package teddy;

import java.io.Serializable;

class Edge implements Serializable {
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

   public boolean contain(Vertex var1) {
      return this.start == var1 || this.end == var1;
   }

   public Vertex end() {
      return this.end;
   }

   public boolean connected(Polygon2 var1) {
      return var1 == this.left_polygon() || var1 == this.right_polygon();
   }

   public boolean connected(Edge var1) {
      return this.start == var1.start || this.start == var1.end || this.end == var1.start || this.end == var1.end;
   }

   public void set_parameters() {
      if (this.left_polygon() == null && this.right_polygon() == null) {
         System.out.println("Edge has no polygon (Edge:set_parameters())");
      } else if (this.left_polygon() != null && this.right_polygon() != null) {
         Polygon2 var1 = this.left_polygon();
         Polygon2 var2 = this.right_polygon();
         Vector3 var3 = new Vector3(this.start, this.end);
         Vector3 var4 = var1.normal;
         Vector3 var5 = var2.normal;
         Vector3 var6 = var4.cross_product(var5);
         this.concave = var3.cos(var6) < 0.0;
      } else {
         System.out.println("Edge doesn't have 2 polygons (Edge:set_parameters())" + this.start + "," + this.end);
         if (this.left_polygon() == null) {
            Draw3DScene.current_polygon = this.right_polygon();
         } else {
            Draw3DScene.current_polygon = this.left_polygon();
         }
      }
   }

   public void set_sharp_if_sharp() {
      Vector3 var1 = this.left_polygon().normal;
      Vector3 var2 = this.right_polygon().normal;
      if (this.concave) {
         this.sharp = var1.cos(var2) < 0.7;
      } else {
         this.sharp = var1.cos(var2) < 0.3;
      }
   }

   public int visibility_type() {
      Polygon2 var1 = this.left_polygon();
      Polygon2 var2 = this.right_polygon();
      if (var1.front_facing && var2.front_facing && this.sharp) {
         return this.type = 3;
      } else if (var1.front_facing == var2.front_facing) {
         return this.type = 0;
      } else {
         return this.concave ? (this.type = 1) : (this.type = 2);
      }
   }

   public boolean on_edge(Vertex var1) {
      if (var1 != this.start && var1 != this.end) {
         Vector3 var2 = new Vector3(var1, this.start);
         Vector3 var3 = new Vector3(var1, this.end);
         return var2.cos(var3) < -0.9;
      } else {
         return true;
      }
   }

   public boolean silhouette() {
      this.visibility_type();
      return this.type == 1 || this.type == 2;
   }

   public void set_sharp() {
      this.sharp = true;
   }

   public void set_sharp(boolean var1) {
      this.sharp = var1;
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

   public Polygon2 get_another_polygon(Polygon2 var1) {
      return this.get_the_other_polygon(var1);
   }

   public Polygon2 get_the_other_polygon(Polygon2 var1) {
      return this.left_polygon() != var1 ? this.left_polygon() : this.right_polygon();
   }

   public void set_right_polygon(Polygon2 var1) {
      this.right_polygon = var1;
   }

   public Vector3 vertical_from(Vertex var1) {
      Vertex var2 = this.start();
      Vertex var3 = this.end();
      Vector3 var4 = new Vector3(var2, var3);
      Vector3 var5 = new Vector3(var2, var1);
      double var6 = var4.dot_product(var5);
      double var8 = var4.length();
      Vector3 var10 = var4.multiple(var6 / var8 / var8);
      Vertex var11 = var2.shift(var10);
      return new Vector3(var1, var11);
   }

   public boolean polygon_is_empty() {
      return this.left_polygon == null && this.right_polygon == null;
   }

   public double length() {
      return this.vector3().length();
   }

   public boolean same_edge(Vertex var1, Vertex var2) {
      return var1 == this.start && var2 == this.end || var2 == this.start && var1 == this.end;
   }

   Edge() {
      this.start = new Vertex();
      this.end = new Vertex();
      this.left_polygon = null;
      this.right_polygon = null;
   }

   Edge(Vertex var1, Vertex var2) {
      this.start = var1;
      this.end = var2;
      if (this.start == this.end) {
         System.out.println("Edge with same Vertex (Edge.java)");
      }

      this.start.edges.append(this);
      this.end.edges.append(this);
      this.left_polygon = null;
      this.right_polygon = null;
   }

   public Vertex get_the_other_vertex(Vertex var1) {
      return var1 == this.start ? this.end : this.start;
   }

   public Vertex get_common_vertex(Edge var1) {
      return this.start != var1.start && this.start != var1.end ? this.end : this.start;
   }

   public boolean possible() {
      this.visibility_type();
      return this.type == 3 || this.type == 2;
   }

   public Polygon2 right_polygon() {
      return this.right_polygon;
   }

   public void set_left_polygon(Polygon2 var1) {
      this.left_polygon = var1;
   }

   public void remove_polygon(Polygon2 var1) {
      if (this.left_polygon == var1) {
         this.left_polygon = null;
      } else {
         if (this.right_polygon == var1) {
            this.right_polygon = null;
         }
      }
   }

   public Vector3 vector3() {
      return new Vector3(this.start, this.end);
   }

   public Edge copy() {
      Edge var1 = new Edge();
      var1.start = this.start;
      var1.end = this.end;
      var1.left_polygon = this.left_polygon;
      var1.right_polygon = this.right_polygon;
      var1.sharp = this.sharp;
      var1.concave = this.concave;
      this.child = var1;
      return var1;
   }

   public void print() {
      System.out.println("" + this + ":" + this.start + "," + this.end + "; " + this.left_polygon + "," + this.right_polygon);
   }
}
