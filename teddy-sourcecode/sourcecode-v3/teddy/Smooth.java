package teddy;

import java.util.Enumeration;

class Smooth extends Pop {
   private static int old_part_index;
   private static int new_part_index;

   public static void smooth_main() {
      Vertex var0 = Draw3DScene.camera;
      Geometry.init(Modify.h, var0);
      Vector3 var1 = new Vector3(0.0, 0.0, 0.0);
      Enumeration var3 = Modify.h.temp_surface_lines.elements();
      Vector3 var4 = ((SurfaceLine)var3.nextElement()).vector3();

      while (var3.hasMoreElements()) {
         Vector3 var5 = ((SurfaceLine)var3.nextElement()).vector3();
         Vector3 var2 = var4.cross_product(var5);
         var1.add_self(var2);
         var4 = var5;
      }

      var1.normalize();
      Vertex var6 = new Vertex(0.0, 0.0, 0.0);
      var3 = Modify.h.temp_surface_lines.elements();

      while (var3.hasMoreElements()) {
         SurfaceLine var7 = (SurfaceLine)var3.nextElement();
         var6.add_self(var7.start);
      }

      var6.multiple_self(1.0 / Modify.h.temp_surface_lines.size());
      Vector3 var17 = var1.multiple(-1.0);
      Vector3 var8 = var17.cross_product(new Vector3(1.0, 0.0, 0.0));
      var8.normalize_self();
      Vector3 var9 = var17.cross_product(var8);
      CoordSystem var10 = new CoordSystem(var8, var9, var17);
      if (!Modify.h.section_bumping) {
         Modify.section_is_sharp = false;
         Pop.divide_polygons_loop(Modify.h.temp_edge_vertex_list);
         Modify.delete_temp_polygons();
      } else {
         var3 = Modify.h.temp_surface_lines.elements();

         while (var3.hasMoreElements()) {
            SurfaceLine var11 = (SurfaceLine)var3.nextElement();
            Modify.h.remove(var11.polygon);
         }

         var3 = Modify.h.temp_edge_vertex_list.elements();

         while (var3.hasMoreElements()) {
            Edge var18 = (Edge)((Objects)var3.nextElement()).get(0);
            var18.set_sharp(false);
         }
      }

      LinkedList var19 = new LinkedList();
      var3 = Modify.h.temp_edge_vertex_list.elements();
      var3.nextElement();

      while (var3.hasMoreElements()) {
         Objects var12 = (Objects)var3.nextElement();
         var19.append((Vertex)var12.get(1));
      }

      Polygon2 var20 = Trianglation2D.generate_simple_patch(Modify.h, var19, var10);
      Modify.remove_broken_polygons();
      Modify.h.remove(var20);
      Trianglation2D.generate_smooth_patch(Modify.h, var19, var10);
      Trianglation.trianglate(Modify.h);
      Tessellation.remove_thin_polygons(Modify.h);
      Modify.h.set_parameters();
      Modify.h.temp_surface_lines = new LinkedList();
   }

   public static void smooth(Polyhedron var0) {
      Teddy.teddy.play_sound("smooth.au");
      Modify.h = var0;
      Modify.h.current_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
      smooth_main();
   }
}
