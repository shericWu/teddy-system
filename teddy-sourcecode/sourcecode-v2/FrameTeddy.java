// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FrameTeddy.java

package teddy;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Referenced classes of package teddy:
//            Teddy

public class FrameTeddy extends Teddy
{

    public FrameTeddy()
    {
    }

    public void init()
    {
        af = new Frame("Teddy");
        Teddy teddy = new Teddy();
        Teddy.teddy = this;
        Teddy.in_browser = true;
        Teddy.f = af;
        teddy.common_init();
        teddy.start();
        af.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                af.dispose();
            }

        });
        af.add("Center", teddy);
        af.setSize(500, 500);
        af.show();
        af.setSize(500, 500);
    }

    public void play_sound(String s)
    {
        play(getCodeBase(), s);
    }

    public Frame af;
}
