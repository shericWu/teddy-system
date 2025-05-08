package teddy;

class Line2D {
   Vertex2D base;
   Vector2 direction;

   public static Vertex2D cross_point(Line2D var0, Line2D var1) {
      Vertex2D var2 = var0.base;
      Vector2 var3 = var0.direction;
      Vertex2D var4 = var1.base;
      Vector2 var5 = var1.direction;
      double var6 = var3.x;
      double var8 = -var5.x;
      double var10 = var3.y;
      double var12 = -var5.y;
      double var14 = var4.x - var2.x;
      double var16 = var4.y - var2.y;
      double var18 = var6 * var12 - var8 * var10;
      if (var18 == 0.0) {
         return null;
      } else {
         double var20 = var12 / var18;
         double var22 = -var8 / var18;
         double var24 = -var10 / var18;
         double var26 = var6 / var18;
         double var28 = var20 * var14 + var22 * var16;
         double var30 = var2.x + var3.x * var28;
         double var32 = var2.y + var3.y * var28;
         return new Vertex2D(var30, var32);
      }
   }

   Line2D(Vertex2D var1, Vector2 var2) {
      this.base = var1;
      this.direction = var2;
   }
}
