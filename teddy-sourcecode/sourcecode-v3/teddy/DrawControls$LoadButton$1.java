package teddy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawControls$LoadButton$1 extends MouseAdapter {
   public void mousePressed(MouseEvent var1) {
      this.this$0.this$0.target.load(this.this$0.this$0.filename.getText());
   }

   DrawControls$LoadButton$1(DrawControls.LoadButton var1) {
      (this.this$0 = var1).getClass();
   }
}
