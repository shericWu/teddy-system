/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.Point2;
import teddy.Vertex;

public class Vector3
implements Serializable {
    public double x;
    public double y;
    public double z;

    public static double distance(Vertex vertex, Vertex vertex2) {
        return Vector3.distance(vertex.x, vertex.y, vertex.z, vertex2.x, vertex2.y, vertex2.z);
    }

    public void normalize_self() {
        this.normalize();
    }

    public void normalize() {
        double d = this.length();
        this.x /= d;
        this.y /= d;
        this.z /= d;
    }

    public double dot_product(Vector3 vector3) {
        return this.x * vector3.x + this.y * vector3.y + this.z * vector3.z;
    }

    public double sin(Vector3 vector3) {
        double d = Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z) * (vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z));
        if (d > 0.0) {
            return this.cross_product(vector3).length() / d;
        }
        return 0.0;
    }

    public boolean parallel(Vector3 vector3) {
        double d = this.sin(vector3);
        return d < 0.01 && d > -0.01;
    }

    Vector3() {
    }

    Vector3(Vertex vertex, Vertex vertex2) {
        this.x = vertex2.x - vertex.x;
        this.y = vertex2.y - vertex.y;
        this.z = vertex2.z - vertex.z;
    }

    Vector3(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Vector3 add(Vector3 vector3) {
        return new Vector3(this.x + vector3.x, this.y + vector3.y, this.z + vector3.z);
    }

    public double get_cos(Vector3 vector3) {
        return this.cos(vector3);
    }

    public double get_sin(Vector3 vector3) {
        return this.sin(vector3);
    }

    public void rotate(int n, double d) {
        if (n == 0) {
            this.rotate_x(d);
            return;
        }
        if (n == 1) {
            this.rotate_y(d);
            return;
        }
        this.rotate_z(d);
    }

    public static Vertex interporate(Vertex vertex, Vertex vertex2, double d) {
        return new Vertex(vertex.x * (1.0 - d) + vertex2.x * d, vertex.y * (1.0 - d) + vertex2.y * d, vertex.z * (1.0 - d) + vertex2.z * d);
    }

    public void multiple_self(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
    }

    public void rotate_x(double d) {
        Point2 point2 = this.rotate_sub(this.y, this.z, d);
        this.y = point2.x;
        this.z = point2.y;
    }

    public Vector3 cross_product(Vector3 vector3) {
        double d = this.y * vector3.z - this.z * vector3.y;
        double d2 = this.z * vector3.x - this.x * vector3.z;
        double d3 = this.x * vector3.y - this.y * vector3.x;
        return new Vector3(d, d2, d3);
    }

    public Vector3 copyVector3() {
        return new Vector3(this.x, this.y, this.z);
    }

    public void rotate_y(double d) {
        Point2 point2 = this.rotate_sub(this.z, this.x, d);
        this.z = point2.x;
        this.x = point2.y;
    }

    public Vector3 reverse() {
        return new Vector3(-this.x, -this.y, -this.z);
    }

    public Vertex vertex() {
        return new Vertex(this.x, this.y, this.z);
    }

    public Vector3 multiple(double d) {
        return new Vector3(this.x * d, this.y * d, this.z * d);
    }

    public double get_relative_angle(Vector3 vector3) {
        double d = this.cos(vector3);
        if (d <= -1.0) {
            return Math.PI;
        }
        if (d >= 1.0) {
            return 0.0;
        }
        return Math.acos(this.cos(vector3));
    }

    public double get_angle(Vector3 vector3, Vector3 vector32) {
        double d = this.get_cos(vector3);
        double d2 = this.get_sin(vector3);
        if (this.cross_product(vector3).dot_product(vector32) < 0.0) {
            d2 *= -1.0;
        }
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

    public void add_self(Vector3 vector3) {
        this.x += vector3.x;
        this.y += vector3.y;
        this.z += vector3.z;
    }

    public void rotate_z(double d) {
        Point2 point2 = this.rotate_sub(this.x, this.y, d);
        this.x = point2.x;
        this.y = point2.y;
    }

    public Vector3 get_normalized() {
        double d = this.length();
        return new Vector3(this.x / d, this.y / d, this.z / d);
    }

    public Point2 rotate_sub(double d, double d2, double d3) {
        double d4 = Math.cos(Math.PI * d3 / 180.0);
        double d5 = Math.sin(Math.PI * d3 / 180.0);
        double d6 = d4 * d - d5 * d2;
        double d7 = d5 * d + d4 * d2;
        return new Point2(d6, d7);
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double cos(Vector3 vector3) {
        double d = Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z) * (vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z));
        if (d > 0.0) {
            return this.dot_product(vector3) / d;
        }
        return 0.0;
    }

    public static double distance(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.sqrt((d4 - d) * (d4 - d) + (d5 - d2) * (d5 - d2) + (d6 - d3) * (d6 - d3));
    }
}

