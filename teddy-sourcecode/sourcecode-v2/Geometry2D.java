// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Geometry2D.java

package teddy;


// Referenced classes of package teddy:
//            Vector2, Vertex2D, Line2D

class Geometry2D
{

    public static double get_radius(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex2D vertex2d2)
    {
        Vertex2D vertex2d3 = get_circumcenter(vertex2d, vertex2d1, vertex2d2);
        if(vertex2d3 == null)
            return 1.7976931348623157E+308D;
        else
            return Vector2.distance(vertex2d3, vertex2d);
    }

    private static Line2D get_dividing_line(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        Vertex2D vertex2d2 = Vertex2D.mid_point(vertex2d, vertex2d1);
        double d = ((Vector2) (vertex2d1)).x - ((Vector2) (vertex2d)).x;
        double d1 = ((Vector2) (vertex2d1)).y - ((Vector2) (vertex2d)).y;
        Vector2 vector2 = new Vector2(d1, -d);
        return new Line2D(vertex2d2, vector2);
    }

    public static boolean left_side(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex2D vertex2d2)
    {
        if(vertex2d == vertex2d2 || vertex2d1 == vertex2d2)
            return true;
        Vector2 vector2 = new Vector2(vertex2d, vertex2d1);
        Vector2 vector2_1 = new Vector2(vertex2d, vertex2d2);
        return vector2.cross_product(vector2_1) <= 0.0D;
    }

    public static boolean left_side(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex2D vertex2d2, Vertex2D vertex2d3)
    {
        Vector2 vector2 = new Vector2(vertex2d1, vertex2d);
        Vector2 vector2_1 = new Vector2(vertex2d1, vertex2d2);
        Vector2 vector2_2 = new Vector2(vertex2d1, vertex2d3);
        double d = 360D - vector2_1.get_angle(vector2_2);
        double d1 = 360D - vector2_1.get_angle(vector2);
        if(d == 360D)
            d = 0.0D;
        return d <= d1;
    }

    Geometry2D()
    {
    }

    public static Vertex2D get_circumcenter(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex2D vertex2d2)
    {
        Line2D line2d = get_dividing_line(vertex2d, vertex2d1);
        Line2D line2d1 = get_dividing_line(vertex2d, vertex2d2);
        return Line2D.cross_point(line2d, line2d1);
    }
}
