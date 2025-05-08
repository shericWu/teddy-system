package teddy;

import java.awt.Point;

class Vertex2D extends Vector2 {
   public static Vertex2D mid_point(Vertex2D var0, Vertex2D var1) {
      return new Vertex2D((var0.x + var1.x) / 2.0, (var0.y + var1.y) / 2.0);
   }

   Vertex2D() {
   }

   Vertex2D(double var1, double var3) {
      super.x = var1;
      super.y = var3;
   }

   Vertex2D(Point var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   Vertex2D(Vector2 var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   Vertex2D(Vertex var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   public Vertex2D translate(Vector2 var1) {
      return new Vertex2D(super.x + var1.x, super.y + var1.y);
   }

   public Vertex2D copy() {
      return new Vertex2D(super.x, super.y);
   }

   public void warp(Vertex2D var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   public boolean same_position(Vertex2D var1) {
      return super.x == var1.x && super.y == var1.y;
   }
}
