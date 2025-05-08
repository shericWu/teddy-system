// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bend.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, Polyhedron, Vertex, SurfaceLine, 
//            Edge, Teddy, Generate, Edge2D, 
//            Vertex2D, Vector3, Draw3DScene, Vector2

class Bend
{

    public static void bend_main(LinkedList linkedlist, LinkedList linkedlist1)
    {
        Edge2D aedge2d[] = stroke_to_edge2Ds(linkedlist);
        Edge2D aedge2d1[] = stroke_to_edge2Ds(linkedlist1);
        int i = linkedlist.size();
        System.out.println("n" + i);
        for(int j = 0; j < h.n_vertices; j++)
        {
            Vertex vertex = h.vertices[j];
            vertex.warp(warp_for_edges(i, aedge2d, aedge2d1, vertex));
        }

        SurfaceLine surfaceline;
        for(Enumeration enumeration = h.surface_lines.elements(); enumeration.hasMoreElements(); ((Edge) (surfaceline)).end.warp(warp_for_edges(i, aedge2d, aedge2d1, ((Edge) (surfaceline)).end)))
        {
            surfaceline = (SurfaceLine)enumeration.nextElement();
            ((Edge) (surfaceline)).start.warp(warp_for_edges(i, aedge2d, aedge2d1, ((Edge) (surfaceline)).start));
        }

        h.set_parameters();
    }

    public static void bend(LinkedList linkedlist, LinkedList linkedlist1, Polyhedron polyhedron)
    {
        Teddy.teddy.play_sound("pop.au");
        linkedlist = Generate.renumber_Point_list(20, linkedlist);
        linkedlist1 = Generate.renumber_Point_list(20, linkedlist1);
        h = polyhedron;
        LinkedList linkedlist2 = stroke_to_vertex2D_list(linkedlist);
        LinkedList linkedlist3 = stroke_to_vertex2D_list(linkedlist1);
        bend_main(linkedlist2, linkedlist3);
    }

    Bend()
    {
    }

    private static Edge2D[] stroke_to_edge2Ds(LinkedList linkedlist)
    {
        int i = linkedlist.size();
        Edge2D aedge2d[] = new Edge2D[i];
        Vertex2D vertex2d = (Vertex2D)linkedlist.nextElement();
        for(int j = 0; j < i - 1; j++)
        {
            Vertex2D vertex2d1 = (Vertex2D)linkedlist.nextElement();
            aedge2d[j] = new Edge2D(vertex2d, vertex2d1);
            vertex2d = vertex2d1;
        }

        return aedge2d;
    }

    public static Vector3 warp_for_edges(int i, Edge2D aedge2d[], Edge2D aedge2d1[], Vertex vertex)
    {
        Vertex2D vertex2d = new Vertex2D(((Vector3) (vertex)).x, ((Vector3) (vertex)).z);
        double ad[] = new double[i];
        double d = 0.0D;
        Vector3 vector3 = new Vector3(0.0D, 0.0D, 0.0D);
        for(int j = 0; j < i - 1; j++)
        {
            double d1 = aedge2d[j].distance_as_a_segment(vertex2d);
            ad[j] = 1.0D / (0.0001D + d1 * d1 * d1);
            d += ad[j];
            Vertex vertex1 = warp_for_an_edge(aedge2d[j], aedge2d1[j], vertex);
            vector3 = vector3.add(vertex1.multiple(ad[j]));
        }

        vector3 = vector3.multiple(1.0D / d);
        return vector3;
    }

    public static LinkedList stroke_to_vertex2D_list(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        Point point;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); linkedlist1.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y))))
            point = (Point)enumeration.nextElement();

        return linkedlist1;
    }

    public static Vertex warp_for_an_edge(Edge2D edge2d, Edge2D edge2d1, Vertex vertex)
    {
        Vertex2D vertex2d = new Vertex2D(((Vector3) (vertex)).x, ((Vector3) (vertex)).z);
        Vector2 vector2 = edge2d.vector2().get_normalized();
        Vector2 vector2_1 = vector2.rotate90().get_normalized();
        Vector2 vector2_2 = edge2d1.vector2().get_normalized();
        Vector2 vector2_3 = vector2_2.rotate90().get_normalized();
        Vector2 vector2_4 = new Vector2(edge2d.start, vertex2d);
        double d = vector2.dot_product(vector2_4) * (edge2d1.length() / edge2d.length());
        double d1 = vector2_1.dot_product(vector2_4);
        Vector2 vector2_5 = vector2_2.multiple(d).add(vector2_3.multiple(d1));
        Vertex2D vertex2d1 = edge2d1.start.translate(vector2_5);
        return new Vertex(((Vector2) (vertex2d1)).x, ((Vector3) (vertex)).y, ((Vector2) (vertex2d1)).y);
    }

    protected static Polyhedron h;
}
