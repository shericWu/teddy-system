/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.Def;
import teddy.Geometry2D;
import teddy.LinkedList;
import teddy.SkEdge2D;
import teddy.SkVertex2D;
import teddy.TrimData;
import teddy.Vector2;
import teddy.Vertex2D;

class SkPolygon2D {
    public LinkedList edges;
    public int type;
    public SkVertex2D center;
    public double height = -1.0;
    public SkEdge2D center_edge;
    public boolean marked = false;
    public static final int TERMINAL = 0;
    public static final int SLEEVE = 1;
    public static final int JUNCTION = 2;
    public static final int COVER = 3;
    public TrimData[] trimData = null;

    private Vertex2D get_gravity_center() {
        double d = 0.0;
        double d2 = 0.0;
        int n = this.edges.size();
        int n2 = 0;
        while (n2 < n) {
            Vertex2D vertex2D = this.get_vertex(n2);
            d += vertex2D.x;
            d2 += vertex2D.y;
            ++n2;
        }
        return new Vertex2D(d /= (double)n, d2 /= (double)n);
    }

    public double average_edge_length() {
        Enumeration enumeration = this.edges.elements();
        double d = 0.0;
        while (enumeration.hasMoreElements()) {
            d += ((SkEdge2D)enumeration.nextElement()).length();
        }
        return d / (double)this.edges.size();
    }

    SkPolygon2D(SkEdge2D skEdge2D, SkEdge2D skEdge2D2, SkEdge2D skEdge2D3, int n) {
        this.edges = new LinkedList();
        this.edges.append(skEdge2D);
        this.edges.append(skEdge2D2);
        this.edges.append(skEdge2D3);
        this.type = n;
        this.set_variables();
    }

    SkPolygon2D(LinkedList linkedList, int n) {
        this.edges = linkedList.copy();
        this.type = n;
        this.set_variables();
    }

    SkPolygon2D(SkEdge2D skEdge2D, SkVertex2D skVertex2D) {
        this.center = skVertex2D;
        SkEdge2D skEdge2D2 = new SkEdge2D((SkVertex2D)skEdge2D.end, this.center, 1);
        SkEdge2D skEdge2D3 = new SkEdge2D(this.center, (SkVertex2D)skEdge2D.start, 1);
        this.edges = new LinkedList();
        this.edges.append(skEdge2D);
        this.edges.append(skEdge2D2);
        this.edges.append(skEdge2D3);
        this.type = 3;
        this.set_variables();
    }

    public SkVertex2D get_terminal_vertex() {
        if (this.get_edge((int)0).type == 2) {
            return (SkVertex2D)this.get_vertex(2);
        }
        if (this.get_edge((int)1).type == 2) {
            return (SkVertex2D)this.get_vertex(0);
        }
        return (SkVertex2D)this.get_vertex(1);
    }

