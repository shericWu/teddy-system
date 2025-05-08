package teddy;

import java.awt.Point;
import java.util.Enumeration;

class Generate {
   public static Teddy teddy;
   private static Polyhedron h;

   public static LinkedList normalize_Vertex2D_list(LinkedList var0) {
      double var1 = 0.0;
      Enumeration var3 = var0.elements();
      Vertex2D var4 = (Vertex2D)var3.nextElement();

      while (var3.hasMoreElements()) {
         Vertex2D var5 = (Vertex2D)var3.nextElement();
         var1 += Vector2.distance(var4, var5);
         var4 = var5;
      }

      int var6 = (int)(var1 / Def.NORMALIZED_EDGE_LENGTH);
      if (var6 < 8) {
         var6 = 8;
      }

      double var7 = var1 / var6;
      LinkedList var9 = new LinkedList();
      var3 = var0.elements();
      var4 = (Vertex2D)var3.nextElement();
      var9.append(var4);
      double var10 = 0.0;

      while (var3.hasMoreElements()) {
         Vertex2D var16 = (Vertex2D)var3.nextElement();
         double var12 = Vector2.distance(var4, var16);
         var10 += var12;

         while (var10 >= var7) {
            var10 -= var7;
            var9.append(Vector2.interporate(var16, var4, var10 / var12).vertex2D());
            if (var9.size() == var6 - 1) {
               break;
            }
         }

         if (var9.size() == var6 - 1) {
            break;
         }

         var4 = var16;
      }

      var9.append(var0.tail());
      return var9;
   }

   public static LinkedList reduce_Vertex2D_list(LinkedList var0, boolean var1) {
      LinkedList var2 = new LinkedList();
      Enumeration var3 = var0.elements();
      Vertex2D var4 = (Vertex2D)var3.nextElement();
      var2.append(var4);
      Vertex2D var5 = (Vertex2D)var3.nextElement();
      Vertex2D var6 = null;
      Vector2 var7 = null;

      for (Object var8 = null; var3.hasMoreElements(); var5 = var6) {
         double var9 = 0.0;
         double var11 = 0.0;
         var7 = new Vector2(var4, var5);

         while (var3.hasMoreElements()) {
            var6 = (Vertex2D)var3.nextElement();
            var8 = new Vector2(var5, var6);
            var9 += var7.get_relative_angle((Vector2)var8);
            var11 += var7.length();
            if (var9 > 0.2 || var1 && var11 > Def.MAXIMUM_EDGE_LENGTH) {
               var2.append(var5);
               break;
            }

            var5 = var6;
            var7 = (Vector2)var8;
         }

         if (!var3.hasMoreElements()) {
            break;
         }

         var4 = var5;
      }

      var2.append(var0.tail());
      return var2;
   }

   public static Segment get_segment(Vertex2D var0, Vertex2D var1) {
      double var2 = DrawPanel.rcX((int)var0.x);
      double var4 = DrawPanel.rcY((int)var0.y);
      double var6 = DrawPanel.rcX((int)var1.x);
      double var8 = DrawPanel.rcY((int)var1.y);
      return new Segment(var2, var4, var6, var8);
   }

   public static Segment get_segment(Edge2D var0) {
      return get_segment(var0.start, var0.end);
   }

   private static LinkedList normalize_Point_list_sub(LinkedList var0, int var1, double var2) {
      LinkedList var7 = new LinkedList();
      Enumeration var4 = var0.elements();
      Point var5 = (Point)var4.nextElement();
      var7.append(var5);
      double var8 = 0.0;

      while (var4.hasMoreElements()) {
         Point var6 = (Point)var4.nextElement();
         double var10 = Vector2.distance(var5.x, var5.y, var6.x, var6.y);
         var8 += var10;

         while (var8 >= var2) {
            var8 -= var2;
            var7.append(Vector2.interporate(var6, var5, var8 / var10).point());
            if (var7.size() == var1 - 1) {
               break;
            }
         }

         if (var7.size() == var1 - 1) {
            break;
         }

         var5 = var6;
      }

      var7.append(var0.tail());
      return var7;
   }

