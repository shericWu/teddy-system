package teddy;

public class Test {
   public static void main(String[] var0) {
      Vertex2D var1 = new Vertex2D(0.0, 0.0);
      Vertex2D var2 = new Vertex2D(1.0, 0.0);
      Vertex2D var3 = new Vertex2D(0.0, 0.0);
      Vertex2D var4 = new Vertex2D(0.0, 1.0);
      Edge2D var5 = new Edge2D(var1, var2);
      Edge2D var6 = new Edge2D(var3, var4);
      Vertex var7 = new Vertex(3.0, 4.0, 5.0);
      Vertex var8 = Bend.warp_for_an_edge(var5, var6, var7);
      System.out.println(var8.toString());
   }
}
