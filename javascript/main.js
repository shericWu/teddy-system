/* References:
 * - Drawing lines using three.js: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 * - Create 3D model in gltf format: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 */

import * as THREE from 'three';
import { Triangle, Edge, getTriangles } from './triangle.js';
import { pruneTriangles } from './pruning.js';
import { getCDT, showCDT } from './cdt.js';
import { triangulate, Point } from './triangulation.js';
import { inflate } from './inflation.js';
import { showTriangles } from './show.js';
// import { CSG } from 'three-csg-ts';
import {
	computeBoundsTree, disposeBoundsTree,
	computeBatchedBoundsTree, disposeBatchedBoundsTree,
    acceleratedRaycast,
} from 'three-mesh-bvh';
import { ADDITION, SUBTRACTION, Brush, Evaluator } from 'three-bvh-csg';
import { timerDelta } from 'three/tsl';

/** @type {THREE.Scene} */
export let scene;

/** @type {THREE.PerspectiveCamera} */
let camera;

const cameraDirection = new THREE.Vector3(0, 0, -1);
const cameraRight = new THREE.Vector3(1, 0, 0);
const cameraUp = new THREE.Vector3(0, 1, 0);

/** @type {THREE.WebGLRenderer} */
let renderer;

let canvas;

let drawing = false;
let view_mode = false;

let cutting_mode = false;
let cutting_curve = [];

let points = [];

/** @type {THREE.Line} */
let line;
let floor;

/** @type {THREE.BufferGeometry} */
let lineGeometry;
let floorGeometry;

const mesh_color = 0x3366ff;
const selected_mesh_color = 0xff0000;
const drawing_line_color = 0xb7bdf8;
const invalid_drawing_line_color = 0xff0000;

const raycaster = new THREE.Raycaster();
const pointer = new THREE.Vector2();

let meshes = [];
let group = new THREE.Group();
let pivot = new THREE.Group();

let cancel_stack = [];

let selected_meshes = [];

const pressedKeys = new Set();

const LINE_UNIT_LEN = 0.5;

let lastTime = 0;

init();
requestAnimationFrame(animate);

function init() {
    init_bvh();
    // Scene and camera
    scene = new THREE.Scene();
    camera = new THREE.PerspectiveCamera(
        75,
        window.innerWidth / window.innerHeight,
        0.1,
        1000
    );
    camera.position.set(0, 0, 10);

    // Renderer
    renderer = new THREE.WebGLRenderer({ antialias: true });
    renderer.setSize(window.innerWidth, window.innerHeight);
    document.body.appendChild(renderer.domElement);
    renderer.domElement.id = "canvas";

    canvas = document.getElementById('canvas');

    // Event listeners
    renderer.domElement.addEventListener('mousedown', onMouseDown);
    renderer.domElement.addEventListener('mousemove', onMouseMove);
    renderer.domElement.addEventListener('mouseup', onMouseUp);
    renderer.domElement.addEventListener('mouseleave', onMouseLeave);
    renderer.domElement.addEventListener('dblclick', onDoubleClick);
    window.addEventListener('resize', onWindowResize);
    document.addEventListener('keydown', onKeyDown);
    document.addEventListener('keyup', onKeyUp);
    document.addEventListener('pointerlockchange', onLockChange);

    let ambientLight = new THREE.AmbientLight('#0c0c0c')
    scene.add(ambientLight)

    let directionalLight = new THREE.DirectionalLight(0xffffff, 3);
    directionalLight.position.set(1, 1, 3);
    scene.add(directionalLight);

    const checkerboardTexture = createCheckerboardTexture();
    const floorMaterial = new THREE.MeshStandardMaterial({
        map: checkerboardTexture,
        side: THREE.DoubleSide
    });

    floorGeometry = new THREE.PlaneGeometry(100, 100);
    floor = new THREE.Mesh(floorGeometry, floorMaterial);
    floorGeometry.computeBoundsTree();
    floor.rotation.x = -Math.PI / 2;
    floor.receiveShadow = true;
    floor.position.set(0, -5, 0);
    group.add(floor);
    group.updateWorldMatrix();

    pivot.add(group);
    pivot.position.set(0, 0, 10);
    pivot.updateWorldMatrix();
    scene.add(pivot);
}

