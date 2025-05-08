/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;
import teddy.CoordSystem;
import teddy.Generate;
import teddy.Geometry2D;
import teddy.LinkedList;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Queue;
import teddy.ReTessellation;
import teddy.Scene;
import teddy.TrEdge;
import teddy.TrVertex;
import teddy.Triangle;
import teddy.Vector2;
import teddy.Vertex;
import teddy.Vertex2D;

class Trianglation2D {
    public static Vector vertices;
    public static Vector edges;
    public static Vector triangles;
    public static Queue queue_of_segments;
    public static Queue queue_of_triangles;
    private static double MIN_EDGE_LENGTH;

    private static void check_flip(TrEdge trEdge) {
        TrVertex trVertex;
        if (trEdge.left_triangle == null || trEdge.right_triangle == null) {
            return;
        }
        TrVertex trVertex2 = (TrVertex)trEdge.start;
        TrVertex trVertex3 = (TrVertex)trEdge.end;
        TrVertex trVertex4 = trEdge.left_triangle.get_opposite_vertex(trEdge);
        if (Geometry2D.left_side(trVertex4, trVertex2, trVertex = trEdge.right_triangle.get_opposite_vertex(trEdge)) && Trianglation2D.cos(trVertex2, trVertex3, trVertex4) > Trianglation2D.cos(trVertex2, trVertex, trVertex4)) {
            trEdge.left_triangle.destroy();
            trEdge.right_triangle.destroy();
            triangles.addElement(new Triangle(trVertex2, trVertex, trVertex4));
            triangles.addElement(new Triangle(trVertex3, trVertex4, trVertex));
            Trianglation2D.check_flip(trVertex2.shared_edge(trVertex4));
            Trianglation2D.check_flip(trVertex2.shared_edge(trVertex));
            Trianglation2D.check_flip(trVertex3.shared_edge(trVertex4));
            Trianglation2D.check_flip(trVertex3.shared_edge(trVertex));
            Trianglation2D.check_encroached(trVertex4.shared_edge(trVertex));
        }
    }

