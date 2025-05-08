package teddy;

import java.io.Serializable;

public class Objects implements Serializable {
   private Object[] objects;
   public int size;

   public Object get(int var1) {
      return this.objects[var1];
   }

   Objects() {
      this.size = 0;
      this.objects = null;
   }

   Objects(Object var1, Object var2) {
      this.size = 2;
      this.objects = new Object[2];
      this.objects[0] = var1;
      this.objects[1] = var2;
   }

   Objects(Object var1, Object var2, Object var3) {
      this.size = 3;
      this.objects = new Object[3];
      this.objects[0] = var1;
      this.objects[1] = var2;
      this.objects[2] = var3;
   }

   Objects(Object var1, Object var2, Object var3, Object var4) {
      this.size = 4;
      this.objects = new Object[this.size];
      this.objects[0] = var1;
      this.objects[1] = var2;
      this.objects[2] = var3;
      this.objects[3] = var4;
   }

   Objects(Object var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
      this.size = 6;
      this.objects = new Object[this.size];
      this.objects[0] = var1;
      this.objects[1] = var2;
      this.objects[2] = var3;
      this.objects[3] = var4;
      this.objects[4] = var5;
      this.objects[5] = var6;
   }
}
