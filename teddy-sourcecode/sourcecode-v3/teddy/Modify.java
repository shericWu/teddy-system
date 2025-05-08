package teddy;

import java.util.Enumeration;

public class Modify {
   public static Teddy teddy;
   protected static Polyhedron h;
   public static LinkedList temp_polygons;
   public static Modify.PolygonReplaceManager polygon_replace_manager;
   public static boolean section_is_sharp;

   public static void remove_broken_polygons() {
      while (true) {
         Edge var0 = find_broken_edge();
         if (var0 == null) {
            return;
         }

         Polygon2 var1;
         if (var0.left_polygon() != null) {
            var1 = var0.left_polygon();
         } else {
            var1 = var0.right_polygon();
         }

         remove_broken_polygons(var0, var1);
      }
   }

   protected static void remove_broken_polygons(Edge var0, Polygon2 var1) {
      h.remove(var1);

      for (int var4 = 0; var4 < var1.n_edges; var4++) {
         Edge var2 = var1.edges[var4];
         if (var2 != var0) {
            Polygon2 var3 = var2.get_another_polygon(null);
            if (var3 != null) {
               remove_broken_polygons(var2, var3);
            }
         }
      }
   }

   public static LinkedList divide_a_polygon_around(Polygon2 var0, Vertex var1, Edge var2, Vertex var3, Edge var4) {
      LinkedList var5 = new LinkedList();
      if (!var0.contains(var2)) {
         System.out.println("prev_edge not contained (dividing_a_polygon_around)");
         return var5;
      } else if (!var0.contains(var4)) {
         return var5;
      } else {
         int var7 = var0.get_edge_index(var2) + 1;
         Edge var6 = h.get_edge_array(var1, var0.get_vertex(var7));
         var5.append(var6);

         while (var4 != var0.edges(var7)) {
            var5.append(var0.edges(var7));
            var7++;
         }

         var6 = h.get_edge_array(var3, var0.get_vertex(var7));
         var5.append(var6);
         return var5;
      }
   }

   public static void delete_temp_polygons() {
      Enumeration var0 = temp_polygons.elements();

      while (var0.hasMoreElements()) {
         Polygon2 var1 = (Polygon2)var0.nextElement();
         if (h.contains(var1)) {
            h.remove(var1);
         }
      }
   }

   protected static Edge find_broken_edge() {
      for (int var1 = 0; var1 < h.n_edges; var1++) {
         Edge var0 = h.edges[var1];
         if (var0.left_polygon() == null && var0.right_polygon() == null) {
            System.out.println("edge without polygons (Cutting.find_broken_edge())");
         }

         if (var0.left_polygon() == null || var0.right_polygon() == null) {
            return var0;
         }
      }

      System.out.println("no broken edge (Cutting.find_broken_edge())");
      return null;
   }

   public static void divide_knot_polygon(Polygon2 var0, Vertex var1, Edge var2, LinkedList var3, Vertex var4, Edge var5, LinkedList var6) {
      LinkedList var7 = var6.reverse();
      LinkedList var8 = var3.copy();
      var8.connect(var7.cdr());
      System.out.println("divide knot polygon--");
      Modify.PolygonReplace var9 = polygon_replace_manager.replaced(var0);
      if (var9 != null) {
         var0 = polygon_replace_manager.get_corresponding_polygon(var9, var1);
         var2 = find_corresponding_edge(var0, var2);
         var5 = find_corresponding_edge(var0, var5);
      }

      if (!var0.contains(var2)) {
         var2 = polygon_replace_manager.get_parent_edge(var2);
         System.out.println("head_edge not contained");
      }

      if (!var0.contains(var5)) {
         var5 = polygon_replace_manager.get_parent_edge(var5);
         System.out.println("tail_edge not contained");
      }

      divide_a_polygon(var0, var8, var1, var2, var4, var5);
   }

   public static Edge find_corresponding_edge(Polygon2 var0, Edge var1) {
      for (int var2 = 0; var2 < var0.n_edges; var2++) {
         Edge var3 = var0.edges[var2];
         if (var1.on_edge(var3.start) && var1.on_edge(var3.end)) {
            return var3;
         }
      }

      System.out.print("no corresponding edge (Cutting.find_corresponding_edge)");
      return null;
   }

   public static void init(Polyhedron var0) {
      h = var0;
      temp_polygons = new LinkedList();
      polygon_replace_manager = new Modify().new PolygonReplaceManager(new Modify());
   }

