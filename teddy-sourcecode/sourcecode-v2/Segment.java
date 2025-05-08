// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Segment.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;

// Referenced classes of package teddy:
//            Node, Def, Vector2

public class Segment
    implements Serializable
{

    public boolean same(Segment segment)
    {
        return start_node().same(segment.start_node()) && end_node().same(segment.end_node()) || start_node().same(segment.end_node()) && end_node().same(segment.start_node());
    }

    public static double get_distance(Node node, Node node1)
    {
        return Math.sqrt((node.x - node1.x) * (node.x - node1.x) + (node.y - node1.y) * (node.y - node1.y));
    }

    public boolean online(Node node)
    {
        return distance_line(node) < 1.0000000000000001E-05D;
    }

    public boolean between(Node node)
    {
        if(Def.equal(y1, y2))
            return node.x >= Math.min(x1, x2) - 1.0000000000000001E-05D && node.x <= Math.max(x1, x2) + 1.0000000000000001E-05D;
        return node.y >= Math.min(y1, y2) - 1.0000000000000001E-05D && node.y <= Math.max(y1, y2) + 1.0000000000000001E-05D;
    }

    public boolean parallel(Segment segment)
    {
        Vector2 vector2 = vector();
        Vector2 vector2_1 = segment.vector();
        double d = vector2.get_sin(vector2_1);
        return Math.abs(d) < 1.0000000000000001E-05D;
    }

    public double parallel_interval(Segment segment)
    {
        Vector2 vector2 = vector().normalize();
        Segment segment1 = coord_system(vector2);
        Segment segment2 = segment.coord_system(vector2);
        if((segment1.x1 - segment2.x2) * (segment1.x2 - segment2.x1) < 0.0D || (segment1.x1 - segment2.x2) * (segment1.x2 - segment2.x2) < 0.0D || (segment2.x1 - segment1.x1) * (segment2.x2 - segment1.x1) < 0.0D)
        {
            double d = segment2.y1 - segment1.y1;
            return Math.abs(d);
        } else
        {
            return -1D;
        }
    }

    Segment(double d, double d1, double d2, double d3)
    {
        x1 = d;
        y1 = d1;
        x2 = d2;
        y2 = d3;
    }

    Segment(Node node, Node node1)
    {
        x1 = node.x;
        y1 = node.y;
        x2 = node1.x;
        y2 = node1.y;
    }

    public Vector2 vector()
    {
        return new Vector2(x2 - x1, y2 - y1);
    }

    public Node start_node()
    {
        return new Node(x1, y1);
    }

    public Node cross_node(Segment segment)
    {
        double d = y1 - y2;
        double d1 = x2 - x1;
        double d2 = y2 * x1 - x2 * y1;
        double d3 = segment.y1 - segment.y2;
        double d4 = segment.x2 - segment.x1;
        double d5 = segment.y2 * segment.x1 - segment.x2 * segment.y1;
        if(Math.abs(d * d4 - d3 * d1) < 1.0000000000000001E-05D)
        {
            System.out.println("Error in Segment.cross_node().");
            return null;
        } else
        {
            double d6 = (d1 * d5 - d4 * d2) / (d * d4 - d3 * d1);
            double d7 = (d * d5 - d3 * d2) / (d3 * d1 - d * d4);
            return new Node(d6, d7);
        }
    }

    public double coords(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return x1;

        case 1: // '\001'
            return y1;

        case 2: // '\002'
            return x2;

        case 3: // '\003'
            return y2;
        }
        return 0.0D;
    }

    public double distance_line(Node node)
    {
        double d = x2 - x1;
        double d1 = y2 - y1;
        double d2 = Math.sqrt(d * d + d1 * d1);
        double d3 = d * (node.y - y1) - d1 * (node.x - x1);
        if(d2 == 0.0D)
        {
            System.out.println("Error in Segment.distance_line");
            return 0.0D;
        } else
        {
            return Math.abs(d3 / d2);
        }
    }

    public boolean same_line(Segment segment)
    {
        return online(segment.start_node()) && online(segment.end_node());
    }

    public Segment coord_system(Vector2 vector2)
    {
        double d = x1 * vector2.x + y1 * vector2.y;
        double d1 = -x1 * vector2.y + y1 * vector2.x;
        double d2 = x2 * vector2.x + y2 * vector2.y;
        double d3 = -x2 * vector2.y + y2 * vector2.x;
        return new Segment(d, d1, d2, d3);
    }

    public double length()
    {
        return Vector2.distance(x1, y1, x2, y2);
    }

    public Node end_node()
    {
        return new Node(x2, y2);
    }

    public boolean cross(Segment segment)
    {
        double d = y1 - y2;
        double d1 = x2 - x1;
        double d2 = y2 * x1 - x2 * y1;
        double d3 = segment.y1 - segment.y2;
        double d4 = segment.x2 - segment.x1;
        double d5 = segment.y2 * segment.x1 - segment.x2 * segment.y1;
        return (d * segment.x1 + d1 * segment.y1 + d2) * (d * segment.x2 + d1 * segment.y2 + d2) <= 1.0000000000000001E-05D && (d3 * x1 + d4 * y1 + d5) * (d3 * x2 + d4 * y2 + d5) <= 1.0000000000000001E-05D;
    }

    public void configure(Node node, Node node1)
    {
        x1 = node.x;
        y1 = node.y;
        x2 = node1.x;
        y2 = node1.y;
    }

    public double distance(Node node)
    {
        Node node1 = start_node();
        Node node2 = end_node();
        Vector2 vector2 = new Vector2(node1, node2);
        Vector2 vector2_1 = new Vector2(node1, node);
        if(vector2.inner_product(vector2_1) < 0.0D)
            return get_distance(node, node1);
        vector2_1 = new Vector2(node2, node);
        if(vector2.inner_product(vector2_1) > 0.0D)
            return get_distance(node, node2);
        else
            return distance_line(node);
    }

    public double x1;
    public double y1;
    public double x2;
    public double y2;
}
