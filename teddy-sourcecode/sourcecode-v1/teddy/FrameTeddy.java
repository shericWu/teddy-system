/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import teddy.Teddy;

public class FrameTeddy
extends Teddy {
    public Frame af;

    public void init() {
        this.af = new Frame("Teddy");
        Teddy teddy = new Teddy();
        Teddy.teddy = this;
        Teddy.in_browser = true;
        Teddy.f = this.af;
        teddy.common_init();
        teddy.start();
        this.af.addWindowListener(new WindowAdapter(){
            {
                FrameTeddy.this.getClass();
            }

            public void windowClosing(WindowEvent windowEvent) {
                FrameTeddy.this.af.dispose();
            }
        });
        this.af.add("Center", teddy);
        ((Component)this.af).setSize(500, 500);
        this.af.show();
        ((Component)this.af).setSize(500, 500);
    }

    public void play_sound(String string) {
        this.play(this.getCodeBase(), string);
    }
}

