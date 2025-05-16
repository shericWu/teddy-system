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
import { ADDITION, SUBTRACTION, INTERSECTION, Brush, Evaluator } from 'three-bvh-csg';
import { mergeVertices } from 'three/examples/jsm/utils/BufferGeometryUtils.js';

/** @type {THREE.Scene} */
export let scene;

/** @type {THREE.PerspectiveCamera} */
let camera;

const cameraDirection = new THREE.Vector3(0, 0, -1);
const cameraRight = new THREE.Vector3(1, 0, 0);
const cameraUp = new THREE.Vector3(0, 1, 0);

/** @type {THREE.WebGLRenderer} */
let renderer;

let drawing = false;

let points = [];

/** @type {THREE.Line} */
let line;
let floor;

/** @type {THREE.BufferGeometry} */
let lineGeometry;
let floorGeometry;

const raycaster = new THREE.Raycaster();
const pointer = new THREE.Vector2();

let meshes = [];
let group = new THREE.Group();
let pivot = new THREE.Group();

let cancel_stack = [];

let selected_meshes = [];

const pressedKeys = new Set();

const LINE_UNIT_LEN = 0.5;

let mouse_event_pos = null;
let rotating_pivot = null;
let current_facing = null;

init();
animate();

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

    // Event listeners
    renderer.domElement.addEventListener('mousedown', onMouseDown);
    renderer.domElement.addEventListener('mousemove', onMouseMove);
    renderer.domElement.addEventListener('mouseup', onMouseUp);
    renderer.domElement.addEventListener('mouseleave', onMouseLeave);
    renderer.domElement.addEventListener('dblclick', onDoubleClick);
    window.addEventListener('resize', onWindowResize);
    document.addEventListener('keydown', onKeyDown);
    document.addEventListener('keyup', onKeyUp);

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
    pointer.x = ((event.clientX - rect.left) / rect.width) * 2 - 1;
    pointer.y = -((event.clientY - rect.top) / rect.height) * 2 + 1;
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
    const material = new THREE.LineBasicMaterial({ color: 0xb7bdf8 });
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
    mouse_event_pos = event;
    const pos3 = getMousePosition(event);
    document.getElementById("mousePos").innerHTML = `(${pos3.x.toFixed(2)}, ${pos3.y.toFixed(2)})`;

    if(pressedKeys.has('control')){
        if(rotating_pivot == null){
            rotating_pivot = [event.clientX, event.clientY];
                current_facing = new THREE.Vector3(pivot.rotation.x, pivot.rotation.y, pivot.rotation.z);

        }

        let rotating_dir = new THREE.Vector2(event.clientX - rotating_pivot[0], event.clientY - rotating_pivot[1]);
        pivot.rotation.set(current_facing.x + rotating_dir.y/100, current_facing.y + rotating_dir.x/100, current_facing.z, 'XYZ');
        return;
    }



    if (!drawing)
        return;

    unselect();

    const newPt = new THREE.Vector3(pos3.x, pos3.y, 0);

    // raycaster.setFromCamera( pointer, camera );
	// const intersects = raycaster.intersectObjects( scene.children );
    // if(intersects.filter((obj) => meshes.includes(obj.object)).length > 0){
    //     invalidColor();
    //     stopDrawing();
    //     return;
    // }

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

function createMeshModel(points){
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

    // const material = //new THREE.MeshPhongMaterial({ color: 0x3366ff, side: THREE.DoubleSide });
    //     new THREE.MeshPhysicalMaterial({
    //     color: 0x3366ff,           // 白色基礎色
    //     transmission: 0.6,         // 傳輸率 = 玻璃的透光度 (1.0 表完全透明)
    //     opacity: 0.6,              // 不透明度 (與 transparent 一起使用)
    //     transparent: true,         // 必須設 true 才能看到透明效果
    //     roughness: 0.1,            // 粗糙度 (0 = 完美光滑)
    //     metalness: 0.0,            // 金屬度 (玻璃為 0)
    //     ior: 2,                  // 折射率 (玻璃常用值在 1.45 - 1.52)
    //     thickness: 0.5,            // 厚度 (用於折射模擬)
    //     side: THREE.DoubleSide     // 如果你有雙面幾何 (像鏡射)，建議使用
    // });
    const material = new THREE.MeshPhongMaterial({color: 0x3366ff});
    // const mesh = new THREE.Mesh(geometry, material);
    const mesh = new Brush(geometry, material);
    geometry.computeBoundsTree();
    mesh.updateWorldMatrix();
    meshes.push(mesh);
    group.attach(mesh);
    group.updateWorldMatrix();
    pivot.updateWorldMatrix();

    scene.remove(line);
}

