package teddy;

class SkEdge2D extends Edge2D {
   public static final int EXTERNAL = 0;
   public static final int INTERNAL = 1;
   public static final int INTERNAL_SHARED = 2;
   int type;
   SkPolygon2D right_polygon = null;
   SkPolygon2D left_polygon = null;
   public double height = -1.0;

   SkEdge2D(SkVertex2D var1, SkVertex2D var2, int var3) {
      super.start = var1;
      super.end = var2;
      var1.add_owner(this);
      var2.add_owner(this);
      this.type = var3;
   }

   public void set_left_polygon(SkPolygon2D var1) {
      this.left_polygon = var1;
   }

   public SkPolygon2D the_other_polygon(SkPolygon2D var1) {
      return this.left_polygon == var1 ? this.right_polygon : this.left_polygon;
   }

   public void set_height() {
      if (this.type == 2 && this.height == -1.0) {
         this.height = this.get_average_height(this.right_polygon, this.left_polygon);
      }
   }

   private double get_average_height(SkPolygon2D var1, SkPolygon2D var2) {
      Vertex2D var3 = this.mid_point();
      Object var5;
      if (var2.type == 2) {
         var5 = var2.center;
      } else if (var2.type == 1) {
         var5 = var2.the_other_internal_edge(this).mid_point();
      } else {
         var5 = var2.get_terminal_vertex();
      }

      Object var4;
      if (var1.type == 2) {
         var4 = var1.center;
      } else if (var1.type == 1) {
         var4 = var1.the_other_internal_edge(this).mid_point();
      } else {
         var4 = var1.get_terminal_vertex();
      }

      double var6 = Vector2.distance(var3, (Vertex2D)var4);
      double var8 = Vector2.distance(var3, (Vertex2D)var5);
      double var10 = var2.height;
      double var12 = var1.height;
      return (var10 * var6 + var12 * var8) / (var8 + var6);
   }

   public boolean out_of_circle(SkVertex2D var1) {
      Vector2 var2 = new Vector2(var1, super.start);
      Vector2 var3 = new Vector2(var1, super.end);
      return var2.get_cos(var3) >= 0.0;
   }

   public void set_right_polygon(SkPolygon2D var1) {
      this.right_polygon = var1;
   }
}
