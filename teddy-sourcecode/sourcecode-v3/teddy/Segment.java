package teddy;

import java.io.Serializable;

public class Segment implements Serializable {
   public double x1;
   public double y1;
   public double x2;
   public double y2;

   public boolean same(Segment var1) {
      return this.start_node().same(var1.start_node()) && this.end_node().same(var1.end_node())
         || this.start_node().same(var1.end_node()) && this.end_node().same(var1.start_node());
   }

   public static double get_distance(Node var0, Node var1) {
      return Math.sqrt((var0.x - var1.x) * (var0.x - var1.x) + (var0.y - var1.y) * (var0.y - var1.y));
   }

   public boolean online(Node var1) {
      return this.distance_line(var1) < 1.0E-5;
   }

   public boolean between(Node var1) {
      return Def.equal(this.y1, this.y2)
         ? var1.x >= Math.min(this.x1, this.x2) - 1.0E-5 && var1.x <= Math.max(this.x1, this.x2) + 1.0E-5
         : var1.y >= Math.min(this.y1, this.y2) - 1.0E-5 && var1.y <= Math.max(this.y1, this.y2) + 1.0E-5;
   }

   public boolean parallel(Segment var1) {
      Vector2 var2 = this.vector();
      Vector2 var3 = var1.vector();
      double var4 = var2.get_sin(var3);
      return Math.abs(var4) < 1.0E-5;
   }

   public double parallel_interval(Segment var1) {
      Vector2 var2 = this.vector().normalize();
      Segment var3 = this.coord_system(var2);
      Segment var4 = var1.coord_system(var2);
      if (!((var3.x1 - var4.x2) * (var3.x2 - var4.x1) < 0.0)
         && !((var3.x1 - var4.x2) * (var3.x2 - var4.x2) < 0.0)
         && !((var4.x1 - var3.x1) * (var4.x2 - var3.x1) < 0.0)) {
         return -1.0;
      } else {
         double var5 = var4.y1 - var3.y1;
         return Math.abs(var5);
      }
   }

   Segment(double var1, double var3, double var5, double var7) {
      this.x1 = var1;
      this.y1 = var3;
      this.x2 = var5;
      this.y2 = var7;
   }

   Segment(Node var1, Node var2) {
      this.x1 = var1.x;
      this.y1 = var1.y;
      this.x2 = var2.x;
      this.y2 = var2.y;
   }

   public Vector2 vector() {
      return new Vector2(this.x2 - this.x1, this.y2 - this.y1);
   }

   public Node start_node() {
      return new Node(this.x1, this.y1);
   }

   public Node cross_node(Segment var1) {
      double var2 = this.y1 - this.y2;
      double var4 = this.x2 - this.x1;
      double var6 = this.y2 * this.x1 - this.x2 * this.y1;
      double var8 = var1.y1 - var1.y2;
      double var10 = var1.x2 - var1.x1;
      double var12 = var1.y2 * var1.x1 - var1.x2 * var1.y1;
      if (Math.abs(var2 * var10 - var8 * var4) < 1.0E-5) {
         System.out.println("Error in Segment.cross_node().");
         return null;
      } else {
         double var14 = (var4 * var12 - var10 * var6) / (var2 * var10 - var8 * var4);
         double var16 = (var2 * var12 - var8 * var6) / (var8 * var4 - var2 * var10);
         return new Node(var14, var16);
      }
   }

   public double coords(int var1) {
      switch (var1) {
         case 0:
            return this.x1;
         case 1:
            return this.y1;
         case 2:
            return this.x2;
         case 3:
            return this.y2;
         default:
            return 0.0;
      }
   }

   public double distance_line(Node var1) {
      double var2 = this.x2 - this.x1;
      double var4 = this.y2 - this.y1;
      double var6 = Math.sqrt(var2 * var2 + var4 * var4);
      double var8 = var2 * (var1.y - this.y1) - var4 * (var1.x - this.x1);
      if (var6 == 0.0) {
         System.out.println("Error in Segment.distance_line");
         return 0.0;
      } else {
         return Math.abs(var8 / var6);
      }
   }

   public boolean same_line(Segment var1) {
      return this.online(var1.start_node()) && this.online(var1.end_node());
   }

   public Segment coord_system(Vector2 var1) {
      double var2 = this.x1 * var1.x + this.y1 * var1.y;
      double var4 = -this.x1 * var1.y + this.y1 * var1.x;
      double var6 = this.x2 * var1.x + this.y2 * var1.y;
      double var8 = -this.x2 * var1.y + this.y2 * var1.x;
      return new Segment(var2, var4, var6, var8);
   }

   public double length() {
      return Vector2.distance(this.x1, this.y1, this.x2, this.y2);
   }

   public Node end_node() {
      return new Node(this.x2, this.y2);
   }

   public boolean cross(Segment var1) {
      double var2 = this.y1 - this.y2;
      double var4 = this.x2 - this.x1;
      double var6 = this.y2 * this.x1 - this.x2 * this.y1;
      double var8 = var1.y1 - var1.y2;
      double var10 = var1.x2 - var1.x1;
      double var12 = var1.y2 * var1.x1 - var1.x2 * var1.y1;
      return (var2 * var1.x1 + var4 * var1.y1 + var6) * (var2 * var1.x2 + var4 * var1.y2 + var6) <= 1.0E-5
         && (var8 * this.x1 + var10 * this.y1 + var12) * (var8 * this.x2 + var10 * this.y2 + var12) <= 1.0E-5;
   }

   public void configure(Node var1, Node var2) {
      this.x1 = var1.x;
      this.y1 = var1.y;
      this.x2 = var2.x;
      this.y2 = var2.y;
   }

   public double distance(Node var1) {
      Node var2 = this.start_node();
      Node var3 = this.end_node();
      Vector2 var4 = new Vector2(var2, var3);
      Vector2 var5 = new Vector2(var2, var1);
      if (var4.inner_product(var5) < 0.0) {
         return get_distance(var1, var2);
      } else {
         var5 = new Vector2(var3, var1);
         return var4.inner_product(var5) > 0.0 ? get_distance(var1, var3) : this.distance_line(var1);
      }
   }
}
