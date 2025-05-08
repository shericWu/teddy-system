package teddy;

import java.awt.Point;
import java.util.Enumeration;

class Skeleton {
   public static LinkedList triangles;
   public static LinkedList edges;
   public static SkVertex2D[] vertices;
   public static int n_vertices;
   public static NewPolyhedron h;
   private static int steps = 4;
   private static double[] cos = new double[steps * 2 + 1];
   private static double[] sin = new double[steps * 2 + 1];

   private static void propagate(SkPolygon2D var0, SkEdge2D var1, TrimData var2, LinkedList var3) {
      SkPolygon2D var4 = var0;
      SkEdge2D var5 = var1;

      SkPolygon2D var6;
      while (true) {
         var4.mark();
         var6 = var5.the_other_polygon(var4);
         if (var6.type != 1) {
            break;
         }

         SkEdge2D var7 = var6.the_other_internal_edge(var5);
         if (!var2.terminals_are_within_this_circle(var7)) {
            break;
         }

         var2.append_terminal_edge(var6.get_external_edge());
         var5 = var7;
         var4 = var6;
      }

      if (var6.type == 2) {
         SkVertex2D var11 = var6.center;
         var6.setTrimData(var5, var2);
         propagate_junction(var6, var3);
      } else {
         SkVertex2D var8 = new SkVertex2D(var5.mid_point());
         var8.height = var5.height;
         Enumeration var9 = var2.terminal_edges.elements();

         while (var9.hasMoreElements()) {
            SkEdge2D var10 = (SkEdge2D)var9.nextElement();
            var3.append(new SkPolygon2D(var10, var8));
         }
      }
   }

   private static void create_polygons_square(
      NewPolyhedron var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23
   ) {
      for (int var53 = -steps; var53 < steps; var53++) {
         double var41 = cos[var53 + steps];
         double var45 = var21 * sin[var53 + steps];
         double var47 = var15 * sin[var53 + steps];
         double var43 = cos[var53 + 1 + steps];
         double var49 = var21 * sin[var53 + 1 + steps];
         double var51 = var15 * sin[var53 + 1 + steps];
         if (var53 == -steps) {
            var41 = 0.0;
            var45 = -var21;
            var47 = -var15;
         } else if (var53 == steps - 1) {
            var43 = 0.0;
            var49 = var21;
            var51 = var15;
         }

         double var25 = var19 + (var1 - var19) * var41;
         double var27 = var23 + (var5 - var23) * var41;
         double var29 = var13 + (var7 - var13) * var41;
         double var31 = var17 + (var11 - var17) * var41;
         double var33 = var13 + (var7 - var13) * var43;
         double var35 = var17 + (var11 - var17) * var43;
         double var37 = var19 + (var1 - var19) * var43;
         double var39 = var23 + (var5 - var23) * var43;
         if (var53 == -1) {
            var33 = var7;
            var35 = var11;
            var37 = var1;
            var39 = var5;
            var51 = 0.0;
         } else if (var53 == 0) {
            var25 = var1;
            var27 = var5;
            var29 = var7;
            var31 = var11;
            var47 = 0.0;
         }

         if (Vector2.distance(var25, var27, var33, var35) > Vector2.distance(var29, var31, var37, var39)) {
            var0.add_temp_polygon(var37, var49, var39, var33, var51, var35, var29, var47, var31);
            var0.add_temp_polygon(var37, var49, var39, var29, var47, var31, var25, var45, var27);
         } else {
            var0.add_temp_polygon(var37, var49, var39, var33, var51, var35, var25, var45, var27);
            var0.add_temp_polygon(var33, var51, var35, var29, var47, var31, var25, var45, var27);
         }
      }
   }