    public LinkedList get_internal_edges() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.type != 2) continue;
            linkedList.append(skEdge2D);
        }
        return linkedList;
    }

    public SkEdge2D get_internal_edge() {
        if (this.get_edge((int)0).type == 2) {
            return this.get_edge(0);
        }
        if (this.get_edge((int)1).type == 2) {
            return this.get_edge(1);
        }
        return this.get_edge(2);
    }

    public void mark() {
        this.marked = true;
    }

    public SkEdge2D get_edge(int n) {
        int n2 = this.edges.size();
        if (n >= n2) {
            n -= n / n2 * n2;
        }
        if (n < 0) {
            n += (-n / n2 + 1) * n2;
        }
        Enumeration enumeration = this.edges.elements();
        SkEdge2D skEdge2D = null;
        int n3 = 0;
        while (n3 <= n) {
            skEdge2D = (SkEdge2D)enumeration.nextElement();
            ++n3;
        }
        return skEdge2D;
    }

    public SkEdge2D the_other_internal_edge(SkEdge2D skEdge2D) {
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D2 = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D2.type != 2 || skEdge2D2 == skEdge2D) continue;
            return skEdge2D2;
        }
        System.out.println("fail in SkPolygon2D.the_other_internal_edge");
        return null;
    }

    public SkEdge2D get_external_edge() {
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.type != 0) continue;
            return skEdge2D;
        }
        System.out.println("fail in SkPolygon2D.get_external_edge");
        return null;
    }

    public SkEdge2D get_longest_edge() {
        Enumeration enumeration = this.edges.elements();
        double d = -1.0;
        SkEdge2D skEdge2D = null;
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D2 = (SkEdge2D)enumeration.nextElement();
            double d2 = skEdge2D2.length();
            if (!(d2 > d)) continue;
            d = d2;
            skEdge2D = skEdge2D2;
        }
        return skEdge2D;
    }

    public SkVertex2D get_internal_vertex() {
        LinkedList linkedList = this.get_internal_edges();
        SkEdge2D skEdge2D = (SkEdge2D)linkedList.head();
        SkEdge2D skEdge2D2 = (SkEdge2D)linkedList.tail();
        return (SkVertex2D)skEdge2D.get_common_vertex(skEdge2D2);
    }

    public int get_index(SkEdge2D skEdge2D) {
        Enumeration enumeration = this.edges.elements();
        int n = 0;
        while (enumeration.hasMoreElements()) {
            if ((SkEdge2D)enumeration.nextElement() == skEdge2D) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private void set_center() {
        if (this.edges.size() == 3) {
            Vector2 vector2 = new Vector2(this.get_vertex(0), this.get_vertex(1));
            Vector2 vector22 = new Vector2(this.get_vertex(1), this.get_vertex(2));
            Vector2 vector23 = new Vector2(this.get_vertex(2), this.get_vertex(0));
            if (vector2.dot_product(vector22) >= 0.0) {
                this.center_edge = this.get_edge(2);
            } else if (vector22.dot_product(vector23) >= 0.0) {
                this.center_edge = this.get_edge(0);
            } else if (vector23.dot_product(vector2) >= 0.0) {
                this.center_edge = this.get_edge(1);
            } else {
                this.center_edge = null;
                Vertex2D vertex2D = this.get_circumcenter();
                if (vertex2D == null) {
                    System.out.println("error in Skeleton.set_center");
                    vertex2D = this.get_gravity_center();
                }
                this.center = new SkVertex2D(vertex2D);
                return;
            }
            this.center = new SkVertex2D(this.center_edge.mid_point());
            return;
        }
        this.center_edge = null;
        this.center = new SkVertex2D(this.get_gravity_center());
        double d = -1.0;
        int n = 0;
        while (n < this.edges.size()) {
            double d2 = Vector2.distance(this.get_vertex(n), this.center);
            if (d2 > d) {
                d = d2;
            }
            ++n;
        }
        this.center.height = d * Def.GENERATE_HEIGHT;
    }

    private Vertex2D get_circumcenter() {
        return Geometry2D.get_circumcenter(this.get_vertex(0), this.get_vertex(1), this.get_vertex(2));
    }

    public Vertex2D get_vertex(int n) {
        SkEdge2D skEdge2D = this.get_edge(n);
        if (skEdge2D.left_polygon == this) {
            return skEdge2D.start;
        }
        return skEdge2D.end;
    }

    public LinkedList get_external_edges() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.type != 0) continue;
            linkedList.append(skEdge2D);
        }
        return linkedList;
    }

    public SkEdge2D get_shortest_edge() {
        Enumeration enumeration = this.edges.elements();
        double d = Double.MAX_VALUE;
        SkEdge2D skEdge2D = null;
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D2 = (SkEdge2D)enumeration.nextElement();
            double d2 = skEdge2D2.length();
            if (!(d2 < d)) continue;
            d = d2;
            skEdge2D = skEdge2D2;
        }
        return skEdge2D;
    }

    public void setTrimData(SkEdge2D skEdge2D, TrimData trimData) {
        if (this.trimData == null) {
            this.trimData = new TrimData[this.edges.size()];
        }
        int n = this.get_index(skEdge2D);
        this.trimData[n] = trimData;
    }

    public TrimData getTrimData(int n) {
        if (this.trimData == null) {
            return null;
        }
        return this.trimData[n];
    }

    private void set_variables() {
        SkEdge2D skEdge2D;
        Enumeration enumeration = this.edges.elements();
        SkEdge2D skEdge2D2 = (SkEdge2D)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.contains(skEdge2D2.end)) {
                skEdge2D2.set_left_polygon(this);
            } else {
                skEdge2D2.set_right_polygon(this);
            }
            skEdge2D2 = skEdge2D;
        }
        skEdge2D = (SkEdge2D)this.edges.head();
        if (skEdge2D.contains(skEdge2D2.end)) {
            skEdge2D2.set_left_polygon(this);
        } else {
            skEdge2D2.set_right_polygon(this);
        }
        if (this.type == 2) {
            this.set_center();
            this.trimData = new TrimData[this.edges.size()];
        }
    }

    public TrimData getTrimData(SkEdge2D skEdge2D) {
        if (this.trimData == null) {
            return null;
        }
        return this.trimData[this.get_index(skEdge2D)];
    }
}

