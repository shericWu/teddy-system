package teddy;

import java.awt.Point;
import java.util.Vector;

class TrVertex extends Vertex2D {
   public Vector edges = new Vector();
   public boolean external = false;
   public Vertex original = null;
   public double height;

   public TrEdge find_opposite_edge(TrEdge var1, Vector var2) {
      Vertex2D var3 = var1.mid_point();
      Vector2 var4 = new Vector2(var3, this);

      for (int var5 = 0; var5 < var2.size(); var5++) {
         TrEdge var6 = (TrEdge)var2.elementAt(var5);
         Vector2 var7 = new Vector2(var3, var6.start);
         Vector2 var8 = new Vector2(var3, var6.end);
         if (var6 != var1
            && var4.dot_product(var8) > 0.0
            && var7.cross_product(var8) < 0.0
            && var4.cross_product(var7) * var4.cross_product(var8) <= 0.0
            && var4.length() < var7.length()) {
            return var6;
         }
      }

      System.out.println("Error in Trianglation2D.find_opposite_edge");
      return null;
   }

   TrVertex(Point var1, boolean var2) {
      super.x = var1.x;
      super.y = var1.y;
      this.external = var2;
   }

   TrVertex(Vertex var1, boolean var2, Vertex var3) {
      this.original = var3;
      super.x = var1.x;
      super.y = var1.y;
      this.height = var1.z;
      this.external = var2;
   }

   TrVertex(Vertex2D var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   public void destroy() {
   }

   public void set_height(Vector var1) {
      this.height = 0.0;
      double var2 = 0.0;

      for (int var4 = 0; var4 < var1.size(); var4++) {
         TrVertex var5 = (TrVertex)var1.elementAt(var4);
         double var6 = Vector2.distance(this, var5);
         this.height = this.height + var6 * var5.height;
         var2 += var6;
      }

      this.height /= var2;
   }

   public boolean edge_is_clockwise(TrEdge var1) {
      Vector2 var2 = new Vector2(this, var1.start);
      Vector2 var3 = new Vector2(this, var1.end);
      return var2.cross_product(var3) < 0.0;
   }

   public void set_height_slope(Vector var1, CoordSystem var2) {
      Vector var3 = new Vector();

      for (int var6 = 0; var6 < var1.size(); var6++) {
         TrVertex var4 = (TrVertex)var1.elementAt(var6);
         TrVertex var5;
         if (var6 < var1.size() - 1) {
            var5 = (TrVertex)var1.elementAt(var6 + 1);
         } else {
            var5 = (TrVertex)var1.elementAt(0);
         }

         TrEdge var7 = var4.shared_edge(var5);
         var7.original = var4.original.get_shared_edge(var5.original);
         var3.addElement(var7);
      }

      this.height = 0.0;
      double var14 = 0.0;

      for (int var8 = 0; var8 < var3.size(); var8++) {
         TrEdge var9 = (TrEdge)var3.elementAt(var8);
         if (this.edge_is_clockwise(var9)) {
            double var10 = this.set_height_slope_sub(var9, var3, var2);
            double var12 = 1.0 / Vector2.distance(var9.mid_point(), this);
            if (var10 != 0.0) {
               var12 *= var12;
               this.height += var10 * var12;
               var14 += var12;
            }
         }
      }

      this.height /= var14;
   }

   public TrEdge shared_edge(TrVertex var1) {
      for (int var2 = 0; var2 < this.edges.size(); var2++) {
         TrEdge var3 = (TrEdge)this.edges.elementAt(var2);
         if (var3.contains(var1)) {
            return var3;
         }
      }

      return null;
   }

   public void remove_edge(TrEdge var1) {
      this.edges.removeElement(var1);
      if (this.edges.size() == 0) {
      }

      this.destroy();
   }

   public double set_height_slope_sub(TrEdge var1, Vector var2, CoordSystem var3) {
      Edge var4 = var1.original;
      Vertex var5 = var4.mid_vertex();
      TrEdge var6 = this.find_opposite_edge(var1, var2);
      if (var6 == null) {
         return 0.0;
      } else {
         Edge var7 = var6.original;
         double var8 = var3.translate(var5).z;
         this.original = var3.reverse_translate(super.x, super.y, var8);
         Vector3 var10 = var3.base_z.cross_product(new Vector3(var5, this.original));
         Surface var11 = new Surface(var5, var10);
         Vertex var12 = var11.cross_point(var7);
         Vector3 var13;
         if (var4.left_polygon != null) {
            var13 = var4.vector3().cross_product(var4.left_polygon.calc_normal());
         } else {
            var13 = var4.vector3().reverse().cross_product(var4.right_polygon.calc_normal());
         }

         var13.normalize();
         Vector3 var14;
         if (var7.left_polygon != null) {
            var14 = var7.vector3().cross_product(var7.left_polygon.calc_normal());
         } else {
            var14 = var7.vector3().reverse().cross_product(var7.right_polygon.calc_normal());
         }

         var14.normalize();
         Vector3 var15 = var3.base_z;
         Vector3 var16 = new Vector3(var5, var12);
         Vector3 var17 = var16.cross_product(var15).get_normalized();
         var16 = var15.cross_product(var17).get_normalized();
         CoordSystem var18 = new CoordSystem(var16, var15, var17);
         Vertex var19 = var18.translate(this.original);
         Vertex var20 = var18.translate(var5);
         Vertex var21 = var18.translate(var12);
         Vector2 var22 = new Vector2(var18.translate(var13));
         Vector2 var23 = new Vector2(var18.translate(var14));
         double var24 = Vector2.distance(var20.x, var20.y, var21.x, var21.y);
         var22 = var22.get_normalized().multiple(var24 * 1.5);
         var23 = var23.get_normalized().multiple(var24);
         double var26 = 2.0 * var20.x - 2.0 * var21.x + var22.x - var23.x;
         double var28 = -3.0 * var20.x + 3.0 * var21.x - 2.0 * var22.x + var23.x;
         double var30 = var22.x;
         double var32 = var20.x;
         double var34 = 2.0 * var20.y - 2.0 * var21.y + var22.y - var23.y;
         double var36 = -3.0 * var20.y + 3.0 * var21.y - 2.0 * var22.y + var23.y;
         double var38 = var22.y;
         double var40 = var20.y;
         double var42 = (var19.x - var20.x) / (var21.x - var20.x);
         if (var42 < 0.0 || var42 > 1.0) {
            System.out.println("Strange t (Trianglation2D.set_height_slope_sub())" + var42);
            var42 = 0.5;
         }

         return var34 * var42 * var42 * var42 + var36 * var42 * var42 + var38 * var42 + var40;
      }
   }
}
