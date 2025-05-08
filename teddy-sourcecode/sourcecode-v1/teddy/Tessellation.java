/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Surface;
import teddy.Vector3;
import teddy.Vertex;

class Tessellation {
    private static Polyhedron h;

    private static void divide_an_edge(Edge edge, double d) {
        double d2 = edge.length();
        int n = (int)(d2 / d);
        Vector3 vector3 = edge.vector3();
        LinkedList linkedList = new LinkedList();
        int n2 = 1;
        while (n2 < n) {
            Vertex vertex = edge.start.shift(vector3.multiple((double)n2 / (double)n));
            linkedList.append(vertex);
            ++n2;
        }
        Enumeration enumeration = linkedList.elements();
        Vertex vertex = edge.start;
        LinkedList linkedList2 = new LinkedList();
        while (enumeration.hasMoreElements()) {
            Vertex vertex2 = (Vertex)enumeration.nextElement();
            linkedList2.append(new Edge(vertex, vertex2));
            vertex = vertex2;
        }
        linkedList2.append(new Edge(vertex, edge.end));
        h.append_vertices(linkedList);
        h.append_edges(linkedList2);
        Tessellation.divide_an_edge_sub(edge.left_polygon(), edge, edge.start, linkedList2, edge.end);
        Tessellation.divide_an_edge_sub(edge.right_polygon(), edge, edge.end, linkedList2.reverse(), edge.start);
    }

