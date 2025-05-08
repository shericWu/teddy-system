// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Edge2D.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;

// Referenced classes of package teddy:
//            Vector2, Vertex2D

class Edge2D
{

    public Vector2 vector2()
    {
        return new Vector2(start, end);
    }

    public boolean right_side_of_edge(double d, double d1, double d2, double d3, double d4, double d5)
    {
        double d6 = d1 - d3;
        double d7 = d2 - d;
        double d8 = d3 * d - d2 * d1;
        return d6 * d4 + d7 * d5 + d8 < 0.0D;
    }

    public Vertex2D cross_point(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7)
    {
        double d8 = d1 - d3;
        double d9 = d2 - d;
        double d10 = d3 * d - d2 * d1;
        double d11 = d5 - d7;
        double d12 = d6 - d4;
        double d13 = d7 * d4 - d6 * d5;
        if(Math.abs(d8 * d12 - d11 * d9) < 1.0000000000000001E-05D)
        {
            return null;
        } else
        {
            double d14 = (d9 * d13 - d12 * d10) / (d8 * d12 - d11 * d9);
            double d15 = (d8 * d13 - d11 * d10) / (d11 * d9 - d8 * d12);
            return new Vertex2D(d14, d15);
        }
    }

    public Vertex2D mid_point()
    {
        return new Vertex2D((((Vector2) (start)).x + ((Vector2) (end)).x) / 2D, (((Vector2) (start)).y + ((Vector2) (end)).y) / 2D);
    }

    Edge2D()
    {
    }

    Edge2D(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        start = vertex2d;
        end = vertex2d1;
    }

    Edge2D(Point point, Point point1)
    {
        start = new Vertex2D(point);
        end = new Vertex2D(point1);
    }

    public Vertex2D get_the_other_vertex(Vertex2D vertex2d)
    {
        if(vertex2d == start)
            return end;
        else
            return start;
    }

    public Vertex2D get_common_vertex(Edge2D edge2d)
    {
        if(start == edge2d.start || start == edge2d.end)
            return start;
        else
            return end;
    }

    public boolean contains(Vertex2D vertex2d)
    {
        return vertex2d == start || vertex2d == end;
    }

    public boolean equals(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        return vertex2d == start && vertex2d1 == end || vertex2d1 == start && vertex2d == end;
    }

    public double distance_as_a_segment(Vertex2D vertex2d)
    {
        Vector2 vector2_1 = new Vector2(start, end);
        Vector2 vector2_2 = new Vector2(start, vertex2d);
        if(vector2_1.dot_product(vector2_2) < 0.0D)
            return Vector2.distance(vertex2d, start);
        vector2_2 = new Vector2(end, vertex2d);
        if(vector2_1.dot_product(vector2_2) > 0.0D)
            return Vector2.distance(vertex2d, end);
        else
            return distance(vertex2d);
    }

    public double length()
    {
        return Vector2.distance(start, end);
    }

    public boolean cross(Edge2D edge2d)
    {
        return cross(((Vector2) (start)).x, ((Vector2) (start)).y, ((Vector2) (end)).x, ((Vector2) (end)).y, ((Vector2) (edge2d.start)).x, ((Vector2) (edge2d.start)).y, ((Vector2) (edge2d.end)).x, ((Vector2) (edge2d.end)).y);
    }

    public boolean cross(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7)
    {
        double d8 = d1 - d3;
        double d9 = d2 - d;
        double d10 = d3 * d - d2 * d1;
        double d11 = d5 - d7;
        double d12 = d6 - d4;
        double d13 = d7 * d4 - d6 * d5;
        return (d8 * d4 + d9 * d5 + d10) * (d8 * d6 + d9 * d7 + d10) <= 0.0D && (d11 * d + d12 * d1 + d13) * (d11 * d2 + d12 * d3 + d13) <= 0.0D;
    }

    public double distance(Vertex2D vertex2d)
    {
        double d = ((Vector2) (end)).x - ((Vector2) (start)).x;
        double d1 = ((Vector2) (end)).y - ((Vector2) (start)).y;
        double d2 = Math.sqrt(d * d + d1 * d1);
        double d3 = d * (((Vector2) (vertex2d)).y - ((Vector2) (start)).y) - d1 * (((Vector2) (vertex2d)).x - ((Vector2) (start)).x);
        if(d2 == 0.0D)
        {
            System.out.println("Error in Edge2D.distance");
            return 0.0D;
        } else
        {
            return Math.abs(d3 / d2);
        }
    }

    Vertex2D start;
    Vertex2D end;
}
