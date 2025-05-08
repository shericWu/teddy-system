// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Tessellation.java

package teddy;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Edge, LinkedList, Vector3, Vertex, 
//            Polyhedron, Polygon2, Objects, Draw3DScene, 
//            Surface

class Tessellation
{

    private static void divide_an_edge(Edge edge, double d)
    {
        double d1 = edge.length();
        int i = (int)(d1 / d);
        Vector3 vector3 = edge.vector3();
        LinkedList linkedlist = new LinkedList();
        for(int j = 1; j < i; j++)
        {
            Vertex vertex = edge.start.shift(vector3.multiple((double)j / (double)i));
            linkedlist.append(vertex);
        }

        Enumeration enumeration = linkedlist.elements();
        Vertex vertex1 = edge.start;
        LinkedList linkedlist1 = new LinkedList();
        while(enumeration.hasMoreElements()) 
        {
            Vertex vertex2 = (Vertex)enumeration.nextElement();
            linkedlist1.append(new Edge(vertex1, vertex2));
            vertex1 = vertex2;
        }
        linkedlist1.append(new Edge(vertex1, edge.end));
        h.append_vertices(linkedlist);
        h.append_edges(linkedlist1);
        divide_an_edge_sub(edge.left_polygon(), edge, edge.start, linkedlist1, edge.end);
        divide_an_edge_sub(edge.right_polygon(), edge, edge.end, linkedlist1.reverse(), edge.start);
    }

    private static boolean no_big_distortion(Vertex vertex, Vertex vertex1, Edge edge)
    {
        for(Enumeration enumeration = vertex.edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge1 = (Edge)enumeration.nextElement();
            if(edge1 != edge)
            {
                Vertex vertex2 = edge1.get_the_other_vertex(vertex);
                Vector3 vector3 = new Vector3(vertex2, vertex);
                Vector3 vector3_1 = new Vector3(vertex2, vertex1);
                double d = Math.abs(vector3.sin(vector3_1));
                double d1 = vector3.cos(vector3_1);
                if(d > 0.29999999999999999D || d1 < 0.0D)
                    return false;
            }
        }

        if(flip_over_test(vertex, vertex1, edge))
            return false;
        else
            return polygons_are_parallel_to_edge(edge, vertex.polygons());
    }

    private static Polygon2 replaced_polygon(Polygon2 polygon2, LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Edge edge = polygon2.edges[i];
            linkedlist1.append(get_corresponding_edge(edge, linkedlist));
        }