    private static boolean no_big_distortion(Vertex vertex, Vertex vertex2, Edge edge) {
        Enumeration enumeration = vertex.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge2 = (Edge)enumeration.nextElement();
            if (edge2 == edge) continue;
            Vertex vertex3 = edge2.get_the_other_vertex(vertex);
            Vector3 vector3 = new Vector3(vertex3, vertex);
            Vector3 vector32 = new Vector3(vertex3, vertex2);
            double d = Math.abs(vector3.sin(vector32));
            double d2 = vector3.cos(vector32);
            if (!(d > 0.3) && !(d2 < 0.0)) continue;
            return false;
        }
        if (Tessellation.flip_over_test(vertex, vertex2, edge)) {
            return false;
        }
        return Tessellation.polygons_are_parallel_to_edge(edge, vertex.polygons());
    }

    private static Polygon2 replaced_polygon(Polygon2 polygon2, LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        int n = 0;
        while (n < polygon2.n_edges) {
            Edge edge = polygon2.edges[n];
            linkedList2.append(Tessellation.get_corresponding_edge(edge, linkedList));
            ++n;
        }
        return new Polygon2(linkedList2);
    }

    private static Polygon2 divide_a_polygon_sub(Polygon2 polygon2, int n, Edge edge, Vertex vertex) {
        LinkedList linkedList = new LinkedList();
        while (polygon2.get_vertex(n) != vertex) {
            linkedList.append(polygon2.edges(n));
            ++n;
        }
        linkedList.append(edge);
        Polygon2 polygon22 = new Polygon2(linkedList);
        h.append(polygon22);
        return polygon22;
    }

    Tessellation() {
    }

    private static boolean flip_over_test(Vertex vertex, Vertex vertex2, Edge edge) {
        Enumeration enumeration = vertex.polygons().elements();
        while (enumeration.hasMoreElements()) {
            Vector3 vector3;
            Vector3 vector32;
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if (polygon2 == edge.left_polygon() || polygon2 == edge.right_polygon()) continue;
            Objects objects = polygon2.get_the_other_edge(vertex);
            Vector3 vector33 = new Vector3(vertex2, (Vertex)objects.get(0));
            if (vector33.parallel(vector32 = new Vector3(vertex2, (Vertex)objects.get(1)))) {
                System.out.println("Tessellation.flip");
                return true;
            }
            Vector3 vector34 = new Vector3(vertex, (Vertex)objects.get(0)).cross_product(new Vector3(vertex, (Vertex)objects.get(1)));
            if (!(vector34.cos(vector3 = vector33.cross_product(vector32)) < -0.8)) continue;
            return true;
        }
        return false;
    }

    private static boolean polygons_are_parallel_to_edge(Edge edge, LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        Vector3 vector3 = edge.vector3();
        while (enumeration.hasMoreElements()) {
            Vector3 vector32 = ((Polygon2)enumeration.nextElement()).get_normal_simple();
            double d = Math.abs(vector32.cos(vector3));
            if (!(d > 0.7)) continue;
            return false;
        }
        return true;
    }

    private static void remove_a_short_edge(Edge edge, Vertex vertex, Vertex vertex2) {
        Serializable serializable;
        Polygon2 polygon2 = edge.left_polygon();
        Polygon2 polygon22 = edge.right_polygon();
        LinkedList linkedList = vertex.polygons().copy();
        Vertex vertex3 = vertex2;
        LinkedList linkedList2 = new LinkedList();
        Tessellation.init_replacement(linkedList2, vertex2);
        Enumeration enumeration = vertex.edges.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (Edge)enumeration.nextElement();
            if (serializable == edge) continue;
            Vertex vertex4 = serializable.get_the_other_vertex(vertex);
            Tessellation.register_replacement(linkedList2, serializable, vertex3, vertex4);
        }
        h.remove(polygon2);
        h.remove(polygon22);
        enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (Polygon2)enumeration.nextElement();
            if (serializable == polygon2 || serializable == polygon22) continue;
            h.remove((Polygon2)serializable);
            Tessellation.h.current_part_index = ((Polygon2)serializable).part_index;
            h.append(Tessellation.replaced_polygon((Polygon2)serializable, linkedList2));
        }
        if (polygon2.n_edges > 3) {
            Tessellation.h.current_part_index = polygon2.part_index;
            h.append(Tessellation.replaced_polygon_special(polygon2, linkedList2, edge));
        }
        if (polygon22.n_edges > 3) {
            Tessellation.h.current_part_index = polygon22.part_index;
            h.append(Tessellation.replaced_polygon_special(polygon22, linkedList2, edge));
        }
    }

    private static void divide_an_edge_sub(Polygon2 polygon2, Edge edge, Vertex vertex, LinkedList linkedList, Vertex vertex2) {
        LinkedList linkedList2 = new LinkedList();
        linkedList2.connect(linkedList);
        int n = 0;
        while (polygon2.edges(n) != edge) {
            ++n;
        }
        ++n;
        while (polygon2.edges(n) != edge) {
            linkedList2.append(polygon2.edges(n));
            ++n;
        }
        Polygon2 polygon22 = new Polygon2(linkedList2);
        h.append(polygon22);
        h.remove(polygon2);
    }

    public static Vector remove_thin_polygons(Polyhedron polyhedron) {
        Vector<Objects> vector = new Vector<Objects>();
        h = polyhedron;
        Edge edge = null;
        int n = 0;
        while (n < Tessellation.h.n_edges) {
            Tessellation.h.edges[n].checked = false;
            ++n;
        }
        n = 0;
        while (n < Tessellation.h.n_edges) {
            if (!Tessellation.h.edges[n].checked) {
                edge = Tessellation.h.edges[n];
                edge.mid_vertex();
                edge.checked = true;
                if (Tessellation.no_big_distortion(edge.start, edge.end, edge)) {
                    Tessellation.remove_a_short_edge(edge, edge.start, edge.end);
                    vector.addElement(new Objects(edge.start, edge.end));
                    n = 0;
                } else if (Tessellation.no_big_distortion(edge.end, edge.start, edge)) {
                    Tessellation.remove_a_short_edge(edge, edge.end, edge.start);
                    vector.addElement(new Objects(edge.end, edge.start));
                    n = 0;
                }
            }
            ++n;
        }
        return vector;
    }

    public static void tessellate_a_polygon(Polygon2 polygon2) {
        int n = polygon2.get_concave_vertex_index();
        if (n != -1) {
            Tessellation.tessellate_a_polygon(polygon2, n);
        }
    }

    public static void adjust_polygon_size(Polyhedron polyhedron, LinkedList linkedList, double d) {
        h = polyhedron;
        d *= 2.0;
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            if (!(edge.length() > d)) continue;
            Tessellation.divide_an_edge(edge, d);
        }
    }

    private static void tessellate_a_polygon(Polygon2 polygon2, int n) {
        Tessellation.h.current_part_index = polygon2.part_index;
        if (polygon2.n_edges == 3) {
            System.out.println("clashed polygon (Tessellation.tessellate)");
            Draw3DScene.current_polygon = polygon2;
            return;
        }
        Vertex vertex = polygon2.get_vertex(n);
        Vertex vertex2 = polygon2.get_vertex(n - 1);
        Vertex vertex3 = polygon2.get_vertex(n + 1);
        Surface.get_normal_surface(vertex2, vertex, vertex3);
        Vector3 vector3 = new Vector3(vertex2, vertex);
        Vector3 vector32 = new Vector3(vertex, vertex3);
        vector3.normalize();
        vector32.normalize();
        Vector3 vector33 = vector3.add(vector32);
        Vector3 vector34 = polygon2.normal.cross_product(vector33);
        int n2 = n + 2;
        Vertex vertex4 = polygon2.get_vertex(n2);
        double d = vector34.cos(new Vector3(vertex, vertex4));
        int n3 = n + 3;
        while (n3 < polygon2.n_edges + n - 1) {
            Vertex vertex5 = polygon2.get_vertex(n3);
            new Vector3(vertex, vertex5);
            double d2 = vector34.cos(new Vector3(vertex, vertex5));
            if (d < d2) {
                d = d2;
                vertex4 = vertex5;
                n2 = n3;
            }
            ++n3;
        }
        Tessellation.divide_a_polygon(polygon2, n, n2);
    }

    private static Edge get_corresponding_edge(Edge edge, LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Objects objects = (Objects)enumeration.nextElement();
            Edge edge2 = (Edge)objects.get(0);
            if (edge != edge2) continue;
            return (Edge)objects.get(1);
        }
        return edge;
    }

    public static void tessellate(Polyhedron polyhedron) {
        h = polyhedron;
        Polygon2 polygon2 = null;
        int n = Tessellation.h.n_polygons;
        Polygon2[] polygon2Array = (Polygon2[])Tessellation.h.polygons.clone();
        int n2 = 0;
        while (n2 < n) {
            polygon2 = polygon2Array[n2];
            int n3 = polygon2.get_concave_vertex_index();
            if (n3 != -1) {
                Tessellation.tessellate_a_polygon(polygon2, n3);
            }
            ++n2;
        }
    }

    private static void init_replacement(LinkedList linkedList, Vertex vertex) {
        Enumeration enumeration = vertex.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            Objects objects = new Objects(edge, edge);
            linkedList.append(objects);
        }
    }

    private static void register_replacement(LinkedList linkedList, Edge edge, Vertex vertex, Vertex vertex2) {
        Serializable serializable;
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (Objects)enumeration.nextElement();
            Edge edge2 = (Edge)((Objects)serializable).get(1);
            if (!edge2.same_edge(vertex, vertex2)) continue;
            Objects objects = new Objects(edge, edge2);
            linkedList.append(objects);
            if (edge.sharp) {
                edge2.set_sharp(true);
            }
            return;
        }
        serializable = new Edge(vertex, vertex2);
        h.append((Edge)serializable);
        if (edge.sharp) {
            ((Edge)serializable).set_sharp(true);
        }
        linkedList.append(new Objects(edge, serializable));
    }

    private static Polygon2 replaced_polygon_special(Polygon2 polygon2, LinkedList linkedList, Edge edge) {
        LinkedList linkedList2 = new LinkedList();
        int n = 0;
        while (n < polygon2.n_edges) {
            Edge edge2 = polygon2.edges[n];
            if (edge2 != edge) {
                linkedList2.append(Tessellation.get_corresponding_edge(edge2, linkedList));
            }
            ++n;
        }
        return new Polygon2(linkedList2);
    }

    private static void divide_a_polygon(Polygon2 polygon2, int n, int n2) {
        Vertex vertex = polygon2.get_vertex(n);
        Vertex vertex2 = polygon2.get_vertex(n2);
        Edge edge = new Edge(vertex2, vertex);
        Polygon2 polygon22 = Tessellation.divide_a_polygon_sub(polygon2, n, edge, vertex2);
        Polygon2 polygon23 = Tessellation.divide_a_polygon_sub(polygon2, n2, edge, vertex);
        h.append(edge);
        h.remove(polygon2);
        Tessellation.tessellate_a_polygon(polygon22);
        Tessellation.tessellate_a_polygon(polygon23);
    }
}

