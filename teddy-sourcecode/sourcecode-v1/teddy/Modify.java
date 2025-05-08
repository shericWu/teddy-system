/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Teddy;
import teddy.Vector3;
import teddy.Vertex;

public class Modify {
    public static Teddy teddy;
    protected static Polyhedron h;
    public static LinkedList temp_polygons;
    public static PolygonReplaceManager polygon_replace_manager;
    public static boolean section_is_sharp;

    public static void remove_broken_polygons() {
        Edge edge;
        while ((edge = Modify.find_broken_edge()) != null) {
            Polygon2 polygon2 = edge.left_polygon() != null ? edge.left_polygon() : edge.right_polygon();
            Modify.remove_broken_polygons(edge, polygon2);
        }
        return;
    }

    protected static void remove_broken_polygons(Edge edge, Polygon2 polygon2) {
        h.remove(polygon2);
        int n = 0;
        while (n < polygon2.n_edges) {
            Polygon2 polygon22;
            Edge edge2 = polygon2.edges[n];
            if (edge2 != edge && (polygon22 = edge2.get_another_polygon(null)) != null) {
                Modify.remove_broken_polygons(edge2, polygon22);
            }
            ++n;
        }
    }

    public static LinkedList divide_a_polygon_around(Polygon2 polygon2, Vertex vertex, Edge edge, Vertex vertex2, Edge edge2) {
        LinkedList linkedList = new LinkedList();
        if (!polygon2.contains(edge)) {
            System.out.println("prev_edge not contained (dividing_a_polygon_around)");
            return linkedList;
        }
        if (!polygon2.contains(edge2)) {
            return linkedList;
        }
        int n = polygon2.get_edge_index(edge) + 1;
        Edge edge3 = h.get_edge_array(vertex, polygon2.get_vertex(n));
        linkedList.append(edge3);
        while (edge2 != polygon2.edges(n)) {
            linkedList.append(polygon2.edges(n));
            ++n;
        }
        edge3 = h.get_edge_array(vertex2, polygon2.get_vertex(n));
        linkedList.append(edge3);
        return linkedList;
    }

    public static void delete_temp_polygons() {
        Enumeration enumeration = temp_polygons.elements();
        while (enumeration.hasMoreElements()) {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if (!h.contains(polygon2)) continue;
            h.remove(polygon2);
        }
    }

    protected static Edge find_broken_edge() {
        int n = 0;
        while (n < Modify.h.n_edges) {
            Edge edge = Modify.h.edges[n];
            if (edge.left_polygon() == null && edge.right_polygon() == null) {
                System.out.println("edge without polygons (Cutting.find_broken_edge())");
            }
            if (edge.left_polygon() == null || edge.right_polygon() == null) {
                return edge;
            }
            ++n;
        }
        System.out.println("no broken edge (Cutting.find_broken_edge())");
        return null;
    }

    public static void divide_knot_polygon(Polygon2 polygon2, Vertex vertex, Edge edge, LinkedList linkedList, Vertex vertex2, Edge edge2, LinkedList linkedList2) {
        LinkedList linkedList3 = linkedList2.reverse();
        LinkedList linkedList4 = linkedList.copy();
        linkedList4.connect(linkedList3.cdr());
        System.out.println("divide knot polygon--");
        PolygonReplace polygonReplace = polygon_replace_manager.replaced(polygon2);
        if (polygonReplace != null) {
            polygon2 = polygon_replace_manager.get_corresponding_polygon(polygonReplace, vertex);
            edge = Modify.find_corresponding_edge(polygon2, edge);
            edge2 = Modify.find_corresponding_edge(polygon2, edge2);
        }
        if (!polygon2.contains(edge)) {
            edge = polygon_replace_manager.get_parent_edge(edge);
            System.out.println("head_edge not contained");
        }
        if (!polygon2.contains(edge2)) {
            edge2 = polygon_replace_manager.get_parent_edge(edge2);
            System.out.println("tail_edge not contained");
        }
        Modify.divide_a_polygon(polygon2, linkedList4, vertex, edge, vertex2, edge2);
    }

