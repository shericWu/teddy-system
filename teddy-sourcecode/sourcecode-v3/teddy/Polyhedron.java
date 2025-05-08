package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

class Polyhedron implements Serializable {
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
   public boolean view_changed;
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
      for (int var1 = 0; var1 < this.n_polygons; var1++) {
         this.polygons[var1].set_normal();
         this.polygons[var1].polyhedron = this;
      }

      for (int var2 = 0; var2 < this.n_edges; var2++) {
         this.edges[var2].set_parameters();
      }

      this.base_x = new Vector3(1.0, 0.0, 0.0);
      this.base_y = new Vector3(0.0, 1.0, 0.0);
      this.base_z = new Vector3(0.0, 0.0, 1.0);
      this.view_changed = true;
   }

   public void restore(Polyhedron var1) {
      this.n_vertices = var1.n_vertices;
      this.n_edges = var1.n_edges;
      this.n_polygons = var1.n_polygons;
      this.max_n_vertices = var1.max_n_vertices;
      this.max_n_edges = var1.max_n_edges;
      this.max_n_polygons = var1.max_n_polygons;
      this.vertices = var1.vertices;
      this.edges = var1.edges;
      this.polygons = var1.polygons;

      for (int var2 = 0; var2 < this.n_polygons; var2++) {
         this.polygons[var2].polyhedron = this;
      }

      this.surface_lines = var1.surface_lines;
      this.temp_surface_lines = var1.temp_surface_lines;
      this.temp_edge_vertex_list = var1.temp_edge_vertex_list;
      this.base_x = var1.base_x;
      this.base_y = var1.base_y;
      this.base_z = var1.base_z;
      this.current_part_index = var1.current_part_index;
      this.max_part_index = var1.max_part_index;
      this.parent_of_a_part = (int[])var1.parent_of_a_part.clone();
      this.pivot_of_a_part = (Vertex[])var1.pivot_of_a_part.clone();
      this.normal_of_a_part = (Vector3[])var1.normal_of_a_part.clone();
   }

   protected void postprocess() {
      this.postprocess_main();
      this.size_normalize();
      this.set_parameters();
   }

   void rotate_x(double var1) {
      this.rotate_sub(0, var1);
   }

   public void replace_edge(Edge var1, Edge var2, Edge var3) {
      if (var1.right_polygon() != null) {
         var1.right_polygon().edge_replace(var1, var2, var3);
      }

      if (var1.left_polygon() != null) {
         var1.left_polygon().edge_replace(var1, var2, var3);
      }

      this.remove(var1);
   }

   void rotate_y(double var1) {
      this.rotate_sub(1, var1);
   }

   public void replace_edge(Edge var1, Edge var2, Edge var3, Edge var4) {
      if (var1.right_polygon() != null) {
         var1.right_polygon().edge_replace(var1, var2, var3, var4);
      }

      if (var1.left_polygon() != null) {
         var1.left_polygon().edge_replace(var1, var2, var3, var4);
      }

      this.remove(var1);
   }

   protected Edge get_edge(Vertex var1, Vertex var2) {
      Enumeration var4 = var1.edges.elements();

      while (var4.hasMoreElements()) {
         Edge var3 = (Edge)var4.nextElement();
         if (var3.same_edge(var1, var2)) {
            return var3;
         }
      }

      var4 = var2.edges.elements();

      while (var4.hasMoreElements()) {
         Edge var5 = (Edge)var4.nextElement();
         if (var5.same_edge(var1, var2)) {
            return var5;
         }
      }

      Edge var6 = new Edge(var1, var2);
      this._edges.append(var6);
      return var6;
   }

   public Vertex get_vertex(Edge var1, Edge var2) {
      return var1.start() != var2.start() && var1.start() != var2.end() ? var1.end() : var1.start();
   }

   protected Vertex get_vertex(double var1, double var3, double var5) {
      Enumeration var8 = this._vertices.elements();

      while (var8.hasMoreElements()) {
         Vertex var7 = (Vertex)var8.nextElement();
         if (var7.same_vertex(var1, var3, var5)) {
            return var7;
         }
      }

      Vertex var9 = new Vertex(var1, var3, var5);
      this._vertices.append(var9);
      return var9;
   }

   public void append_edges(LinkedList var1) {
      Enumeration var2 = var1.elements();

      while (var2.hasMoreElements()) {
         this.append((Edge)var2.nextElement());
      }
   }

   public void append_a_new_polygon(Vertex var1, Vertex var2, Vertex var3) {
      Edge var4 = this.get_edge_array(var1, var2);
      Edge var5 = this.get_edge_array(var2, var3);
      Edge var6 = this.get_edge_array(var3, var1);
      this.append(new Polygon2(var4, var5, var6));
   }

   protected void postprocess_no_normalize() {
      this.postprocess_main();
      this.set_parameters();
   }

   protected Vertex get_vertex(Vertex var1) {
      return this.get_vertex(var1.x, var1.y, var1.z);
   }

   void rotate_z(double var1) {
      this.rotate_sub(2, var1);
   }

   public void append_vertices(LinkedList var1) {
      Enumeration var2 = var1.elements();

      while (var2.hasMoreElements()) {
         this.append((Vertex)var2.nextElement());
      }
   }

   public void remove(Vertex var1) {
      int var2 = 0;

      while (var2 < this.n_vertices && this.vertices[var2] != var1) {
         var2++;
      }

      if (var2 != this.n_vertices) {
         while (var2 < this.n_vertices - 1) {
            this.vertices[var2] = this.vertices[var2 + 1];
            var2++;
         }

         this.n_vertices += -1;
      }
   }

   public void remove(Polygon2 var1) {
      int var2 = 0;

      while (var2 < this.n_polygons && this.polygons[var2] != var1) {
         var2++;
      }

      if (var2 != this.n_polygons) {
         while (var2 < this.n_polygons - 1) {
            this.polygons[var2] = this.polygons[var2 + 1];
            var2++;
         }

         this.n_polygons += -1;

         for (int var4 = 0; var4 < var1.n_edges; var4++) {
            var1.edges(var4).remove_polygon(var1);
            if (var1.edges(var4).polygon_is_empty()) {
               this.remove(var1.edges(var4));
            }
         }

         Enumeration var3 = var1.surface_lines.elements();

         while (var3.hasMoreElements()) {
            this.surface_lines.remove((SurfaceLine)var3.nextElement());
         }
      }
   }

   public void remove(Edge var1) {
      int var2 = 0;

      while (var2 < this.n_edges && this.edges[var2] != var1) {
         var2++;
      }

      if (var2 == this.n_edges) {
         System.out.println("try to remove invalid (Polyhedron.remove(Edge))");
      } else {
         while (var2 < this.n_edges - 1) {
            this.edges[var2] = this.edges[var2 + 1];
            var2++;
         }

         this.n_edges += -1;
         var1.start.remove_edge(var1);
         if (var1.start.edge_is_empty()) {
            this.remove(var1.start);
         }

         var1.end.remove_edge(var1);
         if (var1.end.edge_is_empty()) {
            this.remove(var1.end);
         }
      }
   }

   Polyhedron() {
      this.base_x = new Vector3(1.0, 0.0, 0.0);
      this.base_y = new Vector3(0.0, 1.0, 0.0);
      this.base_z = new Vector3(0.0, 0.0, 1.0);
      this.surface_lines = new LinkedList();
      this.temp_surface_lines = new LinkedList();
      this.temp_edge_vertex_list = new LinkedList();
      this.view_changed = true;
      this.parent_of_a_part[0] = -1;
      this.pivot_of_a_part[0] = new Vertex(0.0, 0.0, 0.0);
      this.normal_of_a_part[0] = new Vector3(1.0, 0.0, 0.0);
   }

   protected void postprocess_main() {
      Enumeration var2 = this.tmp_polygons.elements();

      while (var2.hasMoreElements()) {
         Polyhedron.TmpPolygon var3 = (Polyhedron.TmpPolygon)var2.nextElement();
         this._polygons.append(var3.get_polygon());
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
      int var1 = 0;
      var2 = this._vertices.elements();

      while (var2.hasMoreElements()) {
         this.vertices[var1++] = (Vertex)var2.nextElement();
      }

      var1 = 0;
      var2 = this._edges.elements();

      while (var2.hasMoreElements()) {
         this.edges[var1++] = (Edge)var2.nextElement();
      }

      var1 = 0;
      var2 = this._polygons.elements();

      while (var2.hasMoreElements()) {
         Polygon2 var4 = (Polygon2)var2.nextElement();
         var4.polyhedron = this;
         this.polygons[var1++] = var4;
      }

      Trianglation.trianglate(this);
   }

   public Polyhedron(Vector var1, Vector var2, Vector var3, Vector var4) {
      this();
      this.tmp_polygons = new LinkedList();
      this._vertices = new LinkedList();
      this._edges = new LinkedList();
      this._polygons = new LinkedList();

      for (int var5 = 0; var5 < var1.size(); var5++) {
         this._vertices.append(var1.elementAt(var5));
      }

      for (int var10 = 0; var10 < var2.size(); var10++) {
         Vector var6 = (Vector)var2.elementAt(var10);
         LinkedList var7 = new LinkedList();

         for (int var8 = 0; var8 < var6.size(); var8++) {
            var7.append(var1.elementAt((Integer)var6.elementAt(var8)));
         }

         this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, var7));
      }

      this.postprocess_no_normalize();

      for (int var11 = 0; var11 < var3.size(); var11++) {
         Objects var13 = (Objects)var3.elementAt(var11);
         Vertex var15 = this.vertices[var13.get(0)];
         Vertex var17 = this.vertices[var13.get(1)];
         Edge var9 = var15.get_shared_edge(var17);
         var9.set_sharp(true);
      }

      for (int var12 = 0; var12 < var4.size(); var12++) {
         Objects var14 = (Objects)var4.elementAt(var12);
         Vertex var16 = (Vertex)var14.get(0);
         Vertex var18 = (Vertex)var14.get(1);
         Polygon2 var19 = this.polygons[var14.get(2)];
         this.surface_lines.append(new SurfaceLine(var16, var18, var19));
      }
   }

   public boolean contains(Polygon2 var1) {
      for (int var2 = 0; var2 < this.n_polygons; var2++) {
         if (this.polygons[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   public void size_normalize() {
      double var2 = 0.0;

      for (int var1 = 0; var1 < this.n_vertices; var1++) {
         var2 = Math.max(
            var2,
            Math.sqrt(
               this.vertices[var1].x * this.vertices[var1].x + this.vertices[var1].y * this.vertices[var1].y + this.vertices[var1].z * this.vertices[var1].z
            )
         );
      }

      for (int var4 = 0; var4 < this.n_vertices; var4++) {
         this.vertices[var4].x /= var2;
         this.vertices[var4].y /= var2;
         this.vertices[var4].z /= var2;
      }
   }

   public Vertex absolute_coords(Vector3 var1) {
      double var2 = this.base_x.x * var1.x + this.base_y.x * var1.y + this.base_z.x * var1.z;
      double var4 = this.base_x.y * var1.x + this.base_y.y * var1.y + this.base_z.y * var1.z;
      double var6 = this.base_x.z * var1.x + this.base_y.z * var1.y + this.base_z.z * var1.z;
      return new Vertex(var2, var4, var6);
   }

   public void after_loaded() {
      this.temp_surface_lines = new LinkedList();
      this.temp_edge_vertex_list = new LinkedList();
   }

   public Polyhedron copy() {
      Polyhedron var1 = new Polyhedron();
      var1.n_vertices = this.n_vertices;
      var1.n_edges = this.n_edges;
      var1.n_polygons = this.n_polygons;
      var1.max_n_vertices = this.max_n_vertices;
      var1.max_n_edges = this.max_n_edges;
      var1.max_n_polygons = this.max_n_polygons;
      var1.base_x = this.base_x.copyVector3();
      var1.base_y = this.base_y.copyVector3();
      var1.base_z = this.base_z.copyVector3();
      var1.view_changed = true;
      var1.vertices = new Vertex[this.max_n_vertices];

      for (int var2 = 0; var2 < this.n_vertices; var2++) {
         var1.vertices[var2] = this.vertices[var2].copy();
      }

      var1.edges = new Edge[this.max_n_edges];

      for (int var6 = 0; var6 < this.n_edges; var6++) {
         var1.edges[var6] = this.edges[var6].copy();
      }

      var1.polygons = new Polygon2[this.max_n_polygons];

      for (int var7 = 0; var7 < this.n_polygons; var7++) {
         var1.polygons[var7] = this.polygons[var7].copy();
      }

      for (int var8 = 0; var8 < this.n_vertices; var8++) {
         var1.vertices[var8].renew_network();
      }

      for (int var9 = 0; var9 < this.n_edges; var9++) {
         var1.edges[var9].renew_network();
      }

      for (int var10 = 0; var10 < this.n_polygons; var10++) {
         var1.polygons[var10].renew_network();
      }

      var1.surface_lines = new LinkedList();
      Enumeration var11 = this.surface_lines.elements();

      while (var11.hasMoreElements()) {
         var1.surface_lines.append(((SurfaceLine)var11.nextElement()).copy());
      }

      var1.temp_surface_lines = new LinkedList();
      var11 = this.temp_surface_lines.elements();

      while (var11.hasMoreElements()) {
         var1.temp_surface_lines.append(((SurfaceLine)var11.nextElement()).copy());
      }

      var1.temp_edge_vertex_list = new LinkedList();
      var11 = this.temp_edge_vertex_list.elements();

      while (var11.hasMoreElements()) {
         Objects var3 = (Objects)var11.nextElement();
         Vertex var4 = ((Vertex)var3.get(1)).child;
         if (var3.get(0) instanceof Edge) {
            Edge var5 = ((Edge)var3.get(0)).child;
            var1.temp_edge_vertex_list.append(new Objects(var5, var4));
         } else {
            Polygon2 var14 = ((Polygon2)var3.get(0)).child;
            var1.temp_edge_vertex_list.append(new Objects(var14, var4));
         }
      }

      var1.current_part_index = this.current_part_index;
      var1.max_part_index = this.max_part_index;
      var1.parent_of_a_part = (int[])this.parent_of_a_part.clone();
      var1.pivot_of_a_part = (Vertex[])this.pivot_of_a_part.clone();
      var1.normal_of_a_part = (Vector3[])this.normal_of_a_part.clone();
      return var1;
   }

   public Edge get_edge_array(Vertex var1, Vertex var2) {
      for (int var3 = 0; var3 < this.n_edges; var3++) {
         if (this.edges[var3].same_edge(var1, var2)) {
            return this.edges[var3];
         }
      }

      Edge var4 = new Edge(var1, var2);
      this.append(var4);
      return var4;
   }

   public void set_sharp_edges() {
      for (int var1 = 0; var1 < this.n_edges; var1++) {
         this.edges[var1].set_sharp_if_sharp();
      }
   }

   public Vertex relative_coords(Vector3 var1) {
      double var2 = this.base_x.dot_product(var1);
      double var4 = this.base_y.dot_product(var1);
      double var6 = this.base_z.dot_product(var1);
      return new Vertex(var2, var4, var6);
   }

   public void append(Polygon2 var1) {
      this.n_polygons++;
      if (this.n_polygons > this.max_n_polygons) {
         this.max_n_polygons *= 2;
         Polygon2[] var2 = this.polygons;
         this.polygons = new Polygon2[this.max_n_polygons];

         for (int var3 = 0; var3 < this.n_polygons - 1; var3++) {
            this.polygons[var3] = var2[var3];
         }
      }

      var1.polyhedron = this;
      this.polygons[this.n_polygons - 1] = var1;
      var1.part_index = this.current_part_index;
   }

   void rotate_sub(int var1, double var2) {
      this.base_x.rotate(var1, var2);
      this.base_y.rotate(var1, var2);
      this.base_z.rotate(var1, var2);

      for (int var4 = 0; var4 < this.n_vertices; var4++) {
         this.vertices[var4].rotate(var1, var2);
      }

      Enumeration var6 = this.surface_lines.elements();

      while (var6.hasMoreElements()) {
         Edge var5 = (Edge)var6.nextElement();
         var5.start.rotate(var1, var2);
         var5.end.rotate(var1, var2);
      }

      var6 = this.temp_surface_lines.elements();

      while (var6.hasMoreElements()) {
         Edge var8 = (Edge)var6.nextElement();
         var8.start.rotate(var1, var2);
         var8.end.rotate(var1, var2);
      }

      for (int var9 = 0; var9 <= this.max_part_index; var9++) {
         this.pivot_of_a_part[var9].rotate(var1, var2);
         this.normal_of_a_part[var9].rotate(var1, var2);
      }

      this.view_changed = true;
   }

   public void append(Vertex var1) {
      this.n_vertices++;
      if (this.n_vertices > this.max_n_vertices) {
         this.max_n_vertices *= 2;
         Vertex[] var2 = this.vertices;
         this.vertices = new Vertex[this.max_n_vertices];

         for (int var3 = 0; var3 < this.n_vertices - 1; var3++) {
            this.vertices[var3] = var2[var3];
         }
      }

      this.vertices[this.n_vertices - 1] = var1;
   }

   public void append(Edge var1) {
      this.n_edges++;
      if (this.n_edges > this.max_n_edges) {
         this.max_n_edges *= 2;
         Edge[] var2 = this.edges;
         this.edges = new Edge[this.max_n_edges];

         for (int var3 = 0; var3 < this.n_edges - 1; var3++) {
            this.edges[var3] = var2[var3];
         }
      }

      this.edges[this.n_edges - 1] = var1;
   }

   class TmpPolygon {
      public int n_vertices;
      public Vertex[] vertices;

      public Polygon2 get_polygon() {
         if (this.n_vertices == 3) {
            Edge var6 = this.this$0.get_edge(this.vertices[0], this.vertices[1]);
            Edge var8 = this.this$0.get_edge(this.vertices[1], this.vertices[2]);
            Edge var9 = this.this$0.get_edge(this.vertices[2], this.vertices[0]);
            return new Polygon2(var6, var8, var9);
         } else if (this.n_vertices == 4) {
            Edge var5 = this.this$0.get_edge(this.vertices[0], this.vertices[1]);
            Edge var7 = this.this$0.get_edge(this.vertices[1], this.vertices[2]);
            Edge var3 = this.this$0.get_edge(this.vertices[2], this.vertices[3]);
            Edge var4 = this.this$0.get_edge(this.vertices[3], this.vertices[0]);
            return new Polygon2(var5, var7, var3, var4);
         } else {
            LinkedList var1 = new LinkedList();

            int var2;
            for (var2 = 0; var2 < this.n_vertices - 1; var2++) {
               var1.append(this.this$0.get_edge(this.vertices[var2], this.vertices[var2 + 1]));
            }

            var1.append(this.this$0.get_edge(this.vertices[var2], this.vertices[0]));
            return new Polygon2(var1);
         }
      }

      TmpPolygon(Polyhedron var1, Vertex var2, Vertex var3, Vertex var4, Vertex var5) {
         (this.this$0 = var1).getClass();
         this.n_vertices = 4;
         this.vertices = new Vertex[this.n_vertices];
         this.vertices[0] = var2;
         this.vertices[1] = var3;
         this.vertices[2] = var4;
         this.vertices[3] = var5;
      }

      TmpPolygon(Polyhedron var1, Vertex var2, Vertex var3, Vertex var4) {
         (this.this$0 = var1).getClass();
         this.n_vertices = 3;
         this.vertices = new Vertex[this.n_vertices];
         this.vertices[0] = var2;
         this.vertices[1] = var3;
         this.vertices[2] = var4;
      }

      TmpPolygon(Polyhedron var1, LinkedList var2) {
         (this.this$0 = var1).getClass();
         this.n_vertices = var2.size();
         this.vertices = new Vertex[this.n_vertices];
         Enumeration var3 = var2.elements();
         int var4 = 0;

         while (var3.hasMoreElements()) {
            this.vertices[var4++] = (Vertex)var3.nextElement();
         }
      }
   }
}
