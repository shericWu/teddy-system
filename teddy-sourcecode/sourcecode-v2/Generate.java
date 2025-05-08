// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Generate.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, Vertex2D, Vector2, Def, 
//            DrawPanel, Segment, Edge2D, Teddy, 
//            Skeleton, Scene, Segments, Vertex, 
//            Vector3, Polyhedron

class Generate
{

    public static LinkedList normalize_Vertex2D_list(LinkedList linkedlist)
    {
        double d = 0.0D;
        Enumeration enumeration = linkedlist.elements();
        Vertex2D vertex2d2;
        for(Vertex2D vertex2d = (Vertex2D)enumeration.nextElement(); enumeration.hasMoreElements(); vertex2d = vertex2d2)
        {
            vertex2d2 = (Vertex2D)enumeration.nextElement();
            d += Vector2.distance(vertex2d, vertex2d2);
        }

        int i = (int)(d / Def.NORMALIZED_EDGE_LENGTH);
        if(i < 8)
            i = 8;
        double d1 = d / (double)i;
        LinkedList linkedlist1 = new LinkedList();
        enumeration = linkedlist.elements();
        Vertex2D vertex2d1 = (Vertex2D)enumeration.nextElement();
        linkedlist1.append(vertex2d1);
        double d2 = 0.0D;
        while(enumeration.hasMoreElements()) 
        {
            Vertex2D vertex2d3 = (Vertex2D)enumeration.nextElement();
            double d3 = Vector2.distance(vertex2d1, vertex2d3);
            for(d2 += d3; d2 >= d1;)
            {
                d2 -= d1;
                linkedlist1.append(Vector2.interporate(vertex2d3, vertex2d1, d2 / d3).vertex2D());
                if(linkedlist1.size() == i - 1)
                    break;
            }

            if(linkedlist1.size() == i - 1)
                break;
            vertex2d1 = vertex2d3;
        }
        linkedlist1.append(linkedlist.tail());
        return linkedlist1;
    }

