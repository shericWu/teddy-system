// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DrawPanel.java

package teddy;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Segment, Graphics2, Draw3DScene, Polyhedron, 
//            Vector2, LinkedList, Teddy, ObjFileHandler, 
//            Scene, Bend, Segments, Trianglation2D, 
//            Smooth, Pop, Eraser, SurfaceLine, 
//            Cutting, Generate, Tessellation, ReTessellation

class DrawPanel extends Panel
{
    public class Feedback
    {

        public void clear_stroke()
        {
            stroke = new LinkedList();
        }

        public void draw(Graphics g)
        {
            g.setColor(Color.red);
            if(bend_phase == 2 && DrawPanel.operation_status == 3)
                g.setColor(Color.blue);
            Enumeration enumeration = stroke.elements();
            if(!enumeration.hasMoreElements())
                return;
            Point point1;
            for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
            {
                point1 = (Point)enumeration.nextElement();
                Graphics2.drawWideLine(g, point.x, point.y, point1.x, point1.y, DrawPanel.scale * 6D);
            }

        }

        public void add_point(int i, int j)
        {
            stroke.append(new Point(i, j));
        }

        private void check_erase_loop()
        {
            Enumeration enumeration = erase_loop.elements();
            Point point1;
            for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
            {
                point1 = (Point)enumeration.nextElement();
                Segment segment = new Segment(DrawPanel.rcX(point.x), DrawPanel.rcY(point.y), DrawPanel.rcX(point1.x), DrawPanel.rcY(point1.y));
                scene.append(segment);
            }

        }

        public boolean is_erase()
        {
            Enumeration enumeration = stroke.elements();
            Point point = (Point)enumeration.nextElement();
            Point point1 = new Point(point);
            double d = 0.0D;
            while(enumeration.hasMoreElements()) 
            {
                Point point2 = (Point)enumeration.nextElement();
                point1.x += point2.x;
                point1.y += point2.y;
                d += Vector2.distance(point, point2);
                point = point2;
            }
            point1.x = point1.x / stroke.size();
            point1.y = point1.y / stroke.size();
            Point point3 = point1;
            Point point4 = point1;
            Point point5 = point1;
            Point point6 = point1;
            Point point7 = point1;
            Point point8 = point1;
            Point point9 = point1;
            Point point10 = point1;
            for(Enumeration enumeration1 = stroke.elements(); enumeration1.hasMoreElements();)
            {
                Point point11 = (Point)enumeration1.nextElement();
                if(point11.y < point3.y)
                    point3 = point11;
                if(point11.y > point6.y)
                    point6 = point11;
                if(point11.x < point4.x)
                    point4 = point11;
                if(point11.x > point5.x)
                    point5 = point11;
                if(point11.y + point11.x < point7.y + point7.x)
                    point7 = point11;
                if(point11.y - point11.x > point8.y - point8.x)
                    point8 = point11;
                if(point11.y + point11.x > point9.y + point9.x)
                    point9 = point11;
                if(point11.y - point11.x < point10.y - point10.x)
                    point10 = point11;
            }

            erase_loop = new LinkedList();
            erase_loop.append(point3);
            erase_loop.append(point7);
            erase_loop.append(point4);
            erase_loop.append(point8);
            erase_loop.append(point6);
            erase_loop.append(point9);
            erase_loop.append(point5);
            erase_loop.append(point10);
            erase_loop.append(point3);
            double d1 = Vector2.distance(point3, point7) + Vector2.distance(point7, point4) + Vector2.distance(point4, point8) + Vector2.distance(point8, point6) + Vector2.distance(point6, point9) + Vector2.distance(point9, point5) + Vector2.distance(point5, point10) + Vector2.distance(point10, point3);
            System.out.println("is_erase " + d / d1);
            return d / d1 > 1.5D;
        }

        public void clear()
        {
            stroke = new LinkedList();
        }

        public LinkedList stroke;
        public LinkedList erase_loop;

        Feedback()
        {
            stroke = new LinkedList();
        }
    }

