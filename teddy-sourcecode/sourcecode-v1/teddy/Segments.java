/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import teddy.Def;
import teddy.LinkedList;
import teddy.Node;
import teddy.Segment;

public class Segments
implements Serializable {
    public LinkedList segments = new LinkedList();

    public void reset() {
        this.segments.reset();
    }

    public Segment nextElement() {
        return (Segment)this.segments.nextElement();
    }

    Segments() {
    }

    public Enumeration elements() {
        return this.segments.elements();
    }

    public int size() {
        return this.segments.size();
    }

    public boolean hasMoreElements() {
        return this.segments.hasMoreElements();
    }

    public Segment get_closest(double d, double d2, double d3) {
        double d4 = d3;
        Node node = new Node(d, d2);
        Segment segment = null;
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            Segment segment2 = (Segment)enumeration.nextElement();
            double d5 = segment2.distance(node);
            if (d4 == d5 && segment != null) {
                if (!(segment2.length() < segment.length())) continue;
                segment = segment2;
                continue;
            }
            if (!(d4 >= d5)) continue;
            d4 = d5;
            segment = segment2;
        }
        return segment;
    }

    public void clear() {
        this.segments = new LinkedList();
    }

    public boolean contain_identical_segment(Segment segment) {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            if (!segment.same((Segment)enumeration.nextElement())) continue;
            return true;
        }
        return false;
    }

    public void append(Segment segment) {
        if (!Def.negrigible(segment.length())) {
            this.segments.append(segment);
        }
    }

    public Segment currentElement() {
        return (Segment)this.segments.currentElement();
    }

    public void remove() {
        this.segments.remove();
    }
}