    public static Edge find_corresponding_edge(Polygon2 polygon2, Edge edge) {
        int n = 0;
        while (n < polygon2.n_edges) {
            Edge edge2 = polygon2.edges[n];
            if (edge.on_edge(edge2.start) && edge.on_edge(edge2.end)) {
                return edge2;
            }
            ++n;
        }
        System.out.print("no corresponding edge (Cutting.find_corresponding_edge)");
        return null;
    }

    public static void init(Polyhedron polyhedron) {
        h = polyhedron;
        temp_polygons = new LinkedList();
        polygon_replace_manager = new Modify().new PolygonReplaceManager();
    }

    public static void divide_a_polygon(Polygon2 polygon2, LinkedList linkedList, Vertex vertex, Edge edge, Vertex vertex2, Edge edge2) {
        Serializable serializable;
        Edge edge3;
        Vertex vertex3;
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex vertex4 = (Vertex)enumeration.nextElement();
        int n = 0;
        while (n < linkedList.size() - 2) {
            vertex3 = (Vertex)enumeration.nextElement();
            h.append(vertex3);
            edge3 = new Edge(vertex4, vertex3);
            linkedList2.append(edge3);
            h.append(edge3);
            edge3.set_sharp(section_is_sharp);
            vertex4 = vertex3;
            ++n;
        }
        vertex3 = (Vertex)linkedList.tail();
        edge3 = new Edge(vertex4, vertex3);
        linkedList2.append(edge3);
        h.append(edge3);
        edge3.set_sharp(section_is_sharp);
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        if (edge == edge2) {
            serializable = polygon2.get_vertex(polygon2.get_edge_index(edge));
            if (Vector3.distance(serializable, vertex) < Vector3.distance(serializable, vertex2)) {
                linkedList3.append(h.get_edge_array(vertex, vertex2));
                linkedList4 = Modify.divide_a_polygon_around(polygon2, vertex2, edge2, vertex, edge);
                polygon_replace_manager.edge_replaced(edge, (Edge)linkedList4.tail(), (Edge)linkedList3.head(), (Edge)linkedList4.head());
            } else {
                linkedList4.append(h.get_edge_array(vertex2, vertex));
                linkedList3 = Modify.divide_a_polygon_around(polygon2, vertex, edge, vertex2, edge2);
                polygon_replace_manager.edge_replaced(edge, (Edge)linkedList3.tail(), (Edge)linkedList4.head(), (Edge)linkedList3.head());
            }
        } else {
            linkedList3 = Modify.divide_a_polygon_around(polygon2, vertex, edge, vertex2, edge2);
            linkedList4 = Modify.divide_a_polygon_around(polygon2, vertex2, edge2, vertex, edge);
            polygon_replace_manager.edge_replaced(edge, (Edge)linkedList4.tail(), (Edge)linkedList3.head());
            polygon_replace_manager.edge_replaced(edge2, (Edge)linkedList3.tail(), (Edge)linkedList4.head());
        }
        linkedList3.connect(linkedList2.reverse());
        serializable = new Polygon2(linkedList3);
        h.append((Polygon2)serializable);
        linkedList4.connect(linkedList2);
        Polygon2 polygon22 = new Polygon2(linkedList4);
        h.append(polygon22);
        temp_polygons.append(polygon22);
        polygon_replace_manager.polygon_replaced(polygon2, (Polygon2)serializable, polygon22);
        if (h.contains(polygon2)) {
            h.remove(polygon2);
        }
    }

    class PolygonReplaceManager {
        protected LinkedList polygon_replace_list;
        protected LinkedList edge_replace_list;

        public void edge_replaced(Edge edge, Edge edge2, Edge edge3) {
            this.edge_replace_list.append(new EdgeReplace(edge, edge2, edge3));
        }

