// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Skeleton.java

package teddy;

import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, Vector2, Vertex2D, SkEdge2D, 
//            Edge2D, SkVertex2D, Def, Geometry2D, 
//            TrimData

class SkPolygon2D
{

    private Vertex2D get_gravity_center()
    {
        double d = 0.0D;
        double d1 = 0.0D;
        int i = edges.size();
        for(int j = 0; j < i; j++)
        {
            Vertex2D vertex2d = get_vertex(j);
            d += ((Vector2) (vertex2d)).x;
            d1 += ((Vector2) (vertex2d)).y;
        }

        d /= i;
        d1 /= i;
        return new Vertex2D(d, d1);
    }

    public double average_edge_length()
    {
        Enumeration enumeration = edges.elements();
        double d;
        for(d = 0.0D; enumeration.hasMoreElements(); d += ((SkEdge2D)enumeration.nextElement()).length());
        return d / (double)edges.size();
    }

    SkPolygon2D(SkEdge2D skedge2d, SkEdge2D skedge2d1, SkEdge2D skedge2d2, int i)
    {
        height = -1D;
        marked = false;
        trimData = null;
        edges = new LinkedList();
        edges.append(skedge2d);
        edges.append(skedge2d1);
        edges.append(skedge2d2);
        type = i;
        set_variables();
    }

    SkPolygon2D(LinkedList linkedlist, int i)
    {
        height = -1D;
        marked = false;
        trimData = null;
        edges = linkedlist.copy();
        type = i;
        set_variables();
    }

    SkPolygon2D(SkEdge2D skedge2d, SkVertex2D skvertex2d)
    {
        height = -1D;
        marked = false;
        trimData = null;
        center = skvertex2d;
        SkEdge2D skedge2d1 = new SkEdge2D((SkVertex2D)((Edge2D) (skedge2d)).end, center, 1);
        SkEdge2D skedge2d2 = new SkEdge2D(center, (SkVertex2D)((Edge2D) (skedge2d)).start, 1);
        edges = new LinkedList();
        edges.append(skedge2d);
        edges.append(skedge2d1);
        edges.append(skedge2d2);
        type = 3;
        set_variables();
    }

    public SkVertex2D get_terminal_vertex()
    {
        if(get_edge(0).type == 2)
            return (SkVertex2D)get_vertex(2);
        if(get_edge(1).type == 2)
            return (SkVertex2D)get_vertex(0);
        else
            return (SkVertex2D)get_vertex(1);
    }

    public LinkedList get_internal_edges()
    {
        LinkedList linkedlist = new LinkedList();
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            SkEdge2D skedge2d = (SkEdge2D)enumeration.nextElement();
            if(skedge2d.type == 2)
                linkedlist.append(skedge2d);
        }

