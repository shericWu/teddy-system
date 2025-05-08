package teddy;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Graphics2 {
   static void addPoint(Polygon var0, Point var1, Vector2 var2) {
      var0.addPoint((int)(var1.x + var2.x), (int)(var1.y + var2.y));
   }

   public static void drawLine(Graphics var0, int var1, int var2, int var3, int var4) {
      drawWideLine(var0, var1, var2, var3, var4, 4.0);
   }

   public static void drawRandomLine(Graphics var0, int var1, int var2, int var3, int var4) {
      Vector2 var5 = new Vector2(var3 - var1, var4 - var2);
      Vector2 var6 = var5.rotate(Math.random() * 60.0 - 30.0).scale(Math.random() * 0.2);
      Vector2 var7 = var6.rotate(180.0);
      int var8 = var1 + (int)var7.x;
      int var9 = var2 + (int)var7.y;
      int var10 = var3 + (int)var6.x;
      int var11 = var4 + (int)var6.y;
      var0.drawLine(var8, var9, var10, var11);
   }

   public static void drawWideCircle(Graphics var0, int var1, int var2, int var3, int var4) {
      for (int var5 = var3 - var4 / 2; var5 < var3 + var4 / 2; var5++) {
         var0.drawOval(var1 - var5, var2 - var5, var5 * 2 - 1, var5 * 2 - 1);
      }
   }

   public static void drawWideLine(Graphics var0, double var1, double var3, double var5, double var7, double var9) {
      drawWideLine(var0, (int)var1, (int)var3, (int)var5, (int)var7, var9);
   }

   public static void drawWideLine(Graphics var0, int var1, int var2, int var3, int var4, double var5) {
      int var7 = var3 - var1;
      int var8 = var4 - var2;
      double var9 = Math.sqrt(var7 * var7 + var8 * var8);
      double var11 = var7 / var9 * var5 / 2.0;
      double var13 = var8 / var9 * var5 / 2.0;
      Point var15 = new Point(var1, var2);
      Point var16 = new Point(var3, var4);
      Vector2 var17 = new Vector2(var11, var13);
      Polygon var18 = new Polygon();
      addPoint(var18, var15, var17.rotate(90.0));
      addPoint(var18, var15, var17.rotate(135.0));
      addPoint(var18, var15, var17.rotate(180.0));
      addPoint(var18, var15, var17.rotate(225.0));
      addPoint(var18, var15, var17.rotate(270.0));
      addPoint(var18, var16, var17.rotate(270.0));
      addPoint(var18, var16, var17.rotate(315.0));
      addPoint(var18, var16, var17.rotate(0.0));
      addPoint(var18, var16, var17.rotate(45.0));
      addPoint(var18, var16, var17.rotate(90.0));
      addPoint(var18, var15, var17.rotate(90.0));
      var0.fillPolygon(var18);
   }
}
