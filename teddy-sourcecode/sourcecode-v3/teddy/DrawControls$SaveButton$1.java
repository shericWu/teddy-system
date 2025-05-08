package teddy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawControls$SaveButton$1 extends MouseAdapter {
   public void mousePressed(MouseEvent var1) {
      this.this$0.this$0.target.save(this.this$0.this$0.filename.getText());
   }

   DrawControls$SaveButton$1(DrawControls.SaveButton var1) {
      (this.this$0 = var1).getClass();
   }
}
