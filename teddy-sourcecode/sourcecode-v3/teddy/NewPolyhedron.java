package teddy;

import java.util.Enumeration;

class NewPolyhedron extends Polyhedron {
   public void add_temp_polygon(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
      super.tmp_polygons
         .append(new Polyhedron.TmpPolygon(this, this.get_vertex(var1, var3, var5), this.get_vertex(var7, var9, var11), this.get_vertex(var13, var15, var17)));
   }

   public void add_temp_polygon(
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23
   ) {
      super.tmp_polygons
         .append(
            new Polyhedron.TmpPolygon(
               this,
               this.get_vertex(var1, var3, var5),
               this.get_vertex(var7, var9, var11),
               this.get_vertex(var13, var15, var17),
               this.get_vertex(var19, var21, var23)
            )
         );
   }

   NewPolyhedron() {
      super.tmp_polygons = new LinkedList();
      super._vertices = new LinkedList();
      super._edges = new LinkedList();
      super._polygons = new LinkedList();
   }

   NewPolyhedron(LinkedList var1) {
      super.tmp_polygons = new LinkedList();
      super._vertices = new LinkedList();
      super._edges = new LinkedList();
      super._polygons = new LinkedList();
      Enumeration var2 = var1.elements();
      Vertex2D var3 = new Vertex2D(0.0, 0.0);

      while (var2.hasMoreElements()) {
         Vertex2D var4 = (Vertex2D)var2.nextElement();
         var3.x = var3.x + var4.x;
         var3.y = var3.y + var4.y;
      }

      var3.x = var3.x / var1.size();
      var3.y = var3.y / var1.size();
      var2 = var1.elements();
      Vertex2D var5 = (Vertex2D)var2.nextElement();
      byte var39 = 4;

      while (var2.hasMoreElements()) {
         Vertex2D var6 = (Vertex2D)var2.nextElement();
         double var7 = var5.x;
         double var9 = var5.y;
         double var11 = var6.x;
         double var13 = var6.y;

         for (int var40 = -var39; var40 < var39; var40++) {
            double var31 = Math.cos(Math.PI * var40 / var39 / 2.0);
            double var35 = Math.sin(Math.PI * var40 / var39 / 2.0) / 2.0;
            double var33 = Math.cos(Math.PI * (var40 + 1) / var39 / 2.0);
            double var37 = Math.sin(Math.PI * (var40 + 1) / var39 / 2.0) / 2.0;
            double var15 = var3.x + (var7 - var3.x) * var31;
            double var17 = var3.y + (var9 - var3.y) * var31;
            double var19 = var3.x + (var11 - var3.x) * var31;
            double var21 = var3.y + (var13 - var3.y) * var31;
            double var23 = var3.x + (var11 - var3.x) * var33;
            double var25 = var3.y + (var13 - var3.y) * var33;
            double var27 = var3.x + (var7 - var3.x) * var33;
            double var29 = var3.y + (var9 - var3.y) * var33;
            if (var40 == -var39) {
               super.tmp_polygons
                  .append(
                     new Polyhedron.TmpPolygon(
                        this, this.get_vertex(var3.x, var35, var3.y), this.get_vertex(var27, var37, var29), this.get_vertex(var23, var37, var25)
                     )
                  );
            } else if (var40 == var39 - 1) {
               super.tmp_polygons
                  .append(
                     new Polyhedron.TmpPolygon(
                        this, this.get_vertex(var19, var35, var21), this.get_vertex(var15, var35, var17), this.get_vertex(var3.x, var37, var3.y)
                     )
                  );
            } else {
               super.tmp_polygons
                  .append(
                     new Polyhedron.TmpPolygon(
                        this,
                        this.get_vertex(var27, var37, var29),
                        this.get_vertex(var23, var37, var25),
                        this.get_vertex(var19, var35, var21),
                        this.get_vertex(var15, var35, var17)
                     )
                  );
            }
         }

         var5 = var6;
      }

      this.postprocess_no_normalize();
   }

   public void generate_polygons() {
      this.postprocess_no_normalize();
   }
}
