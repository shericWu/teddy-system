/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.LinkedList;
import teddy.SkEdge2D;
import teddy.SkVertex2D;

class TrimData {
    public LinkedList terminal_edges;
    public LinkedList terminal_vertices = new LinkedList();

    public void merge(TrimData trimData) {
        this.terminal_vertices.connect(trimData.terminal_vertices);
        this.terminal_edges.connect(trimData.terminal_edges);
    }

    public void append_terminal_edge(SkEdge2D skEdge2D) {
        this.terminal_edges.append(skEdge2D);
    }

    TrimData() {
        this.terminal_edges = new LinkedList();
    }

    TrimData(SkVertex2D skVertex2D, LinkedList linkedList) {
        this.terminal_vertices.append(skVertex2D);
        this.terminal_edges = linkedList;
    }

    public boolean terminals_are_within_this_circle(SkEdge2D skEdge2D) {
        Enumeration enumeration = this.terminal_vertices.elements();
        while (enumeration.hasMoreElements()) {
            SkVertex2D skVertex2D = (SkVertex2D)enumeration.nextElement();
            if (!skEdge2D.out_of_circle(skVertex2D)) continue;
            return false;
        }
        return true;
    }
}

