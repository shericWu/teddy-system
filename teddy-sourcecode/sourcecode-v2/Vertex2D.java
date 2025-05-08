// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vertex2D.java

package teddy;

import java.awt.Point;

// Referenced classes of package teddy:
//            Vector2, Vector3, Vertex

class Vertex2D extends Vector2
{

    public static Vertex2D mid_point(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        return new Vertex2D((((Vector2) (vertex2d)).x + ((Vector2) (vertex2d1)).x) / 2D, (((Vector2) (vertex2d)).y + ((Vector2) (vertex2d1)).y) / 2D);
    }

    Vertex2D()
    {
    }

    Vertex2D(double d, double d1)
    {
        super.x = d;
        super.y = d1;
    }

    Vertex2D(Point point)
    {
        super.x = point.x;
        super.y = point.y;
    }

    Vertex2D(Vector2 vector2)
    {
        super.x = vector2.x;
        super.y = vector2.y;
    }

    Vertex2D(Vertex vertex)
    {
        super.x = ((Vector3) (vertex)).x;
        super.y = ((Vector3) (vertex)).y;
    }

    public Vertex2D translate(Vector2 vector2)
    {
        return new Vertex2D(super.x + vector2.x, super.y + vector2.y);
    }

    public Vertex2D copy()
    {
        Vertex2D vertex2d = new Vertex2D(super.x, super.y);
        return vertex2d;
    }

    public void warp(Vertex2D vertex2d)
    {
        super.x = ((Vector2) (vertex2d)).x;
        super.y = ((Vector2) (vertex2d)).y;
    }

    public boolean same_position(Vertex2D vertex2d)
    {
        return super.x == ((Vector2) (vertex2d)).x && super.y == ((Vector2) (vertex2d)).y;
    }
}
