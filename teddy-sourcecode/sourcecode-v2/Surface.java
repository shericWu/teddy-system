// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Surface.java

package teddy;


// Referenced classes of package teddy:
//            Edge, Vertex, Vector3

class Surface
{

    public Vertex cross_point(Edge edge)
    {
        double d = signed_distance(edge.start);
        double d1 = signed_distance(edge.end);
        double d2 = d - d1;
        return new Vertex(edge.start.add(edge.vector3().multiple(d / d2)));
    }

    Surface()
    {
        base = new Vertex();
        normal = new Vector3();
    }

    Surface(Vertex vertex, Vector3 vector3)
    {
        base = vertex;
        normal = vector3;
        normal.normalize();
    }

    Surface(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        Vector3 vector3 = new Vector3(vertex, vertex1);
        Vector3 vector3_1 = new Vector3(vertex, vertex2);
        normal = vector3.cross_product(vector3_1);
        base = vertex;
        normal.normalize();
    }

    public double angle(Vector3 vector3)
    {
        double d = normal.get_relative_angle(vector3);
        return Math.abs(d - 1.5707963267948966D);
    }

    public static Surface get_normal_surface(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        Vector3 vector3 = new Vector3(vertex, vertex1);
        Vector3 vector3_1 = new Vector3(vertex1, vertex2);
        vector3.normalize();
        vector3_1.normalize();
        return new Surface(vertex1, vector3.add(vector3_1));
    }

    public double signed_distance(Vertex vertex)
    {
        Vector3 vector3 = new Vector3(base, vertex);
        return normal.dot_product(vector3);
    }

    public double distance(Vertex vertex)
    {
        Vector3 vector3 = new Vector3(base, vertex);
        return Math.abs(normal.dot_product(vector3));
    }

    public Vertex base;
    public Vector3 normal;
}
