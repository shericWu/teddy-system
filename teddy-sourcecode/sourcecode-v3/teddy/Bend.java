package teddy;

import java.awt.Point;
import java.util.Enumeration;

class Bend {
   protected static Polyhedron h;

   public static void bend_main(LinkedList var0, LinkedList var1) {
      Edge2D[] var2 = stroke_to_edge2Ds(var0);
      Edge2D[] var3 = stroke_to_edge2Ds(var1);
      int var4 = var0.size();
      System.out.println("n" + var4);

      for (int var5 = 0; var5 < h.n_vertices; var5++) {
         Vertex var6 = h.vertices[var5];
         var6.warp(warp_for_edges(var4, var2, var3, var6));
      }

      Enumeration var7 = h.surface_lines.elements();

      while (var7.hasMoreElements()) {
         SurfaceLine var8 = (SurfaceLine)var7.nextElement();
         var8.start.warp(warp_for_edges(var4, var2, var3, var8.start));
         var8.end.warp(warp_for_edges(var4, var2, var3, var8.end));
      }

      h.set_parameters();
   }

   public static void bend(LinkedList var0, LinkedList var1, Polyhedron var2) {
      Teddy.teddy.play_sound("pop.au");
      var0 = Generate.renumber_Point_list(20, var0);
      var1 = Generate.renumber_Point_list(20, var1);
      h = var2;
      LinkedList var3 = stroke_to_vertex2D_list(var0);
      LinkedList var4 = stroke_to_vertex2D_list(var1);
      bend_main(var3, var4);
   }

   private static Edge2D[] stroke_to_edge2Ds(LinkedList var0) {
      int var1 = var0.size();
      Edge2D[] var2 = new Edge2D[var1];
      Vertex2D var3 = (Vertex2D)var0.nextElement();

      for (int var5 = 0; var5 < var1 - 1; var5++) {
         Vertex2D var4 = (Vertex2D)var0.nextElement();
         var2[var5] = new Edge2D(var3, var4);
         var3 = var4;
      }

      return var2;
   }

   public static Vector3 warp_for_edges(int var0, Edge2D[] var1, Edge2D[] var2, Vertex var3) {
      Vertex2D var4 = new Vertex2D(var3.x, var3.z);
      double[] var5 = new double[var0];
      double var6 = 0.0;
      Vector3 var8 = new Vector3(0.0, 0.0, 0.0);

      for (int var9 = 0; var9 < var0 - 1; var9++) {
         double var10 = var1[var9].distance_as_a_segment(var4);
         var5[var9] = 1.0 / (1.0E-4 + var10 * var10 * var10);
         var6 += var5[var9];
         Vertex var12 = warp_for_an_edge(var1[var9], var2[var9], var3);
         var8 = var8.add(var12.multiple(var5[var9]));
      }

      return var8.multiple(1.0 / var6);
   }

   public static LinkedList stroke_to_vertex2D_list(LinkedList var0) {
      LinkedList var2 = new LinkedList();
      Enumeration var3 = var0.elements();

      while (var3.hasMoreElements()) {
         Point var1 = (Point)var3.nextElement();
         var2.append(new Vertex2D(Draw3DScene.reverse_convertX(var1.x), Draw3DScene.reverse_convertY(var1.y)));
      }

      return var2;
   }

   public static Vertex warp_for_an_edge(Edge2D var0, Edge2D var1, Vertex var2) {
      Vertex2D var3 = new Vertex2D(var2.x, var2.z);
      Vector2 var4 = var0.vector2().get_normalized();
      Vector2 var5 = var4.rotate90().get_normalized();
      Vector2 var6 = var1.vector2().get_normalized();
      Vector2 var7 = var6.rotate90().get_normalized();
      Vector2 var8 = new Vector2(var0.start, var3);
      double var9 = var4.dot_product(var8) * (var1.length() / var0.length());
      double var11 = var5.dot_product(var8);
      Vector2 var13 = var6.multiple(var9).add(var7.multiple(var11));
      Vertex2D var14 = var1.start.translate(var13);
      return new Vertex(var14.x, var2.y, var14.y);
   }
}
