import cdt2d from "cdt2d";

export function getCDT(points) {
    const cdp_points = [];
    const cdp_edges = [];
    let i = 0, n = points.length;
    for (i = 0; i < n - 1; i++) {
        cdp_points.push([points[i].x, points[i].y]);
        if (i > 0)
            cdp_edges.push([i-1, i]);
    }
    cdp_edges.push([i-1, 0]);
    // console.log(cdp_points, cdp_edges);
    return cdt2d(cdp_points, cdp_edges, {exterior: false});
}

export function showCDT(cdt_result) {
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