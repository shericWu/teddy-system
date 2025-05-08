package teddy;

import java.awt.Point;
import java.util.Enumeration;

class SkVertex2D extends Vertex2D {
   double height;
   LinkedList edges = null;

   SkVertex2D(Point var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   SkVertex2D(Vertex2D var1) {
      super.x = var1.x;
      super.y = var1.y;
   }

   SkVertex2D(double var1, double var3) {
      super.x = var1;
      super.y = var3;
   }

   public void remove_owner(SkEdge2D var1) {
      this.edges.remove(var1);
   }

   public void add_owner(SkEdge2D var1) {
      if (this.edges == null) {
         this.edges = new LinkedList();
      }

      this.edges.append(var1);
   }

   public LinkedList get_not_shared_edges() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         SkEdge2D var3 = (SkEdge2D)var2.nextElement();
         if (var3.type == 1) {
            var1.append(var3);
         }
      }

      return var1;
   }
}
