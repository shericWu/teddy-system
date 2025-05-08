/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import java.util.Vector;
import teddy.LinkedList;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Vector3;
import teddy.Vertex;

class ReTessellation {
    private static Polyhedron h;

    private static Vertex get_gravity_center(LinkedList linkedList) {
        Vertex vertex = new Vertex();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            vertex.add_self((Vertex)enumeration.nextElement());
        }
        return new Vertex(vertex.multiple(1.0 / (double)linkedList.size()));
    }

    public static Vertex to_sum_of_vectors(LinkedList linkedList, Vertex vertex, double d) {
        Vector3 vector3 = new Vector3(0.0, 0.0, 0.0);
        double d2 = 0.0;
        Object object = linkedList.elements();
        while (object.hasMoreElements()) {
            Vertex vertex2 = (Vertex)object.nextElement();
            Vector3 vector32 = new Vector3(vertex, vertex2);
            double d3 = 1.0 / vector32.length();
            vector3.add_self(vector32.multiple(d3));
            d2 += d3;
        }
        vector3.multiple_self(1.0 / d2);
        object = new Vertex(vertex.add(vector3.multiple(d)));
        return object;
    }

    ReTessellation() {
    }

    public static void smooth5(Polyhedron polyhedron) {
        int n = 0;
        do {
            ReTessellation.smooth_sub(polyhedron, 0.63139836);
            ReTessellation.smooth_sub(polyhedron, -0.6739516);
        } while (++n < 5);
    }

    public static void smooth(Polyhedron polyhedron) {
        ReTessellation.smooth_sub(polyhedron, 0.63139836);
        ReTessellation.smooth_sub(polyhedron, -0.6739516);
        polyhedron.set_parameters();
    }

    public static void smooth(Vector vector) {
        int n = 0;
        do {
            ReTessellation.smooth_sub(vector, 0.63139836);
            ReTessellation.smooth_sub(vector, -0.6739516);
        } while (++n < 5);
    }

    public static Vertex to_the_center(LinkedList linkedList, Vertex vertex, double d) {
        Vertex vertex2 = ReTessellation.get_gravity_center(linkedList);
        Vector3 vector3 = new Vector3(vertex, vertex2);
        Vertex vertex3 = new Vertex(vertex.add(vector3.multiple(d)));
        return vertex3;
    }

    public static void retessellate(Polyhedron polyhedron) {
        Vertex[] vertexArray = new Vertex[polyhedron.n_vertices];
        int n = 0;
        while (n < polyhedron.n_vertices) {
            Vertex vertex = polyhedron.vertices[n];
            LinkedList linkedList = vertex.get_sorrounding_vertices();
            vertexArray[n] = ReTessellation.horizontal_shift(linkedList, vertex);
            ++n;
        }
        n = 0;
        while (n < polyhedron.n_vertices) {
            polyhedron.vertices[n].warp(vertexArray[n]);
            ++n;
        }
        polyhedron.set_parameters();
    }

    public static void smooth_sub(Polyhedron polyhedron, double d) {
        Vertex[] vertexArray = new Vertex[polyhedron.n_vertices];
        int n = 0;
        while (n < polyhedron.n_vertices) {
            Vertex vertex = polyhedron.vertices[n];
            LinkedList linkedList = vertex.get_sorrounding_vertices();
            vertexArray[n] = ReTessellation.to_sum_of_vectors(linkedList, vertex, d);
            ++n;
        }
        n = 0;
        while (n < polyhedron.n_vertices) {
            polyhedron.vertices[n].warp(vertexArray[n]);
            ++n;
        }
    }

    public static void smooth_sub(Vector vector, double d) {
        Vertex[] vertexArray = new Vertex[vector.size()];
        int n = 0;
        while (n < vector.size()) {
            Vertex vertex = (Vertex)vector.elementAt(n);
            LinkedList linkedList = vertex.get_sorrounding_vertices();
            vertexArray[n] = ReTessellation.to_sum_of_vectors(linkedList, vertex, d);
            ++n;
        }
        n = 0;
        while (n < vector.size()) {
            ((Vertex)vector.elementAt(n)).warp(vertexArray[n]);
            ++n;
        }
    }

    private static Vector3 get_normal(LinkedList linkedList, Vertex vertex) {
        Vector3 vector3;
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            linkedList2.append(new Vector3((Vertex)enumeration.nextElement(), vertex));
        }
        enumeration = linkedList2.elements();
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        while (enumeration.hasMoreElements()) {
            vector3 = (Vector3)enumeration.nextElement();
            d += vector3.x * vector3.y;
            d2 += vector3.y * vector3.z;
            d3 += vector3.z * vector3.x;
            d4 += vector3.x * vector3.x;
            d5 += vector3.y * vector3.y;
            d6 += vector3.z * vector3.z;
        }
        vector3 = new Vector3(d6 * d5 - d2 * d2, d * d2 - d * d6, d * d2 - d3 * d5);
        return vector3.get_normalized();
    }

    private static Vector3 get_averaged_normal(LinkedList linkedList) {
        Vertex vertex = new Vertex();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            vertex.add_self(((Polygon2)enumeration.nextElement()).normal);
        }
        Vector3 vector3 = vertex.multiple(1.0 / (double)linkedList.size());
        return vector3.get_normalized();
    }

    private static Vertex horizontal_shift(LinkedList linkedList, Vertex vertex) {
        Vertex vertex2 = ReTessellation.get_gravity_center(linkedList);
        Vector3 vector3 = ReTessellation.get_averaged_normal(vertex.polygons());
        Vector3 vector32 = new Vector3(vertex2, vertex);
        Vertex vertex3 = new Vertex(vertex2.add(vector3.multiple(vector32.length())));
        Vector3 vector33 = new Vector3(vertex, vertex3);
        Vertex vertex4 = new Vertex(vertex.add(vector33.multiple(0.5)));
        return vertex4;
    }
}