    public static void trianglate_from_stroke(LinkedList linkedList) {
        linkedList.append(linkedList.head());
        linkedList = Generate.normalize_Point_list(linkedList, (int)MIN_EDGE_LENGTH);
        linkedList.remove(linkedList.head());
        vertices = new Vector();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            vertices.addElement(new TrVertex((Point)enumeration.nextElement(), true));
        }
        Trianglation2D.trianglate();
    }

    public static void trianglate() {
        Object object;
        edges = new Vector();
        triangles = new Vector();
        int n = 0;
        while (n < vertices.size() - 1) {
            object = (TrVertex)vertices.elementAt(n);
            TrVertex trVertex = (TrVertex)vertices.elementAt(n + 1);
            edges.addElement(new TrEdge((TrVertex)object, trVertex, true));
            ++n;
        }
        edges.addElement(new TrEdge((TrVertex)vertices.elementAt(vertices.size() - 1), (TrVertex)vertices.elementAt(0), true));
        Trianglation2D.constraint_delauny_trianglate(vertices);
        queue_of_segments = new Queue();
        queue_of_triangles = new Queue();
        n = 0;
        while (n < edges.size()) {
            Trianglation2D.check_encroached((TrEdge)edges.elementAt(n));
            ++n;
        }
        n = 0;
        while (queue_of_segments.size() > 0) {
            object = (TrEdge)queue_of_segments.pop();
            if (!((TrEdge)object).destroyed) {
                Trianglation2D.divide_edge((TrEdge)object);
            }
            if (++n > 500) break;
        }
    }

    public static Scene rearrange_scene() {
        Scene scene = new Scene();
        Trianglation2D.rearrange();
        Enumeration enumeration = edges.elements();
        while (enumeration.hasMoreElements()) {
            TrEdge trEdge = (TrEdge)enumeration.nextElement();
            Generate.add_segment(scene, trEdge.start, trEdge.end);
        }
        return scene;
    }

    private static void check_encroached(TrEdge trEdge) {
        if (Trianglation2D.encroached(trEdge)) {
            queue_of_segments.push(trEdge);
        }
    }

    Trianglation2D() {
    }

    public static Polygon2 generate_simple_patch(Polyhedron polyhedron, LinkedList linkedList, CoordSystem coordSystem) {
        Serializable serializable;
        Vertex vertex;
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex vertex2 = vertex = (Vertex)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            serializable = (Vertex)enumeration.nextElement();
            linkedList2.append(vertex.get_shared_edge((Vertex)serializable));
            if (vertex.same_position((Vertex)serializable)) {
                System.out.println("T2D.generate_smooth_patch() overlapping vertex");
            }
            vertex = serializable;
        }
        linkedList2.append(vertex.get_shared_edge(vertex2));
        serializable = new Polygon2(linkedList2);
        polyhedron.append((Polygon2)serializable);
        return serializable;
    }

    public static void rearrange() {
        TrVertex trVertex;
        Vertex2D[] vertex2DArray = new Vertex2D[vertices.size()];
        int n = 0;
        while (n < vertices.size()) {
            trVertex = (TrVertex)vertices.elementAt(n);
            if (!trVertex.external) {
                Vertex2D vertex2D = Trianglation2D.get_center(trVertex);
                Vector2 vector2 = new Vector2(trVertex, vertex2D);
                vertex2DArray[n] = trVertex.translate(vector2.multiple(0.5));
            } else {
                vertex2DArray[n] = trVertex;
            }
            ++n;
        }
        n = 0;
        while (n < vertices.size()) {
            trVertex = (TrVertex)vertices.elementAt(n);
            trVertex.warp(vertex2DArray[n]);
            ++n;
        }
    }

    public static void generate_smooth_patch(Polyhedron polyhedron, LinkedList linkedList, CoordSystem coordSystem) {
        Object object;
        TrVertex trVertex;
        vertices = new Vector();
        Vector<TrVertex> vector = new Vector<TrVertex>();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Vertex vertex = (Vertex)enumeration.nextElement();
            Vertex vertex2 = coordSystem.translate(vertex);
            trVertex = new TrVertex(vertex2, true, vertex);
            vertices.addElement(trVertex);
            vector.addElement(trVertex);
        }
        double d = 0.0;
        enumeration = vector.elements();
        TrVertex trVertex2 = trVertex = (TrVertex)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            TrVertex trVertex3 = (TrVertex)enumeration.nextElement();
            d += Vector2.distance(trVertex, trVertex3);
            trVertex = trVertex3;
        }
        MIN_EDGE_LENGTH = (d += Vector2.distance(trVertex, trVertex2)) / (double)linkedList.size() * 2.0;
        Trianglation2D.trianglate();
        int n = 0;
        do {
            Trianglation2D.rearrange();
        } while (++n < 5);
        enumeration = vertices.elements();
        while (enumeration.hasMoreElements()) {
            TrVertex trVertex4 = (TrVertex)enumeration.nextElement();
            if (trVertex4.external) continue;
            trVertex4.set_height_slope(vector, coordSystem);
            trVertex4.original = coordSystem.reverse_translate(trVertex4.x, trVertex4.y, trVertex4.height);
            polyhedron.append(trVertex4.original);
        }
        enumeration = edges.elements();
        while (enumeration.hasMoreElements()) {
            TrEdge trEdge = (TrEdge)enumeration.nextElement();
            Vertex vertex = ((TrVertex)trEdge.start).original;
            object = ((TrVertex)trEdge.end).original;
            trEdge.original = polyhedron.get_edge_array(vertex, (Vertex)object);
        }
        Vector<Vertex> vector2 = new Vector<Vertex>();
        int n2 = 0;
        while (n2 < vertices.size()) {
            object = (TrVertex)vertices.elementAt(n2);
            vector2.addElement(((TrVertex)object).original);
            ++n2;
        }
        ReTessellation.smooth(vector2);
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            Triangle triangle = (Triangle)enumeration.nextElement();
            polyhedron.append(new Polygon2(triangle.original_edges()));
        }
    }

    private static void divide_edge(TrEdge trEdge) {
        TrVertex trVertex = new TrVertex(trEdge.mid_point());
        vertices.addElement(trVertex);
        if (trEdge.external) {
            trVertex.external = true;
        }
        TrVertex trVertex2 = (TrVertex)trEdge.start;
        TrVertex trVertex3 = (TrVertex)trEdge.end;
        Trianglation2D.divide_edge_sub(trEdge, trVertex, trEdge.left_triangle, trVertex2, trVertex3);
        Trianglation2D.divide_edge_sub(trEdge, trVertex, trEdge.right_triangle, trVertex3, trVertex2);
        Trianglation2D.check_encroached(trVertex.shared_edge(trVertex2));
        Trianglation2D.check_encroached(trVertex.shared_edge(trVertex3));
    }

    public static Scene generate_scene(LinkedList linkedList) {
        Scene scene = new Scene();
        Trianglation2D.trianglate_from_stroke(linkedList);
        Enumeration enumeration = edges.elements();
        while (enumeration.hasMoreElements()) {
            TrEdge trEdge = (TrEdge)enumeration.nextElement();
            Generate.add_segment(scene, trEdge.start, trEdge.end);
        }
        return scene;
    }

    private static boolean encroached(TrEdge trEdge) {
        return !trEdge.external && !(trEdge.length() < MIN_EDGE_LENGTH * 1.8);
    }

    private static boolean encroached_sub(TrEdge trEdge, Triangle triangle) {
        if (triangle == null) {
            return false;
        }
        TrVertex trVertex = triangle.get_opposite_vertex(trEdge);
        return new Vector2(trVertex, trEdge.start).cos(new Vector2(trVertex, trEdge.end)) < 0.0;
    }

    public static void constraint_delauny_trianglate(Vector vector) {
        if (vector.size() == 3) {
            triangles.addElement(new Triangle((TrVertex)vector.elementAt(0), (TrVertex)vector.elementAt(1), (TrVertex)vector.elementAt(2)));
            return;
        }
        int n = vector.size();
        TrVertex trVertex = (TrVertex)vector.elementAt(0);
        TrVertex trVertex2 = (TrVertex)vector.elementAt(1);
        double d = 2.0;
        TrVertex trVertex3 = null;
        int n2 = -100;
        int n3 = 2;
        while (n3 < n) {
            double d2;
            TrVertex trVertex4 = (TrVertex)vector.elementAt(n3);
            if (Geometry2D.left_side(trVertex, trVertex2, trVertex4) && (d2 = new Vector2(trVertex4, trVertex).get_cos(new Vector2(trVertex4, trVertex2))) < d) {
                d = d2;
                trVertex3 = trVertex4;
                n2 = n3;
            }
            ++n3;
        }
        if (trVertex3 == null) {
            System.out.println("Trianglation2D.constraint_delauny_trianglation(), closest_v == null");
        }
        triangles.addElement(new Triangle(trVertex, trVertex2, trVertex3));
        if (n2 > 2) {
            Vector vector2 = new Vector();
            int n4 = 1;
            while (n4 <= n2) {
                vector2.addElement(vector.elementAt(n4));
                ++n4;
            }
            Trianglation2D.constraint_delauny_trianglate(vector2);
        }
        if (n2 < n - 1) {
            Vector vector3 = new Vector();
            vector3.addElement(vector.elementAt(0));
            int n5 = n2;
            while (n5 <= n - 1) {
                vector3.addElement(vector.elementAt(n5));
                ++n5;
            }
            Trianglation2D.constraint_delauny_trianglate(vector3);
        }
    }

    public static void rearrange3D() {
        TrVertex trVertex;
        Vertex[] vertexArray = new Vertex[vertices.size()];
        int n = 0;
        while (n < vertices.size()) {
            trVertex = (TrVertex)vertices.elementAt(n);
            Vertex vertex = trVertex.original;
            if (!trVertex.external) {
                LinkedList linkedList = vertex.get_sorrounding_vertices();
                vertexArray[n] = ReTessellation.to_the_center(linkedList, vertex, 0.5);
            } else {
                vertexArray[n] = vertex;
            }
            ++n;
        }
        n = 0;
        while (n < vertices.size()) {
            trVertex = (TrVertex)vertices.elementAt(n);
            trVertex.original.warp(vertexArray[n]);
            ++n;
        }
    }

    static {
        MIN_EDGE_LENGTH = 40.0;
    }

    public static Vertex2D get_center(TrVertex trVertex) {
        Vertex2D vertex2D = new Vertex2D(0.0, 0.0);
        int n = 0;
        while (n < trVertex.edges.size()) {
            TrEdge trEdge = (TrEdge)trVertex.edges.elementAt(n);
            vertex2D.add_self(trEdge.get_the_other_vertex(trVertex));
            ++n;
        }
        return new Vertex2D(vertex2D.multiple(1.0 / (double)trVertex.edges.size()));
    }

    private static void divide_edge_sub(TrEdge trEdge, TrVertex trVertex, Triangle triangle, TrVertex trVertex2, TrVertex trVertex3) {
        if (triangle == null) {
            return;
        }
        TrVertex trVertex4 = triangle.get_opposite_vertex(trEdge);
        triangle.destroy();
        triangles.addElement(new Triangle(trVertex2, trVertex, trVertex4));
        triangles.addElement(new Triangle(trVertex, trVertex3, trVertex4));
        Trianglation2D.check_flip(trVertex4.shared_edge(trVertex2));
        Trianglation2D.check_flip(trVertex4.shared_edge(trVertex3));
        Trianglation2D.check_encroached(trVertex.shared_edge(trVertex4));
    }

    private static double cos(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex2D vertex2D3) {
        return new Vector2(vertex2D2, vertex2D).cos(new Vector2(vertex2D2, vertex2D3));
    }
}

