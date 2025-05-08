/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.Generate;
import teddy.LinkedList;
import teddy.Objects;
import teddy.Vector3;
import teddy.Vertex;

class Ring
extends LinkedList {
    Ring(LinkedList linkedList) {
        this();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Objects objects = (Objects)enumeration.nextElement();
            this.append((Vertex)objects.get(1));
        }
    }

    Ring() {
    }

    public static Ring linked_list_to_ring(LinkedList linkedList) {
        Ring ring = new Ring();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            ring.append(enumeration.nextElement());
        }
        return ring;
    }

    public static Ring sweep(Ring ring, Vertex vertex, Vertex vertex2, Vertex vertex3, Vertex vertex4, Vector3 vector3) {
        Ring ring2 = new Ring();
        Vector3 vector32 = new Vector3(vertex, vertex2);
        Vector3 vector33 = vector32.cross_product(vector3);
        Vector3 vector34 = vector32.cross_product(vector33);
        Vector3 vector35 = new Vector3(vertex3, vertex4);
        Vector3 vector36 = vector33;
        Vector3 vector37 = vector35.cross_product(vector36);
        double d = vector35.length() / vector32.length();
        vector32.normalize();
        vector33.normalize();
        vector34.normalize();
        vector35.normalize();
        vector36.normalize();
        vector37.normalize();
        Enumeration enumeration = ring.elements();
        while (enumeration.hasMoreElements()) {
            Vertex vertex5 = ((Vertex)enumeration.nextElement()).copy();
            Vector3 vector38 = new Vector3(vertex, vertex5);
            double d2 = vector32.dot_product(vector38);
            double d3 = vector33.dot_product(vector38);
            double d4 = vector34.dot_product(vector38);
            Vector3 vector39 = new Vector3(0.0, 0.0, 0.0);
            vector39.add_self(vector35.multiple(d2 * d));
            vector39.add_self(vector36.multiple(d3 * d));
            vector39.add_self(vector37.multiple(d4 * d));
            Vertex vertex6 = vertex3.shift(vector39);
            ring2.append(vertex6);
        }
        ring2 = Ring.linked_list_to_ring(Generate.reduce_Vertex_list(ring2));
        ring2.replace_tail(ring2.head());
        return ring2;
    }
}

