package teddy;

class TrEdge extends Edge2D {
   public Triangle left_triangle = null;
   public Triangle right_triangle = null;
   public boolean destroyed = false;
   public boolean external = false;
   public Edge original;

   TrEdge(TrVertex var1, TrVertex var2) {
      super.start = var1;
      super.end = var2;
      ((TrVertex)super.start).edges.addElement(this);
      ((TrVertex)super.end).edges.addElement(this);
   }

   TrEdge(TrVertex var1, TrVertex var2, boolean var3) {
      this(var1, var2);
      this.external = var3;
   }

   public TrVertex get_common_vertex(TrEdge var1) {
      if (var1.contains(super.start)) {
         return (TrVertex)super.start;
      } else {
         return var1.contains(super.end) ? (TrVertex)super.end : null;
      }
   }

   public void destroy() {
      ((TrVertex)super.start).remove_edge(this);
      ((TrVertex)super.end).remove_edge(this);
      Trianglation2D.edges.removeElement(this);
      this.destroyed = true;
   }

   public boolean contains(TrVertex var1) {
      return super.start == var1 || super.end == var1;
   }

   public void remove_triangle(Triangle var1) {
      if (this.left_triangle == var1) {
         this.left_triangle = null;
      }

      if (this.right_triangle == var1) {
         this.right_triangle = null;
      }

      if (this.right_triangle == null && this.left_triangle == null) {
         this.destroy();
      }
   }
}
