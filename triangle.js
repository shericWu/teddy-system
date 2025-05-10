import * as THREE from 'three';
// export class Point {
//     constructor(pos) {
//         this.x = pos.x;
//         this.y = pos.y;
//         this.adjancent_points = [];
//     }

//     distanceTo(other) {
//         return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
//     }
// }

export class Edge {
    constructor(p1, p2, type = 'external') {
        this.p1 = p1;
        this.p2 = p2;
        this.type = type;
        this.adjacent_triangles = [];
    }

    getMidpoint() {
        return new THREE.Vector2(
            (this.p1.x + this.p2.x) / 2,
            (this.p1.y + this.p2.y) / 2
        );
    }

    getLength() {
        return this.p1.distanceTo(this.p2);
    }
}

export class Triangle {
    constructor(p1, p2, p3) {
        this.points = [p1, p2, p3];
        this.edges = [null, null, null];
        this.type = null;
    }

    getMidpoint() {
        return new THREE.Vector2(
            (this.points[0].x + this.points[1].x + this.points[2].x) / 3,
            (this.points[0].y + this.points[1].y + this.points[2].y) / 3
        );
    }
}

export function getTriangles(cdt_result, points) {
    let edgeMap = new Map();
    let triangles = [];

    for (const triangle of cdt_result) {
        const p = [points[triangle[0]], points[triangle[1]], points[triangle[2]]];
        let triangleObj = new Triangle(p[0], p[1], p[2]);

        let edgePoints = [[p[1], p[2]], [p[2], p[0]], [p[0], p[1]]];

        for (let i = 0; i < 3; i++) {
            let [a, b] = edgePoints[i];

            // Use string key to avoid JS tuple pitfalls
            let key1 = `${a.x},${a.y}|${b.x},${b.y}`;
            let key2 = `${b.x},${b.y}|${a.x},${a.y}`;

            if (edgeMap.has(key1)) {
                let edge = edgeMap.get(key1);
                edge.type = 'internal';

                edge.adjacent_triangles.push(triangleObj);

                triangleObj.edges[i] = edge;
            } else {
                let edge = new Edge(a, b);
                edge.adjacent_triangles = [triangleObj];
                edgeMap.set(key1, edge);
                edgeMap.set(key2, edge);

                triangleObj.edges[i] = edge;
            }
        }

        triangles.push(triangleObj);
    }

    for(let triangle of triangles){
        let n_external = 0;
        for(let i = 0; i < 3; i++){
            if(triangle.edges[i].type == "external"){
                n_external++;
            }
        }
        //console.log("n_external", n_external);
        if(n_external == 2){
            //console.log("terminal triangle", triangle);
            triangle.type = "terminal";
        }
        else if(n_external == 1){
            //console.log("sleeve triangle", triangle);
            triangle.type = "sleeve";
        }
        else{
            //console.log("junction triangle", triangle);
            triangle.type = "junction";
        }
    }

    return triangles;
}
