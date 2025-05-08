package teddy;

import java.awt.Point;
import java.util.Enumeration;
import java.util.Vector;

class Trianglation2D {
   public static Vector vertices;
   public static Vector edges;
   public static Vector triangles;
   public static Queue queue_of_segments;
   public static Queue queue_of_triangles;
   private static double MIN_EDGE_LENGTH = 40.0;

   private static void check_flip(TrEdge var0) {
      if (var0.left_triangle != null && var0.right_triangle != null) {
         TrVertex var1 = (TrVertex)var0.start;
         TrVertex var2 = (TrVertex)var0.end;
         TrVertex var3 = var0.left_triangle.get_opposite_vertex(var0);
         TrVertex var4 = var0.right_triangle.get_opposite_vertex(var0);
         if (Geometry2D.left_side(var3, var1, var4) && cos(var1, var2, var3) > cos(var1, var4, var3)) {
            var0.left_triangle.destroy();
            var0.right_triangle.destroy();
            triangles.addElement(new Triangle(var1, var4, var3));
            triangles.addElement(new Triangle(var2, var3, var4));
            check_flip(var1.shared_edge(var3));
            check_flip(var1.shared_edge(var4));
            check_flip(var2.shared_edge(var3));
            check_flip(var2.shared_edge(var4));
            check_encroached(var3.shared_edge(var4));
         }
      }
   }

   public static void trianglate_from_stroke(LinkedList var0) {
      var0.append(var0.head());
      var0 = Generate.normalize_Point_list(var0, (int)MIN_EDGE_LENGTH);
      var0.remove(var0.head());
      vertices = new Vector();
      Enumeration var1 = var0.elements();

      while (var1.hasMoreElements()) {
         vertices.addElement(new TrVertex((Point)var1.nextElement(), true));
      }

      trianglate();
   }

   public static void trianglate() {
      edges = new Vector();
      triangles = new Vector();

      for (int var0 = 0; var0 < vertices.size() - 1; var0++) {
         TrVertex var1 = (TrVertex)vertices.elementAt(var0);
         TrVertex var2 = (TrVertex)vertices.elementAt(var0 + 1);
         edges.addElement(new TrEdge(var1, var2, true));
      }

      edges.addElement(new TrEdge((TrVertex)vertices.elementAt(vertices.size() - 1), (TrVertex)vertices.elementAt(0), true));
      constraint_delauny_trianglate(vertices);
      queue_of_segments = new Queue();
      queue_of_triangles = new Queue();

      for (int var3 = 0; var3 < edges.size(); var3++) {
         check_encroached((TrEdge)edges.elementAt(var3));
      }

      int var4 = 0;

      while (queue_of_segments.size() > 0) {
         TrEdge var5 = (TrEdge)queue_of_segments.pop();
         if (!var5.destroyed) {
            divide_edge(var5);
         }

         if (++var4 > 500) {
            break;
         }
      }
   }

   public static Scene rearrange_scene() {
      Scene var0 = new Scene();
      rearrange();
      Enumeration var1 = edges.elements();

      while (var1.hasMoreElements()) {
         TrEdge var2 = (TrEdge)var1.nextElement();
         Generate.add_segment(var0, var2.start, var2.end);
      }

      return var0;
   }

   private static void check_encroached(TrEdge var0) {
      if (encroached(var0)) {
         queue_of_segments.push(var0);
      }
   }

   public static Polygon2 generate_simple_patch(Polyhedron var0, LinkedList var1, CoordSystem var2) {
      LinkedList var4 = new LinkedList();
      Enumeration var3 = var1.elements();
      Vertex var5 = (Vertex)var3.nextElement();
      Vertex var6 = var5;

      while (var3.hasMoreElements()) {
         Vertex var7 = (Vertex)var3.nextElement();
         var4.append(var5.get_shared_edge(var7));
         if (var5.same_position(var7)) {
            System.out.println("T2D.generate_smooth_patch() overlapping vertex");
         }

         var5 = var7;
      }

      var4.append(var5.get_shared_edge(var6));
      Polygon2 var8 = new Polygon2(var4);
      var0.append(var8);
      return var8;
   }