   private static void create_polygons_junction_prepare(Vertex[] var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      if (var3 > var9) {
         create_polygons_junction_prepare_sub(var0, var1, var3, var5, var7, var9, var11);
      } else {
         create_polygons_junction_prepare_sub(var0, var7, var9, var11, var1, var3, var5);
         Vertex[] var13 = new Vertex[steps + 1];

         for (int var14 = 0; var14 <= steps; var14++) {
            var13[var14] = var0[steps - var14];
         }

         for (int var15 = 0; var15 <= steps; var15++) {
            var0[var15] = var13[var15];
         }
      }
   }

   public static void create_T_triangle(LinkedList var0, LinkedList var1, SkVertex2D var2, SkVertex2D var3, SkVertex2D var4) {
      SkEdge2D var5 = new SkEdge2D(var2, var3, 0);
      var1.append(var5);
      SkEdge2D var6 = new SkEdge2D(var3, var4, 0);
      var1.append(var6);
      SkEdge2D var7 = get_edge(var1, var4, var2);
      var0.append(new SkPolygon2D(var5, var6, var7, 0));
   }

   private static void propagate_junction(SkPolygon2D var0, LinkedList var1) {
      SkEdge2D var2 = var0.get_longest_edge();
      TrimData var3 = new TrimData();
      boolean var4 = false;
      boolean var5 = false;

      for (int var6 = 0; var6 < var0.edges.size(); var6++) {
         SkEdge2D var7 = var0.get_edge(var6);
         if (var7 != var2) {
            TrimData var8 = var0.getTrimData(var6);
            if (var8 != null) {
               if (!var8.terminals_are_within_this_circle(var7)) {
                  var4 = true;
               } else {
                  var3.merge(var8);
               }
            } else {
               var5 = true;
            }
         }
      }

      if (var0.getTrimData(var2) != null) {
         var4 = true;
      }

      if (!var5) {
         if (!var4) {
            propagate(var0, var2, var3, var1);
         }
      }
   }

   private static SkEdge2D find_appropriate_edge(LinkedList var0, SkEdge2D var1, SkVertex2D var2) {
      Vector2 var3 = var1.vector2();
      if (var1.start != var2) {
         var3.multiple_self(-1.0);
      }

      SkEdge2D var4 = null;
      double var5 = 360.0;
      Enumeration var7 = var0.elements();

      while (var7.hasMoreElements()) {
         SkEdge2D var8 = (SkEdge2D)var7.nextElement();
         Vector2 var9 = var8.vector2();
         if (var8.start != var2) {
            var9.multiple_self(-1.0);
         }

         double var10 = var3.get_angle(var9);
         if (var10 < var5) {
            var5 = var10;
            var4 = var8;
         }
      }

      return var4;
   }

   public static SkEdge2D get_edge(LinkedList var0, SkVertex2D var1, SkVertex2D var2) {
      Enumeration var3 = var0.elements();

      while (var3.hasMoreElements()) {
         SkEdge2D var4 = (SkEdge2D)var3.nextElement();
         if (var4.equals(var1, var2)) {
            var1.add_owner(var4);
            var2.add_owner(var4);
            if (var4.type == 2) {
               System.out.println("edge shared by more than 2 polygons (SKeleton)");
            }

            var4.type = 2;
            return var4;
         }
      }

      SkEdge2D var5 = new SkEdge2D(var1, var2, 1);
      var0.append(var5);
      return var5;
   }