        public void edge_replaced(Edge edge, Edge edge2, Edge edge3, Edge edge4) {
            this.edge_replace_list.append(new EdgeReplace(edge, edge2, edge3, edge4));
        }

        PolygonReplaceManager() {
            Modify.this.getClass();
            this.polygon_replace_list = new LinkedList();
            this.edge_replace_list = new LinkedList();
        }

        public Polygon2 get_corresponding_polygon(PolygonReplace polygonReplace, Vertex vertex) {
            Polygon2 polygon2 = polygonReplace.child0.on_polygon(vertex) ? polygonReplace.child0 : polygonReplace.child1;
            polygonReplace = this.replaced(polygon2);
            if (polygonReplace == null) {
                return polygon2;
            }
            return this.get_corresponding_polygon(polygonReplace, vertex);
        }

        public Edge get_parent_edge(Edge edge) {
            Enumeration enumeration = this.edge_replace_list.elements();
            while (enumeration.hasMoreElements()) {
                EdgeReplace edgeReplace = (EdgeReplace)enumeration.nextElement();
                if (!edgeReplace.is_child(edge)) continue;
                return edgeReplace.parent;
            }
            System.out.println("no parent (Cutting.get_parent_replace)");
            return edge;
        }

        public void polygon_replaced(Polygon2 polygon2, Polygon2 polygon22, Polygon2 polygon23) {
            this.polygon_replace_list.append(new PolygonReplace(polygon2, polygon22, polygon23));
        }

        public Edge get_corresponding_edge(Edge edge, Vertex vertex) {
            Object object;
            EdgeReplace edgeReplace = null;
            Enumeration enumeration = this.edge_replace_list.elements();
            while (enumeration.hasMoreElements()) {
                object = (EdgeReplace)enumeration.nextElement();
                if (((EdgeReplace)object).parent != edge) continue;
                edgeReplace = object;
                break;
            }
            if (edgeReplace == null) {
                return edge;
            }
            object = null;
            if (edgeReplace.child0.on_edge(vertex)) {
                object = edgeReplace.child0;
            } else if (edgeReplace.child1.on_edge(vertex)) {
                object = edgeReplace.child1;
            } else if (edgeReplace.child2.on_edge(vertex)) {
                object = edgeReplace.child2;
            } else {
                System.out.println("no corresponding edge (Cutting.get_corresponding_edge)");
            }
            return this.get_corresponding_edge((Edge)object, vertex);
        }

        public PolygonReplace replaced(Polygon2 polygon2) {
            Enumeration enumeration = this.polygon_replace_list.elements();
            while (enumeration.hasMoreElements()) {
                PolygonReplace polygonReplace = (PolygonReplace)enumeration.nextElement();
                if (polygonReplace.parent != polygon2) continue;
                return polygonReplace;
            }
            return null;
        }
    }

    class PolygonReplace {
        Polygon2 parent;
        Polygon2 child0;
        Polygon2 child1;

        PolygonReplace(Polygon2 polygon2, Polygon2 polygon22, Polygon2 polygon23) {
            Modify.this.getClass();
            this.parent = polygon2;
            this.child0 = polygon22;
            this.child1 = polygon23;
        }
    }

    class EdgeReplace {
        Edge parent;
        Edge child0;
        Edge child1;
        Edge child2;

        EdgeReplace(Edge edge, Edge edge2, Edge edge3) {
            Modify.this.getClass();
            this.parent = edge;
            this.child0 = edge2;
            this.child1 = edge3;
            this.child2 = null;
        }

        EdgeReplace(Edge edge, Edge edge2, Edge edge3, Edge edge4) {
            Modify.this.getClass();
            this.parent = edge;
            this.child0 = edge2;
            this.child1 = edge3;
            this.child2 = edge4;
        }

        public boolean is_child(Edge edge) {
            return edge == this.child0 || edge == this.child1 || edge == this.child2;
        }
    }
}

