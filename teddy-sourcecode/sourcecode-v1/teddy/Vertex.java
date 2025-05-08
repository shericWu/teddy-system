/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Vector3;

class Vertex
extends Vector3
implements Serializable {
    LinkedList edges;
    public transient Vertex child = this;
    public transient int index;

    public Edge get_shared_edge(Vertex vertex) {
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            if (!vertex.edges.member(edge)) continue;
            return edge;
        }
        return null;
    }

    public double z() {
        return this.z;
    }

    public static Vertex mid_point(Vertex vertex, Vertex vertex2) {
        return new Vertex((vertex.x + vertex2.x) / 2.0, (vertex.y + vertex2.y) / 2.0, (vertex.z + vertex2.z) / 2.0);
    }

    Vertex() {
        this.edges = new LinkedList();
    }

    Vertex(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.edges = new LinkedList();
    }

    Vertex(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
        this.edges = new LinkedList();
    }

    public boolean same_vertex(double d, double d2, double d3) {
        return this.x == d && this.y == d2 && this.z == d3;
    }

    public Vertex position_copy() {
        Vertex vertex;
        this.child = vertex = new Vertex(this.x, this.y, this.z);
        return vertex;
    }

    public Vertex shift(Vector3 vector3) {
        return new Vertex(this.x + vector3.x, this.y + vector3.y, this.z + vector3.z);
    }

    public boolean edge_is_empty() {
        return this.edges.size() == 0;
    }

    public Vertex copy() {
        Vertex vertex = new Vertex(this.x, this.y, this.z);
        vertex.edges = this.edges;
        this.child = vertex;
        return vertex;
    }

    public void warp(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
    }

    public double x() {
        return this.x;
    }

    public void renew_network() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            linkedList.append(edge.child);
        }
        this.edges = linkedList;
    }

    public boolean same_position(Vertex vertex) {
        return this.x == vertex.x && this.y == vertex.y && this.z == vertex.z;
    }

    public void remove_edge(Edge edge) {
        this.edges.remove(edge);
    }

    public LinkedList get_sorrounding_vertices() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            linkedList.append(edge.get_the_other_vertex(this));
        }
        return linkedList;
    }

    public LinkedList polygons() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            Edge edge = (Edge)enumeration.nextElement();
            if (edge.left_polygon() == null || edge.right_polygon() == null) {
                System.out.println("edge doesn't have 2 polygons (Vertex.polygons())");
            }
            if (!linkedList.member(edge.left_polygon())) {
                linkedList.append(edge.left_polygon());
            }
            if (linkedList.member(edge.right_polygon())) continue;
            linkedList.append(edge.right_polygon());
        }
        return linkedList;
    }

    public double y() {
        return this.y;
    }

    public double distance(Vertex vertex) {
        return Vector3.distance(this, vertex);
    }
}

