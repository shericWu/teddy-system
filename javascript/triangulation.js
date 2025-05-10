import * as THREE from 'three'
import { Triangle, Edge } from './triangle.js';

export function connectSpine(triangles){
    const n_triangles = triangles.length;
    let isVisited = new Array(n_triangles).fill(false);
    let spine = [];
    for(let i = 0; i < n_triangles; i++){
        let triangle = triangles[i];
        if (triangle.type === 'fan')
            isVisited[i] = true;
        DFS(triangle, i, triangles, isVisited, spine);
    }
    return spine;
}

function performDFS(cursor, triangles, isVisited, spine){
    for (let edge of cursor.edges) {
        if(edge.type == 'external' || edge.type == 'fan')
            continue;
        for (let triangle of edge.adjacent_triangles){
            if(triangle == cursor)
                continue;
            let next_idx = triangles.indexOf(triangle)
            if(isVisited[next_idx])
                continue;
            DFS(triangle, next_idx, triangles, isVisited, spine);
            break;
        }
    }
}

function DFS(cursor, idx, triangles, isVisited, spine) {
    if(isVisited[idx])
        return;
    isVisited[idx] = true;
    if (cursor.type === 'sleeve'){
        for(let i = 0; i < 3; i++){
            let edge = cursor.edges[i];
            if(edge.type == 'external'){
                let midpoint1 = cursor.edges[(i + 1) % 3].getMidpoint();
                let midpoint2 = cursor.edges[(i + 2) % 3].getMidpoint();
                let spine_edge = new Edge(midpoint1, midpoint2, 'spine');
                spine.push(spine_edge);
                break;
            }
        }
        performDFS(cursor, triangles, isVisited, spine);
    }
    else if (cursor.type === 'junction'){
        let center = cursor.getMidpoint();
        for (let i = 0; i < 3; i++) {
            let edge = cursor.edges[i];
            if (edge.type === 'internal' || !edge.is_pruned) {
                let midpoint = edge.getMidpoint();
                let spine_edge = new Edge(midpoint, center, 'spine');
                spine.push(spine_edge);
            }
        }
        performDFS(cursor, triangles, isVisited, spine);
    }
}