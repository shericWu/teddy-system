/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Edge;
import teddy.Vector3;
import teddy.Vertex;

class Surface {
    public Vertex base;
    public Vector3 normal;

    public Vertex cross_point(Edge edge) {
        double d = this.signed_distance(edge.start);
        double d2 = this.signed_distance(edge.end);
        double d3 = d - d2;
        return new Vertex(edge.start.add(edge.vector3().multiple(d / d3)));
    }

    Surface() {
        this.base = new Vertex();
        this.normal = new Vector3();
    }

    Surface(Vertex vertex, Vector3 vector3) {
        this.base = vertex;
        this.normal = vector3;
        this.normal.normalize();
    }

    Surface(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        Vector3 vector3 = new Vector3(vertex, vertex2);
        Vector3 vector32 = new Vector3(vertex, vertex3);
        this.normal = vector3.cross_product(vector32);
        this.base = vertex;
        this.normal.normalize();
    }

    public double angle(Vector3 vector3) {
        double d = this.normal.get_relative_angle(vector3);
        return Math.abs(d - 1.5707963267948966);
    }

    public static Surface get_normal_surface(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        Vector3 vector3 = new Vector3(vertex, vertex2);
        Vector3 vector32 = new Vector3(vertex2, vertex3);
        vector3.normalize();
        vector32.normalize();
        return new Surface(vertex2, vector3.add(vector32));
    }

    public double signed_distance(Vertex vertex) {
        Vector3 vector3 = new Vector3(this.base, vertex);
        return this.normal.dot_product(vector3);
    }

    public double distance(Vertex vertex) {
        Vector3 vector3 = new Vector3(this.base, vertex);
        return Math.abs(this.normal.dot_product(vector3));
    }
}

