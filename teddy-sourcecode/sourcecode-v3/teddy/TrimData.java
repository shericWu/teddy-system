package teddy;

import java.util.Enumeration;

class TrimData {
   public LinkedList terminal_edges;
   public LinkedList terminal_vertices = new LinkedList();

   public void merge(TrimData var1) {
      this.terminal_vertices.connect(var1.terminal_vertices);
      this.terminal_edges.connect(var1.terminal_edges);
   }

   public void append_terminal_edge(SkEdge2D var1) {
      this.terminal_edges.append(var1);
   }

   TrimData() {
      this.terminal_edges = new LinkedList();
   }

   TrimData(SkVertex2D var1, LinkedList var2) {
      this.terminal_vertices.append(var1);
      this.terminal_edges = var2;
   }

   public boolean terminals_are_within_this_circle(SkEdge2D var1) {
      Enumeration var2 = this.terminal_vertices.elements();

      while (var2.hasMoreElements()) {
         SkVertex2D var3 = (SkVertex2D)var2.nextElement();
         if (var1.out_of_circle(var3)) {
            return false;
         }
      }

      return true;
   }
}
