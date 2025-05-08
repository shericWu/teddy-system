package teddy;

import java.awt.Point;
import java.util.Enumeration;
import java.util.Vector;

class Cutting extends Modify {
   private static LinkedList get_edge_vertices(LinkedList var0) {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = var0.elements();

      while (var2.hasMoreElements()) {
         Objects var3 = (Objects)var2.nextElement();
         if (var3.get(0) instanceof Edge) {
            var1.append((Vertex)var3.get(1));
         }
      }

      return var1;
   }

   private static void generate_temp_edge_vertex_list(LinkedList var0, LinkedList var1, LinkedList var2, LinkedList var3, Vector var4) {
      Modify.h.temp_edge_vertex_list = new LinkedList();
      generate_temp_edge_vertex_list(var0, var4);
      generate_temp_edge_vertex_list(var1, var4);
      generate_temp_edge_vertex_list(var2, var4);
      generate_temp_edge_vertex_list(var3, var4);
      Modify.h.temp_edge_vertex_list.append(Modify.h.temp_edge_vertex_list.head());
   }

   private static void generate_temp_edge_vertex_list(LinkedList var0, Vector var1) {
      Enumeration var2 = var0.elements();
      Vertex var3 = find_corresponding_vertex((Vertex)((Objects)var2.nextElement()).get(1), var1);

      while (var2.hasMoreElements()) {
         Vertex var4 = find_corresponding_vertex((Vertex)((Objects)var2.nextElement()).get(1), var1);
         if (var3 != var4) {
            Edge var5 = var3.get_shared_edge(var4);
            if (var5 == null) {
               System.out.println("Cutting, OOOOOOOPS");
            }

            Modify.h.temp_edge_vertex_list.append(new Objects(var5, var3));
         }

         var3 = var4;
      }
   }

