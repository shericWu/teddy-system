import * as THREE from 'three';
import { Triangle, Edge } from './triangle.js';

function pruneTriangles(triangles) {
    for(let triangle of triangles) {
        if(!triangle.type === 'terminal') {
            continue;
        }

        let points = [];
        
    }

    return prunedTriangles;
}