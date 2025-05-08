package teddy;

class Geometry2D {
   public static double get_radius(Vertex2D var0, Vertex2D var1, Vertex2D var2) {
      Vertex2D var3 = get_circumcenter(var0, var1, var2);
      return var3 == null ? Double.MAX_VALUE : Vector2.distance(var3, var0);
   }

   private static Line2D get_dividing_line(Vertex2D var0, Vertex2D var1) {
      Vertex2D var2 = Vertex2D.mid_point(var0, var1);
      double var3 = var1.x - var0.x;
      double var5 = var1.y - var0.y;
      Vector2 var7 = new Vector2(var5, -var3);
      return new Line2D(var2, var7);
   }

   public static boolean left_side(Vertex2D var0, Vertex2D var1, Vertex2D var2) {
      if (var0 != var2 && var1 != var2) {
         Vector2 var3 = new Vector2(var0, var1);
         Vector2 var4 = new Vector2(var0, var2);
         return var3.cross_product(var4) <= 0.0;
      } else {
         return true;
      }
   }

   public static boolean left_side(Vertex2D var0, Vertex2D var1, Vertex2D var2, Vertex2D var3) {
      Vector2 var4 = new Vector2(var1, var0);
      Vector2 var5 = new Vector2(var1, var2);
      Vector2 var6 = new Vector2(var1, var3);
      double var7 = 360.0 - var5.get_angle(var6);
      double var9 = 360.0 - var5.get_angle(var4);
      if (var7 == 360.0) {
         var7 = 0.0;
      }

      return var7 <= var9;
   }

   public static Vertex2D get_circumcenter(Vertex2D var0, Vertex2D var1, Vertex2D var2) {
      Line2D var3 = get_dividing_line(var0, var1);
      Line2D var4 = get_dividing_line(var0, var2);
      return Line2D.cross_point(var3, var4);
   }
}
