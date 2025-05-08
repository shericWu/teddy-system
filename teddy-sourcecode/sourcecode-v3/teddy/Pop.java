package teddy;

import java.awt.Point;
import java.util.Enumeration;

class Pop extends Modify {
   private static int old_part_index;
   private static int new_part_index;

   public static void pop(LinkedList var0, Polyhedron var1) {
      if (Vector2.distance((Point)var0.head(), (Point)var0.tail()) < 10.0) {
         var1.temp_surface_lines = new LinkedList();
      } else {
         Teddy.teddy.play_sound("pop.au");
         var0 = Generate.normalize_Point_list(var0, Def.NORMALIZED_STROKE_LENGTH_POP);
         Modify.h = var1;
         LinkedList var3 = new LinkedList();
         Enumeration var4 = var0.elements();

         while (var4.hasMoreElements()) {
            Point var2 = (Point)var4.nextElement();
            var3.append(new Vertex2D(Draw3DScene.reverse_convertX(var2.x), Draw3DScene.reverse_convertY(var2.y)));
         }

         var3 = Generate.normalize_Vertex2D_list(var3);
         var3 = Generate.reduce_Vertex2D_list(var3, false);
         Modify.h.max_part_index++;
         new_part_index = Modify.h.max_part_index;
         old_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
         Modify.h.parent_of_a_part[new_part_index] = old_part_index;
         Modify.h.current_part_index = new_part_index;
         pop_main(var3);
      }
   }

   private static void construct(LinkedList var0) {
      if (!Modify.h.section_bumping) {
         Modify.section_is_sharp = true;
         Modify.h.current_part_index = old_part_index;
         divide_polygons_loop(Modify.h.temp_edge_vertex_list);
         Modify.h.current_part_index = new_part_index;
         Modify.delete_temp_polygons();
      } else {
         Modify.section_is_sharp = false;
         Enumeration var1 = Modify.h.temp_surface_lines.elements();

         while (var1.hasMoreElements()) {
            SurfaceLine var2 = (SurfaceLine)var1.nextElement();
            Modify.h.remove(var2.polygon);
         }

         var1 = Modify.h.temp_edge_vertex_list.elements();

         while (var1.hasMoreElements()) {
            Edge var7 = (Edge)((Objects)var1.nextElement()).get(0);
            var7.set_sharp(false);
         }
      }

      Enumeration var6 = var0.elements();
      Ring var8 = (Ring)var6.nextElement();

      while (var6.hasMoreElements()) {
         Object var3 = var6.nextElement();
         if (var3 instanceof Vertex) {
            construct_top(var8, (Vertex)var3);
            break;
         }

         Ring var4 = (Ring)var3;
         construct_sub(var8, var4);
         var8 = var4;
      }

      Modify.h.temp_surface_lines = new LinkedList();
   }

   private static void construct_top(Ring var0, Vertex var1) {
      Modify.h.append(var1);
      Enumeration var2 = var0.elements();
      Vertex var3 = (Vertex)var2.nextElement();

      while (var2.hasMoreElements()) {
         Vertex var4 = (Vertex)var2.nextElement();
         Modify.h.append_a_new_polygon(var3, var4, var1);
         var3 = var4;
      }
   }

   private static LinkedList generate_rings(Ring var0, Vertex var1, Vertex var2, LinkedList var3, Vector3 var4) {
      LinkedList var5 = new LinkedList();
      var5.append(var0);
      LinkedList var6 = var3.reverse();
      Enumeration var7 = var3.elements();
      Enumeration var8 = var6.elements();
      Vertex var9 = (Vertex)var7.nextElement();
      Vertex var10 = (Vertex)var7.nextElement();
      Vertex var11 = (Vertex)var7.nextElement();
      Vertex var12 = (Vertex)var8.nextElement();
      Vertex var13 = (Vertex)var8.nextElement();
      Vertex var14 = (Vertex)var8.nextElement();

      while (true) {
         Ring var15 = Ring.sweep(var0, var1, var2, var9, var12, var4);
         var5.append(var15);
         if (var10 == var13) {
            var5.append(var10);
            break;
         }

         if (var10 == var12) {
            var5.append(Vertex.mid_point(var9, var12));
            break;
         }

         Vector3 var16 = new Vector3(var9, var10).get_normalized();
         Vector3 var17 = new Vector3(var10, var11).get_normalized();
         Vector3 var18 = new Vector3(var12, var13).get_normalized();
         Vector3 var19 = new Vector3(var13, var14).get_normalized();
         var16.add(var19);
         var17.add(var18);
         var17.add(var19);
         Vector3 var20 = new Vector3(var9, var13);
         Vector3 var21 = new Vector3(var10, var12);
         Vector3 var22 = new Vector3(var10, var13);
         double var23 = Math.max(Math.abs(var20.cos(var16)), Math.abs(var20.cos(var19)));
         double var25 = Math.max(Math.abs(var21.cos(var17)), Math.abs(var21.cos(var18)));
         double var27 = Math.max(Math.abs(var22.cos(var17)), Math.abs(var22.cos(var19)));
         if (var23 <= var25 && var23 <= var27) {
            var12 = var13;
            var13 = var14;
            var14 = (Vertex)var8.nextElement();
            var9 = Vertex.mid_point(var9, var10);
         } else if (var25 <= var23 && var25 <= var27) {
            var9 = var10;
            var10 = var11;
            var11 = (Vertex)var7.nextElement();
            var12 = Vertex.mid_point(var12, var13);
         } else {
            var9 = var10;
            var10 = var11;
            var11 = (Vertex)var7.nextElement();
            var12 = var13;
            var13 = var14;
            var14 = (Vertex)var8.nextElement();
         }
      }

      Enumeration var29 = var5.elements();
      Ring var30 = (Ring)var29.nextElement();

      while (var29.hasMoreElements()) {
         Object var31 = var29.nextElement();
         if (var31 instanceof Vertex) {
            break;
         }

         Ring var32 = (Ring)var31;
         if (((Vertex)var30.head()).same_position((Vertex)var32.head())) {
            var32.replace_head(var30.head());
            var32.replace_tail(var30.head());
         }

         var30 = var32;
      }

      return var5;
   }