   public static Polyhedron generate(LinkedList var0) {
      Teddy.teddy.play_sound("generate.au");
      var0.remove(var0.head());
      var0.remove(var0.tail());
      var0.append(var0.head());
      var0 = normalize_Point_list(var0, Def.NORMALIZED_STROKE_LENGTH_NEW);
      var0 = reduce_Point_list(var0);
      var0 = counter_clockwise(var0);
      return Skeleton.generate_polyhedron(var0);
   }

   public static Scene get_boundary(LinkedList var0) {
      Scene var1 = new Scene();
      var0.reverse();
      Enumeration var10 = var0.elements();
      Point var11 = (Point)var10.nextElement();

      while (var10.hasMoreElements()) {
         Point var12 = (Point)var10.nextElement();
         double var2 = DrawPanel.rcX(var11.x);
         double var4 = DrawPanel.rcY(var11.y);
         double var6 = DrawPanel.rcX(var12.x);
         double var8 = DrawPanel.rcY(var12.y);
         var1.append(new Segment(var2, var4, var6, var8));
         var11 = var12;
      }

      return var1;
   }

   public static Scene pop_test(LinkedList var0) {
      Scene var1 = new Scene();
      LinkedList var2 = var0.reverse();
      Enumeration var11 = var0.elements();
      Enumeration var12 = var2.elements();
      Point var13 = (Point)var11.nextElement();
      Point var14 = (Point)var11.nextElement();
      Point var15 = (Point)var11.nextElement();
      Point var16 = (Point)var12.nextElement();
      Point var17 = (Point)var12.nextElement();
      Point var18 = (Point)var12.nextElement();

      while (true) {
         double var3 = DrawPanel.rcX(var13.x);
         double var5 = DrawPanel.rcY(var13.y);
         double var7 = DrawPanel.rcX(var16.x);
         double var9 = DrawPanel.rcY(var16.y);
         var1.append(new Segment(var3, var5, var7, var9));
         if (var14 == var17 || var14 == var16) {
            return var1;
         }

         Vector2 var19 = new Vector2(var13, var14).normalize();
         Vector2 var20 = new Vector2(var14, var15).normalize();
         Vector2 var21 = new Vector2(var16, var17).normalize();
         Vector2 var22 = new Vector2(var17, var18).normalize();
         var19.add(var22);
         var20.add(var21);
         var20.add(var22);
         Vector2 var23 = new Vector2(var13, var17);
         Vector2 var24 = new Vector2(var14, var16);
         Vector2 var25 = new Vector2(var14, var17);
         double var26 = Math.max(Math.abs(var23.cos(var19)), Math.abs(var23.cos(var22)));
         double var28 = Math.max(Math.abs(var24.cos(var20)), Math.abs(var24.cos(var21)));
         double var30 = Math.max(Math.abs(var25.cos(var20)), Math.abs(var25.cos(var22)));
         if (var26 <= var28 && var26 <= var30) {
            var16 = var17;
            var17 = var18;
            var18 = (Point)var12.nextElement();
         } else if (var28 <= var26 && var28 <= var30) {
            var13 = var14;
            var14 = var15;
            var15 = (Point)var11.nextElement();
         } else {
            var13 = var14;
            var14 = var15;
            var15 = (Point)var11.nextElement();
            var16 = var17;
            var17 = var18;
            var18 = (Point)var12.nextElement();
         }
      }
   }

   public static LinkedList renumber_Point_list(int var0, LinkedList var1) {
      double var2 = calculate_stroke_length(var1);
      double var4 = var2 / var0;
      return normalize_Point_list_sub(var1, var0, var4);
   }

