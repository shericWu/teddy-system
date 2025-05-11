/* References:
 * - Drawing lines using three.js: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 * - Create 3D model in gltf format: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 */

import * as THREE from 'three'
import { Triangle, Edge, getTriangles } from './triangle.js';
import { pruneTriangles } from './pruning.js';
import { getCDT, showCDT } from './cdt.js';
import { triangulate, Point } from './triangulation.js';

/** @type {THREE.Scene} */
let scene;

/** @type {THREE.PerspectiveCamera} */
let camera;

/** @type {THREE.WebGLRenderer} */
let renderer;

let drawing = false;

let points = [];

/** @type {THREE.Line} */
let line;

/** @type {THREE.BufferGeometry} */
let line_geometry;

const LINE_UNIT_LEN = 1;

init();
animate();

function init() {
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

    // // Line geometry and material
    // line_geometry = new THREE.BufferGeometry();
    // const material = new THREE.LineBasicMaterial({ color: 0xb7bdf8 });
    // line = new THREE.LineSegments(line_geometry, material);
    // scene.add(line);

    // Event listeners
    renderer.domElement.addEventListener('mousedown', onMouseDown);
    renderer.domElement.addEventListener('mousemove', onMouseMove);
    renderer.domElement.addEventListener('mouseup', onMouseUp);
    renderer.domElement.addEventListener('mouseleave', onMouseLeave);
    window.addEventListener('resize', onWindowResize);
}

function getMousePosition(event) {
    const rect = renderer.domElement.getBoundingClientRect();
    /*
     * Origin: center
     * x (left to right): -1 ~ 1
     * y (top to bottom): -1 ~ 1
     */
    const x = ((event.clientX - rect.left) / rect.width) * 2 - 1;
    const y = -((event.clientY - rect.top) / rect.height) * 2 + 1;
    const vec = new THREE.Vector3(x, y, 0.5);
    vec.unproject(camera);
    const dir = vec.sub(camera.position).normalize();
    const distance = -camera.position.z / dir.z;
    return camera.position.clone().add(dir.multiplyScalar(distance));
}

function onMouseDown(event) {
    while(scene.children.length > 0){
        scene.remove(scene.children[0]);
    }

    // Line geometry and material
    line_geometry = new THREE.BufferGeometry();
    const material = new THREE.LineBasicMaterial({ color: 0xb7bdf8 });
    line = new THREE.LineSegments(line_geometry, material);
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
    if (!drawing)
        return;
    const newPt = new THREE.Vector3(pos3.x, pos3.y, 0);

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
    // showCDT(cdt_result);
    var triangles = getTriangles(cdt_result, points);
    // showTriangles(triangles);
    triangles = pruneTriangles(triangles);
    showTriangles(triangles);
    var spine, triangulation;
    [spine, triangulation] = triangulate(triangles);
    console.log(triangulation);
    showTriangles(triangulation);
    showSpine(spine);
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

function showSpine(spine){
    let spine_geometry = new THREE.BufferGeometry();
    let vertices = [];
    for (let edge of spine) {
        vertices.push(edge.p1.x, edge.p1.y, 0);
        vertices.push(edge.p2.x, edge.p2.y, 0);
    }
    spine_geometry.setAttribute('position', new THREE.Float32BufferAttribute(vertices, 3));
    const material = new THREE.LineBasicMaterial({ color: 0x4545ff });
    const line = new THREE.LineSegments(spine_geometry, material);
    scene.add(line);
}

function showTriangles(triangles) {
    for (const triangle of triangles) {
        const positions = [];
        for (const point of triangle.points) {
            positions.push(point.x, point.y, 0);
        }
        const geometry = new THREE.BufferGeometry();
        geometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        
        console.log("type" + triangle.type);
        if (triangle.type === 'terminal') {
            const material = new THREE.MeshBasicMaterial({ color: 0x0000ff });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
        }
        else if (triangle.type === 'sleeve') {
            const material = new THREE.MeshBasicMaterial({ color: 0xff0000 });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
        }
        else if (triangle.type === 'junction') {
            const material = new THREE.MeshBasicMaterial({ color: 0x00ffff });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
        }
        else{
            //console.log("draw", triangle.points[0], triangle.points[1], triangle.points[2]);
            console.log(positions)
            const material = new THREE.MeshBasicMaterial({ color: 0x005520 });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
        }

        // draw the triangle's edges
        const lineMaterial = new THREE.LineBasicMaterial({ color: 0x000000 });
        const lineGeometry = new THREE.BufferGeometry();
        lineGeometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        const line = new THREE.Line(lineGeometry, lineMaterial);
        scene.add(line);
    }
    /*
    for (const triangle of triangles) {
        const positions = [];
        for (const point of triangle.points) {
            positions.push(point.x, point.y, 0);
        }
        const geometry = new THREE.BufferGeometry();
        geometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        if (triangle.type === 'fan') {
            const material = new THREE.MeshBasicMaterial({ color: 0x00ff00 });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
        }
        else{
            continue;
        }
        // draw the triangle's edges
        const lineMaterial = new THREE.LineBasicMaterial({ color: 0x000000 });
        const lineGeometry = new THREE.BufferGeometry();
        lineGeometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        const line = new THREE.Line(lineGeometry, lineMaterial);
        scene.add(line);
    }
    */
}

function updateLine() {
    const positions = [];
    // points.forEach(p => { positions.push(p.x, p.y, 0); });
    for (let i = 0; i < points.length - 1; i++) {
        positions.push(points[i].x, points[i].y, 0);
        positions.push(points[i + 1].x, points[i + 1].y, 0);
    }
    line_geometry.setAttribute(
        'position',
        new THREE.Float32BufferAttribute(positions, 3)
    );
    line_geometry.setDrawRange(0, positions.length);
    line_geometry.attributes.position.needsUpdate = true;
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

function animate() {
    requestAnimationFrame(animate);
    renderer.render(scene, camera);
}