   private static void create_polygons_junction_simple_sub(
      NewPolyhedron var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      for (int var47 = 0; var47 < steps; var47++) {
         double var35 = cos[var47 + steps];
         double var39 = var15 + (var9 - var15) * sin[var47 + steps];
         double var41 = var15 + (var3 - var15) * sin[var47 + steps];
         double var37 = cos[var47 + 1 + steps];
         double var43 = var15 + (var9 - var15) * sin[var47 + 1 + steps];
         double var45 = var15 + (var3 - var15) * sin[var47 + 1 + steps];
         if (var47 == steps - 1) {
            var37 = 0.0;
            var43 = var9;
            var45 = var3;
         }

         double var19 = var7 + (var13 - var7) * var35;
         double var21 = var11 + (var17 - var11) * var35;
         double var23 = var1 + (var13 - var1) * var35;
         double var25 = var5 + (var17 - var5) * var35;
         double var27 = var1 + (var13 - var1) * var37;
         double var29 = var5 + (var17 - var5) * var37;
         double var31 = var7 + (var13 - var7) * var37;
         double var33 = var11 + (var17 - var11) * var37;
         if (var47 == 0) {
            var0.add_temp_polygon(var31, var43, var33, var27, var45, var29, var13, var15, var17);
         } else {
            var0.add_temp_polygon(var31, var43, var33, var27, var45, var29, var23, var41, var25);
            var0.add_temp_polygon(var31, var43, var33, var23, var41, var25, var19, var39, var21);
         }
      }
   }

   private static void propagate_junction_final(SkPolygon2D var0, LinkedList var1) {
      LinkedList var2 = new LinkedList();

      for (int var3 = 0; var3 < var0.edges.size(); var3++) {
         TrimData var4 = var0.getTrimData(var3);
         if (var4 != null) {
            var2.connect(var4.terminal_edges);
         }
      }

      SkVertex2D var6 = var0.center;
      Enumeration var7 = var2.elements();

      while (var7.hasMoreElements()) {
         SkEdge2D var5 = (SkEdge2D)var7.nextElement();
         var1.append(new SkPolygon2D(var5, var6));
      }
   }

   public static SkVertex2D get_vertex(int var0) {
      if (var0 >= n_vertices) {
         var0 -= var0 / n_vertices * n_vertices;
      }

      if (var0 < 0) {
         var0 += (-var0 / n_vertices + 1) * n_vertices;
      }

      return vertices[var0];
   }

   public static LinkedList get_skeleton_edges(LinkedList var0) {
      return new LinkedList();
   }

   private static void create_polygons_junction(
      NewPolyhedron var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23
   ) {
      double var25 = Vector2.distance(var13, var17, var19, var23);
      if (var25 < Vector2.distance(var13, var17, var1, var5)
         && var25 < Vector2.distance(var13, var17, var7, var11)
         && var25 < Vector2.distance(var19, var23, var1, var5)
         && var25 < Vector2.distance(var19, var23, var1, var5)) {
         create_polygons_junction_simple(var0, var13, var15, var17, var19, var21, var23, var1, var3, var5);
         create_polygons_junction_simple(var0, var19, var21, var23, var13, var15, var17, var7, var9, var11);
      } else {
         create_polygons_junction_complicated(var0, var13, var15, var17, var19, var21, var23, var1, var3, var5);
         create_polygons_junction_complicated(var0, var19, var21, var23, var13, var15, var17, var7, var9, var11);
      }
   }

   private static void create_polygons_junction_prepare_sub(Vertex[] var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      for (int var21 = 0; var21 <= steps; var21++) {
         double var17 = cos[var21 + steps];
         double var19 = sin[var21 + steps];
         double var13 = var1 + (var7 - var1) * var17;
         double var15 = var5 + (var11 - var5) * var17;
         var19 = var9 + (var3 - var9) * var19;
         if (var21 == 0) {
            var13 = var7;
            var15 = var11;
            var19 = var9;
         }

         if (var21 == steps) {
            var13 = var1;
            var15 = var5;
            var19 = var3;
         }

         var0[steps - var21] = new Vertex(var13, -var19, var15);
      }

      if (var3 > 0.0 && var9 > 0.0) {
         double var31 = var0[0].x;
         double var23 = (var0[steps].x - var0[0].x) / steps;
         double var25 = var0[0].z;
         double var27 = (var0[steps].z - var0[0].z) / steps;

         for (int var29 = 1; var29 <= steps - 1; var29++) {
            var0[var29].x = var31 + var23 * var29;
            var0[var29].z = var25 + var27 * var29;
         }
      }
   }

