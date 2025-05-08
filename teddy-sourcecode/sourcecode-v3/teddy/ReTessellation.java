package teddy;

import java.util.Enumeration;
import java.util.Vector;

class ReTessellation {
   private static Polyhedron h;

   private static Vertex get_gravity_center(LinkedList var0) {
      Vertex var1 = new Vertex();
      Enumeration var2 = var0.elements();

      while (var2.hasMoreElements()) {
         var1.add_self((Vertex)var2.nextElement());
      }

      return new Vertex(var1.multiple(1.0 / var0.size()));
   }

   public static Vertex to_sum_of_vectors(LinkedList var0, Vertex var1, double var2) {
      Vector3 var4 = new Vector3(0.0, 0.0, 0.0);
      double var5 = 0.0;
      Enumeration var7 = var0.elements();

      while (var7.hasMoreElements()) {
         Vertex var8 = (Vertex)var7.nextElement();
         Vector3 var9 = new Vector3(var1, var8);
         double var10 = 1.0 / var9.length();
         var4.add_self(var9.multiple(var10));
         var5 += var10;
      }

      var4.multiple_self(1.0 / var5);
      return new Vertex(var1.add(var4.multiple(var2)));
   }

   public static void smooth5(Polyhedron var0) {
      int var1 = 0;

      do {
         smooth_sub(var0, 0.63139836);
         smooth_sub(var0, -0.6739516);
      } while (++var1 < 5);
   }

   public static void smooth(Polyhedron var0) {
      smooth_sub(var0, 0.63139836);
      smooth_sub(var0, -0.6739516);
      var0.set_parameters();
   }

   public static void smooth(Vector var0) {
      int var1 = 0;

      do {
         smooth_sub(var0, 0.63139836);
         smooth_sub(var0, -0.6739516);
      } while (++var1 < 5);
   }

   public static Vertex to_the_center(LinkedList var0, Vertex var1, double var2) {
      Vertex var4 = get_gravity_center(var0);
      Vector3 var5 = new Vector3(var1, var4);
      return new Vertex(var1.add(var5.multiple(var2)));
   }

   public static void retessellate(Polyhedron var0) {
      Vertex[] var1 = new Vertex[var0.n_vertices];

      for (int var2 = 0; var2 < var0.n_vertices; var2++) {
         Vertex var3 = var0.vertices[var2];
         LinkedList var4 = var3.get_sorrounding_vertices();
         var1[var2] = horizontal_shift(var4, var3);
      }

      for (int var5 = 0; var5 < var0.n_vertices; var5++) {
         var0.vertices[var5].warp(var1[var5]);
      }

      var0.set_parameters();
   }

   public static void smooth_sub(Polyhedron var0, double var1) {
      Vertex[] var3 = new Vertex[var0.n_vertices];

      for (int var4 = 0; var4 < var0.n_vertices; var4++) {
         Vertex var5 = var0.vertices[var4];
         LinkedList var6 = var5.get_sorrounding_vertices();
         var3[var4] = to_sum_of_vectors(var6, var5, var1);
      }

      for (int var7 = 0; var7 < var0.n_vertices; var7++) {
         var0.vertices[var7].warp(var3[var7]);
      }
   }

   public static void smooth_sub(Vector var0, double var1) {
      Vertex[] var3 = new Vertex[var0.size()];

      for (int var4 = 0; var4 < var0.size(); var4++) {
         Vertex var5 = (Vertex)var0.elementAt(var4);
         LinkedList var6 = var5.get_sorrounding_vertices();
         var3[var4] = to_sum_of_vectors(var6, var5, var1);
      }

      for (int var7 = 0; var7 < var0.size(); var7++) {
         ((Vertex)var0.elementAt(var7)).warp(var3[var7]);
      }
   }

   private static Vector3 get_normal(LinkedList var0, Vertex var1) {
      LinkedList var2 = new LinkedList();
      Enumeration var3 = var0.elements();

      while (var3.hasMoreElements()) {
         var2.append(new Vector3((Vertex)var3.nextElement(), var1));
      }

      var3 = var2.elements();
      double var4 = 0.0;
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      double var12 = 0.0;
      double var14 = 0.0;

      while (var3.hasMoreElements()) {
         Vector3 var16 = (Vector3)var3.nextElement();
         var4 += var16.x * var16.y;
         var6 += var16.y * var16.z;
         var8 += var16.z * var16.x;
         var10 += var16.x * var16.x;
         var12 += var16.y * var16.y;
         var14 += var16.z * var16.z;
      }

      Vector3 var18 = new Vector3(var14 * var12 - var6 * var6, var4 * var6 - var4 * var14, var4 * var6 - var8 * var12);
      return var18.get_normalized();
   }

   private static Vector3 get_averaged_normal(LinkedList var0) {
      Vertex var1 = new Vertex();
      Enumeration var2 = var0.elements();

      while (var2.hasMoreElements()) {
         var1.add_self(((Polygon2)var2.nextElement()).normal);
      }

      Vector3 var3 = var1.multiple(1.0 / var0.size());
      return var3.get_normalized();
   }

   private static Vertex horizontal_shift(LinkedList var0, Vertex var1) {
      Vertex var2 = get_gravity_center(var0);
      Vector3 var3 = get_averaged_normal(var1.polygons());
      Vector3 var4 = new Vector3(var2, var1);
      Vertex var5 = new Vertex(var2.add(var3.multiple(var4.length())));
      Vector3 var6 = new Vector3(var1, var5);
      return new Vertex(var1.add(var6.multiple(0.5)));
   }
}