function init_bvh() {
    THREE.BufferGeometry.prototype.computeBoundsTree = computeBoundsTree;
    THREE.BufferGeometry.prototype.disposeBoundsTree = disposeBoundsTree;
    THREE.Mesh.prototype.raycast = acceleratedRaycast;
    THREE.BatchedMesh.prototype.computeBoundsTree = computeBatchedBoundsTree;
    THREE.BatchedMesh.prototype.disposeBoundsTree = disposeBatchedBoundsTree;
    THREE.BatchedMesh.prototype.raycast = acceleratedRaycast;
    raycaster.firstHitOnly = true;
}

function createCheckerboardTexture(size = 512, squares = 8) {
    const canvas = document.createElement('canvas');
    canvas.width = canvas.height = size;
    const ctx = canvas.getContext('2d');

    const squareSize = size / squares;

    for (let y = 0; y < squares; y++) {
        for (let x = 0; x < squares; x++) {
            ctx.fillStyle = (x + y) % 2 === 0 ? '#ffffff' : '#000000';
            ctx.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
        }
    }

    const texture = new THREE.CanvasTexture(canvas);
    texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
    texture.repeat.set(10, 10);
    return texture;
}

function getMousePosition(event) {
    const rect = renderer.domElement.getBoundingClientRect();
    /*
     * Origin: center
     * x (left to right): -1 ~ 1
     * y (top to bottom): -1 ~ 1
     */
    pointer.x = (view_mode)? 0 : ((event.clientX - rect.left) / rect.width) * 2 - 1;
    pointer.y = (view_mode)? 0 : -((event.clientY - rect.top) / rect.height) * 2 + 1;
    const vec = new THREE.Vector3(pointer.x, pointer.y, 0.5);
    vec.unproject(camera);
    const dir = vec.sub(camera.position).normalize();
    const distance = -camera.position.z / dir.z;
    return camera.position.clone().add(dir.multiplyScalar(distance));
}

function onMouseDown(event) {
    scene.remove(line);

    // Line geometry and material
    lineGeometry = new THREE.BufferGeometry();
    const material = new THREE.LineBasicMaterial({ color: drawing_line_color });
    // lineGeometry.computeBoundsTree();
    line = new THREE.LineSegments(lineGeometry, material);
    scene.add(line);

    drawing = true;
    points = [];
    validColor();
    const pos = getMousePosition(event);
    points.push(new THREE.Vector3(pos.x, pos.y, 0));
    updateLine();

}

function onMouseMove(event) {
    const pos3 = getMousePosition(event);
    document.getElementById("mousePos").innerHTML = `(${pos3.x.toFixed(2)}, ${pos3.y.toFixed(2)})`;

    if (!drawing){
        if(pressedKeys.has('control')){
            let moveX = event.movementX, moveY = event.movementY;
            if(pivot.rotation.x + moveY / 100 >= 1.4)
                moveY = (1.4 - pivot.rotation.x) * 100;
            if(pivot.rotation.x + moveY / 100 <= -1.4)
                moveY = (-1.4 - pivot.rotation.x) * 100;
            pivot.rotation.x += moveY / 100;
            pivot.rotation.y += moveX / 100;
        }
        return;
    }

    const newPt = new THREE.Vector3(pos3.x, pos3.y, 0);

    raycaster.setFromCamera( pointer, camera );
	const intersects = raycaster.intersectObjects( scene.children ).filter((obj) => meshes.includes(obj.object));
    if(intersects.length > 0){
        if(intersects[0].object == selected_meshes[selected_meshes.length - 1])
            cutting_mode = true;
        else{
            unselect();
            invalidColor();
            stopDrawing();
            return;
        }
    }

    // Check distance and self-intersection
    const len = points.length;
    if (len >= 1) {
        const a1 = points[len - 1];
        const a2 = newPt;

        if (a2.distanceTo(a1) < LINE_UNIT_LEN) {
            return;
        }

        for (let i = 0; i < len - 2; i++) {
            const b1 = points[i];
            const b2 = points[i + 1];
            if (segmentsIntersect(a1, a2, b1, b2)) {
                unselect();
                invalidColor();
                stopDrawing();
                return;
            }
        }
    }

    points.push(newPt);
    updateLine();
}

function isValid() {
    if(points.length <= 3) {
        return false;
    }
    const end_length = points[points.length - 1].distanceTo(points[0]);
    if (end_length > 3 * LINE_UNIT_LEN) {
        return false;
    }
    return true;
}


function translateToMidPoint(points){
    let mid = new THREE.Vector2(0,0);
    for(let p of points){
        mid.x += p.x;
        mid.y += p.y;
    }
    mid.x /= points.length;
    mid.y /= points.length;

    for(let p of points){
        p.x -= mid.x;
        p.y -= mid.y;
    }
    return [mid, points];

}