        return new Polygon2(linkedlist1);
    }

    private static Polygon2 divide_a_polygon_sub(Polygon2 polygon2, int i, Edge edge, Vertex vertex)
    {
        LinkedList linkedlist = new LinkedList();
        for(; polygon2.get_vertex(i) != vertex; i++)
            linkedlist.append(polygon2.edges(i));

        linkedlist.append(edge);
        Polygon2 polygon2_1 = new Polygon2(linkedlist);
        h.append(polygon2_1);
        return polygon2_1;
    }

    Tessellation()
    {
    }

    private static boolean flip_over_test(Vertex vertex, Vertex vertex1, Edge edge)
    {
        for(Enumeration enumeration = vertex.polygons().elements(); enumeration.hasMoreElements();)
        {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if(polygon2 != edge.left_polygon() && polygon2 != edge.right_polygon())
            {
                Objects objects = polygon2.get_the_other_edge(vertex);
                Vector3 vector3 = new Vector3(vertex1, (Vertex)objects.get(0));
                Vector3 vector3_1 = new Vector3(vertex1, (Vertex)objects.get(1));
                if(vector3.parallel(vector3_1))
                {
                    System.out.println("Tessellation.flip");
                    return true;
                }
                Vector3 vector3_2 = (new Vector3(vertex, (Vertex)objects.get(0))).cross_product(new Vector3(vertex, (Vertex)objects.get(1)));
                Vector3 vector3_3 = vector3.cross_product(vector3_1);
                if(vector3_2.cos(vector3_3) < -0.80000000000000004D)
                    return true;
            }
        }

        return false;
    }

    private static boolean polygons_are_parallel_to_edge(Edge edge, LinkedList linkedlist)
    {
        Enumeration enumeration = linkedlist.elements();
        Vector3 vector3 = edge.vector3();
        while(enumeration.hasMoreElements()) 
        {
            Vector3 vector3_1 = ((Polygon2)enumeration.nextElement()).get_normal_simple();
            double d = Math.abs(vector3_1.cos(vector3));
            if(d > 0.69999999999999996D)
                return false;
        }
        return true;
    }

    private static void remove_a_short_edge(Edge edge, Vertex vertex, Vertex vertex1)
    {
        Polygon2 polygon2 = edge.left_polygon();
        Polygon2 polygon2_1 = edge.right_polygon();
        LinkedList linkedlist = vertex.polygons().copy();
        Vertex vertex2 = vertex1;
        LinkedList linkedlist1 = new LinkedList();
        init_replacement(linkedlist1, vertex1);
        for(Enumeration enumeration = vertex.edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge1 = (Edge)enumeration.nextElement();
            if(edge1 != edge)
            {
                Vertex vertex3 = edge1.get_the_other_vertex(vertex);
                register_replacement(linkedlist1, edge1, vertex2, vertex3);
            }
        }

        h.remove(polygon2);
        h.remove(polygon2_1);
        for(Enumeration enumeration1 = linkedlist.elements(); enumeration1.hasMoreElements();)
        {
            Polygon2 polygon2_2 = (Polygon2)enumeration1.nextElement();
            if(polygon2_2 != polygon2 && polygon2_2 != polygon2_1)
            {
                h.remove(polygon2_2);
                h.current_part_index = polygon2_2.part_index;
                h.append(replaced_polygon(polygon2_2, linkedlist1));
            }
        }

        if(polygon2.n_edges > 3)
        {
            h.current_part_index = polygon2.part_index;
            h.append(replaced_polygon_special(polygon2, linkedlist1, edge));
        }
        if(polygon2_1.n_edges > 3)
        {
            h.current_part_index = polygon2_1.part_index;
            h.append(replaced_polygon_special(polygon2_1, linkedlist1, edge));
        }
    }

    private static void divide_an_edge_sub(Polygon2 polygon2, Edge edge, Vertex vertex, LinkedList linkedlist, Vertex vertex1)
    {
        LinkedList linkedlist1 = new LinkedList();
        linkedlist1.connect(linkedlist);
        int i;
        for(i = 0; polygon2.edges(i) != edge; i++);
        for(i++; polygon2.edges(i) != edge; i++)
            linkedlist1.append(polygon2.edges(i));

        Polygon2 polygon2_1 = new Polygon2(linkedlist1);
        h.append(polygon2_1);
        h.remove(polygon2);
    }

    public static Vector remove_thin_polygons(Polyhedron polyhedron)
    {
        Vector vector = new Vector();
        h = polyhedron;
        Object obj = null;
        for(int i = 0; i < h.n_edges; i++)
            h.edges[i].checked = false;

        for(int j = 0; j < h.n_edges; j++)
            if(!h.edges[j].checked)
            {
                Edge edge = h.edges[j];
                edge.mid_vertex();
                edge.checked = true;
                if(no_big_distortion(edge.start, edge.end, edge))
                {
                    remove_a_short_edge(edge, edge.start, edge.end);
                    vector.addElement(new Objects(edge.start, edge.end));
                    j = 0;
                } else
                if(no_big_distortion(edge.end, edge.start, edge))
                {
                    remove_a_short_edge(edge, edge.end, edge.start);
                    vector.addElement(new Objects(edge.end, edge.start));
                    j = 0;
                }
            }

        return vector;
    }

    public static void tessellate_a_polygon(Polygon2 polygon2)
    {
        int i = polygon2.get_concave_vertex_index();
        if(i != -1)
            tessellate_a_polygon(polygon2, i);
    }

    public static void adjust_polygon_size(Polyhedron polyhedron, LinkedList linkedlist, double d)
    {
        h = polyhedron;
        d *= 2D;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Edge edge = (Edge)enumeration.nextElement();
            if(edge.length() > d)
                divide_an_edge(edge, d);
        }

    }

    private static void tessellate_a_polygon(Polygon2 polygon2, int i)
    {
        h.current_part_index = polygon2.part_index;
        if(polygon2.n_edges == 3)
        {
            System.out.println("clashed polygon (Tessellation.tessellate)");
            Draw3DScene.current_polygon = polygon2;
            return;
        }
        Vertex vertex = polygon2.get_vertex(i);
        Vertex vertex1 = polygon2.get_vertex(i - 1);
        Vertex vertex2 = polygon2.get_vertex(i + 1);
        Surface.get_normal_surface(vertex1, vertex, vertex2);
        Vector3 vector3 = new Vector3(vertex1, vertex);
        Vector3 vector3_1 = new Vector3(vertex, vertex2);
        vector3.normalize();
        vector3_1.normalize();
        Vector3 vector3_2 = vector3.add(vector3_1);
        Vector3 vector3_3 = polygon2.normal.cross_product(vector3_2);
        int k = i + 2;
        Vertex vertex3 = polygon2.get_vertex(k);
        double d = vector3_3.cos(new Vector3(vertex, vertex3));
        for(int j = i + 3; j < (polygon2.n_edges + i) - 1; j++)
        {
            Vertex vertex5 = polygon2.get_vertex(j);
            new Vector3(vertex, vertex5);
            double d1 = vector3_3.cos(new Vector3(vertex, vertex5));
            if(d < d1)
            {
                d = d1;
                Vertex vertex4 = vertex5;
                k = j;
            }
        }

        divide_a_polygon(polygon2, i, k);
    }

    private static Edge get_corresponding_edge(Edge edge, LinkedList linkedlist)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Objects objects = (Objects)enumeration.nextElement();
            Edge edge1 = (Edge)objects.get(0);
            if(edge == edge1)
                return (Edge)objects.get(1);
        }

        return edge;
    }

    public static void tessellate(Polyhedron polyhedron)
    {
        h = polyhedron;
        Object obj = null;
        int i = h.n_polygons;
        Polygon2 apolygon2[] = (Polygon2[])h.polygons.clone();
        for(int k = 0; k < i; k++)
        {
            Polygon2 polygon2 = apolygon2[k];
            int j = polygon2.get_concave_vertex_index();
            if(j != -1)
                tessellate_a_polygon(polygon2, j);
        }

    }

    private static void init_replacement(LinkedList linkedlist, Vertex vertex)
    {
        Objects objects;
        for(Enumeration enumeration = vertex.edges.elements(); enumeration.hasMoreElements(); linkedlist.append(objects))
        {
            Edge edge = (Edge)enumeration.nextElement();
            objects = new Objects(edge, edge);
        }

    }

    private static void register_replacement(LinkedList linkedlist, Edge edge, Vertex vertex, Vertex vertex1)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Objects objects = (Objects)enumeration.nextElement();
            Edge edge2 = (Edge)objects.get(1);
            if(edge2.same_edge(vertex, vertex1))
            {
                Objects objects1 = new Objects(edge, edge2);
                linkedlist.append(objects1);
                if(edge.sharp)
                    edge2.set_sharp(true);
                return;
            }
        }

        Edge edge1 = new Edge(vertex, vertex1);
        h.append(edge1);
        if(edge.sharp)
            edge1.set_sharp(true);
        linkedlist.append(new Objects(edge, edge1));
    }

    private static Polygon2 replaced_polygon_special(Polygon2 polygon2, LinkedList linkedlist, Edge edge)
    {
        LinkedList linkedlist1 = new LinkedList();
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Edge edge1 = polygon2.edges[i];
            if(edge1 != edge)
                linkedlist1.append(get_corresponding_edge(edge1, linkedlist));
        }

        return new Polygon2(linkedlist1);
    }

    private static void divide_a_polygon(Polygon2 polygon2, int i, int j)
    {
        Vertex vertex = polygon2.get_vertex(i);
        Vertex vertex1 = polygon2.get_vertex(j);
        Edge edge = new Edge(vertex1, vertex);
        Polygon2 polygon2_1 = divide_a_polygon_sub(polygon2, i, edge, vertex1);
        Polygon2 polygon2_2 = divide_a_polygon_sub(polygon2, j, edge, vertex);
        h.append(edge);
        h.remove(polygon2);
        tessellate_a_polygon(polygon2_1);
        tessellate_a_polygon(polygon2_2);
    }

    private static Polyhedron h;
}
