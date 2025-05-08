/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.Vector3;
import teddy.Vertex;

public class CoordSystem
implements Serializable {
    public Vector3 base_x;
    public Vector3 base_y;
    public Vector3 base_z;

    CoordSystem(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.base_x = vector3;
        this.base_y = vector32;
        this.base_z = vector33;
    }

    public Vertex translate(Vertex vertex) {
        double d = vertex.dot_product(this.base_x);
        double d2 = vertex.dot_product(this.base_y);
        double d3 = vertex.dot_product(this.base_z);
        return new Vertex(d, d2, d3);
    }

    public Vector3 translate(Vector3 vector3) {
        double d = vector3.dot_product(this.base_x);
        double d2 = vector3.dot_product(this.base_y);
        double d3 = vector3.dot_product(this.base_z);
        return new Vector3(d, d2, d3);
    }

    public Vertex reverse_translate(Vertex vertex) {
        Vector3 vector3 = this.base_x.multiple(vertex.x);
        Vector3 vector32 = this.base_y.multiple(vertex.y);
        Vector3 vector33 = this.base_z.multiple(vertex.z);
        return new Vertex(vector3.add(vector32).add(vector33));
    }

    public Vertex reverse_translate(double d, double d2, double d3) {
        Vector3 vector3 = this.base_x.multiple(d);
        Vector3 vector32 = this.base_y.multiple(d2);
        Vector3 vector33 = this.base_z.multiple(d3);
        return new Vertex(vector3.add(vector32).add(vector33));
    }

    public Vector3 reverse_translate(Vector3 vector3) {
        Vector3 vector32 = this.base_x.multiple(vector3.x);
        Vector3 vector33 = this.base_y.multiple(vector3.y);
        Vector3 vector34 = this.base_z.multiple(vector3.z);
        return vector32.add(vector33).add(vector34);
    }
}

