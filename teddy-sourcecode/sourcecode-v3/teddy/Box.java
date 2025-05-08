package teddy;

class Box extends Polyhedron {
   Box() {
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
         for (double var7 = -2.0; var7 <= 1.5; var7 += 0.5) {
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

         for (double var9 = -1.0; var9 <= 0.5; var9 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(-2.0, var9, var5),
                     this.get_vertex(-2.0, var9 + 0.5, var5),
                     this.get_vertex(-2.0, var9 + 0.5, var5 - 0.5),
                     this.get_vertex(-2.0, var9, var5 - 0.5)
                  )
               );
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(2.0, var9, var5 - 0.5),
                     this.get_vertex(2.0, var9 + 0.5, var5 - 0.5),
                     this.get_vertex(2.0, var9 + 0.5, var5),
                     this.get_vertex(2.0, var9, var5)
                  )
               );
         }
      }

      for (double var8 = -2.0; var8 <= 1.5; var8 += 0.5) {
         for (double var10 = -1.0; var10 <= 0.5; var10 += 0.5) {
            super.tmp_polygons
               .append(
                  new Polyhedron.TmpPolygon(
                     this,
                     this.get_vertex(var8, var10, -1.0),
                     this.get_vertex(var8, var10 + 0.5, -1.0),
                     this.get_vertex(var8 + 0.5, var10 + 0.5, -1.0),
                     this.get_vertex(var8 + 0.5, var10, -1.0)
                  )
               );
         }
      }

      this.postprocess();
      this.set_sharp_edges();
      this.rotate_z(20.0);
      this.rotate_x(10.0);
   }
}