    public class MouseDispatcher extends MouseAdapter
        implements MouseMotionListener, KeyListener
    {

        public void mouseDragged(MouseEvent mouseevent)
        {
            mouseevent.consume();
            switch(DrawPanel.operation_status)
            {
            case 1: // '\001'
                zooming_interim(mouseevent);
                return;

            case 2: // '\002'
                moving_interim(mouseevent);
                return;

            case 3: // '\003'
                drawing_interim(mouseevent);
                return;
            }
        }

        public void mousePressed(MouseEvent mouseevent)
        {
            mouseevent.consume();
            is_ctrl = (mouseevent.getModifiers() & 2) != 0;
            if((mouseevent.getModifiers() & 4) != 0 || (mouseevent.getModifiers() & 1) != 0)
            {
                if(mouseevent.getClickCount() == 2)
                {
                    zooming_start(mouseevent);
                    return;
                } else
                {
                    moving_start(mouseevent);
                    return;
                }
            } else
            {
                drawing_start(mouseevent);
                return;
            }
        }

        public void mouseMoved(MouseEvent mouseevent)
        {
        }

        public void keyTyped(KeyEvent keyevent)
        {
            toggleStyle();
        }

        public void keyPressed(KeyEvent keyevent)
        {
        }

        public void mouseReleased(MouseEvent mouseevent)
        {
            mouseevent.consume();
            switch(DrawPanel.operation_status)
            {
            default:
                break;

            case 1: // '\001'
                zooming_end(mouseevent);
                break;

            case 2: // '\002'
                moving_end(mouseevent);
                break;

            case 3: // '\003'
                if(stroke_length > 10D)
                {
                    drawing_finish(mouseevent);
                    break;
                }
                if(teddy.temp_surface_lines.size() > 0)
                {
                    if(!teddy.section_bumping)
                        teddy.surface_lines.connect(teddy.temp_surface_lines);
                    teddy.temp_surface_lines = new LinkedList();
                }
                DrawPanel.feedback.clear_stroke();
                break;
            }
            DrawPanel.operation_status = 0;
        }

        public void keyReleased(KeyEvent keyevent)
        {
        }

        public MouseDispatcher()
        {
        }
    }


    private void draw_segment(Graphics g, Segment segment, Color color)
    {
        g.setColor(color);
        Graphics2.drawWideLine(g, cX(segment.x1), cY(segment.y1), cX(segment.x2), cY(segment.y2), scale);
    }

    public void moving_end(MouseEvent mouseevent)
    {
        Draw3DScene.in_motion = false;
        repaint_all();
    }

    public void undo()
    {
        bend_end();
        Draw3DScene.current_polygon = null;
        feedback.clear();
        if(teddy != null)
            teddy.restore(saved_teddy);
        else
            teddy = saved_teddy;
        if(saved_teddy2 != null)
            saved_teddy = saved_teddy2.copy();
        else
            saved_teddy = null;
        repaint_all();
    }

    public void drawing_interim(MouseEvent mouseevent)
    {
        xl = x2;
        yl = y2;
        x2 = mouseevent.getX();
        y2 = mouseevent.getY();
        stroke_length += Vector2.distance(xl, yl, x2, y2);
        feedback.add_point(x2, y2);
        repaint_feedback();
    }

    public void drawing_start(MouseEvent mouseevent)
    {
        operation_status = 3;
        mouse_start(mouseevent);
        stroke_length = 0.0D;
        feedback.clear_stroke();
    }

    public static double rcY(int i)
    {
        return (double)(i - frameY) / scale;
    }

    public void setStyle(int i)
    {
        Draw3DScene.render_style = i;
        repaint_all();
    }

    public void toggleStyle()
    {
        if(Draw3DScene.render_style != 4)
        {
            Draw3DScene.render_style = 4;
            Draw3DScene.line_style = 2;
        } else
        {
            Draw3DScene.render_style = 1;
            Draw3DScene.line_style = 0;
        }
        repaint_all();
    }

    public void setLineStyle(int i)
    {
        Draw3DScene.line_style = i;
        repaint_all();
    }

    public static int cX(double d)
    {
        return (int)(d * scale) + frameX;
    }

    public void setShape(Polyhedron polyhedron)
    {
        scale = 1.0D;
        Draw3DScene.current_polygon = null;
        feedback.clear();
        saved_teddy2 = saved_teddy;
        saved_teddy = teddy;
        teddy = polyhedron;
        repaint_all();
    }

    public String get_message()
    {
        if(teddy == null)
            return "CREATION";
        if(teddy.temp_surface_lines.size() > 0)
            return "EXTRUSION";
        if(bend_phase == 1)
            return "BENDING";
        if(bend_phase == 2)
            return "BENDING";
        if(annotating)
            return "NOTE";
        else
            return "";
    }

