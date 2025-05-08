package teddy;

import java.util.Enumeration;

class SilhouetteFind {
   public static ProjectedEdge[] silhouette_edges;
   public static int n_silhouette_edges;
   public static ProjectedEdge[] possible_edges;
   public static int n_possible_edges;
   public static int eye_z = 10;
   public static Vertex camera;
   private static LinkedList visible_edges;
   private static ProjectedVertex[] possible_vertices;
   private static int n_possible_vertices;

   private static void propagate(ProjectedEdge var0, ProjectedVertex var1, int var2) {
      ProjectedVertex var3 = var0.another_vertex(var1);
      var0.QI = var2;
      int var4 = var2;

      for (int var5 = 0; var5 < n_silhouette_edges; var5++) {
         ProjectedEdge var6 = silhouette_edges[var5];
         if (var0.cross_behind(var6, camera)) {
            var0.QI = 2;
            if (var6.in(var1)) {
               var4 -= 2;
            } else {
               var4 += 2;
            }
         }
      }

      if (var4 >= 0) {
         if (var3.QI == -1) {
            var3.QI = var4;
            propagate(var3, var0);
         }
      }
   }

   private static void propagate(ProjectedVertex var0, ProjectedEdge var1) {
      int var2 = var0.cusp();
      if (var2 > 0) {
         if (var2 <= 2) {
            byte var8;
            if (var0.back_silhouette_edge.covered(var0)) {
               var8 = -1;
            } else {
               var8 = 1;
            }

            int var9 = var0.QI;
            if (var1 == var0.back_silhouette_edge) {
               var0.QI += var8;
            }

            Enumeration var5 = var0.edges.elements();

            while (var5.hasMoreElements()) {
               ProjectedEdge var6 = (ProjectedEdge)var5.nextElement();
               if (var6 != var1 && var6.QI == -1) {
                  if (var6 == var0.back_silhouette_edge) {
                     int var7 = var0.QI - var8;
                     if (var7 < 0) {
                        System.out.println("back_silhouette's QI becomes -1 (SilhouetteFind.propagate())" + var9 + ", delta" + var8);
                     } else {
                        propagate(var6, var0, var7);
                     }
                  } else {
                     propagate(var6, var0, var0.QI);
                  }
               }
            }
         }
      } else {
         Enumeration var3 = var0.edges.elements();

         while (var3.hasMoreElements()) {
            ProjectedEdge var4 = (ProjectedEdge)var3.nextElement();
            if (var4 != var1 && var4.QI == -1) {
               if (var4.type == 1 && var1.type == 3) {
                  propagate(var4, var0, var0.QI - 1);
               } else if (var4.type == 3 && var1.type == 1) {
                  propagate(var4, var0, var0.QI + 1);
               } else {
                  propagate(var4, var0, var0.QI);
               }
            }
         }
      }
   }

   private static void propagate_from_silhouette(ProjectedEdge var0, int var1, Polyhedron var2) {
      ProjectedVertex var3 = var0.start;
      if (var3.original.y > 0.0) {
         var1 += 2;
      }

      var0.QI = var1;
      var3.QI = var1;
      propagate(var0, var3, var3.QI);
      propagate(var3, var0);
   }

   private static ProjectedVertex find_same_vertex(ProjectedVertex var0) {
      for (int var2 = 0; var2 < n_possible_vertices; var2++) {
         ProjectedVertex var1 = possible_vertices[var2];
         if (var1.same_position(var0)) {
            return var1;
         }
      }

      return null;
   }

   private static void renew_network() {
      possible_vertices = new ProjectedVertex[n_possible_edges * 2];
      n_possible_vertices = 0;

      for (int var2 = 0; var2 < n_possible_edges; var2++) {
         ProjectedEdge var0 = possible_edges[var2];
         ProjectedVertex var1 = find_same_vertex(var0.start);
         if (var1 != null) {
            var0.start = var1;
            var1.edges.append(var0);
         } else {
            possible_vertices[n_possible_vertices++] = var0.start;
            var0.start.edges.append(var0);
         }

         var1 = find_same_vertex(var0.end);
         if (var1 != null) {
            var0.end = var1;
            var1.edges.append(var0);
         } else {
            possible_vertices[n_possible_vertices++] = var0.end;
            var0.end.edges.append(var0);
         }
      }
   }

   private static void propagate_from_boundedges(BoundEdges var0) {
      var0.right.right_vertex().QI = 0;
      var0.top.top_vertex().QI = 0;
      var0.bottom.bottom_vertex().QI = 0;
      ProjectedEdge var1 = var0.left;
      ProjectedVertex var2 = var1.left_vertex();
      var2.QI = 0;
      propagate(var1, var2, var2.QI);
      propagate(var2, var1);
      var1 = var0.right;
      var2 = var1.right_vertex();
      var2.QI = 0;
      propagate(var1, var2, var2.QI);
      propagate(var2, var1);
      var1 = var0.top;
      var2 = var1.top_vertex();
      var2.QI = 0;
      propagate(var1, var2, var2.QI);
      propagate(var2, var1);
      var1 = var0.bottom;
      var2 = var1.bottom_vertex();
      var2.QI = 0;
      propagate(var1, var2, var2.QI);
      propagate(var2, var1);
   }

   public static LinkedList find_visible_edges(Polyhedron var0, Vertex var1) {
      if (!var0.view_changed && visible_edges != null) {
         return visible_edges;
      } else {
         var0.view_changed = false;
         camera = var1;

         int var2;
         for (var2 = 0; var2 < var0.n_polygons; var2++) {
            var0.polygons[var2].check_facing(camera);
         }

         silhouette_edges = new ProjectedEdge[var0.n_edges];
         n_silhouette_edges = 0;
         possible_edges = new ProjectedEdge[var0.n_edges];
         n_possible_edges = 0;
         BoundEdges var6 = new BoundEdges(new ProjectedEdge(var0.edges[var2]));

         for (int var7 = 0; var7 < var0.n_edges; var7++) {
            Edge var3 = var0.edges[var7];
            int var5 = var3.visibility_type();
            if (var5 != 0) {
               ProjectedEdge var4 = new ProjectedEdge(var3);
               if (var5 == 2 || var5 == 1) {
                  silhouette_edges[n_silhouette_edges++] = var4;
               }

               if (var5 == 2 || var5 == 3) {
                  possible_edges[n_possible_edges++] = var4;
                  var6.check(var4);
               }
            }
         }

         renew_network();
         propagate_from_boundedges(var6);

         for (int var8 = 0; var8 < n_possible_edges; var8++) {
            ProjectedEdge var10 = possible_edges[var8];
            if (var10.QI == -1) {
               propagate_from_silhouette(var10, 0, var0);
            }
         }

         visible_edges = new LinkedList();

         for (int var9 = 0; var9 < n_possible_edges; var9++) {
            ProjectedEdge var11 = possible_edges[var9];
            if (var11.QI == 0 || var11.QI == -1) {
               visible_edges.append(var11);
            }
         }

         return visible_edges;
      }
   }
}
