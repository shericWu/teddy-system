package teddy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Teddy$2 extends KeyAdapter {
   public void keyPress(KeyEvent var1) {
      System.out.println(var1.getKeyCode());
      System.out.println(67);
      if (var1.getKeyCode() == 67) {
         System.exit(0);
      }
   }
}