function createMeshModel(points){
    let mid_points = null;
    [mid_points, points] = translateToMidPoint(points);

    const cdt_result = getCDT(points);
    var triangles = getTriangles(cdt_result, points);
    triangles = pruneTriangles(triangles);
    // group.attach(showTriangles(triangles));
    var spine, triangulation;
    [spine, triangulation] = triangulate(triangles);
    let geometry_positions, geometry_faces;
    [geometry_positions, geometry_faces] = inflate(triangulation, spine);

    const geometry = new THREE.BufferGeometry();

    geometry.setAttribute('position', new THREE.BufferAttribute( new Float32Array(geometry_positions), 3));
    geometry.setIndex(new THREE.BufferAttribute(new Uint32Array(geometry_faces), 1));

    geometry.computeVertexNormals();

    const material = //new THREE.MeshPhongMaterial({ color: 0x3366ff, side: THREE.DoubleSide });
        new THREE.MeshPhysicalMaterial({
        color: mesh_color,           // 白色基礎色
        transmission: 0.6,         // 傳輸率 = 玻璃的透光度 (1.0 表完全透明)
        opacity: 0.6,              // 不透明度 (與 transparent 一起使用)
        transparent: true,         // 必須設 true 才能看到透明效果
        roughness: 0.1,            // 粗糙度 (0 = 完美光滑)
        metalness: 0.0,            // 金屬度 (玻璃為 0)
        ior: 2,                  // 折射率 (玻璃常用值在 1.45 - 1.52)
        thickness: 0.5,            // 厚度 (用於折射模擬)
        side: THREE.DoubleSide     // 如果你有雙面幾何 (像鏡射)，建議使用
    });
    // const material = new THREE.MeshNormalMaterial({color: 0x3366ff});
    // const mesh = new THREE.Mesh(geometry, material);
    const mesh = new Brush(geometry, material);
    mesh.position.set(mid_points.x, mid_points.y, 0);
    geometry.computeBoundsTree();
    mesh.updateWorldMatrix();
    meshes.push(mesh);
    group.attach(mesh);
    group.updateWorldMatrix();
    pivot.updateWorldMatrix();

    scene.remove(line);
}

function onLockChange(){
    unselect();
    if (document.pointerLockElement === canvas) {
        view_mode = true;
        document.getElementById("mousePos").innerHTML = `View Mode`;
        document.getElementById("crosshair").style.display = 'block';
        renderer.domElement.removeEventListener('mousemove', onMouseMove);
        renderer.domElement.removeEventListener('mousemove', view_control);
        renderer.domElement.addEventListener('mousemove', view_control);
    } else {
        view_mode = false;
        document.getElementById("crosshair").style.display = 'none';
        renderer.domElement.removeEventListener('mousemove', view_control);
        renderer.domElement.removeEventListener('mousemove', onMouseMove);
        renderer.domElement.addEventListener('mousemove', onMouseMove);
    }
}

function view_control(event){
    let moveX = event.movementX, moveY = event.movementY;
    if(pivot.rotation.x + moveY / 100 >= 1.4)
        moveY = (1.4 - pivot.rotation.x) * 100;
    if(pivot.rotation.x + moveY / 100 <= -1.4)
        moveY = (-1.4 - pivot.rotation.x) * 100;
    pivot.rotation.x += moveY / 100;
    pivot.rotation.y += moveX / 100;
    return;
}

function onMouseUp() {
    if (!drawing)
        return;
    if(cutting_mode){
        updateLine();
        stopDrawing();

        cutting_curve = [];
        for(let point of points){
            cutting_curve.push(new THREE.Vector2(point.x, point.y));
        }
        // console.log(cutting_curve);
        cutting();
        scene.remove(line);
        unselect();
        return;
    }
    unselect();
    if(!isValid()){
        invalidColor();
        stopDrawing();
        return;
    }
    points.push(new THREE.Vector3(points[0].x, points[0].y, 0));
    updateLine();
    stopDrawing();
    createMeshModel(points);
}

function onMouseLeave() {
    if (!drawing)
        return;
    unselect();
    invalidColor();
    stopDrawing();
}

function invalidColor() {
    line.material.color = new THREE.Color(invalid_drawing_line_color);
    line.material.needsUpdate = true;
}

function validColor() {
    line.material.color = new THREE.Color(drawing_line_color);
    line.material.needsUpdate = true;
}


