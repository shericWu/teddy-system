/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import teddy.DrawPanel;
import teddy.Teddy;

class DrawControls
extends Panel
implements ItemListener {
    public static Applet applet;
    DrawPanel target;
    TextField filename;

    public DrawControls(DrawPanel drawPanel) {
        this.target = drawPanel;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        this.add(new NewButton());
        this.add(new UndoButton());
        this.add(new BendButton());
        this.add(new RenderingButton());
        this.add(new LoadButton());
        if (!Teddy.in_browser) {
            this.add(new SaveButton());
        }
        this.filename = new TextField("test", 4);
        this.add(this.filename);
        this.filename.setFont(new Font("Helvetica", 0, 24));
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource() instanceof Choice) {
            String string = (String)itemEvent.getItem();
            if (string.equals("wire frame")) {
                this.target.setStyle(0);
                this.target.setLineStyle(0);
                return;
            }
            if (string.equals("front face")) {
                this.target.setStyle(1);
                this.target.setLineStyle(0);
                return;
            }
            if (string.equals("flat shade")) {
                this.target.setStyle(3);
                this.target.setLineStyle(0);
                return;
            }
            if (string.equals("pen & ink")) {
                this.target.setStyle(4);
                this.target.setLineStyle(1);
                return;
            }
            if (string.equals("default")) {
                this.target.setStyle(4);
                this.target.setLineStyle(2);
                return;
            }
            if (string.equals("silhouette")) {
                this.target.setStyle(2);
                this.target.setLineStyle(2);
            }
        }
    }

    public void paint(Graphics graphics) {
        Rectangle rectangle = this.getBounds();
        graphics.setColor(Color.lightGray);
        graphics.draw3DRect(0, 0, rectangle.width, rectangle.height, false);
    }

    class NewButton
    extends Button {
        NewButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Init");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.init();
                }
                {
                    NewButton.this.getClass();
                }
            });
        }
    }

    class UndoButton
    extends Button {
        UndoButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Undo");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.undo();
                }
                {
                    UndoButton.this.getClass();
                }
            });
        }
    }

    class BendButton
    extends Button {
        BendButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Bend");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.bend_start();
                }
                {
                    BendButton.this.getClass();
                }
            });
        }
    }

    class RenderingButton
    extends Button {
        RenderingButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Style");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.toggleStyle();
                }
                {
                    RenderingButton.this.getClass();
                }
            });
        }
    }

    class LoadButton
    extends Button {
        LoadButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Load");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.load(DrawControls.this.filename.getText());
                }
                {
                    LoadButton.this.getClass();
                }
            });
        }
    }

    public class SaveButton
    extends Button {
        SaveButton() {
            DrawControls.this.getClass();
            this.setFont(new Font("Helvetica", 0, 24));
            this.setLabel("Save");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.save(DrawControls.this.filename.getText());
                }
                {
                    SaveButton.this.getClass();
                }
            });
        }
    }

    class QuitButton
    extends Button {
        QuitButton() {
            DrawControls.this.getClass();
            this.setLabel("quit");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    System.exit(0);
                }
                {
                    QuitButton.this.getClass();
                }
            });
        }
    }

    class ReTessellateButton
    extends Button {
        ReTessellateButton() {
            DrawControls.this.getClass();
            this.setLabel("ReTile");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.retessellate();
                }
                {
                    ReTessellateButton.this.getClass();
                }
            });
        }
    }

    class SmoothButton
    extends Button {
        SmoothButton() {
            DrawControls.this.getClass();
            this.setLabel("Smooth");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.smooth();
                }
                {
                    SmoothButton.this.getClass();
                }
            });
        }
    }

    class RemoveThinButton
    extends Button {
        RemoveThinButton() {
            DrawControls.this.getClass();
            this.setLabel("RmThin");
            this.addMouseListener(new MouseAdapter(){

                public void mousePressed(MouseEvent mouseEvent) {
                    DrawControls.this.target.removeThin();
                }
                {
                    RemoveThinButton.this.getClass();
                }
            });
        }
    }
}

