import * as THREE from 'three';
import { Point } from "./triangulation.js";
import { Triangle, Edge } from './triangle.js';
import { junction_centers } from './pruning.js';

const ELEVATE_CONSTANT = 1;
const NUM_SAMPLE = 5;

var geometry_positions = [], geometry_faces = [];
var point_map = new Map();
var id_count = 0;

export function inflate(triangles, spine_edges){
    elevate_spine(spine_edges);

    let sampled_points = oval_sample(triangles);
    sew_edges(triangles, sampled_points);

    return [geometry_positions, geometry_faces];
}

    
function sew_edges(triangles, sampled_points){
    geometry_positions = [], geometry_faces = [];
    point_map = new Map();
    id_count = 0;
    for (let triangle of triangles){
        let edge, edge1, edge2;
        for (let i = 0; i < triangle.edges.length; i++){
            edge = triangle.edges[i];
            if(edge.type == 'external' || edge.type == 'spine'){
                edge1 = triangle.edges[(i + 1) % 3];
                edge2 = triangle.edges[(i + 2) % 3];
                break;
            }
        }
        let key1 = `${edge1.p1.x},${edge1.p1.y}|${edge1.p2.x},${edge1.p2.y}`;
        let key2 = `${edge2.p1.x},${edge2.p1.y}|${edge2.p2.x},${edge2.p2.y}`;
        let sampled_points1 = Array.from(sampled_points.get(key1));
        let sampled_points2 = Array.from(sampled_points.get(key2));
        if (edge.type === 'spine') {
            sampled_points1.reverse();
            sampled_points2.reverse();
        }
        for (let i = 0; i < NUM_SAMPLE - 1; i++) {
            add_triangle(sampled_points1[i], sampled_points1[i+1], sampled_points2[i]);
            add_triangle(sampled_points1[i+1], sampled_points2[i+1], sampled_points2[i]);
        }
        add_triangle(sampled_points1[NUM_SAMPLE - 1], sampled_points1[NUM_SAMPLE], sampled_points2[NUM_SAMPLE - 1]);
    }
}

function add_point(point) {
    const key = `${point.x},${point.y},${point.z}`;
    if (point_map.has(key)) {
        return point_map.get(key);
    }
    geometry_positions.push(point.x);
    geometry_positions.push(point.y);
    geometry_positions.push(point.z);
    point_map.set(key, id_count);
    id_count++;
    return id_count - 1;
}

function add_triangle(p1, p2, p3) {
    let idx1 = add_point(p1);
    let idx2 = add_point(p2);
    let idx3 = add_point(p3);

    geometry_faces.push(idx1);
    geometry_faces.push(idx2);
    geometry_faces.push(idx3);

    // the other side
    let p4 = new THREE.Vector3(p1.x, p1.y, -p1.z);
    let p5 = new THREE.Vector3(p2.x, p2.y, -p2.z);
    let p6 = new THREE.Vector3(p3.x, p3.y, -p3.z);
    let idx4 = add_point(p4);
    let idx6 = add_point(p6);
    let idx5 = add_point(p5);

    geometry_faces.push(idx4);
    geometry_faces.push(idx6);
    geometry_faces.push(idx5);
}

function oval_sample(triangles){
    var oval_map = new Map();
    
    for (let triangle of triangles){
        for (let edge of triangle.edges){
            if(edge.type !== "internal")
                continue;

            let key = `${edge.p1.x},${edge.p1.y}|${edge.p2.x},${edge.p2.y}`;
            if(oval_map.has(key))
                continue;
                
            let sampled_points = [];
            let a, b, c, center;
            if(edge.p1.type == "spine"){
                center = new Point(edge.p1);
                center.z = 0;
                a = edge.p2.x - center.x;
                b = edge.p2.y - center.y;
                c = edge.p1.z;
            }
            else{
                center = new Point(edge.p2);
                center.z = 0;
                a = edge.p1.x - center.x;
                b = edge.p1.y - center.y;
                c = edge.p2.z;
            }
            
            let theta = 0;
            for (let i = 0; i < NUM_SAMPLE; i++) {
                theta = Math.PI / 2 / NUM_SAMPLE * i;
                let x = a * Math.cos(theta) + center.x;
                let y = b * Math.cos(theta) + center.y;
                let z = c * Math.sin(theta);
                let new_point = new THREE.Vector3(x, y, z);
                sampled_points.push(new_point);
            }
            sampled_points.push(new THREE.Vector3(center.x, center.y, c));
            
            oval_map.set(key, sampled_points);
        }
    }
    return oval_map;
}

function elevate_spine(spine_edges){
    let elevated_points = [];
    for(let edge of spine_edges){
        let p1 = edge.p1, p2 = edge.p2;
        if(p1.z == 0){
            elevate_point(p1);
            elevated_points.push(p1);
        }
        if(p2.z == 0){
            elevate_point(p2);
            elevated_points.push(p2);
        }
    }
    return elevated_points;
}

function handle_junction_center(cursor) {
    const key = `${cursor.x},${cursor.y}`;
    if (!junction_centers.has(key))
        return false;
    const avg_dis = junction_centers.get(key);
    cursor.z = ELEVATE_CONSTANT * avg_dis;
    return true;
}

function elevate_point(cursor) {
    if (handle_junction_center(cursor))
        return;
    let total_dis = 0;
    let n_external_neighbor = 0;
    for (const neighbor of cursor.adjacent_points) {
        if (neighbor.type !== 'external')
            continue;
        total_dis += cursor.distanceTo(neighbor);
        n_external_neighbor++;
    }
    cursor.z = ELEVATE_CONSTANT * total_dis / n_external_neighbor;
}
