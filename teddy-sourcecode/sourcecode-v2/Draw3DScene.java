// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Draw3DScene.java

package teddy;

import java.awt.*;
import java.util.Enumeration;
import java.util.Random;

// Referenced classes of package teddy:
//            Geometry, Polyhedron, Polygon2, Vector2, 
//            Vector3, Graphics2, Vertex, SilhouetteFind, 
//            LinkedList, ProjectedEdge, SurfaceLine, Edge, 
//            Vertex2D

class Draw3DScene
{

    public static double reverse_convertY(double d)
    {
        return -(d - (double)centerY) / scale;
    }

    private static void paint_z_buffer(Graphics g, Polyhedron polyhedron, boolean flag)
    {
        Geometry.init(polyhedron, camera);
        for(int i = polyhedron.n_polygons - 1; i > -1; i--)
        {
            Polygon2 polygon2 = Geometry.sorted_polygons[i];
            polygon2.check_facing(camera);
            if(polygon2.front_facing)
            {
                draw_white_polygon(g, polygon2);
                if(!flag)
                    fillRandom(g, polygon2);
                draw_silhouette_edges(g, polygon2);
            }
        }

    }

    public static void fillRandom(Graphics g, Polygon2 polygon2)
    {
        Point point = project(polygon2.get_vertex(0));
        Point point1 = project(polygon2.get_vertex(1));
        Point point2 = project(polygon2.get_vertex(2));
        Vector2 vector2 = new Vector2(point, point1);
        Vector2 vector2_1 = new Vector2(point, point2);
        Vector3 vector3 = polygon2.absolute_normal().get_normalized();
        Vector2 vector2_2 = project(vector3).normalize();
        double d = Vector2.distance(0.0D, 0.0D, vector3.x, vector3.z);
        double d1 = Math.abs(vector2.cross_product(vector2_1));
        d = Math.max(d - 0.59999999999999998D, 0.0D);
        int i = (int)(d1 * d * d * 0.29999999999999999D);
        for(int j = 0; j < i; j++)
        {
            double d2 = rand.nextDouble();
            double d3 = rand.nextDouble();
            double d6 = rand.nextDouble();
            double d4 = d3 * d2;
            double d5 = (1.0D - d3) * d2;
            g.setColor(new Color(0, 0, 0));
            Graphics2.drawRandomLine(g, (int)((double)point.x + d4 * vector2.x + d5 * vector2_1.x + 8D * d6 * vector2_2.y), (int)(((double)point.y + d4 * vector2.y + d5 * vector2_1.y) - 8D * d6 * vector2_2.x), (int)(((double)point.x + d4 * vector2.x + d5 * vector2_1.x) - 8D * d6 * vector2_2.y), (int)((double)point.y + d4 * vector2.y + d5 * vector2_1.y + 8D * d6 * vector2_2.x));
        }

    }

    public static double project_x(Vertex vertex)
    {
        return (vertex.x() * (double)eye_z) / (vertex.y() + (double)eye_z);
    }

    public static void draw_polygon(Graphics g, Polygon2 polygon2, Color color)
    {
        for(int i = 0; i < polygon2.n_edges; i++)
            draw_edge(g, polygon2.edges[i], color);

    }