   protected static void divide_polygons_loop(LinkedList var0) {
      Modify.init(Modify.h);
      LinkedList var10 = new LinkedList();
      Enumeration var11 = var0.elements();
      Objects var3 = (Objects)var11.nextElement();
      var10.append((Vertex)var3.get(1));
      Polygon2 var12 = (Polygon2)var3.get(0);
      System.out.println("base " + var12);
      var3 = new Objects();

      while (var11.hasMoreElements()) {
         var3 = (Objects)var11.nextElement();
         var10.append((Vertex)var3.get(1));
         if (var3.get(0) instanceof Edge) {
            break;
         }
      }

      if (var11.hasMoreElements()) {
         Vertex var4 = (Vertex)var3.get(1);
         Edge var1 = (Edge)var3.get(0);
         Polygon2 var6 = var12;
         var12 = var1.get_another_polygon(var12);
         Modify.h.append(var4);
         LinkedList var14 = var10.reverse();
         Vertex var15 = var4;
         Edge var16 = var1;

         while (true) {
            var10 = new LinkedList();
            var10.append(var4);

            while (var11.hasMoreElements()) {
               var3 = (Objects)var11.nextElement();
               var10.append((Vertex)var3.get(1));
               if (var3.get(0) instanceof Edge) {
                  break;
               }
            }

            if (!var11.hasMoreElements()) {
               Modify.divide_knot_polygon(var12, var4, var1, var10, var15, var16, var14);
               return;
            }

            Vertex var5 = (Vertex)var3.get(1);
            Edge var2 = (Edge)var3.get(0);
            Polygon2 var7 = var2.get_another_polygon(var12);
            Edge var8 = var2;
            if (var7 == null) {
               var2 = Modify.find_corresponding_edge(var12, var2);
               var7 = var2.get_another_polygon(var12);
            }

            Edge var9 = var2;
            if (var7 == null) {
               var9 = var8;
               var7 = var8.get_another_polygon(null);
            }

            if (var1 == var2) {
               Modify.PolygonReplace var17 = Modify.polygon_replace_manager.replaced(var6);
               if (var17 != null) {
                  Edge var18 = Modify.find_corresponding_edge(var17.child0, var2);
                  Edge var19 = Modify.find_corresponding_edge(var17.child1, var2);
                  if (var18.on_edge(var5)) {
                     var9 = var18;
                     var7 = var17.child0;
                  } else {
                     var9 = var19;
                     var7 = var17.child1;
                  }
               }
            }

            if (!var12.contains(var2)) {
               var2 = Modify.polygon_replace_manager.get_corresponding_edge(var2, var5);
            }

            Modify.divide_a_polygon(var12, var10, var4, var1, var5, var2);
            var6 = var12;
            var4 = var5;
            var1 = var9;
            var12 = var7;
            Modify.h.append(var5);
         }
      }
   }