   private static void create_polygons_external(
      NewPolyhedron var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      if (var7 == var1 && var11 == var5) {
         System.out.println("clashed internal");
      }

      for (int var43 = -steps; var43 < steps; var43++) {
         double var35 = cos[var43 + steps];
         double var39 = var15 * sin[var43 + steps];
         double var37 = cos[var43 + 1 + steps];
         double var41 = var15 * sin[var43 + 1 + steps];
         double var19 = var13 + (var1 - var13) * var35;
         double var21 = var17 + (var5 - var17) * var35;
         double var23 = var13 + (var7 - var13) * var35;
         double var25 = var17 + (var11 - var17) * var35;
         double var27 = var13 + (var7 - var13) * var37;
         double var29 = var17 + (var11 - var17) * var37;
         double var31 = var13 + (var1 - var13) * var37;
         double var33 = var17 + (var5 - var17) * var37;
         if (var43 == -1) {
            var27 = var7;
            var29 = var11;
            var31 = var1;
            var33 = var5;
            var41 = 0.0;
         } else if (var43 == 0) {
            var19 = var1;
            var21 = var5;
            var23 = var7;
            var25 = var11;
            var39 = 0.0;
         }

         if (var43 == -steps) {
            var0.add_temp_polygon(var13, var39, var17, var31, var41, var33, var27, var41, var29);
         } else if (var43 == steps - 1) {
            var0.add_temp_polygon(var23, var39, var25, var19, var39, var21, var13, var41, var17);
         } else if (Vector2.distance(var19, var21, var27, var29) > Vector2.distance(var23, var25, var31, var33)) {
            var0.add_temp_polygon(var31, var41, var33, var27, var41, var29, var23, var39, var25);
            var0.add_temp_polygon(var31, var41, var33, var23, var39, var25, var19, var39, var21);
         } else {
            var0.add_temp_polygon(var31, var41, var33, var27, var41, var29, var19, var39, var21);
            var0.add_temp_polygon(var27, var41, var29, var23, var39, var25, var19, var39, var21);
         }
      }
   }

   private static void cos_sin_init() {
      for (int var0 = -steps; var0 <= steps; var0++) {
         cos[var0 + steps] = Math.cos(Math.PI * var0 / steps / 2.0);
         sin[var0 + steps] = Math.sin(Math.PI * var0 / steps / 2.0);
      }

      cos[0] = 0.0;
      sin[0] = -1.0;
      cos[steps] = 1.0;
      sin[steps] = 0.0;
      cos[steps * 2] = 0.0;
      sin[steps * 2] = 1.0;
   }

   private static void create_polygons_junction_complicated(
      NewPolyhedron var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      Vertex[] var19 = new Vertex[steps + 1];
      Vertex[] var20 = new Vertex[steps + 1];
      Vertex[] var21 = new Vertex[steps + 1];
      create_polygons_junction_prepare(var19, var7, var9, var11, var13, 0.0, var17);
      create_polygons_junction_prepare(var20, var1, var3, var5, var13, 0.0, var17);
      create_polygons_junction_prepare(var21, var1, var3, var5, var7, var9, var11);
      Vertex[] var22 = new Vertex[steps * 3 + 1];

      for (int var23 = 0; var23 < steps; var23++) {
         var22[var23] = var19[var23];
      }

      for (int var26 = 0; var26 < steps; var26++) {
         var22[steps + var26] = var20[steps - var26];
      }

      for (int var27 = 0; var27 <= steps; var27++) {
         var22[steps * 2 + var27] = var21[var27];
      }

      LinkedList var28 = delauny(var22);
      Enumeration var24 = var28.elements();

      while (var24.hasMoreElements()) {
         Vertex[] var25 = (Vertex[])var24.nextElement();
         create_polygons_junction_sub(var25[0], var25[1], var25[2]);
      }
   }

