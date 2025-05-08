package teddy;

import java.io.Serializable;

public class CoordSystem implements Serializable {
   public Vector3 base_x;
   public Vector3 base_y;
   public Vector3 base_z;

   CoordSystem(Vector3 var1, Vector3 var2, Vector3 var3) {
      this.base_x = var1;
      this.base_y = var2;
      this.base_z = var3;
   }

   public Vertex translate(Vertex var1) {
      double var2 = var1.dot_product(this.base_x);
      double var4 = var1.dot_product(this.base_y);
      double var6 = var1.dot_product(this.base_z);
      return new Vertex(var2, var4, var6);
   }

   public Vector3 translate(Vector3 var1) {
      double var2 = var1.dot_product(this.base_x);
      double var4 = var1.dot_product(this.base_y);
      double var6 = var1.dot_product(this.base_z);
      return new Vector3(var2, var4, var6);
   }

   public Vertex reverse_translate(Vertex var1) {
      Vector3 var2 = this.base_x.multiple(var1.x);
      Vector3 var3 = this.base_y.multiple(var1.y);
      Vector3 var4 = this.base_z.multiple(var1.z);
      return new Vertex(var2.add(var3).add(var4));
   }

   public Vertex reverse_translate(double var1, double var3, double var5) {
      Vector3 var7 = this.base_x.multiple(var1);
      Vector3 var8 = this.base_y.multiple(var3);
      Vector3 var9 = this.base_z.multiple(var5);
      return new Vertex(var7.add(var8).add(var9));
   }

   public Vector3 reverse_translate(Vector3 var1) {
      Vector3 var2 = this.base_x.multiple(var1.x);
      Vector3 var3 = this.base_y.multiple(var1.y);
      Vector3 var4 = this.base_z.multiple(var1.z);
      return var2.add(var3).add(var4);
   }
}
