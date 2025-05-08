package teddy;

class Lshape extends Polyhedron {
   Lshape() {
      super.tmp_polygons = new LinkedList();
      super._vertices = new LinkedList();
      super._edges = new LinkedList();
      super._polygons = new LinkedList();

      for (double var1 = -1.0; var1 <= 0.5; var1 += 0.5) {
         for (double var3 = -1.0; var3 <= 0.5; var3 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var1, var3, 3.0),
                     this.get_vertex(var1 + 0.5, var3, 3.0),
                     this.get_vertex(var1 + 0.5, var3 + 0.5, 3.0),
                     this.get_vertex(var1, var3 + 0.5, 3.0)
                  )
               );
         }
      }

      for (double var5 = 3.0; var5 >= 1.5; var5 -= 0.5) {
         for (double var7 = -1.0; var7 <= 0.5; var7 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var7, 1.0, var5),
                     this.get_vertex(var7 + 0.5, 1.0, var5),
                     this.get_vertex(var7 + 0.5, 1.0, var5 - 0.5),
                     this.get_vertex(var7, 1.0, var5 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var7, -1.0, var5 - 0.5),
                     this.get_vertex(var7 + 0.5, -1.0, var5 - 0.5),
                     this.get_vertex(var7 + 0.5, -1.0, var5),
                     this.get_vertex(var7, -1.0, var5)
                  )
               );
         }

         for (double var11 = -1.0; var11 <= 0.5; var11 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(-1.0, var11, var5),
                     this.get_vertex(-1.0, var11 + 0.5, var5),
                     this.get_vertex(-1.0, var11 + 0.5, var5 - 0.5),
                     this.get_vertex(-1.0, var11, var5 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(1.0, var11, var5 - 0.5),
                     this.get_vertex(1.0, var11 + 0.5, var5 - 0.5),
                     this.get_vertex(1.0, var11 + 0.5, var5),
                     this.get_vertex(1.0, var11, var5)
                  )
               );
         }
      }

      for (double var8 = 1.0; var8 <= 2.5; var8 += 0.5) {
         for (double var12 = -1.0; var12 <= 0.5; var12 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var8, var12, 1.0),
                     this.get_vertex(var8 + 0.5, var12, 1.0),
                     this.get_vertex(var8 + 0.5, var12 + 0.5, 1.0),
                     this.get_vertex(var8, var12 + 0.5, 1.0)
                  )
               );
         }
      }

      for (double var15 = 1.0; var15 >= -0.5; var15 -= 0.5) {
         for (double var9 = -1.0; var9 <= 2.5; var9 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var9, 1.0, var15),
                     this.get_vertex(var9 + 0.5, 1.0, var15),
                     this.get_vertex(var9 + 0.5, 1.0, var15 - 0.5),
                     this.get_vertex(var9, 1.0, var15 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var9, -1.0, var15 - 0.5),
                     this.get_vertex(var9 + 0.5, -1.0, var15 - 0.5),
                     this.get_vertex(var9 + 0.5, -1.0, var15),
                     this.get_vertex(var9, -1.0, var15)
                  )
               );
         }

         for (double var13 = -1.0; var13 <= 0.5; var13 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(-1.0, var13, var15),
                     this.get_vertex(-1.0, var13 + 0.5, var15),
                     this.get_vertex(-1.0, var13 + 0.5, var15 - 0.5),
                     this.get_vertex(-1.0, var13, var15 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(3.0, var13, var15 - 0.5),
                     this.get_vertex(3.0, var13 + 0.5, var15 - 0.5),
                     this.get_vertex(3.0, var13 + 0.5, var15),
                     this.get_vertex(3.0, var13, var15)
                  )
               );
         }
      }

      for (double var10 = -1.0; var10 <= 2.5; var10 += 0.5) {
         for (double var14 = -1.0; var14 <= 0.5; var14 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var10, var14, -1.0),
                     this.get_vertex(var10, var14 + 0.5, -1.0),
                     this.get_vertex(var10 + 0.5, var14 + 0.5, -1.0),
                     this.get_vertex(var10 + 0.5, var14, -1.0)
                  )
               );
         }
      }

      this.postprocess();
   }
}
