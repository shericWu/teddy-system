/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import teddy.Vector2;
import teddy.Vertex;

class Vertex2D
extends Vector2 {
    public static Vertex2D mid_point(Vertex2D vertex2D, Vertex2D vertex2D2) {
        return new Vertex2D((vertex2D.x + vertex2D2.x) / 2.0, (vertex2D.y + vertex2D2.y) / 2.0);
    }

    Vertex2D() {
    }

    Vertex2D(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    Vertex2D(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    Vertex2D(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }

    Vertex2D(Vertex vertex) {
        this.x = vertex.x;
        this.y = vertex.y;
    }

    public Vertex2D translate(Vector2 vector2) {
        return new Vertex2D(this.x + vector2.x, this.y + vector2.y);
    }

    public Vertex2D copy() {
        Vertex2D vertex2D = new Vertex2D(this.x, this.y);
        return vertex2D;
    }

    public void warp(Vertex2D vertex2D) {
        this.x = vertex2D.x;
        this.y = vertex2D.y;
    }

    public boolean same_position(Vertex2D vertex2D) {
        return this.x == vertex2D.x && this.y == vertex2D.y;
    }
}

