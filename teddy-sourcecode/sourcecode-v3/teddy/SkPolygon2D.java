package teddy;

import java.util.Enumeration;

class SkPolygon2D {
   public LinkedList edges;
   public int type;
   public SkVertex2D center;
   public double height = -1.0;
   public SkEdge2D center_edge;
   public boolean marked = false;
   public static final int TERMINAL = 0;
   public static final int SLEEVE = 1;
   public static final int JUNCTION = 2;
   public static final int COVER = 3;
   public TrimData[] trimData = null;

   private Vertex2D get_gravity_center() {
      double var1 = 0.0;
      double var3 = 0.0;
      int var5 = this.edges.size();

      for (int var6 = 0; var6 < var5; var6++) {
         Vertex2D var7 = this.get_vertex(var6);
         var1 += var7.x;
         var3 += var7.y;
      }

      var1 /= var5;
      var3 /= var5;
      return new Vertex2D(var1, var3);
   }

   public double average_edge_length() {
      Enumeration var1 = this.edges.elements();
      double var2 = 0.0;

      while (var1.hasMoreElements()) {
         var2 += ((SkEdge2D)var1.nextElement()).length();
      }

      return var2 / this.edges.size();
   }

   SkPolygon2D(SkEdge2D var1, SkEdge2D var2, SkEdge2D var3, int var4) {
      this.edges = new LinkedList();
      this.edges.append(var1);
      this.edges.append(var2);
      this.edges.append(var3);
      this.type = var4;
      this.set_variables();
   }

   SkPolygon2D(LinkedList var1, int var2) {
      this.edges = var1.copy();
      this.type = var2;
      this.set_variables();
   }

   SkPolygon2D(SkEdge2D var1, SkVertex2D var2) {
      this.center = var2;
      SkEdge2D var3 = new SkEdge2D((SkVertex2D)var1.end, this.center, 1);
      SkEdge2D var4 = new SkEdge2D(this.center, (SkVertex2D)var1.start, 1);
      this.edges = new LinkedList();
      this.edges.append(var1);
      this.edges.append(var3);
      this.edges.append(var4);
      this.type = 3;
      this.set_variables();
   }

   public SkVertex2D get_terminal_vertex() {
      if (this.get_edge(0).type == 2) {
         return (SkVertex2D)this.get_vertex(2);
      } else {
         return this.get_edge(1).type == 2 ? (SkVertex2D)this.get_vertex(0) : (SkVertex2D)this.get_vertex(1);
      }
   }

