package teddy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawControls$UndoButton$1 extends MouseAdapter {
   public void mousePressed(MouseEvent var1) {
      this.this$0.this$0.target.undo();
   }

   DrawControls$UndoButton$1(DrawControls.UndoButton var1) {
      (this.this$0 = var1).getClass();
   }
}
