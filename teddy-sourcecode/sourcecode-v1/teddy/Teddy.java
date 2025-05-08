/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import teddy.DrawControls;
import teddy.DrawPanel;

public class Teddy
extends Applet {
    public static Teddy teddy;
    public static boolean in_browser;
    public static Frame f;

    public void common_init() {
        this.setLayout(new BorderLayout());
        DrawPanel drawPanel = new DrawPanel();
        this.add("Center", drawPanel);
        this.add("South", new DrawControls(drawPanel));
    }

    public static String filename_(String string) {
        return "" + string + "_.obj";
    }

    public static String filename(String string) {
        return "" + string + ".obj";
    }

    public static void main(String[] stringArray) {
        f = new Frame("Teddy");
        teddy = new Teddy();
        in_browser = false;
        teddy.common_init();
        teddy.start();
        f.addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        f.addKeyListener(new KeyAdapter(){

            public void keyPress(KeyEvent keyEvent) {
                System.out.println(keyEvent.getKeyCode());
                System.out.println(67);
                if (keyEvent.getKeyCode() == 67) {
                    System.exit(0);
                }
            }
        });
        f.add("Center", teddy);
        ((Component)f).setSize(600, 600);
        f.show();
    }

    static {
        in_browser = true;
    }

    public void init() {
        in_browser = true;
        teddy = this;
        this.common_init();
    }

    public void play_sound(String string) {
        if (in_browser) {
            this.play(this.getCodeBase(), string);
        }
    }
}

