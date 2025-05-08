/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import teddy.Vector2;
import teddy.Vertex2D;

class Edge2D {
    Vertex2D start;
    Vertex2D end;

    public Vector2 vector2() {
        return new Vector2(this.start, this.end);
    }

    public boolean right_side_of_edge(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 - d4;
        double d8 = d3 - d;
        double d9 = d4 * d - d3 * d2;
        return d7 * d5 + d8 * d6 + d9 < 0.0;
    }

    public Vertex2D cross_point(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d2 - d4;
        double d10 = d3 - d;
        double d11 = d4 * d - d3 * d2;
        double d12 = d6 - d8;
        double d13 = d7 - d5;
        double d14 = d8 * d5 - d7 * d6;
        if (Math.abs(d9 * d13 - d12 * d10) < 1.0E-5) {
            return null;
        }
        double d15 = (d10 * d14 - d13 * d11) / (d9 * d13 - d12 * d10);
        double d16 = (d9 * d14 - d12 * d11) / (d12 * d10 - d9 * d13);
        return new Vertex2D(d15, d16);
    }

    public Vertex2D mid_point() {
        return new Vertex2D((this.start.x + this.end.x) / 2.0, (this.start.y + this.end.y) / 2.0);
    }

    Edge2D() {
    }

    Edge2D(Vertex2D vertex2D, Vertex2D vertex2D2) {
        this.start = vertex2D;
        this.end = vertex2D2;
    }

    Edge2D(Point point, Point point2) {
        this.start = new Vertex2D(point);
        this.end = new Vertex2D(point2);
    }

    public Vertex2D get_the_other_vertex(Vertex2D vertex2D) {
        if (vertex2D == this.start) {
            return this.end;
        }
        return this.start;
    }

    public Vertex2D get_common_vertex(Edge2D edge2D) {
        if (this.start == edge2D.start || this.start == edge2D.end) {
            return this.start;
        }
        return this.end;
    }

    public boolean contains(Vertex2D vertex2D) {
        return vertex2D == this.start || vertex2D == this.end;
    }

    public boolean equals(Vertex2D vertex2D, Vertex2D vertex2D2) {
        return vertex2D == this.start && vertex2D2 == this.end || vertex2D2 == this.start && vertex2D == this.end;
    }

    public double distance_as_a_segment(Vertex2D vertex2D) {
        Vector2 vector2 = new Vector2(this.start, this.end);
        Vector2 vector22 = new Vector2(this.start, vertex2D);
        if (vector2.dot_product(vector22) < 0.0) {
            return Vector2.distance(vertex2D, this.start);
        }
        vector22 = new Vector2(this.end, vertex2D);
        if (vector2.dot_product(vector22) > 0.0) {
            return Vector2.distance(vertex2D, this.end);
        }
        return this.distance(vertex2D);
    }

    public double length() {
        return Vector2.distance(this.start, this.end);
    }

    public boolean cross(Edge2D edge2D) {
        return this.cross(this.start.x, this.start.y, this.end.x, this.end.y, edge2D.start.x, edge2D.start.y, edge2D.end.x, edge2D.end.y);
    }

    public boolean cross(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d2 - d4;
        double d10 = d3 - d;
        double d11 = d4 * d - d3 * d2;
        double d12 = d6 - d8;
        double d13 = d7 - d5;
        double d14 = d8 * d5 - d7 * d6;
        return (d9 * d5 + d10 * d6 + d11) * (d9 * d7 + d10 * d8 + d11) <= 0.0 && (d12 * d + d13 * d2 + d14) * (d12 * d3 + d13 * d4 + d14) <= 0.0;
    }

    public double distance(Vertex2D vertex2D) {
        double d = this.end.x - this.start.x;
        double d2 = this.end.y - this.start.y;
        double d3 = Math.sqrt(d * d + d2 * d2);
        double d4 = d * (vertex2D.y - this.start.y) - d2 * (vertex2D.x - this.start.x);
        if (d3 == 0.0) {
            System.out.println("Error in Edge2D.distance");
            return 0.0;
        }
        return Math.abs(d4 / d3);
    }
}

