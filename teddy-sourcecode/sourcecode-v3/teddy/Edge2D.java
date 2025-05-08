package teddy;

import java.awt.Point;

class Edge2D {
   Vertex2D start;
   Vertex2D end;

   public Vector2 vector2() {
      return new Vector2(this.start, this.end);
   }

   public boolean right_side_of_edge(double var1, double var3, double var5, double var7, double var9, double var11) {
      double var13 = var3 - var7;
      double var15 = var5 - var1;
      double var17 = var7 * var1 - var5 * var3;
      return var13 * var9 + var15 * var11 + var17 < 0.0;
   }

   public Vertex2D cross_point(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      double var17 = var3 - var7;
      double var19 = var5 - var1;
      double var21 = var7 * var1 - var5 * var3;
      double var23 = var11 - var15;
      double var25 = var13 - var9;
      double var27 = var15 * var9 - var13 * var11;
      if (Math.abs(var17 * var25 - var23 * var19) < 1.0E-5) {
         return null;
      } else {
         double var29 = (var19 * var27 - var25 * var21) / (var17 * var25 - var23 * var19);
         double var31 = (var17 * var27 - var23 * var21) / (var23 * var19 - var17 * var25);
         return new Vertex2D(var29, var31);
      }
   }

   public Vertex2D mid_point() {
      return new Vertex2D((this.start.x + this.end.x) / 2.0, (this.start.y + this.end.y) / 2.0);
   }

   Edge2D() {
   }

   Edge2D(Vertex2D var1, Vertex2D var2) {
      this.start = var1;
      this.end = var2;
   }

   Edge2D(Point var1, Point var2) {
      this.start = new Vertex2D(var1);
      this.end = new Vertex2D(var2);
   }

   public Vertex2D get_the_other_vertex(Vertex2D var1) {
      return var1 == this.start ? this.end : this.start;
   }

   public Vertex2D get_common_vertex(Edge2D var1) {
      return this.start != var1.start && this.start != var1.end ? this.end : this.start;
   }

   public boolean contains(Vertex2D var1) {
      return var1 == this.start || var1 == this.end;
   }

   public boolean equals(Vertex2D var1, Vertex2D var2) {
      return var1 == this.start && var2 == this.end || var2 == this.start && var1 == this.end;
   }

   public double distance_as_a_segment(Vertex2D var1) {
      Vector2 var2 = new Vector2(this.start, this.end);
      Vector2 var3 = new Vector2(this.start, var1);
      if (var2.dot_product(var3) < 0.0) {
         return Vector2.distance(var1, this.start);
      } else {
         var3 = new Vector2(this.end, var1);
         return var2.dot_product(var3) > 0.0 ? Vector2.distance(var1, this.end) : this.distance(var1);
      }
   }

   public double length() {
      return Vector2.distance(this.start, this.end);
   }

   public boolean cross(Edge2D var1) {
      return this.cross(this.start.x, this.start.y, this.end.x, this.end.y, var1.start.x, var1.start.y, var1.end.x, var1.end.y);
   }

   public boolean cross(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      double var17 = var3 - var7;
      double var19 = var5 - var1;
      double var21 = var7 * var1 - var5 * var3;
      double var23 = var11 - var15;
      double var25 = var13 - var9;
      double var27 = var15 * var9 - var13 * var11;
      return (var17 * var9 + var19 * var11 + var21) * (var17 * var13 + var19 * var15 + var21) <= 0.0
         && (var23 * var1 + var25 * var3 + var27) * (var23 * var5 + var25 * var7 + var27) <= 0.0;
   }

   public double distance(Vertex2D var1) {
      double var2 = this.end.x - this.start.x;
      double var4 = this.end.y - this.start.y;
      double var6 = Math.sqrt(var2 * var2 + var4 * var4);
      double var8 = var2 * (var1.y - this.start.y) - var4 * (var1.x - this.start.x);
      if (var6 == 0.0) {
         System.out.println("Error in Edge2D.distance");
         return 0.0;
      } else {
         return Math.abs(var8 / var6);
      }
   }
}
