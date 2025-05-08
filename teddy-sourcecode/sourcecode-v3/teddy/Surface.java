package teddy;

class Surface {
   public Vertex base;
   public Vector3 normal;

   public Vertex cross_point(Edge var1) {
      double var2 = this.signed_distance(var1.start);
      double var4 = this.signed_distance(var1.end);
      double var6 = var2 - var4;
      return new Vertex(var1.start.add(var1.vector3().multiple(var2 / var6)));
   }

   Surface() {
      this.base = new Vertex();
      this.normal = new Vector3();
   }

   Surface(Vertex var1, Vector3 var2) {
      this.base = var1;
      this.normal = var2;
      this.normal.normalize();
   }

   Surface(Vertex var1, Vertex var2, Vertex var3) {
      Vector3 var4 = new Vector3(var1, var2);
      Vector3 var5 = new Vector3(var1, var3);
      this.normal = var4.cross_product(var5);
      this.base = var1;
      this.normal.normalize();
   }

   public double angle(Vector3 var1) {
      double var2 = this.normal.get_relative_angle(var1);
      return Math.abs(var2 - (Math.PI / 2));
   }

   public static Surface get_normal_surface(Vertex var0, Vertex var1, Vertex var2) {
      Vector3 var3 = new Vector3(var0, var1);
      Vector3 var4 = new Vector3(var1, var2);
      var3.normalize();
      var4.normalize();
      return new Surface(var1, var3.add(var4));
   }

   public double signed_distance(Vertex var1) {
      Vector3 var2 = new Vector3(this.base, var1);
      return this.normal.dot_product(var2);
   }

   public double distance(Vertex var1) {
      Vector3 var2 = new Vector3(this.base, var1);
      return Math.abs(this.normal.dot_product(var2));
   }
}
