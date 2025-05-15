import * as THREE from 'three';
import { Triangle, Edge } from './triangle.js';

function pointOutside(points, end_edge) {
    // console.log("End edge: ", end_edge);
    const mid_point = end_edge.getMidpoint();
    const radius = end_edge.getLength() / 2;
    for (let i = 1; i < points.length - 1; i++) {
        let point = points[i];
        if (point.distanceTo(mid_point) > radius) {
            return true;
        }
    }
    return false;
}


function findEndEdge(current_edge, triangle) {
    // console.log(triangle.edges[0].type, triangle.edges[1].type, triangle.edges[2].type);
    for (let i = 0; i < triangle.edges.length; i++) {
        let edge = triangle.edges[i];
        if ((edge.type == 'internal' || edge.type == 'fan') && edge != current_edge) {
            return [edge, i];
        }
    }
    return [null, -1];
}

function updatePoints(points, triangle){
    for (let edge of triangle.edges) {
        if (edge.type == 'external') {
            let p1 = edge.p1, p2 = edge.p2;
            if (points[0] == p1)
                points.unshift(p2);
            else if (points[0] == p2)
                points.unshift(p1);
            else if (points[points.length - 1] == p1)
                points.push(p2);
            else if (points[points.length - 1] == p2)
                points.push(p1);
            return;
        }
    }
}

export let junction_centers = new Map();

function add_junction_center(center, adjs) {
    const key = `${center.x},${center.y}`;
    if (junction_centers.has(key))
        return;

    let total_dis = 0;
    for (const neighbor of adjs) {
        total_dis += Math.sqrt((center.x - neighbor.x) ** 2 + (center.y - neighbor.y) ** 2);
    }
    junction_centers.set(key, total_dis / adjs.length);
    return;
}

export function pruneTriangles(triangles) {
    let prunedTriangles = [];
    let toDelTriangles = [];
    for (let triangle of triangles) {
        if (triangle.type !== 'terminal') {
            continue;
        }

        // console.log("Pruning triangle: ", triangle);

        let points = [];
        let end_edge, idx;
        [end_edge, idx] = findEndEdge(null, triangle);
        //console.log("End edge: ", end_edge);
        points.push(triangle.points[idx]);
        points.push(triangle.points[(idx + 1) % 3]);
        points.unshift(triangle.points[(idx + 2) % 3]);

        let current_triangle = triangle;
        while(!pointOutside(points, end_edge)) {
            toDelTriangles.push(current_triangle);
            current_triangle = (end_edge.adjacent_triangles[0] == current_triangle)? end_edge.adjacent_triangles[1] : end_edge.adjacent_triangles[0];

            // console.log("Current triangle: ", current_triangle);

            if(current_triangle.type == 'junction' || end_edge.type == 'fan')
                break;

            let old_end_edge = end_edge;
            [end_edge, idx] = findEndEdge(end_edge, current_triangle);
            if (end_edge == null) {
                end_edge = old_end_edge;
                break;
            }
            updatePoints(points, current_triangle);
            // console.log("End edge is: ", end_edge);
        }

        if(current_triangle.type == 'junction')
            end_edge.is_pruned = true;

        let center = (current_triangle.type == 'junction') ? current_triangle.getMidpoint() : end_edge.getMidpoint();
        if(current_triangle.type !== 'junction') {
            toDelTriangles.push(current_triangle);
            if(end_edge.adjacent_triangles[0] == current_triangle)
                current_triangle = end_edge.adjacent_triangles[1];
            else
                current_triangle = end_edge.adjacent_triangles[0];
        }
        // the current_triangle is now pointing to the one outside the fan

        let new_triangles = [];

        for(let i = 0; i < points.length - 1; i++) {
            let new_triangle = new Triangle(points[i], points[i + 1], center);
            new_triangle.edges[2] = new Edge(points[i], points[i + 1], "external");
            new_triangle.edges[2].adjacent_triangles = [new_triangle];
            new_triangle.type = 'fan';
            new_triangles.push(new_triangle);
        }

        end_edge.type = 'fan';
        end_edge.adjacent_triangles = [new_triangles[0], new_triangles[new_triangles.length - 1], current_triangle];

        for (let i = 1; i < points.length - 1; i++) {
            let new_edge = new Edge(points[i], center, "internal");
            new_triangles[i - 1].edges[0] = new_edge;
            new_triangles[i].edges[1] = new_edge;
            new_edge.adjacent_triangles = [new_triangles[i - 1], new_triangles[i]];
        }

        let left_edge = new Edge(points[0], center, "fan");
        left_edge.adjacent_triangles = [new_triangles[0], current_triangle];
        let right_edge = new Edge(points[points.length - 1], center, "fan");
        right_edge.adjacent_triangles = [new_triangles[new_triangles.length - 1], current_triangle];

        new_triangles[0].edges[1] = left_edge;
        new_triangles[new_triangles.length - 1].edges[0] = right_edge;

        prunedTriangles = prunedTriangles.concat(new_triangles);

        if(current_triangle.type == 'junction' && current_triangle.edges[0].is_pruned &&
                current_triangle.edges[1].is_pruned && current_triangle.edges[2].is_pruned){
            toDelTriangles.push(current_triangle);
        }
    }

    triangles = triangles.filter((triangle) => !toDelTriangles.includes(triangle));
    triangles = triangles.concat(prunedTriangles);

    junction_centers = new Map();
    for(let cursor of triangles){
        if(cursor.type !== "junction")
            continue;

        let n_pruned = 0;
        for (let edge of cursor.edges) {
            if(edge.is_pruned)
                n_pruned++;
        }

        if(n_pruned == 1){
            let midpoints = [];
            for(let edge of cursor.edges){
                if(!edge.is_pruned)
                    midpoints.push(edge.getMidpoint());
            }
            cursor.center.x = (midpoints[0].x + midpoints[1].x) / 2;
            cursor.center.y = (midpoints[0].y + midpoints[1].y) / 2;
            add_junction_center(cursor.center, cursor.points);
        }
    }

    console.log(triangles);

    return triangles;
}
