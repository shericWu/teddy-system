package teddy;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameTeddy$1 extends WindowAdapter {
   FrameTeddy$1(FrameTeddy var1) {
      (this.this$0 = var1).getClass();
   }

   public void windowClosing(WindowEvent var1) {
      this.this$0.af.dispose();
   }
}
