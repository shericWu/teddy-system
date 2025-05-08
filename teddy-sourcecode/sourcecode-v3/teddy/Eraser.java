package teddy;

import java.awt.Point;
import java.util.Enumeration;

class Eraser extends Modify {
   private static boolean enclosed(LinkedList var0, Vertex var1) {
      Point var2 = Draw3DScene.project(var1);
      Enumeration var3 = var0.elements();
      Point var4 = (Point)var3.nextElement();

      while (var3.hasMoreElements()) {
         Point var5 = (Point)var3.nextElement();
         if (new Vector2(var4, var5).cross_product(new Vector2(var4, var2)) > 0.0) {
            return false;
         }

         var4 = var5;
      }

      return true;
   }

   public static void erase(LinkedList var0, Polyhedron var1) {
      Teddy.teddy.play_sound("smooth.au");
      Modify.init(var1);
      LinkedList var2 = new LinkedList();
      Enumeration var3 = Modify.h.surface_lines.elements();

      while (var3.hasMoreElements()) {
         SurfaceLine var4 = (SurfaceLine)var3.nextElement();
         if (!enclosed(var0, var4.start)) {
            var2.append(var4);
         }
      }

      Modify.h.surface_lines = var2;

      for (int var6 = 0; var6 < Modify.h.n_edges; var6++) {
         Edge var5 = Modify.h.edges[var6];
         if (var5.sharp && (var5.left_polygon.front_facing || var5.right_polygon.front_facing) && enclosed(var0, var5.start) && enclosed(var0, var5.end)) {
            var5.sharp = false;
         }
      }
   }
}
