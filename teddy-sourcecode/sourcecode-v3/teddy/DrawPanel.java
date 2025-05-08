package teddy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Vector;

class DrawPanel extends Panel {
   public static final int LINES = 0;
   public static final int POINTS = 1;
   Scene scene;
   public static Segment special_segment = null;
   public static LinkedList special_segments = new LinkedList();
   int x1;
   int y1;
   int x2;
   int y2;
   int xl;
   int yl;
   double stroke_length;
   public static double scale = 1.0;
   public static double original_scale = 1.0;
   public static int frameX = 0;
   public static int frameY = 0;
   public static int original_frameX;
   public static int original_frameY;
   public static int operation_status;
   public static final int NONE = 0;
   public static final int ZOOMING = 1;
   public static final int MOVING = 2;
   public static final int DRAWING = 3;
   public static final int ERASING = 4;
   public static DrawPanel.Feedback feedback;
   private int state;
   private static final int SETTLED = 0;
   private static final int SELECTING = 1;
   private static final int PREDICTING = 2;
   protected static final int MINIMUM_STROKE_LENGTH = 10;
   protected static final int MINIMUM_SELECT_DISTANCE = 10;
   private static final int WIRE_VISIBLE = 2;
   Polyhedron teddy;
   Polyhedron saved_teddy;
   Polyhedron saved_teddy2;
   public LinkedList bend_stroke0 = null;
   public LinkedList bend_stroke1 = null;
   public int bend_phase = 0;
   boolean annotating = false;
   Vector annotations = new Vector();
   boolean redraw_background = true;
   Image buffered_image;
   public boolean is_ctrl = false;

   private void draw_segment(Graphics var1, Segment var2, Color var3) {
      var1.setColor(var3);
      Graphics2.drawWideLine(var1, cX(var2.x1), cY(var2.y1), cX(var2.x2), cY(var2.y2), scale);
   }

   public void moving_end(MouseEvent var1) {
      Draw3DScene.in_motion = false;
      this.repaint_all();
   }

   public void undo() {
      this.bend_end();
      Draw3DScene.current_polygon = null;
      feedback.clear();
      if (this.teddy != null) {
         this.teddy.restore(this.saved_teddy);
      } else {
         this.teddy = this.saved_teddy;
      }

      if (this.saved_teddy2 != null) {
         this.saved_teddy = this.saved_teddy2.copy();
      } else {
         this.saved_teddy = null;
      }

      this.repaint_all();
   }

   public void drawing_interim(MouseEvent var1) {
      this.xl = this.x2;
      this.yl = this.y2;
      this.x2 = var1.getX();
      this.y2 = var1.getY();
      this.stroke_length = this.stroke_length + Vector2.distance(this.xl, this.yl, this.x2, this.y2);
      feedback.add_point(this.x2, this.y2);
      this.repaint_feedback();
   }

   public void drawing_start(MouseEvent var1) {
      operation_status = 3;
      this.mouse_start(var1);
      this.stroke_length = 0.0;
      feedback.clear_stroke();
   }

   public static double rcY(int var0) {
      return (var0 - frameY) / scale;
   }

   public void setStyle(int var1) {
      Draw3DScene.render_style = var1;
      this.repaint_all();
   }

   public void toggleStyle() {
      if (Draw3DScene.render_style != 4) {
         Draw3DScene.render_style = 4;
         Draw3DScene.line_style = 2;
      } else {
         Draw3DScene.render_style = 1;
         Draw3DScene.line_style = 0;
      }

      this.repaint_all();
   }

   public void setLineStyle(int var1) {
      Draw3DScene.line_style = var1;
      this.repaint_all();
   }

   public static int cX(double var0) {
      return (int)(var0 * scale) + frameX;
   }

   public void setShape(Polyhedron var1) {
      scale = 1.0;
      Draw3DScene.current_polygon = null;
      feedback.clear();
      this.saved_teddy2 = this.saved_teddy;
      this.saved_teddy = this.teddy;
      this.teddy = var1;
      this.repaint_all();
   }

