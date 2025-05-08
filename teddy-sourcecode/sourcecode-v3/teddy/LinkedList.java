package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class LinkedList implements Serializable {
   private Link head;
   private Link tail;
   private Link pre;
   private int len;

   public Object remove() {
      Link var1 = this.cursor();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         if (this.tail == var1) {
            this.tail = this.pre;
         }

         if (this.pre != null) {
            this.pre.next = var1.next;
         } else {
            this.head = var1.next;
         }

         this.len += -1;
         return var1.data;
      }
   }

   public void merge(LinkedList var1) {
      Enumeration var3 = var1.elements();

      while (var3.hasMoreElements()) {
         Object var2 = var3.nextElement();
         if (!this.member(var2)) {
            this.append(var2);
         }
      }
   }

   public LinkedList cdr() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.elements();
      var2.nextElement();

      while (var2.hasMoreElements()) {
         var1.append(var2.nextElement());
      }

      return var1;
   }

   public void reset() {
      this.pre = null;
   }

   public Object head() {
      if (this.head == null) {
         throw new NoSuchElementException();
      } else {
         return this.head.data;
      }
   }

   public Object nextElement() {
      if (this.pre == null) {
         this.pre = this.head;
      } else {
         this.pre = this.pre.next;
      }

      if (this.pre == null) {
         throw new NoSuchElementException();
      } else {
         return this.pre.data;
      }
   }

   public void substitute(LinkedList var1) {
      this.head = var1.head;
      this.tail = var1.tail;
      this.pre = null;
      this.len = var1.len;
   }

   public void replace_head(Object var1) {
      this.head.data = var1;
   }

   public void insert(Object var1) {
      Link var2 = new Link(var1, this.cursor());
      if (this.pre != null) {
         this.pre.next = var2;
         if (this.pre == this.tail) {
            this.tail = var2;
         }
      } else {
         if (this.head == null) {
            this.tail = var2;
         }

         this.head = var2;
      }

      this.pre = var2;
      this.len++;
   }

   public boolean hasMoreElements() {
      return this.cursor() != null;
   }

   public int size() {
      return this.len;
   }

   public Enumeration elements() {
      return new ListEnumeration(this.head);
   }

   public LinkedList reverse() {
      Enumeration var1 = this.elements();
      return this.reverse_sub(var1);
   }

   public Object tail() {
      if (this.tail == null) {
         throw new NoSuchElementException();
      } else {
         return this.tail.data;
      }
   }

   public LinkedList copy() {
      LinkedList var1 = new LinkedList();
      Enumeration var2 = this.elements();

      while (var2.hasMoreElements()) {
         var1.append(var2.nextElement());
      }

      return var1;
   }

   public boolean member(Object var1) {
      Enumeration var2 = this.elements();

      while (var2.hasMoreElements()) {
         if (var1 == var2.nextElement()) {
            return true;
         }
      }

      return false;
   }

   public void print() {
      Enumeration var1 = this.elements();

      while (var1.hasMoreElements()) {
         System.out.print(", " + var1.nextElement());
      }

      System.out.println();
   }

   public Object currentElement() {
      Link var1 = this.cursor();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1.data;
      }
   }

   public void replace_tail(Object var1) {
      this.tail.data = var1;
   }

   public LinkedList reverse_sub(Enumeration var1) {
      if (var1.hasMoreElements()) {
         Object var2 = var1.nextElement();
         LinkedList var3 = this.reverse_sub(var1);
         var3.append(var2);
         return var3;
      } else {
         return new LinkedList();
      }
   }

   public void append(Object var1) {
      Link var2 = new Link(var1, null);
      if (this.head == null) {
         this.head = this.tail = var2;
      } else {
         this.tail.next = var2;
         this.tail = var2;
      }

      this.len++;
   }

   private Link cursor() {
      return this.pre == null ? this.head : this.pre.next;
   }

   public void remove(Object var1) {
      this.reset();

      while (this.hasMoreElements()) {
         if (var1 == this.currentElement()) {
            this.remove();
            return;
         }

         this.nextElement();
      }
   }

   public void connect(LinkedList var1) {
      Enumeration var2 = var1.elements();

      while (var2.hasMoreElements()) {
         this.append(var2.nextElement());
      }
   }
}
