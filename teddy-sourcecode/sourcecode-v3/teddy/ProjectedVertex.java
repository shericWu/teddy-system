package teddy;

import java.util.Enumeration;

class ProjectedVertex extends Vertex2D {
   public LinkedList edges;
   int QI;
   Vertex original;
   private static int eye_z = 10;
   public ProjectedEdge front_silhouette_edge;
   public ProjectedEdge back_silhouette_edge;

   public int cusp() {
      int var1 = 0;
      int var2 = 0;
      Enumeration var3 = this.edges.elements();

      while (var3.hasMoreElements()) {
         ProjectedEdge var4 = (ProjectedEdge)var3.nextElement();
         if (var4.type == 2) {
            var1++;
            this.front_silhouette_edge = var4;
         } else if (var4.type == 1) {
            var2++;
            this.back_silhouette_edge = var4;
         }
      }

      return var1 >= 1 && var2 >= 1 ? var1 + var2 : 0;
   }

   ProjectedVertex(Vertex var1) {
      super.x = Draw3DScene.project_x(var1);
      super.y = Draw3DScene.project_y(var1);
      this.edges = new LinkedList();
      this.QI = -1;
      this.original = var1;
   }

   ProjectedVertex(Vertex2D var1) {
      super.x = var1.x;
      super.y = var1.y;
   }
}
