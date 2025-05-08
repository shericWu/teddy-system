// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Modify.java

package teddy;

import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Edge, Polyhedron, Polygon2, LinkedList, 
//            Vertex, Vector3, Teddy

public class Modify
{
    class PolygonReplaceManager
    {

        public void edge_replaced(Edge edge, Edge edge1, Edge edge2)
        {
            edge_replace_list.append(new EdgeReplace(edge, edge1, edge2));
        }

        public void edge_replaced(Edge edge, Edge edge1, Edge edge2, Edge edge3)
        {
            edge_replace_list.append(new EdgeReplace(edge, edge1, edge2, edge3));
        }

        public Polygon2 get_corresponding_polygon(PolygonReplace polygonreplace, Vertex vertex)
        {
            Polygon2 polygon2;
            if(polygonreplace.child0.on_polygon(vertex))
                polygon2 = polygonreplace.child0;
            else
                polygon2 = polygonreplace.child1;
            polygonreplace = replaced(polygon2);
            if(polygonreplace == null)
                return polygon2;
            else
                return get_corresponding_polygon(polygonreplace, vertex);
        }

        public Edge get_parent_edge(Edge edge)
        {
            for(Enumeration enumeration = edge_replace_list.elements(); enumeration.hasMoreElements();)
            {
                EdgeReplace edgereplace = (EdgeReplace)enumeration.nextElement();
                if(edgereplace.is_child(edge))
                    return edgereplace.parent;
            }

            System.out.println("no parent (Cutting.get_parent_replace)");
            return edge;
        }

        public void polygon_replaced(Polygon2 polygon2, Polygon2 polygon2_1, Polygon2 polygon2_2)
        {
            polygon_replace_list.append(new PolygonReplace(polygon2, polygon2_1, polygon2_2));
        }

        public Edge get_corresponding_edge(Edge edge, Vertex vertex)
        {
            EdgeReplace edgereplace = null;
            for(Enumeration enumeration = edge_replace_list.elements(); enumeration.hasMoreElements();)
            {
                EdgeReplace edgereplace1 = (EdgeReplace)enumeration.nextElement();
                if(edgereplace1.parent == edge)
                {
                    edgereplace = edgereplace1;
                    break;
                }
            }

            if(edgereplace == null)
                return edge;
            Edge edge1 = null;
            if(edgereplace.child0.on_edge(vertex))
                edge1 = edgereplace.child0;
            else
            if(edgereplace.child1.on_edge(vertex))
                edge1 = edgereplace.child1;
            else
            if(edgereplace.child2.on_edge(vertex))
                edge1 = edgereplace.child2;
            else
                System.out.println("no corresponding edge (Cutting.get_corresponding_edge)");
            return get_corresponding_edge(edge1, vertex);
        }

        public PolygonReplace replaced(Polygon2 polygon2)
        {
            for(Enumeration enumeration = polygon_replace_list.elements(); enumeration.hasMoreElements();)
            {
                PolygonReplace polygonreplace = (PolygonReplace)enumeration.nextElement();
                if(polygonreplace.parent == polygon2)
                    return polygonreplace;
            }

            return null;
        }

        protected LinkedList polygon_replace_list;
        protected LinkedList edge_replace_list;

        PolygonReplaceManager()
        {
            polygon_replace_list = new LinkedList();
            edge_replace_list = new LinkedList();
        }
    }

    class PolygonReplace
    {

        Polygon2 parent;
        Polygon2 child0;
        Polygon2 child1;

        PolygonReplace(Polygon2 polygon2, Polygon2 polygon2_1, Polygon2 polygon2_2)
        {
            parent = polygon2;
            child0 = polygon2_1;
            child1 = polygon2_2;
        }
    }

    class EdgeReplace
    {

        public boolean is_child(Edge edge)
        {
            return edge == child0 || edge == child1 || edge == child2;
        }

        Edge parent;
        Edge child0;
        Edge child1;
        Edge child2;

