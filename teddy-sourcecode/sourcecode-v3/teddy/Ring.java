package teddy;

import java.util.Enumeration;

class Ring extends LinkedList {
   Ring(LinkedList var1) {
      this();
      Enumeration var2 = var1.elements();

      while (var2.hasMoreElements()) {
         Objects var3 = (Objects)var2.nextElement();
         this.append((Vertex)var3.get(1));
      }
   }

   Ring() {
   }

   public static Ring linked_list_to_ring(LinkedList var0) {
      Ring var1 = new Ring();
      Enumeration var2 = var0.elements();

      while (var2.hasMoreElements()) {
         var1.append(var2.nextElement());
      }

      return var1;
   }

   public static Ring sweep(Ring var0, Vertex var1, Vertex var2, Vertex var3, Vertex var4, Vector3 var5) {
      Ring var6 = new Ring();
      Vector3 var7 = new Vector3(var1, var2);
      Vector3 var8 = var7.cross_product(var5);
      Vector3 var9 = var7.cross_product(var8);
      Vector3 var10 = new Vector3(var3, var4);
      Vector3 var11 = var8;
      Vector3 var12 = var10.cross_product(var8);
      double var13 = var10.length() / var7.length();
      var7.normalize();
      var8.normalize();
      var9.normalize();
      var10.normalize();
      var8.normalize();
      var12.normalize();
      Enumeration var15 = var0.elements();

      while (var15.hasMoreElements()) {
         Vertex var16 = ((Vertex)var15.nextElement()).copy();
         Vector3 var17 = new Vector3(var1, var16);
         double var18 = var7.dot_product(var17);
         double var20 = var8.dot_product(var17);
         double var22 = var9.dot_product(var17);
         Vector3 var24 = new Vector3(0.0, 0.0, 0.0);
         var24.add_self(var10.multiple(var18 * var13));
         var24.add_self(var11.multiple(var20 * var13));
         var24.add_self(var12.multiple(var22 * var13));
         Vertex var25 = var3.shift(var24);
         var6.append(var25);
      }

      var6 = linked_list_to_ring(Generate.reduce_Vertex_list(var6));
      var6.replace_tail(var6.head());
      return var6;
   }
}