function onMouseUp() {
    if (!drawing)
        return;
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
    invalidColor();
    stopDrawing();
}

function invalidColor() {
    line.material.color = new THREE.Color(0xff0000);
    line.material.needsUpdate = true;
}

function validColor() {
    line.material.color = new THREE.Color(0xb7bdf8);
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
    if(event.key == 'Control')
        rotating_pivot = null;
    pressedKeys.delete(event.key.toLowerCase());
}

const pos_step = 0.5;

function onKeyDown(event){
    pressedKeys.add(event.key.toLowerCase());

    if(drawing) return;

    scene.remove(line);

    let origin = pivot.worldToLocal(new THREE.Vector3(0, 0, 0));
    let direction = pivot.worldToLocal(cameraDirection.clone()).sub(origin).normalize();
    let right = pivot.worldToLocal(cameraRight.clone()).sub(origin).normalize();
    let up = pivot.worldToLocal(cameraUp.clone()).sub(origin).normalize();

    let floor_normal = (new THREE.Vector3(0, 1, 0));
    let v;
    switch(event.key.toLowerCase()) {
        case 'w':
            v = getProjection(direction, floor_normal).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, pos_step);
            }
            else
                group.position.addScaledVector(v, -pos_step);
            break;
        case 's':
            v = getProjection(direction, floor_normal).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, -pos_step);
            }
            else
                group.position.addScaledVector(v, pos_step);
            break;
        case 'a':
            v = getProjection(right, floor_normal).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, -pos_step);
            }
            else
                group.position.addScaledVector(v, pos_step);
            break;
        case 'd':
            v = getProjection(right, floor_normal).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, pos_step);
            }
            else
                group.position.addScaledVector(v, -pos_step);
            break;
        case 'q':
            v = up.clone().sub(getProjection(up, floor_normal)).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, -pos_step);
            }
            else
                group.position.addScaledVector(v, -pos_step);
            break;
        case 'e':
            v = up.clone().sub(getProjection(up, floor_normal)).normalize();
            if(selected_meshes.length > 0){
                for(let mesh of selected_meshes)
                    mesh.position.addScaledVector(v, pos_step);
            }
            else
                group.position.addScaledVector(v, pos_step);
            break;
        case 'c':
            if(selected_meshes.length > 0){
                unselect();
                break;
            }
            if(pressedKeys.has('shift'))
                uncancelModel();
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
            if(pressedKeys.has('shift'))
                pivot.rotation.set(0,0,0,'XYZ');
            else
                group.position.set(0,0,0);
            break;
        case 'control':
            if(rotating_pivot == null && mouse_event_pos != null){
                rotating_pivot = [mouse_event_pos.clientX, mouse_event_pos.clientY];
                current_facing = new THREE.Vector3(pivot.rotation.x, pivot.rotation.y, pivot.rotation.z);
            }
            break;
        case 'i':
            let show = document.getElementById("infoBox");
            show.style.display = show.style.display === 'none' ? '' : 'none';
            break;
        case 'backspace':
            if (selected_meshes.length >= 1)  {
                difference(selected_meshes[selected_meshes.length - 1]);
            }
            unselect();
            break;
    }
}

function getProjection(v, floor_normal){
    const n = floor_normal.normalize();
    const projected = v.clone().sub(n.clone().multiplyScalar(v.dot(n)));
    return projected;
}

