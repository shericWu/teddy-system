package teddy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawControls$ReTessellateButton$1 extends MouseAdapter {
   public void mousePressed(MouseEvent var1) {
      this.this$0.this$0.target.retessellate();
   }

   DrawControls$ReTessellateButton$1(DrawControls.ReTessellateButton var1) {
      (this.this$0 = var1).getClass();
   }
}
