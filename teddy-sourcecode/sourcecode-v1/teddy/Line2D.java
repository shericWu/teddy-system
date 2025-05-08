/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Vector2;
import teddy.Vertex2D;

class Line2D {
    Vertex2D base;
    Vector2 direction;

    public static Vertex2D cross_point(Line2D line2D, Line2D line2D2) {
        Vertex2D vertex2D = line2D.base;
        Vector2 vector2 = line2D.direction;
        Vertex2D vertex2D2 = line2D2.base;
        Vector2 vector22 = line2D2.direction;
        double d = vector2.x;
        double d2 = -vector22.x;
        double d3 = vector2.y;
        double d4 = -vector22.y;
        double d5 = vertex2D2.x - vertex2D.x;
        double d6 = vertex2D2.y - vertex2D.y;
        double d7 = d * d4 - d2 * d3;
        if (d7 == 0.0) {
            return null;
        }
        double d8 = d4 / d7;
        double d9 = -d2 / d7;
        double d10 = -d3 / d7;
        double d11 = d / d7;
        double d12 = d8 * d5 + d9 * d6;
        double d13 = vertex2D.x + vector2.x * d12;
        double d14 = vertex2D.y + vector2.y * d12;
        return new Vertex2D(d13, d14);
    }

    Line2D(Vertex2D vertex2D, Vector2 vector2) {
        this.base = vertex2D;
        this.direction = vector2;
    }
}

