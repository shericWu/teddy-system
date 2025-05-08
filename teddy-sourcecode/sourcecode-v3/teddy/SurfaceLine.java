package teddy;

import java.awt.Point;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.Enumeration;

class SurfaceLine extends Edge implements Serializable {
   public static Teddy teddy;
   public Polygon2 polygon;
   public static Polyhedron h;

   SurfaceLine() {
      super.start = new Vertex();
      super.end = new Vertex();
      this.polygon = null;
   }

   SurfaceLine(Vertex var1, Vertex var2, Polygon2 var3) {
      super.start = var1;
      super.end = var2;
      this.polygon = var3;
      if (this.polygon != null) {
         this.polygon.surface_lines.append(this);
      }
   }

   SurfaceLine(Vertex2D var1, Vertex2D var2, Polyhedron var3) {
      Vertex var4 = Draw3DScene.camera;
      Geometry.init(var3, var4);
      Objects var5 = Geometry.find_vertex_on_surface(var1, true);
      Objects var6 = Geometry.find_vertex_on_surface(var2, true);
      if (var5.get(0) != var6.get(0)) {
         System.out.println("surface line, different polygon");
      }

      super.start = (Vertex)var5.get(1);
      super.end = (Vertex)var6.get(1);
      this.polygon = (Polygon2)var5.get(0);
   }

   public static boolean generate_surface_lines(LinkedList var0, Polyhedron var1, boolean var2) {
      h = var1;
      if (var0.size() == 0) {
         return false;
      } else {
         boolean var3 = generate_surface_lines_main(var0, true);
         if (var3) {
            return true;
         } else {
            if (var2) {
               generate_surface_lines_main(var0, false);
            }

            return false;
         }
      }
   }

   public static LinkedList get_edge_vertex_list(LinkedList var0, Objects var1, boolean var2) {
      LinkedList var3 = new LinkedList();
      var3.append(var1);
      Enumeration var8 = var0.elements();
      Point var4 = (Point)var8.nextElement();

      while (var8.hasMoreElements()) {
         Point var5 = (Point)var8.nextElement();
         Vertex2D var6 = new Vertex2D(Draw3DScene.reverse_convertX(var4.x), Draw3DScene.reverse_convertY(var4.y));
         Vertex2D var7 = new Vertex2D(Draw3DScene.reverse_convertX(var5.x), Draw3DScene.reverse_convertY(var5.y));
         get_edge_vertex_list_sub(var6, var7, h, var3, var2);
         var4 = var5;
      }

      return var3;
   }

   public static boolean generate_surface_lines_main(LinkedList var0, boolean var1) {
      Point var2 = (Point)var0.head();
      Vertex2D var3 = new Vertex2D(Draw3DScene.reverse_convertX(var2.x), Draw3DScene.reverse_convertY(var2.y));
      Objects var4 = Geometry.find_vertex_on_surface(var3, var1);
      if (var4 == null) {
         return true;
      } else {
         Teddy.teddy.play_sound("drip.au");
         boolean var5 = false;
         double var6 = Generate.calculate_stroke_length(var0);
         if (var6 > 40.0 && Vector2.distance((Point)var0.head(), (Point)var0.tail()) < 20.0) {
            var5 = true;
            var0.replace_tail(var0.head());
            var0 = Generate.counter_clockwise(var0);
         }

         var0 = Generate.normalize_Point_list(var0, Def.NORMALIZED_STROKE_LENGTH_POP);
         LinkedList var8 = get_edge_vertex_list(var0, var4, var1);
         var8 = remove_short_edges(var8);
         if (var5) {
            h.temp_surface_lines.connect(generate_surface_lines_sub(var8));
            var8.replace_tail(var8.head());
            h.temp_edge_vertex_list = var8;
            h.section_bumping = false;
         } else {
            h.surface_lines.connect(generate_surface_lines_sub(var8));
         }

         return false;
      }
   }

   public static LinkedList generate_surface_lines_sub(LinkedList var0) {
      LinkedList var1 = new LinkedList();
      Enumeration var7 = var0.elements();
      Objects var6 = (Objects)var7.nextElement();
      Polygon2 var2 = (Polygon2)var6.get(0);
      Vertex var3 = (Vertex)var6.get(1);

      while (var7.hasMoreElements()) {
         var6 = (Objects)var7.nextElement();
         Vertex var4 = (Vertex)var6.get(1);
         var1.append(new SurfaceLine(var3, var4, var2));
         if (var6.get(0) instanceof Edge) {
            Edge var5 = (Edge)var6.get(0);
            var2 = var5.get_another_polygon(var2);
         }

         var3 = var4.copy();
      }

      return var1;
   }

   public static void get_edge_vertex_list_sub(Vertex2D var0, Vertex2D var1, Polyhedron var2, LinkedList var3, boolean var4) {
      Objects var5 = Geometry.find_vertex_on_surface(var0, var4);
      Objects var6 = Geometry.find_vertex_on_surface(var1, var4);
      if (var5 != null && var6 != null) {
         Vertex var7 = (Vertex)var5.get(1);
         Vertex var8 = (Vertex)var6.get(1);
         Polygon2 var9 = (Polygon2)var5.get(0);
         Polygon2 var10 = (Polygon2)var6.get(0);
         var3.connect(Geometry.surface_path(var0, var1, var7, var8, var9, var10));
         var3.append(var6);
      } else {
         System.out.println("failed to find surface");
      }
   }

   public Edge copy() {
      Polygon2 var1 = this.polygon.child;
      SurfaceLine var2 = new SurfaceLine(super.start.position_copy(), super.end.position_copy(), var1);
      var1.surface_lines.append(var2);
      return var2;
   }

   private static LinkedList remove_short_edges(LinkedList var0) {
      boolean var1 = false;
      if (var0.head() == var0.tail()) {
         var1 = true;
      }

      LinkedList var2 = new LinkedList();
      Enumeration var3 = var0.elements();
      Objects var4 = (Objects)var3.nextElement();
      Objects var6 = var4;
      var2.append(var4);
      Vertex var7 = (Vertex)var4.get(1);

      while (var3.hasMoreElements()) {
         Objects var8 = (Objects)var3.nextElement();
         Vertex var9 = (Vertex)var8.get(1);
         if (Vector3.distance(var7, var9) > Def.MINIMUM_EDGE_LENGTH || var8.get(0) instanceof Edge) {
            if (var4.get(0) instanceof Polygon && Vector3.distance(var7, var9) < Def.MINIMUM_EDGE_LENGTH) {
               var2.remove(var2.tail());
            }

            if (var4.get(0) instanceof Edge && var4.get(0) == var8.get(0)) {
               var2.append(var6);
               System.out.println("inserted");
            }

            var2.append(var8);
            var7 = var9;
            var4 = var8;
         }

         var6 = var8;
      }

      if (var1) {
         if (var2.head() != var2.tail()) {
            var2.append(var2.head());
         }
      } else {
         if (var2.head() != var0.head()) {
            var2.reset();
            var2.insert(var0.head());
         }

         if (var2.tail() != var0.tail()) {
            var2.append(var0.tail());
         }
      }

      return var2;
   }
}
