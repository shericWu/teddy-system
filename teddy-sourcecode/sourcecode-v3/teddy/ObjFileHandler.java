package teddy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

class ObjFileHandler {
   public static void convert(String var0) {
      Polyhedron var1 = null;

      try {
         BufferedReader var2 = new BufferedReader(new FileReader(Teddy.filename(var0)));
         var1 = load(var2);
      } catch (IOException var40) {
         System.out.print("IO Error " + var40);
      }

      Draw3DScene.set_front_facing(var1);
      Vector var42 = new Vector();
      Vector var3 = new Vector();
      int var4 = 0;

      while (var4 < var1.n_vertices) {
         Vertex var5 = var1.vertices[var4];
         var42.addElement(var5);
         var5.index = var4++;
      }

      for (int var44 = 0; var44 < var1.n_polygons; var44++) {
         Polygon2 var46 = var1.polygons[var44];
         Vector var6 = new Vector();

         for (int var7 = 0; var7 < var46.n_edges; var7++) {
            var6.addElement(new Integer(var46.get_vertex(var7).index + 1));
         }

         var3.addElement(var6);
      }

      var4 = var42.size();
      boolean[] var47 = new boolean[var42.size() + 1];

      for (int var48 = 0; var48 < var42.size() + 1; var48++) {
         var47[var48] = false;
      }

      var42.size();
      Vector var49 = new Vector();

      for (int var50 = 0; var50 < var3.size(); var50++) {
         Vector var8 = (Vector)var3.elementAt(var50);
         Vector var9 = new Vector();
         var9.addElement(var8.elementAt(2));
         var9.addElement(var8.elementAt(1));
         var9.addElement(var8.elementAt(0));
         var49.addElement(var9);
      }

      var3 = var49;
      double var51 = 0.0;
      double var52 = 0.0;
      double var11 = 0.0;
      double var13 = 0.0;

      for (int var15 = 0; var15 < var4; var15++) {
         Vertex var16 = (Vertex)var42.elementAt(var15);
         if (var16.z < var51) {
            var51 = var16.z;
         }

         if (var16.z > var52) {
            var52 = var16.z;
         }

         if (var16.x < var11) {
            var11 = var16.x;
         }

         if (var16.x > var13) {
            var13 = var16.x;
         }
      }

      double var53 = var13 - var11;
      double var17 = var52 - var51;
      double var19;
      double var21;
      double var23;
      if (var53 > var17) {
         var19 = Math.max(var53, var17 * 2.0);
         var23 = var17 / var19;
         var21 = 0.0;
      } else {
         var19 = Math.max(var53 * 2.0, var17);
         var21 = var53 / var19;
         var23 = 0.0;
      }

      Vector var25 = new Vector();
      Vector var26 = new Vector();
      int[] var27 = new int[var42.size() + 1];
      int[] var28 = new int[var42.size() + 1];

      for (int var29 = 0; var29 < var3.size(); var29++) {
         Vector var30 = (Vector)var3.elementAt(var29);
         Vector var31 = new Vector();

         for (int var32 = 0; var32 < var30.size(); var32++) {
            int var33 = (Integer)var30.elementAt(var32);
            int var34 = var27[var33];
            if (!var1.polygons[var29].front_facing) {
               var34 = var28[var33];
            }

            if (var34 == 0) {
               Vertex var35 = (Vertex)var42.elementAt(var33 - 1);
               double var36 = (var35.x - var11) / var19;
               double var38 = (var35.z - var51) / var19;
               if (!var1.polygons[var29].front_facing) {
                  var36 += var21;
                  var38 += var23;
               }

               var38 = 1.0 - var38;
               var25.addElement(new Vertex2D(var36, var38));
               var34 = var25.size();
               if (var1.polygons[var29].front_facing) {
                  var27[var33] = var34;
               } else {
                  var28[var33] = var34;
               }
            }

            var31.addElement(new Integer(var34));
         }

         var26.addElement(var31);
      }

      try {
         BufferedWriter var54 = new BufferedWriter(new FileWriter(Teddy.filename_(var0)));

         for (int var55 = 0; var55 < var42.size(); var55++) {
            Vertex var58 = (Vertex)var42.elementAt(var55);
            String var61 = "v " + var58.x + " " + var58.y + " " + var58.z;
            var54.write(var61, 0, var61.length());
            var54.newLine();
         }

         for (int var56 = 0; var56 < var25.size(); var56++) {
            Vertex2D var59 = (Vertex2D)var25.elementAt(var56);
            String var62 = "vt " + var59.x + " " + var59.y;
            var54.write(var62, 0, var62.length());
            var54.newLine();
         }

         for (int var57 = 0; var57 < var3.size(); var57++) {
            Vector var60 = (Vector)var3.elementAt(var57);
            Vector var63 = (Vector)var26.elementAt(var57);
            String var64 = "f";

            for (int var65 = 0; var65 < var60.size(); var65++) {
               int var66 = (Integer)var60.elementAt(var65);
               int var67 = (Integer)var63.elementAt(var65);
               var64 = var64 + " " + var66 + "/" + var67 + "";
            }

            var54.write(var64, 0, var64.length());
            var54.newLine();
         }

         var54.flush();
         var54.close();
      } catch (IOException var41) {
         System.out.print("IO Error " + var41);
      }
   }

   public static void main(String[] var0) {
      convert(var0[0]);
   }

