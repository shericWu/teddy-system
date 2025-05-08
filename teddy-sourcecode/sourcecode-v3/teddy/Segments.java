package teddy;

import java.io.Serializable;
import java.util.Enumeration;

public class Segments implements Serializable {
   public LinkedList segments = new LinkedList();

   public void reset() {
      this.segments.reset();
   }

   public Segment nextElement() {
      return (Segment)this.segments.nextElement();
   }

   Segments() {
   }

   public Enumeration elements() {
      return this.segments.elements();
   }

   public int size() {
      return this.segments.size();
   }

   public boolean hasMoreElements() {
      return this.segments.hasMoreElements();
   }

   public Segment get_closest(double var1, double var3, double var5) {
      double var7 = var5;
      Node var11 = new Node(var1, var3);
      Segment var12 = null;
      Enumeration var14 = this.elements();

      while (var14.hasMoreElements()) {
         Segment var13 = (Segment)var14.nextElement();
         double var9 = var13.distance(var11);
         if (var7 == var9 && var12 != null) {
            if (var13.length() < var12.length()) {
               var12 = var13;
            }
         } else if (var7 >= var9) {
            var7 = var9;
            var12 = var13;
         }
      }

      return var12;
   }

   public void clear() {
      this.segments = new LinkedList();
   }

   public boolean contain_identical_segment(Segment var1) {
      Enumeration var2 = this.elements();

      while (var2.hasMoreElements()) {
         if (var1.same((Segment)var2.nextElement())) {
            return true;
         }
      }

      return false;
   }

   public void append(Segment var1) {
      if (!Def.negrigible(var1.length())) {
         this.segments.append(var1);
      }
   }

   public Segment currentElement() {
      return (Segment)this.segments.currentElement();
   }

   public void remove() {
      this.segments.remove();
   }
}
