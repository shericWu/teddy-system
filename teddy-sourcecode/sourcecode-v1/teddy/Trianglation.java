/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Vector3;
import teddy.Vertex;

class Trianglation {
    private static Polyhedron h;
    public static LinkedList triangles;
    public static LinkedList edges;
    public static Vector3 normal;

    /*
     * Unable to fully structure code
     */
    public static void trianglate(Polyhedron var0) {
        Trianglation.h = var0;
        var1_1 = 0;
        ** GOTO lbl8
        {
            Trianglation.trianglate(Trianglation.h, Trianglation.h.polygons[var1_1]);
            do {
                if (Trianglation.h.polygons[var1_1].n_edges > 3) continue block0;
                ++var1_1;
lbl8:
                // 2 sources

            } while (var1_1 < Trianglation.h.n_polygons);
        }
        Trianglation.h.set_parameters();
    }

    public static void trianglate(Polyhedron polyhedron, Polygon2 polygon2) {
        Edge edge;
        int n;
        LinkedList linkedList;
        Serializable serializable;
        if (polygon2.n_edges == 3) {
            return;
        }
        h = polyhedron;
        normal = polygon2.calc_normal();
        int n2 = polygon2.n_edges;
        Vertex vertex = polygon2.get_vertex(0);
        Vertex vertex2 = polygon2.get_vertex(1);
        double d = 2.0;
        Serializable serializable2 = null;
        int n3 = -100;
        int n4 = 2;
        while (n4 < n2) {
            double d2;
            serializable = polygon2.get_vertex(n4);
            if (Trianglation.left_side(vertex, vertex2, serializable) && (d2 = new Vector3((Vertex)serializable, vertex).get_cos(new Vector3((Vertex)serializable, vertex2))) < d) {
                d = d2;
                serializable2 = serializable;
                n3 = n4;
            }
            ++n4;
        }
        h.remove(polygon2);
        Polygon2 polygon22 = null;
        Polygon2 polygon23 = null;
        if (n3 > 2) {
            serializable = new Edge(vertex2, (Vertex)serializable2);
            h.append((Edge)serializable);
            linkedList = new LinkedList();
            n = 1;
            while (n < n3) {
                linkedList.append(polygon2.edges(n));
                ++n;
            }
            linkedList.append(serializable);
            polygon23 = new Polygon2(linkedList);
            h.append(polygon23);
        } else {
            serializable = vertex2.get_shared_edge((Vertex)serializable2);
        }
        if (n3 < n2 - 1) {
            edge = new Edge(vertex, (Vertex)serializable2);
            h.append(edge);
            linkedList = new LinkedList();
            n = n3;
            while (n < n2) {
                linkedList.append(polygon2.edges(n));
                ++n;
            }
            linkedList.append(edge);
            polygon22 = new Polygon2(linkedList);
            h.append(polygon22);
        } else {
            edge = vertex.get_shared_edge((Vertex)serializable2);
        }
        h.append(new Polygon2(polygon2.edges(0), (Edge)serializable, edge));
        if (polygon23 != null) {
            Trianglation.trianglate(h, polygon23);
        }
        if (polygon22 != null) {
            Trianglation.trianglate(h, polygon22);
        }
    }

    public static boolean left_side(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        if (vertex == vertex3 || vertex2 == vertex3) {
            return true;
        }
        Vector3 vector3 = new Vector3(vertex, vertex2);
        Vector3 vector32 = new Vector3(vertex, vertex3);
        return vector3.cross_product(vector32).dot_product(normal) >= 0.0;
    }

    Trianglation() {
    }
}

