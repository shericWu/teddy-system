/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import teddy.Node;
import teddy.Vector3;
import teddy.Vertex2D;

public class Vector2 {
    public double x;
    public double y;

    public static double distance(Point point, Point point2) {
        return Vector2.distance(point.x, point.y, point2.x, point2.y);
    }

    public void normalize_self() {
        double d = this.length();
        if (d == 0.0) {
            d = 1.0;
        }
        this.x /= d;
        this.y /= d;
    }

    public static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt((d3 - d) * (d3 - d) + (d4 - d2) * (d4 - d2));
    }

    public static double distance(Vertex2D vertex2D, Vertex2D vertex2D2) {
        return Vector2.distance(vertex2D.x, vertex2D.y, vertex2D2.x, vertex2D2.y);
    }

    public Vector2 normalize() {
        double d = this.length();
        if (d == 0.0) {
            d = 1.0;
        }
        return new Vector2(this.x / d, this.y / d);
    }

    public double get_sin(Vector2 vector2) {
        double d = Math.sqrt((this.x * this.x + this.y * this.y) * (vector2.x * vector2.x + vector2.y * vector2.y));
        if (d > 0.0) {
            return this.cross_product(vector2) / d;
        }
        return 0.0;
    }

    protected Vector2 add(Vector2 vector2) {
        return new Vector2(this.x + vector2.x, this.y + vector2.y);
    }

    public double get_cos(Vector2 vector2) {
        double d = Math.sqrt((this.x * this.x + this.y * this.y) * (vector2.x * vector2.x + vector2.y * vector2.y));
        if (d > 0.0) {
            return this.inner_product(vector2) / d;
        }
        return 0.0;
    }

    public void multiple_self(double d) {
        this.x *= d;
        this.y *= d;
    }

    public void rotate90_self() {
        this.y = this.x = -this.y;
    }

    public double inner_product(Vector2 vector2) {
        return this.x * vector2.x + this.y * vector2.y;
    }

    public double cross_product(Vector2 vector2) {
        return this.x * vector2.y - this.y * vector2.x;
    }

    public Vertex2D vertex2D() {
        return new Vertex2D(this.x, this.y);
    }

    public void add_self(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
    }

    public Vector2 flip_y_axis() {
        return new Vector2(-this.x, this.y);
    }

    public Vector2 get_normalized() {
        double d = this.length();
        if (d == 0.0) {
            d = 1.0;
        }
        return new Vector2(this.x / d, this.y / d);
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2 rotate90() {
        return new Vector2(-this.y, this.x);
    }

    public Vector2 scale(double d) {
        return new Vector2(this.x * d, this.y * d);
    }

    public double cos(Vector2 vector2) {
        return this.get_cos(vector2);
    }

    public double outer_product(Vector2 vector2) {
        return this.x * vector2.y - this.y * vector2.x;
    }

    public double dot_product(Vector2 vector2) {
        return this.x * vector2.x + this.y * vector2.y;
    }

    public double sin(Vector2 vector2) {
        return this.get_sin(vector2);
    }

    Vector2(Node node, Node node2) {
        this.x = node2.x - node.x;
        this.y = node2.y - node.y;
    }

    Vector2(Point point, Point point2) {
        this.x = point2.x - point.x;
        this.y = point2.y - point.y;
    }

    Vector2(Vertex2D vertex2D, Vertex2D vertex2D2) {
        this.x = vertex2D2.x - vertex2D.x;
        this.y = vertex2D2.y - vertex2D.y;
    }

    Vector2(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    Vector2() {
    }

    Vector2(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    Vector2(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
    }

    public Vector2 rotate(double d) {
        if (d == 90.0) {
            return new Vector2(-this.y, this.x);
        }
        if (d == 180.0) {
            return new Vector2(-this.x, -this.y);
        }
        if (d == 270.0) {
            return new Vector2(this.y, -this.x);
        }
        double d2 = d * Math.PI / 180.0;
        double d3 = Math.cos(d2);
        double d4 = Math.sin(d2);
        return new Vector2(this.x * d3 - this.y * d4, this.x * d4 + this.y * d3);
    }

    public static Vector2 interporate(Point point, Point point2, double d) {
        return new Vector2((double)point.x * (1.0 - d) + (double)point2.x * d, (double)point.y * (1.0 - d) + (double)point2.y * d);
    }

    public static Vector2 interporate(Vertex2D vertex2D, Vertex2D vertex2D2, double d) {
        return new Vector2(vertex2D.x * (1.0 - d) + vertex2D2.x * d, vertex2D.y * (1.0 - d) + vertex2D2.y * d);
    }

    public Vector2 multiple(double d) {
        return new Vector2(this.x * d, this.y * d);
    }

    public double get_relative_angle(Vector2 vector2) {
        double d = this.cos(vector2);
        if (d <= -1.0) {
            return Math.PI;
        }
        if (d >= 1.0) {
            return 0.0;
        }
        return Math.acos(this.cos(vector2));
    }

    public double get_angle(Vector2 vector2) {
        double d = this.get_cos(vector2);
        double d2 = this.get_sin(vector2);
        if (d == 0.0) {
            if (d2 > 0.0) {
                return 90.0;
            }
            return 270.0;
        }
        if (d2 == 0.0) {
            if (d > 0.0) {
                return 0.0;
            }
            return 180.0;
        }
        double d3 = 180.0 * Math.atan(d2 / d) / Math.PI;
        if (d < 0.0) {
            d3 += 180.0;
        }
        if (d3 < 0.0) {
            d3 += 360.0;
        }
        return d3;
    }

    public Point point() {
        return new Point((int)this.x, (int)this.y);
    }

    public static double distance(int n, int n2, int n3, int n4) {
        return Math.sqrt((n3 - n) * (n3 - n) + (n4 - n2) * (n4 - n2));
    }
}