    private static void paint_silhouette(Graphics g, Polyhedron polyhedron)
    {
        LinkedList linkedlist = SilhouetteFind.find_visible_edges(polyhedron, camera);
        ProjectedEdge projectededge;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); draw_projected_edge(g, projectededge, Color.black))
            projectededge = (ProjectedEdge)enumeration.nextElement();

    }

    public static double project_y(Vertex vertex)
    {
        return (vertex.z() * (double)eye_z) / (vertex.y() + (double)eye_z);
    }

    public static void paint(Graphics g, Polyhedron polyhedron, double d, Dimension dimension)
    {
        scale = d * (double)basic_scale;
        line_scale = d * 6D;
        centerX = dimension.width / 2;
        centerY = dimension.height / 2;
        g.setPaintMode();
        camera = new Vertex(0.0D, -eye_z, 0.0D);
        if(polyhedron == null)
            return;
        switch(render_style)
        {
        default:
            break;

        case 0: // '\0'
            if(!in_motion)
                Geometry.init(polyhedron, camera);
            for(int i = 0; i < polyhedron.n_edges; i++)
                draw_edge(g, polyhedron.edges[i], Color.black);

            break;

        case 1: // '\001'
            if(!in_motion)
                Geometry.init(polyhedron, camera);
            for(int j = 0; j < polyhedron.n_polygons; j++)
            {
                polyhedron.polygons[j].check_facing(camera);
                if(polyhedron.polygons[j].front_facing)
                    draw_polygon(g, polyhedron.polygons[j], Color.black);
            }

            break;

        case 3: // '\003'
            if(!in_motion)
            {
                Geometry.init(polyhedron, camera);
                for(int k = polyhedron.n_polygons - 1; k > -1; k--)
                {
                    Polygon2 polygon2 = Geometry.sorted_polygons[k];
                    polygon2.check_facing(camera);
                    if(polygon2.front_facing)
                        draw_shaded_polygon(g, polygon2);
                }

            }
            paint_silhouette(g, polyhedron);
            break;

        case 4: // '\004'
            if(!in_motion)
            {
                Geometry.init(polyhedron, camera);
                for(int l = polyhedron.n_polygons - 1; l > -1; l--)
                {
                    Polygon2 polygon2_1 = Geometry.sorted_polygons[l];
                    polygon2_1.check_facing(camera);
                    if(polygon2_1.front_facing)
                    {
                        draw_white_polygon(g, polygon2_1);
                        fillRandom(g, polygon2_1);
                    }
                }

            }
            paint_silhouette(g, polyhedron);
            break;

        case 2: // '\002'
            if(!in_motion)
                Geometry.init(polyhedron, camera);
            paint_silhouette(g, polyhedron);
            break;
        }
        paint_surfacelines(g, polyhedron);
        paint_temp_surfacelines(g, polyhedron);
        if(current_polygon != null)
            draw_polygon(g, current_polygon, Color.blue);
    }

    private static void draw_line(Graphics g, Color color, int i, int j, int k, int l)
    {
        g.setColor(color);
        switch(line_style)
        {
        case 0: // '\0'
            g.drawLine(i, j, k, l);
            return;

        case 1: // '\001'
            Graphics2.drawRandomLine(g, i, j, k, l);
            return;

        case 2: // '\002'
            Graphics2.drawWideLine(g, i, j, k, l, line_scale);
            return;
        }
    }

    Draw3DScene()
    {
    }

    public static int convertY(double d)
    {
        return centerY - (int)(d * scale);
    }

    public static double reverse_convertZ(double d)
    {
        return d / scale;
    }

    private static void paint_surfacelines(Graphics g, Polyhedron polyhedron)
    {
        Color color = Color.black;
        for(Enumeration enumeration = polyhedron.surface_lines.elements(); enumeration.hasMoreElements();)
        {
            SurfaceLine surfaceline = (SurfaceLine)enumeration.nextElement();
            if(surfaceline.polygon == null || surfaceline.polygon.front_facing)
                draw_edge(g, surfaceline, color);
        }

    }

    private static void draw_silhouette_edges(Graphics g, Polygon2 polygon2)
    {
        Color color = Color.black;
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Edge edge = polygon2.edges[i];
            Polygon2 polygon2_1 = edge.get_the_other_polygon(polygon2);
            polygon2_1.check_facing(camera);
            if(!polygon2_1.front_facing)
                draw_edge(g, edge, color);
        }

    }

    public static void draw_shaded_polygon(Graphics g, Polygon2 polygon2)
    {
        Vector3 vector3 = polygon2.absolute_normal();
        int i = (int)(75D - (180D * vector3.y) / vector3.length());
        g.setColor(new Color(i, i, i));
        draw_fill_polygon(g, polygon2);
    }

    public static Vector2 project(Vector3 vector3)
    {
        Vertex vertex = vector3.vertex();
        double d = convertX_vector(project_x(vertex));
        double d1 = convertY_vector(project_y(vertex));
        return new Vector2(d, d1);
    }

    public static Point project(Vertex vertex)
    {
        Point point = new Point();
        point.x = convertX(project_x(vertex));
        point.y = convertY(project_y(vertex));
        return point;
    }

    public static double reverse_convertX(int i)
    {
        return (double)(i - centerX) / scale;
    }

    private static void draw_edge(Graphics g, Edge edge, Color color)
    {
        g.setColor(color);
        Point point = project(edge.start());
        Point point1 = project(edge.end());
        draw_line(g, color, point.x, point.y, point1.x, point1.y);
    }

    private static void draw_projected_edge(Graphics g, ProjectedEdge projectededge, Color color)
    {
        draw_line(g, color, convertX(((Vector2) (projectededge.start)).x), convertY(((Vector2) (projectededge.start)).y), convertX(((Vector2) (projectededge.end)).x), convertY(((Vector2) (projectededge.end)).y));
    }

    public static double reverse_convertX(double d)
    {
        return (d - (double)centerX) / scale;
    }

    public static int convertX_vector(double d)
    {
        return (int)(d * scale);
    }

    public static int convertY_vector(double d)
    {
        return -(int)(d * scale);
    }

    public static void draw_white_polygon(Graphics g, Polygon2 polygon2)
    {
        g.setColor(Color.white);
        draw_fill_polygon(g, polygon2);
    }

    public static void draw_fill_polygon(Graphics g, Polygon2 polygon2)
    {
        int ai[] = new int[polygon2.n_edges];
        int ai1[] = new int[polygon2.n_edges];
        for(int i = 0; i < polygon2.n_edges; i++)
        {
            Point point = project(polygon2.get_vertex(i));
            ai[i] = point.x;
            ai1[i] = point.y;
        }

        g.fillPolygon(ai, ai1, polygon2.n_edges);
    }

    public static int convertX(double d)
    {
        return centerX + (int)(d * scale);
    }

    private static void paint_temp_surfacelines(Graphics g, Polyhedron polyhedron)
    {
        Color color = Color.red;
        for(Enumeration enumeration = polyhedron.temp_surface_lines.elements(); enumeration.hasMoreElements();)
        {
            SurfaceLine surfaceline = (SurfaceLine)enumeration.nextElement();
            if(surfaceline.polygon == null || surfaceline.polygon.front_facing)
                draw_edge(g, surfaceline, color);
        }

    }

    public static Vertex image_plane_to_world_coords(Vertex2D vertex2d)
    {
        return new Vertex(((Vector2) (vertex2d)).x, 0.0D, ((Vector2) (vertex2d)).y);
    }

    public static void set_front_facing(Polyhedron polyhedron)
    {
        camera = new Vertex(0.0D, -eye_z, 0.0D);
        for(int i = 0; i < polyhedron.n_polygons; i++)
            polyhedron.polygons[i].check_facing(camera);

    }

    public static double reverse_convertY(int i)
    {
        return (double)(-(i - centerY)) / scale;
    }

    public static int render_style;
    public static final int WIRE_FRAME = 0;
    public static final int FRONT_FACE = 1;
    public static final int SILHOUETTE = 2;
    public static final int SHADED = 3;
    public static final int STROKE_SHADED = 4;
    private static double scale;
    private static double line_scale;
    public static int line_style;
    public static final int NORMAL_LINE = 0;
    public static final int RANDOM_LINE = 1;
    public static final int WIDE_LINE = 2;
    public static Polygon2 current_polygon = null;
    public static boolean in_motion = false;
    private static Random rand = new Random();
    private static int centerX = 200;
    private static int centerY = 150;
    private static int basic_scale = 100;
    private static int eye_z = 10;
    public static Vertex camera;

}
