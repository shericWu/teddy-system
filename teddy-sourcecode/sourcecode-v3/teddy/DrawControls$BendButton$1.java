package teddy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawControls$BendButton$1 extends MouseAdapter {
   public void mousePressed(MouseEvent var1) {
      this.this$0.this$0.target.bend_start();
   }

   DrawControls$BendButton$1(DrawControls.BendButton var1) {
      (this.this$0 = var1).getClass();
   }
}