function getCutterBrush(line) {
    // Parameters to control the cutting mesh
    const far_z = -20, near_z = 20, thickness = 0.01;
    
    let cutter_pos = [];
    let cutter_index = [];
    const line_len = line.length;
    for (let i = 0; i < line_len; i++) {
        cutter_pos.push(line[i].x, line[i].y, near_z);
        cutter_pos.push(line[i].x, line[i].y, far_z);
        let prev_dir = null, next_dir = null, dir = null;
        if (i > 0) {
            prev_dir = line[i].clone().sub(line[i-1]);
            prev_dir.set(prev_dir.y, -prev_dir.x).normalize();
        }
        if (i < line_len - 1) {
            next_dir = line[i+1].clone().sub(line[i]);
            next_dir.set(next_dir.y, -next_dir.x).normalize();
        }
        if (prev_dir != null && next_dir != null)
            dir = prev_dir.clone().add(next_dir).normalize();
        else if (prev_dir != null)
            dir = prev_dir.clone();
        else
            dir = next_dir.clone();
        dir.multiplyScalar(thickness);
        const edge = line[i].clone().add(dir);
        cutter_pos.push(edge.x, edge.y, far_z);
        cutter_pos.push(edge.x, edge.y, near_z);
    }
    
    for (let i = 0; i < cutter_pos.length - 4; i += 4) {
        cutter_index.push(i, i+4, i+1);
        cutter_index.push(i+4, i+5, i+1);
        cutter_index.push(i+3, i+2, i+7);
        cutter_index.push(i+2, i+6, i+7);
        cutter_index.push(i, i+3, i+4);
        cutter_index.push(i+3, i+7, i+4);
        cutter_index.push(i+1, i+5, i+2);
        cutter_index.push(i+5, i+6, i+2);
    }
    cutter_index.push(0, 1, 3);
    cutter_index.push(1, 2, 3);
    const last_i = cutter_pos.length - 4;
    cutter_index.push(last_i + 0, last_i + 3, last_i + 1);
    cutter_index.push(last_i + 3, last_i + 2, last_i + 1);
    
    const cutter_geo = new THREE.BufferGeometry();
    cutter_geo.setAttribute('position', new THREE.BufferAttribute(new Float32Array(cutter_pos), 3));
    cutter_geo.setIndex(new THREE.BufferAttribute(new Uint32Array(cutter_index), 1));
    cutter_geo.computeVertexNormals();
    const cutter_material = new THREE.MeshPhysicalMaterial({
        color: 0xffffff, opacity: 0.0, transparent: true, side: THREE.DoubleSide
    });
    const cutterBrush = new Brush(cutter_geo, cutter_material);
    cutter_geo.computeBoundsTree();
    cutterBrush.updateWorldMatrix();
    return cutterBrush;
}

