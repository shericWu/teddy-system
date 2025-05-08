/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Vector;
import teddy.LinkedList;
import teddy.TrEdge;
import teddy.TrVertex;
import teddy.Trianglation2D;

class Triangle {
    Vector edges = new Vector();
    public boolean destroyed = false;

    private void add_edge(TrVertex trVertex, TrVertex trVertex2) {
        TrEdge trEdge = trVertex.shared_edge(trVertex2);
        if (trEdge == null) {
            trEdge = new TrEdge(trVertex, trVertex2);
            Trianglation2D.edges.addElement(trEdge);
        }
        if (trEdge.start == trVertex) {
            trEdge.left_triangle = this;
        } else {
            trEdge.right_triangle = this;
        }
        this.edges.addElement(trEdge);
    }

    Triangle(TrVertex trVertex, TrVertex trVertex2, TrVertex trVertex3) {
        this.add_edge(trVertex, trVertex2);
        this.add_edge(trVertex2, trVertex3);
        this.add_edge(trVertex3, trVertex);
    }

    public TrVertex get_opposite_vertex(TrEdge trEdge) {
        int n = 0;
        do {
            if (this.edges(n) != trEdge) continue;
            return this.edges(n + 1).get_common_vertex(this.edges(n + 2));
        } while (++n < 3);
        return null;
    }

    public void destroy() {
        int n = 0;
        do {
            this.edges(n).remove_triangle(this);
        } while (++n < 3);
        Trianglation2D.triangles.removeElement(this);
        this.destroyed = true;
    }

    public TrEdge edges(int n) {
        if (n >= this.edges.size()) {
            n -= n / this.edges.size() * this.edges.size();
        }
        if (n < 0) {
            n += (-n / this.edges.size() + 1) * this.edges.size();
        }
        return (TrEdge)this.edges.elementAt(n);
    }

    public LinkedList original_edges() {
        LinkedList linkedList = new LinkedList();
        int n = 0;
        do {
            linkedList.append(this.edges((int)n).original);
        } while (++n < 3);
        return linkedList;
    }
}

