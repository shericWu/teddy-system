// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trianglation2D.java

package teddy;

import java.util.Vector;

// Referenced classes of package teddy:
//            TrVertex, TrEdge, Trianglation2D, Edge2D, 
//            LinkedList

class Triangle
{

    private void add_edge(TrVertex trvertex, TrVertex trvertex1)
    {
        TrEdge tredge = trvertex.shared_edge(trvertex1);
        if(tredge == null)
        {
            tredge = new TrEdge(trvertex, trvertex1);
            Trianglation2D.edges.addElement(tredge);
        }
        if(((Edge2D) (tredge)).start == trvertex)
            tredge.left_triangle = this;
        else
            tredge.right_triangle = this;
        edges.addElement(tredge);
    }

    Triangle(TrVertex trvertex, TrVertex trvertex1, TrVertex trvertex2)
    {
        edges = new Vector();
        destroyed = false;
        add_edge(trvertex, trvertex1);
        add_edge(trvertex1, trvertex2);
        add_edge(trvertex2, trvertex);
    }

    public TrVertex get_opposite_vertex(TrEdge tredge)
    {
        int i = 0;
        do
            if(edges(i) == tredge)
                return edges(i + 1).get_common_vertex(edges(i + 2));
        while(++i < 3);
        return null;
    }

    public void destroy()
    {
        int i = 0;
        do
            edges(i).remove_triangle(this);
        while(++i < 3);
        Trianglation2D.triangles.removeElement(this);
        destroyed = true;
    }

    public TrEdge edges(int i)
    {
        if(i >= edges.size())
            i -= (i / edges.size()) * edges.size();
        if(i < 0)
            i += (-i / edges.size() + 1) * edges.size();
        return (TrEdge)edges.elementAt(i);
    }

    public LinkedList original_edges()
    {
        LinkedList linkedlist = new LinkedList();
        int i = 0;
        do
            linkedlist.append(edges(i).original);
        while(++i < 3);
        return linkedlist;
    }

    Vector edges;
    public boolean destroyed;
}