function splitMesh(position, index, original_material) {
    const parent_len = position.length / 3;
    let parent = new Int32Array(parent_len).fill(-1);
    
    function find(i) {
        if (i >= parent_len) {
            console.log("error:", i, parent_len);
        }
        let trajectory = [];
        while (parent[i] >= 0) {
            trajectory.push(i);
            i = parent[i];
        }
        for (let idx of trajectory) {
            parent[idx] = i;
        }
        return i;
    }

    function merge(i, j) {
        let r1 = find(i);
        let r2 = find(j);
        if (r1 == r2)
            return;
        let sum = parent[r1] + parent[r2];
        if (parent[r1] < parent[r2]) {
            parent[r2] = r1;
            parent[r1] = sum;
        }
        else {
            parent[r1] = r2;
            parent[r2] = sum;
        }
    }

    function getRoots() {
        let roots = [];
        for (let i = 0; i < parent_len; i++) {
            let r = find(i);
            if (roots.indexOf(r) === -1)
                roots.push(r);
        }
        console.log("roots before:", roots);
        return roots;
    }

    const index_len = index.length;
    for (let i = 0; i < index_len; i += 3) {
        merge(index[i], index[i+1])
        merge(index[i+1], index[i+2])
        merge(index[i+2], index[i])
    }
    let roots = getRoots();
    console.log("roots after", roots);
    let ret = [];
    for (let i = 0; i < roots.length; i++) {
        ret.push([new Float32Array(position), []])
    }
    for (let i = 0; i < index_len; i += 3) {
        let temp = roots.indexOf(find(index[i]));
        for (let j = 0; j < 3; j++) {
            let root_idx = roots.indexOf(find(index[i + j]));
            if (root_idx != temp || root_idx == -1) {
                console.log("bad:", temp, root_idx);
            }
            ret[root_idx][1].push(index[i + j]);
        }
    }
    let splitted = [];
    for (let i = 0; i < roots.length; i++) {
        const geometry = new THREE.BufferGeometry();
        geometry.setAttribute('position', new THREE.BufferAttribute(ret[i][0], 3));
        geometry.setIndex(new THREE.BufferAttribute(new Uint32Array(ret[i][1]), 1));
        geometry.computeVertexNormals();
        const mesh = new Brush(geometry, original_material.clone());
        geometry.computeBoundsTree();
        mesh.updateWorldMatrix();
        splitted.push(mesh);
    }
    return splitted;
}

function difference(mesh) {
    const line = [
        new THREE.Vector2(-0.5, -7),
        new THREE.Vector2( 0.5, -6),
        new THREE.Vector2(-0.5, -5),
        new THREE.Vector2( 0.5, -4),
        new THREE.Vector2(-0.5, -3),
        new THREE.Vector2( 0.5, -2),
        new THREE.Vector2(-0.5, -1),
        new THREE.Vector2( 0.5,  0),
        new THREE.Vector2(-0.5,  1),
        new THREE.Vector2( 0.5,  2),
        new THREE.Vector2(-0.5,  3),
        new THREE.Vector2( 0.5,  4),
        new THREE.Vector2(-0.5,  5),
        new THREE.Vector2( 0.5,  6),
        new THREE.Vector2(-0.5,  7),
    ]
    
    let cutterBrush = getCutterBrush(line);
    group.remove(mesh);
    meshes.splice(meshes.indexOf(mesh), 1);
    selected_meshes.splice(selected_meshes.indexOf(mesh), 1);
    const evaluator = new Evaluator();
    evaluator.attributes = ['position'];  // * Ignore normal so mergeVertices can merge the "skin"
    let original_material = mesh.material;
    let remain = evaluator.evaluate(mesh, cutterBrush, SUBTRACTION);
    // let cut_plane = evaluator.evaluate(mesh, cutterBrush, INTERSECTION);
    let result_geo = remain.geometry;
    let merged_geo = mergeVertices(result_geo);
    remain.material = original_material;
    // cut_plane.material = original_material;

    let splitted = splitMesh(
        merged_geo.attributes.position.array,
        merged_geo.getIndex().array,
        original_material
    );
    for (let mesh of splitted) {
        group.attach(mesh);
        meshes.push(mesh);
        selected_meshes.push(mesh);
    }
}

function union_v2(mesh1, mesh2) {

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
    new_mesh.material = original_material.clone();

    new_mesh.geometry.computeBoundsTree();
    new_mesh.updateWorldMatrix();

    group.attach(new_mesh);
    group.updateWorldMatrix();
    pivot.updateWorldMatrix();
    meshes.push(new_mesh);
    selected_meshes.push(new_mesh);
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
            mesh.material.color.set(0x3366ff);
        }
        else
            select(mesh);
        break;
    }
}

function select(mesh){
    selected_meshes.push(mesh);
    mesh.material.color.set(0xff0000);
}

function unselect(){
    if(selected_meshes.length == 0)
        return;
    for(let mesh of selected_meshes)
        mesh.material.color.set(0x3366ff);
    selected_meshes = [];
}

function animate() {
    requestAnimationFrame(animate);
    renderer.render(scene, camera);
}
