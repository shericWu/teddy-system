/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Enumeration;
import teddy.LinkedList;
import teddy.SkEdge2D;
import teddy.Vertex2D;

class SkVertex2D
extends Vertex2D {
    double height;
    LinkedList edges = null;

    SkVertex2D(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    SkVertex2D(Vertex2D vertex2D) {
        this.x = vertex2D.x;
        this.y = vertex2D.y;
    }

    SkVertex2D(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void remove_owner(SkEdge2D skEdge2D) {
        this.edges.remove(skEdge2D);
    }

    public void add_owner(SkEdge2D skEdge2D) {
        if (this.edges == null) {
            this.edges = new LinkedList();
        }
        this.edges.append(skEdge2D);
    }

    public LinkedList get_not_shared_edges() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.type != 1) continue;
            linkedList.append(skEdge2D);
        }
        return linkedList;
    }
}

