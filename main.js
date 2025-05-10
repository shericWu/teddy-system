/* References:
 * - Drawing lines using three.js: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 * - Create 3D model in gltf format: https://www.donmccurdy.com/2023/08/01/generating-gltf/
 */

import * as THREE from 'three'
import cdt2d from "cdt2d";
import { Triangle, Edge, getTriangles } from './triangle.js';

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

const LINE_UNIT_LEN = 0.5;

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
    points.push(new THREE.Vector2(pos.x, pos.y));
    updateLine();
}

function onMouseMove(event) {
    if (!drawing)
        return;
    const pos3 = getMousePosition(event);
    const newPt = new THREE.Vector2(pos3.x, pos3.y);

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
    const cdt_result = getCDT();
    // showCDT(cdt_result);
    const triangles = getTriangles(cdt_result, points);
    showTriangles(triangles);
    console.log(cdt_result);
}

function onMouseUp() {
    if (!drawing)
        return;
    if(!isValid()){
        invalidColor();
        stopDrawing();
        return;
    }
    points.push(new THREE.Vector2(points[0].x, points[0].y));
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

function getCDT() {
    const cdp_points = [];
    const cdp_edges = [];
    let i = 0, n = points.length;
    for (i = 0; i < n - 1; i++) {
        cdp_points.push([points[i].x, points[i].y]);
        if (i > 0)
            cdp_edges.push([i-1, i]);
    }
    cdp_edges.push([i-1, 0]);
    console.log(cdp_points, cdp_edges);
    return cdt2d(cdp_points, cdp_edges, {exterior: false});
}

function showCDT(cdt_result) {
    const positions = [];
    for (const triangle of cdt_result) {
        positions.push(points[triangle[0]].x, points[triangle[0]].y, 0);
        positions.push(points[triangle[1]].x, points[triangle[1]].y, 0);
        positions.push(points[triangle[1]].x, points[triangle[1]].y, 0);
        positions.push(points[triangle[2]].x, points[triangle[2]].y, 0);
        positions.push(points[triangle[2]].x, points[triangle[2]].y, 0);
        positions.push(points[triangle[0]].x, points[triangle[0]].y, 0);
    }
    line_geometry.setAttribute(
        'position',
        new THREE.Float32BufferAttribute(positions, 3)
    );
    line_geometry.setDrawRange(0, positions.length);
    line_geometry.attributes.position.needsUpdate = true;
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
        else{
            const material = new THREE.MeshBasicMaterial({ color: 0x00ffff });
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