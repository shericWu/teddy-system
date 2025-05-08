/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.LinkedList;
import teddy.Polyhedron;

class Box
extends Polyhedron {
    Box() {
        double d;
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
        double d2 = -2.0;
        while (d2 <= 1.5) {
            d = -1.0;
            while (d <= 0.5) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, d, 1.0), this.get_vertex(d2 + 0.5, d, 1.0), this.get_vertex(d2 + 0.5, d + 0.5, 1.0), this.get_vertex(d2, d + 0.5, 1.0)));
                d += 0.5;
            }
            d2 += 0.5;
        }
        double d3 = 1.0;
        while (d3 >= -0.5) {
            d2 = -2.0;
            while (d2 <= 1.5) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, 1.0, d3), this.get_vertex(d2 + 0.5, 1.0, d3), this.get_vertex(d2 + 0.5, 1.0, d3 - 0.5), this.get_vertex(d2, 1.0, d3 - 0.5)));
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, -1.0, d3 - 0.5), this.get_vertex(d2 + 0.5, -1.0, d3 - 0.5), this.get_vertex(d2 + 0.5, -1.0, d3), this.get_vertex(d2, -1.0, d3)));
                d2 += 0.5;
            }
            d = -1.0;
            while (d <= 0.5) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(-2.0, d, d3), this.get_vertex(-2.0, d + 0.5, d3), this.get_vertex(-2.0, d + 0.5, d3 - 0.5), this.get_vertex(-2.0, d, d3 - 0.5)));
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(2.0, d, d3 - 0.5), this.get_vertex(2.0, d + 0.5, d3 - 0.5), this.get_vertex(2.0, d + 0.5, d3), this.get_vertex(2.0, d, d3)));
                d += 0.5;
            }
            d3 -= 0.5;
        }
        d2 = -2.0;
        while (d2 <= 1.5) {
            d = -1.0;
            while (d <= 0.5) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, d, -1.0), this.get_vertex(d2, d + 0.5, -1.0), this.get_vertex(d2 + 0.5, d + 0.5, -1.0), this.get_vertex(d2 + 0.5, d, -1.0)));
                d += 0.5;
            }
            d2 += 0.5;
        }
        this.postprocess();
        this.set_sharp_edges();
        this.rotate_z(20.0);
        this.rotate_x(10.0);
    }
}

