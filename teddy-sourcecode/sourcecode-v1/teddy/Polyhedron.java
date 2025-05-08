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
import teddy.Polygon2;
import teddy.SurfaceLine;
import teddy.Trianglation;
import teddy.Vector3;
import teddy.Vertex;

class Polyhedron
implements Serializable {
    public Vertex[] vertices;
    public Edge[] edges;
    public Polygon2[] polygons;
    public int n_vertices;
    public int n_edges;
    public int n_polygons;
    public int max_n_vertices;
    public int max_n_edges;
    public int max_n_polygons;
    public LinkedList surface_lines;
    public transient LinkedList temp_surface_lines;
    public transient LinkedList temp_edge_vertex_list;
    public Vector3 base_x;
    public Vector3 base_y;
    public Vector3 base_z;
    public boolean view_changed = true;
    public transient boolean section_bumping = false;
    public int[] parent_of_a_part = new int[20];
    public Vertex[] pivot_of_a_part = new Vertex[20];
    public Vector3[] normal_of_a_part = new Vector3[20];
    public int current_part_index = 0;
    public int max_part_index = 0;
    protected transient LinkedList tmp_polygons;
    protected transient LinkedList _vertices;
    protected transient LinkedList _edges;
    protected transient LinkedList _polygons;

    public void set_parameters() {
        int n = 0;
        while (n < this.n_polygons) {
            this.polygons[n].set_normal();
            this.polygons[n].polyhedron = this;
            ++n;
        }
        n = 0;
        while (n < this.n_edges) {
            this.edges[n].set_parameters();
            ++n;
        }
        this.base_x = new Vector3(1.0, 0.0, 0.0);
        this.base_y = new Vector3(0.0, 1.0, 0.0);
        this.base_z = new Vector3(0.0, 0.0, 1.0);
        this.view_changed = true;
    }

    public void restore(Polyhedron polyhedron) {
        this.n_vertices = polyhedron.n_vertices;
        this.n_edges = polyhedron.n_edges;
        this.n_polygons = polyhedron.n_polygons;
        this.max_n_vertices = polyhedron.max_n_vertices;
        this.max_n_edges = polyhedron.max_n_edges;
        this.max_n_polygons = polyhedron.max_n_polygons;
        this.vertices = polyhedron.vertices;
        this.edges = polyhedron.edges;
        this.polygons = polyhedron.polygons;
        int n = 0;
        while (n < this.n_polygons) {
            this.polygons[n].polyhedron = this;
            ++n;
        }
        this.surface_lines = polyhedron.surface_lines;
        this.temp_surface_lines = polyhedron.temp_surface_lines;
        this.temp_edge_vertex_list = polyhedron.temp_edge_vertex_list;
        this.base_x = polyhedron.base_x;
        this.base_y = polyhedron.base_y;
        this.base_z = polyhedron.base_z;
        this.current_part_index = polyhedron.current_part_index;
        this.max_part_index = polyhedron.max_part_index;
        this.parent_of_a_part = (int[])polyhedron.parent_of_a_part.clone();
        this.pivot_of_a_part = (Vertex[])polyhedron.pivot_of_a_part.clone();
        this.normal_of_a_part = (Vector3[])polyhedron.normal_of_a_part.clone();
    }

    protected void postprocess() {
        this.postprocess_main();
        this.size_normalize();
        this.set_parameters();
    }

    void rotate_x(double d) {
        this.rotate_sub(0, d);
    }

    public void replace_edge(Edge edge, Edge edge2, Edge edge3) {
        if (edge.right_polygon() != null) {
            edge.right_polygon().edge_replace(edge, edge2, edge3);
        }
        if (edge.left_polygon() != null) {
            edge.left_polygon().edge_replace(edge, edge2, edge3);
        }
        this.remove(edge);
    }

    void rotate_y(double d) {
        this.rotate_sub(1, d);
    }

    public void replace_edge(Edge edge, Edge edge2, Edge edge3, Edge edge4) {
        if (edge.right_polygon() != null) {
            edge.right_polygon().edge_replace(edge, edge2, edge3, edge4);
        }
        if (edge.left_polygon() != null) {
            edge.left_polygon().edge_replace(edge, edge2, edge3, edge4);
        }
        this.remove(edge);
    }

    protected Edge get_edge(Vertex vertex, Vertex vertex2) {
        Edge edge;
        Enumeration enumeration = vertex.edges.elements();
        while (enumeration.hasMoreElements()) {
            edge = (Edge)enumeration.nextElement();
            if (!edge.same_edge(vertex, vertex2)) continue;
            return edge;
        }
        enumeration = vertex2.edges.elements();
        while (enumeration.hasMoreElements()) {
            edge = (Edge)enumeration.nextElement();
            if (!edge.same_edge(vertex, vertex2)) continue;
            return edge;
        }
        edge = new Edge(vertex, vertex2);
        this._edges.append(edge);
        return edge;
    }

    public Vertex get_vertex(Edge edge, Edge edge2) {
        if (edge.start() == edge2.start() || edge.start() == edge2.end()) {
            return edge.start();
        }
        return edge.end();
    }

    protected Vertex get_vertex(double d, double d2, double d3) {
        Vertex vertex;
        Enumeration enumeration = this._vertices.elements();
        while (enumeration.hasMoreElements()) {
            vertex = (Vertex)enumeration.nextElement();
            if (!vertex.same_vertex(d, d2, d3)) continue;
            return vertex;
        }
        vertex = new Vertex(d, d2, d3);
        this._vertices.append(vertex);
        return vertex;
    }

    public void append_edges(LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            this.append((Edge)enumeration.nextElement());
        }
    }

    public void append_a_new_polygon(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        Edge edge = this.get_edge_array(vertex, vertex2);
        Edge edge2 = this.get_edge_array(vertex2, vertex3);
        Edge edge3 = this.get_edge_array(vertex3, vertex);
        this.append(new Polygon2(edge, edge2, edge3));
    }

    protected void postprocess_no_normalize() {
        this.postprocess_main();
        this.set_parameters();
    }

    protected Vertex get_vertex(Vertex vertex) {
        return this.get_vertex(vertex.x, vertex.y, vertex.z);
    }

    void rotate_z(double d) {
        this.rotate_sub(2, d);
    }

    public void append_vertices(LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            this.append((Vertex)enumeration.nextElement());
        }
    }

    /*
     * Unable to fully structure code
     */
    public void remove(Vertex var1_1) {
        var2_2 = 0;
        while (var2_2 < this.n_vertices) {
            if (this.vertices[var2_2] == var1_1) break;
            ++var2_2;
        }
        if (var2_2 != this.n_vertices) ** GOTO lbl10
        return;
lbl-1000:
        // 1 sources

        {
            this.vertices[var2_2] = this.vertices[var2_2 + 1];
            ++var2_2;
lbl10:
            // 2 sources

            ** while (var2_2 < this.n_vertices - 1)
        }
lbl11:
        // 1 sources

        this.n_vertices += -1;
    }

    /*
     * Unable to fully structure code
     */
    public void remove(Polygon2 var1_1) {
        var2_2 = 0;
        while (var2_2 < this.n_polygons) {
            if (this.polygons[var2_2] == var1_1) break;
            ++var2_2;
        }
        if (var2_2 != this.n_polygons) ** GOTO lbl10
        return;
lbl-1000:
        // 1 sources

        {
            this.polygons[var2_2] = this.polygons[var2_2 + 1];
            ++var2_2;
lbl10:
            // 2 sources

            ** while (var2_2 < this.n_polygons - 1)
        }
lbl11:
        // 1 sources

        this.n_polygons += -1;
        var2_2 = 0;
        while (var2_2 < var1_1.n_edges) {
            var1_1.edges(var2_2).remove_polygon(var1_1);
            if (var1_1.edges(var2_2).polygon_is_empty()) {
                this.remove(var1_1.edges(var2_2));
            }
            ++var2_2;
        }
        var3_3 = var1_1.surface_lines.elements();
        while (var3_3.hasMoreElements()) {
            this.surface_lines.remove((SurfaceLine)var3_3.nextElement());
        }
    }

    /*
     * Unable to fully structure code
     */
    public void remove(Edge var1_1) {
        var2_2 = 0;
        while (var2_2 < this.n_edges) {
            if (this.edges[var2_2] == var1_1) break;
            ++var2_2;
        }
        if (var2_2 != this.n_edges) ** GOTO lbl11
        System.out.println("try to remove invalid (Polyhedron.remove(Edge))");
        return;
lbl-1000:
        // 1 sources

        {
            this.edges[var2_2] = this.edges[var2_2 + 1];
            ++var2_2;
lbl11:
            // 2 sources

            ** while (var2_2 < this.n_edges - 1)
        }
lbl12:
        // 1 sources

        this.n_edges += -1;
        var1_1.start.remove_edge(var1_1);
        if (var1_1.start.edge_is_empty()) {
            this.remove(var1_1.start);
        }
        var1_1.end.remove_edge(var1_1);
        if (var1_1.end.edge_is_empty()) {
            this.remove(var1_1.end);
        }
    }

    Polyhedron() {
        this.base_x = new Vector3(1.0, 0.0, 0.0);
        this.base_y = new Vector3(0.0, 1.0, 0.0);
        this.base_z = new Vector3(0.0, 0.0, 1.0);
        this.surface_lines = new LinkedList();
        this.temp_surface_lines = new LinkedList();
        this.temp_edge_vertex_list = new LinkedList();
        this.parent_of_a_part[0] = -1;
        this.pivot_of_a_part[0] = new Vertex(0.0, 0.0, 0.0);
        this.normal_of_a_part[0] = new Vector3(1.0, 0.0, 0.0);
    }

    protected void postprocess_main() {
        Enumeration enumeration = this.tmp_polygons.elements();
        while (enumeration.hasMoreElements()) {
            TmpPolygon tmpPolygon = (TmpPolygon)enumeration.nextElement();
            this._polygons.append(tmpPolygon.get_polygon());
        }
        this.n_vertices = this._vertices.size();
        this.n_edges = this._edges.size();
        this.n_polygons = this._polygons.size();
        this.max_n_vertices = this.n_vertices * 2;
        this.max_n_edges = this.n_edges * 2;
        this.max_n_polygons = this.n_polygons * 2;
        this.vertices = new Vertex[this.max_n_vertices];
        this.edges = new Edge[this.max_n_edges];
        this.polygons = new Polygon2[this.max_n_polygons];
        int n = 0;
        enumeration = this._vertices.elements();
        while (enumeration.hasMoreElements()) {
            this.vertices[n++] = (Vertex)enumeration.nextElement();
        }
        n = 0;
        enumeration = this._edges.elements();
        while (enumeration.hasMoreElements()) {
            this.edges[n++] = (Edge)enumeration.nextElement();
        }
        n = 0;
        enumeration = this._polygons.elements();
        while (enumeration.hasMoreElements()) {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            polygon2.polyhedron = this;
            this.polygons[n++] = polygon2;
        }
        Trianglation.trianglate(this);
    }

    public Polyhedron(Vector vector, Vector vector2, Vector vector3, Vector vector4) {
        this();
        Serializable serializable;
        Serializable serializable2;
        Serializable serializable3;
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
        int n = 0;
        while (n < vector.size()) {
            this._vertices.append(vector.elementAt(n));
            ++n;
        }
        n = 0;
        while (n < vector2.size()) {
            serializable3 = (Vector)vector2.elementAt(n);
            serializable2 = new LinkedList();
            int n2 = 0;
            while (n2 < ((Vector)serializable3).size()) {
                ((LinkedList)serializable2).append(vector.elementAt((Integer)((Vector)serializable3).elementAt(n2)));
                ++n2;
            }
            this.tmp_polygons.append(new TmpPolygon((LinkedList)serializable2));
            ++n;
        }
        this.postprocess_no_normalize();
        n = 0;
        while (n < vector3.size()) {
            serializable3 = (Objects)vector3.elementAt(n);
            serializable2 = this.vertices[(Integer)((Objects)serializable3).get(0)];
            Vertex vertex = this.vertices[(Integer)((Objects)serializable3).get(1)];
            serializable = ((Vertex)serializable2).get_shared_edge(vertex);
            serializable.set_sharp(true);
            ++n;
        }
        n = 0;
        while (n < vector4.size()) {
            serializable3 = (Objects)vector4.elementAt(n);
            serializable2 = (Vertex)((Objects)serializable3).get(0);
            Vertex vertex = (Vertex)((Objects)serializable3).get(1);
            serializable = this.polygons[(Integer)((Objects)serializable3).get(2)];
            this.surface_lines.append(new SurfaceLine((Vertex)serializable2, vertex, (Polygon2)serializable));
            ++n;
        }
    }

    public boolean contains(Polygon2 polygon2) {
        int n = 0;
        while (n < this.n_polygons) {
            if (this.polygons[n] == polygon2) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public void size_normalize() {
        double d = 0.0;
        int n = 0;
        while (n < this.n_vertices) {
            d = Math.max(d, Math.sqrt(this.vertices[n].x * this.vertices[n].x + this.vertices[n].y * this.vertices[n].y + this.vertices[n].z * this.vertices[n].z));
            ++n;
        }
        n = 0;
        while (n < this.n_vertices) {
            this.vertices[n].x /= d;
            this.vertices[n].y /= d;
            this.vertices[n].z /= d;
            ++n;
        }
    }

    public Vertex absolute_coords(Vector3 vector3) {
        double d = this.base_x.x * vector3.x + this.base_y.x * vector3.y + this.base_z.x * vector3.z;
        double d2 = this.base_x.y * vector3.x + this.base_y.y * vector3.y + this.base_z.y * vector3.z;
        double d3 = this.base_x.z * vector3.x + this.base_y.z * vector3.y + this.base_z.z * vector3.z;
        return new Vertex(d, d2, d3);
    }

    public void after_loaded() {
        this.temp_surface_lines = new LinkedList();
        this.temp_edge_vertex_list = new LinkedList();
    }

    public Polyhedron copy() {
        Polyhedron polyhedron = new Polyhedron();
        polyhedron.n_vertices = this.n_vertices;
        polyhedron.n_edges = this.n_edges;
        polyhedron.n_polygons = this.n_polygons;
        polyhedron.max_n_vertices = this.max_n_vertices;
        polyhedron.max_n_edges = this.max_n_edges;
        polyhedron.max_n_polygons = this.max_n_polygons;
        polyhedron.base_x = this.base_x.copyVector3();
        polyhedron.base_y = this.base_y.copyVector3();
        polyhedron.base_z = this.base_z.copyVector3();
        polyhedron.view_changed = true;
        polyhedron.vertices = new Vertex[this.max_n_vertices];
        int n = 0;
        while (n < this.n_vertices) {
            polyhedron.vertices[n] = this.vertices[n].copy();
            ++n;
        }
        polyhedron.edges = new Edge[this.max_n_edges];
        n = 0;
        while (n < this.n_edges) {
            polyhedron.edges[n] = this.edges[n].copy();
            ++n;
        }
        polyhedron.polygons = new Polygon2[this.max_n_polygons];
        n = 0;
        while (n < this.n_polygons) {
            polyhedron.polygons[n] = this.polygons[n].copy();
            ++n;
        }
        n = 0;
        while (n < this.n_vertices) {
            polyhedron.vertices[n].renew_network();
            ++n;
        }
        n = 0;
        while (n < this.n_edges) {
            polyhedron.edges[n].renew_network();
            ++n;
        }
        n = 0;
        while (n < this.n_polygons) {
            polyhedron.polygons[n].renew_network();
            ++n;
        }
        polyhedron.surface_lines = new LinkedList();
        Enumeration enumeration = this.surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            polyhedron.surface_lines.append(((SurfaceLine)enumeration.nextElement()).copy());
        }
        polyhedron.temp_surface_lines = new LinkedList();
        enumeration = this.temp_surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            polyhedron.temp_surface_lines.append(((SurfaceLine)enumeration.nextElement()).copy());
        }
        polyhedron.temp_edge_vertex_list = new LinkedList();
        enumeration = this.temp_edge_vertex_list.elements();
        while (enumeration.hasMoreElements()) {
            Serializable serializable;
            Objects objects = (Objects)enumeration.nextElement();
            Vertex vertex = ((Vertex)objects.get((int)1)).child;
            if (objects.get(0) instanceof Edge) {
                serializable = ((Edge)objects.get((int)0)).child;
                polyhedron.temp_edge_vertex_list.append(new Objects(serializable, vertex));
                continue;
            }
            serializable = ((Polygon2)objects.get((int)0)).child;
            polyhedron.temp_edge_vertex_list.append(new Objects(serializable, vertex));
        }
        polyhedron.current_part_index = this.current_part_index;
        polyhedron.max_part_index = this.max_part_index;
        polyhedron.parent_of_a_part = (int[])this.parent_of_a_part.clone();
        polyhedron.pivot_of_a_part = (Vertex[])this.pivot_of_a_part.clone();
        polyhedron.normal_of_a_part = (Vector3[])this.normal_of_a_part.clone();
        return polyhedron;
    }

    public Edge get_edge_array(Vertex vertex, Vertex vertex2) {
        int n = 0;
        while (n < this.n_edges) {
            if (this.edges[n].same_edge(vertex, vertex2)) {
                return this.edges[n];
            }
            ++n;
        }
        Edge edge = new Edge(vertex, vertex2);
        this.append(edge);
        return edge;
    }

    public void set_sharp_edges() {
        int n = 0;
        while (n < this.n_edges) {
            this.edges[n].set_sharp_if_sharp();
            ++n;
        }
    }

    public Vertex relative_coords(Vector3 vector3) {
        double d = this.base_x.dot_product(vector3);
        double d2 = this.base_y.dot_product(vector3);
        double d3 = this.base_z.dot_product(vector3);
        return new Vertex(d, d2, d3);
    }

    public void append(Polygon2 polygon2) {
        ++this.n_polygons;
        if (this.n_polygons > this.max_n_polygons) {
            this.max_n_polygons *= 2;
            Polygon2[] polygon2Array = this.polygons;
            this.polygons = new Polygon2[this.max_n_polygons];
            int n = 0;
            while (n < this.n_polygons - 1) {
                this.polygons[n] = polygon2Array[n];
                ++n;
            }
        }
        polygon2.polyhedron = this;
        this.polygons[this.n_polygons - 1] = polygon2;
        polygon2.part_index = this.current_part_index;
    }

    void rotate_sub(int n, double d) {
        Edge edge;
        this.base_x.rotate(n, d);
        this.base_y.rotate(n, d);
        this.base_z.rotate(n, d);
        int n2 = 0;
        while (n2 < this.n_vertices) {
            this.vertices[n2].rotate(n, d);
            ++n2;
        }
        Enumeration enumeration = this.surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            edge = (Edge)enumeration.nextElement();
            edge.start.rotate(n, d);
            edge.end.rotate(n, d);
        }
        enumeration = this.temp_surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            edge = (Edge)enumeration.nextElement();
            edge.start.rotate(n, d);
            edge.end.rotate(n, d);
        }
        int n3 = 0;
        while (n3 <= this.max_part_index) {
            this.pivot_of_a_part[n3].rotate(n, d);
            this.normal_of_a_part[n3].rotate(n, d);
            ++n3;
        }
        this.view_changed = true;
    }

    public void append(Vertex vertex) {
        ++this.n_vertices;
        if (this.n_vertices > this.max_n_vertices) {
            this.max_n_vertices *= 2;
            Vertex[] vertexArray = this.vertices;
            this.vertices = new Vertex[this.max_n_vertices];
            int n = 0;
            while (n < this.n_vertices - 1) {
                this.vertices[n] = vertexArray[n];
                ++n;
            }
        }
        this.vertices[this.n_vertices - 1] = vertex;
    }

    public void append(Edge edge) {
        ++this.n_edges;
        if (this.n_edges > this.max_n_edges) {
            this.max_n_edges *= 2;
            Edge[] edgeArray = this.edges;
            this.edges = new Edge[this.max_n_edges];
            int n = 0;
            while (n < this.n_edges - 1) {
                this.edges[n] = edgeArray[n];
                ++n;
            }
        }
        this.edges[this.n_edges - 1] = edge;
    }

    class TmpPolygon {
        public int n_vertices;
        public Vertex[] vertices;

        public Polygon2 get_polygon() {
            if (this.n_vertices == 3) {
                Edge edge = Polyhedron.this.get_edge(this.vertices[0], this.vertices[1]);
                Edge edge2 = Polyhedron.this.get_edge(this.vertices[1], this.vertices[2]);
                Edge edge3 = Polyhedron.this.get_edge(this.vertices[2], this.vertices[0]);
                return new Polygon2(edge, edge2, edge3);
            }
            if (this.n_vertices == 4) {
                Edge edge = Polyhedron.this.get_edge(this.vertices[0], this.vertices[1]);
                Edge edge4 = Polyhedron.this.get_edge(this.vertices[1], this.vertices[2]);
                Edge edge5 = Polyhedron.this.get_edge(this.vertices[2], this.vertices[3]);
                Edge edge6 = Polyhedron.this.get_edge(this.vertices[3], this.vertices[0]);
                return new Polygon2(edge, edge4, edge5, edge6);
            }
            LinkedList linkedList = new LinkedList();
            int n = 0;
            while (n < this.n_vertices - 1) {
                linkedList.append(Polyhedron.this.get_edge(this.vertices[n], this.vertices[n + 1]));
                ++n;
            }
            linkedList.append(Polyhedron.this.get_edge(this.vertices[n], this.vertices[0]));
            return new Polygon2(linkedList);
        }

        TmpPolygon(Vertex vertex, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
            Polyhedron.this.getClass();
            this.n_vertices = 4;
            this.vertices = new Vertex[this.n_vertices];
            this.vertices[0] = vertex;
            this.vertices[1] = vertex2;
            this.vertices[2] = vertex3;
            this.vertices[3] = vertex4;
        }

        TmpPolygon(Vertex vertex, Vertex vertex2, Vertex vertex3) {
            Polyhedron.this.getClass();
            this.n_vertices = 3;
            this.vertices = new Vertex[this.n_vertices];
            this.vertices[0] = vertex;
            this.vertices[1] = vertex2;
            this.vertices[2] = vertex3;
        }

        TmpPolygon(LinkedList linkedList) {
            Polyhedron.this.getClass();
            this.n_vertices = linkedList.size();
            this.vertices = new Vertex[this.n_vertices];
            Enumeration enumeration = linkedList.elements();
            int n = 0;
            while (enumeration.hasMoreElements()) {
                this.vertices[n++] = (Vertex)enumeration.nextElement();
            }
        }
    }
}

