package teddy;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;

public class Teddy extends Applet {
   public static Teddy teddy;
   public static boolean in_browser = true;
   public static Frame f;

   public void common_init() {
      this.setLayout(new BorderLayout());
      DrawPanel var1 = new DrawPanel();
      this.add("Center", var1);
      this.add("South", new DrawControls(var1));
   }

   public static String filename_(String var0) {
      return "" + var0 + "_.obj";
   }

   public static String filename(String var0) {
      return "" + var0 + ".obj";
   }

   public static void main(String[] var0) {
      f = new Frame("Teddy");
      teddy = new Teddy();
      in_browser = false;
      teddy.common_init();
      teddy.start();
      f.addWindowListener(new Teddy$1());
      f.addKeyListener(new Teddy$2());
      f.add("Center", teddy);
      f.setSize(600, 600);
      f.show();
   }

   public void init() {
      in_browser = true;
      teddy = this;
      this.common_init();
   }

   public void play_sound(String var1) {
      if (in_browser) {
         this.play(this.getCodeBase(), var1);
      }
   }
}
