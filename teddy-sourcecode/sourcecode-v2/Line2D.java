// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Geometry2D.java

package teddy;


// Referenced classes of package teddy:
//            Vector2, Vertex2D

class Line2D
{

    public static Vertex2D cross_point(Line2D line2d, Line2D line2d1)
    {
        Vertex2D vertex2d = line2d.base;
        Vector2 vector2 = line2d.direction;
        Vertex2D vertex2d1 = line2d1.base;
        Vector2 vector2_1 = line2d1.direction;
        double d = vector2.x;
        double d1 = -vector2_1.x;
        double d2 = vector2.y;
        double d3 = -vector2_1.y;
        double d4 = ((Vector2) (vertex2d1)).x - ((Vector2) (vertex2d)).x;
        double d5 = ((Vector2) (vertex2d1)).y - ((Vector2) (vertex2d)).y;
        double d6 = d * d3 - d1 * d2;
        if(d6 == 0.0D)
        {
            return null;
        } else
        {
            double d7 = d3 / d6;
            double d8 = -d1 / d6;
            double d9 = -d2 / d6;
            double d10 = d / d6;
            double d11 = d7 * d4 + d8 * d5;
            double d12 = ((Vector2) (vertex2d)).x + vector2.x * d11;
            double d13 = ((Vector2) (vertex2d)).y + vector2.y * d11;
            return new Vertex2D(d12, d13);
        }
    }

    Line2D(Vertex2D vertex2d, Vector2 vector2)
    {
        base = vertex2d;
        direction = vector2;
    }

    Vertex2D base;
    Vector2 direction;
}
