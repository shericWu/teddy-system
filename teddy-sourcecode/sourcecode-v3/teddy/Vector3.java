package teddy;

import java.io.Serializable;

public class Vector3 implements Serializable {
   public double x;
   public double y;
   public double z;

   public static double distance(Vertex var0, Vertex var1) {
      return distance(var0.x, var0.y, var0.z, var1.x, var1.y, var1.z);
   }

   public void normalize_self() {
      this.normalize();
   }

   public void normalize() {
      double var1 = this.length();
      this.x /= var1;
      this.y /= var1;
      this.z /= var1;
   }

   public double dot_product(Vector3 var1) {
      return this.x * var1.x + this.y * var1.y + this.z * var1.z;
   }

   public double sin(Vector3 var1) {
      double var2 = Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z) * (var1.x * var1.x + var1.y * var1.y + var1.z * var1.z));
      return var2 > 0.0 ? this.cross_product(var1).length() / var2 : 0.0;
   }

   public boolean parallel(Vector3 var1) {
      double var2 = this.sin(var1);
      return var2 < 0.01 && var2 > -0.01;
   }

   Vector3() {
   }

   Vector3(Vertex var1, Vertex var2) {
      this.x = var2.x - var1.x;
      this.y = var2.y - var1.y;
      this.z = var2.z - var1.z;
   }

   Vector3(double var1, double var3, double var5) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
   }

   public Vector3 add(Vector3 var1) {
      return new Vector3(this.x + var1.x, this.y + var1.y, this.z + var1.z);
   }

   public double get_cos(Vector3 var1) {
      return this.cos(var1);
   }

   public double get_sin(Vector3 var1) {
      return this.sin(var1);
   }

   public void rotate(int var1, double var2) {
      if (var1 == 0) {
         this.rotate_x(var2);
      } else if (var1 == 1) {
         this.rotate_y(var2);
      } else {
         this.rotate_z(var2);
      }
   }

   public static Vertex interporate(Vertex var0, Vertex var1, double var2) {
      return new Vertex(var0.x * (1.0 - var2) + var1.x * var2, var0.y * (1.0 - var2) + var1.y * var2, var0.z * (1.0 - var2) + var1.z * var2);
   }

   public void multiple_self(double var1) {
      this.x *= var1;
      this.y *= var1;
      this.z *= var1;
   }

   public void rotate_x(double var1) {
      Point2 var3 = this.rotate_sub(this.y, this.z, var1);
      this.y = var3.x;
      this.z = var3.y;
   }

   public Vector3 cross_product(Vector3 var1) {
      double var2 = this.y * var1.z - this.z * var1.y;
      double var4 = this.z * var1.x - this.x * var1.z;
      double var6 = this.x * var1.y - this.y * var1.x;
      return new Vector3(var2, var4, var6);
   }

   public Vector3 copyVector3() {
      return new Vector3(this.x, this.y, this.z);
   }

   public void rotate_y(double var1) {
      Point2 var3 = this.rotate_sub(this.z, this.x, var1);
      this.z = var3.x;
      this.x = var3.y;
   }

   public Vector3 reverse() {
      return new Vector3(-this.x, -this.y, -this.z);
   }

   public Vertex vertex() {
      return new Vertex(this.x, this.y, this.z);
   }

   public Vector3 multiple(double var1) {
      return new Vector3(this.x * var1, this.y * var1, this.z * var1);
   }

   public double get_relative_angle(Vector3 var1) {
      double var2 = this.cos(var1);
      if (var2 <= -1.0) {
         return Math.PI;
      } else {
         return var2 >= 1.0 ? 0.0 : Math.acos(this.cos(var1));
      }
   }

   public double get_angle(Vector3 var1, Vector3 var2) {
      double var3 = this.get_cos(var1);
      double var5 = this.get_sin(var1);
      if (this.cross_product(var1).dot_product(var2) < 0.0) {
         var5 *= -1.0;
      }

      if (var3 == 0.0) {
         return var5 > 0.0 ? 90.0 : 270.0;
      } else if (var5 == 0.0) {
         return var3 > 0.0 ? 0.0 : 180.0;
      } else {
         double var7 = 180.0 * Math.atan(var5 / var3) / Math.PI;
         if (var3 < 0.0) {
            var7 += 180.0;
         }

         if (var7 < 0.0) {
            var7 += 360.0;
         }

         return var7;
      }
   }

   public void add_self(Vector3 var1) {
      this.x = this.x + var1.x;
      this.y = this.y + var1.y;
      this.z = this.z + var1.z;
   }

   public void rotate_z(double var1) {
      Point2 var3 = this.rotate_sub(this.x, this.y, var1);
      this.x = var3.x;
      this.y = var3.y;
   }

   public Vector3 get_normalized() {
      double var1 = this.length();
      return new Vector3(this.x / var1, this.y / var1, this.z / var1);
   }

   public Point2 rotate_sub(double var1, double var3, double var5) {
      double var7 = Math.cos(Math.PI * var5 / 180.0);
      double var9 = Math.sin(Math.PI * var5 / 180.0);
      double var11 = var7 * var1 - var9 * var3;
      double var13 = var9 * var1 + var7 * var3;
      return new Point2(var11, var13);
   }

   public double length() {
      return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   public double cos(Vector3 var1) {
      double var2 = Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z) * (var1.x * var1.x + var1.y * var1.y + var1.z * var1.z));
      return var2 > 0.0 ? this.dot_product(var1) / var2 : 0.0;
   }

   public static double distance(double var0, double var2, double var4, double var6, double var8, double var10) {
      return Math.sqrt((var6 - var0) * (var6 - var0) + (var8 - var2) * (var8 - var2) + (var10 - var4) * (var10 - var4));
   }
}
