import * as THREE from 'three'
import { scene } from "./main.js";

function showSpine(spine){
    let spine_geometry = new THREE.BufferGeometry();
    let vertices = [];
    for (let edge of spine) {
        vertices.push(edge.p1.x, edge.p1.y, edge.p1.z ?? 0);
        vertices.push(edge.p2.x, edge.p2.y, edge.p2.z ?? 0);
    }
    spine_geometry.setAttribute('position', new THREE.Float32BufferAttribute(vertices, 3));
    const material = new THREE.LineBasicMaterial({ color: 0xff0000 });
    const line = new THREE.LineSegments(spine_geometry, material);
    scene.add(line);
}

export function showTriangles(triangles) {
    let group = new THREE.Group();
    for (const triangle of triangles) {
        const positions = [];
        for (const point of triangle.points) {
            positions.push(point.x, point.y, point.z ?? 0);
        }
        const geometry = new THREE.BufferGeometry();
        geometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        if (triangle.type === 'terminal') {
            const material = new THREE.MeshBasicMaterial({ color: 0x0000ff, side: THREE.DoubleSide });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
            group.add(mesh);
        }
        else if (triangle.type === 'sleeve') {
            const material = new THREE.MeshBasicMaterial({ color: 0xff0000, side: THREE.DoubleSide });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
            group.add(mesh);
        }
        else if (triangle.type === 'junction') {
            const material = new THREE.MeshBasicMaterial({ color: 0x00ffff, side: THREE.DoubleSide });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
            group.add(mesh);
        }
        else{
            const material = new THREE.MeshBasicMaterial({ color: 0x005520, side: THREE.DoubleSide });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
            group.add(mesh);
        }

        // draw the triangle's edges
        const lineMaterial = new THREE.LineBasicMaterial({ color: 0xffffff });
        const lineGeometry = new THREE.BufferGeometry();
        lineGeometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        // console.log("positions = ", positions);
        const line = new THREE.LineLoop(lineGeometry, lineMaterial);
        scene.add(line);
        group.add(line);
    }
    for (const triangle of triangles) {
        const positions = [];
        for (const point of triangle.points) {
            positions.push(point.x, point.y, point.z ?? 0);
        }
        const geometry = new THREE.BufferGeometry();
        geometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        if (triangle.type === 'fan') {
            const material = new THREE.MeshBasicMaterial({ color: 0x00ff00, side: THREE.DoubleSide });
            const mesh = new THREE.Mesh(geometry, material);
            scene.add(mesh);
            group.add(mesh);
        }
        else{
            continue;
        }
        // draw the triangle's edges
        const lineMaterial = new THREE.LineBasicMaterial({ color: 0xffffff });
        const lineGeometry = new THREE.BufferGeometry();
        lineGeometry.setAttribute(
            'position',
            new THREE.Float32BufferAttribute(positions, 3)
        );
        const line = new THREE.LineLoop(lineGeometry, lineMaterial);
        scene.add(line);
        group.add(line);
    }
    return group;
}