   private static void construct_sub(Ring var0, Ring var1) {
      Enumeration var2 = var1.elements();
      var2.nextElement();

      while (var2.hasMoreElements()) {
         Modify.h.append((Vertex)var2.nextElement());
      }

      Enumeration var3 = var0.elements();
      Enumeration var4 = var1.elements();
      Vertex var5 = (Vertex)var3.nextElement();
      Vertex var6 = (Vertex)var4.nextElement();
      if (var0.size() == var1.size()) {
         while (var3.hasMoreElements()) {
            Vertex var17 = (Vertex)var3.nextElement();
            Vertex var18 = (Vertex)var4.nextElement();
            if (var17.distance(var6) < var5.distance(var18)) {
               Modify.h.append_a_new_polygon(var5, var17, var6);
               Modify.h.append_a_new_polygon(var18, var6, var17);
            } else {
               Modify.h.append_a_new_polygon(var5, var17, var18);
               Modify.h.append_a_new_polygon(var18, var6, var5);
            }

            var5 = var17;
            var6 = var18;
         }
      } else {
         Vertex var7 = (Vertex)var3.nextElement();
         Vertex var8 = (Vertex)var4.nextElement();

         while (var3.hasMoreElements() || var4.hasMoreElements()) {
            Vector3 var9 = new Vector3(var6, var8);
            Vector3 var10 = new Vector3(var5, var7);
            Vector3 var11 = new Vector3(var5, var8);
            Vector3 var12 = new Vector3(var6, var7);
            double var13 = Math.min(Math.abs(var11.sin(var9)), Math.abs(var11.sin(var10)));
            double var15 = Math.min(Math.abs(var12.sin(var9)), Math.abs(var12.sin(var10)));
            if (!(var15 > var13) && var4.hasMoreElements()) {
               Modify.h.append_a_new_polygon(var8, var6, var5);
               var6 = var8;
               var8 = (Vertex)var4.nextElement();
            } else {
               Modify.h.append_a_new_polygon(var5, var7, var6);
               var5 = var7;
               var7 = (Vertex)var3.nextElement();
            }
         }

         Modify.h.append_a_new_polygon(var5, var7, var6);
         Modify.h.append_a_new_polygon(var8, var6, var7);
      }
   }

   public static void pop_main(LinkedList var0) {
      Vertex var1 = Draw3DScene.camera;
      Geometry.init(Modify.h, var1);
      Vector3 var2 = new Vector3(0.0, 0.0, 0.0);
      Enumeration var4 = Modify.h.temp_surface_lines.elements();
      Vector3 var5 = ((SurfaceLine)var4.nextElement()).vector3();

      while (var4.hasMoreElements()) {
         Vector3 var6 = ((SurfaceLine)var4.nextElement()).vector3();
         Vector3 var3 = var5.cross_product(var6);
         var2.add_self(var3);
         var5 = var6;
      }

      var2.normalize();
      Vertex var7 = new Vertex(0.0, 0.0, 0.0);
      var4 = Modify.h.temp_surface_lines.elements();

      while (var4.hasMoreElements()) {
         SurfaceLine var8 = (SurfaceLine)var4.nextElement();
         var7.add_self(var8.start);
      }

      var7.multiple_self(1.0 / Modify.h.temp_surface_lines.size());
      Modify.h.pivot_of_a_part[Modify.h.current_part_index] = var7;
      Modify.h.normal_of_a_part[Modify.h.current_part_index] = var2;
      Vector3 var34 = new Vector3(var1, var7);
      Vector3 var9 = var2.cross_product(var34);
      var4 = Modify.h.temp_surface_lines.elements();
      Vertex var10 = ((SurfaceLine)var4.nextElement()).start;
      Vector3 var11 = new Vector3(var7, var10);
      double var12 = var9.dot_product(var11);
      Vertex var14 = var10;
      Vertex var15 = var10;
      double var16 = var12;
      double var18 = var12;

      while (var4.hasMoreElements()) {
         var10 = ((SurfaceLine)var4.nextElement()).start;
         var11 = new Vector3(var7, var10);
         var12 = var9.dot_product(var11);
         if (var12 > var16) {
            var16 = var12;
            var14 = var10;
         }

         if (var12 < var18) {
            var18 = var12;
            var15 = var10;
         }
      }

      Surface var20 = new Surface(var7, var2.cross_product(var2.cross_product(var34)));
      LinkedList var21 = new LinkedList();
      var4 = var0.elements();

      while (var4.hasMoreElements()) {
         var10 = Draw3DScene.image_plane_to_world_coords((Vertex2D)var4.nextElement());
         var21.append(var20.cross_point(new Edge(var1, var10)));
      }

      System.out.println(var21.size());
      Ring var22 = new Ring(Modify.h.temp_edge_vertex_list);
      double var25 = Vector3.distance(var15, (Vertex)var21.head());
      double var27 = Vector3.distance(var15, (Vertex)var21.tail());
      Vertex var23;
      Vertex var24;
      if (var25 < var27) {
         var23 = var15;
         var24 = var14;
      } else {
         var23 = var14;
         var24 = var15;
      }

      Line var29 = new Line(var7, var2.cross_product(var34));
      var23 = var29.get_foot(var23);
      var24 = var29.get_foot(var24);
      LinkedList var30 = generate_rings(var22, var23, var24, var21, var2);
      construct(var30);
      Modify.remove_broken_polygons();
      Trianglation.trianglate(Modify.h);
      Tessellation.remove_thin_polygons(Modify.h);
      Modify.h.set_parameters();
   }
}
