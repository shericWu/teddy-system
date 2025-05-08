package teddy;

import java.util.Enumeration;
import java.util.Vector;

class Tessellation {
   private static Polyhedron h;

   private static void divide_an_edge(Edge var0, double var1) {
      double var3 = var0.length();
      int var5 = (int)(var3 / var1);
      Vector3 var6 = var0.vector3();
      LinkedList var8 = new LinkedList();

      for (int var9 = 1; var9 < var5; var9++) {
         Vertex var7 = var0.start.shift(var6.multiple((double)var9 / var5));
         var8.append(var7);
      }

      Enumeration var13 = var8.elements();
      Vertex var10 = var0.start;
      LinkedList var12 = new LinkedList();

      while (var13.hasMoreElements()) {
         Vertex var11 = (Vertex)var13.nextElement();
         var12.append(new Edge(var10, var11));
         var10 = var11;
      }

      var12.append(new Edge(var10, var0.end));
      h.append_vertices(var8);
      h.append_edges(var12);
      divide_an_edge_sub(var0.left_polygon(), var0, var0.start, var12, var0.end);
      divide_an_edge_sub(var0.right_polygon(), var0, var0.end, var12.reverse(), var0.start);
   }

   private static boolean no_big_distortion(Vertex var0, Vertex var1, Edge var2) {
      Enumeration var3 = var0.edges.elements();

      while (var3.hasMoreElements()) {
         Edge var4 = (Edge)var3.nextElement();
         if (var4 != var2) {
            Vertex var5 = var4.get_the_other_vertex(var0);
            Vector3 var6 = new Vector3(var5, var0);
            Vector3 var7 = new Vector3(var5, var1);
            double var8 = Math.abs(var6.sin(var7));
            double var10 = var6.cos(var7);
            if (var8 > 0.3 || var10 < 0.0) {
               return false;
            }
         }
      }

      return flip_over_test(var0, var1, var2) ? false : polygons_are_parallel_to_edge(var2, var0.polygons());
   }

   private static Polygon2 replaced_polygon(Polygon2 var0, LinkedList var1) {
      LinkedList var2 = new LinkedList();

      for (int var3 = 0; var3 < var0.n_edges; var3++) {
         Edge var4 = var0.edges[var3];
         var2.append(get_corresponding_edge(var4, var1));
      }

      return new Polygon2(var2);
   }

   private static Polygon2 divide_a_polygon_sub(Polygon2 var0, int var1, Edge var2, Vertex var3) {
      LinkedList var4 = new LinkedList();

      while (var0.get_vertex(var1) != var3) {
         var4.append(var0.edges(var1));
         var1++;
      }

      var4.append(var2);
      Polygon2 var5 = new Polygon2(var4);
      h.append(var5);
      return var5;
   }

