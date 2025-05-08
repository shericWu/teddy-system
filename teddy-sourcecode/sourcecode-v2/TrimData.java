// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Skeleton.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, SkVertex2D, SkEdge2D

class TrimData
{

    public void merge(TrimData trimdata)
    {
        terminal_vertices.connect(trimdata.terminal_vertices);
        terminal_edges.connect(trimdata.terminal_edges);
    }

    public void append_terminal_edge(SkEdge2D skedge2d)
    {
        terminal_edges.append(skedge2d);
    }

    TrimData()
    {
        terminal_vertices = new LinkedList();
        terminal_edges = new LinkedList();
    }

    TrimData(SkVertex2D skvertex2d, LinkedList linkedlist)
    {
        terminal_vertices = new LinkedList();
        terminal_vertices.append(skvertex2d);
        terminal_edges = linkedlist;
    }

    public boolean terminals_are_within_this_circle(SkEdge2D skedge2d)
    {
        for(Enumeration enumeration = terminal_vertices.elements(); enumeration.hasMoreElements();)
        {
            SkVertex2D skvertex2d = (SkVertex2D)enumeration.nextElement();
            if(skedge2d.out_of_circle(skvertex2d))
                return false;
        }

        return true;
    }

    public LinkedList terminal_edges;
    public LinkedList terminal_vertices;
}
