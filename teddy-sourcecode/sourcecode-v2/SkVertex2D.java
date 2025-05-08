// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Skeleton.java

package teddy;

import java.awt.Point;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Vertex2D, Vector2, LinkedList, SkEdge2D

class SkVertex2D extends Vertex2D
{

    SkVertex2D(Point point)
    {
        edges = null;
        super.x = point.x;
        super.y = point.y;
    }

    SkVertex2D(Vertex2D vertex2d)
    {
        edges = null;
        super.x = ((Vector2) (vertex2d)).x;
        super.y = ((Vector2) (vertex2d)).y;
    }

    SkVertex2D(double d, double d1)
    {
        edges = null;
        super.x = d;
        super.y = d1;
    }

    public void remove_owner(SkEdge2D skedge2d)
    {
        edges.remove(skedge2d);
    }

    public void add_owner(SkEdge2D skedge2d)
    {
        if(edges == null)
            edges = new LinkedList();
        edges.append(skedge2d);
    }

    public LinkedList get_not_shared_edges()
    {
        LinkedList linkedlist = new LinkedList();
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            SkEdge2D skedge2d = (SkEdge2D)enumeration.nextElement();
            if(skedge2d.type == 1)
                linkedlist.append(skedge2d);
        }

        return linkedlist;
    }

    double height;
    LinkedList edges;
}