    public static LinkedList reduce_Vertex2D_list(LinkedList linkedlist, boolean flag)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex2D vertex2d = (Vertex2D)enumeration.nextElement();
        linkedlist1.append(vertex2d);
        Vertex2D vertex2d1 = (Vertex2D)enumeration.nextElement();
        Vertex2D vertex2d2 = null;
        Object obj = null;
        Object obj1 = null;
        while(enumeration.hasMoreElements()) 
        {
            double d = 0.0D;
            double d1 = 0.0D;
            Vector2 vector2_1;
            for(Vector2 vector2 = new Vector2(vertex2d, vertex2d1); enumeration.hasMoreElements(); vector2 = vector2_1)
            {
                vertex2d2 = (Vertex2D)enumeration.nextElement();
                vector2_1 = new Vector2(vertex2d1, vertex2d2);
                d += vector2.get_relative_angle(vector2_1);
                d1 += vector2.length();
                if(d > 0.20000000000000001D || flag && d1 > Def.MAXIMUM_EDGE_LENGTH)
                {
                    linkedlist1.append(vertex2d1);
                    break;
                }
                vertex2d1 = vertex2d2;
            }

            if(!enumeration.hasMoreElements())
                break;
            vertex2d = vertex2d1;
            vertex2d1 = vertex2d2;
        }
        linkedlist1.append(linkedlist.tail());
        return linkedlist1;
    }

    public static Segment get_segment(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        double d = DrawPanel.rcX((int)((Vector2) (vertex2d)).x);
        double d1 = DrawPanel.rcY((int)((Vector2) (vertex2d)).y);
        double d2 = DrawPanel.rcX((int)((Vector2) (vertex2d1)).x);
        double d3 = DrawPanel.rcY((int)((Vector2) (vertex2d1)).y);
        return new Segment(d, d1, d2, d3);
    }

    public static Segment get_segment(Edge2D edge2d)
    {
        return get_segment(edge2d.start, edge2d.end);
    }

    private static LinkedList normalize_Point_list_sub(LinkedList linkedlist, int i, double d)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Point point = (Point)enumeration.nextElement();
        linkedlist1.append(point);
        double d1 = 0.0D;
        while(enumeration.hasMoreElements()) 
        {
            Point point1 = (Point)enumeration.nextElement();
            double d2 = Vector2.distance(point.x, point.y, point1.x, point1.y);
            for(d1 += d2; d1 >= d;)
            {
                d1 -= d;
                linkedlist1.append(Vector2.interporate(point1, point, d1 / d2).point());
                if(linkedlist1.size() == i - 1)
                    break;
            }

            if(linkedlist1.size() == i - 1)
                break;
            point = point1;
        }
        linkedlist1.append(linkedlist.tail());
        return linkedlist1;
    }

    public static Polyhedron generate(LinkedList linkedlist)
    {
        Teddy.teddy.play_sound("generate.au");
        linkedlist.remove(linkedlist.head());
        linkedlist.remove(linkedlist.tail());
        linkedlist.append(linkedlist.head());
        linkedlist = normalize_Point_list(linkedlist, Def.NORMALIZED_STROKE_LENGTH_NEW);
        linkedlist = reduce_Point_list(linkedlist);
        linkedlist = counter_clockwise(linkedlist);
        return Skeleton.generate_polyhedron(linkedlist);
    }

    public static Scene get_boundary(LinkedList linkedlist)
    {
        Scene scene = new Scene();
        linkedlist.reverse();
        Enumeration enumeration = linkedlist.elements();
        Point point1;
        for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
        {
            point1 = (Point)enumeration.nextElement();
            double d = DrawPanel.rcX(point.x);
            double d1 = DrawPanel.rcY(point.y);
            double d2 = DrawPanel.rcX(point1.x);
            double d3 = DrawPanel.rcY(point1.y);
            scene.append(new Segment(d, d1, d2, d3));
        }

        return scene;
    }

    Generate()
    {
    }

    public static Scene pop_test(LinkedList linkedlist)
    {
        Scene scene = new Scene();
        LinkedList linkedlist1 = linkedlist.reverse();
        Enumeration enumeration = linkedlist.elements();
        Enumeration enumeration1 = linkedlist1.elements();
        Point point = (Point)enumeration.nextElement();
        Point point1 = (Point)enumeration.nextElement();
        Point point2 = (Point)enumeration.nextElement();
        Point point3 = (Point)enumeration1.nextElement();
        Point point4 = (Point)enumeration1.nextElement();
        Point point5 = (Point)enumeration1.nextElement();
        do
        {
            double d = DrawPanel.rcX(point.x);
            double d1 = DrawPanel.rcY(point.y);
            double d2 = DrawPanel.rcX(point3.x);
            double d3 = DrawPanel.rcY(point3.y);
            scene.append(new Segment(d, d1, d2, d3));
            if(point1 != point4 && point1 != point3)
            {
                Vector2 vector2 = (new Vector2(point, point1)).normalize();
                Vector2 vector2_1 = (new Vector2(point1, point2)).normalize();
                Vector2 vector2_2 = (new Vector2(point3, point4)).normalize();
                Vector2 vector2_3 = (new Vector2(point4, point5)).normalize();
                vector2.add(vector2_3);
                vector2_1.add(vector2_2);
                vector2_1.add(vector2_3);
                Vector2 vector2_4 = new Vector2(point, point4);
                Vector2 vector2_5 = new Vector2(point1, point3);
                Vector2 vector2_6 = new Vector2(point1, point4);
                double d4 = Math.max(Math.abs(vector2_4.cos(vector2)), Math.abs(vector2_4.cos(vector2_3)));
                double d5 = Math.max(Math.abs(vector2_5.cos(vector2_1)), Math.abs(vector2_5.cos(vector2_2)));
                double d6 = Math.max(Math.abs(vector2_6.cos(vector2_1)), Math.abs(vector2_6.cos(vector2_3)));
                if(d4 <= d5 && d4 <= d6)
                {
                    point3 = point4;
                    point4 = point5;
                    point5 = (Point)enumeration1.nextElement();
                } else
                if(d5 <= d4 && d5 <= d6)
                {
                    point = point1;
                    point1 = point2;
                    point2 = (Point)enumeration.nextElement();
                } else
                {
                    point = point1;
                    point1 = point2;
                    point2 = (Point)enumeration.nextElement();
                    point3 = point4;
                    point4 = point5;
                    point5 = (Point)enumeration1.nextElement();
                }
            } else
            {
                return scene;
            }
        } while(true);
    }

    public static LinkedList renumber_Point_list(int i, LinkedList linkedlist)
    {
        double d = calculate_stroke_length(linkedlist);
        double d1 = d / (double)i;
        return normalize_Point_list_sub(linkedlist, i, d1);
    }

    public static LinkedList reduce_Vertex_list(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex vertex = (Vertex)enumeration.nextElement();
        linkedlist1.append(vertex);
        Vertex vertex1 = (Vertex)enumeration.nextElement();
        Vertex vertex2 = null;
        Object obj = null;
        Object obj1 = null;
        boolean flag = false;
        while(enumeration.hasMoreElements()) 
        {
            double d = 0.0D;
            double d1 = 0.0D;
            Vector3 vector3 = new Vector3(vertex, vertex1);
            int i = 0;
            while(enumeration.hasMoreElements()) 
            {
                vertex2 = (Vertex)enumeration.nextElement();
                Vector3 vector3_1 = new Vector3(vertex1, vertex2);
                d += vector3.get_relative_angle(vector3_1);
                d1 += vector3.length();
                if(d > 0.20000000000000001D || i > 2)
                {
                    linkedlist1.append(vertex1);
                    break;
                }
                i++;
                vertex1 = vertex2;
                vector3 = vector3_1;
            }
            if(!enumeration.hasMoreElements())
                break;
            vertex = vertex1;
            vertex1 = vertex2;
        }
        linkedlist1.append(linkedlist.tail());
        return linkedlist1;
    }

    public static Scene skeleton_test(LinkedList linkedlist)
    {
        Scene scene = new Scene();
        LinkedList linkedlist1 = Skeleton.get_skeleton_edges(linkedlist);
        Edge2D edge2d;
        for(Enumeration enumeration = linkedlist1.elements(); enumeration.hasMoreElements(); add_segment(scene, edge2d.start, edge2d.end))
            edge2d = (Edge2D)enumeration.nextElement();

        return scene;
    }

    public static Scene generate_scene(LinkedList linkedlist)
    {
        linkedlist.append(linkedlist.head());
        linkedlist = normalize_Point_list(linkedlist, Def.NORMALIZED_STROKE_LENGTH_NEW);
        linkedlist = reduce_Point_list(linkedlist);
        return skeleton_test(linkedlist);
    }

    public static void add_segment(Scene scene, Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        scene.append(get_segment(vertex2d, vertex2d1));
    }

    public static double calculate_stroke_length(LinkedList linkedlist)
    {
        double d = 0.0D;
        Enumeration enumeration = linkedlist.elements();
        Point point1;
        for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
        {
            point1 = (Point)enumeration.nextElement();
            d += Math.sqrt((point1.x - point.x) * (point1.x - point.x) + (point1.y - point.y) * (point1.y - point.y));
        }

        return d;
    }

    public static LinkedList counter_clockwise(LinkedList linkedlist)
    {
        double d = 0.0D;
        Enumeration enumeration = linkedlist.elements();
        Point point1;
        for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
        {
            point1 = (Point)enumeration.nextElement();
            d += (point.y + point1.y) * (point1.x - point.x);
        }

        if(linkedlist.tail() != linkedlist.head())
            System.out.println(d);
        if(d < 0.0D)
            return linkedlist.reverse();
        else
            return linkedlist;
    }

    public static LinkedList normalize_Point_list(LinkedList linkedlist, int i)
    {
        double d = calculate_stroke_length(linkedlist);
        int j = (int)(d / (double)i);
        if(j < 8)
            j = 8;
        double d1 = d / (double)j;
        return normalize_Point_list_sub(linkedlist, j, d1);
    }

    public static LinkedList reduce_Point_list(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Point point = (Point)enumeration.nextElement();
        linkedlist1.append(point);
        Point point1 = (Point)enumeration.nextElement();
        Point point2 = null;
        Object obj = null;
        Object obj1 = null;
        while(enumeration.hasMoreElements()) 
        {
            double d = 0.0D;
            double d1 = 0.0D;
            Vector2 vector2_1;
            for(Vector2 vector2 = new Vector2(point, point1); enumeration.hasMoreElements(); vector2 = vector2_1)
            {
                point2 = (Point)enumeration.nextElement();
                vector2_1 = new Vector2(point1, point2);
                d += vector2.get_relative_angle(vector2_1);
                d1 += vector2.length();
                if(d > 0.20000000000000001D || d1 > (double)Def.MAXIMUM_STROKE_LENGTH)
                {
                    linkedlist1.append(point1);
                    break;
                }
                point1 = point2;
            }

            if(!enumeration.hasMoreElements())
                break;
            point = point1;
            point1 = point2;
        }
        linkedlist1.append(linkedlist.tail());
        return linkedlist1;
    }

    public static Teddy teddy;
    private static Polyhedron h;
}