   public static Polyhedron load(BufferedReader var0) {
      Vector var1 = new Vector();
      Vector var2 = new Vector();
      Vector var3 = new Vector();
      Vector var4 = new Vector();

      try {
         while (true) {
            String var5 = var0.readLine();
            if (var5 == null) {
               var0.close();
               break;
            }

            StringTokenizer var6 = new StringTokenizer(var5);
            if (var6.hasMoreTokens()) {
               String var7 = var6.nextToken();
               if (var7.equals("v")) {
                  double var26 = new Double(var6.nextToken());
                  double var29 = new Double(var6.nextToken());
                  double var30 = new Double(var6.nextToken());
                  var1.addElement(new Vertex(var26, -var30, var29));
               } else if (!var7.equals("f")) {
                  if (var7.equals("#se")) {
                     while (var6.hasMoreTokens()) {
                        int var25 = new Integer(var6.nextToken());
                        int var27 = new Integer(var6.nextToken());
                        var3.addElement(new Objects(new Integer(var25), new Integer(var27)));
                     }
                  } else if (var7.equals("#sl")) {
                     while (var6.hasMoreTokens()) {
                        double var24 = new Double(var6.nextToken());
                        double var28 = new Double(var6.nextToken());
                        double var12 = new Double(var6.nextToken());
                        double var14 = new Double(var6.nextToken());
                        double var16 = new Double(var6.nextToken());
                        double var18 = new Double(var6.nextToken());
                        Vertex var20 = new Vertex(var24, -var12, var28);
                        Vertex var21 = new Vertex(var14, -var18, var16);
                        Integer var22 = new Integer(var6.nextToken());
                        var4.addElement(new Objects(var20, var21, var22));
                     }
                  }
               } else {
                  Vector var8 = new Vector();

                  while (var6.hasMoreTokens()) {
                     String var9 = var6.nextToken();
                     int var10 = var9.indexOf("/");
                     if (var10 != -1) {
                        var9 = var9.substring(0, var10);
                     }

                     int var11 = new Integer(var9) - 1;
                     var8.addElement(new Integer(var11));
                  }

                  var2.addElement(var8);
               }
            }
         }
      } catch (IOException var23) {
         System.out.print("IO Error " + var23);
      }

      return new Polyhedron(var1, var2, var3, var4);
   }

   public static void save(Polyhedron var0, String var1) {
      Vector var2 = new Vector();
      Vector var3 = new Vector();
      int var4 = 0;

      while (var4 < var0.n_vertices) {
         Vertex var5 = var0.vertices[var4];
         var2.addElement(var5);
         var5.index = var4++;
      }

      for (int var12 = 0; var12 < var0.n_polygons; var12++) {
         Polygon2 var14 = var0.polygons[var12];
         var14.index = var12;
         Vector var6 = new Vector();

         for (int var7 = 0; var7 < var14.n_edges; var7++) {
            var6.addElement(new Integer(var14.get_vertex(var7).index + 1));
         }

         var3.addElement(var6);
      }

      Vector var13 = new Vector();

      for (int var15 = 0; var15 < var0.n_edges; var15++) {
         Edge var17 = var0.edges[var15];
         if (var17.sharp) {
            var13.addElement(new Objects(new Integer(var17.start.index), new Integer(var17.end.index)));
         }
      }

      Vector var16 = new Vector();
      Enumeration var18 = var0.surface_lines.elements();

      while (var18.hasMoreElements()) {
         SurfaceLine var20 = (SurfaceLine)var18.nextElement();
         var16.addElement(var20);
      }

      try {
         BufferedWriter var19 = new BufferedWriter(new FileWriter(Teddy.filename(var1)));

         for (int var21 = 0; var21 < var2.size(); var21++) {
            Vertex var8 = (Vertex)var2.elementAt(var21);
            String var9 = "v " + var8.x + " " + var8.z + " " + -var8.y;
            var19.write(var9, 0, var9.length());
            var19.newLine();
         }

         for (int var22 = 0; var22 < var3.size(); var22++) {
            Vector var25 = (Vector)var3.elementAt(var22);
            String var31 = "f";

            for (int var10 = 0; var10 < var25.size(); var10++) {
               var31 = var31 + " " + ((Integer)var25.elementAt(var10)).toString();
            }

            var19.write(var31, 0, var31.length());
            var19.newLine();
         }

         for (int var23 = 0; var23 < var16.size(); var23++) {
            String var26 = "#sl";
            SurfaceLine var32 = (SurfaceLine)var16.elementAt(var23);
            var26 = var26 + " " + var32.start.x + " " + var32.start.z + " " + -var32.start.y;
            var26 = var26 + " " + var32.end.x + " " + var32.end.z + " " + -var32.end.y;
            var26 = var26 + " " + var32.polygon.index;
            var19.write(var26, 0, var26.length());
            var19.newLine();
         }

         String var24 = "#se";

         for (int var30 = 0; var30 < var13.size(); var30++) {
            Objects var33 = (Objects)var13.elementAt(var30);
            var24 = var24 + " " + ((Integer)var33.get(0)).toString() + " " + ((Integer)var33.get(1)).toString();
         }

         var19.write(var24, 0, var24.length());
         var19.newLine();
         var19.flush();
         var19.close();
      } catch (IOException var11) {
         System.out.print("IO Error " + var11);
      }
   }
}
