// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Teddy.java

package teddy;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

// Referenced classes of package teddy:
//            DrawPanel, DrawControls

public class Teddy extends Applet
{

    public void common_init()
    {
        setLayout(new BorderLayout());
        DrawPanel drawpanel = new DrawPanel();
        add("Center", drawpanel);
        add("South", new DrawControls(drawpanel));
    }

    public Teddy()
    {
    }

    public static String filename_(String s)
    {
        return "" + s + "_.obj";
    }

    public static String filename(String s)
    {
        return "" + s + ".obj";
    }

    public static void main(String args[])
    {
        f = new Frame("Teddy");
        teddy = new Teddy();
        in_browser = false;
        teddy.common_init();
        teddy.start();
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                System.exit(0);
            }

        });
        f.addKeyListener(new KeyAdapter() {

            public void keyPress(KeyEvent keyevent)
            {
                System.out.println(keyevent.getKeyCode());
                System.out.println(67);
                if(keyevent.getKeyCode() == 67)
                    System.exit(0);
            }

        });
        f.add("Center", teddy);
        f.setSize(600, 600);
        f.show();
    }

    public void init()
    {
        in_browser = true;
        teddy = this;
        common_init();
    }

    public void play_sound(String s)
    {
        if(in_browser)
            play(getCodeBase(), s);
    }

    public static Teddy teddy;
    public static boolean in_browser = true;
    public static Frame f;

}
