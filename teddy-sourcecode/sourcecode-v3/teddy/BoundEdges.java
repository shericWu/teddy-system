package teddy;

class BoundEdges {
   public ProjectedEdge left;
   public ProjectedEdge right;
   public ProjectedEdge top;
   public ProjectedEdge bottom;
   public double left_bound;
   public double right_bound;
   public double top_bound;
   public double bottom_bound;

   BoundEdges(ProjectedEdge var1) {
      this.left = var1;
      this.right = var1;
      this.top = var1;
      this.bottom = var1;
      this.left_bound = var1.left();
      this.right_bound = var1.right();
      this.top_bound = var1.top();
      this.bottom_bound = var1.bottom();
   }

   void check(ProjectedEdge var1) {
      if (this.left_bound > var1.left()) {
         this.left_bound = var1.left();
         this.left = var1;
      }

      if (this.right_bound < var1.right()) {
         this.right_bound = var1.right();
         this.right = var1;
      }

      if (this.top_bound > var1.top()) {
         this.top_bound = var1.top();
         this.top = var1;
      }

      if (this.bottom_bound < var1.bottom()) {
         this.bottom_bound = var1.bottom();
         this.bottom = var1;
      }
   }
}