   public static void rearrange() {
      Vertex2D[] var0 = new Vertex2D[vertices.size()];

      for (int var1 = 0; var1 < vertices.size(); var1++) {
         TrVertex var2 = (TrVertex)vertices.elementAt(var1);
         if (!var2.external) {
            Vertex2D var3 = get_center(var2);
            Vector2 var4 = new Vector2(var2, var3);
            var0[var1] = var2.translate(var4.multiple(0.5));
         } else {
            var0[var1] = var2;
         }
      }

      for (int var5 = 0; var5 < vertices.size(); var5++) {
         TrVertex var6 = (TrVertex)vertices.elementAt(var5);
         var6.warp(var0[var5]);
      }
   }

   public static void generate_smooth_patch(Polyhedron var0, LinkedList var1, CoordSystem var2) {
      vertices = new Vector();
      Vector var4 = new Vector();
      Enumeration var3 = var1.elements();

      while (var3.hasMoreElements()) {
         Vertex var5 = (Vertex)var3.nextElement();
         Vertex var6 = var2.translate(var5);
         TrVertex var7 = new TrVertex(var6, true, var5);
         vertices.addElement(var7);
         var4.addElement(var7);
      }

      double var16 = 0.0;
      var3 = var4.elements();
      TrVertex var18 = (TrVertex)var3.nextElement();
      TrVertex var8 = var18;

      while (var3.hasMoreElements()) {
         TrVertex var9 = (TrVertex)var3.nextElement();
         var16 += Vector2.distance(var18, var9);
         var18 = var9;
      }

      var16 += Vector2.distance(var18, var8);
      MIN_EDGE_LENGTH = var16 / var1.size() * 2.0;
      trianglate();
      int var19 = 0;

      do {
         rearrange();
      } while (++var19 < 5);

      var3 = vertices.elements();

      while (var3.hasMoreElements()) {
         TrVertex var20 = (TrVertex)var3.nextElement();
         if (!var20.external) {
            var20.set_height_slope(var4, var2);
            var20.original = var2.reverse_translate(var20.x, var20.y, var20.height);
            var0.append(var20.original);
         }
      }

      var3 = edges.elements();

      while (var3.hasMoreElements()) {
         TrEdge var21 = (TrEdge)var3.nextElement();
         Vertex var10 = ((TrVertex)var21.start).original;
         Vertex var11 = ((TrVertex)var21.end).original;
         var21.original = var0.get_edge_array(var10, var11);
      }

      Vector var22 = new Vector();

      for (int var23 = 0; var23 < vertices.size(); var23++) {
         TrVertex var25 = (TrVertex)vertices.elementAt(var23);
         var22.addElement(var25.original);
      }

      ReTessellation.smooth(var22);
      var3 = triangles.elements();

      while (var3.hasMoreElements()) {
         Triangle var24 = (Triangle)var3.nextElement();
         var0.append(new Polygon2(var24.original_edges()));
      }
   }

   private static void divide_edge(TrEdge var0) {
      TrVertex var1 = new TrVertex(var0.mid_point());
      vertices.addElement(var1);
      if (var0.external) {
         var1.external = true;
      }

      TrVertex var2 = (TrVertex)var0.start;
      TrVertex var3 = (TrVertex)var0.end;
      divide_edge_sub(var0, var1, var0.left_triangle, var2, var3);
      divide_edge_sub(var0, var1, var0.right_triangle, var3, var2);
      check_encroached(var1.shared_edge(var2));
      check_encroached(var1.shared_edge(var3));
   }

   public static Scene generate_scene(LinkedList var0) {
      Scene var1 = new Scene();
      trianglate_from_stroke(var0);
      Enumeration var2 = edges.elements();

      while (var2.hasMoreElements()) {
         TrEdge var3 = (TrEdge)var2.nextElement();
         Generate.add_segment(var1, var3.start, var3.end);
      }

      return var1;
   }