   public String get_message() {
      if (this.teddy == null) {
         return "CREATION";
      } else if (this.teddy.temp_surface_lines.size() > 0) {
         return "EXTRUSION";
      } else if (this.bend_phase == 1) {
         return "BENDING";
      } else if (this.bend_phase == 2) {
         return "BENDING";
      } else {
         return this.annotating ? "NOTE" : "";
      }
   }

   public void add_annotation(LinkedList var1) {
      this.annotating = true;
      this.annotations.addElement(var1);
   }

   public void update(Graphics var1) {
      this.paint(var1);
   }

   public void load(String var1) {
      this.bend_end();
      if (this.teddy != null) {
         this.saved_teddy2 = this.saved_teddy;
         this.saved_teddy = this.teddy.copy();
      }

      try {
         BufferedReader var2;
         if (Teddy.in_browser) {
            InputStream var3 = new URL(Teddy.teddy.getDocumentBase(), Teddy.filename(var1)).openStream();
            var2 = new BufferedReader(new InputStreamReader(var3));
         } else {
            var2 = new BufferedReader(new FileReader(Teddy.filename(var1)));
         }

         this.teddy = ObjFileHandler.load(var2);
         this.repaint_all();
      } catch (IOException var4) {
         System.out.print("IO Error " + var4);
      }
   }

   public void save(String var1) {
      this.bend_end();
      ObjFileHandler.save(this.teddy, var1);
   }

   public void moving_start(MouseEvent var1) {
      operation_status = 2;
      this.mouse_start(var1);
      this.clear_annotation();
   }

   public static double rcX(int var0) {
      return (var0 - frameX) / scale;
   }

   public void zooming_interim(MouseEvent var1) {
      scale = original_scale * Math.pow(Math.E, (var1.getY() - this.y1) / 100.0);
      frameX = this.x1 + (int)((original_frameX - this.x1) * scale / original_scale);
      frameY = this.y1 + (int)((original_frameY - this.y1) * scale / original_scale);
      Draw3DScene.in_motion = true;
      this.repaint_all();
   }

   public void repaint_all() {
      this.redraw_background = true;
      if (this.teddy != null) {
         this.teddy.view_changed = true;
      }

      this.repaint();
   }

   public void paint_annotations(Graphics var1) {
      for (int var2 = 0; var2 < this.annotations.size(); var2++) {
         LinkedList var3 = (LinkedList)this.annotations.elementAt(var2);
         Enumeration var4 = var3.elements();
         Point var5 = (Point)var4.nextElement();

         while (var4.hasMoreElements()) {
            Point var6 = (Point)var4.nextElement();
            Graphics2.drawWideLine(var1, var5.x, var5.y, var6.x, var6.y, scale * 6.0);
            var5 = var6;
         }
      }
   }

   public DrawPanel() {
      feedback = new DrawPanel.Feedback(this);
      this.setBackground(Color.white);
      DrawPanel.MouseDispatcher var1 = new DrawPanel.MouseDispatcher(this);
      this.addMouseMotionListener(var1);
      this.addKeyListener(var1);
      this.addMouseListener(var1);
      this.scene = new Scene();
      this.state = 0;
      this.saved_teddy2 = null;
      this.saved_teddy = null;
      this.teddy = null;
      this.load("default");
      this.setStyle(4);
      this.setLineStyle(2);
   }

   public void bend(LinkedList var1) {
      if (this.bend_phase == 1) {
         this.bend_phase++;
         this.bend_stroke0 = var1;
      } else {
         if (this.bend_phase == 2) {
            this.bend_stroke1 = var1;
            Bend.bend(this.bend_stroke0, this.bend_stroke1, this.teddy);
            this.bend_phase = 0;
            feedback.clear_stroke();
         }
      }
   }

