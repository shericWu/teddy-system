package teddy;

import java.util.Enumeration;

class Geometry {
   public static Polyhedron h;
   public static Vertex camera;
   public static Polygon2[] sorted_polygons;

   private static Vertex cross_point(Polygon2 var0, Vertex2D var1) {
      Vertex var2 = Draw3DScene.image_plane_to_world_coords(var1);
      Edge var3 = new Edge(camera, var2);
      return var0.cross_point(var3);
   }

   public static Objects find_vertex_on_surface(Vertex2D var0, boolean var1) {
      Vertex var2 = null;
      Polygon2 var3 = null;
      double var4 = -1.0;
      Object var6 = null;
      Object var7 = null;

      for (int var10 = 0; var10 < h.n_polygons; var10++) {
         var7 = sorted_polygons[var10];
         if (((Polygon2)var7).front_facing == var1 && on_surface((Polygon2)var7, var0)) {
            var6 = cross_point((Polygon2)var7, var0);
            double var8 = Vector3.distance(camera, (Vertex)var6);
            var4 = var8;
            var2 = (Vertex)var6;
            var3 = (Polygon2)var7;
            break;
         }
      }

      return var4 != -1.0 ? new Objects(var3, var2) : null;
   }

   public static LinkedList surface_path(Vertex2D var0, Vertex2D var1, Vertex var2, Vertex var3, Polygon2 var4, Polygon2 var5) {
      LinkedList var6 = new LinkedList();
      if (var4 == var5) {
         return var6;
      } else {
         ProjectedEdge var7 = new ProjectedEdge(var0, var1);
         Polygon2 var9 = var4;
         ProjectedEdge var10 = var7;
         Surface var15 = new Surface(camera, Draw3DScene.image_plane_to_world_coords(var0), Draw3DScene.image_plane_to_world_coords(var1));

         while (var9 != var5) {
            Objects var8 = find_cross_edge(var9, var7, var10.original);
            ProjectedEdge var11 = (ProjectedEdge)var8.get(0);
            Vertex2D var12 = (Vertex2D)var8.get(1);
            Vertex var14 = var15.cross_point(var11.original);
            var6.append(new Objects(var11.original, var14));
            var9 = var11.original.get_another_polygon(var9);
            Vertex var13 = var14.copy();
            var10 = var11;
         }

         return var6;
      }
   }

   public static boolean on_surface(Polygon2 var0, Vertex2D var1) {
      for (int var2 = 0; var2 < var0.n_edges; var2++) {
         if (!new ProjectedEdge(var0.edges(var2)).in(var0, var1)) {
            return false;
         }
      }

      return true;
   }

   private static Objects find_cross_edge(Polygon2 var0, ProjectedEdge var1, Edge var2) {
      for (int var5 = 0; var5 < var0.n_edges; var5++) {
         if (var0.edges(var5) != var2) {
            ProjectedEdge var3 = new ProjectedEdge(var0.edges(var5));
            if (var3.cross(var1)) {
               Vertex2D var4 = var3.cross_point(var1);
               return new Objects(var3, var4);
            }
         }
      }

      System.out.println("error in path finding (Geometry.find_cross_edge())");
      return null;
   }

   public static void sort_polygons() {
      LinkedList var0 = new LinkedList();

      for (int var1 = 0; var1 < h.n_polygons; var1++) {
         h.polygons[var1].set_distance(camera);
         var0.append(h.polygons[var1]);
      }

      var0 = sort_polygons(var0);
      sorted_polygons = new Polygon2[h.n_polygons];
      Enumeration var4 = var0.elements();

      for (int var2 = 0; var2 < h.n_polygons; var2++) {
         sorted_polygons[var2] = (Polygon2)var4.nextElement();
      }
   }

   private static LinkedList sort_polygons(LinkedList var0) {
      LinkedList var1 = new LinkedList();
      LinkedList var2 = new LinkedList();
      Enumeration var3 = var0.elements();
      if (!var3.hasMoreElements()) {
         return new LinkedList();
      } else {
         Polygon2 var4 = (Polygon2)var3.nextElement();
         double var5 = var4.distance;

         while (var3.hasMoreElements()) {
            Polygon2 var7 = (Polygon2)var3.nextElement();
            if (var7.distance < var5) {
               var1.append(var7);
            } else {
               var2.append(var7);
            }
         }

         var1 = sort_polygons(var1);
         var2 = sort_polygons(var2);
         var1.append(var4);
         var1.connect(var2);
         return var1;
      }
   }

   public static void init(Polyhedron var0, Vertex var1) {
      h = var0;
      camera = var1;
      sort_polygons();
   }
}
