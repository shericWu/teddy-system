/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Line2D;
import teddy.Vector2;
import teddy.Vertex2D;

class Geometry2D {
    public static double get_radius(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex2D vertex2D3) {
        Vertex2D vertex2D4 = Geometry2D.get_circumcenter(vertex2D, vertex2D2, vertex2D3);
        if (vertex2D4 == null) {
            return Double.MAX_VALUE;
        }
        return Vector2.distance(vertex2D4, vertex2D);
    }

    private static Line2D get_dividing_line(Vertex2D vertex2D, Vertex2D vertex2D2) {
        Vertex2D vertex2D3 = Vertex2D.mid_point(vertex2D, vertex2D2);
        double d = vertex2D2.x - vertex2D.x;
        double d2 = vertex2D2.y - vertex2D.y;
        Vector2 vector2 = new Vector2(d2, -d);
        return new Line2D(vertex2D3, vector2);
    }

    public static boolean left_side(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex2D vertex2D3) {
        if (vertex2D == vertex2D3 || vertex2D2 == vertex2D3) {
            return true;
        }
        Vector2 vector2 = new Vector2(vertex2D, vertex2D2);
        Vector2 vector22 = new Vector2(vertex2D, vertex2D3);
        return vector2.cross_product(vector22) <= 0.0;
    }

    public static boolean left_side(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex2D vertex2D3, Vertex2D vertex2D4) {
        Vector2 vector2 = new Vector2(vertex2D2, vertex2D);
        Vector2 vector22 = new Vector2(vertex2D2, vertex2D3);
        Vector2 vector23 = new Vector2(vertex2D2, vertex2D4);
        double d = 360.0 - vector22.get_angle(vector23);
        double d2 = 360.0 - vector22.get_angle(vector2);
        if (d == 360.0) {
            d = 0.0;
        }
        return d <= d2;
    }

    Geometry2D() {
    }

    public static Vertex2D get_circumcenter(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex2D vertex2D3) {
        Line2D line2D = Geometry2D.get_dividing_line(vertex2D, vertex2D2);
        Line2D line2D2 = Geometry2D.get_dividing_line(vertex2D, vertex2D3);
        return Line2D.cross_point(line2D, line2D2);
    }
}