   public static LinkedList reduce_Vertex_list(LinkedList var0) {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = var0.elements();
      Vertex var3 = (Vertex)var2.nextElement();
      var1.append(var3);
      Vertex var4 = (Vertex)var2.nextElement();
      Vertex var5 = null;
      Vector3 var6 = null;
      Object var7 = null;

      for (int var8 = 0; var2.hasMoreElements(); var4 = var5) {
         double var9 = 0.0;
         double var11 = 0.0;
         var6 = new Vector3(var3, var4);
         var8 = 0;

         while (var2.hasMoreElements()) {
            var5 = (Vertex)var2.nextElement();
            var7 = new Vector3(var4, var5);
            var9 += var6.get_relative_angle((Vector3)var7);
            var11 += var6.length();
            if (var9 > 0.2 || var8 > 2) {
               var1.append(var4);
               break;
            }

            var8++;
            var4 = var5;
            var6 = (Vector3)var7;
         }

         if (!var2.hasMoreElements()) {
            break;
         }

         var3 = var4;
      }

      var1.append(var0.tail());
      return var1;
   }

   public static Scene skeleton_test(LinkedList var0) {
      Scene var1 = new Scene();
      LinkedList var2 = Skeleton.get_skeleton_edges(var0);
      Enumeration var3 = var2.elements();

      while (var3.hasMoreElements()) {
         Edge2D var4 = (Edge2D)var3.nextElement();
         add_segment(var1, var4.start, var4.end);
      }

      return var1;
   }

   public static Scene generate_scene(LinkedList var0) {
      var0.append(var0.head());
      var0 = normalize_Point_list(var0, Def.NORMALIZED_STROKE_LENGTH_NEW);
      var0 = reduce_Point_list(var0);
      return skeleton_test(var0);
   }

   public static void add_segment(Scene var0, Vertex2D var1, Vertex2D var2) {
      var0.append(get_segment(var1, var2));
   }

   public static double calculate_stroke_length(LinkedList var0) {
      double var1 = 0.0;
      Enumeration var3 = var0.elements();
      Point var4 = (Point)var3.nextElement();

      while (var3.hasMoreElements()) {
         Point var5 = (Point)var3.nextElement();
         var1 += Math.sqrt((var5.x - var4.x) * (var5.x - var4.x) + (var5.y - var4.y) * (var5.y - var4.y));
         var4 = var5;
      }

      return var1;
   }

   public static LinkedList counter_clockwise(LinkedList var0) {
      double var1 = 0.0;
      Enumeration var3 = var0.elements();
      Point var4 = (Point)var3.nextElement();

      while (var3.hasMoreElements()) {
         Point var5 = (Point)var3.nextElement();
         var1 += (var4.y + var5.y) * (var5.x - var4.x);
         var4 = var5;
      }

      if (var0.tail() != var0.head()) {
         System.out.println(var1);
      }

      return var1 < 0.0 ? var0.reverse() : var0;
   }

   public static LinkedList normalize_Point_list(LinkedList var0, int var1) {
      double var2 = calculate_stroke_length(var0);
      int var4 = (int)(var2 / var1);
      if (var4 < 8) {
         var4 = 8;
      }

      double var5 = var2 / var4;
      return normalize_Point_list_sub(var0, var4, var5);
   }

   public static LinkedList reduce_Point_list(LinkedList var0) {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = var0.elements();
      Point var3 = (Point)var2.nextElement();
      var1.append(var3);
      Point var4 = (Point)var2.nextElement();
      Point var5 = null;
      Vector2 var6 = null;

      for (Object var7 = null; var2.hasMoreElements(); var4 = var5) {
         double var8 = 0.0;
         double var10 = 0.0;
         var6 = new Vector2(var3, var4);

         while (var2.hasMoreElements()) {
            var5 = (Point)var2.nextElement();
            var7 = new Vector2(var4, var5);
            var8 += var6.get_relative_angle((Vector2)var7);
            var10 += var6.length();
            if (var8 > 0.2 || var10 > Def.MAXIMUM_STROKE_LENGTH) {
               var1.append(var4);
               break;
            }

            var4 = var5;
            var6 = (Vector2)var7;
         }

         if (!var2.hasMoreElements()) {
            break;
         }

         var3 = var4;
      }

      var1.append(var0.tail());
      return var1;
   }
}
