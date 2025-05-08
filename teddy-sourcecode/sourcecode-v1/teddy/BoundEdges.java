/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.ProjectedEdge;

class BoundEdges {
    public ProjectedEdge left;
    public ProjectedEdge right;
    public ProjectedEdge top;
    public ProjectedEdge bottom;
    public double left_bound;
    public double right_bound;
    public double top_bound;
    public double bottom_bound;

    BoundEdges(ProjectedEdge projectedEdge) {
        this.left = projectedEdge;
        this.right = projectedEdge;
        this.top = projectedEdge;
        this.bottom = projectedEdge;
        this.left_bound = projectedEdge.left();
        this.right_bound = projectedEdge.right();
        this.top_bound = projectedEdge.top();
        this.bottom_bound = projectedEdge.bottom();
    }

    void check(ProjectedEdge projectedEdge) {
        if (this.left_bound > projectedEdge.left()) {
            this.left_bound = projectedEdge.left();
            this.left = projectedEdge;
        }
        if (this.right_bound < projectedEdge.right()) {
            this.right_bound = projectedEdge.right();
            this.right = projectedEdge;
        }
        if (this.top_bound > projectedEdge.top()) {
            this.top_bound = projectedEdge.top();
            this.top = projectedEdge;
        }
        if (this.bottom_bound < projectedEdge.bottom()) {
            this.bottom_bound = projectedEdge.bottom();
            this.bottom = projectedEdge;
        }
    }
}

