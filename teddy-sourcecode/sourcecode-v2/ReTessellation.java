// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReTessellation.java

package teddy;

import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Vertex, LinkedList, Vector3, Polyhedron, 
//            Polygon2

class ReTessellation
{

    private static Vertex get_gravity_center(LinkedList linkedlist)
    {
        Vertex vertex = new Vertex();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); vertex.add_self((Vertex)enumeration.nextElement()));
        return new Vertex(vertex.multiple(1.0D / (double)linkedlist.size()));
    }

    public static Vertex to_sum_of_vectors(LinkedList linkedlist, Vertex vertex, double d)
    {
        Vector3 vector3 = new Vector3(0.0D, 0.0D, 0.0D);
        double d1 = 0.0D;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Vertex vertex2 = (Vertex)enumeration.nextElement();
            Vector3 vector3_1 = new Vector3(vertex, vertex2);
            double d2 = 1.0D / vector3_1.length();
            vector3.add_self(vector3_1.multiple(d2));
            d1 += d2;
        }

        vector3.multiple_self(1.0D / d1);
        Vertex vertex1 = new Vertex(vertex.add(vector3.multiple(d)));
        return vertex1;
    }

    ReTessellation()
    {
    }

    public static void smooth5(Polyhedron polyhedron)
    {
        int i = 0;
        do
        {
            smooth_sub(polyhedron, 0.63139836000000005D);
            smooth_sub(polyhedron, -0.67395159999999998D);
        } while(++i < 5);
    }

    public static void smooth(Polyhedron polyhedron)
    {
        smooth_sub(polyhedron, 0.63139836000000005D);
        smooth_sub(polyhedron, -0.67395159999999998D);
        polyhedron.set_parameters();
    }

    public static void smooth(Vector vector)
    {
        int i = 0;
        do
        {
            smooth_sub(vector, 0.63139836000000005D);
            smooth_sub(vector, -0.67395159999999998D);
        } while(++i < 5);
    }

    public static Vertex to_the_center(LinkedList linkedlist, Vertex vertex, double d)
    {
        Vertex vertex1 = get_gravity_center(linkedlist);
        Vector3 vector3 = new Vector3(vertex, vertex1);
        Vertex vertex2 = new Vertex(vertex.add(vector3.multiple(d)));
        return vertex2;
    }

    public static void retessellate(Polyhedron polyhedron)
    {
        Vertex avertex[] = new Vertex[polyhedron.n_vertices];
        for(int i = 0; i < polyhedron.n_vertices; i++)
        {
            Vertex vertex = polyhedron.vertices[i];
            LinkedList linkedlist = vertex.get_sorrounding_vertices();
            avertex[i] = horizontal_shift(linkedlist, vertex);
        }

        for(int j = 0; j < polyhedron.n_vertices; j++)
            polyhedron.vertices[j].warp(avertex[j]);

        polyhedron.set_parameters();
    }

    public static void smooth_sub(Polyhedron polyhedron, double d)
    {
        Vertex avertex[] = new Vertex[polyhedron.n_vertices];
        for(int i = 0; i < polyhedron.n_vertices; i++)
        {
            Vertex vertex = polyhedron.vertices[i];
            LinkedList linkedlist = vertex.get_sorrounding_vertices();
            avertex[i] = to_sum_of_vectors(linkedlist, vertex, d);
        }

        for(int j = 0; j < polyhedron.n_vertices; j++)
            polyhedron.vertices[j].warp(avertex[j]);

    }

    public static void smooth_sub(Vector vector, double d)
    {
        Vertex avertex[] = new Vertex[vector.size()];
        for(int i = 0; i < vector.size(); i++)
        {
            Vertex vertex = (Vertex)vector.elementAt(i);
            LinkedList linkedlist = vertex.get_sorrounding_vertices();
            avertex[i] = to_sum_of_vectors(linkedlist, vertex, d);
        }

        for(int j = 0; j < vector.size(); j++)
            ((Vertex)vector.elementAt(j)).warp(avertex[j]);

    }

    private static Vector3 get_normal(LinkedList linkedlist, Vertex vertex)
    {
        LinkedList linkedlist1 = new LinkedList();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); linkedlist1.append(new Vector3((Vertex)enumeration.nextElement(), vertex)));
        Enumeration enumeration1 = linkedlist1.elements();
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5;
        Vector3 vector3;
        for(d5 = 0.0D; enumeration1.hasMoreElements(); d5 += vector3.z * vector3.z)
        {
            vector3 = (Vector3)enumeration1.nextElement();
            d += vector3.x * vector3.y;
            d1 += vector3.y * vector3.z;
            d2 += vector3.z * vector3.x;
            d3 += vector3.x * vector3.x;
            d4 += vector3.y * vector3.y;
        }

        Vector3 vector3_1 = new Vector3(d5 * d4 - d1 * d1, d * d1 - d * d5, d * d1 - d2 * d4);
        return vector3_1.get_normalized();
    }

    private static Vector3 get_averaged_normal(LinkedList linkedlist)
    {
        Vertex vertex = new Vertex();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); vertex.add_self(((Polygon2)enumeration.nextElement()).normal));
        Vector3 vector3 = vertex.multiple(1.0D / (double)linkedlist.size());
        return vector3.get_normalized();
    }

    private static Vertex horizontal_shift(LinkedList linkedlist, Vertex vertex)
    {
        Vertex vertex1 = get_gravity_center(linkedlist);
        Vector3 vector3 = get_averaged_normal(vertex.polygons());
        Vector3 vector3_1 = new Vector3(vertex1, vertex);
        Vertex vertex2 = new Vertex(vertex1.add(vector3.multiple(vector3_1.length())));
        Vector3 vector3_2 = new Vector3(vertex, vertex2);
        Vertex vertex3 = new Vertex(vertex.add(vector3_2.multiple(0.5D)));
        return vertex3;
    }

    private static Polyhedron h;
}