   public void zooming_end(MouseEvent var1) {
      Draw3DScene.in_motion = false;
      this.repaint_all();
   }

   public void note() {
      this.annotating = !this.annotating;
   }

   public static double rc(double var0) {
      return var0 / scale;
   }

   public void paint(Graphics var1) {
      if (!this.redraw_background) {
         feedback.draw(var1);
      } else {
         if (this.buffered_image == null) {
            this.buffered_image = this.createImage(this.getSize().width, this.getSize().height);
         } else if (this.buffered_image.getWidth(null) != this.getSize().width || this.buffered_image.getHeight(null) != this.getSize().height) {
            this.buffered_image = this.createImage(this.getSize().width, this.getSize().height);
         }

         Graphics var2 = this.buffered_image.getGraphics();
         var2.clearRect(0, 0, this.getSize().width, this.getSize().height);
         var2.setPaintMode();
         Enumeration var3 = this.scene.elements();

         while (var3.hasMoreElements()) {
            this.draw_segment(var2, (Segment)var3.nextElement(), Color.black);
         }

         if (special_segment != null) {
            this.draw_segment(var2, special_segment, Color.blue);
         }

         var3 = special_segments.elements();

         while (var3.hasMoreElements()) {
            this.draw_segment(var2, (Segment)var3.nextElement(), Color.blue);
         }

         Draw3DScene.paint(var2, this.teddy, scale, this.getSize());
         var2.dispose();
         var1.drawImage(this.buffered_image, 0, 0, this);
         feedback.draw(var1);
         this.redraw_background = false;
         var1.setColor(Color.red);
         var1.setFont(new Font("SansSerif", 0, 24));
         var1.drawString(this.get_message(), 10, 30);
         this.paint_annotations(var1);
      }
   }

   public void bend_start() {
      this.bend_stroke0 = null;
      this.bend_stroke1 = null;
      this.bend_phase = 1;
      this.repaint_all();
   }

   public void drawing_finish(MouseEvent var1) {
      if (this.annotating) {
         this.add_annotation(feedback.stroke);
         feedback.clear_stroke();
      } else {
         if (this.teddy != null) {
            this.saved_teddy2 = this.saved_teddy;
            this.saved_teddy = this.teddy.copy();
         }

         if (this.bend_phase > 0) {
            if (this.teddy != null) {
               this.bend(feedback.stroke);
               this.repaint_all();
               return;
            }

            this.scene = Trianglation2D.generate_scene(feedback.stroke);
            this.bend_phase = 0;
         } else if (this.teddy != null) {
            if (this.teddy.temp_surface_lines.size() > 0) {
               if (feedback.is_erase()) {
                  Smooth.smooth(this.teddy);
               } else {
                  Pop.pop(feedback.stroke, this.teddy);
               }
            } else if (feedback.is_erase()) {
               Eraser.erase(feedback.erase_loop, this.teddy);
            } else if (SurfaceLine.generate_surface_lines(feedback.stroke, this.teddy, this.is_ctrl) && Cutting.cut(feedback.stroke, this.teddy, this.is_ctrl)) {
               this.add_annotation(feedback.stroke);
            }
         } else {
            this.teddy = Generate.generate(feedback.stroke);
         }

         feedback.clear_stroke();
         Draw3DScene.in_motion = false;
         this.repaint_all();
      }
   }

   public void removeThin() {
      Tessellation.remove_thin_polygons(this.teddy);
      this.repaint_all();
   }

   public void smooth() {
      ReTessellation.smooth(this.teddy);
      this.repaint_all();
   }

