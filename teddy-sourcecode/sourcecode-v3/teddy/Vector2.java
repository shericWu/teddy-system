package teddy;

import java.awt.Point;

public class Vector2 {
   public double x;
   public double y;

   public static double distance(Point var0, Point var1) {
      return distance(var0.x, var0.y, var1.x, var1.y);
   }

   public void normalize_self() {
      double var1 = this.length();
      if (var1 == 0.0) {
         var1 = 1.0;
      }

      this.x /= var1;
      this.y /= var1;
   }

   public static double distance(double var0, double var2, double var4, double var6) {
      return Math.sqrt((var4 - var0) * (var4 - var0) + (var6 - var2) * (var6 - var2));
   }

   public static double distance(Vertex2D var0, Vertex2D var1) {
      return distance(var0.x, var0.y, var1.x, var1.y);
   }

   public Vector2 normalize() {
      double var1 = this.length();
      if (var1 == 0.0) {
         var1 = 1.0;
      }

      return new Vector2(this.x / var1, this.y / var1);
   }

   public double get_sin(Vector2 var1) {
      double var2 = Math.sqrt((this.x * this.x + this.y * this.y) * (var1.x * var1.x + var1.y * var1.y));
      return var2 > 0.0 ? this.cross_product(var1) / var2 : 0.0;
   }

   protected Vector2 add(Vector2 var1) {
      return new Vector2(this.x + var1.x, this.y + var1.y);
   }

   public double get_cos(Vector2 var1) {
      double var2 = Math.sqrt((this.x * this.x + this.y * this.y) * (var1.x * var1.x + var1.y * var1.y));
      return var2 > 0.0 ? this.inner_product(var1) / var2 : 0.0;
   }

   public void multiple_self(double var1) {
      this.x *= var1;
      this.y *= var1;
   }

   public void rotate90_self() {
      this.x = -this.y;
      this.y = this.x;
   }

   public double inner_product(Vector2 var1) {
      return this.x * var1.x + this.y * var1.y;
   }

   public double cross_product(Vector2 var1) {
      return this.x * var1.y - this.y * var1.x;
   }

   public Vertex2D vertex2D() {
      return new Vertex2D(this.x, this.y);
   }

   public void add_self(Vector2 var1) {
      this.x = this.x + var1.x;
      this.y = this.y + var1.y;
   }

   public Vector2 flip_y_axis() {
      return new Vector2(-this.x, this.y);
   }

   public Vector2 get_normalized() {
      double var1 = this.length();
      if (var1 == 0.0) {
         var1 = 1.0;
      }

      return new Vector2(this.x / var1, this.y / var1);
   }

   public double length() {
      return Math.sqrt(this.x * this.x + this.y * this.y);
   }

   public Vector2 rotate90() {
      return new Vector2(-this.y, this.x);
   }

   public Vector2 scale(double var1) {
      return new Vector2(this.x * var1, this.y * var1);
   }

   public double cos(Vector2 var1) {
      return this.get_cos(var1);
   }

   public double outer_product(Vector2 var1) {
      return this.x * var1.y - this.y * var1.x;
   }

   public double dot_product(Vector2 var1) {
      return this.x * var1.x + this.y * var1.y;
   }

   public double sin(Vector2 var1) {
      return this.get_sin(var1);
   }

   Vector2(Node var1, Node var2) {
      this.x = var2.x - var1.x;
      this.y = var2.y - var1.y;
   }

   Vector2(Point var1, Point var2) {
      this.x = var2.x - var1.x;
      this.y = var2.y - var1.y;
   }

   Vector2(Vertex2D var1, Vertex2D var2) {
      this.x = var2.x - var1.x;
      this.y = var2.y - var1.y;
   }

   Vector2(Point var1) {
      this.x = var1.x;
      this.y = var1.y;
   }

   Vector2() {
   }

   Vector2(double var1, double var3) {
      this.x = var1;
      this.y = var3;
   }

   Vector2(Vector3 var1) {
      this.x = var1.x;
      this.y = var1.y;
   }

   public Vector2 rotate(double var1) {
      if (var1 == 90.0) {
         return new Vector2(-this.y, this.x);
      } else if (var1 == 180.0) {
         return new Vector2(-this.x, -this.y);
      } else if (var1 == 270.0) {
         return new Vector2(this.y, -this.x);
      } else {
         double var3 = var1 * Math.PI / 180.0;
         double var5 = Math.cos(var3);
         double var7 = Math.sin(var3);
         return new Vector2(this.x * var5 - this.y * var7, this.x * var7 + this.y * var5);
      }
   }

   public static Vector2 interporate(Point var0, Point var1, double var2) {
      return new Vector2(var0.x * (1.0 - var2) + var1.x * var2, var0.y * (1.0 - var2) + var1.y * var2);
   }

   public static Vector2 interporate(Vertex2D var0, Vertex2D var1, double var2) {
      return new Vector2(var0.x * (1.0 - var2) + var1.x * var2, var0.y * (1.0 - var2) + var1.y * var2);
   }

   public Vector2 multiple(double var1) {
      return new Vector2(this.x * var1, this.y * var1);
   }

   public double get_relative_angle(Vector2 var1) {
      double var2 = this.cos(var1);
      if (var2 <= -1.0) {
         return Math.PI;
      } else {
         return var2 >= 1.0 ? 0.0 : Math.acos(this.cos(var1));
      }
   }

   public double get_angle(Vector2 var1) {
      double var2 = this.get_cos(var1);
      double var4 = this.get_sin(var1);
      if (var2 == 0.0) {
         return var4 > 0.0 ? 90.0 : 270.0;
      } else if (var4 == 0.0) {
         return var2 > 0.0 ? 0.0 : 180.0;
      } else {
         double var6 = 180.0 * Math.atan(var4 / var2) / Math.PI;
         if (var2 < 0.0) {
            var6 += 180.0;
         }

         if (var6 < 0.0) {
            var6 += 360.0;
         }

         return var6;
      }
   }

   public Point point() {
      return new Point((int)this.x, (int)this.y);
   }

   public static double distance(int var0, int var1, int var2, int var3) {
      return Math.sqrt((var2 - var0) * (var2 - var0) + (var3 - var1) * (var3 - var1));
   }
}
