// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Polygon2.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Edge, Vector3, Vertex, LinkedList, 
//            Objects, Polyhedron

class Polygon2
    implements Serializable
{

    public Vertex cross_point(Edge edge)
    {
        Vertex vertex = edges[0].start();
        Vector3 vector3 = absolute_normal();
        Vector3 vector3_1 = edge.vector3();
        Vertex vertex1 = edge.start();
        double d = (vertex.dot_product(vector3) - vertex1.dot_product(vector3)) / vector3_1.dot_product(vector3);
        return new Vertex(((Vector3) (vertex1)).x + vector3_1.x * d, ((Vector3) (vertex1)).y + vector3_1.y * d, ((Vector3) (vertex1)).z + vector3_1.z * d);
    }

    public Edge edges(int i)
    {
        if(i >= n_edges)
            i -= (i / n_edges) * n_edges;
        if(i < 0)
            i += (-i / n_edges + 1) * n_edges;
        return edges[i];
    }

    public Edge get_longest_edge()
    {
        Edge edge = null;
        double d = -1D;
        for(int i = 0; i < n_edges; i++)
        {
            double d1 = edges[i].length();
            if(d < d1)
            {
                edge = edges[i];
                d = d1;
            }
        }

        return edge;
    }

    public Vertex get_vertex(int i)
    {
        return edges(i - 1).get_common_vertex(edges(i));
    }

    public LinkedList get_edges()
    {
        LinkedList linkedlist = new LinkedList();
        for(int i = 0; i < n_edges; i++)
            linkedlist.append(edges[i]);

        return linkedlist;
    }

    public void renew_network()
    {
        for(int i = 0; i < n_edges; i++)
            edges[i] = edges[i].child;

    }

    public Vector get_vertices()
    {
        Vector vector = new Vector();
        for(int i = 0; i < n_edges; i++)
            vector.addElement(get_vertex(i));

        return vector;
    }

    public void print_normal()
    {
        System.out.println("normal " + (int)(normal.x * 10D) + "," + (int)(normal.y * 10D) + "," + (int)(normal.z * 10D));
    }

    public int get_vertex_index(Vertex vertex)
    {
        for(int i = 0; i < n_edges; i++)
            if(get_vertex(i) == vertex)
                return i;

        System.out.println("Vertex not in Polygon (Polygon2.get_vertex_index)");
        return -1;
    }

    public int get_concave_vertex_index()
    {
        set_normal();
        for(int i = 0; i < n_edges; i++)
            if(is_concave(i))
                return i;

        return -1;
    }

    public boolean is_concave(int i)
    {
        Vertex vertex = get_vertex(i);
        Vector3 vector3 = new Vector3(get_vertex(i - 1), vertex);
        Vector3 vector3_1 = new Vector3(vertex, get_vertex(i + 1));
        Vector3 vector3_2 = vector3.cross_product(vector3_1);
        if(vector3.parallel(vector3_1) && vector3.dot_product(vector3_1) > 0.0D)
            return true;
        return normal.dot_product(vector3_2) <= 0.0D;
    }

    public boolean on_polygon(Vertex vertex)
    {
        set_normal();
        double d = 0.0D;
        Vertex vertex1 = vertex;
        Vector3 vector3 = new Vector3(vertex1, get_vertex(0));
        for(int i = 1; i < n_edges + 1; i++)
        {
            Vector3 vector3_1 = new Vector3(vertex1, get_vertex(i));
            double d1 = vector3.get_relative_angle(vector3_1);
            if(normal.dot_product(vector3.cross_product(vector3_1)) < 0.0D)
                d1 *= -1D;
            d += d1;
            vector3 = vector3_1;
        }

        return d > 3.1415926535897931D;
    }

    private void add_edges(Enumeration enumeration)
    {
        Edge edge = (Edge)enumeration.nextElement();
        Edge edge1 = edge;
        for(int i = 0; i < n_edges - 1; i++)
        {
            Edge edge2 = (Edge)enumeration.nextElement();
            add_edge(i, edge, edge2);
            edge = edge2;
        }

        add_edge(n_edges - 1, edge, edge1);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    private void add_edge(int i, Edge edge, Edge edge1)
    {
        edges[i] = edge;
        if(edge1.contain(edge.end))
        {
            edge.set_left_polygon(this);
            return;
        } else
        {
            edge.set_right_polygon(this);
            return;
        }
    }

    private Edge find_shared_edge(Vertex vertex, Vertex vertex1)
    {
        for(Enumeration enumeration = vertex.edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge = (Edge)enumeration.nextElement();
            for(Enumeration enumeration2 = vertex1.edges.elements(); enumeration2.hasMoreElements();)
                if(edge == (Edge)enumeration2.nextElement())
                    return edge;

        }

        System.out.println("error while searching shared edge (Polygon2.java)");
        for(Enumeration enumeration1 = vertex.edges.elements(); enumeration1.hasMoreElements(); System.out.print(" " + enumeration1.nextElement()));
        System.out.println("");
        for(Enumeration enumeration3 = vertex1.edges.elements(); enumeration3.hasMoreElements(); System.out.print(" " + enumeration3.nextElement()));
        System.out.println("");
        return null;
    }

    public Objects get_the_other_edge(Vertex vertex)
    {
        int i = 0;
        for(i = 0; i < n_edges; i++)
            if(get_vertex(i) == vertex)
                break;

        return new Objects(get_vertex(i - 1), get_vertex(i + 1));
    }

    public void set_distance(Vertex vertex)
    {
        distance = Vector3.distance(vertex, centerVertex());
    }

    public Vector3 absolute_normal()
    {
        return polyhedron.absolute_coords(normal);
    }

    Polygon2()
    {
        part_index = 0;
        n_edges = 3;
        edges = new Edge[3];
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(Edge edge, Edge edge1, Edge edge2)
    {
        part_index = 0;
        n_edges = 3;
        edges = new Edge[3];
        add_edge(0, edge, edge1);
        add_edge(1, edge1, edge2);
        add_edge(2, edge2, edge);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(Edge edge, Edge edge1, Edge edge2, Edge edge3)
    {
        part_index = 0;
        n_edges = 4;
        edges = new Edge[4];
        add_edge(0, edge, edge1);
        add_edge(1, edge1, edge2);
        add_edge(2, edge2, edge3);
        add_edge(3, edge3, edge);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        part_index = 0;
        n_edges = 3;
        edges = new Edge[3];
        Edge edge = find_shared_edge(vertex, vertex1);
        Edge edge1 = find_shared_edge(vertex1, vertex2);
        Edge edge2 = find_shared_edge(vertex2, vertex);
        add_edge(0, edge, edge1);
        add_edge(1, edge1, edge2);
        add_edge(2, edge2, edge);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(Vertex vertex, Vertex vertex1, Vertex vertex2, Vertex vertex3)
    {
        part_index = 0;
        n_edges = 4;
        edges = new Edge[4];
        Edge edge = find_shared_edge(vertex, vertex1);
        Edge edge1 = find_shared_edge(vertex1, vertex2);
        Edge edge2 = find_shared_edge(vertex2, vertex3);
        Edge edge3 = find_shared_edge(vertex3, vertex);
        add_edge(0, edge, edge1);
        add_edge(1, edge1, edge2);
        add_edge(2, edge2, edge3);
        add_edge(3, edge3, edge);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(int i, Edge aedge[])
    {
        part_index = 0;
        n_edges = i;
        edges = new Edge[n_edges];
        for(int j = 0; j < n_edges - 1; j++)
            add_edge(j, aedge[j], aedge[j + 1]);

        add_edge(i - 1, aedge[i - 1], aedge[0]);
        set_normal();
        front_facing = false;
        surface_lines = new LinkedList();
    }

    Polygon2(LinkedList linkedlist)
    {
        part_index = 0;
        n_edges = linkedlist.size();
        edges = new Edge[n_edges];
        add_edges(linkedlist.elements());
    }

    Polygon2(Vector vector)
    {
        part_index = 0;
        n_edges = vector.size();
        edges = new Edge[n_edges];
        add_edges(vector.elements());
    }

    public Vector3 get_normal_simple()
    {
        for(int i = 0; i < n_edges - 1; i++)
        {
            Vector3 vector3 = new Vector3(get_vertex(i - 1), get_vertex(i));
            Vector3 vector3_1 = new Vector3(get_vertex(i), get_vertex(i + 1));
            Vector3 vector3_2 = vector3.cross_product(vector3_1);
            if(!vector3.parallel(vector3_1))
                return vector3_2;
        }

        return null;
    }

    public boolean contains(Edge edge)
    {
        for(int i = 0; i < n_edges; i++)
            if(edges[i] == edge)
                return true;

        return false;
    }

    public boolean contains(Vertex vertex)
    {
        for(int i = 0; i < n_edges; i++)
            if(edges[i].contain(vertex))
                return true;

        return false;
    }

    public void check_facing(Vertex vertex)
    {
        Vector3 vector3 = new Vector3(vertex, edges(0).start());
        Vector3 vector3_1 = absolute_normal();
        if(vector3.dot_product(vector3_1) < 0.0D)
        {
            front_facing = true;
            return;
        } else
        {
            front_facing = false;
            return;
        }
    }

    public Polygon2 copy()
    {
        Polygon2 polygon2 = new Polygon2();
        polygon2.edges = (Edge[])edges.clone();
        polygon2.n_edges = n_edges;
        polygon2.surface_lines = new LinkedList();
        polygon2.normal = normal;
        polygon2.front_facing = front_facing;
        polygon2.part_index = part_index;
        child = polygon2;
        return polygon2;
    }

    public Vertex centerVertex()
    {
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        for(int i = 0; i < n_edges; i++)
        {
            Edge edge = edges[i];
            Vertex vertex = edge.start();
            Vertex vertex1 = edge.end();
            d = d + ((Vector3) (vertex)).x + ((Vector3) (vertex1)).x;
            d1 = d1 + ((Vector3) (vertex)).y + ((Vector3) (vertex1)).y;
            d2 = d2 + ((Vector3) (vertex)).z + ((Vector3) (vertex1)).z;
        }

        d /= n_edges * 2;
        d1 /= n_edges * 2;
        d2 /= n_edges * 2;
        return new Vertex(d, d1, d2);
    }

    public int get_edge_index(Edge edge)
    {
        for(int i = 0; i < n_edges; i++)
            if(edges(i) == edge)
                return i;

        System.out.println("Edge not in Polygon (Polygon2.get_edge_index)");
        return -1;
    }

    public void edge_replace(Edge edge, Edge edge1, Edge edge2)
    {
        Edge aedge[] = new Edge[n_edges + 1];
        int i = 0;
        for(int j = 0; j < n_edges; j++)
            if(edges[j] != edge)
                aedge[i++] = edges[j];
            else
            if(edges[j - 1].connected(edge1))
            {
                add_edge(i++, edge1, edge2);
                add_edge(i++, edge2, edges[j + 1]);
            } else
            {
                add_edge(i++, edge2, edge1);
                add_edge(i++, edge1, edges[j + 1]);
            }

        edges = aedge;
        n_edges = n_edges + 1;
    }

    public void edge_replace(Edge edge, Edge edge1, Edge edge2, Edge edge3)
    {
        Edge aedge[] = new Edge[n_edges + 2];
        int i = 0;
        for(int j = 0; j < n_edges; j++)
            if(edges[j] != edge)
                aedge[i++] = edges[j];
            else
            if(edges[j - 1].connected(edge1))
            {
                add_edge(i++, edge1, edge2);
                add_edge(i++, edge2, edge3);
                add_edge(i++, edge3, edges[j + 1]);
            } else
            {
                add_edge(i++, edge3, edge2);
                add_edge(i++, edge2, edge1);
                add_edge(i++, edge1, edges[j + 1]);
            }

        edges = aedge;
        n_edges = n_edges + 2;
    }

    public Edge get_shortest_edge()
    {
        Edge edge = null;
        double d = 1.7976931348623157E+308D;
        for(int i = 0; i < n_edges; i++)
        {
            double d1 = edges[i].length();
            if(d > d1)
            {
                edge = edges[i];
                d = d1;
            }
        }

        return edge;
    }

    public void set_normal()
    {
        normal = calc_normal();
    }

    public Vector3 calc_normal()
    {
        int i = 0;
        double d = 0.0D;
        for(int j = 0; j < n_edges; j++)
        {
            Vector3 vector3 = new Vector3(get_vertex(j), get_vertex(j + 1));
            Vector3 vector3_1 = new Vector3(get_vertex(j), get_vertex(j - 1));
            double d2 = vector3.sin(vector3_1);
            if(d2 > d)
            {
                d = d2;
                i = j;
            }
        }

        Vertex vertex = get_vertex(i);
        double d1 = 0.0D;
        Vector3 vector3_2 = new Vector3(get_vertex(i - 1), vertex);
        Vector3 vector3_3 = new Vector3(vertex, get_vertex(i + 1));
        Vector3 vector3_5 = vector3_2.cross_product(vector3_3);
        vector3_2 = new Vector3(vertex, get_vertex(i + 1));
        for(int k = i + 2; k < n_edges + i; k++)
        {
            Vector3 vector3_4 = new Vector3(vertex, get_vertex(k));
            double d3 = vector3_2.get_relative_angle(vector3_4);
            if(vector3_5.dot_product(vector3_2.cross_product(vector3_4)) < 0.0D)
                d3 *= -1D;
            d1 += d3;
            vector3_2 = vector3_4;
        }

        if(d1 < 0.0D)
            vector3_5.multiple_self(-1D);
        return vector3_5;
    }

    public Edge edges[];
    public int n_edges;
    public LinkedList surface_lines;
    public Vector3 normal;
    boolean front_facing;
    public Polyhedron polyhedron;
    double distance;
    public transient Polygon2 child;
    public int part_index;
    int index;
}
