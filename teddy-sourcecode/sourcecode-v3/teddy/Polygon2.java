package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

class Polygon2 implements Serializable {
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

   public Vertex cross_point(Edge var1) {
      Vertex var2 = this.edges[0].start();
      Vector3 var3 = this.absolute_normal();
      Vector3 var4 = var1.vector3();
      Vertex var5 = var1.start();
      double var6 = (var2.dot_product(var3) - var5.dot_product(var3)) / var4.dot_product(var3);
      return new Vertex(var5.x + var4.x * var6, var5.y + var4.y * var6, var5.z + var4.z * var6);
   }

   public Edge edges(int var1) {
      if (var1 >= this.n_edges) {
         var1 -= var1 / this.n_edges * this.n_edges;
      }

      if (var1 < 0) {
         var1 += (-var1 / this.n_edges + 1) * this.n_edges;
      }

      return this.edges[var1];
   }

   public Edge get_longest_edge() {
      Edge var1 = null;
      double var2 = -1.0;

      for (int var4 = 0; var4 < this.n_edges; var4++) {
         double var5 = this.edges[var4].length();
         if (var2 < var5) {
            var1 = this.edges[var4];
            var2 = var5;
         }
      }

      return var1;
   }

   public Vertex get_vertex(int var1) {
      return this.edges(var1 - 1).get_common_vertex(this.edges(var1));
   }

   public LinkedList get_edges() {
      LinkedList var1 = new LinkedList();

      for (int var2 = 0; var2 < this.n_edges; var2++) {
         var1.append(this.edges[var2]);
      }

      return var1;
   }

   public void renew_network() {
      for (int var1 = 0; var1 < this.n_edges; var1++) {
         this.edges[var1] = this.edges[var1].child;
      }
   }

   public Vector get_vertices() {
      Vector var1 = new Vector();

      for (int var2 = 0; var2 < this.n_edges; var2++) {
         var1.addElement(this.get_vertex(var2));
      }

      return var1;
   }

   public void print_normal() {
      System.out.println("normal " + (int)(this.normal.x * 10.0) + "," + (int)(this.normal.y * 10.0) + "," + (int)(this.normal.z * 10.0));
   }

   public int get_vertex_index(Vertex var1) {
      for (int var2 = 0; var2 < this.n_edges; var2++) {
         if (this.get_vertex(var2) == var1) {
            return var2;
         }
      }

      System.out.println("Vertex not in Polygon (Polygon2.get_vertex_index)");
      return -1;
   }

   public int get_concave_vertex_index() {
      this.set_normal();

      for (int var1 = 0; var1 < this.n_edges; var1++) {
         if (this.is_concave(var1)) {
            return var1;
         }
      }

      return -1;
   }

   public boolean is_concave(int var1) {
      Vertex var2 = this.get_vertex(var1);
      Vector3 var3 = new Vector3(this.get_vertex(var1 - 1), var2);
      Vector3 var4 = new Vector3(var2, this.get_vertex(var1 + 1));
      Vector3 var5 = var3.cross_product(var4);
      return var3.parallel(var4) && var3.dot_product(var4) > 0.0 ? true : this.normal.dot_product(var5) <= 0.0;
   }

   public boolean on_polygon(Vertex var1) {
      this.set_normal();
      double var2 = 0.0;
      Vertex var6 = var1;
      Vector3 var4 = new Vector3(var1, this.get_vertex(0));

      for (int var7 = 1; var7 < this.n_edges + 1; var7++) {
         Vector3 var5 = new Vector3(var6, this.get_vertex(var7));
         double var8 = var4.get_relative_angle(var5);
         if (this.normal.dot_product(var4.cross_product(var5)) < 0.0) {
            var8 *= -1.0;
         }

         var2 += var8;
         var4 = var5;
      }

      return var2 > Math.PI;
   }

