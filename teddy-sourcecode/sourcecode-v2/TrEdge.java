// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trianglation2D.java

package teddy;

import java.util.Vector;

// Referenced classes of package teddy:
//            Edge2D, TrVertex, Trianglation2D, Triangle, 
//            Edge

class TrEdge extends Edge2D
{

    TrEdge(TrVertex trvertex, TrVertex trvertex1)
    {
        left_triangle = null;
        right_triangle = null;
        destroyed = false;
        external = false;
        super.start = trvertex;
        super.end = trvertex1;
        ((TrVertex)super.start).edges.addElement(this);
        ((TrVertex)super.end).edges.addElement(this);
    }

    TrEdge(TrVertex trvertex, TrVertex trvertex1, boolean flag)
    {
        this(trvertex, trvertex1);
        external = flag;
    }

    public TrVertex get_common_vertex(TrEdge tredge)
    {
        if(tredge.contains(super.start))
            return (TrVertex)super.start;
        if(tredge.contains(super.end))
            return (TrVertex)super.end;
        else
            return null;
    }

    public void destroy()
    {
        ((TrVertex)super.start).remove_edge(this);
        ((TrVertex)super.end).remove_edge(this);
        Trianglation2D.edges.removeElement(this);
        destroyed = true;
    }

    public boolean contains(TrVertex trvertex)
    {
        return super.start == trvertex || super.end == trvertex;
    }

    public void remove_triangle(Triangle triangle)
    {
        if(left_triangle == triangle)
            left_triangle = null;
        if(right_triangle == triangle)
            right_triangle = null;
        if(right_triangle == null && left_triangle == null)
            destroy();
    }

    public Triangle left_triangle;
    public Triangle right_triangle;
    public boolean destroyed;
    public boolean external;
    public Edge original;
}
