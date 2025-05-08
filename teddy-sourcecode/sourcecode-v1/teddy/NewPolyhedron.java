/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.LinkedList;
import teddy.Polyhedron;
import teddy.Vertex2D;

class NewPolyhedron
extends Polyhedron {
    public void add_temp_polygon(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d, d2, d3), this.get_vertex(d4, d5, d6), this.get_vertex(d7, d8, d9)));
    }

    public void add_temp_polygon(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d, d2, d3), this.get_vertex(d4, d5, d6), this.get_vertex(d7, d8, d9), this.get_vertex(d10, d11, d12)));
    }

    NewPolyhedron() {
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
    }

    NewPolyhedron(LinkedList linkedList) {
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex2D vertex2D = new Vertex2D(0.0, 0.0);
        while (enumeration.hasMoreElements()) {
            Vertex2D vertex2D2 = (Vertex2D)enumeration.nextElement();
            vertex2D.x += vertex2D2.x;
            vertex2D.y += vertex2D2.y;
        }
        vertex2D.x /= (double)linkedList.size();
        vertex2D.y /= (double)linkedList.size();
        enumeration = linkedList.elements();
        Vertex2D vertex2D3 = (Vertex2D)enumeration.nextElement();
        int n = 4;
        while (enumeration.hasMoreElements()) {
            Vertex2D vertex2D4 = (Vertex2D)enumeration.nextElement();
            double d = vertex2D3.x;
            double d2 = vertex2D3.y;
            double d3 = vertex2D4.x;
            double d4 = vertex2D4.y;
            int n2 = -n;
            while (n2 < n) {
                double d5 = Math.cos(Math.PI * (double)n2 / (double)n / 2.0);
                double d6 = Math.sin(Math.PI * (double)n2 / (double)n / 2.0) / 2.0;
                double d7 = Math.cos(Math.PI * (double)(n2 + 1) / (double)n / 2.0);
                double d8 = Math.sin(Math.PI * (double)(n2 + 1) / (double)n / 2.0) / 2.0;
                double d9 = vertex2D.x + (d - vertex2D.x) * d5;
                double d10 = vertex2D.y + (d2 - vertex2D.y) * d5;
                double d11 = vertex2D.x + (d3 - vertex2D.x) * d5;
                double d12 = vertex2D.y + (d4 - vertex2D.y) * d5;
                double d13 = vertex2D.x + (d3 - vertex2D.x) * d7;
                double d14 = vertex2D.y + (d4 - vertex2D.y) * d7;
                double d15 = vertex2D.x + (d - vertex2D.x) * d7;
                double d16 = vertex2D.y + (d2 - vertex2D.y) * d7;
                if (n2 == -n) {
                    this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(vertex2D.x, d6, vertex2D.y), this.get_vertex(d15, d8, d16), this.get_vertex(d13, d8, d14)));
                } else if (n2 == n - 1) {
                    this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d11, d6, d12), this.get_vertex(d9, d6, d10), this.get_vertex(vertex2D.x, d8, vertex2D.y)));
                } else {
                    this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(d15, d8, d16), this.get_vertex(d13, d8, d14), this.get_vertex(d11, d6, d12), this.get_vertex(d9, d6, d10)));
                }
                ++n2;
            }
            vertex2D3 = vertex2D4;
        }
        this.postprocess_no_normalize();
    }

    public void generate_polygons() {
        this.postprocess_no_normalize();
    }
}

