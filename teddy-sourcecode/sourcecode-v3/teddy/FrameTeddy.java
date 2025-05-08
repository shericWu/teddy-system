package teddy;

import java.awt.Frame;

public class FrameTeddy extends Teddy {
   public Frame af;

   public void init() {
      this.af = new Frame("Teddy");
      Teddy var1 = new Teddy();
      Teddy.teddy = this;
      Teddy.in_browser = true;
      Teddy.f = this.af;
      var1.common_init();
      var1.start();
      this.af.addWindowListener(new FrameTeddy$1(this));
      this.af.add("Center", var1);
      this.af.setSize(500, 500);
      this.af.show();
      this.af.setSize(500, 500);
   }

   public void play_sound(String var1) {
      this.play(this.getCodeBase(), var1);
   }
}
