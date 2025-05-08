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

class DrawControls extends Panel implements ItemListener {
   public static Applet applet;
   DrawPanel target;
   TextField filename;

   public DrawControls(DrawPanel var1) {
      this.target = var1;
      this.setLayout(new FlowLayout());
      this.setBackground(Color.lightGray);
      this.add(new DrawControls.NewButton(this));
      this.add(new DrawControls.UndoButton(this));
      this.add(new DrawControls.BendButton(this));
      this.add(new DrawControls.RenderingButton(this));
      this.add(new DrawControls.LoadButton(this));
      if (!Teddy.in_browser) {
         this.add(new DrawControls.SaveButton(this));
      }

      this.add(this.filename = new TextField("test", 4));
      this.filename.setFont(new Font("Helvetica", 0, 24));
   }

   public void itemStateChanged(ItemEvent var1) {
      if (var1.getSource() instanceof Choice) {
         String var2 = (String)var1.getItem();
         if (var2.equals("wire frame")) {
            this.target.setStyle(0);
            this.target.setLineStyle(0);
            return;
         }

         if (var2.equals("front face")) {
            this.target.setStyle(1);
            this.target.setLineStyle(0);
            return;
         }

         if (var2.equals("flat shade")) {
            this.target.setStyle(3);
            this.target.setLineStyle(0);
            return;
         }

         if (var2.equals("pen & ink")) {
            this.target.setStyle(4);
            this.target.setLineStyle(1);
            return;
         }

         if (var2.equals("default")) {
            this.target.setStyle(4);
            this.target.setLineStyle(2);
            return;
         }

         if (var2.equals("silhouette")) {
            this.target.setStyle(2);
            this.target.setLineStyle(2);
         }
      }
   }

   public void paint(Graphics var1) {
      Rectangle var2 = this.getBounds();
      var1.setColor(Color.lightGray);
      var1.draw3DRect(0, 0, var2.width, var2.height, false);
   }

   class BendButton extends Button {
      BendButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Bend");
         this.addMouseListener(new DrawControls$BendButton$1(this));
      }
   }

   class LoadButton extends Button {
      LoadButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Load");
         this.addMouseListener(new DrawControls$LoadButton$1(this));
      }
   }

   class NewButton extends Button {
      NewButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Init");
         this.addMouseListener(new DrawControls$NewButton$1(this));
      }
   }

   class QuitButton extends Button {
      QuitButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setLabel("quit");
         this.addMouseListener(new DrawControls$QuitButton$1(this));
      }
   }

   class ReTessellateButton extends Button {
      ReTessellateButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setLabel("ReTile");
         this.addMouseListener(new DrawControls$ReTessellateButton$1(this));
      }
   }

   class RemoveThinButton extends Button {
      RemoveThinButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setLabel("RmThin");
         this.addMouseListener(new DrawControls$RemoveThinButton$1(this));
      }
   }

   class RenderingButton extends Button {
      RenderingButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Style");
         this.addMouseListener(new DrawControls$RenderingButton$1(this));
      }
   }

   public class SaveButton extends Button {
      SaveButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Save");
         this.addMouseListener(new DrawControls$SaveButton$1(this));
      }
   }

   class SmoothButton extends Button {
      SmoothButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setLabel("Smooth");
         this.addMouseListener(new DrawControls$SmoothButton$1(this));
      }
   }

   class UndoButton extends Button {
      UndoButton(DrawControls var1) {
         (this.this$0 = var1).getClass();
         this.setFont(new Font("Helvetica", 0, 24));
         this.setLabel("Undo");
         this.addMouseListener(new DrawControls$UndoButton$1(this));
      }
   }
}
