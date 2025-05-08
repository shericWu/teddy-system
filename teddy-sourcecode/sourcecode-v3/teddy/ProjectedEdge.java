package teddy;

import java.util.Enumeration;

class ProjectedEdge extends Edge2D {
   public ProjectedVertex start;
   public ProjectedVertex end;
   Edge original;
   int QI;
   int type;

   public double bottom() {
      return Math.max(this.start.y, this.end.y);
   }

   public Vertex2D cross_point(ProjectedEdge var1) {
      return this.cross_point(this.start.x, this.start.y, this.end.x, this.end.y, var1.start.x, var1.start.y, var1.end.x, var1.end.y);
   }

   public boolean connected(ProjectedEdge var1) {
      return this.start == var1.start || this.start == var1.end || this.end == var1.start || this.end == var1.end;
   }

   ProjectedEdge(Edge var1) {
      this.start = new ProjectedVertex(var1.start());
      this.end = new ProjectedVertex(var1.end());
      this.QI = -1;
      this.original = var1;
      this.type = var1.type;
   }

   ProjectedEdge(Vertex2D var1, Vertex2D var2) {
      this.start = new ProjectedVertex(var1);
      this.end = new ProjectedVertex(var2);
      this.original = null;
   }

   public boolean cross_behind(ProjectedEdge var1, Vertex var2) {
      if (this.connected(var1)) {
         return false;
      } else if (!this.cross(var1)) {
         return false;
      } else {
         Vertex2D var3 = this.cross_point(var1);
         if (var3 == null) {
            return false;
         } else {
            Vertex var4 = new Vertex(var3.x, 0.0, var3.y);
            Vector3 var5 = new Vector3(var2, this.original.start());
            Vector3 var6 = this.original.vector3();
            Vector3 var7 = new Vector3(var2, var4);
            double var8 = var5.cross_product(var6).length() / var7.cross_product(var6).length();
            var5 = new Vector3(var2, var1.original.start());
            var6 = var1.original.vector3();
            double var10 = var5.cross_product(var6).length() / var7.cross_product(var6).length();
            return var8 > var10;
         }
      }
   }

   public boolean in(Vertex2D var1) {
      Polygon2 var2 = this.original.left_polygon();
      boolean var3 = this.right_side_of_edge(this.start.x, this.start.y, this.end.x, this.end.y, var1.x, var1.y);
      return var2.front_facing ? !var3 : var3;
   }

   public boolean in(Polygon2 var1, Vertex2D var2) {
      Polygon2 var3 = this.original.left_polygon();
      boolean var4 = this.right_side_of_edge(this.start.x, this.start.y, this.end.x, this.end.y, var2.x, var2.y);
      if (!var1.front_facing) {
         var4 = !var4;
      }

      return var1 == var3 ? !var4 : var4;
   }

   public double top() {
      return Math.min(this.start.y, this.end.y);
   }

   public ProjectedVertex bottom_vertex() {
      return this.start.y > this.end.y ? this.start : this.end;
   }

   private boolean covered_sub(Vertex var1, Polygon2 var2) {
      if (!var2.front_facing) {
         return false;
      } else if (this.original.connected(var2)) {
         return false;
      } else {
         Vector3 var3 = this.original.vector3();
         if (this.original.end == var1) {
            var3 = var3.reverse();
         }

         if (var2.absolute_normal().dot_product(var3) >= 0.0) {
            return false;
         } else {
            int var4 = var2.get_vertex_index(var1);
            Vertex var5 = var2.get_vertex(var4 - 1);
            Vertex var6 = var2.get_vertex(var4 + 1);
            Vertex var7 = this.original.get_the_other_vertex(var1);
            ProjectedVertex var8 = new ProjectedVertex(var5);
            ProjectedVertex var9 = new ProjectedVertex(var6);
            ProjectedVertex var10 = new ProjectedVertex(var1);
            ProjectedVertex var11 = new ProjectedVertex(var7);
            Vector2 var12 = new Vector2(var10, var8);
            Vector2 var13 = new Vector2(var10, var9);
            Vector2 var14 = new Vector2(var10, var11);
            double var15 = 360.0 - var12.get_angle(var13);
            double var17 = 360.0 - var12.get_angle(var14);
            return var17 < var15;
         }
      }
   }

   public double left() {
      return Math.min(this.start.x, this.end.x);
   }

   public ProjectedVertex left_vertex() {
      return this.start.x < this.end.x ? this.start : this.end;
   }

   public double right() {
      return Math.max(this.start.x, this.end.x);
   }

   public boolean covered(ProjectedVertex var1) {
      Vertex var2 = var1.original;
      Enumeration var3 = var2.polygons().elements();

      while (var3.hasMoreElements()) {
         Polygon2 var4 = (Polygon2)var3.nextElement();
         if (this.covered_sub(var2, var4)) {
            return true;
         }
      }

      return false;
   }

   public ProjectedVertex another_vertex(ProjectedVertex var1) {
      return var1 == this.start ? this.end : this.start;
   }

   public boolean cross(ProjectedEdge var1) {
      return this.cross(this.start.x, this.start.y, this.end.x, this.end.y, var1.start.x, var1.start.y, var1.end.x, var1.end.y);
   }

   public ProjectedVertex right_vertex() {
      return this.start.x > this.end.x ? this.start : this.end;
   }

   public ProjectedVertex top_vertex() {
      return this.start.y < this.end.y ? this.start : this.end;
   }
}