   public void moving_interim(MouseEvent var1) {
      if (this.teddy != null) {
         int var2 = this.getSize().width / 2;
         int var3 = this.getSize().height / 2;
         Point var4 = new Point(var2, var3);
         int var5 = var1.getX();
         int var6 = var1.getY();
         this.teddy.rotate_z((var5 - this.x1) * (var3 - Math.abs(var6 - var4.y)) / var3);
         this.teddy.rotate_x((var6 - this.y1) * (var2 - Math.abs(var5 - var4.x)) / var2);
         Vector2 var7 = new Vector2(var5 - var4.x, var6 - var4.y);
         Vector2 var8 = new Vector2(var5 - this.x1, var6 - this.y1);
         double var9 = var7.cross_product(var8) / var3;
         this.teddy.rotate_y(var9 / 4.0);
      }

      frameX = frameX + (var1.getX() - this.x1);
      frameY = frameY + (var1.getY() - this.y1);
      this.x1 = var1.getX();
      this.y1 = var1.getY();
      Draw3DScene.in_motion = true;
      this.repaint_all();
   }

   public void clear_annotation() {
      this.annotating = false;
      this.annotations = new Vector();
   }

   public void repaint_feedback() {
      this.redraw_background = false;
      this.repaint();
   }

   public void retessellate() {
      this.scene = Trianglation2D.rearrange_scene();
      this.repaint_all();
   }

   public void init() {
      this.bend_end();
      this.setShape(null);
   }

   public void bend_end() {
      this.bend_phase = 0;
   }

   public static int cY(double var0) {
      return (int)(var0 * scale) + frameY;
   }

   public void zooming_start(MouseEvent var1) {
      operation_status = 1;
      original_scale = scale;
      original_frameX = frameX;
      original_frameY = frameY;
      this.mouse_start(var1);
   }

   public void mouse_start(MouseEvent var1) {
      this.x1 = var1.getX();
      this.y1 = var1.getY();
      this.x2 = this.x1;
      this.y2 = this.y1;
   }

   public class Feedback {
      public LinkedList stroke;
      public LinkedList erase_loop;

      public void clear_stroke() {
         this.stroke = new LinkedList();
      }

      public void draw(Graphics var1) {
         var1.setColor(Color.red);
         if (this.this$0.bend_phase == 2 && DrawPanel.operation_status == 3) {
            var1.setColor(Color.blue);
         }

         Enumeration var4 = this.stroke.elements();
         if (var4.hasMoreElements()) {
            Point var2 = (Point)var4.nextElement();

            while (var4.hasMoreElements()) {
               Point var3 = (Point)var4.nextElement();
               Graphics2.drawWideLine(var1, var2.x, var2.y, var3.x, var3.y, DrawPanel.scale * 6.0);
               var2 = var3;
            }
         }
      }

      Feedback(DrawPanel var1) {
         (this.this$0 = var1).getClass();
         this.stroke = new LinkedList();
      }

      public void add_point(int var1, int var2) {
         this.stroke.append(new Point(var1, var2));
      }

      private void check_erase_loop() {
         Enumeration var1 = this.erase_loop.elements();
         Point var2 = (Point)var1.nextElement();

         while (var1.hasMoreElements()) {
            Point var3 = (Point)var1.nextElement();
            Segment var4 = new Segment(DrawPanel.rcX(var2.x), DrawPanel.rcY(var2.y), DrawPanel.rcX(var3.x), DrawPanel.rcY(var3.y));
            this.this$0.scene.append(var4);
            var2 = var3;
         }
      }