   private static LinkedList delauny(Vertex[] var0) {
      LinkedList var1 = new LinkedList();

      for (int var2 = 0; var2 < steps * 3; var2++) {
         Vertex[] var3 = new Vertex[]{var0[var2], var0[var2 + 1], delauny_sub(var0, var0[var2], var0[var2 + 1])};
         if ((var2 <= 0 || !var3[2].same_position(var0[var2 - 1])) && (var2 != 0 || !var3[2].same_position(var0[steps * 3 - 1]))) {
            var1.append(var3);
         }
      }

      if (var1.size() == 10) {
         return var1;
      } else {
         Enumeration var6 = var1.elements();
         Vertex[] var4 = new Vertex[3];

         while (var6.hasMoreElements()) {
            Vertex[] var7 = (Vertex[])var6.nextElement();
            Vertex var5 = var7[2];
            if (get_origin(var0, var5) == 1) {
               var4[0] = var7[0];
               break;
            }
         }

         while (var6.hasMoreElements()) {
            Vertex[] var8 = (Vertex[])var6.nextElement();
            Vertex var10 = var8[2];
            if (get_origin(var0, var10) == 2) {
               var4[1] = var8[0];
               break;
            }
         }

         while (var6.hasMoreElements()) {
            Vertex[] var9 = (Vertex[])var6.nextElement();
            Vertex var11 = var9[2];
            if (get_origin(var0, var11) == 0) {
               var4[2] = var9[0];
               var1.append(var4);
               break;
            }
         }

         return var1;
      }
   }

   private static int get_origin(Vertex[] var0, Vertex var1) {
      int var2 = 0;

      while (var0[var2] != var1) {
         var2++;
      }

      return var2 / steps;
   }

   private static void create_polygons_junction_sub(Vertex var0, Vertex var1, Vertex var2) {
      h.add_temp_polygon(var0.x, var0.y, var0.z, var1.x, var1.y, var1.z, var2.x, var2.y, var2.z);
      h.add_temp_polygon(var1.x, -var1.y, var1.z, var0.x, -var0.y, var0.z, var2.x, -var2.y, var2.z);
   }

   private static void create_polygons_junction_sub(Vertex var0, Vertex var1, Vertex var2, Vertex var3) {
      if (Vector3.distance(var0, var2) > Vector3.distance(var1, var3)) {
         Vertex var4 = var3;
         var3 = var2;
         var2 = var1;
         var1 = var0;
         var0 = var4;
      }

      h.add_temp_polygon(var0.x, var0.y, var0.z, var1.x, var1.y, var1.z, var2.x, var2.y, var2.z);
      h.add_temp_polygon(var0.x, var0.y, var0.z, var2.x, var2.y, var2.z, var3.x, var3.y, var3.z);
      h.add_temp_polygon(var1.x, -var1.y, var1.z, var0.x, -var0.y, var0.z, var2.x, -var2.y, var2.z);
      h.add_temp_polygon(var2.x, -var2.y, var2.z, var0.x, -var0.y, var0.z, var3.x, -var3.y, var3.z);
   }

   private static void create_polygons_junction_simple(
      NewPolyhedron var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      create_polygons_junction_simple_sub(var0, var1, var3, var5, var7, var9, var11, var13, 0.0, var17);
      create_polygons_junction_simple_sub(var0, var7, -var9, var11, var1, -var3, var5, var13, 0.0, var17);
   }

   public static void create_S_triangle(LinkedList var0, LinkedList var1, SkVertex2D var2, SkVertex2D var3, SkVertex2D var4) {
      SkEdge2D var5 = new SkEdge2D(var2, var3, 0);
      var1.append(var5);
      SkEdge2D var6 = get_edge(var1, var3, var4);
      SkEdge2D var7 = get_edge(var1, var4, var2);
      var0.append(new SkPolygon2D(var5, var6, var7, 1));
   }

   public static void remove_S_triangle(LinkedList var0, LinkedList var1, SkPolygon2D var2) {
      SkEdge2D var3 = var2.get_external_edge();
      remove_edge(var1, var3);
      LinkedList var4 = var2.get_internal_edges();
      ((SkEdge2D)var4.head()).type = 1;
      ((SkEdge2D)var4.tail()).type = 1;
   }

