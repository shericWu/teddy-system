/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.LinkedList;
import teddy.Polyhedron;
import teddy.Vertex;

class Hammer
extends Polyhedron {
    Hammer() {
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
                if (d2 != -0.5 && d2 != 0.0 || d != -0.5 && d != 0.0) {
                    this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, d, -1.0), this.get_vertex(d2, d + 0.5, -1.0), this.get_vertex(d2 + 0.5, d + 0.5, -1.0), this.get_vertex(d2 + 0.5, d, -1.0)));
                }
                d += 0.5;
            }
            d2 += 0.5;
        }
        d3 = -1.0;
        while (d3 >= -2.75) {
            d2 = -0.5;
            while (d2 <= 0.0) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, 0.5, d3), this.get_vertex(d2 + 0.5, 0.5, d3), this.get_vertex(d2 + 0.5, 0.5, d3 - 0.25), this.get_vertex(d2, 0.5, d3 - 0.25)));
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, -0.5, d3 - 0.25), this.get_vertex(d2 + 0.5, -0.5, d3 - 0.25), this.get_vertex(d2 + 0.5, -0.5, d3), this.get_vertex(d2, -0.5, d3)));
                d2 += 0.5;
            }
            d = -0.5;
            while (d <= 0.0) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(-0.5, d, d3), this.get_vertex(-0.5, d + 0.5, d3), this.get_vertex(-0.5, d + 0.5, d3 - 0.25), this.get_vertex(-0.5, d, d3 - 0.25)));
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(0.5, d, d3 - 0.25), this.get_vertex(0.5, d + 0.5, d3 - 0.25), this.get_vertex(0.5, d + 0.5, d3), this.get_vertex(0.5, d, d3)));
                d += 0.5;
            }
            d3 -= 0.25;
        }
        d2 = -0.5;
        while (d2 <= 0.0) {
            d = -0.5;
            while (d <= 0.0) {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d2, d, -3.0), this.get_vertex(d2, d + 0.5, -3.0), this.get_vertex(d2 + 0.5, d + 0.5, -3.0), this.get_vertex(d2 + 0.5, d, -3.0)));
                d += 0.5;
            }
            d2 += 0.5;
        }
        Enumeration enumeration = this._vertices.elements();
        while (enumeration.hasMoreElements()) {
            Vertex vertex = (Vertex)enumeration.nextElement();
            double d4 = Math.sqrt(vertex.x * vertex.x + vertex.y * vertex.y);
            if (!(d4 > 1.0E-4)) continue;
            double d5 = (0.5 + d4 / 2.0) / d4;
            vertex.x *= d5;
            vertex.y *= d5;
        }
        this.postprocess();
    }
}

