// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vector2.java

package teddy;

import java.awt.Point;

// Referenced classes of package teddy:
//            Vertex2D, Node, Vector3

public class Vector2
{

    public static double distance(Point point1, Point point2)
    {
        return distance(point1.x, point1.y, point2.x, point2.y);
    }

    public void normalize_self()
    {
        double d = length();
        if(d == 0.0D)
            d = 1.0D;
        x = x / d;
        y = y / d;
    }

    public static double distance(double d, double d1, double d2, double d3)
    {
        return Math.sqrt((d2 - d) * (d2 - d) + (d3 - d1) * (d3 - d1));
    }

    public static double distance(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        return distance(((Vector2) (vertex2d)).x, ((Vector2) (vertex2d)).y, ((Vector2) (vertex2d1)).x, ((Vector2) (vertex2d1)).y);
    }

    public Vector2 normalize()
    {
        double d = length();
        if(d == 0.0D)
            d = 1.0D;
        return new Vector2(x / d, y / d);
    }

    public double get_sin(Vector2 vector2)
    {
        double d = Math.sqrt((x * x + y * y) * (vector2.x * vector2.x + vector2.y * vector2.y));
        if(d > 0.0D)
            return cross_product(vector2) / d;
        else
            return 0.0D;
    }

    protected Vector2 add(Vector2 vector2)
    {
        return new Vector2(x + vector2.x, y + vector2.y);
    }

    public double get_cos(Vector2 vector2)
    {
        double d = Math.sqrt((x * x + y * y) * (vector2.x * vector2.x + vector2.y * vector2.y));
        if(d > 0.0D)
            return inner_product(vector2) / d;
        else
            return 0.0D;
    }

    public void multiple_self(double d)
    {
        x *= d;
        y *= d;
    }

    public void rotate90_self()
    {
        x = -y;
        y = x;
    }

    public double inner_product(Vector2 vector2)
    {
        return x * vector2.x + y * vector2.y;
    }

    public double cross_product(Vector2 vector2)
    {
        return x * vector2.y - y * vector2.x;
    }

    public Vertex2D vertex2D()
    {
        return new Vertex2D(x, y);
    }

    public void add_self(Vector2 vector2)
    {
        x += vector2.x;
        y += vector2.y;
    }

    public Vector2 flip_y_axis()
    {
        return new Vector2(-x, y);
    }

    public Vector2 get_normalized()
    {
        double d = length();
        if(d == 0.0D)
            d = 1.0D;
        return new Vector2(x / d, y / d);
    }

    public double length()
    {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2 rotate90()
    {
        return new Vector2(-y, x);
    }

    public Vector2 scale(double d)
    {
        return new Vector2(x * d, y * d);
    }

    public double cos(Vector2 vector2)
    {
        return get_cos(vector2);
    }

    public double outer_product(Vector2 vector2)
    {
        return x * vector2.y - y * vector2.x;
    }

    public double dot_product(Vector2 vector2)
    {
        return x * vector2.x + y * vector2.y;
    }

    public double sin(Vector2 vector2)
    {
        return get_sin(vector2);
    }

    Vector2(Node node, Node node1)
    {
        x = node1.x - node.x;
        y = node1.y - node.y;
    }

    Vector2(Point point1, Point point2)
    {
        x = point2.x - point1.x;
        y = point2.y - point1.y;
    }

    Vector2(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        x = ((Vector2) (vertex2d1)).x - ((Vector2) (vertex2d)).x;
        y = ((Vector2) (vertex2d1)).y - ((Vector2) (vertex2d)).y;
    }

    Vector2(Point point1)
    {
        x = point1.x;
        y = point1.y;
    }

    Vector2()
    {
    }

    Vector2(double d, double d1)
    {
        x = d;
        y = d1;
    }

    Vector2(Vector3 vector3)
    {
        x = vector3.x;
        y = vector3.y;
    }

    public Vector2 rotate(double d)
    {
        if(d == 90D)
            return new Vector2(-y, x);
        if(d == 180D)
            return new Vector2(-x, -y);
        if(d == 270D)
        {
            return new Vector2(y, -x);
        } else
        {
            double d1 = (d * 3.1415926535897931D) / 180D;
            double d2 = Math.cos(d1);
            double d3 = Math.sin(d1);
            return new Vector2(x * d2 - y * d3, x * d3 + y * d2);
        }
    }

    public static Vector2 interporate(Point point1, Point point2, double d)
    {
        return new Vector2((double)point1.x * (1.0D - d) + (double)point2.x * d, (double)point1.y * (1.0D - d) + (double)point2.y * d);
    }

    public static Vector2 interporate(Vertex2D vertex2d, Vertex2D vertex2d1, double d)
    {
        return new Vector2(((Vector2) (vertex2d)).x * (1.0D - d) + ((Vector2) (vertex2d1)).x * d, ((Vector2) (vertex2d)).y * (1.0D - d) + ((Vector2) (vertex2d1)).y * d);
    }

    public Vector2 multiple(double d)
    {
        return new Vector2(x * d, y * d);
    }

    public double get_relative_angle(Vector2 vector2)
    {
        double d = cos(vector2);
        if(d <= -1D)
            return 3.1415926535897931D;
        if(d >= 1.0D)
            return 0.0D;
        else
            return Math.acos(cos(vector2));
    }

    public double get_angle(Vector2 vector2)
    {
        double d = get_cos(vector2);
        double d1 = get_sin(vector2);
        if(d == 0.0D)
            return d1 <= 0.0D ? 270D : 90D;
        if(d1 == 0.0D)
            return d <= 0.0D ? 180D : 0.0D;
        double d2 = (180D * Math.atan(d1 / d)) / 3.1415926535897931D;
        if(d < 0.0D)
            d2 += 180D;
        if(d2 < 0.0D)
            d2 += 360D;
        return d2;
    }

    public Point point()
    {
        return new Point((int)x, (int)y);
    }

    public static double distance(int i, int j, int k, int l)
    {
        return Math.sqrt((k - i) * (k - i) + (l - j) * (l - j));
    }

    public double x;
    public double y;
}