function stopDrawing() {
    drawing = false;
}

function updateLine() {
    const positions = [];
    for (let i = 0; i < points.length - 1; i++) {
        positions.push(points[i].x, points[i].y, 0);
        positions.push(points[i + 1].x, points[i + 1].y, 0);
    }
    lineGeometry.setAttribute(
        'position',
        new THREE.Float32BufferAttribute(positions, 3)
    );
    lineGeometry.setDrawRange(0, positions.length);
    lineGeometry.attributes.position.needsUpdate = true;
}

// Line segment intersection test in 2D
function segmentsIntersect(p1, p2, p3, p4) {
    function orient(a, b, c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }
    const o1 = orient(p1, p2, p3);
    const o2 = orient(p1, p2, p4);
    const o3 = orient(p3, p4, p1);
    const o4 = orient(p3, p4, p2);
    if (o1 * o2 < 0 && o3 * o4 < 0)
        return true;
    return false;
}

function onWindowResize() {
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    renderer.setSize(window.innerWidth, window.innerHeight);
}

function onKeyUp(event) {
    pressedKeys.delete(event.key.toLowerCase());
}

function onKeyDown(event){
    pressedKeys.add(event.key.toLowerCase());

    if(drawing) return;

    scene.remove(line);

    switch(event.key.toLowerCase()) {
        case 'w': case 's': case 'a': case 'd': case 'q': case 'e': case 'space': case 'shift':
            if(pressedKeys.has('control')) event.preventDefault();
            break;
        case 'c':
            if(selected_meshes.length > 0){
                unselect();
                break;
            }
            if(pressedKeys.has('control')){
                event.preventDefault();
                uncancelModel();
            }
            else
                cancelModel();
            break;
        case 'enter':
            unselect();
            break;
        case 'u':
            let len = selected_meshes.length;
            if(len >= 2)
                // union(selected_meshes[len - 1], selected_meshes[len - 2]);
                union_v2(selected_meshes[len - 1], selected_meshes[len - 2]);
            unselect();
            break;
        case 'o':
            unselect();
            if(pressedKeys.has('control')){
                event.preventDefault();
                pivot.rotation.set(0,0,0,'XYZ');
            }
            else
                group.position.set(0,0,0);
            break;
        case 'f':
            if(view_mode){
                document.exitPointerLock();
            }
            else{
                unselect();
                canvas.requestPointerLock();
            }
            break;
        case 'i':
            let infoBox = document.getElementById("infoBox");
            infoBox.style.display = infoBox.style.display === 'none' ? '' : 'none';
            break;

    }
}

function getProjection(v, floor_normal){
    const n = floor_normal.normalize();
    const projected = v.clone().sub(n.clone().multiplyScalar(v.dot(n)));
    return projected;
}

// import { mergeVertices } from 'three/examples/jsm/utils/BufferGeometryUtils.js';

// function union(mesh1, mesh2){
//     mesh1.geometry = mergeVertices(mesh1.geometry, 1e-5);
//     mesh2.geometry = mergeVertices(mesh2.geometry, 1e-5);

//     let new_mesh = CSG.union(mesh1, mesh2);
//     new_mesh.geometry = mergeVertices(new_mesh.geometry, 1e-5);

//     if(new_mesh.geometry.attributes.position.count == 0)
//         return;

//     console.log(new_mesh);

//     group.remove(mesh1);
//     group.remove(mesh2);
//     meshes.splice(meshes.indexOf(mesh1), 1);
//     meshes.splice(meshes.indexOf(mesh2), 1);
//     selected_meshes.splice(selected_meshes.indexOf(mesh1), 1);
//     selected_meshes.splice(selected_meshes.indexOf(mesh2), 1);
//     group.add(new_mesh);
//     meshes.push(new_mesh);
//     selected_meshes.push(new_mesh);
// }

function union_v2(mesh1, mesh2) {
    // console.log(mesh1.position);
    // console.log(mesh2.position);

    group.remove(mesh1);
    group.remove(mesh2);
    meshes.splice(meshes.indexOf(mesh1), 1);
    meshes.splice(meshes.indexOf(mesh2), 1);
    selected_meshes.splice(selected_meshes.indexOf(mesh1), 1);
    selected_meshes.splice(selected_meshes.indexOf(mesh2), 1);

    let evaluator = new Evaluator();
    evaluator.attributes = ['position', 'normal'];
    let original_material = mesh1.material;
    let new_mesh = evaluator.evaluate(mesh1, mesh2, ADDITION);
    new_mesh.material = original_material;

    new_mesh.geometry.computeBoundsTree();
    new_mesh.updateWorldMatrix();

    group.attach(new_mesh);
    group.updateWorldMatrix();
    pivot.updateWorldMatrix();
    meshes.push(new_mesh);
    selected_meshes.push(new_mesh);

    // console.log(new_mesh.position);
}