   public LinkedList get_internal_edges() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         SkEdge2D var3 = (SkEdge2D)var2.nextElement();
         if (var3.type == 2) {
            var1.append(var3);
         }
      }

      return var1;
   }

   public SkEdge2D get_internal_edge() {
      if (this.get_edge(0).type == 2) {
         return this.get_edge(0);
      } else {
         return this.get_edge(1).type == 2 ? this.get_edge(1) : this.get_edge(2);
      }
   }

   public void mark() {
      this.marked = true;
   }

   public SkEdge2D get_edge(int var1) {
      int var2 = this.edges.size();
      if (var1 >= var2) {
         var1 -= var1 / var2 * var2;
      }

      if (var1 < 0) {
         var1 += (-var1 / var2 + 1) * var2;
      }

      Enumeration var3 = this.edges.elements();
      SkEdge2D var4 = null;

      for (int var5 = 0; var5 <= var1; var5++) {
         var4 = (SkEdge2D)var3.nextElement();
      }

      return var4;
   }

   public SkEdge2D the_other_internal_edge(SkEdge2D var1) {
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         SkEdge2D var3 = (SkEdge2D)var2.nextElement();
         if (var3.type == 2 && var3 != var1) {
            return var3;
         }
      }

      System.out.println("fail in SkPolygon2D.the_other_internal_edge");
      return null;
   }

   public SkEdge2D get_external_edge() {
      Enumeration var1 = this.edges.elements();

      while (var1.hasMoreElements()) {
         SkEdge2D var2 = (SkEdge2D)var1.nextElement();
         if (var2.type == 0) {
            return var2;
         }
      }

      System.out.println("fail in SkPolygon2D.get_external_edge");
      return null;
   }

   public SkEdge2D get_longest_edge() {
      Enumeration var1 = this.edges.elements();
      double var2 = -1.0;
      SkEdge2D var4 = null;

      while (var1.hasMoreElements()) {
         SkEdge2D var5 = (SkEdge2D)var1.nextElement();
         double var6 = var5.length();
         if (var6 > var2) {
            var2 = var6;
            var4 = var5;
         }
      }

      return var4;
   }

   public SkVertex2D get_internal_vertex() {
      LinkedList var1 = this.get_internal_edges();
      SkEdge2D var2 = (SkEdge2D)var1.head();
      SkEdge2D var3 = (SkEdge2D)var1.tail();
      return (SkVertex2D)var2.get_common_vertex(var3);
   }

   public int get_index(SkEdge2D var1) {
      Enumeration var2 = this.edges.elements();

      for (int var3 = 0; var2.hasMoreElements(); var3++) {
         if ((SkEdge2D)var2.nextElement() == var1) {
            return var3;
         }
      }

      return -1;
   }

   private void set_center() {
      if (this.edges.size() == 3) {
         Vector2 var6 = new Vector2(this.get_vertex(0), this.get_vertex(1));
         Vector2 var2 = new Vector2(this.get_vertex(1), this.get_vertex(2));
         Vector2 var7 = new Vector2(this.get_vertex(2), this.get_vertex(0));
         if (var6.dot_product(var2) >= 0.0) {
            this.center_edge = this.get_edge(2);
         } else if (var2.dot_product(var7) >= 0.0) {
            this.center_edge = this.get_edge(0);
         } else {
            if (!(var7.dot_product(var6) >= 0.0)) {
               this.center_edge = null;
               Vertex2D var8 = this.get_circumcenter();
               if (var8 == null) {
                  System.out.println("error in Skeleton.set_center");
                  var8 = this.get_gravity_center();
               }

               this.center = new SkVertex2D(var8);
               return;
            }

            this.center_edge = this.get_edge(1);
         }

         this.center = new SkVertex2D(this.center_edge.mid_point());
      } else {
         this.center_edge = null;
         this.center = new SkVertex2D(this.get_gravity_center());
         double var1 = -1.0;

         for (int var3 = 0; var3 < this.edges.size(); var3++) {
            double var4 = Vector2.distance(this.get_vertex(var3), this.center);
            if (var4 > var1) {
               var1 = var4;
            }
         }

         this.center.height = var1 * Def.GENERATE_HEIGHT;
      }
   }

   private Vertex2D get_circumcenter() {
      return Geometry2D.get_circumcenter(this.get_vertex(0), this.get_vertex(1), this.get_vertex(2));
   }

   public Vertex2D get_vertex(int var1) {
      SkEdge2D var2 = this.get_edge(var1);
      return var2.left_polygon == this ? var2.start : var2.end;
   }

   public LinkedList get_external_edges() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.edges.elements();

      while (var2.hasMoreElements()) {
         SkEdge2D var3 = (SkEdge2D)var2.nextElement();
         if (var3.type == 0) {
            var1.append(var3);
         }
      }

      return var1;
   }

   public SkEdge2D get_shortest_edge() {
      Enumeration var1 = this.edges.elements();
      double var2 = Double.MAX_VALUE;
      SkEdge2D var4 = null;

      while (var1.hasMoreElements()) {
         SkEdge2D var5 = (SkEdge2D)var1.nextElement();
         double var6 = var5.length();
         if (var6 < var2) {
            var2 = var6;
            var4 = var5;
         }
      }

      return var4;
   }

   public void setTrimData(SkEdge2D var1, TrimData var2) {
      if (this.trimData == null) {
         this.trimData = new TrimData[this.edges.size()];
      }

      int var3 = this.get_index(var1);
      this.trimData[var3] = var2;
   }

   public TrimData getTrimData(int var1) {
      return this.trimData == null ? null : this.trimData[var1];
   }

   private void set_variables() {
      Enumeration var1 = this.edges.elements();
      SkEdge2D var2 = (SkEdge2D)var1.nextElement();

      while (var1.hasMoreElements()) {
         SkEdge2D var3 = (SkEdge2D)var1.nextElement();
         if (var3.contains(var2.end)) {
            var2.set_left_polygon(this);
         } else {
            var2.set_right_polygon(this);
         }

         var2 = var3;
      }

      SkEdge2D var4 = (SkEdge2D)this.edges.head();
      if (var4.contains(var2.end)) {
         var2.set_left_polygon(this);
      } else {
         var2.set_right_polygon(this);
      }

      if (this.type == 2) {
         this.set_center();
         this.trimData = new TrimData[this.edges.size()];
      }
   }

   public TrimData getTrimData(SkEdge2D var1) {
      return this.trimData == null ? null : this.trimData[this.get_index(var1)];
   }
}