      public boolean is_erase() {
         Enumeration var1 = this.stroke.elements();
         Point var2 = (Point)var1.nextElement();
         Point var3 = new Point(var2);
         double var4 = 0.0;

         while (var1.hasMoreElements()) {
            Point var6 = (Point)var1.nextElement();
            var3.x = var3.x + var6.x;
            var3.y = var3.y + var6.y;
            var4 += Vector2.distance(var2, var6);
            var2 = var6;
         }

         var3.x = var3.x / this.stroke.size();
         var3.y = var3.y / this.stroke.size();
         Point var17 = var3;
         Point var7 = var3;
         Point var8 = var3;
         Point var9 = var3;
         Point var10 = var3;
         Point var11 = var3;
         Point var12 = var3;
         Point var13 = var3;
         var1 = this.stroke.elements();

         while (var1.hasMoreElements()) {
            Point var14 = (Point)var1.nextElement();
            if (var14.y < var17.y) {
               var17 = var14;
            }

            if (var14.y > var9.y) {
               var9 = var14;
            }

            if (var14.x < var7.x) {
               var7 = var14;
            }

            if (var14.x > var8.x) {
               var8 = var14;
            }

            if (var14.y + var14.x < var10.y + var10.x) {
               var10 = var14;
            }

            if (var14.y - var14.x > var11.y - var11.x) {
               var11 = var14;
            }

            if (var14.y + var14.x > var12.y + var12.x) {
               var12 = var14;
            }

            if (var14.y - var14.x < var13.y - var13.x) {
               var13 = var14;
            }
         }

         this.erase_loop = new LinkedList();
         this.erase_loop.append(var17);
         this.erase_loop.append(var10);
         this.erase_loop.append(var7);
         this.erase_loop.append(var11);
         this.erase_loop.append(var9);
         this.erase_loop.append(var12);
         this.erase_loop.append(var8);
         this.erase_loop.append(var13);
         this.erase_loop.append(var17);
         double var18 = Vector2.distance(var17, var10)
            + Vector2.distance(var10, var7)
            + Vector2.distance(var7, var11)
            + Vector2.distance(var11, var9)
            + Vector2.distance(var9, var12)
            + Vector2.distance(var12, var8)
            + Vector2.distance(var8, var13)
            + Vector2.distance(var13, var17);
         System.out.println("is_erase " + var4 / var18);
         return var4 / var18 > 1.5;
      }

      public void clear() {
         this.stroke = new LinkedList();
      }
   }

   public class MouseDispatcher extends MouseAdapter implements MouseMotionListener, KeyListener {
      public void mouseDragged(MouseEvent var1) {
         var1.consume();
         switch (DrawPanel.operation_status) {
            case 1:
               this.this$0.zooming_interim(var1);
               return;
            case 2:
               this.this$0.moving_interim(var1);
               return;
            case 3:
               this.this$0.drawing_interim(var1);
               return;
         }
      }

      public void mousePressed(MouseEvent var1) {
         var1.consume();
         this.this$0.is_ctrl = (var1.getModifiers() & 2) != 0;
         if ((var1.getModifiers() & 4) == 0 && (var1.getModifiers() & 1) == 0) {
            this.this$0.drawing_start(var1);
         } else if (var1.getClickCount() == 2) {
            this.this$0.zooming_start(var1);
         } else {
            this.this$0.moving_start(var1);
         }
      }

      public MouseDispatcher(DrawPanel var1) {
         (this.this$0 = var1).getClass();
      }

      public void mouseMoved(MouseEvent var1) {
      }

      public void keyTyped(KeyEvent var1) {
         this.this$0.toggleStyle();
      }

      public void keyPressed(KeyEvent var1) {
      }

      public void mouseReleased(MouseEvent var1) {
         var1.consume();
         switch (DrawPanel.operation_status) {
            case 1:
               this.this$0.zooming_end(var1);
               break;
            case 2:
               this.this$0.moving_end(var1);
               break;
            case 3:
               if (this.this$0.stroke_length > 10.0) {
                  this.this$0.drawing_finish(var1);
               } else {
                  if (this.this$0.teddy.temp_surface_lines.size() > 0) {
                     if (!this.this$0.teddy.section_bumping) {
                        this.this$0.teddy.surface_lines.connect(this.this$0.teddy.temp_surface_lines);
                     }

                     this.this$0.teddy.temp_surface_lines = new LinkedList();
                  }

                  DrawPanel.feedback.clear_stroke();
               }
         }

         DrawPanel.operation_status = 0;
      }

      public void keyReleased(KeyEvent var1) {
      }
   }
}
