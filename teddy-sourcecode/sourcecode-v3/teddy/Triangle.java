package teddy;

import java.util.Vector;

class Triangle {
   Vector edges = new Vector();
   public boolean destroyed = false;

   private void add_edge(TrVertex var1, TrVertex var2) {
      TrEdge var3 = var1.shared_edge(var2);
      if (var3 == null) {
         var3 = new TrEdge(var1, var2);
         Trianglation2D.edges.addElement(var3);
      }

      if (var3.start == var1) {
         var3.left_triangle = this;
      } else {
         var3.right_triangle = this;
      }

      this.edges.addElement(var3);
   }

   Triangle(TrVertex var1, TrVertex var2, TrVertex var3) {
      this.add_edge(var1, var2);
      this.add_edge(var2, var3);
      this.add_edge(var3, var1);
   }

   public TrVertex get_opposite_vertex(TrEdge var1) {
      int var2 = 0;

      while (this.edges(var2) != var1) {
         if (++var2 >= 3) {
            return null;
         }
      }

      return this.edges(var2 + 1).get_common_vertex(this.edges(var2 + 2));
   }

   public void destroy() {
      int var1 = 0;

      do {
         this.edges(var1).remove_triangle(this);
      } while (++var1 < 3);

      Trianglation2D.triangles.removeElement(this);
      this.destroyed = true;
   }

   public TrEdge edges(int var1) {
      if (var1 >= this.edges.size()) {
         var1 -= var1 / this.edges.size() * this.edges.size();
      }

      if (var1 < 0) {
         var1 += (-var1 / this.edges.size() + 1) * this.edges.size();
      }

      return (TrEdge)this.edges.elementAt(var1);
   }

   public LinkedList original_edges() {
      LinkedList var1 = new LinkedList();
      int var2 = 0;

      do {
         var1.append(this.edges(var2).original);
      } while (++var2 < 3);

      return var1;
   }
}
