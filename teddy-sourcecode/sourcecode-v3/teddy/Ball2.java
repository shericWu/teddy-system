package teddy;

class Ball2 extends Polyhedron {
   Ball2() {
      super.tmp_polygons = new LinkedList();
      super._vertices = new LinkedList();
      super._edges = new LinkedList();
      super._polygons = new LinkedList();
      double var1 = Math.cos(Math.PI / 8);
      double var3 = Math.sin(Math.PI / 8);
      double var5 = Math.sqrt(2.0) / 2.0;
      double[] var9 = new double[]{0.0, 0.1, 0.2, 0.35, 0.4, 0.35, 0.2, 0.0, -var3, -var5, -var1, -1.0};
      double[] var10 = new double[]{0.0, 0.2, 0.3, 0.5, 0.65, 0.8, 0.95, 1.0, var1, var5, var3, 0.0};
      double[][] var11 = new double[][]{
         {1.0, 0.0},
         {var1, var3},
         {var5, var5},
         {var3, var1},
         {0.0, 1.0},
         {-var3, var1},
         {-var5, var5},
         {-var1, var3},
         {-1.0, 0.0},
         {-var1, -var3},
         {-var5, -var5},
         {-var3, -var1},
         {0.0, -1.0},
         {var3, -var1},
         {var5, -var5},
         {var1, -var3},
         {1.0, 0.0}
      };
      int var8 = 0;

      do {
         super.tmp_polygons
            .append(
               new Polyhedron.TmpPolygon(
                  this,
                  this.get_vertex(0.0, 0.0, var9[0]),
                  this.get_vertex(var10[1] * var11[var8][0], var10[1] * var11[var8][1], var9[1]),
                  this.get_vertex(var10[1] * var11[var8 + 1][0], var10[1] * var11[var8 + 1][1], var9[1])
               )
            );
      } while (++var8 <= 15);

      int var7 = 1;

      do {
         var8 = 0;

         do {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var10[var7] * var11[var8][0], var10[var7] * var11[var8][1], var9[var7]),
                     this.get_vertex(var10[var7 + 1] * var11[var8][0], var10[var7 + 1] * var11[var8][1], var9[var7 + 1]),
                     this.get_vertex(var10[var7 + 1] * var11[var8 + 1][0], var10[var7 + 1] * var11[var8 + 1][1], var9[var7 + 1]),
                     this.get_vertex(var10[var7] * var11[var8 + 1][0], var10[var7] * var11[var8 + 1][1], var9[var7])
                  )
               );
         } while (++var8 <= 15);
      } while (++var7 <= 9);

      var8 = 0;

      do {
         super.tmp_polygons
            .append(
               new Polyhedron.TmpPolygon(
                  this,
                  this.get_vertex(var10[10] * var11[var8][0], var10[10] * var11[var8][1], var9[10]),
                  this.get_vertex(0.0, 0.0, var9[11]),
                  this.get_vertex(var10[10] * var11[var8 + 1][0], var10[10] * var11[var8 + 1][1], var9[10])
               )
            );
      } while (++var8 <= 15);

      this.postprocess();
   }
}
