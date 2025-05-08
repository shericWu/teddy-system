/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Objects;
import teddy.Polyhedron;
import teddy.Vector3;
import teddy.Vertex;

class Polygon2
implements Serializable {
    public Edge[] edges;
    public int n_edges;
    public LinkedList surface_lines;
    public Vector3 normal;
    boolean front_facing;
    public Polyhedron polyhedron;
    double distance;
    public transient Polygon2 child;
    public int part_index = 0;
    int index;

    public Vertex cross_point(Edge edge) {
        Vertex vertex = this.edges[0].start();
        Vector3 vector3 = this.absolute_normal();
        Vector3 vector32 = edge.vector3();
        Vertex vertex2 = edge.start();
        double d = (vertex.dot_product(vector3) - vertex2.dot_product(vector3)) / vector32.dot_product(vector3);
        return new Vertex(vertex2.x + vector32.x * d, vertex2.y + vector32.y * d, vertex2.z + vector32.z * d);
    }

    public Edge edges(int n) {
        if (n >= this.n_edges) {
            n -= n / this.n_edges * this.n_edges;
        }
        if (n < 0) {
            n += (-n / this.n_edges + 1) * this.n_edges;
        }
        return this.edges[n];
    }

    public Edge get_longest_edge() {
        Edge edge = null;
        double d = -1.0;
        int n = 0;
        while (n < this.n_edges) {
            double d2 = this.edges[n].length();
            if (d < d2) {
                edge = this.edges[n];
                d = d2;
            }
            ++n;
        }
        return edge;
    }

    public Vertex get_vertex(int n) {
        return this.edges(n - 1).get_common_vertex(this.edges(n));
    }

    public LinkedList get_edges() {
        LinkedList linkedList = new LinkedList();
        int n = 0;
        while (n < this.n_edges) {
            linkedList.append(this.edges[n]);
            ++n;
        }
        return linkedList;
    }

    public void renew_network() {
        int n = 0;
        while (n < this.n_edges) {
            this.edges[n] = this.edges[n].child;
            ++n;
        }
    }

    public Vector get_vertices() {
        Vector<Vertex> vector = new Vector<Vertex>();
        int n = 0;
        while (n < this.n_edges) {
            vector.addElement(this.get_vertex(n));
            ++n;
        }
        return vector;
    }

    public void print_normal() {
        System.out.println("normal " + (int)(this.normal.x * 10.0) + "," + (int)(this.normal.y * 10.0) + "," + (int)(this.normal.z * 10.0));
    }

    public int get_vertex_index(Vertex vertex) {
        int n = 0;
        while (n < this.n_edges) {
            if (this.get_vertex(n) == vertex) {
                return n;
            }
            ++n;
        }
        System.out.println("Vertex not in Polygon (Polygon2.get_vertex_index)");
        return -1;
    }

    public int get_concave_vertex_index() {
        this.set_normal();
        int n = 0;
        while (n < this.n_edges) {
            if (this.is_concave(n)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public boolean is_concave(int n) {
        Vertex vertex = this.get_vertex(n);
        Vector3 vector3 = new Vector3(this.get_vertex(n - 1), vertex);
        Vector3 vector32 = new Vector3(vertex, this.get_vertex(n + 1));
        Vector3 vector33 = vector3.cross_product(vector32);
        if (vector3.parallel(vector32) && vector3.dot_product(vector32) > 0.0) {
            return true;
        }
        return this.normal.dot_product(vector33) <= 0.0;
    }

    public boolean on_polygon(Vertex vertex) {
        this.set_normal();
        double d = 0.0;
        Vertex vertex2 = vertex;
        Vector3 vector3 = new Vector3(vertex2, this.get_vertex(0));
        int n = 1;
        while (n < this.n_edges + 1) {
            Vector3 vector32 = new Vector3(vertex2, this.get_vertex(n));
            double d2 = vector3.get_relative_angle(vector32);
            if (this.normal.dot_product(vector3.cross_product(vector32)) < 0.0) {
                d2 *= -1.0;
            }
            d += d2;
            vector3 = vector32;
            ++n;
        }
        return d > Math.PI;
    }

    private void add_edges(Enumeration enumeration) {
        Edge edge;
        Edge edge2 = edge = (Edge)enumeration.nextElement();
        int n = 0;
        while (n < this.n_edges - 1) {
            Edge edge3 = (Edge)enumeration.nextElement();
            this.add_edge(n, edge, edge3);
            edge = edge3;
            ++n;
        }
        this.add_edge(this.n_edges - 1, edge, edge2);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    private void add_edge(int n, Edge edge, Edge edge2) {
        this.edges[n] = edge;
        if (edge2.contain(edge.end)) {
            edge.set_left_polygon(this);
            return;
        }
        edge.set_right_polygon(this);
    }

    private Edge find_shared_edge(Vertex vertex, Vertex vertex2) {
        Enumeration enumeration;
        Enumeration enumeration2 = vertex.edges.elements();
        while (enumeration2.hasMoreElements()) {
            Edge edge = (Edge)enumeration2.nextElement();
            enumeration = vertex2.edges.elements();
            while (enumeration.hasMoreElements()) {
                if (edge != (Edge)enumeration.nextElement()) continue;
                return edge;
            }
        }
        System.out.println("error while searching shared edge (Polygon2.java)");
        enumeration2 = vertex.edges.elements();
        while (enumeration2.hasMoreElements()) {
            System.out.print(" " + enumeration2.nextElement());
        }
        System.out.println("");
        enumeration = vertex2.edges.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(" " + enumeration.nextElement());
        }
        System.out.println("");
        return null;
    }

    public Objects get_the_other_edge(Vertex vertex) {
        int n = 0;
        n = 0;
        while (n < this.n_edges) {
            if (this.get_vertex(n) == vertex) break;
            ++n;
        }
        return new Objects(this.get_vertex(n - 1), this.get_vertex(n + 1));
    }

    public void set_distance(Vertex vertex) {
        this.distance = Vector3.distance(vertex, this.centerVertex());
    }

    public Vector3 absolute_normal() {
        return this.polyhedron.absolute_coords(this.normal);
    }

    Polygon2() {
        this.n_edges = 3;
        this.edges = new Edge[3];
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(Edge edge, Edge edge2, Edge edge3) {
        this.n_edges = 3;
        this.edges = new Edge[3];
        this.add_edge(0, edge, edge2);
        this.add_edge(1, edge2, edge3);
        this.add_edge(2, edge3, edge);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(Edge edge, Edge edge2, Edge edge3, Edge edge4) {
        this.n_edges = 4;
        this.edges = new Edge[4];
        this.add_edge(0, edge, edge2);
        this.add_edge(1, edge2, edge3);
        this.add_edge(2, edge3, edge4);
        this.add_edge(3, edge4, edge);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        this.n_edges = 3;
        this.edges = new Edge[3];
        Edge edge = this.find_shared_edge(vertex, vertex2);
        Edge edge2 = this.find_shared_edge(vertex2, vertex3);
        Edge edge3 = this.find_shared_edge(vertex3, vertex);
        this.add_edge(0, edge, edge2);
        this.add_edge(1, edge2, edge3);
        this.add_edge(2, edge3, edge);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(Vertex vertex, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
        this.n_edges = 4;
        this.edges = new Edge[4];
        Edge edge = this.find_shared_edge(vertex, vertex2);
        Edge edge2 = this.find_shared_edge(vertex2, vertex3);
        Edge edge3 = this.find_shared_edge(vertex3, vertex4);
        Edge edge4 = this.find_shared_edge(vertex4, vertex);
        this.add_edge(0, edge, edge2);
        this.add_edge(1, edge2, edge3);
        this.add_edge(2, edge3, edge4);
        this.add_edge(3, edge4, edge);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(int n, Edge[] edgeArray) {
        this.n_edges = n;
        this.edges = new Edge[this.n_edges];
        int n2 = 0;
        while (n2 < this.n_edges - 1) {
            this.add_edge(n2, edgeArray[n2], edgeArray[n2 + 1]);
            ++n2;
        }
        this.add_edge(n - 1, edgeArray[n - 1], edgeArray[0]);
        this.set_normal();
        this.front_facing = false;
        this.surface_lines = new LinkedList();
    }

    Polygon2(LinkedList linkedList) {
        this.n_edges = linkedList.size();
        this.edges = new Edge[this.n_edges];
        this.add_edges(linkedList.elements());
    }

    Polygon2(Vector vector) {
        this.n_edges = vector.size();
        this.edges = new Edge[this.n_edges];
        this.add_edges(vector.elements());
    }

    public Vector3 get_normal_simple() {
        int n = 0;
        while (n < this.n_edges - 1) {
            Vector3 vector3 = new Vector3(this.get_vertex(n - 1), this.get_vertex(n));
            Vector3 vector32 = new Vector3(this.get_vertex(n), this.get_vertex(n + 1));
            Vector3 vector33 = vector3.cross_product(vector32);
            if (!vector3.parallel(vector32)) {
                return vector33;
            }
            ++n;
        }
        return null;
    }

    public boolean contains(Edge edge) {
        int n = 0;
        while (n < this.n_edges) {
            if (this.edges[n] == edge) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public boolean contains(Vertex vertex) {
        int n = 0;
        while (n < this.n_edges) {
            if (this.edges[n].contain(vertex)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public void check_facing(Vertex vertex) {
        Vector3 vector3;
        Vector3 vector32 = new Vector3(vertex, this.edges(0).start());
        if (vector32.dot_product(vector3 = this.absolute_normal()) < 0.0) {
            this.front_facing = true;
            return;
        }
        this.front_facing = false;
    }

    public Polygon2 copy() {
        Polygon2 polygon2 = new Polygon2();
        polygon2.edges = (Edge[])this.edges.clone();
        polygon2.n_edges = this.n_edges;
        polygon2.surface_lines = new LinkedList();
        polygon2.normal = this.normal;
        polygon2.front_facing = this.front_facing;
        polygon2.part_index = this.part_index;
        this.child = polygon2;
        return polygon2;
    }

    public Vertex centerVertex() {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        int n = 0;
        while (n < this.n_edges) {
            Edge edge = this.edges[n];
            Vertex vertex = edge.start();
            Vertex vertex2 = edge.end();
            d = d + vertex.x + vertex2.x;
            d2 = d2 + vertex.y + vertex2.y;
            d3 = d3 + vertex.z + vertex2.z;
            ++n;
        }
        return new Vertex(d /= (double)(this.n_edges * 2), d2 /= (double)(this.n_edges * 2), d3 /= (double)(this.n_edges * 2));
    }

    public int get_edge_index(Edge edge) {
        int n = 0;
        while (n < this.n_edges) {
            if (this.edges(n) == edge) {
                return n;
            }
            ++n;
        }
        System.out.println("Edge not in Polygon (Polygon2.get_edge_index)");
        return -1;
    }

    public void edge_replace(Edge edge, Edge edge2, Edge edge3) {
        Edge[] edgeArray = new Edge[this.n_edges + 1];
        int n = 0;
        int n2 = 0;
        while (n2 < this.n_edges) {
            if (this.edges[n2] != edge) {
                edgeArray[n++] = this.edges[n2];
            } else if (this.edges[n2 - 1].connected(edge2)) {
                this.add_edge(n++, edge2, edge3);
                this.add_edge(n++, edge3, this.edges[n2 + 1]);
            } else {
                this.add_edge(n++, edge3, edge2);
                this.add_edge(n++, edge2, this.edges[n2 + 1]);
            }
            ++n2;
        }
        this.edges = edgeArray;
        ++this.n_edges;
    }

    public void edge_replace(Edge edge, Edge edge2, Edge edge3, Edge edge4) {
        Edge[] edgeArray = new Edge[this.n_edges + 2];
        int n = 0;
        int n2 = 0;
        while (n2 < this.n_edges) {
            if (this.edges[n2] != edge) {
                edgeArray[n++] = this.edges[n2];
            } else if (this.edges[n2 - 1].connected(edge2)) {
                this.add_edge(n++, edge2, edge3);
                this.add_edge(n++, edge3, edge4);
                this.add_edge(n++, edge4, this.edges[n2 + 1]);
            } else {
                this.add_edge(n++, edge4, edge3);
                this.add_edge(n++, edge3, edge2);
                this.add_edge(n++, edge2, this.edges[n2 + 1]);
            }
            ++n2;
        }
        this.edges = edgeArray;
        this.n_edges += 2;
    }

    public Edge get_shortest_edge() {
        Edge edge = null;
        double d = Double.MAX_VALUE;
        int n = 0;
        while (n < this.n_edges) {
            double d2 = this.edges[n].length();
            if (d > d2) {
                edge = this.edges[n];
                d = d2;
            }
            ++n;
        }
        return edge;
    }

    public void set_normal() {
        this.normal = this.calc_normal();
    }

    public Vector3 calc_normal() {
        int n = 0;
        double d = 0.0;
        int n2 = 0;
        while (n2 < this.n_edges) {
            Vector3 vector3;
            Vector3 vector32 = new Vector3(this.get_vertex(n2), this.get_vertex(n2 + 1));
            double d2 = vector32.sin(vector3 = new Vector3(this.get_vertex(n2), this.get_vertex(n2 - 1)));
            if (d2 > d) {
                d = d2;
                n = n2;
            }
            ++n2;
        }
        Vertex vertex = this.get_vertex(n);
        double d3 = 0.0;
        Vector3 vector3 = new Vector3(this.get_vertex(n - 1), vertex);
        Vector3 vector33 = new Vector3(vertex, this.get_vertex(n + 1));
        Vector3 vector34 = vector3.cross_product(vector33);
        vector3 = new Vector3(vertex, this.get_vertex(n + 1));
        int n3 = n + 2;
        while (n3 < this.n_edges + n) {
            vector33 = new Vector3(vertex, this.get_vertex(n3));
            double d4 = vector3.get_relative_angle(vector33);
            if (vector34.dot_product(vector3.cross_product(vector33)) < 0.0) {
                d4 *= -1.0;
            }
            d3 += d4;
            vector3 = vector33;
            ++n3;
        }
        if (d3 < 0.0) {
            vector34.multiple_self(-1.0);
        }
        return vector34;
    }
}

