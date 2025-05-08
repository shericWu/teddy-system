package teddy;

import java.io.Serializable;
import java.util.Enumeration;

class Vertex extends Vector3 implements Serializable {
   LinkedList edges;
   public transient Vertex child = this;
   public transient int index;

   public Edge get_shared_edge(Vertex var1) {
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         Edge var3 = (Edge)var2.nextElement();
         if (var1.edges.member(var3)) {
            return var3;
         }
      }

      return null;
   }

   public double z() {
      return super.z;
   }

   public static Vertex mid_point(Vertex var0, Vertex var1) {
      return new Vertex((var0.x + var1.x) / 2.0, (var0.y + var1.y) / 2.0, (var0.z + var1.z) / 2.0);
   }

   Vertex() {
      this.edges = new LinkedList();
   }

   Vertex(double var1, double var3, double var5) {
      super.x = var1;
      super.y = var3;
      super.z = var5;
      this.edges = new LinkedList();
   }

   Vertex(Vector3 var1) {
      super.x = var1.x;
      super.y = var1.y;
      super.z = var1.z;
      this.edges = new LinkedList();
   }

   public boolean same_vertex(double var1, double var3, double var5) {
      return super.x == var1 && super.y == var3 && super.z == var5;
   }

   public Vertex position_copy() {
      Vertex var1 = new Vertex(super.x, super.y, super.z);
      this.child = var1;
      return var1;
   }

   public Vertex shift(Vector3 var1) {
      return new Vertex(super.x + var1.x, super.y + var1.y, super.z + var1.z);
   }

   public boolean edge_is_empty() {
      return this.edges.size() == 0;
   }

   public Vertex copy() {
      Vertex var1 = new Vertex(super.x, super.y, super.z);
      var1.edges = this.edges;
      this.child = var1;
      return var1;
   }

   public void warp(Vector3 var1) {
      super.x = var1.x;
      super.y = var1.y;
      super.z = var1.z;
   }

   public double x() {
      return super.x;
   }

   public void renew_network() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         Edge var3 = (Edge)var2.nextElement();
         var1.append(var3.child);
      }

      this.edges = var1;
   }

   public boolean same_position(Vertex var1) {
      return super.x == var1.x && super.y == var1.y && super.z == var1.z;
   }

   public void remove_edge(Edge var1) {
      this.edges.remove(var1);
   }

   public LinkedList get_sorrounding_vertices() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         Edge var3 = (Edge)var2.nextElement();
         var1.append(var3.get_the_other_vertex(this));
      }

      return var1;
   }

   public LinkedList polygons() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         Edge var3 = (Edge)var2.nextElement();
         if (var3.left_polygon() == null || var3.right_polygon() == null) {
            System.out.println("edge doesn't have 2 polygons (Vertex.polygons())");
         }

         if (!var1.member(var3.left_polygon())) {
            var1.append(var3.left_polygon());
         }

         if (!var1.member(var3.right_polygon())) {
            var1.append(var3.right_polygon());
         }
      }

      return var1;
   }

   public double y() {
      return super.y;
   }

   public double distance(Vertex var1) {
      return Vector3.distance(this, var1);
   }
}
