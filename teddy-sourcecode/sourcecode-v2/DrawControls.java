// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DrawControls.java

package teddy;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

// Referenced classes of package teddy:
//            Teddy, DrawPanel

class DrawControls extends Panel
    implements ItemListener
{
    class NewButton extends Button
    {

        NewButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Init");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.init();
                }

            });
        }
    }

    class UndoButton extends Button
    {

        UndoButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Undo");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.undo();
                }

            });
        }
    }

    class BendButton extends Button
    {

        BendButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Bend");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.bend_start();
                }

            });
        }
    }

    class RenderingButton extends Button
    {

        RenderingButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Style");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.toggleStyle();
                }

            });
        }
    }

    class LoadButton extends Button
    {

        LoadButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Load");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.load(filename.getText());
                }

            });
        }
    }

    public class SaveButton extends Button
    {

        SaveButton()
        {
            setFont(new Font("Helvetica", 0, 24));
            setLabel("Save");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.save(filename.getText());
                }

            });
        }
    }

    class QuitButton extends Button
    {

        QuitButton()
        {
            setLabel("quit");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    System.exit(0);
                }

            });
        }
    }

    class ReTessellateButton extends Button
    {

        ReTessellateButton()
        {
            setLabel("ReTile");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.retessellate();
                }

            });
        }
    }

    class SmoothButton extends Button
    {

        SmoothButton()
        {
            setLabel("Smooth");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.smooth();
                }

            });
        }
    }

    class RemoveThinButton extends Button
    {

        RemoveThinButton()
        {
            setLabel("RmThin");
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    target.removeThin();
                }

            });
        }
    }


    public DrawControls(DrawPanel drawpanel)
    {
        target = drawpanel;
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        add(new NewButton());
        add(new UndoButton());
        add(new BendButton());
        add(new RenderingButton());
        add(new LoadButton());
        if(!Teddy.in_browser)
            add(new SaveButton());
        add(filename = new TextField("test", 4));
        filename.setFont(new Font("Helvetica", 0, 24));
    }

    public void itemStateChanged(ItemEvent itemevent)
    {
        if(itemevent.getSource() instanceof Choice)
        {
            String s = (String)itemevent.getItem();
            if(s.equals("wire frame"))
            {
                target.setStyle(0);
                target.setLineStyle(0);
                return;
            }
            if(s.equals("front face"))
            {
                target.setStyle(1);
                target.setLineStyle(0);
                return;
            }
            if(s.equals("flat shade"))
            {
                target.setStyle(3);
                target.setLineStyle(0);
                return;
            }
            if(s.equals("pen & ink"))
            {
                target.setStyle(4);
                target.setLineStyle(1);
                return;
            }
            if(s.equals("default"))
            {
                target.setStyle(4);
                target.setLineStyle(2);
                return;
            }
            if(s.equals("silhouette"))
            {
                target.setStyle(2);
                target.setLineStyle(2);
            }
        }
    }

    public void paint(Graphics g)
    {
        Rectangle rectangle = getBounds();
        g.setColor(Color.lightGray);
        g.draw3DRect(0, 0, rectangle.width, rectangle.height, false);
    }

    public static Applet applet;
    DrawPanel target;
    TextField filename;
}