function uncancelModel(){
    if(cancel_stack.length == 0)
        return;

    let uncancel = cancel_stack[cancel_stack.length - 1];
    meshes.push(uncancel);
    group.add(uncancel);
    cancel_stack.splice(cancel_stack.length - 1, 1);
}

function cancelModel(){
    raycaster.setFromCamera( pointer, camera );
	const intersects = raycaster.intersectObjects( scene.children );
    let i = 0;
    while(intersects.length > i && meshes.includes(intersects[i].object)){
        if(!intersects[i].object.visible){
            i++;
            continue;
        }
        let toCancel = intersects[i].object;
        cancel_stack.push(toCancel);
        meshes.splice(meshes.indexOf(toCancel), 1);
        group.remove(toCancel);
        break;
    }
}

function onDoubleClick(){
    if(drawing)
        return;

    raycaster.setFromCamera( pointer, camera );
	const intersects = raycaster.intersectObjects( scene.children );
    let i = 0;
    while(intersects.length > i && meshes.includes(intersects[i].object)){
        if(!intersects[i].object.visible){
            i++;
            continue;
        }
        let mesh = intersects[i].object;
        if(selected_meshes.includes(mesh)){
            selected_meshes.splice(selected_meshes.indexOf(mesh), 1);
            mesh.material.color.set(mesh_color);
        }
        else
            select(mesh);
        break;
    }
}

function select(mesh){
    selected_meshes.push(mesh);
    mesh.material.color.set(selected_mesh_color);
}

function unselect(){
    if(selected_meshes.length == 0)
        return;
    for(let mesh of selected_meshes)
        mesh.material.color.set(mesh_color);
    selected_meshes = [];
}

const pos_step = 20;
const rot_step = 5;

function animate(currentTime) {
    if (!lastTime) lastTime = currentTime;

    const deltaTime = (currentTime - lastTime) / 1000;
    lastTime = currentTime;


    let origin = pivot.worldToLocal(new THREE.Vector3(0, 0, 0));
    let direction = pivot.worldToLocal(cameraDirection.clone()).sub(origin).normalize();
    let right = pivot.worldToLocal(cameraRight.clone()).sub(origin).normalize();
    let up = pivot.worldToLocal(cameraUp.clone()).sub(origin).normalize();

    let floor_normal = (new THREE.Vector3(0, 1, 0));
    let v;

    if(pressedKeys.has('w')){
        v = getProjection(direction, floor_normal).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.x -= rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, pos_step * deltaTime);

            }
        }
        else
        group.position.addScaledVector(v, -pos_step * deltaTime);
    }
    else if(pressedKeys.has('s')){
        v = getProjection(direction, floor_normal).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.x += rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, -pos_step * deltaTime);
            }
        }
        else
        group.position.addScaledVector(v, pos_step * deltaTime);

    }
    if(pressedKeys.has('a')){
        v = getProjection(right, floor_normal).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.y -= rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, -pos_step * deltaTime);
            }
        }
        else
        group.position.addScaledVector(v, pos_step * deltaTime);

    }
    else if(pressedKeys.has('d')){
        v = getProjection(right, floor_normal).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.y += rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, pos_step * deltaTime);
            }
        }
        else
        group.position.addScaledVector(v, -pos_step * deltaTime);

    }
    if(pressedKeys.has('q') || pressedKeys.has(' ')){
        v = up.clone().sub(getProjection(up, floor_normal)).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.z += rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, pos_step * deltaTime);
            }
        }
        else
        group.position.addScaledVector(v, -pos_step * deltaTime);
    }
    else if(pressedKeys.has('e') || pressedKeys.has('shift')){
        v = up.clone().sub(getProjection(up, floor_normal)).normalize();
        if(selected_meshes.length > 0){
            for(let mesh of selected_meshes){
                if(pressedKeys.has('r')){
                    mesh.rotation.z -= rot_step * deltaTime;
                }
                else mesh.position.addScaledVector(v, -pos_step * deltaTime);
            }
        }
        else
        group.position.addScaledVector(v, pos_step * deltaTime);
    }

    renderer.render(scene, camera);
    requestAnimationFrame(animate);
}
