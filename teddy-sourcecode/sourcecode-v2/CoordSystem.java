// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoordSystem.java

package teddy;

import java.io.Serializable;

// Referenced classes of package teddy:
//            Vector3, Vertex

public class CoordSystem
    implements Serializable
{

    CoordSystem(Vector3 vector3, Vector3 vector3_1, Vector3 vector3_2)
    {
        base_x = vector3;
        base_y = vector3_1;
        base_z = vector3_2;
    }

    public Vertex translate(Vertex vertex)
    {
        double d = vertex.dot_product(base_x);
        double d1 = vertex.dot_product(base_y);
        double d2 = vertex.dot_product(base_z);
        return new Vertex(d, d1, d2);
    }

    public Vector3 translate(Vector3 vector3)
    {
        double d = vector3.dot_product(base_x);
        double d1 = vector3.dot_product(base_y);
        double d2 = vector3.dot_product(base_z);
        return new Vector3(d, d1, d2);
    }

    public Vertex reverse_translate(Vertex vertex)
    {
        Vector3 vector3 = base_x.multiple(((Vector3) (vertex)).x);
        Vector3 vector3_1 = base_y.multiple(((Vector3) (vertex)).y);
        Vector3 vector3_2 = base_z.multiple(((Vector3) (vertex)).z);
        return new Vertex(vector3.add(vector3_1).add(vector3_2));
    }

    public Vertex reverse_translate(double d, double d1, double d2)
    {
        Vector3 vector3 = base_x.multiple(d);
        Vector3 vector3_1 = base_y.multiple(d1);
        Vector3 vector3_2 = base_z.multiple(d2);
        return new Vertex(vector3.add(vector3_1).add(vector3_2));
    }

    public Vector3 reverse_translate(Vector3 vector3)
    {
        Vector3 vector3_1 = base_x.multiple(vector3.x);
        Vector3 vector3_2 = base_y.multiple(vector3.y);
        Vector3 vector3_3 = base_z.multiple(vector3.z);
        return vector3_1.add(vector3_2).add(vector3_3);
    }

    public Vector3 base_x;
    public Vector3 base_y;
    public Vector3 base_z;
}
