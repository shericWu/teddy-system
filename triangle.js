class Edge {
    constructor(p1, p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.adjacent_triangles = [null, null];
    }

    getMidpoint() {
        return new THREE.Vector2(
            (this.p1.x + this.p2.x) / 2,
            (this.p1.y + this.p2.y) / 2
        );
    }
}

class Triangle {
    constructor(p1, p2, p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.adjacent_triangles = [];
    }

    getMidpoint() {
        return new THREE.Vector2(
            (this.p1.x + this.p2.x + this.p3.x) / 3,
            (this.p1.y + this.p2.y + this.p3.y) / 3
        );
    }
}

function getTriangles(triangles){
    let edges = new Map();
    for (let i = 0; i < triangles.length; i++) {
        const triangle = triangles[i];
        const p1_idx = triangle[0], p2_idx = triangle[1], p3_idx = triangle[2];
        const p1 = points[p1_idx], p2 = points[p2_idx], p3 = points[p3_idx];
        let triangleObj = new Triangle(p1, p2, p3);

        if(edges.has((p1_idx, p2_idx))){
            let edge = edges.get((p1_idx, p2_idx));
            triangleObj.adjacent_triangles.push(edge.adjacent_triangles[0]);
            edge.adjacent_triangles[1] = triangleObj;
            edge.adjacent_triangles[0].adjacent_triangles.push(triangleObj);
        }
        else{
            let edge = new Edge(p1, p2);
            edges.set((p1_idx, p2_idx), edge);
            edges.set((p2_idx, p1_idx), edge);
            edge.adjacent_triangles[0] = triangleObj;
        }
    }
}