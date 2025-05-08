package teddy;

public class Node {
   public double x;
   public double y;

   public static double distance(Node var0, Node var1) {
      return Math.sqrt((var0.x - var1.x) * (var0.x - var1.x) + (var0.y - var1.y) * (var0.y - var1.y));
   }

   public boolean same(Node var1) {
      return Def.equal(var1.x, this.x) && Def.equal(var1.y, this.y);
   }

   Node(double var1, double var3) {
      this.x = var1;
      this.y = var3;
   }

   public double distance(Node var1) {
      return Math.sqrt((var1.x - this.x) * (var1.x - this.x) + (var1.y - this.y) * (var1.y - this.y));
   }
}
