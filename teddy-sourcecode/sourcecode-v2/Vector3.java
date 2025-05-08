// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vector3.java

package teddy;

import java.io.Serializable;

// Referenced classes of package teddy:
//            Vertex, Point2

public class Vector3
    implements Serializable
{

    public static double distance(Vertex vertex1, Vertex vertex2)
    {
        return distance(((Vector3) (vertex1)).x, ((Vector3) (vertex1)).y, ((Vector3) (vertex1)).z, ((Vector3) (vertex2)).x, ((Vector3) (vertex2)).y, ((Vector3) (vertex2)).z);
    }

    public void normalize_self()
    {
        normalize();
    }

    public void normalize()
    {
        double d = length();
        x /= d;
        y /= d;
        z /= d;
    }

    public double dot_product(Vector3 vector3)
    {
        return x * vector3.x + y * vector3.y + z * vector3.z;
    }

    public double sin(Vector3 vector3)
    {
        double d = Math.sqrt((x * x + y * y + z * z) * (vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z));
        if(d > 0.0D)
            return cross_product(vector3).length() / d;
        else
            return 0.0D;
    }

    public boolean parallel(Vector3 vector3)
    {
        double d = sin(vector3);
        return d < 0.01D && d > -0.01D;
    }

    Vector3()
    {
    }

    Vector3(Vertex vertex1, Vertex vertex2)
    {
        x = ((Vector3) (vertex2)).x - ((Vector3) (vertex1)).x;
        y = ((Vector3) (vertex2)).y - ((Vector3) (vertex1)).y;
        z = ((Vector3) (vertex2)).z - ((Vector3) (vertex1)).z;
    }

    Vector3(double d, double d1, double d2)
    {
        x = d;
        y = d1;
        z = d2;
    }

    public Vector3 add(Vector3 vector3)
    {
        return new Vector3(x + vector3.x, y + vector3.y, z + vector3.z);
    }

    public double get_cos(Vector3 vector3)
    {
        return cos(vector3);
    }

    public double get_sin(Vector3 vector3)
    {
        return sin(vector3);
    }

    public void rotate(int i, double d)
    {
        if(i == 0)
        {
            rotate_x(d);
            return;
        }
        if(i == 1)
        {
            rotate_y(d);
            return;
        } else
        {
            rotate_z(d);
            return;
        }
    }

    public static Vertex interporate(Vertex vertex1, Vertex vertex2, double d)
    {
        return new Vertex(((Vector3) (vertex1)).x * (1.0D - d) + ((Vector3) (vertex2)).x * d, ((Vector3) (vertex1)).y * (1.0D - d) + ((Vector3) (vertex2)).y * d, ((Vector3) (vertex1)).z * (1.0D - d) + ((Vector3) (vertex2)).z * d);
    }

    public void multiple_self(double d)
    {
        x *= d;
        y *= d;
        z *= d;
    }

    public void rotate_x(double d)
    {
        Point2 point2 = rotate_sub(y, z, d);
        y = point2.x;
        z = point2.y;
    }

    public Vector3 cross_product(Vector3 vector3)
    {
        double d = y * vector3.z - z * vector3.y;
        double d1 = z * vector3.x - x * vector3.z;
        double d2 = x * vector3.y - y * vector3.x;
        return new Vector3(d, d1, d2);
    }

    public Vector3 copyVector3()
    {
        return new Vector3(x, y, z);
    }

    public void rotate_y(double d)
    {
        Point2 point2 = rotate_sub(z, x, d);
        z = point2.x;
        x = point2.y;
    }

    public Vector3 reverse()
    {
        return new Vector3(-x, -y, -z);
    }

    public Vertex vertex()
    {
        return new Vertex(x, y, z);
    }

    public Vector3 multiple(double d)
    {
        return new Vector3(x * d, y * d, z * d);
    }

    public double get_relative_angle(Vector3 vector3)
    {
        double d = cos(vector3);
        if(d <= -1D)
            return 3.1415926535897931D;
        if(d >= 1.0D)
            return 0.0D;
        else
            return Math.acos(cos(vector3));
    }

    public double get_angle(Vector3 vector3, Vector3 vector3_1)
    {
        double d = get_cos(vector3);
        double d1 = get_sin(vector3);
        if(cross_product(vector3).dot_product(vector3_1) < 0.0D)
            d1 *= -1D;
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

    public void add_self(Vector3 vector3)
    {
        x += vector3.x;
        y += vector3.y;
        z += vector3.z;
    }

    public void rotate_z(double d)
    {
        Point2 point2 = rotate_sub(x, y, d);
        x = point2.x;
        y = point2.y;
    }

    public Vector3 get_normalized()
    {
        double d = length();
        return new Vector3(x / d, y / d, z / d);
    }

    public Point2 rotate_sub(double d, double d1, double d2)
    {
        double d3 = Math.cos((3.1415926535897931D * d2) / 180D);
        double d4 = Math.sin((3.1415926535897931D * d2) / 180D);
        double d5 = d3 * d - d4 * d1;
        double d6 = d4 * d + d3 * d1;
        return new Point2(d5, d6);
    }

    public double length()
    {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double cos(Vector3 vector3)
    {
        double d = Math.sqrt((x * x + y * y + z * z) * (vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z));
        if(d > 0.0D)
            return dot_product(vector3) / d;
        else
            return 0.0D;
    }

    public static double distance(double d, double d1, double d2, double d3, 
            double d4, double d5)
    {
        return Math.sqrt((d3 - d) * (d3 - d) + (d4 - d1) * (d4 - d1) + (d5 - d2) * (d5 - d2));
    }

    public double x;
    public double y;
    public double z;
}
