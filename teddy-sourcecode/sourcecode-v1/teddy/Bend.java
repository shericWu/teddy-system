/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.io.Serializable;
import java.util.Enumeration;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Edge2D;
import teddy.Generate;
import teddy.LinkedList;
import teddy.Polyhedron;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Bend {
    protected static Polyhedron h;

    public static void bend_main(LinkedList linkedList, LinkedList linkedList2) {
        Serializable serializable;
        Edge2D[] edge2DArray = Bend.stroke_to_edge2Ds(linkedList);
        Edge2D[] edge2DArray2 = Bend.stroke_to_edge2Ds(linkedList2);
        int n = linkedList.size();
        System.out.println("n" + n);
        int n2 = 0;
        while (n2 < Bend.h.n_vertices) {
            serializable = Bend.h.vertices[n2];
            serializable.warp(Bend.warp_for_edges(n, edge2DArray, edge2DArray2, serializable));
            ++n2;
        }
        Enumeration enumeration = Bend.h.surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (SurfaceLine)enumeration.nextElement();
            ((Edge)serializable).start.warp(Bend.warp_for_edges(n, edge2DArray, edge2DArray2, ((Edge)serializable).start));
            ((Edge)serializable).end.warp(Bend.warp_for_edges(n, edge2DArray, edge2DArray2, ((Edge)serializable).end));
        }
        h.set_parameters();
    }

    public static void bend(LinkedList linkedList, LinkedList linkedList2, Polyhedron polyhedron) {
        Teddy.teddy.play_sound("pop.au");
        linkedList = Generate.renumber_Point_list(20, linkedList);
        linkedList2 = Generate.renumber_Point_list(20, linkedList2);
        h = polyhedron;
        LinkedList linkedList3 = Bend.stroke_to_vertex2D_list(linkedList);
        LinkedList linkedList4 = Bend.stroke_to_vertex2D_list(linkedList2);
        Bend.bend_main(linkedList3, linkedList4);
    }

    Bend() {
    }

    private static Edge2D[] stroke_to_edge2Ds(LinkedList linkedList) {
        int n = linkedList.size();
        Edge2D[] edge2DArray = new Edge2D[n];
        Vertex2D vertex2D = (Vertex2D)linkedList.nextElement();
        int n2 = 0;
        while (n2 < n - 1) {
            Vertex2D vertex2D2 = (Vertex2D)linkedList.nextElement();
            edge2DArray[n2] = new Edge2D(vertex2D, vertex2D2);
            vertex2D = vertex2D2;
            ++n2;
        }
        return edge2DArray;
    }

    public static Vector3 warp_for_edges(int n, Edge2D[] edge2DArray, Edge2D[] edge2DArray2, Vertex vertex) {
        Vertex2D vertex2D = new Vertex2D(vertex.x, vertex.z);
        double[] dArray = new double[n];
        double d = 0.0;
        Vector3 vector3 = new Vector3(0.0, 0.0, 0.0);
        int n2 = 0;
        while (n2 < n - 1) {
            double d2 = edge2DArray[n2].distance_as_a_segment(vertex2D);
            dArray[n2] = 1.0 / (1.0E-4 + d2 * d2 * d2);
            d += dArray[n2];
            Vertex vertex2 = Bend.warp_for_an_edge(edge2DArray[n2], edge2DArray2[n2], vertex);
            vector3 = vector3.add(vertex2.multiple(dArray[n2]));
            ++n2;
        }
        vector3 = vector3.multiple(1.0 / d);
        return vector3;
    }

    public static LinkedList stroke_to_vertex2D_list(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Point point = (Point)enumeration.nextElement();
            linkedList2.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y)));
        }
        return linkedList2;
    }

    public static Vertex warp_for_an_edge(Edge2D edge2D, Edge2D edge2D2, Vertex vertex) {
        Vertex2D vertex2D = new Vertex2D(vertex.x, vertex.z);
        Vector2 vector2 = edge2D.vector2().get_normalized();
        Vector2 vector22 = vector2.rotate90().get_normalized();
        Vector2 vector23 = edge2D2.vector2().get_normalized();
        Vector2 vector24 = vector23.rotate90().get_normalized();
        Vector2 vector25 = new Vector2(edge2D.start, vertex2D);
        double d = vector2.dot_product(vector25) * (edge2D2.length() / edge2D.length());
        double d2 = vector22.dot_product(vector25);
        Vector2 vector26 = vector23.multiple(d).add(vector24.multiple(d2));
        Vertex2D vertex2D2 = edge2D2.start.translate(vector26);
        return new Vertex(vertex2D2.x, vertex.y, vertex2D2.y);
    }
}

