package teddy;

class Trianglation {
   private static Polyhedron h;
   public static LinkedList triangles;
   public static LinkedList edges;
   public static Vector3 normal;

   public static void trianglate(Polyhedron var0) {
      h = var0;

      for (int var1 = 0; var1 < h.n_polygons; var1++) {
         while (h.polygons[var1].n_edges > 3) {
            trianglate(h, h.polygons[var1]);
         }
      }

      h.set_parameters();
   }

   public static void trianglate(Polyhedron var0, Polygon2 var1) {
      if (var1.n_edges != 3) {
         h = var0;
         normal = var1.calc_normal();
         int var2 = var1.n_edges;
         Vertex var3 = var1.get_vertex(0);
         Vertex var4 = var1.get_vertex(1);
         double var5 = 2.0;
         Vertex var7 = null;
         int var8 = -100;

         for (int var9 = 2; var9 < var2; var9++) {
            Vertex var10 = var1.get_vertex(var9);
            if (left_side(var3, var4, var10)) {
               double var11 = new Vector3(var10, var3).get_cos(new Vector3(var10, var4));
               if (var11 < var5) {
                  var5 = var11;
                  var7 = var10;
                  var8 = var9;
               }
            }
         }

         h.remove(var1);
         Polygon2 var17 = null;
         Polygon2 var12 = null;
         Edge var16;
         if (var8 > 2) {
            var16 = new Edge(var4, var7);
            h.append(var16);
            LinkedList var13 = new LinkedList();

            for (int var14 = 1; var14 < var8; var14++) {
               var13.append(var1.edges(var14));
            }

            var13.append(var16);
            var12 = new Polygon2(var13);
            h.append(var12);
         } else {
            var16 = var4.get_shared_edge(var7);
         }

         Edge var15;
         if (var8 < var2 - 1) {
            var15 = new Edge(var3, var7);
            h.append(var15);
            LinkedList var18 = new LinkedList();

            for (int var19 = var8; var19 < var2; var19++) {
               var18.append(var1.edges(var19));
            }

            var18.append(var15);
            var17 = new Polygon2(var18);
            h.append(var17);
         } else {
            var15 = var3.get_shared_edge(var7);
         }

         h.append(new Polygon2(var1.edges(0), var16, var15));
         if (var12 != null) {
            trianglate(h, var12);
         }

         if (var17 != null) {
            trianglate(h, var17);
         }
      }
   }

   public static boolean left_side(Vertex var0, Vertex var1, Vertex var2) {
      if (var0 != var2 && var1 != var2) {
         Vector3 var3 = new Vector3(var0, var1);
         Vector3 var4 = new Vector3(var0, var2);
         return var3.cross_product(var4).dot_product(normal) >= 0.0;
      } else {
         return true;
      }
   }
}