   public static void divide_a_polygon(Polygon2 var0, LinkedList var1, Vertex var2, Edge var3, Vertex var4, Edge var5) {
      LinkedList var7 = new LinkedList();
      Enumeration var8 = var1.elements();
      Vertex var9 = (Vertex)var8.nextElement();

      for (int var11 = 0; var11 < var1.size() - 2; var11++) {
         Vertex var10 = (Vertex)var8.nextElement();
         h.append(var10);
         Edge var6 = new Edge(var9, var10);
         var7.append(var6);
         h.append(var6);
         var6.set_sharp(section_is_sharp);
         var9 = var10;
      }

      Vertex var16 = (Vertex)var1.tail();
      Edge var15 = new Edge(var9, var16);
      var7.append(var15);
      h.append(var15);
      var15.set_sharp(section_is_sharp);
      LinkedList var17 = new LinkedList();
      LinkedList var12 = new LinkedList();
      if (var3 == var5) {
         Vertex var13 = var0.get_vertex(var0.get_edge_index(var3));
         if (Vector3.distance(var13, var2) < Vector3.distance(var13, var4)) {
            var17.append(h.get_edge_array(var2, var4));
            var12 = divide_a_polygon_around(var0, var4, var5, var2, var3);
            polygon_replace_manager.edge_replaced(var3, (Edge)var12.tail(), (Edge)var17.head(), (Edge)var12.head());
         } else {
            var12.append(h.get_edge_array(var4, var2));
            var17 = divide_a_polygon_around(var0, var2, var3, var4, var5);
            polygon_replace_manager.edge_replaced(var3, (Edge)var17.tail(), (Edge)var12.head(), (Edge)var17.head());
         }
      } else {
         var17 = divide_a_polygon_around(var0, var2, var3, var4, var5);
         var12 = divide_a_polygon_around(var0, var4, var5, var2, var3);
         polygon_replace_manager.edge_replaced(var3, (Edge)var12.tail(), (Edge)var17.head());
         polygon_replace_manager.edge_replaced(var5, (Edge)var17.tail(), (Edge)var12.head());
      }

      var17.connect(var7.reverse());
      Polygon2 var18 = new Polygon2(var17);
      h.append(var18);
      var12.connect(var7);
      Polygon2 var14 = new Polygon2(var12);
      h.append(var14);
      temp_polygons.append(var14);
      polygon_replace_manager.polygon_replaced(var0, var18, var14);
      if (h.contains(var0)) {
         h.remove(var0);
      }
   }

   class EdgeReplace {
      Edge parent;
      Edge child0;
      Edge child1;
      Edge child2;

      EdgeReplace(Modify var1, Edge var2, Edge var3, Edge var4) {
         (this.this$0 = var1).getClass();
         this.parent = var2;
         this.child0 = var3;
         this.child1 = var4;
         this.child2 = null;
      }

      EdgeReplace(Modify var1, Edge var2, Edge var3, Edge var4, Edge var5) {
         (this.this$0 = var1).getClass();
         this.parent = var2;
         this.child0 = var3;
         this.child1 = var4;
         this.child2 = var5;
      }

      public boolean is_child(Edge var1) {
         return var1 == this.child0 || var1 == this.child1 || var1 == this.child2;
      }
   }

   class PolygonReplace {
      Polygon2 parent;
      Polygon2 child0;
      Polygon2 child1;

      PolygonReplace(Modify var1, Polygon2 var2, Polygon2 var3, Polygon2 var4) {
         (this.this$0 = var1).getClass();
         this.parent = var2;
         this.child0 = var3;
         this.child1 = var4;
      }
   }

   class PolygonReplaceManager {
      protected LinkedList polygon_replace_list;
      protected LinkedList edge_replace_list;

      public void edge_replaced(Edge var1, Edge var2, Edge var3) {
         this.edge_replace_list.append(this.this$0.new EdgeReplace(this.this$0, var1, var2, var3));
      }

      public void edge_replaced(Edge var1, Edge var2, Edge var3, Edge var4) {
         this.edge_replace_list.append(this.this$0.new EdgeReplace(this.this$0, var1, var2, var3, var4));
      }

      PolygonReplaceManager(Modify var1) {
         (this.this$0 = var1).getClass();
         this.polygon_replace_list = new LinkedList();
         this.edge_replace_list = new LinkedList();
      }

      public Polygon2 get_corresponding_polygon(Modify.PolygonReplace var1, Vertex var2) {
         Polygon2 var3;
         if (var1.child0.on_polygon(var2)) {
            var3 = var1.child0;
         } else {
            var3 = var1.child1;
         }

         var1 = this.replaced(var3);
         return var1 == null ? var3 : this.get_corresponding_polygon(var1, var2);
      }

      public Edge get_parent_edge(Edge var1) {
         Enumeration var2 = this.edge_replace_list.elements();

         while (var2.hasMoreElements()) {
            Modify.EdgeReplace var3 = (Modify.EdgeReplace)var2.nextElement();
            if (var3.is_child(var1)) {
               return var3.parent;
            }
         }

         System.out.println("no parent (Cutting.get_parent_replace)");
         return var1;
      }

      public void polygon_replaced(Polygon2 var1, Polygon2 var2, Polygon2 var3) {
         this.polygon_replace_list.append(this.this$0.new PolygonReplace(this.this$0, var1, var2, var3));
      }

      public Edge get_corresponding_edge(Edge var1, Vertex var2) {
         Modify.EdgeReplace var3 = null;
         Enumeration var4 = this.edge_replace_list.elements();

         while (var4.hasMoreElements()) {
            Modify.EdgeReplace var5 = (Modify.EdgeReplace)var4.nextElement();
            if (var5.parent == var1) {
               var3 = var5;
               break;
            }
         }

         if (var3 == null) {
            return var1;
         } else {
            Edge var6 = null;
            if (var3.child0.on_edge(var2)) {
               var6 = var3.child0;
            } else if (var3.child1.on_edge(var2)) {
               var6 = var3.child1;
            } else if (var3.child2.on_edge(var2)) {
               var6 = var3.child2;
            } else {
               System.out.println("no corresponding edge (Cutting.get_corresponding_edge)");
            }

            return this.get_corresponding_edge(var6, var2);
         }
      }

      public Modify.PolygonReplace replaced(Polygon2 var1) {
         Enumeration var2 = this.polygon_replace_list.elements();

         while (var2.hasMoreElements()) {
            Modify.PolygonReplace var3 = (Modify.PolygonReplace)var2.nextElement();
            if (var3.parent == var1) {
               return var3;
            }
         }

         return null;
      }
   }
}
