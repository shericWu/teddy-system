// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Segments.java

package teddy;

import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, Segment, Node, Def

public class Segments
    implements Serializable
{

    public void reset()
    {
        segments.reset();
    }

    public Segment nextElement()
    {
        return (Segment)segments.nextElement();
    }

    Segments()
    {
        segments = new LinkedList();
    }

    public Enumeration elements()
    {
        return segments.elements();
    }

    public int size()
    {
        return segments.size();
    }

    public boolean hasMoreElements()
    {
        return segments.hasMoreElements();
    }

    public Segment get_closest(double d, double d1, double d2)
    {
        double d3 = d2;
        Node node = new Node(d, d1);
        Segment segment = null;
        for(Enumeration enumeration = elements(); enumeration.hasMoreElements();)
        {
            Segment segment1 = (Segment)enumeration.nextElement();
            double d4 = segment1.distance(node);
            if(d3 == d4 && segment != null)
            {
                if(segment1.length() < segment.length())
                    segment = segment1;
            } else
            if(d3 >= d4)
            {
                d3 = d4;
                segment = segment1;
            }
        }

        return segment;
    }

    public void clear()
    {
        segments = new LinkedList();
    }

    public boolean contain_identical_segment(Segment segment)
    {
        for(Enumeration enumeration = elements(); enumeration.hasMoreElements();)
            if(segment.same((Segment)enumeration.nextElement()))
                return true;

        return false;
    }

    public void append(Segment segment)
    {
        if(!Def.negrigible(segment.length()))
            segments.append(segment);
    }

    public Segment currentElement()
    {
        return (Segment)segments.currentElement();
    }

    public void remove()
    {
        segments.remove();
    }

    public LinkedList segments;
}
