package teddy;

import java.io.Serializable;

class Link implements Serializable {
   Object data;
   Link next;

   Link(Object var1, Link var2) {
      this.data = var1;
      this.next = var2;
   }
}
