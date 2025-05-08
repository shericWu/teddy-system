/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Vector;
import teddy.CoordSystem;
import teddy.Edge;
import teddy.Surface;
import teddy.TrEdge;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class TrVertex
extends Vertex2D {
    public Vector edges = new Vector();
    public boolean external = false;
    public Vertex original = null;
    public double height;

    public TrEdge find_opposite_edge(TrEdge trEdge, Vector vector) {
        Vertex2D vertex2D = trEdge.mid_point();
        Vector2 vector2 = new Vector2(vertex2D, this);
        int n = 0;
        while (n < vector.size()) {
            TrEdge trEdge2 = (TrEdge)vector.elementAt(n);
            Vector2 vector22 = new Vector2(vertex2D, trEdge2.start);
            Vector2 vector23 = new Vector2(vertex2D, trEdge2.end);
            if (trEdge2 != trEdge && vector2.dot_product(vector23) > 0.0 && vector22.cross_product(vector23) < 0.0 && vector2.cross_product(vector22) * vector2.cross_product(vector23) <= 0.0 && vector2.length() < vector22.length()) {
                return trEdge2;
            }
            ++n;
        }
        System.out.println("Error in Trianglation2D.find_opposite_edge");
        return null;
    }

    TrVertex(Point point, boolean bl) {
        this.x = point.x;
        this.y = point.y;
        this.external = bl;
    }

    TrVertex(Vertex vertex, boolean bl, Vertex vertex2) {
        this.original = vertex2;
        this.x = vertex.x;
        this.y = vertex.y;
        this.height = vertex.z;
        this.external = bl;
    }

    TrVertex(Vertex2D vertex2D) {
        this.x = vertex2D.x;
        this.y = vertex2D.y;
    }

    public void destroy() {
    }

    public void set_height(Vector vector) {
        this.height = 0.0;
        double d = 0.0;
        int n = 0;
        while (n < vector.size()) {
            TrVertex trVertex = (TrVertex)vector.elementAt(n);
            double d2 = Vector2.distance(this, trVertex);
            this.height += d2 * trVertex.height;
            d += d2;
            ++n;
        }
        this.height /= d;
    }

    public boolean edge_is_clockwise(TrEdge trEdge) {
        Vector2 vector2 = new Vector2(this, trEdge.start);
        Vector2 vector22 = new Vector2(this, trEdge.end);
        return vector2.cross_product(vector22) < 0.0;
    }

    public void set_height_slope(Vector vector, CoordSystem coordSystem) {
        Vector<TrEdge> vector2 = new Vector<TrEdge>();
        int n = 0;
        while (n < vector.size()) {
            TrVertex trVertex = (TrVertex)vector.elementAt(n);
            TrVertex trVertex2 = n < vector.size() - 1 ? (TrVertex)vector.elementAt(n + 1) : (TrVertex)vector.elementAt(0);
            TrEdge trEdge = trVertex.shared_edge(trVertex2);
            trEdge.original = trVertex.original.get_shared_edge(trVertex2.original);
            vector2.addElement(trEdge);
            ++n;
        }
        this.height = 0.0;
        double d = 0.0;
        int n2 = 0;
        while (n2 < vector2.size()) {
            TrEdge trEdge = (TrEdge)vector2.elementAt(n2);
            if (this.edge_is_clockwise(trEdge)) {
                double d2 = this.set_height_slope_sub(trEdge, vector2, coordSystem);
                double d3 = 1.0 / Vector2.distance(trEdge.mid_point(), this);
                if (d2 != 0.0) {
                    d3 *= d3;
                    this.height += d2 * d3;
                    d += d3;
                }
            }
            ++n2;
        }
        this.height /= d;
    }

    public TrEdge shared_edge(TrVertex trVertex) {
        int n = 0;
        while (n < this.edges.size()) {
            TrEdge trEdge = (TrEdge)this.edges.elementAt(n);
            if (trEdge.contains(trVertex)) {
                return trEdge;
            }
            ++n;
        }
        return null;
    }

    public void remove_edge(TrEdge trEdge) {
        this.edges.removeElement(trEdge);
        if (this.edges.size() == 0) {
            // empty if block
        }
        this.destroy();
    }

    public double set_height_slope_sub(TrEdge trEdge, Vector vector, CoordSystem coordSystem) {
        Edge edge = trEdge.original;
        Vertex vertex = edge.mid_vertex();
        TrEdge trEdge2 = this.find_opposite_edge(trEdge, vector);
        if (trEdge2 == null) {
            return 0.0;
        }
        Edge edge2 = trEdge2.original;
        double d = coordSystem.translate((Vertex)vertex).z;
        this.original = coordSystem.reverse_translate(this.x, this.y, d);
        Vector3 vector3 = coordSystem.base_z.cross_product(new Vector3(vertex, this.original));
        Surface surface = new Surface(vertex, vector3);
        Vertex vertex2 = surface.cross_point(edge2);
        Vector3 vector32 = edge.left_polygon != null ? edge.vector3().cross_product(edge.left_polygon.calc_normal()) : edge.vector3().reverse().cross_product(edge.right_polygon.calc_normal());
        vector32.normalize();
        Vector3 vector33 = edge2.left_polygon != null ? edge2.vector3().cross_product(edge2.left_polygon.calc_normal()) : edge2.vector3().reverse().cross_product(edge2.right_polygon.calc_normal());
        vector33.normalize();
        Vector3 vector34 = coordSystem.base_z;
        Vector3 vector35 = new Vector3(vertex, vertex2);
        Vector3 vector36 = vector35.cross_product(vector34).get_normalized();
        vector35 = vector34.cross_product(vector36).get_normalized();
        CoordSystem coordSystem2 = new CoordSystem(vector35, vector34, vector36);
        Vertex vertex3 = coordSystem2.translate(this.original);
        Vertex vertex4 = coordSystem2.translate(vertex);
        Vertex vertex5 = coordSystem2.translate(vertex2);
        Vector2 vector2 = new Vector2(coordSystem2.translate(vector32));
        Vector2 vector22 = new Vector2(coordSystem2.translate(vector33));
        double d2 = Vector2.distance(vertex4.x, vertex4.y, vertex5.x, vertex5.y);
        vector2 = vector2.get_normalized().multiple(d2 * 1.5);
        vector22 = vector22.get_normalized().multiple(d2);
        double d3 = 2.0 * vertex4.x - 2.0 * vertex5.x + vector2.x - vector22.x;
        double d4 = -3.0 * vertex4.x + 3.0 * vertex5.x - 2.0 * vector2.x + vector22.x;
        double d5 = vector2.x;
        double d6 = vertex4.x;
        double d7 = 2.0 * vertex4.y - 2.0 * vertex5.y + vector2.y - vector22.y;
        double d8 = -3.0 * vertex4.y + 3.0 * vertex5.y - 2.0 * vector2.y + vector22.y;
        double d9 = vector2.y;
        double d10 = vertex4.y;
        double d11 = (vertex3.x - vertex4.x) / (vertex5.x - vertex4.x);
        if (d11 < 0.0 || d11 > 1.0) {
            System.out.println("Strange t (Trianglation2D.set_height_slope_sub())" + d11);
            d11 = 0.5;
        }
        double d12 = d7 * d11 * d11 * d11 + d8 * d11 * d11 + d9 * d11 + d10;
        return d12;
    }
}