   public static void create_J_triangle(LinkedList var0, LinkedList var1, SkEdge2D var2) {
      LinkedList var3 = new LinkedList();
      SkEdge2D var4 = var2;
      Object var5 = null;

      while (true) {
         var4.type = 2;
         var3.append(var4);
         SkVertex2D var6 = (SkVertex2D)var4.start;
         if (var6 == var2.end) {
            System.out.println("J" + var3.size());
            var0.append(new SkPolygon2D(var3, 2));
            return;
         }

         LinkedList var7 = var6.get_not_shared_edges();
         if (var7.size() > 1) {
            var5 = find_appropriate_edge(var7, var4, var6);
         } else {
            var5 = (SkEdge2D)var7.head();
         }

         var4 = (SkEdge2D)var5;
      }
   }

   public static Polyhedron generate_polyhedron(LinkedList var0) {
      System.out.println("Skeleton start ------");
      DrawPanel.special_segments = new LinkedList();
      int var1 = var0.size();
      vertices = new SkVertex2D[var0.size()];
      int var2 = 0;
      Enumeration var3 = var0.elements();

      while (var3.hasMoreElements()) {
         vertices[var2++] = new SkVertex2D((Point)var3.nextElement());
      }

      vertices[var1 - 1] = vertices[0];
      n_vertices = var1 - 1;
      edges = new LinkedList();
      triangles = new LinkedList();

      for (int var4 = 0; var4 < var1 - 1; var4++) {
         SkVertex2D var5 = vertices[var4];
         SkVertex2D var6 = vertices[var4 + 1];
         double var7 = 1.0;
         SkVertex2D var11 = null;
         int var12 = -100;

         for (int var13 = 0; var13 < var1 - 1; var13++) {
            if (var13 != var4
               && var13 != var4 + 1
               && (var4 != var1 - 2 || var13 != 0)
               && Geometry2D.left_side(var5, var6, vertices[var13])
               && Geometry2D.left_side(get_vertex(var13 - 1), get_vertex(var13), get_vertex(var13 + 1), var5)
               && Geometry2D.left_side(get_vertex(var13 - 1), get_vertex(var13), get_vertex(var13 + 1), var6)) {
               double var9 = new Vector2(vertices[var13], var5).get_cos(new Vector2(vertices[var13], var6));
               if (var9 < var7) {
                  var7 = var9;
                  var11 = vertices[var13];
                  var12 = var13;
               }
            }
         }

         if (var12 != var4 + 2 && (var4 != var1 - 2 || var12 != 1) && (var4 != var1 - 3 || var12 != 0)) {
            if (var12 != var4 - 1 && (var4 != 0 || var12 != var1 - 2)) {
               create_S_triangle(triangles, edges, var5, var6, var11);
            }
         } else {
            create_T_triangle(triangles, edges, var5, var6, var11);
         }
      }

      var3 = edges.elements();

      while (var3.hasMoreElements()) {
         SkEdge2D var24 = (SkEdge2D)var3.nextElement();
         if (var24.type == 1) {
            create_J_triangle(triangles, edges, var24);
         }
      }

      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var25 = (SkPolygon2D)var3.nextElement();
         if (var25.type == 1) {
            LinkedList var28 = var25.get_internal_edges();
            double var36 = ((SkEdge2D)var28.head()).length();
            double var8 = ((SkEdge2D)var28.tail()).length();
            var25.height = (var36 + var8) / 4.0 * Def.GENERATE_HEIGHT;
         } else if (var25.type == 2) {
            SkEdge2D var29 = var25.get_longest_edge();
            var25.height = var29.length() / 2.0 * Def.GENERATE_HEIGHT;
         } else if (var25.type == 0) {
            SkEdge2D var30 = var25.get_internal_edge();
            LinkedList var37 = var25.get_external_edges();
            SkEdge2D var41 = (SkEdge2D)var37.head();
            SkEdge2D var44 = (SkEdge2D)var37.tail();
            Vertex2D var48 = var30.mid_point();
            double var10 = var41.distance(var48);
            double var54 = var44.distance(var48);
            var25.height = Math.min(var10, var54) * Def.GENERATE_HEIGHT;
         }
      }

      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var26 = (SkPolygon2D)var3.nextElement();
         Enumeration var31 = var26.edges.elements();

