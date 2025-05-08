// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vertex.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Vector3, LinkedList, Edge

class Vertex extends Vector3
    implements Serializable
{

    public Edge get_shared_edge(Vertex vertex)
    {
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge = (Edge)enumeration.nextElement();
            if(vertex.edges.member(edge))
                return edge;
        }

        return null;
    }

    public double z()
    {
        return super.z;
    }

    public static Vertex mid_point(Vertex vertex, Vertex vertex1)
    {
        return new Vertex((((Vector3) (vertex)).x + ((Vector3) (vertex1)).x) / 2D, (((Vector3) (vertex)).y + ((Vector3) (vertex1)).y) / 2D, (((Vector3) (vertex)).z + ((Vector3) (vertex1)).z) / 2D);
    }

    Vertex()
    {
        child = this;
        edges = new LinkedList();
    }

    Vertex(double d, double d1, double d2)
    {
        child = this;
        super.x = d;
        super.y = d1;
        super.z = d2;
        edges = new LinkedList();
    }

    Vertex(Vector3 vector3)
    {
        child = this;
        super.x = vector3.x;
        super.y = vector3.y;
        super.z = vector3.z;
        edges = new LinkedList();
    }

    public boolean same_vertex(double d, double d1, double d2)
    {
        return super.x == d && super.y == d1 && super.z == d2;
    }

    public Vertex position_copy()
    {
        Vertex vertex = new Vertex(super.x, super.y, super.z);
        child = vertex;
        return vertex;
    }

    public Vertex shift(Vector3 vector3)
    {
        return new Vertex(super.x + vector3.x, super.y + vector3.y, super.z + vector3.z);
    }

    public boolean edge_is_empty()
    {
        return edges.size() == 0;
    }

    public Vertex copy()
    {
        Vertex vertex = new Vertex(super.x, super.y, super.z);
        vertex.edges = edges;
        child = vertex;
        return vertex;
    }

    public void warp(Vector3 vector3)
    {
        super.x = vector3.x;
        super.y = vector3.y;
        super.z = vector3.z;
    }

    public double x()
    {
        return super.x;
    }

    public void renew_network()
    {
        LinkedList linkedlist = new LinkedList();
        Edge edge;
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements(); linkedlist.append(edge.child))
            edge = (Edge)enumeration.nextElement();

        edges = linkedlist;
    }

    public boolean same_position(Vertex vertex)
    {
        return super.x == ((Vector3) (vertex)).x && super.y == ((Vector3) (vertex)).y && super.z == ((Vector3) (vertex)).z;
    }

    public void remove_edge(Edge edge)
    {
        edges.remove(edge);
    }

    public LinkedList get_sorrounding_vertices()
    {
        LinkedList linkedlist = new LinkedList();
        Edge edge;
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements(); linkedlist.append(edge.get_the_other_vertex(this)))
            edge = (Edge)enumeration.nextElement();

        return linkedlist;
    }

    public LinkedList polygons()
    {
        LinkedList linkedlist = new LinkedList();
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge = (Edge)enumeration.nextElement();
            if(edge.left_polygon() == null || edge.right_polygon() == null)
                System.out.println("edge doesn't have 2 polygons (Vertex.polygons())");
            if(!linkedlist.member(edge.left_polygon()))
                linkedlist.append(edge.left_polygon());
            if(!linkedlist.member(edge.right_polygon()))
                linkedlist.append(edge.right_polygon());
        }

        return linkedlist;
    }

    public double y()
    {
        return super.y;
    }

    public double distance(Vertex vertex)
    {
        return Vector3.distance(this, vertex);
    }

    LinkedList edges;
    public transient Vertex child;
    public transient int index;
}
