package teddy;

import java.util.Enumeration;

class Hammer extends Polyhedron {
   Hammer() {
      super.tmp_polygons = new LinkedList();
      super._vertices = new LinkedList();
      super._edges = new LinkedList();
      super._polygons = new LinkedList();

      for (double var1 = -2.0; var1 <= 1.5; var1 += 0.5) {
         for (double var3 = -1.0; var3 <= 0.5; var3 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var1, var3, 1.0),
                     this.get_vertex(var1 + 0.5, var3, 1.0),
                     this.get_vertex(var1 + 0.5, var3 + 0.5, 1.0),
                     this.get_vertex(var1, var3 + 0.5, 1.0)
                  )
               );
         }
      }

      for (double var5 = 1.0; var5 >= -0.5; var5 -= 0.5) {
         for (double var13 = -2.0; var13 <= 1.5; var13 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var13, 1.0, var5),
                     this.get_vertex(var13 + 0.5, 1.0, var5),
                     this.get_vertex(var13 + 0.5, 1.0, var5 - 0.5),
                     this.get_vertex(var13, 1.0, var5 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var13, -1.0, var5 - 0.5),
                     this.get_vertex(var13 + 0.5, -1.0, var5 - 0.5),
                     this.get_vertex(var13 + 0.5, -1.0, var5),
                     this.get_vertex(var13, -1.0, var5)
                  )
               );
         }

         for (double var17 = -1.0; var17 <= 0.5; var17 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(-2.0, var17, var5),
                     this.get_vertex(-2.0, var17 + 0.5, var5),
                     this.get_vertex(-2.0, var17 + 0.5, var5 - 0.5),
                     this.get_vertex(-2.0, var17, var5 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(2.0, var17, var5 - 0.5),
                     this.get_vertex(2.0, var17 + 0.5, var5 - 0.5),
                     this.get_vertex(2.0, var17 + 0.5, var5),
                     this.get_vertex(2.0, var17, var5)
                  )
               );
         }
      }

      for (double var14 = -2.0; var14 <= 1.5; var14 += 0.5) {
         for (double var18 = -1.0; var18 <= 0.5; var18 += 0.5) {
            if (var14 != -0.5 && var14 != 0.0 || var18 != -0.5 && var18 != 0.0) {
               super.tmp_polygons
                  .append(
                     new Polyhedron.TmpPolygon(
                        this,
                        this.get_vertex(var14, var18, -1.0),
                        this.get_vertex(var14, var18 + 0.5, -1.0),
                        this.get_vertex(var14 + 0.5, var18 + 0.5, -1.0),
                        this.get_vertex(var14 + 0.5, var18, -1.0)
                     )
                  );
            }
         }
      }

      for (double var21 = -1.0; var21 >= -2.75; var21 -= 0.25) {
         for (double var15 = -0.5; var15 <= 0.0; var15 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var15, 0.5, var21),
                     this.get_vertex(var15 + 0.5, 0.5, var21),
                     this.get_vertex(var15 + 0.5, 0.5, var21 - 0.25),
                     this.get_vertex(var15, 0.5, var21 - 0.25)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var15, -0.5, var21 - 0.25),
                     this.get_vertex(var15 + 0.5, -0.5, var21 - 0.25),
                     this.get_vertex(var15 + 0.5, -0.5, var21),
                     this.get_vertex(var15, -0.5, var21)
                  )
               );
         }

         for (double var19 = -0.5; var19 <= 0.0; var19 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(-0.5, var19, var21),
                     this.get_vertex(-0.5, var19 + 0.5, var21),
                     this.get_vertex(-0.5, var19 + 0.5, var21 - 0.25),
                     this.get_vertex(-0.5, var19, var21 - 0.25)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(0.5, var19, var21 - 0.25),
                     this.get_vertex(0.5, var19 + 0.5, var21 - 0.25),
                     this.get_vertex(0.5, var19 + 0.5, var21),
                     this.get_vertex(0.5, var19, var21)
                  )
               );
         }
      }

      for (double var16 = -0.5; var16 <= 0.0; var16 += 0.5) {
         for (double var20 = -0.5; var20 <= 0.0; var20 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var16, var20, -3.0),
                     this.get_vertex(var16, var20 + 0.5, -3.0),
                     this.get_vertex(var16 + 0.5, var20 + 0.5, -3.0),
                     this.get_vertex(var16 + 0.5, var20, -3.0)
                  )
               );
         }
      }

      Enumeration var7 = super._vertices.elements();

      while (var7.hasMoreElements()) {
         Vertex var8 = (Vertex)var7.nextElement();
         double var9 = Math.sqrt(var8.x * var8.x + var8.y * var8.y);
         if (var9 > 1.0E-4) {
            double var11 = (0.5 + var9 / 2.0) / var9;
            var8.x *= var11;
            var8.y *= var11;
         }
      }

      this.postprocess();
   }
}