   private static boolean flip_over_test(Vertex var0, Vertex var1, Edge var2) {
      Enumeration var3 = var0.polygons().elements();

      while (var3.hasMoreElements()) {
         Polygon2 var4 = (Polygon2)var3.nextElement();
         if (var4 != var2.left_polygon() && var4 != var2.right_polygon()) {
            Objects var5 = var4.get_the_other_edge(var0);
            Vector3 var6 = new Vector3(var1, (Vertex)var5.get(0));
            Vector3 var7 = new Vector3(var1, (Vertex)var5.get(1));
            if (var6.parallel(var7)) {
               System.out.println("Tessellation.flip");
               return true;
            }

            Vector3 var8 = new Vector3(var0, (Vertex)var5.get(0)).cross_product(new Vector3(var0, (Vertex)var5.get(1)));
            Vector3 var9 = var6.cross_product(var7);
            if (var8.cos(var9) < -0.8) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean polygons_are_parallel_to_edge(Edge var0, LinkedList var1) {
      Enumeration var2 = var1.elements();
      Vector3 var3 = var0.vector3();

      while (var2.hasMoreElements()) {
         Vector3 var4 = ((Polygon2)var2.nextElement()).get_normal_simple();
         double var5 = Math.abs(var4.cos(var3));
         if (var5 > 0.7) {
            return false;
         }
      }

      return true;
   }

   private static void remove_a_short_edge(Edge var0, Vertex var1, Vertex var2) {
      Polygon2 var3 = var0.left_polygon();
      Polygon2 var4 = var0.right_polygon();
      LinkedList var5 = var1.polygons().copy();
      Vertex var6 = var2;
      LinkedList var7 = new LinkedList();
      init_replacement(var7, var2);
      Enumeration var8 = var1.edges.elements();

      while (var8.hasMoreElements()) {
         Edge var9 = (Edge)var8.nextElement();
         if (var9 != var0) {
            Vertex var10 = var9.get_the_other_vertex(var1);
            register_replacement(var7, var9, var6, var10);
         }
      }

      h.remove(var3);
      h.remove(var4);
      var8 = var5.elements();

      while (var8.hasMoreElements()) {
         Polygon2 var12 = (Polygon2)var8.nextElement();
         if (var12 != var3 && var12 != var4) {
            h.remove(var12);
            h.current_part_index = var12.part_index;
            h.append(replaced_polygon(var12, var7));
         }
      }

      if (var3.n_edges > 3) {
         h.current_part_index = var3.part_index;
         h.append(replaced_polygon_special(var3, var7, var0));
      }

      if (var4.n_edges > 3) {
         h.current_part_index = var4.part_index;
         h.append(replaced_polygon_special(var4, var7, var0));
      }
   }

   private static void divide_an_edge_sub(Polygon2 var0, Edge var1, Vertex var2, LinkedList var3, Vertex var4) {
      LinkedList var5 = new LinkedList();
      var5.connect(var3);
      int var6 = 0;

      while (var0.edges(var6) != var1) {
         var6++;
      }

      var6++;

      while (var0.edges(var6) != var1) {
         var5.append(var0.edges(var6));
         var6++;
      }

      Polygon2 var7 = new Polygon2(var5);
      h.append(var7);
      h.remove(var0);
   }

   public static Vector remove_thin_polygons(Polyhedron var0) {
      Vector var1 = new Vector();
      h = var0;
      Edge var2 = null;

      for (int var3 = 0; var3 < h.n_edges; var3++) {
         h.edges[var3].checked = false;
      }

      for (int var5 = 0; var5 < h.n_edges; var5++) {
         if (!h.edges[var5].checked) {
            var2 = h.edges[var5];
            var2.mid_vertex();
            var2.checked = true;
            if (no_big_distortion(var2.start, var2.end, var2)) {
               remove_a_short_edge(var2, var2.start, var2.end);
               var1.addElement(new Objects(var2.start, var2.end));
               var5 = 0;
            } else if (no_big_distortion(var2.end, var2.start, var2)) {
               remove_a_short_edge(var2, var2.end, var2.start);
               var1.addElement(new Objects(var2.end, var2.start));
               var5 = 0;
            }
         }
      }

      return var1;
   }

   public static void tessellate_a_polygon(Polygon2 var0) {
      int var1 = var0.get_concave_vertex_index();
      if (var1 != -1) {
         tessellate_a_polygon(var0, var1);
      }
   }

   public static void adjust_polygon_size(Polyhedron var0, LinkedList var1, double var2) {
      h = var0;
      var2 *= 2.0;
      Enumeration var4 = var1.elements();

      while (var4.hasMoreElements()) {
         Edge var5 = (Edge)var4.nextElement();
         if (var5.length() > var2) {
            divide_an_edge(var5, var2);
         }
      }
   }

   private static void tessellate_a_polygon(Polygon2 var0, int var1) {
      h.current_part_index = var0.part_index;
      if (var0.n_edges == 3) {
         System.out.println("clashed polygon (Tessellation.tessellate)");
         Draw3DScene.current_polygon = var0;
      } else {
         Vertex var2 = var0.get_vertex(var1);
         Vertex var3 = var0.get_vertex(var1 - 1);
         Vertex var4 = var0.get_vertex(var1 + 1);
         Surface.get_normal_surface(var3, var2, var4);
         Vector3 var5 = new Vector3(var3, var2);
         Vector3 var6 = new Vector3(var2, var4);
         var5.normalize();
         var6.normalize();
         Vector3 var7 = var5.add(var6);
         Vector3 var8 = var0.normal.cross_product(var7);
         int var10 = var1 + 2;
         Vertex var11 = var0.get_vertex(var10);
         double var12 = var8.cos(new Vector3(var2, var11));

         for (int var9 = var1 + 3; var9 < var0.n_edges + var1 - 1; var9++) {
            Vertex var16 = var0.get_vertex(var9);
            new Vector3(var2, var16);
            double var14 = var8.cos(new Vector3(var2, var16));
            if (var12 < var14) {
               var12 = var14;
               var10 = var9;
            }
         }

         divide_a_polygon(var0, var1, var10);
      }
   }

   private static Edge get_corresponding_edge(Edge var0, LinkedList var1) {
      Enumeration var2 = var1.elements();

      while (var2.hasMoreElements()) {
         Objects var3 = (Objects)var2.nextElement();
         Edge var4 = (Edge)var3.get(0);
         if (var0 == var4) {
            return (Edge)var3.get(1);
         }
      }

      return var0;
   }

   public static void tessellate(Polyhedron var0) {
      h = var0;
      Polygon2 var1 = null;
      int var2 = h.n_polygons;
      Polygon2[] var3 = (Polygon2[])h.polygons.clone();

      for (int var5 = 0; var5 < var2; var5++) {
         var1 = var3[var5];
         int var4 = var1.get_concave_vertex_index();
         if (var4 != -1) {
            tessellate_a_polygon(var1, var4);
         }
      }
   }

   private static void init_replacement(LinkedList var0, Vertex var1) {
      Enumeration var2 = var1.edges.elements();

      while (var2.hasMoreElements()) {
         Edge var3 = (Edge)var2.nextElement();
         Objects var4 = new Objects(var3, var3);
         var0.append(var4);
      }
   }

   private static void register_replacement(LinkedList var0, Edge var1, Vertex var2, Vertex var3) {
      Enumeration var4 = var0.elements();

      while (var4.hasMoreElements()) {
         Objects var5 = (Objects)var4.nextElement();
         Edge var6 = (Edge)var5.get(1);
         if (var6.same_edge(var2, var3)) {
            Objects var7 = new Objects(var1, var6);
            var0.append(var7);
            if (var1.sharp) {
               var6.set_sharp(true);
            }

            return;
         }
      }

      Edge var8 = new Edge(var2, var3);
      h.append(var8);
      if (var1.sharp) {
         var8.set_sharp(true);
      }

      var0.append(new Objects(var1, var8));
   }

   private static Polygon2 replaced_polygon_special(Polygon2 var0, LinkedList var1, Edge var2) {
      LinkedList var3 = new LinkedList();

      for (int var4 = 0; var4 < var0.n_edges; var4++) {
         Edge var5 = var0.edges[var4];
         if (var5 != var2) {
            var3.append(get_corresponding_edge(var5, var1));
         }
      }

      return new Polygon2(var3);
   }

   private static void divide_a_polygon(Polygon2 var0, int var1, int var2) {
      Vertex var3 = var0.get_vertex(var1);
      Vertex var4 = var0.get_vertex(var2);
      Edge var5 = new Edge(var4, var3);
      Polygon2 var6 = divide_a_polygon_sub(var0, var1, var5, var4);
      Polygon2 var7 = divide_a_polygon_sub(var0, var2, var5, var3);
      h.append(var5);
      h.remove(var0);
      tessellate_a_polygon(var6);
      tessellate_a_polygon(var7);
   }
}
