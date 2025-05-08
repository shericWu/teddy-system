/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Vector3;
import teddy.Vertex;

class Line {
    public Vertex base;
    public Vector3 direction;

    Line() {
        this.base = new Vertex();
        this.direction = new Vector3();
    }

    Line(Vertex vertex, Vector3 vector3) {
        this.base = vertex;
        this.direction = vector3;
        this.direction.normalize();
    }

    public Vertex get_foot(Vertex vertex) {
        double d = vertex.add(this.base.reverse()).dot_product(this.direction);
        return this.base.shift(this.direction.multiple(d));
    }
}

