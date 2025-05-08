package teddy;

import java.awt.Button;
import java.awt.Font;

public class DrawControls$NoteButton extends Button {
   DrawControls$NoteButton(DrawControls var1) {
      (this.this$0 = var1).getClass();
      this.setFont(new Font("Helvetica", 0, 24));
      this.setLabel("Note");
      this.addMouseListener(new DrawControls$NoteButton$1(this));
   }
}
