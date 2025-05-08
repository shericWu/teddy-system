/*
 * Decompiled with CFR 0.152.
 */
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
import teddy.Bend;
import teddy.Cutting;
import teddy.Draw3DScene;
import teddy.Eraser;
import teddy.Generate;
import teddy.Graphics2;
import teddy.LinkedList;
import teddy.ObjFileHandler;
import teddy.Polyhedron;
import teddy.Pop;
import teddy.ReTessellation;
import teddy.Scene;
import teddy.Segment;
import teddy.Smooth;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Tessellation;
import teddy.Trianglation2D;
import teddy.Vector2;

class DrawPanel
extends Panel {
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
    public static Feedback feedback;
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

    private void draw_segment(Graphics graphics, Segment segment, Color color) {
        graphics.setColor(color);
        Graphics2.drawWideLine(graphics, DrawPanel.cX(segment.x1), DrawPanel.cY(segment.y1), DrawPanel.cX(segment.x2), DrawPanel.cY(segment.y2), scale);
    }

    public void moving_end(MouseEvent mouseEvent) {
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
        this.saved_teddy = this.saved_teddy2 != null ? this.saved_teddy2.copy() : null;
        this.repaint_all();
    }

    public void drawing_interim(MouseEvent mouseEvent) {
        this.xl = this.x2;
        this.yl = this.y2;
        this.x2 = mouseEvent.getX();
        this.y2 = mouseEvent.getY();
        this.stroke_length += Vector2.distance(this.xl, this.yl, this.x2, this.y2);
        feedback.add_point(this.x2, this.y2);
        this.repaint_feedback();
    }

    public void drawing_start(MouseEvent mouseEvent) {
        operation_status = 3;
        this.mouse_start(mouseEvent);
        this.stroke_length = 0.0;
        feedback.clear_stroke();
    }

    public static double rcY(int n) {
        return (double)(n - frameY) / scale;
    }

    public void setStyle(int n) {
        Draw3DScene.render_style = n;
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

    public void setLineStyle(int n) {
        Draw3DScene.line_style = n;
        this.repaint_all();
    }

    public static int cX(double d) {
        return (int)(d * scale) + frameX;
    }

    public void setShape(Polyhedron polyhedron) {
        scale = 1.0;
        Draw3DScene.current_polygon = null;
        feedback.clear();
        this.saved_teddy2 = this.saved_teddy;
        this.saved_teddy = this.teddy;
        this.teddy = polyhedron;
        this.repaint_all();
    }

    public String get_message() {
        if (this.teddy == null) {
            return "CREATION";
        }
        if (this.teddy.temp_surface_lines.size() > 0) {
            return "EXTRUSION";
        }
        if (this.bend_phase == 1) {
            return "BENDING";
        }
        if (this.bend_phase == 2) {
            return "BENDING";
        }
        if (this.annotating) {
            return "NOTE";
        }
        return "";
    }

    public void add_annotation(LinkedList linkedList) {
        this.annotating = true;
        this.annotations.addElement(linkedList);
    }

    public void update(Graphics graphics) {
        this.paint(graphics);
    }

    public void load(String string) {
        this.bend_end();
        if (this.teddy != null) {
            this.saved_teddy2 = this.saved_teddy;
            this.saved_teddy = this.teddy.copy();
        }
        try {
            BufferedReader bufferedReader;
            if (Teddy.in_browser) {
                InputStream inputStream = new URL(Teddy.teddy.getDocumentBase(), Teddy.filename(string)).openStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } else {
                bufferedReader = new BufferedReader(new FileReader(Teddy.filename(string)));
            }
            this.teddy = ObjFileHandler.load(bufferedReader);
            this.repaint_all();
            return;
        }
        catch (IOException iOException) {
            System.out.print("IO Error " + iOException);
            return;
        }
    }

    public void save(String string) {
        this.bend_end();
        ObjFileHandler.save(this.teddy, string);
    }

    public void moving_start(MouseEvent mouseEvent) {
        operation_status = 2;
        this.mouse_start(mouseEvent);
        this.clear_annotation();
    }

    public static double rcX(int n) {
        return (double)(n - frameX) / scale;
    }

    public void zooming_interim(MouseEvent mouseEvent) {
        scale = original_scale * Math.pow(Math.E, (double)(mouseEvent.getY() - this.y1) / 100.0);
        frameX = this.x1 + (int)((double)(original_frameX - this.x1) * scale / original_scale);
        frameY = this.y1 + (int)((double)(original_frameY - this.y1) * scale / original_scale);
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

    public void paint_annotations(Graphics graphics) {
        int n = 0;
        while (n < this.annotations.size()) {
            LinkedList linkedList = (LinkedList)this.annotations.elementAt(n);
            Enumeration enumeration = linkedList.elements();
            Point point = (Point)enumeration.nextElement();
            while (enumeration.hasMoreElements()) {
                Point point2 = (Point)enumeration.nextElement();
                Graphics2.drawWideLine(graphics, point.x, point.y, point2.x, point2.y, scale * 6.0);
                point = point2;
            }
            ++n;
        }
    }

    public DrawPanel() {
        feedback = new Feedback();
        this.setBackground(Color.white);
        MouseDispatcher mouseDispatcher = new MouseDispatcher();
        this.addMouseMotionListener(mouseDispatcher);
        this.addKeyListener(mouseDispatcher);
        this.addMouseListener(mouseDispatcher);
        this.scene = new Scene();
        this.state = 0;
        this.saved_teddy2 = null;
        this.saved_teddy = null;
        this.teddy = null;
        this.load("default");
        this.setStyle(4);
        this.setLineStyle(2);
    }

    public void bend(LinkedList linkedList) {
        if (this.bend_phase == 1) {
            ++this.bend_phase;
            this.bend_stroke0 = linkedList;
            return;
        }
        if (this.bend_phase == 2) {
            this.bend_stroke1 = linkedList;
            Bend.bend(this.bend_stroke0, this.bend_stroke1, this.teddy);
            this.bend_phase = 0;
            feedback.clear_stroke();
        }
    }

    public void zooming_end(MouseEvent mouseEvent) {
        Draw3DScene.in_motion = false;
        this.repaint_all();
    }

    public void note() {
        this.annotating = !this.annotating;
    }

    public static double rc(double d) {
        return d / scale;
    }

    public void paint(Graphics graphics) {
        if (this.redraw_background) {
            if (this.buffered_image == null) {
                this.buffered_image = this.createImage(this.getSize().width, this.getSize().height);
            } else if (this.buffered_image.getWidth(null) != this.getSize().width || this.buffered_image.getHeight(null) != this.getSize().height) {
                this.buffered_image = this.createImage(this.getSize().width, this.getSize().height);
            }
            Graphics graphics2 = this.buffered_image.getGraphics();
            graphics2.clearRect(0, 0, this.getSize().width, this.getSize().height);
            graphics2.setPaintMode();
            Enumeration enumeration = this.scene.elements();
            while (enumeration.hasMoreElements()) {
                this.draw_segment(graphics2, (Segment)enumeration.nextElement(), Color.black);
            }
            if (special_segment != null) {
                this.draw_segment(graphics2, special_segment, Color.blue);
            }
            enumeration = special_segments.elements();
            while (enumeration.hasMoreElements()) {
                this.draw_segment(graphics2, (Segment)enumeration.nextElement(), Color.blue);
            }
            Draw3DScene.paint(graphics2, this.teddy, scale, this.getSize());
            graphics2.dispose();
            graphics.drawImage(this.buffered_image, 0, 0, this);
            feedback.draw(graphics);
            this.redraw_background = false;
            graphics.setColor(Color.red);
            graphics.setFont(new Font("SansSerif", 0, 24));
            graphics.drawString(this.get_message(), 10, 30);
            this.paint_annotations(graphics);
            return;
        }
        feedback.draw(graphics);
    }

    public void bend_start() {
        this.bend_stroke0 = null;
        this.bend_stroke1 = null;
        this.bend_phase = 1;
        this.repaint_all();
    }

    public void drawing_finish(MouseEvent mouseEvent) {
        if (this.annotating) {
            this.add_annotation(DrawPanel.feedback.stroke);
            feedback.clear_stroke();
            return;
        }
        if (this.teddy != null) {
            this.saved_teddy2 = this.saved_teddy;
            this.saved_teddy = this.teddy.copy();
        }
        if (this.bend_phase > 0) {
            if (this.teddy != null) {
                this.bend(DrawPanel.feedback.stroke);
                this.repaint_all();
                return;
            }
            this.scene = Trianglation2D.generate_scene(DrawPanel.feedback.stroke);
            this.bend_phase = 0;
        } else if (this.teddy != null) {
            if (this.teddy.temp_surface_lines.size() > 0) {
                if (feedback.is_erase()) {
                    Smooth.smooth(this.teddy);
                } else {
                    Pop.pop(DrawPanel.feedback.stroke, this.teddy);
                }
            } else if (feedback.is_erase()) {
                Eraser.erase(DrawPanel.feedback.erase_loop, this.teddy);
            } else if (SurfaceLine.generate_surface_lines(DrawPanel.feedback.stroke, this.teddy, this.is_ctrl) && Cutting.cut(DrawPanel.feedback.stroke, this.teddy, this.is_ctrl)) {
                this.add_annotation(DrawPanel.feedback.stroke);
            }
        } else {
            this.teddy = Generate.generate(DrawPanel.feedback.stroke);
        }
        feedback.clear_stroke();
        Draw3DScene.in_motion = false;
        this.repaint_all();
    }

    public void removeThin() {
        Tessellation.remove_thin_polygons(this.teddy);
        this.repaint_all();
    }

    public void smooth() {
        ReTessellation.smooth(this.teddy);
        this.repaint_all();
    }

    public void moving_interim(MouseEvent mouseEvent) {
        if (this.teddy != null) {
            int n = this.getSize().width / 2;
            int n2 = this.getSize().height / 2;
            Point point = new Point(n, n2);
            int n3 = mouseEvent.getX();
            int n4 = mouseEvent.getY();
            this.teddy.rotate_z((n3 - this.x1) * (n2 - Math.abs(n4 - point.y)) / n2);
            this.teddy.rotate_x((n4 - this.y1) * (n - Math.abs(n3 - point.x)) / n);
            Vector2 vector2 = new Vector2(n3 - point.x, n4 - point.y);
            Vector2 vector22 = new Vector2(n3 - this.x1, n4 - this.y1);
            double d = vector2.cross_product(vector22) / (double)n2;
            this.teddy.rotate_y(d / 4.0);
        }
        frameX += mouseEvent.getX() - this.x1;
        frameY += mouseEvent.getY() - this.y1;
        this.x1 = mouseEvent.getX();
        this.y1 = mouseEvent.getY();
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

    public static int cY(double d) {
        return (int)(d * scale) + frameY;
    }

    public void zooming_start(MouseEvent mouseEvent) {
        operation_status = 1;
        original_scale = scale;
        original_frameX = frameX;
        original_frameY = frameY;
        this.mouse_start(mouseEvent);
    }

    public void mouse_start(MouseEvent mouseEvent) {
        this.x1 = mouseEvent.getX();
        this.y1 = mouseEvent.getY();
        this.x2 = this.x1;
        this.y2 = this.y1;
    }

    public class Feedback {
        public LinkedList stroke;
        public LinkedList erase_loop;

        public void clear_stroke() {
            this.stroke = new LinkedList();
        }

        public void draw(Graphics graphics) {
            Enumeration enumeration;
            graphics.setColor(Color.red);
            if (DrawPanel.this.bend_phase == 2 && operation_status == 3) {
                graphics.setColor(Color.blue);
            }
            if (!(enumeration = this.stroke.elements()).hasMoreElements()) {
                return;
            }
            Point point = (Point)enumeration.nextElement();
            while (enumeration.hasMoreElements()) {
                Point point2 = (Point)enumeration.nextElement();
                Graphics2.drawWideLine(graphics, point.x, point.y, point2.x, point2.y, scale * 6.0);
                point = point2;
            }
        }

        Feedback() {
            DrawPanel.this.getClass();
            this.stroke = new LinkedList();
        }

        public void add_point(int n, int n2) {
            this.stroke.append(new Point(n, n2));
        }

        private void check_erase_loop() {
            Enumeration enumeration = this.erase_loop.elements();
            Point point = (Point)enumeration.nextElement();
            while (enumeration.hasMoreElements()) {
                Point point2 = (Point)enumeration.nextElement();
                Segment segment = new Segment(DrawPanel.rcX(point.x), DrawPanel.rcY(point.y), DrawPanel.rcX(point2.x), DrawPanel.rcY(point2.y));
                DrawPanel.this.scene.append(segment);
                point = point2;
            }
        }

        public boolean is_erase() {
            Point point;
            Enumeration enumeration = this.stroke.elements();
            Point point2 = (Point)enumeration.nextElement();
            Point point3 = new Point(point2);
            double d = 0.0;
            while (enumeration.hasMoreElements()) {
                point = (Point)enumeration.nextElement();
                point3.x += point.x;
                point3.y += point.y;
                d += Vector2.distance(point2, point);
                point2 = point;
            }
            point3.x /= this.stroke.size();
            point3.y /= this.stroke.size();
            point = point3;
            Point point4 = point3;
            Point point5 = point3;
            Point point6 = point3;
            Point point7 = point3;
            Point point8 = point3;
            Point point9 = point3;
            Point point10 = point3;
            enumeration = this.stroke.elements();
            while (enumeration.hasMoreElements()) {
                Point point11 = (Point)enumeration.nextElement();
                if (point11.y < point.y) {
                    point = point11;
                }
                if (point11.y > point6.y) {
                    point6 = point11;
                }
                if (point11.x < point4.x) {
                    point4 = point11;
                }
                if (point11.x > point5.x) {
                    point5 = point11;
                }
                if (point11.y + point11.x < point7.y + point7.x) {
                    point7 = point11;
                }
                if (point11.y - point11.x > point8.y - point8.x) {
                    point8 = point11;
                }
                if (point11.y + point11.x > point9.y + point9.x) {
                    point9 = point11;
                }
                if (point11.y - point11.x >= point10.y - point10.x) continue;
                point10 = point11;
            }
            this.erase_loop = new LinkedList();
            this.erase_loop.append(point);
            this.erase_loop.append(point7);
            this.erase_loop.append(point4);
            this.erase_loop.append(point8);
            this.erase_loop.append(point6);
            this.erase_loop.append(point9);
            this.erase_loop.append(point5);
            this.erase_loop.append(point10);
            this.erase_loop.append(point);
            double d2 = Vector2.distance(point, point7) + Vector2.distance(point7, point4) + Vector2.distance(point4, point8) + Vector2.distance(point8, point6) + Vector2.distance(point6, point9) + Vector2.distance(point9, point5) + Vector2.distance(point5, point10) + Vector2.distance(point10, point);
            System.out.println("is_erase " + d / d2);
            return d / d2 > 1.5;
        }

        public void clear() {
            this.stroke = new LinkedList();
        }
    }

    public class MouseDispatcher
    extends MouseAdapter
    implements MouseMotionListener,
    KeyListener {
        public void mouseDragged(MouseEvent mouseEvent) {
            mouseEvent.consume();
            switch (operation_status) {
                case 1: {
                    DrawPanel.this.zooming_interim(mouseEvent);
                    return;
                }
                case 2: {
                    DrawPanel.this.moving_interim(mouseEvent);
                    return;
                }
                case 3: {
                    DrawPanel.this.drawing_interim(mouseEvent);
                    return;
                }
            }
        }

        public void mousePressed(MouseEvent mouseEvent) {
            mouseEvent.consume();
            boolean bl = DrawPanel.this.is_ctrl = (mouseEvent.getModifiers() & 2) != 0;
            if ((mouseEvent.getModifiers() & 4) != 0 || (mouseEvent.getModifiers() & 1) != 0) {
                if (mouseEvent.getClickCount() == 2) {
                    DrawPanel.this.zooming_start(mouseEvent);
                    return;
                }
                DrawPanel.this.moving_start(mouseEvent);
                return;
            }
            DrawPanel.this.drawing_start(mouseEvent);
        }

        public MouseDispatcher() {
            DrawPanel.this.getClass();
        }

        public void mouseMoved(MouseEvent mouseEvent) {
        }

        public void keyTyped(KeyEvent keyEvent) {
            DrawPanel.this.toggleStyle();
        }

        public void keyPressed(KeyEvent keyEvent) {
        }

        public void mouseReleased(MouseEvent mouseEvent) {
            mouseEvent.consume();
            switch (operation_status) {
                case 1: {
                    DrawPanel.this.zooming_end(mouseEvent);
                    break;
                }
                case 2: {
                    DrawPanel.this.moving_end(mouseEvent);
                    break;
                }
                case 3: {
                    if (DrawPanel.this.stroke_length > 10.0) {
                        DrawPanel.this.drawing_finish(mouseEvent);
                        break;
                    }
                    if (DrawPanel.this.teddy.temp_surface_lines.size() > 0) {
                        if (!DrawPanel.this.teddy.section_bumping) {
                            DrawPanel.this.teddy.surface_lines.connect(DrawPanel.this.teddy.temp_surface_lines);
                        }
                        DrawPanel.this.teddy.temp_surface_lines = new LinkedList();
                    }
                    feedback.clear_stroke();
                }
            }
            operation_status = 0;
        }

        public void keyReleased(KeyEvent keyEvent) {
        }
    }
}

