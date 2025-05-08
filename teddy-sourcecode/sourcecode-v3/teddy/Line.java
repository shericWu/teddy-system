package teddy;

class Line {
   public Vertex base;
   public Vector3 direction;

   Line() {
      this.base = new Vertex();
      this.direction = new Vector3();
   }

   Line(Vertex var1, Vector3 var2) {
      this.base = var1;
      this.direction = var2;
      this.direction.normalize();
   }

   public Vertex get_foot(Vertex var1) {
      double var2 = var1.add(this.base.reverse()).dot_product(this.direction);
      return this.base.shift(this.direction.multiple(var2));
   }
}
