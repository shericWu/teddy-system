import * as THREE from 'three'
import { Triangle, Edge } from './triangle.js'

var id_count = 0;

export class Point {
    constructor(pos, type = 'external') {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        this.type = type;
        this.adjacent_points = [];
        this.id = id_count;
        id_count -=- 1;
    }

    distanceTo(other) {
        return Math.sqrt(
            Math.pow(this.x - other.x, 2) +
            Math.pow(this.y - other.y, 2) +
            Math.pow(this.z - other.z, 2)
        );
    }
}

var resulting_triangulation = [];
var new_edges = new Map();
var new_points = new Map();

export function triangulate(triangles){
    resulting_triangulation = [];
    new_edges = new Map();
    new_points = new Map();
    id_count = 0;
    let spine = [];
    for (let triangle of triangles){
        if(triangle.type == 'sleeve')
            handleSleeve(triangle, spine);
        else if(triangle.type == 'junction')
            handleJunction(triangle, spine);
    }
    for (let triangle of triangles){
        if(triangle.type == 'fan')
            handleFan(triangle);
    }
    return [spine, resulting_triangulation];
}

function addPoint(point, type) {
    let key = `${point.x},${point.y}`;
    if (new_points.has(key)){
        return new_points.get(key);
    }
    let new_point = new Point(point, type);
    new_points.set(key, new_point);
    return new_point;
}

function addEdge(p1, p2, type) {
    const key1 = `${p1.x},${p1.y}|${p2.x},${p2.y}`;
    const key2 = `${p2.x},${p2.y}|${p1.x},${p1.y}`;
    if (new_edges.has(key1)){
        let edge = new_edges.get(key1);
        if(edge.type == 'external')
            edge.type = 'internal';
        return edge;
    }
    let edge = new Edge(p1, p2, type);
    new_edges.set(key1, edge);
    new_edges.set(key2, edge);
    p1.adjacent_points.push(p2);
    p2.adjacent_points.push(p1);
    return edge;
}

function addTriangle(p1, p2, p3, type1 = 'external', type2 = 'external', type3 = 'external', 
            etype1 = 'external', etype2 = 'external', etype3 = 'external'){
    let a = addPoint(p1, type1), b = addPoint(p2, type2), c = addPoint(p3, type3);
    let e1 = addEdge(b, c, etype1), e2 = addEdge(c, a, etype2), e3 = addEdge(a, b, etype3);
    let new_triangle = new Triangle(a, b, c);
    new_triangle.points = [a, b, c];
    new_triangle.edges = [e1, e2, e3];
    resulting_triangulation.push(new_triangle);
    return new_triangle // note that the type of the triangle created havent set yet
}

function triangulateSleeve(cursor, spine_edge, idx1, idx2) {
    addTriangle(
        spine_edge.p1, cursor.points[idx2], cursor.points[idx1],
        "spine", "external", "external",
        "external", "internal", "internal"
    );
    addTriangle(
        spine_edge.p1, cursor.points[idx1], spine_edge.p2,
        "spine", "external", "spine",
        "internal", "spine", "internal"
    );
    addTriangle(
        spine_edge.p1, spine_edge.p2, cursor.points[3 - idx1 - idx2],
        "spine", "spine", "external",
        "internal", "internal", "spine"
    );
}

function triangulateJunction(cursor, spine_edge, idx1, idx2) {
    addTriangle(
        spine_edge.p1, spine_edge.p2, cursor.points[idx1],
        "spine", "spine", "external", 
        "internal", "internal", "spine"
    );
    addTriangle(
        spine_edge.p1, spine_edge.p2, cursor.points[idx2],
        "spine", "spine", "external", 
        "internal", "internal", "spine"
    );
}

function handleSleeve(cursor, spine) {
    for(let i = 0; i < 3; i++){
        let edge = cursor.edges[i];
        if(edge.type == 'external'){
            let midpoint1 = addPoint(cursor.edges[(i + 1) % 3].getMidpoint(), "spine");
            let midpoint2 = addPoint(cursor.edges[(i + 2) % 3].getMidpoint(), "spine");
            let spine_edge = addEdge(midpoint1, midpoint2, 'spine');
            spine.push(spine_edge);
            triangulateSleeve(cursor, spine_edge, (i+1) % 3, (i+2) % 3);
            break;
        }
    }
}

function handleJunction(cursor, spine){
    let center = addPoint(cursor.getMidpoint(), "spine");

    for (let i = 0; i < 3; i++) {
        let edge = cursor.edges[i];
        if (edge.type === 'internal' || !edge.is_pruned) {
            let midpoint = addPoint(edge.getMidpoint(), "spine");
            let spine_edge = addEdge(midpoint, center, 'spine');
            spine.push(spine_edge);

            triangulateJunction(cursor, spine_edge, (i+1)%3, (i+2)%3);
        }
    }
}

function handleFan(cursor){
    addTriangle(
        cursor.points[0], cursor.points[1], cursor.points[2]
    )
}