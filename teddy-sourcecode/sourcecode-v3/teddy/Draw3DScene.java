package teddy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Enumeration;
import java.util.Random;

class Draw3DScene {
   public static int render_style;
   public static final int WIRE_FRAME = 0;
   public static final int FRONT_FACE = 1;
   public static final int SILHOUETTE = 2;
   public static final int SHADED = 3;
   public static final int STROKE_SHADED = 4;
   private static double scale;
   private static double line_scale;
   public static int line_style;
   public static final int NORMAL_LINE = 0;
   public static final int RANDOM_LINE = 1;
   public static final int WIDE_LINE = 2;
   public static Polygon2 current_polygon = null;
   public static boolean in_motion = false;
   private static Random rand = new Random();
   private static int centerX = 200;
   private static int centerY = 150;
   private static int basic_scale = 100;
   private static int eye_z = 10;
   public static Vertex camera;

   public static double reverse_convertY(double var0) {
      return -(var0 - centerY) / scale;
   }

   private static void paint_z_buffer(Graphics var0, Polyhedron var1, boolean var2) {
      Geometry.init(var1, camera);

      for (int var3 = var1.n_polygons - 1; var3 > -1; var3--) {
         Polygon2 var4 = Geometry.sorted_polygons[var3];
         var4.check_facing(camera);
         if (var4.front_facing) {
            draw_white_polygon(var0, var4);
            if (!var2) {
               fillRandom(var0, var4);
            }

            draw_silhouette_edges(var0, var4);
         }
      }
   }

   public static void fillRandom(Graphics var0, Polygon2 var1) {
      Point var2 = project(var1.get_vertex(0));
      Point var3 = project(var1.get_vertex(1));
      Point var4 = project(var1.get_vertex(2));
      Vector2 var5 = new Vector2(var2, var3);
      Vector2 var6 = new Vector2(var2, var4);
      Vector3 var7 = var1.absolute_normal().get_normalized();
      Vector2 var8 = project(var7).normalize();
      double var9 = Vector2.distance(0.0, 0.0, var7.x, var7.z);
      double var11 = Math.abs(var5.cross_product(var6));
      var9 = Math.max(var9 - 0.6, 0.0);
      int var23 = (int)(var11 * var9 * var9 * 0.3);

      for (int var24 = 0; var24 < var23; var24++) {
         double var13 = rand.nextDouble();
         double var15 = rand.nextDouble();
         double var21 = rand.nextDouble();
         double var17 = var15 * var13;
         double var19 = (1.0 - var15) * var13;
         var0.setColor(new Color(0, 0, 0));
         Graphics2.drawRandomLine(
            var0,
            (int)(var2.x + var17 * var5.x + var19 * var6.x + 8.0 * var21 * var8.y),
            (int)(var2.y + var17 * var5.y + var19 * var6.y - 8.0 * var21 * var8.x),
            (int)(var2.x + var17 * var5.x + var19 * var6.x - 8.0 * var21 * var8.y),
            (int)(var2.y + var17 * var5.y + var19 * var6.y + 8.0 * var21 * var8.x)
         );
      }
   }

   public static double project_x(Vertex var0) {
      return var0.x() * eye_z / (var0.y() + eye_z);
   }

   public static void draw_polygon(Graphics var0, Polygon2 var1, Color var2) {
      for (int var3 = 0; var3 < var1.n_edges; var3++) {
         draw_edge(var0, var1.edges[var3], var2);
      }
   }

   private static void paint_silhouette(Graphics var0, Polyhedron var1) {
      LinkedList var2 = SilhouetteFind.find_visible_edges(var1, camera);
      Enumeration var3 = var2.elements();

      while (var3.hasMoreElements()) {
         ProjectedEdge var4 = (ProjectedEdge)var3.nextElement();
         draw_projected_edge(var0, var4, Color.black);
      }
   }

   public static double project_y(Vertex var0) {
      return var0.z() * eye_z / (var0.y() + eye_z);
   }

   public static void paint(Graphics var0, Polyhedron var1, double var2, Dimension var4) {
      scale = var2 * basic_scale;
      line_scale = var2 * 6.0;
      centerX = var4.width / 2;
      centerY = var4.height / 2;
      var0.setPaintMode();
      camera = new Vertex(0.0, -eye_z, 0.0);
      if (var1 != null) {
         switch (render_style) {
            case 0:
               if (!in_motion) {
                  Geometry.init(var1, camera);
               }

               for (int var9 = 0; var9 < var1.n_edges; var9++) {
                  draw_edge(var0, var1.edges[var9], Color.black);
               }
               break;
            case 1:
               if (!in_motion) {
                  Geometry.init(var1, camera);
               }

               for (int var8 = 0; var8 < var1.n_polygons; var8++) {
                  var1.polygons[var8].check_facing(camera);
                  if (var1.polygons[var8].front_facing) {
                     draw_polygon(var0, var1.polygons[var8], Color.black);
                  }
               }
               break;
            case 2:
               if (!in_motion) {
                  Geometry.init(var1, camera);
               }

               paint_silhouette(var0, var1);
               break;
            case 3:
               if (!in_motion) {
                  Geometry.init(var1, camera);

                  for (int var7 = var1.n_polygons - 1; var7 > -1; var7--) {
                     Polygon2 var10 = Geometry.sorted_polygons[var7];
                     var10.check_facing(camera);
                     if (var10.front_facing) {
                        draw_shaded_polygon(var0, var10);
                     }
                  }
               }

               paint_silhouette(var0, var1);
               break;
            case 4:
               if (!in_motion) {
                  Geometry.init(var1, camera);

                  for (int var5 = var1.n_polygons - 1; var5 > -1; var5--) {
                     Polygon2 var6 = Geometry.sorted_polygons[var5];
                     var6.check_facing(camera);
                     if (var6.front_facing) {
                        draw_white_polygon(var0, var6);
                        fillRandom(var0, var6);
                     }
                  }
               }

               paint_silhouette(var0, var1);
         }

         paint_surfacelines(var0, var1);
         paint_temp_surfacelines(var0, var1);
         if (current_polygon != null) {
            draw_polygon(var0, current_polygon, Color.blue);
         }
      }
   }