   private static boolean encroached(TrEdge var0) {
      return !var0.external && !(var0.length() < MIN_EDGE_LENGTH * 1.8);
   }

   private static boolean encroached_sub(TrEdge var0, Triangle var1) {
      if (var1 == null) {
         return false;
      } else {
         TrVertex var2 = var1.get_opposite_vertex(var0);
         return new Vector2(var2, var0.start).cos(new Vector2(var2, var0.end)) < 0.0;
      }
   }

   public static void constraint_delauny_trianglate(Vector var0) {
      if (var0.size() == 3) {
         triangles.addElement(new Triangle((TrVertex)var0.elementAt(0), (TrVertex)var0.elementAt(1), (TrVertex)var0.elementAt(2)));
      } else {
         int var1 = var0.size();
         TrVertex var2 = (TrVertex)var0.elementAt(0);
         TrVertex var3 = (TrVertex)var0.elementAt(1);
         double var4 = 2.0;
         TrVertex var6 = null;
         int var7 = -100;

         for (int var8 = 2; var8 < var1; var8++) {
            TrVertex var9 = (TrVertex)var0.elementAt(var8);
            if (Geometry2D.left_side(var2, var3, var9)) {
               double var10 = new Vector2(var9, var2).get_cos(new Vector2(var9, var3));
               if (var10 < var4) {
                  var4 = var10;
                  var6 = var9;
                  var7 = var8;
               }
            }
         }

         if (var6 == null) {
            System.out.println("Trianglation2D.constraint_delauny_trianglation(), closest_v == null");
         }

         triangles.addElement(new Triangle(var2, var3, var6));
         if (var7 > 2) {
            Vector var12 = new Vector();

            for (int var14 = 1; var14 <= var7; var14++) {
               var12.addElement(var0.elementAt(var14));
            }

            constraint_delauny_trianglate(var12);
         }

         if (var7 < var1 - 1) {
            Vector var13 = new Vector();
            var13.addElement(var0.elementAt(0));

            for (int var15 = var7; var15 <= var1 - 1; var15++) {
               var13.addElement(var0.elementAt(var15));
            }

            constraint_delauny_trianglate(var13);
         }
      }
   }

   public static void rearrange3D() {
      Vertex[] var0 = new Vertex[vertices.size()];

      for (int var1 = 0; var1 < vertices.size(); var1++) {
         TrVertex var2 = (TrVertex)vertices.elementAt(var1);
         Vertex var3 = var2.original;
         if (!var2.external) {
            LinkedList var4 = var3.get_sorrounding_vertices();
            var0[var1] = ReTessellation.to_the_center(var4, var3, 0.5);
         } else {
            var0[var1] = var3;
         }
      }

      for (int var5 = 0; var5 < vertices.size(); var5++) {
         TrVertex var6 = (TrVertex)vertices.elementAt(var5);
         var6.original.warp(var0[var5]);
      }
   }

   public static Vertex2D get_center(TrVertex var0) {
      Vertex2D var1 = new Vertex2D(0.0, 0.0);

      for (int var2 = 0; var2 < var0.edges.size(); var2++) {
         TrEdge var3 = (TrEdge)var0.edges.elementAt(var2);
         var1.add_self(var3.get_the_other_vertex(var0));
      }

      return new Vertex2D(var1.multiple(1.0 / var0.edges.size()));
   }

   private static void divide_edge_sub(TrEdge var0, TrVertex var1, Triangle var2, TrVertex var3, TrVertex var4) {
      if (var2 != null) {
         TrVertex var5 = var2.get_opposite_vertex(var0);
         var2.destroy();
         triangles.addElement(new Triangle(var3, var1, var5));
         triangles.addElement(new Triangle(var1, var4, var5));
         check_flip(var5.shared_edge(var3));
         check_flip(var5.shared_edge(var4));
         check_encroached(var1.shared_edge(var5));
      }
   }

   private static double cos(Vertex2D var0, Vertex2D var1, Vertex2D var2) {
      return new Vector2(var1, var0).cos(new Vector2(var1, var2));
   }
}
