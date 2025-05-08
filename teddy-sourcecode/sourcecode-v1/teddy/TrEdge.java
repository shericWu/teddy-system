/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Edge;
import teddy.Edge2D;
import teddy.TrVertex;
import teddy.Trianglation2D;
import teddy.Triangle;

class TrEdge
extends Edge2D {
    public Triangle left_triangle = null;
    public Triangle right_triangle = null;
    public boolean destroyed = false;
    public boolean external = false;
    public Edge original;

    TrEdge(TrVertex trVertex, TrVertex trVertex2) {
        this.start = trVertex;
        this.end = trVertex2;
        ((TrVertex)this.start).edges.addElement(this);
        ((TrVertex)this.end).edges.addElement(this);
    }

    TrEdge(TrVertex trVertex, TrVertex trVertex2, boolean bl) {
        this(trVertex, trVertex2);
        this.external = bl;
    }

    public TrVertex get_common_vertex(TrEdge trEdge) {
        if (trEdge.contains(this.start)) {
            return (TrVertex)this.start;
        }
        if (trEdge.contains(this.end)) {
            return (TrVertex)this.end;
        }
        return null;
    }

    public void destroy() {
        ((TrVertex)this.start).remove_edge(this);
        ((TrVertex)this.end).remove_edge(this);
        Trianglation2D.edges.removeElement(this);
        this.destroyed = true;
    }

    public boolean contains(TrVertex trVertex) {
        return this.start == trVertex || this.end == trVertex;
    }

    public void remove_triangle(Triangle triangle) {
        if (this.left_triangle == triangle) {
            this.left_triangle = null;
        }
        if (this.right_triangle == triangle) {
            this.right_triangle = null;
        }
        if (this.right_triangle == null && this.left_triangle == null) {
            this.destroy();
        }
    }
}

