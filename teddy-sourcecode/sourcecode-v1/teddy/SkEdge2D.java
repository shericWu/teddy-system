/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Edge2D;
import teddy.SkPolygon2D;
import teddy.SkVertex2D;
import teddy.Vector2;
import teddy.Vertex2D;

class SkEdge2D
extends Edge2D {
    public static final int EXTERNAL = 0;
    public static final int INTERNAL = 1;
    public static final int INTERNAL_SHARED = 2;
    int type;
    SkPolygon2D right_polygon = null;
    SkPolygon2D left_polygon = null;
    public double height = -1.0;

    SkEdge2D(SkVertex2D skVertex2D, SkVertex2D skVertex2D2, int n) {
        this.start = skVertex2D;
        this.end = skVertex2D2;
        skVertex2D.add_owner(this);
        skVertex2D2.add_owner(this);
        this.type = n;
    }

    public void set_left_polygon(SkPolygon2D skPolygon2D) {
        this.left_polygon = skPolygon2D;
    }

    public SkPolygon2D the_other_polygon(SkPolygon2D skPolygon2D) {
        if (this.left_polygon == skPolygon2D) {
            return this.right_polygon;
        }
        return this.left_polygon;
    }

    public void set_height() {
        if (this.type == 2 && this.height == -1.0) {
            this.height = this.get_average_height(this.right_polygon, this.left_polygon);
        }
    }

    private double get_average_height(SkPolygon2D skPolygon2D, SkPolygon2D skPolygon2D2) {
        Vertex2D vertex2D = this.mid_point();
        Vertex2D vertex2D2 = skPolygon2D2.type == 2 ? skPolygon2D2.center : (skPolygon2D2.type == 1 ? skPolygon2D2.the_other_internal_edge(this).mid_point() : skPolygon2D2.get_terminal_vertex());
        Vertex2D vertex2D3 = skPolygon2D.type == 2 ? skPolygon2D.center : (skPolygon2D.type == 1 ? skPolygon2D.the_other_internal_edge(this).mid_point() : skPolygon2D.get_terminal_vertex());
        double d = Vector2.distance(vertex2D, vertex2D3);
        double d2 = Vector2.distance(vertex2D, vertex2D2);
        double d3 = skPolygon2D2.height;
        double d4 = skPolygon2D.height;
        return (d3 * d + d4 * d2) / (d2 + d);
    }

    public boolean out_of_circle(SkVertex2D skVertex2D) {
        Vector2 vector2 = new Vector2(skVertex2D, this.start);
        Vector2 vector22 = new Vector2(skVertex2D, this.end);
        return vector2.get_cos(vector22) >= 0.0;
    }

    public void set_right_polygon(SkPolygon2D skPolygon2D) {
        this.right_polygon = skPolygon2D;
    }
}

