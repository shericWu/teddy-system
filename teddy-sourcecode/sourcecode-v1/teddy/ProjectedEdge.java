/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.Edge;
import teddy.Edge2D;
import teddy.Polygon2;
import teddy.ProjectedVertex;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class ProjectedEdge
extends Edge2D {
    public ProjectedVertex start;
    public ProjectedVertex end;
    Edge original;
    int QI;
    int type;

    public double bottom() {
        return Math.max(this.start.y, this.end.y);
    }

    public Vertex2D cross_point(ProjectedEdge projectedEdge) {
        return this.cross_point(this.start.x, this.start.y, this.end.x, this.end.y, projectedEdge.start.x, projectedEdge.start.y, projectedEdge.end.x, projectedEdge.end.y);
    }

    public boolean connected(ProjectedEdge projectedEdge) {
        return this.start == projectedEdge.start || this.start == projectedEdge.end || this.end == projectedEdge.start || this.end == projectedEdge.end;
    }

    ProjectedEdge(Edge edge) {
        this.start = new ProjectedVertex(edge.start());
        this.end = new ProjectedVertex(edge.end());
        this.QI = -1;
        this.original = edge;
        this.type = edge.type;
    }

    ProjectedEdge(Vertex2D vertex2D, Vertex2D vertex2D2) {
        this.start = new ProjectedVertex(vertex2D);
        this.end = new ProjectedVertex(vertex2D2);
        this.original = null;
    }

    public boolean cross_behind(ProjectedEdge projectedEdge, Vertex vertex) {
        double d;
        if (this.connected(projectedEdge)) {
            return false;
        }
        if (!this.cross(projectedEdge)) {
            return false;
        }
        Vertex2D vertex2D = this.cross_point(projectedEdge);
        if (vertex2D == null) {
            return false;
        }
        Vertex vertex2 = new Vertex(vertex2D.x, 0.0, vertex2D.y);
        Vector3 vector3 = new Vector3(vertex, this.original.start());
        Vector3 vector32 = this.original.vector3();
        Vector3 vector33 = new Vector3(vertex, vertex2);
        double d2 = vector3.cross_product(vector32).length() / vector33.cross_product(vector32).length();
        return d2 > (d = (vector3 = new Vector3(vertex, projectedEdge.original.start())).cross_product(vector32 = projectedEdge.original.vector3()).length() / vector33.cross_product(vector32).length());
    }

    public boolean in(Vertex2D vertex2D) {
        Polygon2 polygon2 = this.original.left_polygon();
        boolean bl = this.right_side_of_edge(this.start.x, this.start.y, this.end.x, this.end.y, vertex2D.x, vertex2D.y);
        if (polygon2.front_facing) {
            return !bl;
        }
        return bl;
    }

    public boolean in(Polygon2 polygon2, Vertex2D vertex2D) {
        Polygon2 polygon22 = this.original.left_polygon();
        boolean bl = this.right_side_of_edge(this.start.x, this.start.y, this.end.x, this.end.y, vertex2D.x, vertex2D.y);
        if (!polygon2.front_facing) {
            boolean bl2 = bl = !bl;
        }
        if (polygon2 == polygon22) {
            return !bl;
        }
        return bl;
    }

    public double top() {
        return Math.min(this.start.y, this.end.y);
    }

    public ProjectedVertex bottom_vertex() {
        if (this.start.y > this.end.y) {
            return this.start;
        }
        return this.end;
    }

    private boolean covered_sub(Vertex vertex, Polygon2 polygon2) {
        if (!polygon2.front_facing) {
            return false;
        }
        if (this.original.connected(polygon2)) {
            return false;
        }
        Vector3 vector3 = this.original.vector3();
        if (this.original.end == vertex) {
            vector3 = vector3.reverse();
        }
        if (polygon2.absolute_normal().dot_product(vector3) >= 0.0) {
            return false;
        }
        int n = polygon2.get_vertex_index(vertex);
        Vertex vertex2 = polygon2.get_vertex(n - 1);
        Vertex vertex3 = polygon2.get_vertex(n + 1);
        Vertex vertex4 = this.original.get_the_other_vertex(vertex);
        ProjectedVertex projectedVertex = new ProjectedVertex(vertex2);
        ProjectedVertex projectedVertex2 = new ProjectedVertex(vertex3);
        ProjectedVertex projectedVertex3 = new ProjectedVertex(vertex);
        ProjectedVertex projectedVertex4 = new ProjectedVertex(vertex4);
        Vector2 vector2 = new Vector2(projectedVertex3, projectedVertex);
        Vector2 vector22 = new Vector2(projectedVertex3, projectedVertex2);
        Vector2 vector23 = new Vector2(projectedVertex3, projectedVertex4);
        double d = 360.0 - vector2.get_angle(vector22);
        double d2 = 360.0 - vector2.get_angle(vector23);
        return d2 < d;
    }

    public double left() {
        return Math.min(this.start.x, this.end.x);
    }

    public ProjectedVertex left_vertex() {
        if (this.start.x < this.end.x) {
            return this.start;
        }
        return this.end;
    }

    public double right() {
        return Math.max(this.start.x, this.end.x);
    }

    public boolean covered(ProjectedVertex projectedVertex) {
        Vertex vertex = projectedVertex.original;
        Enumeration enumeration = vertex.polygons().elements();
        while (enumeration.hasMoreElements()) {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if (!this.covered_sub(vertex, polygon2)) continue;
            return true;
        }
        return false;
    }

    public ProjectedVertex another_vertex(ProjectedVertex projectedVertex) {
        if (projectedVertex == this.start) {
            return this.end;
        }
        return this.start;
    }

    public boolean cross(ProjectedEdge projectedEdge) {
        return this.cross(this.start.x, this.start.y, this.end.x, this.end.y, projectedEdge.start.x, projectedEdge.start.y, projectedEdge.end.x, projectedEdge.end.y);
    }

    public ProjectedVertex right_vertex() {
        if (this.start.x > this.end.x) {
            return this.start;
        }
        return this.end;
    }

    public ProjectedVertex top_vertex() {
        if (this.start.y < this.end.y) {
            return this.start;
        }
        return this.end;
    }
}

