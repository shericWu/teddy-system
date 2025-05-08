// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Skeleton.java

package teddy;


// Referenced classes of package teddy:
//            Edge2D, SkVertex2D, SkPolygon2D, Vector2

class SkEdge2D extends Edge2D
{

    SkEdge2D(SkVertex2D skvertex2d, SkVertex2D skvertex2d1, int i)
    {
        right_polygon = null;
        left_polygon = null;
        height = -1D;
        super.start = skvertex2d;
        super.end = skvertex2d1;
        skvertex2d.add_owner(this);
        skvertex2d1.add_owner(this);
        type = i;
    }

    public void set_left_polygon(SkPolygon2D skpolygon2d)
    {
        left_polygon = skpolygon2d;
    }

    public SkPolygon2D the_other_polygon(SkPolygon2D skpolygon2d)
    {
        if(left_polygon == skpolygon2d)
            return right_polygon;
        else
            return left_polygon;
    }

    public void set_height()
    {
        if(type == 2 && height == -1D)
            height = get_average_height(right_polygon, left_polygon);
    }

    private double get_average_height(SkPolygon2D skpolygon2d, SkPolygon2D skpolygon2d1)
    {
        Vertex2D vertex2d = mid_point();
        Object obj1;
        if(skpolygon2d1.type == 2)
            obj1 = skpolygon2d1.center;
        else
        if(skpolygon2d1.type == 1)
            obj1 = skpolygon2d1.the_other_internal_edge(this).mid_point();
        else
            obj1 = skpolygon2d1.get_terminal_vertex();
        Object obj;
        if(skpolygon2d.type == 2)
            obj = skpolygon2d.center;
        else
        if(skpolygon2d.type == 1)
            obj = skpolygon2d.the_other_internal_edge(this).mid_point();
        else
            obj = skpolygon2d.get_terminal_vertex();
        double d = Vector2.distance(vertex2d, ((Vertex2D) (obj)));
        double d1 = Vector2.distance(vertex2d, ((Vertex2D) (obj1)));
        double d2 = skpolygon2d1.height;
        double d3 = skpolygon2d.height;
        return (d2 * d + d3 * d1) / (d1 + d);
    }

    public boolean out_of_circle(SkVertex2D skvertex2d)
    {
        Vector2 vector2 = new Vector2(skvertex2d, super.start);
        Vector2 vector2_1 = new Vector2(skvertex2d, super.end);
        return vector2.get_cos(vector2_1) >= 0.0D;
    }

    public void set_right_polygon(SkPolygon2D skpolygon2d)
    {
        right_polygon = skpolygon2d;
    }

    public static final int EXTERNAL = 0;
    public static final int INTERNAL = 1;
    public static final int INTERNAL_SHARED = 2;
    int type;
    SkPolygon2D right_polygon;
    SkPolygon2D left_polygon;
    public double height;
}
