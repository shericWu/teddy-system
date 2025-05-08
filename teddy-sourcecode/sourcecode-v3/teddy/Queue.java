package teddy;

import java.io.Serializable;

public class Queue implements Serializable {
   private QueueElement head = null;
   private QueueElement tail = null;
   private int len = 0;

   public Object pop() {
      if (this.head == null) {
         return null;
      } else {
         Object var1 = this.head.data;
         this.head = this.head.next;
         this.len += -1;
         return var1;
      }
   }

   Queue() {
   }

   public int size() {
      return this.len;
   }

   public void push(Object var1) {
      QueueElement var2 = new QueueElement(var1, null);
      if (this.head == null) {
         this.head = this.tail = var2;
      } else {
         this.tail.next = var2;
         this.tail = var2;
      }

      this.len++;
   }
}