   private static Objects divide_polygons(LinkedList var0) {
      LinkedList var10 = new LinkedList();
      Enumeration var11 = var0.elements();
      Objects var3 = (Objects)var11.nextElement();
      Vertex var12 = (Vertex)var3.get(1);
      var10.append(var12);
      Polygon2 var13 = (Polygon2)var3.get(0);
      var3 = new Objects();

      while (var11.hasMoreElements()) {
         var3 = (Objects)var11.nextElement();
         var10.append((Vertex)var3.get(1));
         if (var3.get(0) instanceof Edge) {
            break;
         }
      }

      if (!var11.hasMoreElements()) {
         return new Objects(null, null, var10, null, null, null);
      } else {
         Vertex var4 = (Vertex)var3.get(1);
         Edge var1 = (Edge)var3.get(0);
         Polygon2 var6 = var13;
         System.out.println("divide polygons--");
         Modify.PolygonReplace var14 = Modify.polygon_replace_manager.replaced(var13);
         if (var14 != null) {
            var6 = Modify.polygon_replace_manager.get_corresponding_polygon(var14, var12);
            var1 = Modify.find_corresponding_edge(var6, var1);
         }

         var13 = var1.get_another_polygon(var6);
         if (var13 == null) {
            var1 = Modify.polygon_replace_manager.get_corresponding_edge(var1, var4);
            var13 = var1.get_another_polygon(null);
            if (var13 == var6) {
               System.out.println("from divided to not-divied (Cutting.divide_polygons)");
               var1 = (Edge)var3.get(0);
               var13 = var1.get_another_polygon(null);
            }
         }

         Modify.h.append(var4);
         LinkedList var15 = var10.reverse();
         Vertex var16 = var4;
         Edge var17 = var1;

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
               return new Objects(var16, var17, var15, var4, var1, var10);
            }

            Vertex var5 = (Vertex)var3.get(1);
            Edge var2 = (Edge)var3.get(0);
            Polygon2 var7 = var2.get_another_polygon(var13);
            Edge var8 = var2;
            if (var7 == null) {
               var2 = Modify.find_corresponding_edge(var13, var2);
               var7 = var2.get_another_polygon(var13);
            }

            Edge var9 = var2;
            if (var7 == null) {
               var9 = var8;
               var7 = var8.get_another_polygon(null);
               System.out.println("into polygon not divided");
            }

            if (var1 == var2) {
               Modify.PolygonReplace var18 = Modify.polygon_replace_manager.replaced(var6);
               if (var18 != null) {
                  Edge var19 = Modify.find_corresponding_edge(var18.child0, var2);
                  Edge var20 = Modify.find_corresponding_edge(var18.child1, var2);
                  if (var19.on_edge(var5)) {
                     var9 = var19;
                     var7 = var18.child0;
                  } else {
                     var9 = var20;
                     var7 = var18.child1;
                  }

                  System.out.println("U turn");
               }
            }

            if (!var13.contains(var2)) {
               var2 = Modify.polygon_replace_manager.get_corresponding_edge(var2, var5);
            }

            Modify.divide_a_polygon(var13, var10, var4, var1, var5, var2);
            var6 = var13;
            var4 = var5;
            var1 = var9;
            var13 = var7;
            Modify.h.append(var5);
         }
      }
   }

   private static void draw_surface_lines(LinkedList var0, Polygon2 var1, Vertex var2) {
      Enumeration var6 = var0.elements();
      var6.nextElement();

      while (var6.hasMoreElements()) {
         Objects var4 = (Objects)var6.nextElement();
         Vertex var5 = (Vertex)var4.get(1);
         Modify.h.temp_surface_lines.append(new SurfaceLine(var2.copy(), var5.copy(), var1));
         if (var4.get(0) instanceof Edge) {
            Edge var3 = (Edge)var4.get(0);
            var1 = var3.get_another_polygon(var1);
         }

         var2 = var5.copy();
      }
   }

   private static double get_average_length(LinkedList var0, LinkedList var1, LinkedList var2, LinkedList var3) {
      double var4 = 0.0;
      var4 += get_average_length_sub(var0);
      var4 += get_average_length_sub(var1);
      var4 += get_average_length_sub(var2);
      var4 += get_average_length_sub(var3);
      return var4 / (var0.size() + var1.size() + var2.size() + var3.size());
   }

   private static void generate_section_surface(LinkedList var0, LinkedList var1) {
      LinkedList var2 = new LinkedList();
      Enumeration var4 = var0.elements();
      Objects var5 = (Objects)var4.nextElement();
      Vertex var6 = (Vertex)var5.get(1);
      Vertex var7 = var6;

      while (var4.hasMoreElements()) {
         var5 = (Objects)var4.nextElement();
         Vertex var8 = (Vertex)var5.get(1);
         Edge var3 = Modify.h.get_edge_array(var6, var8);
         var2.append(var3);
         var6 = var8;
      }

      Edge var10 = Modify.h.get_edge_array(var6, var7);
      var2.append(var10);
      Polygon2 var9 = new Polygon2(var2);
      Modify.h.append(var9);
      var1.append(var10);
   }

   private static void generate_section_surface(LinkedList var0, LinkedList var1, LinkedList var2) {
      Enumeration var3 = var0.elements();
      Enumeration var4 = var1.elements();
      Vertex var10 = null;
      Objects var8 = (Objects)var3.nextElement();
      Vertex var11 = (Vertex)var8.get(1);
      var8 = (Objects)var4.nextElement();
      Vertex var13 = (Vertex)var8.get(1);

      while (var3.hasMoreElements()) {
         Vertex var9 = var11;

         LinkedList var6;
         for (var6 = new LinkedList(); var3.hasMoreElements(); var9 = var10) {
            var8 = (Objects)var3.nextElement();
            var10 = (Vertex)var8.get(1);
            var6.append(Modify.h.get_edge_array(var9, var10));
            if (var8.get(0) instanceof Polygon2) {
               break;
            }
         }

         Vertex var12 = var10;
         var9 = var13;

         LinkedList var7;
         for (var7 = new LinkedList(); var4.hasMoreElements(); var9 = var10) {
            var8 = (Objects)var4.nextElement();
            var10 = (Vertex)var8.get(1);
            var7.append(Modify.h.get_edge_array(var9, var10));
            if (var8.get(0) instanceof Polygon2) {
               break;
            }
         }

         Edge var15 = Modify.h.get_edge_array(var13, var11);
         Edge var16 = Modify.h.get_edge_array(var12, var10);
         LinkedList var5 = new LinkedList();
         var5.append(var15);
         var5.connect(var6);
         var5.append(var16);
         var5.connect(var7.reverse());
         Modify.h.append(new Polygon2(var5));
         var11 = var12;
         var13 = var10;
         var2.append(var15);
      }
   }

   private static void generate_section_surface(Vertex var0, Vertex var1, Vertex var2, Vertex var3) {
      LinkedList var4 = new LinkedList();
      var4.append(Modify.h.get_edge_array(var0, var1));
      var4.append(Modify.h.get_edge_array(var1, var2));
      var4.append(Modify.h.get_edge_array(var2, var3));
      var4.append(Modify.h.get_edge_array(var3, var0));
      Modify.h.append(new Polygon2(var4));
   }

   private static void generate_section_surface(Vertex var0, Vertex var1, Vertex var2) {
      LinkedList var3 = new LinkedList();
      var3.append(Modify.h.get_edge_array(var0, var1));
      var3.append(Modify.h.get_edge_array(var1, var2));
      var3.append(Modify.h.get_edge_array(var2, var0));
      Modify.h.append(new Polygon2(var3));
   }

   public static boolean cut_main(LinkedList var0, boolean var1) {
      Vertex var2 = Draw3DScene.camera;
      Geometry.init(Modify.h, var2);
      LinkedList var19 = new LinkedList();
      LinkedList var20 = new LinkedList();
      Enumeration var22 = var0.elements();
      Vertex2D var3 = (Vertex2D)var22.nextElement();
      if (Geometry.find_vertex_on_surface(var3, true) != null) {
         return false;
      } else {
         while (var22.hasMoreElements()) {
            Vertex2D var4 = (Vertex2D)var22.nextElement();
            Objects var21 = Geometry.find_vertex_on_surface(var4, true);
            if (var21 != null) {
               Vertex2D var7 = var3;
               Polygon2 var15 = (Polygon2)var21.get(0);
               Vertex var11 = (Vertex)var21.get(1);
               var19.append(var21);
               Objects var23 = cut_sub(var19, var22, var15, var4, var11, true);
               Polygon2 var6 = (Polygon2)var23.get(0);
               Vertex var5 = (Vertex)var23.get(1);
               var3 = (Vertex2D)var23.get(2);
               var4 = (Vertex2D)var23.get(3);
               var22 = var0.elements();

               while (var7 != (Vertex2D)var22.nextElement()) {
               }

               var4 = (Vertex2D)var22.nextElement();
               var21 = Geometry.find_vertex_on_surface(var4, false);
               Polygon2 var16 = (Polygon2)var21.get(0);
               Vertex var12 = (Vertex)var21.get(1);
               var20.append(var21);
               var23 = cut_sub(var20, var22, var16, var4, var12, false);
               var6 = (Polygon2)var23.get(0);
               var5 = (Vertex)var23.get(1);
               var3 = (Vertex2D)var23.get(2);
               var4 = (Vertex2D)var23.get(3);
               if (var4 == var4 && var3 == var3) {
                  LinkedList var24 = new LinkedList();
                  LinkedList var25 = new LinkedList();
                  var24.append(new Objects(var15, var11));
                  var24.connect(Geometry.surface_path(var4, var7, var11, var12, var15, var16));
                  var24.append(new Objects(var16, var12));
                  var25.append(new Objects(var6, var5));
                  var25.connect(Geometry.surface_path(var3, var4, var5, var5, var6, var6));
                  var25.append(new Objects(var6, var5));
                  if (var1) {
                     draw_surface_lines(var19, var15, var11);
                     draw_surface_lines(var20, var16, var12);
                     draw_surface_lines(var24, var15, var11.copy());
                     draw_surface_lines(var25, var6, var5.copy());
                     Modify.h.surface_lines.connect(Modify.h.temp_surface_lines);
                     Modify.h.temp_surface_lines = new LinkedList();
                     return false;
                  }

                  Modify.h.current_part_index = var15.part_index;
                  Modify.section_is_sharp = true;
                  Objects var26 = divide_polygons(var19);
                  Objects var27 = divide_polygons(var20.reverse());
                  Objects var28 = divide_polygons(var24.reverse());
                  Objects var29 = divide_polygons(var25);
                  if (var26.get(0) != null) {
                     Modify.divide_knot_polygon(
                        var15,
                        (Vertex)var28.get(3),
                        (Edge)var28.get(4),
                        (LinkedList)var28.get(5),
                        (Vertex)var26.get(0),
                        (Edge)var26.get(1),
                        (LinkedList)var26.get(2)
                     );
                     Modify.divide_knot_polygon(
                        var6,
                        (Vertex)var26.get(3),
                        (Edge)var26.get(4),
                        (LinkedList)var26.get(5),
                        (Vertex)var29.get(0),
                        (Edge)var29.get(1),
                        (LinkedList)var29.get(2)
                     );
                  } else {
                     LinkedList var30 = (LinkedList)var28.get(5);
                     var30.connect(((LinkedList)var26.get(2)).cdr());
                     Modify.divide_knot_polygon(
                        var15, (Vertex)var28.get(3), (Edge)var28.get(4), var30, (Vertex)var29.get(0), (Edge)var29.get(1), (LinkedList)var29.get(2)
                     );
                  }

                  if (var27.get(0) != null) {
                     Modify.divide_knot_polygon(
                        var16,
                        (Vertex)var27.get(3),
                        (Edge)var27.get(4),
                        (LinkedList)var27.get(5),
                        (Vertex)var28.get(0),
                        (Edge)var28.get(1),
                        (LinkedList)var28.get(2)
                     );
                     Modify.divide_knot_polygon(
                        var6,
                        (Vertex)var29.get(3),
                        (Edge)var29.get(4),
                        (LinkedList)var29.get(5),
                        (Vertex)var27.get(0),
                        (Edge)var27.get(1),
                        (LinkedList)var27.get(2)
                     );
                  } else {
                     LinkedList var43 = (LinkedList)var29.get(5);
                     var43.connect(((LinkedList)var27.get(2)).cdr());
                     Modify.divide_knot_polygon(
                        var6,
                        (Vertex)var29.get(3),
                        (Edge)var29.get(4),
                        (LinkedList)var29.get(5),
                        (Vertex)var28.get(0),
                        (Edge)var28.get(1),
                        (LinkedList)var28.get(2)
                     );
                  }

                  Modify.delete_temp_polygons();
                  LinkedList var44 = new LinkedList();
                  generate_section_surface(var24.reverse(), var44);
                  var44 = new LinkedList();
                  generate_section_surface(var25, var44);
                  generate_section_surface(var19, var20, var44);
                  Modify.remove_broken_polygons();
                  double var31 = get_average_length(var24, var19, var25, var20);
                  Tessellation.adjust_polygon_size(Modify.h, var44, var31);
                  Trianglation.trianglate(Modify.h);
                  Tessellation.remove_thin_polygons(Modify.h);
                  Modify.h.set_parameters();
                  return false;
               }

               System.out.println("front back cutting mismatch");
               return false;
            }

            var3 = var4;
         }

         System.out.println("invalid cutting stroke");
         return true;
      }
   }

   private static Objects cut_sub(LinkedList var0, Enumeration var1, Polygon2 var2, Vertex2D var3, Vertex var4, boolean var5) {
      while (var1.hasMoreElements()) {
         Vertex2D var6 = (Vertex2D)var1.nextElement();
         Objects var9 = Geometry.find_vertex_on_surface(var6, var5);
         if (var9 == null) {
            return new Objects(var2, var4, var3, var6);
         }

         Polygon2 var8 = (Polygon2)var9.get(0);
         Vertex var7 = (Vertex)var9.get(1);
         var0.connect(Geometry.surface_path(var3, var6, var4, var7, var2, var8));
         var0.append(var9);
         var2 = var8;
         var3 = var6;
         var4 = var7;
      }

      System.out.println("Cutting sttroke is too short");
      return null;
   }

   private static double get_average_length_sub(LinkedList var0) {
      double var1 = 0.0;
      Enumeration var3 = var0.elements();
      Vertex var4 = (Vertex)((Objects)var3.nextElement()).get(1);

      while (var3.hasMoreElements()) {
         Vertex var5 = (Vertex)((Objects)var3.nextElement()).get(1);
         var1 += Vector3.distance(var4, var5);
         var4 = var5;
      }

      return var1;
   }

   private static void generate_temp_surface_lines(Vector var0) {
      Modify.h.temp_surface_lines = new LinkedList();
      Enumeration var1 = Modify.h.temp_edge_vertex_list.elements();
      var1.nextElement();

      while (var1.hasMoreElements()) {
         Objects var2 = (Objects)var1.nextElement();
         Edge var3 = (Edge)var2.get(0);
         Polygon2 var4 = var3.left_polygon;
         Vertex var5 = var3.start;
         Vertex var6 = var3.end;
         if (var3.start != var2.get(1)) {
            var4 = var3.right_polygon;
            var5 = var3.end;
            var6 = var3.start;
         }

         Modify.h.temp_surface_lines.append(new SurfaceLine(var5.copy(), var6.copy(), var4));
      }
   }

   public static boolean cut(LinkedList var0, Polyhedron var1, boolean var2) {
      Teddy.teddy.play_sound("cutting.au");
      var0 = Generate.normalize_Point_list(var0, Def.NORMALIZED_STROKE_LENGTH_POP);
      Modify.init(var1);
      LinkedList var4 = new LinkedList();
      Enumeration var5 = var0.elements();

      while (var5.hasMoreElements()) {
         Point var3 = (Point)var5.nextElement();
         var4.append(new Vertex2D(Draw3DScene.reverse_convertX(var3.x), Draw3DScene.reverse_convertY(var3.y)));
      }

      var4 = Generate.normalize_Vertex2D_list(var4);
      var4 = Generate.reduce_Vertex2D_list(var4, true);
      return cut_main(var4, var2);
   }

   private static Vertex find_corresponding_vertex(Vertex var0, Vector var1) {
      for (int var2 = 0; var2 < var1.size(); var2++) {
         Objects var3 = (Objects)var1.elementAt(var2);
         if (var0 == var3.get(0)) {
            var0 = (Vertex)var3.get(1);
            var2 = 0;
         }
      }

      return var0;
   }
}