        EdgeReplace(Edge edge, Edge edge1, Edge edge2)
        {
            parent = edge;
            child0 = edge1;
            child1 = edge2;
            child2 = null;
        }

        EdgeReplace(Edge edge, Edge edge1, Edge edge2, Edge edge3)
        {
            parent = edge;
            child0 = edge1;
            child1 = edge2;
            child2 = edge3;
        }
    }


    public static void remove_broken_polygons()
    {
        do
        {
            Edge edge = find_broken_edge();
            if(edge == null)
                return;
            Polygon2 polygon2;
            if(edge.left_polygon() != null)
                polygon2 = edge.left_polygon();
            else
                polygon2 = edge.right_polygon();
            remove_broken_polygons(edge, polygon2);
        } while(true);
    }

    protected static void remove_broken_polygons(Edge edge, Polygon2 polygon2)
    {
        h.remove(polygon2);
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Edge edge1 = polygon2.edges[i];
            if(edge1 != edge)
            {
                Polygon2 polygon2_1 = edge1.get_another_polygon(null);
                if(polygon2_1 != null)
                    remove_broken_polygons(edge1, polygon2_1);
            }
        }

    }

    public Modify()
    {
    }

    public static LinkedList divide_a_polygon_around(Polygon2 polygon2, Vertex vertex, Edge edge, Vertex vertex1, Edge edge1)
    {
        LinkedList linkedlist = new LinkedList();
        if(!polygon2.contains(edge))
        {
            System.out.println("prev_edge not contained (dividing_a_polygon_around)");
            return linkedlist;
        }
        if(!polygon2.contains(edge1))
            return linkedlist;
        int i = polygon2.get_edge_index(edge) + 1;
        Edge edge2 = h.get_edge_array(vertex, polygon2.get_vertex(i));
        linkedlist.append(edge2);
        for(; edge1 != polygon2.edges(i); i++)
            linkedlist.append(polygon2.edges(i));

        edge2 = h.get_edge_array(vertex1, polygon2.get_vertex(i));
        linkedlist.append(edge2);
        return linkedlist;
    }

    public static void delete_temp_polygons()
    {
        for(Enumeration enumeration = temp_polygons.elements(); enumeration.hasMoreElements();)
        {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if(h.contains(polygon2))
                h.remove(polygon2);
        }

    }

    protected static Edge find_broken_edge()
    {
        for(int i = 0; i < h.n_edges; i++)
        {
            Edge edge = h.edges[i];
            if(edge.left_polygon() == null && edge.right_polygon() == null)
                System.out.println("edge without polygons (Cutting.find_broken_edge())");
            if(edge.left_polygon() == null || edge.right_polygon() == null)
                return edge;
        }

        System.out.println("no broken edge (Cutting.find_broken_edge())");
        return null;
    }

    public static void divide_knot_polygon(Polygon2 polygon2, Vertex vertex, Edge edge, LinkedList linkedlist, Vertex vertex1, Edge edge1, LinkedList linkedlist1)
    {
        LinkedList linkedlist2 = linkedlist1.reverse();
        LinkedList linkedlist3 = linkedlist.copy();
        linkedlist3.connect(linkedlist2.cdr());
        System.out.println("divide knot polygon--");
        PolygonReplace polygonreplace = polygon_replace_manager.replaced(polygon2);
        if(polygonreplace != null)
        {
            polygon2 = polygon_replace_manager.get_corresponding_polygon(polygonreplace, vertex);
            edge = find_corresponding_edge(polygon2, edge);
            edge1 = find_corresponding_edge(polygon2, edge1);
        }
        if(!polygon2.contains(edge))
        {
            edge = polygon_replace_manager.get_parent_edge(edge);
            System.out.println("head_edge not contained");
        }
        if(!polygon2.contains(edge1))
        {
            edge1 = polygon_replace_manager.get_parent_edge(edge1);
            System.out.println("tail_edge not contained");
        }
        divide_a_polygon(polygon2, linkedlist3, vertex, edge, vertex1, edge1);
    }

    public static Edge find_corresponding_edge(Polygon2 polygon2, Edge edge)
    {
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Edge edge1 = polygon2.edges[i];
            if(edge.on_edge(edge1.start) && edge.on_edge(edge1.end))
                return edge1;
        }

        System.out.print("no corresponding edge (Cutting.find_corresponding_edge)");
        return null;
    }

    public static void init(Polyhedron polyhedron)
    {
        h = polyhedron;
        temp_polygons = new LinkedList();
        polygon_replace_manager = (new Modify()). new PolygonReplaceManager();
    }

    public static void divide_a_polygon(Polygon2 polygon2, LinkedList linkedlist, Vertex vertex, Edge edge, Vertex vertex1, Edge edge1)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex vertex2 = (Vertex)enumeration.nextElement();
        for(int i = 0; i < linkedlist.size() - 2; i++)
        {
            Vertex vertex3 = (Vertex)enumeration.nextElement();
            h.append(vertex3);
            Edge edge2 = new Edge(vertex2, vertex3);
            linkedlist1.append(edge2);
            h.append(edge2);
            edge2.set_sharp(section_is_sharp);
            vertex2 = vertex3;
        }

        Vertex vertex4 = (Vertex)linkedlist.tail();
        Edge edge3 = new Edge(vertex2, vertex4);
        linkedlist1.append(edge3);
        h.append(edge3);
        edge3.set_sharp(section_is_sharp);
        LinkedList linkedlist2 = new LinkedList();
        LinkedList linkedlist3 = new LinkedList();
        if(edge == edge1)
        {
            Vertex vertex5 = polygon2.get_vertex(polygon2.get_edge_index(edge));
            if(Vector3.distance(vertex5, vertex) < Vector3.distance(vertex5, vertex1))
            {
                linkedlist2.append(h.get_edge_array(vertex, vertex1));
                linkedlist3 = divide_a_polygon_around(polygon2, vertex1, edge1, vertex, edge);
                polygon_replace_manager.edge_replaced(edge, (Edge)linkedlist3.tail(), (Edge)linkedlist2.head(), (Edge)linkedlist3.head());
            } else
            {
                linkedlist3.append(h.get_edge_array(vertex1, vertex));
                linkedlist2 = divide_a_polygon_around(polygon2, vertex, edge, vertex1, edge1);
                polygon_replace_manager.edge_replaced(edge, (Edge)linkedlist2.tail(), (Edge)linkedlist3.head(), (Edge)linkedlist2.head());
            }
        } else
        {
            linkedlist2 = divide_a_polygon_around(polygon2, vertex, edge, vertex1, edge1);
            linkedlist3 = divide_a_polygon_around(polygon2, vertex1, edge1, vertex, edge);
            polygon_replace_manager.edge_replaced(edge, (Edge)linkedlist3.tail(), (Edge)linkedlist2.head());
            polygon_replace_manager.edge_replaced(edge1, (Edge)linkedlist2.tail(), (Edge)linkedlist3.head());
        }
        linkedlist2.connect(linkedlist1.reverse());
        Polygon2 polygon2_1 = new Polygon2(linkedlist2);
        h.append(polygon2_1);
        linkedlist3.connect(linkedlist1);
        Polygon2 polygon2_2 = new Polygon2(linkedlist3);
        h.append(polygon2_2);
        temp_polygons.append(polygon2_2);
        polygon_replace_manager.polygon_replaced(polygon2, polygon2_1, polygon2_2);
        if(h.contains(polygon2))
            h.remove(polygon2);
    }

    public static Teddy teddy;
    protected static Polyhedron h;
    public static LinkedList temp_polygons;
    public static PolygonReplaceManager polygon_replace_manager;
    public static boolean section_is_sharp;
}
