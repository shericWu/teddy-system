/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Enumeration;
import java.util.Random;
import teddy.Edge;
import teddy.Geometry;
import teddy.Graphics2;
import teddy.LinkedList;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.ProjectedEdge;
import teddy.SilhouetteFind;
import teddy.SurfaceLine;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Draw3DScene {
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
    public static Polygon2 current_polygon;
    public static boolean in_motion;
    private static Random rand;
    private static int centerX;
    private static int centerY;
    private static int basic_scale;
    private static int eye_z;
    public static Vertex camera;

    public static double reverse_convertY(double d) {
        return -(d - (double)centerY) / scale;
    }

    private static void paint_z_buffer(Graphics graphics, Polyhedron polyhedron, boolean bl) {
        Geometry.init(polyhedron, camera);
        int n = polyhedron.n_polygons - 1;
        while (n > -1) {
            Polygon2 polygon2 = Geometry.sorted_polygons[n];
            polygon2.check_facing(camera);
            if (polygon2.front_facing) {
                Draw3DScene.draw_white_polygon(graphics, polygon2);
                if (!bl) {
                    Draw3DScene.fillRandom(graphics, polygon2);
                }
                Draw3DScene.draw_silhouette_edges(graphics, polygon2);
            }
            --n;
        }
    }

    public static void fillRandom(Graphics graphics, Polygon2 polygon2) {
        Point point = Draw3DScene.project(polygon2.get_vertex(0));
        Point point2 = Draw3DScene.project(polygon2.get_vertex(1));
        Point point3 = Draw3DScene.project(polygon2.get_vertex(2));
        Vector2 vector2 = new Vector2(point, point2);
        Vector2 vector22 = new Vector2(point, point3);
        Vector3 vector3 = polygon2.absolute_normal().get_normalized();
        Vector2 vector23 = Draw3DScene.project(vector3).normalize();
        double d = Vector2.distance(0.0, 0.0, vector3.x, vector3.z);
        double d2 = Math.abs(vector2.cross_product(vector22));
        d = Math.max(d - 0.6, 0.0);
        int n = (int)(d2 * d * d * 0.3);
        int n2 = 0;
        while (n2 < n) {
            double d3 = rand.nextDouble();
            double d4 = rand.nextDouble();
            double d5 = rand.nextDouble();
            double d6 = d4 * d3;
            double d7 = (1.0 - d4) * d3;
            graphics.setColor(new Color(0, 0, 0));
            Graphics2.drawRandomLine(graphics, (int)((double)point.x + d6 * vector2.x + d7 * vector22.x + 8.0 * d5 * vector23.y), (int)((double)point.y + d6 * vector2.y + d7 * vector22.y - 8.0 * d5 * vector23.x), (int)((double)point.x + d6 * vector2.x + d7 * vector22.x - 8.0 * d5 * vector23.y), (int)((double)point.y + d6 * vector2.y + d7 * vector22.y + 8.0 * d5 * vector23.x));
            ++n2;
        }
    }

    public static double project_x(Vertex vertex) {
        return vertex.x() * (double)eye_z / (vertex.y() + (double)eye_z);
    }

    public static void draw_polygon(Graphics graphics, Polygon2 polygon2, Color color) {
        int n = 0;
        while (n < polygon2.n_edges) {
            Draw3DScene.draw_edge(graphics, polygon2.edges[n], color);
            ++n;
        }
    }

    private static void paint_silhouette(Graphics graphics, Polyhedron polyhedron) {
        LinkedList linkedList = SilhouetteFind.find_visible_edges(polyhedron, camera);
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            ProjectedEdge projectedEdge = (ProjectedEdge)enumeration.nextElement();
            Draw3DScene.draw_projected_edge(graphics, projectedEdge, Color.black);
        }
    }

    public static double project_y(Vertex vertex) {
        return vertex.z() * (double)eye_z / (vertex.y() + (double)eye_z);
    }

    public static void paint(Graphics graphics, Polyhedron polyhedron, double d, Dimension dimension) {
        scale = d * (double)basic_scale;
        line_scale = d * 6.0;
        centerX = dimension.width / 2;
        centerY = dimension.height / 2;
        graphics.setPaintMode();
        camera = new Vertex(0.0, -eye_z, 0.0);
        if (polyhedron == null) {
            return;
        }
        switch (render_style) {
            case 0: {
                if (!in_motion) {
                    Geometry.init(polyhedron, camera);
                }
                int n = 0;
                while (n < polyhedron.n_edges) {
                    Draw3DScene.draw_edge(graphics, polyhedron.edges[n], Color.black);
                    ++n;
                }
                break;
            }
            case 1: {
                if (!in_motion) {
                    Geometry.init(polyhedron, camera);
                }
                int n = 0;
                while (n < polyhedron.n_polygons) {
                    polyhedron.polygons[n].check_facing(camera);
                    if (polyhedron.polygons[n].front_facing) {
                        Draw3DScene.draw_polygon(graphics, polyhedron.polygons[n], Color.black);
                    }
                    ++n;
                }
                break;
            }
            case 3: {
                if (!in_motion) {
                    Geometry.init(polyhedron, camera);
                    int n = polyhedron.n_polygons - 1;
                    while (n > -1) {
                        Polygon2 polygon2 = Geometry.sorted_polygons[n];
                        polygon2.check_facing(camera);
                        if (polygon2.front_facing) {
                            Draw3DScene.draw_shaded_polygon(graphics, polygon2);
                        }
                        --n;
                    }
                }
                Draw3DScene.paint_silhouette(graphics, polyhedron);
                break;
            }
            case 4: {
                if (!in_motion) {
                    Geometry.init(polyhedron, camera);
                    int n = polyhedron.n_polygons - 1;
                    while (n > -1) {
                        Polygon2 polygon2 = Geometry.sorted_polygons[n];
                        polygon2.check_facing(camera);
                        if (polygon2.front_facing) {
                            Draw3DScene.draw_white_polygon(graphics, polygon2);
                            Draw3DScene.fillRandom(graphics, polygon2);
                        }
                        --n;
                    }
                }
                Draw3DScene.paint_silhouette(graphics, polyhedron);
                break;
            }
            case 2: {
                if (!in_motion) {
                    Geometry.init(polyhedron, camera);
                }
                Draw3DScene.paint_silhouette(graphics, polyhedron);
            }
        }
        Draw3DScene.paint_surfacelines(graphics, polyhedron);
        Draw3DScene.paint_temp_surfacelines(graphics, polyhedron);
        if (current_polygon != null) {
            Draw3DScene.draw_polygon(graphics, current_polygon, Color.blue);
        }
    }

    private static void draw_line(Graphics graphics, Color color, int n, int n2, int n3, int n4) {
        graphics.setColor(color);
        switch (line_style) {
            case 0: {
                graphics.drawLine(n, n2, n3, n4);
                return;
            }
            case 1: {
                Graphics2.drawRandomLine(graphics, n, n2, n3, n4);
                return;
            }
            case 2: {
                Graphics2.drawWideLine(graphics, n, n2, n3, n4, line_scale);
                return;
            }
        }
    }

    Draw3DScene() {
    }

    public static int convertY(double d) {
        return centerY - (int)(d * scale);
    }

    public static double reverse_convertZ(double d) {
        return d / scale;
    }

    private static void paint_surfacelines(Graphics graphics, Polyhedron polyhedron) {
        Color color = Color.black;
        Enumeration enumeration = polyhedron.surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            SurfaceLine surfaceLine = (SurfaceLine)enumeration.nextElement();
            if (surfaceLine.polygon != null && !surfaceLine.polygon.front_facing) continue;
            Draw3DScene.draw_edge(graphics, surfaceLine, color);
        }
    }

    private static void draw_silhouette_edges(Graphics graphics, Polygon2 polygon2) {
        Color color = Color.black;
        int n = 0;
        while (n < polygon2.n_edges) {
            Edge edge = polygon2.edges[n];
            Polygon2 polygon22 = edge.get_the_other_polygon(polygon2);
            polygon22.check_facing(camera);
            if (!polygon22.front_facing) {
                Draw3DScene.draw_edge(graphics, edge, color);
            }
            ++n;
        }
    }

    public static void draw_shaded_polygon(Graphics graphics, Polygon2 polygon2) {
        Vector3 vector3 = polygon2.absolute_normal();
        int n = (int)(75.0 - 180.0 * vector3.y / vector3.length());
        graphics.setColor(new Color(n, n, n));
        Draw3DScene.draw_fill_polygon(graphics, polygon2);
    }

    public static Vector2 project(Vector3 vector3) {
        Vertex vertex = vector3.vertex();
        double d = Draw3DScene.convertX_vector(Draw3DScene.project_x(vertex));
        double d2 = Draw3DScene.convertY_vector(Draw3DScene.project_y(vertex));
        return new Vector2(d, d2);
    }

    public static Point project(Vertex vertex) {
        Point point = new Point();
        point.x = Draw3DScene.convertX(Draw3DScene.project_x(vertex));
        point.y = Draw3DScene.convertY(Draw3DScene.project_y(vertex));
        return point;
    }

    public static double reverse_convertX(int n) {
        return (double)(n - centerX) / scale;
    }

    private static void draw_edge(Graphics graphics, Edge edge, Color color) {
        graphics.setColor(color);
        Point point = Draw3DScene.project(edge.start());
        Point point2 = Draw3DScene.project(edge.end());
        Draw3DScene.draw_line(graphics, color, point.x, point.y, point2.x, point2.y);
    }

    private static void draw_projected_edge(Graphics graphics, ProjectedEdge projectedEdge, Color color) {
        Draw3DScene.draw_line(graphics, color, Draw3DScene.convertX(projectedEdge.start.x), Draw3DScene.convertY(projectedEdge.start.y), Draw3DScene.convertX(projectedEdge.end.x), Draw3DScene.convertY(projectedEdge.end.y));
    }

    public static double reverse_convertX(double d) {
        return (d - (double)centerX) / scale;
    }

    public static int convertX_vector(double d) {
        return (int)(d * scale);
    }

    static {
        current_polygon = null;
        in_motion = false;
        rand = new Random();
        centerX = 200;
        centerY = 150;
        basic_scale = 100;
        eye_z = 10;
    }

    public static int convertY_vector(double d) {
        return -((int)(d * scale));
    }

    public static void draw_white_polygon(Graphics graphics, Polygon2 polygon2) {
        graphics.setColor(Color.white);
        Draw3DScene.draw_fill_polygon(graphics, polygon2);
    }

    public static void draw_fill_polygon(Graphics graphics, Polygon2 polygon2) {
        int[] nArray = new int[polygon2.n_edges];
        int[] nArray2 = new int[polygon2.n_edges];
        int n = 0;
        while (n < polygon2.n_edges) {
            Point point = Draw3DScene.project(polygon2.get_vertex(n));
            nArray[n] = point.x;
            nArray2[n] = point.y;
            ++n;
        }
        graphics.fillPolygon(nArray, nArray2, polygon2.n_edges);
    }

    public static int convertX(double d) {
        return centerX + (int)(d * scale);
    }

    private static void paint_temp_surfacelines(Graphics graphics, Polyhedron polyhedron) {
        Color color = Color.red;
        Enumeration enumeration = polyhedron.temp_surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            SurfaceLine surfaceLine = (SurfaceLine)enumeration.nextElement();
            if (surfaceLine.polygon != null && !surfaceLine.polygon.front_facing) continue;
            Draw3DScene.draw_edge(graphics, surfaceLine, color);
        }
    }

    public static Vertex image_plane_to_world_coords(Vertex2D vertex2D) {
        return new Vertex(vertex2D.x, 0.0, vertex2D.y);
    }

    public static void set_front_facing(Polyhedron polyhedron) {
        camera = new Vertex(0.0, -eye_z, 0.0);
        int n = 0;
        while (n < polyhedron.n_polygons) {
            polyhedron.polygons[n].check_facing(camera);
            ++n;
        }
    }

    public static double reverse_convertY(int n) {
        return (double)(-(n - centerY)) / scale;
    }
}