         while (var31.hasMoreElements()) {
            ((SkEdge2D)var31.nextElement()).set_height();
         }

         if (var26.type == 2) {
            if (var26.center_edge == null) {
               var26.center.height = var26.height;
            } else {
               var26.center.height = var26.center_edge.height;
            }
         }
      }

      LinkedList var27 = new LinkedList();
      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var32 = (SkPolygon2D)var3.nextElement();
         if (var32.type == 0) {
            propagate_terminal(var32, var27);
         }
      }

      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var33 = (SkPolygon2D)var3.nextElement();
         if (var33.type == 2 && !var33.marked) {
            propagate_junction_final(var33, var27);
         }
      }

      cos_sin_init();
      h = new NewPolyhedron();
      var3 = var27.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var34 = (SkPolygon2D)var3.nextElement();
         double var38 = reverse_convert(var34.center.height);
         Vertex2D var45 = reverse_convert(var34.center);
         Vertex2D var49 = reverse_convert(var34.get_vertex(0));
         Vertex2D var50 = reverse_convert(var34.get_vertex(1));
         create_polygons_external(h, var49.x, 0.0, var49.y, var50.x, 0.0, var50.y, var45.x, var38, var45.y);
      }

      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         SkPolygon2D var35 = (SkPolygon2D)var3.nextElement();
         if (!var35.marked && var35.type == 1) {
            SkEdge2D var40 = (SkEdge2D)var35.get_internal_edges().head();
            SkEdge2D var43 = (SkEdge2D)var35.get_internal_edges().tail();
            double var47 = reverse_convert(var40.height);
            double var52 = reverse_convert(var43.height);
            Vertex2D var56 = reverse_convert(var35.get_vertex(0));
            Vertex2D var58 = reverse_convert(var35.get_vertex(1));
            Vertex2D var59 = reverse_convert(var35.get_vertex(2));
            Vertex2D var15 = reverse_convert(var40.mid_point());
            Vertex2D var16 = reverse_convert(var43.mid_point());
            create_polygons_square(h, var56.x, 0.0, var56.y, var58.x, 0.0, var58.y, var15.x, var47, var15.y, var16.x, var52, var16.y);
            create_polygons_internal(h, var16.x, var52, var16.y, var15.x, var47, var15.y, var59.x, 0.0, var59.y);
         } else if (!var35.marked && var35.type == 2) {
            SkVertex2D var39 = var35.center;
            Vertex2D var42 = reverse_convert(var39);
            double var46 = reverse_convert(var39.height);

            for (int var51 = 0; var51 < var35.edges.size(); var51++) {
               if (var35.trimData[var51] == null && var35.get_edge(var51) != var35.center_edge) {
                  Vertex2D var53 = reverse_convert(var35.get_vertex(var51));
                  Vertex2D var55 = reverse_convert(var35.get_vertex(var51 + 1));
                  Vertex2D var57 = reverse_convert(var35.get_edge(var51).mid_point());
                  double var14 = reverse_convert(var35.get_edge(var51).height);
                  create_polygons_junction(h, var53.x, 0.0, var53.y, var55.x, 0.0, var55.y, var57.x, var14, var57.y, var42.x, var46, var42.y);
               }
            }
         }
      }

      h.postprocess_main();
      Tessellation.remove_thin_polygons(h);
      ReTessellation.smooth5(h);
      h.set_parameters();
      return h;
   }

   public static void remove_edge(LinkedList var0, SkEdge2D var1) {
      ((SkVertex2D)var1.start).remove_owner(var1);
      ((SkVertex2D)var1.end).remove_owner(var1);
      var0.remove(var1);
   }

   private static Vertex delauny_sub(Vertex[] var0, Vertex var1, Vertex var2) {
      Vertex2D var3 = new Vertex2D(var1.x, var1.z);
      Vertex2D var4 = new Vertex2D(var2.x, var2.z);
      int var5 = steps * 3 + 1;
      double var6 = 1.0;
      Vertex var10 = null;
      byte var11 = -100;

      for (int var12 = 0; var12 < var5 - 1; var12++) {
         if (var0[var12] != var1 && var0[var12] != var2) {
            Vertex2D var13 = new Vertex2D(var0[var12].x, var0[var12].z);
            if (!Geometry2D.left_side(var3, var4, var13)) {
               double var8 = new Vector2(var13, var3).get_cos(new Vector2(var13, var4));
               if (var8 < var6) {
                  var6 = var8;
                  var10 = var0[var12];
               }
            }
         }
      }

      return var10;
   }

   private static void create_polygons_internal(
      NewPolyhedron var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      if (var1 == var7 && var5 == var11 && var3 == var9) {
         System.out.println("clashed internal");
      }

      for (int var47 = -steps; var47 < steps; var47++) {
         double var35 = cos[var47 + steps];
         double var39 = var9 * sin[var47 + steps];
         double var41 = var3 * sin[var47 + steps];
         double var37 = cos[var47 + 1 + steps];
         double var43 = var9 * sin[var47 + 1 + steps];
         double var45 = var3 * sin[var47 + 1 + steps];
         if (var47 == -steps) {
            var35 = 0.0;
            var39 = -var9;
            var41 = -var3;
         } else if (var47 == steps - 1) {
            var37 = 0.0;
            var43 = var9;
            var45 = var3;
         }

         double var19 = var7 + (var13 - var7) * var35;
         double var21 = var11 + (var17 - var11) * var35;
         double var23 = var1 + (var13 - var1) * var35;
         double var25 = var5 + (var17 - var5) * var35;
         double var27 = var1 + (var13 - var1) * var37;
         double var29 = var5 + (var17 - var5) * var37;
         double var31 = var7 + (var13 - var7) * var37;
         double var33 = var11 + (var17 - var11) * var37;
         if (var47 == -1) {
            var0.add_temp_polygon(var13, 0.0, var17, var23, var41, var25, var19, var39, var21);
         } else if (var47 == 0) {
            var0.add_temp_polygon(var31, var43, var33, var27, var45, var29, var13, 0.0, var17);
         } else if (Vector2.distance(var19, var21, var27, var29) > Vector2.distance(var23, var25, var31, var33)) {
            var0.add_temp_polygon(var31, var43, var33, var27, var45, var29, var23, var41, var25);
            var0.add_temp_polygon(var31, var43, var33, var23, var41, var25, var19, var39, var21);
         } else {
            var0.add_temp_polygon(var31, var43, var33, var27, var45, var29, var19, var39, var21);
            var0.add_temp_polygon(var27, var45, var29, var23, var41, var25, var19, var39, var21);
         }
      }
   }

   private static void propagate_terminal(SkPolygon2D var0, LinkedList var1) {
      SkVertex2D var2 = var0.get_terminal_vertex();
      LinkedList var3 = var0.get_external_edges();
      SkEdge2D var4 = var0.get_internal_edge();
      TrimData var5 = new TrimData(var2, var3);
      propagate(var0, var4, var5, var1);
   }

   public static Vertex2D reverse_convert(Vertex2D var0) {
      return new Vertex2D(Draw3DScene.reverse_convertX(var0.x), Draw3DScene.reverse_convertY(var0.y));
   }

   public static double reverse_convert(double var0) {
      return Draw3DScene.reverse_convertZ(var0);
   }
}