   private static void draw_line(Graphics var0, Color var1, int var2, int var3, int var4, int var5) {
      var0.setColor(var1);
      switch (line_style) {
         case 0:
            var0.drawLine(var2, var3, var4, var5);
            return;
         case 1:
            Graphics2.drawRandomLine(var0, var2, var3, var4, var5);
            return;
         case 2:
            Graphics2.drawWideLine(var0, var2, var3, var4, var5, line_scale);
            return;
      }
   }

   public static int convertY(double var0) {
      return centerY - (int)(var0 * scale);
   }

   public static double reverse_convertZ(double var0) {
      return var0 / scale;
   }

   private static void paint_surfacelines(Graphics var0, Polyhedron var1) {
      Color var2 = Color.black;
      Enumeration var3 = var1.surface_lines.elements();

      while (var3.hasMoreElements()) {
         SurfaceLine var4 = (SurfaceLine)var3.nextElement();
         if (var4.polygon == null || var4.polygon.front_facing) {
            draw_edge(var0, var4, var2);
         }
      }
   }

   private static void draw_silhouette_edges(Graphics var0, Polygon2 var1) {
      Color var2 = Color.black;

      for (int var3 = 0; var3 < var1.n_edges; var3++) {
         Edge var4 = var1.edges[var3];
         Polygon2 var5 = var4.get_the_other_polygon(var1);
         var5.check_facing(camera);
         if (!var5.front_facing) {
            draw_edge(var0, var4, var2);
         }
      }
   }

   public static void draw_shaded_polygon(Graphics var0, Polygon2 var1) {
      Vector3 var2 = var1.absolute_normal();
      int var3 = (int)(75.0 - 180.0 * var2.y / var2.length());
      var0.setColor(new Color(var3, var3, var3));
      draw_fill_polygon(var0, var1);
   }

   public static Vector2 project(Vector3 var0) {
      Vertex var1 = var0.vertex();
      double var2 = convertX_vector(project_x(var1));
      double var4 = convertY_vector(project_y(var1));
      return new Vector2(var2, var4);
   }

   public static Point project(Vertex var0) {
      Point var1 = new Point();
      var1.x = convertX(project_x(var0));
      var1.y = convertY(project_y(var0));
      return var1;
   }

   public static double reverse_convertX(int var0) {
      return (var0 - centerX) / scale;
   }

   private static void draw_edge(Graphics var0, Edge var1, Color var2) {
      var0.setColor(var2);
      Point var3 = project(var1.start());
      Point var4 = project(var1.end());
      draw_line(var0, var2, var3.x, var3.y, var4.x, var4.y);
   }

   private static void draw_projected_edge(Graphics var0, ProjectedEdge var1, Color var2) {
      draw_line(var0, var2, convertX(var1.start.x), convertY(var1.start.y), convertX(var1.end.x), convertY(var1.end.y));
   }

   public static double reverse_convertX(double var0) {
      return (var0 - centerX) / scale;
   }

   public static int convertX_vector(double var0) {
      return (int)(var0 * scale);
   }

   public static int convertY_vector(double var0) {
      return -((int)(var0 * scale));
   }

   public static void draw_white_polygon(Graphics var0, Polygon2 var1) {
      var0.setColor(Color.white);
      draw_fill_polygon(var0, var1);
   }

   public static void draw_fill_polygon(Graphics var0, Polygon2 var1) {
      int[] var2 = new int[var1.n_edges];
      int[] var3 = new int[var1.n_edges];

      for (int var4 = 0; var4 < var1.n_edges; var4++) {
         Point var5 = project(var1.get_vertex(var4));
         var2[var4] = var5.x;
         var3[var4] = var5.y;
      }

      var0.fillPolygon(var2, var3, var1.n_edges);
   }

   public static int convertX(double var0) {
      return centerX + (int)(var0 * scale);
   }

   private static void paint_temp_surfacelines(Graphics var0, Polyhedron var1) {
      Color var2 = Color.red;
      Enumeration var3 = var1.temp_surface_lines.elements();

      while (var3.hasMoreElements()) {
         SurfaceLine var4 = (SurfaceLine)var3.nextElement();
         if (var4.polygon == null || var4.polygon.front_facing) {
            draw_edge(var0, var4, var2);
         }
      }
   }

   public static Vertex image_plane_to_world_coords(Vertex2D var0) {
      return new Vertex(var0.x, 0.0, var0.y);
   }

   public static void set_front_facing(Polyhedron var0) {
      camera = new Vertex(0.0, -eye_z, 0.0);

      for (int var1 = 0; var1 < var0.n_polygons; var1++) {
         var0.polygons[var1].check_facing(camera);
      }
   }

   public static double reverse_convertY(int var0) {
      return -(var0 - centerY) / scale;
   }
}
