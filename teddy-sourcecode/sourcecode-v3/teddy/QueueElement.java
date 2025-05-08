package teddy;

import java.io.Serializable;

class QueueElement implements Serializable {
   Object data;
   QueueElement next;

   QueueElement(Object var1, QueueElement var2) {
      this.data = var1;
      this.next = var2;
   }
}