   private void add_edges(Enumeration var1) {
      Edge var2 = (Edge)var1.nextElement();
      Edge var3 = var2;

      for (int var5 = 0; var5 < this.n_edges - 1; var5++) {
         Edge var4 = (Edge)var1.nextElement();
         this.add_edge(var5, var2, var4);
         var2 = var4;
      }

      this.add_edge(this.n_edges - 1, var2, var3);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   private void add_edge(int var1, Edge var2, Edge var3) {
      this.edges[var1] = var2;
      if (var3.contain(var2.end)) {
         var2.set_left_polygon(this);
      } else {
         var2.set_right_polygon(this);
      }
   }

   private Edge find_shared_edge(Vertex var1, Vertex var2) {
      Enumeration var3 = var1.edges.elements();

      while (var3.hasMoreElements()) {
         Edge var5 = (Edge)var3.nextElement();
         Enumeration var4 = var2.edges.elements();

         while (var4.hasMoreElements()) {
            if (var5 == (Edge)var4.nextElement()) {
               return var5;
            }
         }
      }

      System.out.println("error while searching shared edge (Polygon2.java)");
      var3 = var1.edges.elements();

      while (var3.hasMoreElements()) {
         System.out.print(" " + var3.nextElement());
      }

      System.out.println("");
      Enumeration var7 = var2.edges.elements();

      while (var7.hasMoreElements()) {
         System.out.print(" " + var7.nextElement());
      }

      System.out.println("");
      return null;
   }

   public Objects get_the_other_edge(Vertex var1) {
      int var2 = 0;
      var2 = 0;

      while (var2 < this.n_edges && this.get_vertex(var2) != var1) {
         var2++;
      }

      return new Objects(this.get_vertex(var2 - 1), this.get_vertex(var2 + 1));
   }

   public void set_distance(Vertex var1) {
      this.distance = Vector3.distance(var1, this.centerVertex());
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

   Polygon2(Edge var1, Edge var2, Edge var3) {
      this.n_edges = 3;
      this.edges = new Edge[3];
      this.add_edge(0, var1, var2);
      this.add_edge(1, var2, var3);
      this.add_edge(2, var3, var1);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   Polygon2(Edge var1, Edge var2, Edge var3, Edge var4) {
      this.n_edges = 4;
      this.edges = new Edge[4];
      this.add_edge(0, var1, var2);
      this.add_edge(1, var2, var3);
      this.add_edge(2, var3, var4);
      this.add_edge(3, var4, var1);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   Polygon2(Vertex var1, Vertex var2, Vertex var3) {
      this.n_edges = 3;
      this.edges = new Edge[3];
      Edge var4 = this.find_shared_edge(var1, var2);
      Edge var5 = this.find_shared_edge(var2, var3);
      Edge var6 = this.find_shared_edge(var3, var1);
      this.add_edge(0, var4, var5);
      this.add_edge(1, var5, var6);
      this.add_edge(2, var6, var4);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   Polygon2(Vertex var1, Vertex var2, Vertex var3, Vertex var4) {
      this.n_edges = 4;
      this.edges = new Edge[4];
      Edge var5 = this.find_shared_edge(var1, var2);
      Edge var6 = this.find_shared_edge(var2, var3);
      Edge var7 = this.find_shared_edge(var3, var4);
      Edge var8 = this.find_shared_edge(var4, var1);
      this.add_edge(0, var5, var6);
      this.add_edge(1, var6, var7);
      this.add_edge(2, var7, var8);
      this.add_edge(3, var8, var5);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   Polygon2(int var1, Edge[] var2) {
      this.n_edges = var1;
      this.edges = new Edge[this.n_edges];

      for (int var3 = 0; var3 < this.n_edges - 1; var3++) {
         this.add_edge(var3, var2[var3], var2[var3 + 1]);
      }

      this.add_edge(var1 - 1, var2[var1 - 1], var2[0]);
      this.set_normal();
      this.front_facing = false;
      this.surface_lines = new LinkedList();
   }

   Polygon2(LinkedList var1) {
      this.n_edges = var1.size();
      this.edges = new Edge[this.n_edges];
      this.add_edges(var1.elements());
   }

   Polygon2(Vector var1) {
      this.n_edges = var1.size();
      this.edges = new Edge[this.n_edges];
      this.add_edges(var1.elements());
   }

   public Vector3 get_normal_simple() {
      for (int var1 = 0; var1 < this.n_edges - 1; var1++) {
         Vector3 var2 = new Vector3(this.get_vertex(var1 - 1), this.get_vertex(var1));
         Vector3 var3 = new Vector3(this.get_vertex(var1), this.get_vertex(var1 + 1));
         Vector3 var4 = var2.cross_product(var3);
         if (!var2.parallel(var3)) {
            return var4;
         }
      }

      return null;
   }

   public boolean contains(Edge var1) {
      for (int var2 = 0; var2 < this.n_edges; var2++) {
         if (this.edges[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   public boolean contains(Vertex var1) {
      for (int var2 = 0; var2 < this.n_edges; var2++) {
         if (this.edges[var2].contain(var1)) {
            return true;
         }
      }

      return false;
   }

   public void check_facing(Vertex var1) {
      Vector3 var2 = new Vector3(var1, this.edges(0).start());
      Vector3 var3 = this.absolute_normal();
      if (var2.dot_product(var3) < 0.0) {
         this.front_facing = true;
      } else {
         this.front_facing = false;
      }
   }

   public Polygon2 copy() {
      Polygon2 var1 = new Polygon2();
      var1.edges = (Edge[])this.edges.clone();
      var1.n_edges = this.n_edges;
      var1.surface_lines = new LinkedList();
      var1.normal = this.normal;
      var1.front_facing = this.front_facing;
      var1.part_index = this.part_index;
      this.child = var1;
      return var1;
   }

   public Vertex centerVertex() {
      double var1 = 0.0;
      double var3 = 0.0;
      double var5 = 0.0;

      for (int var10 = 0; var10 < this.n_edges; var10++) {
         Edge var7 = this.edges[var10];
         Vertex var8 = var7.start();
         Vertex var9 = var7.end();
         var1 = var1 + var8.x + var9.x;
         var3 = var3 + var8.y + var9.y;
         var5 = var5 + var8.z + var9.z;
      }

      var1 /= this.n_edges * 2;
      var3 /= this.n_edges * 2;
      var5 /= this.n_edges * 2;
      return new Vertex(var1, var3, var5);
   }

   public int get_edge_index(Edge var1) {
      for (int var2 = 0; var2 < this.n_edges; var2++) {
         if (this.edges(var2) == var1) {
            return var2;
         }
      }

      System.out.println("Edge not in Polygon (Polygon2.get_edge_index)");
      return -1;
   }

   public void edge_replace(Edge var1, Edge var2, Edge var3) {
      Edge[] var4 = new Edge[this.n_edges + 1];
      int var5 = 0;

      for (int var6 = 0; var6 < this.n_edges; var6++) {
         if (this.edges[var6] != var1) {
            var4[var5++] = this.edges[var6];
         } else if (this.edges[var6 - 1].connected(var2)) {
            this.add_edge(var5++, var2, var3);
            this.add_edge(var5++, var3, this.edges[var6 + 1]);
         } else {
            this.add_edge(var5++, var3, var2);
            this.add_edge(var5++, var2, this.edges[var6 + 1]);
         }
      }

      this.edges = var4;
      this.n_edges++;
   }

   public void edge_replace(Edge var1, Edge var2, Edge var3, Edge var4) {
      Edge[] var5 = new Edge[this.n_edges + 2];
      int var6 = 0;

      for (int var7 = 0; var7 < this.n_edges; var7++) {
         if (this.edges[var7] != var1) {
            var5[var6++] = this.edges[var7];
         } else if (this.edges[var7 - 1].connected(var2)) {
            this.add_edge(var6++, var2, var3);
            this.add_edge(var6++, var3, var4);
            this.add_edge(var6++, var4, this.edges[var7 + 1]);
         } else {
            this.add_edge(var6++, var4, var3);
            this.add_edge(var6++, var3, var2);
            this.add_edge(var6++, var2, this.edges[var7 + 1]);
         }
      }

      this.edges = var5;
      this.n_edges += 2;
   }

   public Edge get_shortest_edge() {
      Edge var1 = null;
      double var2 = Double.MAX_VALUE;

      for (int var4 = 0; var4 < this.n_edges; var4++) {
         double var5 = this.edges[var4].length();
         if (var2 > var5) {
            var1 = this.edges[var4];
            var2 = var5;
         }
      }

      return var1;
   }

   public void set_normal() {
      this.normal = this.calc_normal();
   }

   public Vector3 calc_normal() {
      int var1 = 0;
      double var2 = 0.0;

      for (int var4 = 0; var4 < this.n_edges; var4++) {
         Vector3 var5 = new Vector3(this.get_vertex(var4), this.get_vertex(var4 + 1));
         Vector3 var6 = new Vector3(this.get_vertex(var4), this.get_vertex(var4 - 1));
         double var7 = var5.sin(var6);
         if (var7 > var2) {
            var2 = var7;
            var1 = var4;
         }
      }

      Vertex var13 = this.get_vertex(var1);
      double var15 = 0.0;
      Vector3 var8 = new Vector3(this.get_vertex(var1 - 1), var13);
      Vector3 var9 = new Vector3(var13, this.get_vertex(var1 + 1));
      Vector3 var10 = var8.cross_product(var9);
      var8 = new Vector3(var13, this.get_vertex(var1 + 1));

      for (int var14 = var1 + 2; var14 < this.n_edges + var1; var14++) {
         var9 = new Vector3(var13, this.get_vertex(var14));
         double var11 = var8.get_relative_angle(var9);
         if (var10.dot_product(var8.cross_product(var9)) < 0.0) {
            var11 *= -1.0;
         }

         var15 += var11;
         var8 = var9;
      }

      if (var15 < 0.0) {
         var10.multiple_self(-1.0);
      }

      return var10;
   }
}