        return linkedlist;
    }

    public SkEdge2D get_internal_edge()
    {
        if(get_edge(0).type == 2)
            return get_edge(0);
        if(get_edge(1).type == 2)
            return get_edge(1);
        else
            return get_edge(2);
    }

    public void mark()
    {
        marked = true;
    }

    public SkEdge2D get_edge(int i)
    {
        int j = edges.size();
        if(i >= j)
            i -= (i / j) * j;
        if(i < 0)
            i += (-i / j + 1) * j;
        Enumeration enumeration = edges.elements();
        SkEdge2D skedge2d = null;
        for(int k = 0; k <= i; k++)
            skedge2d = (SkEdge2D)enumeration.nextElement();

        return skedge2d;
    }

    public SkEdge2D the_other_internal_edge(SkEdge2D skedge2d)
    {
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            SkEdge2D skedge2d1 = (SkEdge2D)enumeration.nextElement();
            if(skedge2d1.type == 2 && skedge2d1 != skedge2d)
                return skedge2d1;
        }

        System.out.println("fail in SkPolygon2D.the_other_internal_edge");
        return null;
    }

    public SkEdge2D get_external_edge()
    {
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            SkEdge2D skedge2d = (SkEdge2D)enumeration.nextElement();
            if(skedge2d.type == 0)
                return skedge2d;
        }

        System.out.println("fail in SkPolygon2D.get_external_edge");
        return null;
    }

    public SkEdge2D get_longest_edge()
    {
        Enumeration enumeration = edges.elements();
        double d = -1D;
        SkEdge2D skedge2d = null;
        while(enumeration.hasMoreElements()) 
        {
            SkEdge2D skedge2d1 = (SkEdge2D)enumeration.nextElement();
            double d1 = skedge2d1.length();
            if(d1 > d)
            {
                d = d1;
                skedge2d = skedge2d1;
            }
        }
        return skedge2d;
    }

    public SkVertex2D get_internal_vertex()
    {
        LinkedList linkedlist = get_internal_edges();
        SkEdge2D skedge2d = (SkEdge2D)linkedlist.head();
        SkEdge2D skedge2d1 = (SkEdge2D)linkedlist.tail();
        return (SkVertex2D)skedge2d.get_common_vertex(skedge2d1);
    }

    public int get_index(SkEdge2D skedge2d)
    {
        Enumeration enumeration = edges.elements();
        for(int i = 0; enumeration.hasMoreElements(); i++)
            if((SkEdge2D)enumeration.nextElement() == skedge2d)
                return i;

        return -1;
    }

    private void set_center()
    {
        if(edges.size() == 3)
        {
            Vector2 vector2 = new Vector2(get_vertex(0), get_vertex(1));
            Vector2 vector2_1 = new Vector2(get_vertex(1), get_vertex(2));
            Vector2 vector2_2 = new Vector2(get_vertex(2), get_vertex(0));
            if(vector2.dot_product(vector2_1) >= 0.0D)
                center_edge = get_edge(2);
            else
            if(vector2_1.dot_product(vector2_2) >= 0.0D)
                center_edge = get_edge(0);
            else
            if(vector2_2.dot_product(vector2) >= 0.0D)
            {
                center_edge = get_edge(1);
            } else
            {
                center_edge = null;
                Vertex2D vertex2d = get_circumcenter();
                if(vertex2d == null)
                {
                    System.out.println("error in Skeleton.set_center");
                    vertex2d = get_gravity_center();
                }
                center = new SkVertex2D(vertex2d);
                return;
            }
            center = new SkVertex2D(center_edge.mid_point());
            return;
        }
        center_edge = null;
        center = new SkVertex2D(get_gravity_center());
        double d = -1D;
        for(int i = 0; i < edges.size(); i++)
        {
            double d1 = Vector2.distance(get_vertex(i), center);
            if(d1 > d)
                d = d1;
        }

        center.height = d * Def.GENERATE_HEIGHT;
    }

    private Vertex2D get_circumcenter()
    {
        return Geometry2D.get_circumcenter(get_vertex(0), get_vertex(1), get_vertex(2));
    }

    public Vertex2D get_vertex(int i)
    {
        SkEdge2D skedge2d = get_edge(i);
        if(skedge2d.left_polygon == this)
            return ((Edge2D) (skedge2d)).start;
        else
            return ((Edge2D) (skedge2d)).end;
    }

    public LinkedList get_external_edges()
    {
        LinkedList linkedlist = new LinkedList();
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            SkEdge2D skedge2d = (SkEdge2D)enumeration.nextElement();
            if(skedge2d.type == 0)
                linkedlist.append(skedge2d);
        }

        return linkedlist;
    }

    public SkEdge2D get_shortest_edge()
    {
        Enumeration enumeration = edges.elements();
        double d = 1.7976931348623157E+308D;
        SkEdge2D skedge2d = null;
        while(enumeration.hasMoreElements()) 
        {
            SkEdge2D skedge2d1 = (SkEdge2D)enumeration.nextElement();
            double d1 = skedge2d1.length();
            if(d1 < d)
            {
                d = d1;
                skedge2d = skedge2d1;
            }
        }
        return skedge2d;
    }

    public void setTrimData(SkEdge2D skedge2d, TrimData trimdata)
    {
        if(trimData == null)
            trimData = new TrimData[edges.size()];
        int i = get_index(skedge2d);
        trimData[i] = trimdata;
    }

    public TrimData getTrimData(int i)
    {
        if(trimData == null)
            return null;
        else
            return trimData[i];
    }

    private void set_variables()
    {
        Enumeration enumeration = edges.elements();
        SkEdge2D skedge2d;
        SkEdge2D skedge2d1;
        for(skedge2d = (SkEdge2D)enumeration.nextElement(); enumeration.hasMoreElements(); skedge2d = skedge2d1)
        {
            skedge2d1 = (SkEdge2D)enumeration.nextElement();
            if(skedge2d1.contains(((Edge2D) (skedge2d)).end))
                skedge2d.set_left_polygon(this);
            else
                skedge2d.set_right_polygon(this);
        }

        SkEdge2D skedge2d2 = (SkEdge2D)edges.head();
        if(skedge2d2.contains(((Edge2D) (skedge2d)).end))
            skedge2d.set_left_polygon(this);
        else
            skedge2d.set_right_polygon(this);
        if(type == 2)
        {
            set_center();
            trimData = new TrimData[edges.size()];
        }
    }

    public TrimData getTrimData(SkEdge2D skedge2d)
    {
        if(trimData == null)
            return null;
        else
            return trimData[get_index(skedge2d)];
    }

    public LinkedList edges;
    public int type;
    public SkVertex2D center;
    public double height;
    public SkEdge2D center_edge;
    public boolean marked;
    public static final int TERMINAL = 0;
    public static final int SLEEVE = 1;
    public static final int JUNCTION = 2;
    public static final int COVER = 3;
    public TrimData trimData[];
}
