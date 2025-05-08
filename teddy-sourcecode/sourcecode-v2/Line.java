// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Line.java

package teddy;


// Referenced classes of package teddy:
//            Vertex, Vector3

class Line
{

    Line()
    {
        base = new Vertex();
        direction = new Vector3();
    }

    Line(Vertex vertex, Vector3 vector3)
    {
        base = vertex;
        direction = vector3;
        direction.normalize();
    }

    public Vertex get_foot(Vertex vertex)
    {
        double d = vertex.add(base.reverse()).dot_product(direction);
        return base.shift(direction.multiple(d));
    }

    public Vertex base;
    public Vector3 direction;
}
