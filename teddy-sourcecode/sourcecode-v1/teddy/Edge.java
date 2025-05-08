/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.Draw3DScene;
import teddy.Polygon2;
import teddy.Vector3;
import teddy.Vertex;

class Edge
implements Serializable {
    public Vertex start;
    public Vertex end;
    public int index;
    public Polygon2 left_polygon;
    public Polygon2 right_polygon;
    public boolean sharp = false;
    public boolean concave;
    public int type;
    public boolean checked = false;
    public transient Edge child;
    static final int NONE = 0;
    static final int BACK_SILHOUETTE = 1;
    static final int FRONT_SILHOUETTE = 2;
    static final int SHARP_FRONT = 3;

    public Polygon2 left_polygon() {
        return this.left_polygon;
    }

    public boolean contain(Vertex vertex) {
        return this.start == vertex || this.end == vertex;
    }

    public Vertex end() {
        return this.end;
    }

    public boolean connected(Polygon2 polygon2) {
        return polygon2 == this.left_polygon() || polygon2 == this.right_polygon();
    }

    public boolean connected(Edge edge) {
        return this.start == edge.start || this.start == edge.end || this.end == edge.start || this.end == edge.end;
    }

    public void set_parameters() {
        if (this.left_polygon() == null && this.right_polygon() == null) {
            System.out.println("Edge has no polygon (Edge:set_parameters())");
            return;
        }
        if (this.left_polygon() == null || this.right_polygon() == null) {
            System.out.println("Edge doesn't have 2 polygons (Edge:set_parameters())" + this.start + "," + this.end);
            if (this.left_polygon() == null) {
                Draw3DScene.current_polygon = this.right_polygon();
                return;
            }
            Draw3DScene.current_polygon = this.left_polygon();
            return;
        }
        Polygon2 polygon2 = this.left_polygon();
        Polygon2 polygon22 = this.right_polygon();
        Vector3 vector3 = new Vector3(this.start, this.end);
        Vector3 vector32 = polygon2.normal;
        Vector3 vector33 = polygon22.normal;
        Vector3 vector34 = vector32.cross_product(vector33);
        this.concave = vector3.cos(vector34) < 0.0;
    }

    public void set_sharp_if_sharp() {
        Vector3 vector3 = this.left_polygon().normal;
        Vector3 vector32 = this.right_polygon().normal;
        if (this.concave) {
            this.sharp = vector3.cos(vector32) < 0.7;
            return;
        }
        this.sharp = vector3.cos(vector32) < 0.3;
    }

    public int visibility_type() {
        Polygon2 polygon2 = this.left_polygon();
        Polygon2 polygon22 = this.right_polygon();
        if (polygon2.front_facing && polygon22.front_facing && this.sharp) {
            this.type = 3;
            return 3;
        }
        if (polygon2.front_facing == polygon22.front_facing) {
            this.type = 0;
            return 0;
        }
        if (this.concave) {
            this.type = 1;
            return 1;
        }
        this.type = 2;
        return 2;
    }

    public boolean on_edge(Vertex vertex) {
        if (vertex == this.start || vertex == this.end) {
            return true;
        }
        Vector3 vector3 = new Vector3(vertex, this.start);
        Vector3 vector32 = new Vector3(vertex, this.end);
        return vector3.cos(vector32) < -0.9;
    }

    public boolean silhouette() {
        this.visibility_type();
        return this.type == 1 || this.type == 2;
    }

    public void set_sharp() {
        this.sharp = true;
    }

    public void set_sharp(boolean bl) {
        this.sharp = bl;
    }

    public Vertex start() {
        return this.start;
    }

    public Vertex mid_vertex() {
        return new Vertex((this.start.x + this.end.x) / 2.0, (this.start.y + this.end.y) / 2.0, (this.start.z + this.end.z) / 2.0);
    }

    public void renew_network() {
        this.start = this.start.child;
        this.end = this.end.child;
        this.left_polygon = this.left_polygon.child;
        this.right_polygon = this.right_polygon.child;
    }

    public Polygon2 get_another_polygon(Polygon2 polygon2) {
        return this.get_the_other_polygon(polygon2);
    }

    public Polygon2 get_the_other_polygon(Polygon2 polygon2) {
        if (this.left_polygon() != polygon2) {
            return this.left_polygon();
        }
        return this.right_polygon();
    }

    public void set_right_polygon(Polygon2 polygon2) {
        this.right_polygon = polygon2;
    }

    public Vector3 vertical_from(Vertex vertex) {
        Vertex vertex2 = this.start();
        Vertex vertex3 = this.end();
        Vector3 vector3 = new Vector3(vertex2, vertex3);
        Vector3 vector32 = new Vector3(vertex2, vertex);
        double d = vector3.dot_product(vector32);
        double d2 = vector3.length();
        Vector3 vector33 = vector3.multiple(d / d2 / d2);
        Vertex vertex4 = vertex2.shift(vector33);
        return new Vector3(vertex, vertex4);
    }

    public boolean polygon_is_empty() {
        return this.left_polygon == null && this.right_polygon == null;
    }

    public double length() {
        return this.vector3().length();
    }

    public boolean same_edge(Vertex vertex, Vertex vertex2) {
        return vertex == this.start && vertex2 == this.end || vertex2 == this.start && vertex == this.end;
    }

    Edge() {
        this.start = new Vertex();
        this.end = new Vertex();
        this.left_polygon = null;
        this.right_polygon = null;
    }

    Edge(Vertex vertex, Vertex vertex2) {
        this.start = vertex;
        this.end = vertex2;
        if (this.start == this.end) {
            System.out.println("Edge with same Vertex (Edge.java)");
        }
        this.start.edges.append(this);
        this.end.edges.append(this);
        this.left_polygon = null;
        this.right_polygon = null;
    }

    public Vertex get_the_other_vertex(Vertex vertex) {
        if (vertex == this.start) {
            return this.end;
        }
        return this.start;
    }

    public Vertex get_common_vertex(Edge edge) {
        if (this.start == edge.start || this.start == edge.end) {
            return this.start;
        }
        return this.end;
    }

    public boolean possible() {
        this.visibility_type();
        return this.type == 3 || this.type == 2;
    }

    public Polygon2 right_polygon() {
        return this.right_polygon;
    }

    public void set_left_polygon(Polygon2 polygon2) {
        this.left_polygon = polygon2;
    }

    public void remove_polygon(Polygon2 polygon2) {
        if (this.left_polygon == polygon2) {
            this.left_polygon = null;
            return;
        }
        if (this.right_polygon == polygon2) {
            this.right_polygon = null;
        }
    }

    public Vector3 vector3() {
        return new Vector3(this.start, this.end);
    }

    public Edge copy() {
        Edge edge = new Edge();
        edge.start = this.start;
        edge.end = this.end;
        edge.left_polygon = this.left_polygon;
        edge.right_polygon = this.right_polygon;
        edge.sharp = this.sharp;
        edge.concave = this.concave;
        this.child = edge;
        return edge;
    }

    public void print() {
        System.out.println("" + this + ":" + this.start + "," + this.end + "; " + this.left_polygon + "," + this.right_polygon);
    }
}