    public void add_annotation(LinkedList linkedlist)
    {
        annotating = true;
        annotations.addElement(linkedlist);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void load(String s)
    {
        bend_end();
        if(teddy != null)
        {
            saved_teddy2 = saved_teddy;
            saved_teddy = teddy.copy();
        }
        try
        {
            BufferedReader bufferedreader;
            if(Teddy.in_browser)
            {
                java.io.InputStream inputstream = (new URL(Teddy.teddy.getDocumentBase(), Teddy.filename(s))).openStream();
                bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            } else
            {
                bufferedreader = new BufferedReader(new FileReader(Teddy.filename(s)));
            }
            teddy = ObjFileHandler.load(bufferedreader);
            repaint_all();
            return;
        }
        catch(IOException ioexception)
        {
            System.out.print("IO Error " + ioexception);
        }
    }

    public void save(String s)
    {
        bend_end();
        ObjFileHandler.save(teddy, s);
    }

    public void moving_start(MouseEvent mouseevent)
    {
        operation_status = 2;
        mouse_start(mouseevent);
        clear_annotation();
    }

    public static double rcX(int i)
    {
        return (double)(i - frameX) / scale;
    }

    public void zooming_interim(MouseEvent mouseevent)
    {
        scale = original_scale * Math.pow(2.7182818284590451D, (double)(mouseevent.getY() - y1) / 100D);
        frameX = x1 + (int)(((double)(original_frameX - x1) * scale) / original_scale);
        frameY = y1 + (int)(((double)(original_frameY - y1) * scale) / original_scale);
        Draw3DScene.in_motion = true;
        repaint_all();
    }

    public void repaint_all()
    {
        redraw_background = true;
        if(teddy != null)
            teddy.view_changed = true;
        repaint();
    }

    public void paint_annotations(Graphics g)
    {
        for(int i = 0; i < annotations.size(); i++)
        {
            LinkedList linkedlist = (LinkedList)annotations.elementAt(i);
            Enumeration enumeration = linkedlist.elements();
            Point point1;
            for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
            {
                point1 = (Point)enumeration.nextElement();
                Graphics2.drawWideLine(g, point.x, point.y, point1.x, point1.y, scale * 6D);
            }

        }

    }

    public DrawPanel()
    {
        bend_stroke0 = null;
        bend_stroke1 = null;
        bend_phase = 0;
        annotating = false;
        annotations = new Vector();
        redraw_background = true;
        is_ctrl = false;
        feedback = new Feedback();
        setBackground(Color.white);
        MouseDispatcher mousedispatcher = new MouseDispatcher();
        addMouseMotionListener(mousedispatcher);
        addKeyListener(mousedispatcher);
        addMouseListener(mousedispatcher);
        scene = new Scene();
        state = 0;
        saved_teddy2 = null;
        saved_teddy = null;
        teddy = null;
        load("default");
        setStyle(4);
        setLineStyle(2);
    }

    public void bend(LinkedList linkedlist)
    {
        if(bend_phase == 1)
        {
            bend_phase++;
            bend_stroke0 = linkedlist;
            return;
        }
        if(bend_phase == 2)
        {
            bend_stroke1 = linkedlist;
            Bend.bend(bend_stroke0, bend_stroke1, teddy);
            bend_phase = 0;
            feedback.clear_stroke();
        }
    }

    public void zooming_end(MouseEvent mouseevent)
    {
        Draw3DScene.in_motion = false;
        repaint_all();
    }

    public void note()
    {
        annotating = !annotating;
    }

    public static double rc(double d)
    {
        return d / scale;
    }

    public void paint(Graphics g)
    {
        if(redraw_background)
        {
            if(buffered_image == null)
                buffered_image = createImage(getSize().width, getSize().height);
            else
            if(buffered_image.getWidth(null) != getSize().width || buffered_image.getHeight(null) != getSize().height)
                buffered_image = createImage(getSize().width, getSize().height);
            Graphics g1 = buffered_image.getGraphics();
            g1.clearRect(0, 0, getSize().width, getSize().height);
            g1.setPaintMode();
            for(Enumeration enumeration = scene.elements(); enumeration.hasMoreElements(); draw_segment(g1, (Segment)enumeration.nextElement(), Color.black));
            if(special_segment != null)
                draw_segment(g1, special_segment, Color.blue);
            for(Enumeration enumeration1 = special_segments.elements(); enumeration1.hasMoreElements(); draw_segment(g1, (Segment)enumeration1.nextElement(), Color.blue));
            Draw3DScene.paint(g1, teddy, scale, getSize());
            g1.dispose();
            g.drawImage(buffered_image, 0, 0, this);
            feedback.draw(g);
            redraw_background = false;
            g.setColor(Color.red);
            g.setFont(new Font("SansSerif", 0, 24));
            g.drawString(get_message(), 10, 30);
            paint_annotations(g);
            return;
        } else
        {
            feedback.draw(g);
            return;
        }
    }

    public void bend_start()
    {
        bend_stroke0 = null;
        bend_stroke1 = null;
        bend_phase = 1;
        repaint_all();
    }

    public void drawing_finish(MouseEvent mouseevent)
    {
        if(annotating)
        {
            add_annotation(feedback.stroke);
            feedback.clear_stroke();
            return;
        }
        if(teddy != null)
        {
            saved_teddy2 = saved_teddy;
            saved_teddy = teddy.copy();
        }
        if(bend_phase > 0)
        {
            if(teddy != null)
            {
                bend(feedback.stroke);
                repaint_all();
                return;
            }
            scene = Trianglation2D.generate_scene(feedback.stroke);
            bend_phase = 0;
        } else
        if(teddy != null)
        {
            if(teddy.temp_surface_lines.size() > 0)
            {
                if(feedback.is_erase())
                    Smooth.smooth(teddy);
                else
                    Pop.pop(feedback.stroke, teddy);
            } else
            if(feedback.is_erase())
                Eraser.erase(feedback.erase_loop, teddy);
            else
            if(SurfaceLine.generate_surface_lines(feedback.stroke, teddy, is_ctrl) && Cutting.cut(feedback.stroke, teddy, is_ctrl))
                add_annotation(feedback.stroke);
        } else
        {
            teddy = Generate.generate(feedback.stroke);
        }
        feedback.clear_stroke();
        Draw3DScene.in_motion = false;
        repaint_all();
    }

    public void removeThin()
    {
        Tessellation.remove_thin_polygons(teddy);
        repaint_all();
    }

    public void smooth()
    {
        ReTessellation.smooth(teddy);
        repaint_all();
    }

    public void moving_interim(MouseEvent mouseevent)
    {
        if(teddy != null)
        {
            int i = getSize().width / 2;
            int j = getSize().height / 2;
            Point point = new Point(i, j);
            int k = mouseevent.getX();
            int l = mouseevent.getY();
            teddy.rotate_z(((k - x1) * (j - Math.abs(l - point.y))) / j);
            teddy.rotate_x(((l - y1) * (i - Math.abs(k - point.x))) / i);
            Vector2 vector2 = new Vector2(k - point.x, l - point.y);
            Vector2 vector2_1 = new Vector2(k - x1, l - y1);
            double d = vector2.cross_product(vector2_1) / (double)j;
            teddy.rotate_y(d / 4D);
        }
        frameX += mouseevent.getX() - x1;
        frameY += mouseevent.getY() - y1;
        x1 = mouseevent.getX();
        y1 = mouseevent.getY();
        Draw3DScene.in_motion = true;
        repaint_all();
    }

    public void clear_annotation()
    {
        annotating = false;
        annotations = new Vector();
    }

    public void repaint_feedback()
    {
        redraw_background = false;
        repaint();
    }

    public void retessellate()
    {
        scene = Trianglation2D.rearrange_scene();
        repaint_all();
    }

    public void init()
    {
        bend_end();
        setShape(null);
    }

    public void bend_end()
    {
        bend_phase = 0;
    }

    public static int cY(double d)
    {
        return (int)(d * scale) + frameY;
    }

    public void zooming_start(MouseEvent mouseevent)
    {
        operation_status = 1;
        original_scale = scale;
        original_frameX = frameX;
        original_frameY = frameY;
        mouse_start(mouseevent);
    }

    public void mouse_start(MouseEvent mouseevent)
    {
        x1 = mouseevent.getX();
        y1 = mouseevent.getY();
        x2 = x1;
        y2 = y1;
    }

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
    public static double scale = 1.0D;
    public static double original_scale = 1.0D;
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
    public LinkedList bend_stroke0;
    public LinkedList bend_stroke1;
    public int bend_phase;
    boolean annotating;
    Vector annotations;
    boolean redraw_background;
    Image buffered_image;
    public boolean is_ctrl;

}
