package teddy;

import java.util.Enumeration;
import java.util.NoSuchElementException;

class ListEnumeration implements Enumeration {
   private Link cursor;

   public Object nextElement() {
      if (this.cursor == null) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.cursor.data;
         this.cursor = this.cursor.next;
         return var1;
      }
   }

   public ListEnumeration(Link var1) {
      this.cursor = var1;
   }

   public boolean hasMoreElements() {
      return this.cursor != null;
   }
}
