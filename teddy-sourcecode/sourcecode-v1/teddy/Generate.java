/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Enumeration;
import teddy.Def;
import teddy.DrawPanel;
import teddy.Edge2D;
import teddy.LinkedList;
import teddy.Polyhedron;
import teddy.Scene;
import teddy.Segment;
import teddy.Skeleton;
import teddy.Teddy;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Generate {
    public static Teddy teddy;
    private static Polyhedron h;

    public static LinkedList normalize_Vertex2D_list(LinkedList linkedList) {
        Vertex2D vertex2D;
        double d = 0.0;
        Enumeration enumeration = linkedList.elements();
        Vertex2D vertex2D2 = (Vertex2D)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            vertex2D = (Vertex2D)enumeration.nextElement();
            d += Vector2.distance(vertex2D2, vertex2D);
            vertex2D2 = vertex2D;
        }
        int n = (int)(d / Def.NORMALIZED_EDGE_LENGTH);
        if (n < 8) {
            n = 8;
        }
        double d2 = d / (double)n;
        LinkedList linkedList2 = new LinkedList();
        enumeration = linkedList.elements();
        vertex2D2 = (Vertex2D)enumeration.nextElement();
        linkedList2.append(vertex2D2);
        double d3 = 0.0;
        while (enumeration.hasMoreElements()) {
            vertex2D = (Vertex2D)enumeration.nextElement();
            double d4 = Vector2.distance(vertex2D2, vertex2D);
            d3 += d4;
            while (d3 >= d2) {
                linkedList2.append(Vector2.interporate(vertex2D, vertex2D2, (d3 -= d2) / d4).vertex2D());
                if (linkedList2.size() == n - 1) break;
            }
            if (linkedList2.size() == n - 1) break;
            vertex2D2 = vertex2D;
        }
        linkedList2.append(linkedList.tail());
        return linkedList2;
    }

    public static LinkedList reduce_Vertex2D_list(LinkedList linkedList, boolean bl) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex2D vertex2D = (Vertex2D)enumeration.nextElement();
        linkedList2.append(vertex2D);
        Vertex2D vertex2D2 = (Vertex2D)enumeration.nextElement();
        Vertex2D vertex2D3 = null;
        Vector2 vector2 = null;
        Vector2 vector22 = null;
        while (enumeration.hasMoreElements()) {
            double d = 0.0;
            double d2 = 0.0;
            vector2 = new Vector2(vertex2D, vertex2D2);
            while (enumeration.hasMoreElements()) {
                vertex2D3 = (Vertex2D)enumeration.nextElement();
                vector22 = new Vector2(vertex2D2, vertex2D3);
                d2 += vector2.length();
                if ((d += vector2.get_relative_angle(vector22)) > 0.2 || bl && d2 > Def.MAXIMUM_EDGE_LENGTH) {
                    linkedList2.append(vertex2D2);
                    break;
                }
                vertex2D2 = vertex2D3;
                vector2 = vector22;
            }
            if (!enumeration.hasMoreElements()) break;
            vertex2D = vertex2D2;
            vertex2D2 = vertex2D3;
        }
        linkedList2.append(linkedList.tail());
        return linkedList2;
    }

    public static Segment get_segment(Vertex2D vertex2D, Vertex2D vertex2D2) {
        double d = DrawPanel.rcX((int)vertex2D.x);
        double d2 = DrawPanel.rcY((int)vertex2D.y);
        double d3 = DrawPanel.rcX((int)vertex2D2.x);
        double d4 = DrawPanel.rcY((int)vertex2D2.y);
        return new Segment(d, d2, d3, d4);
    }

    public static Segment get_segment(Edge2D edge2D) {
        return Generate.get_segment(edge2D.start, edge2D.end);
    }

    private static LinkedList normalize_Point_list_sub(LinkedList linkedList, int n, double d) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        linkedList2.append(point);
        double d2 = 0.0;
        while (enumeration.hasMoreElements()) {
            Point point2 = (Point)enumeration.nextElement();
            double d3 = Vector2.distance(point.x, point.y, point2.x, point2.y);
            d2 += d3;
            while (d2 >= d) {
                linkedList2.append(Vector2.interporate(point2, point, (d2 -= d) / d3).point());
                if (linkedList2.size() == n - 1) break;
            }
            if (linkedList2.size() == n - 1) break;
            point = point2;
        }
        linkedList2.append(linkedList.tail());
        return linkedList2;
    }

    public static Polyhedron generate(LinkedList linkedList) {
        Teddy.teddy.play_sound("generate.au");
        linkedList.remove(linkedList.head());
        linkedList.remove(linkedList.tail());
        linkedList.append(linkedList.head());
        linkedList = Generate.normalize_Point_list(linkedList, Def.NORMALIZED_STROKE_LENGTH_NEW);
        linkedList = Generate.reduce_Point_list(linkedList);
        linkedList = Generate.counter_clockwise(linkedList);
        return Skeleton.generate_polyhedron(linkedList);
    }

    public static Scene get_boundary(LinkedList linkedList) {
        Scene scene = new Scene();
        linkedList.reverse();
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Point point2 = (Point)enumeration.nextElement();
            double d = DrawPanel.rcX(point.x);
            double d2 = DrawPanel.rcY(point.y);
            double d3 = DrawPanel.rcX(point2.x);
            double d4 = DrawPanel.rcY(point2.y);
            scene.append(new Segment(d, d2, d3, d4));
            point = point2;
        }
        return scene;
    }

    Generate() {
    }

    public static Scene pop_test(LinkedList linkedList) {
        Scene scene = new Scene();
        LinkedList linkedList2 = linkedList.reverse();
        Enumeration enumeration = linkedList.elements();
        Enumeration enumeration2 = linkedList2.elements();
        Point point = (Point)enumeration.nextElement();
        Point point2 = (Point)enumeration.nextElement();
        Point point3 = (Point)enumeration.nextElement();
        Point point4 = (Point)enumeration2.nextElement();
        Point point5 = (Point)enumeration2.nextElement();
        Point point6 = (Point)enumeration2.nextElement();
        while (true) {
            double d = DrawPanel.rcX(point.x);
            double d2 = DrawPanel.rcY(point.y);
            double d3 = DrawPanel.rcX(point4.x);
            double d4 = DrawPanel.rcY(point4.y);
            scene.append(new Segment(d, d2, d3, d4));
            if (point2 == point5 || point2 == point4) break;
            Vector2 vector2 = new Vector2(point, point2).normalize();
            Vector2 vector22 = new Vector2(point2, point3).normalize();
            Vector2 vector23 = new Vector2(point4, point5).normalize();
            Vector2 vector24 = new Vector2(point5, point6).normalize();
            vector2.add(vector24);
            vector22.add(vector23);
            vector22.add(vector24);
            Vector2 vector25 = new Vector2(point, point5);
            Vector2 vector26 = new Vector2(point2, point4);
            Vector2 vector27 = new Vector2(point2, point5);
            double d5 = Math.max(Math.abs(vector25.cos(vector2)), Math.abs(vector25.cos(vector24)));
            double d6 = Math.max(Math.abs(vector26.cos(vector22)), Math.abs(vector26.cos(vector23)));
            double d7 = Math.max(Math.abs(vector27.cos(vector22)), Math.abs(vector27.cos(vector24)));
            if (d5 <= d6 && d5 <= d7) {
                point4 = point5;
                point5 = point6;
                point6 = (Point)enumeration2.nextElement();
                continue;
            }
            if (d6 <= d5 && d6 <= d7) {
                point = point2;
                point2 = point3;
                point3 = (Point)enumeration.nextElement();
                continue;
            }
            point = point2;
            point2 = point3;
            point3 = (Point)enumeration.nextElement();
            point4 = point5;
            point5 = point6;
            point6 = (Point)enumeration2.nextElement();
        }
        return scene;
    }

    public static LinkedList renumber_Point_list(int n, LinkedList linkedList) {
        double d = Generate.calculate_stroke_length(linkedList);
        double d2 = d / (double)n;
        return Generate.normalize_Point_list_sub(linkedList, n, d2);
    }

    public static LinkedList reduce_Vertex_list(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex vertex = (Vertex)enumeration.nextElement();
        linkedList2.append(vertex);
        Vertex vertex2 = (Vertex)enumeration.nextElement();
        Vertex vertex3 = null;
        Vector3 vector3 = null;
        Vector3 vector32 = null;
        int n = 0;
        while (enumeration.hasMoreElements()) {
            double d = 0.0;
            double d2 = 0.0;
            vector3 = new Vector3(vertex, vertex2);
            n = 0;
            while (enumeration.hasMoreElements()) {
                vertex3 = (Vertex)enumeration.nextElement();
                vector32 = new Vector3(vertex2, vertex3);
                d2 += vector3.length();
                if ((d += vector3.get_relative_angle(vector32)) > 0.2 || n > 2) {
                    linkedList2.append(vertex2);
                    break;
                }
                ++n;
                vertex2 = vertex3;
                vector3 = vector32;
            }
            if (!enumeration.hasMoreElements()) break;
            vertex = vertex2;
            vertex2 = vertex3;
        }
        linkedList2.append(linkedList.tail());
        return linkedList2;
    }

    public static Scene skeleton_test(LinkedList linkedList) {
        Scene scene = new Scene();
        LinkedList linkedList2 = Skeleton.get_skeleton_edges(linkedList);
        Enumeration enumeration = linkedList2.elements();
        while (enumeration.hasMoreElements()) {
            Edge2D edge2D = (Edge2D)enumeration.nextElement();
            Generate.add_segment(scene, edge2D.start, edge2D.end);
        }
        return scene;
    }

    public static Scene generate_scene(LinkedList linkedList) {
        linkedList.append(linkedList.head());
        linkedList = Generate.normalize_Point_list(linkedList, Def.NORMALIZED_STROKE_LENGTH_NEW);
        linkedList = Generate.reduce_Point_list(linkedList);
        return Generate.skeleton_test(linkedList);
    }

    public static void add_segment(Scene scene, Vertex2D vertex2D, Vertex2D vertex2D2) {
        scene.append(Generate.get_segment(vertex2D, vertex2D2));
    }

    public static double calculate_stroke_length(LinkedList linkedList) {
        double d = 0.0;
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Point point2 = (Point)enumeration.nextElement();
            d += Math.sqrt((point2.x - point.x) * (point2.x - point.x) + (point2.y - point.y) * (point2.y - point.y));
            point = point2;
        }
        return d;
    }

    public static LinkedList counter_clockwise(LinkedList linkedList) {
        double d = 0.0;
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Point point2 = (Point)enumeration.nextElement();
            d += (double)((point.y + point2.y) * (point2.x - point.x));
            point = point2;
        }
        if (linkedList.tail() != linkedList.head()) {
            System.out.println(d);
        }
        if (d < 0.0) {
            return linkedList.reverse();
        }
        return linkedList;
    }

    public static LinkedList normalize_Point_list(LinkedList linkedList, int n) {
        double d = Generate.calculate_stroke_length(linkedList);
        int n2 = (int)(d / (double)n);
        if (n2 < 8) {
            n2 = 8;
        }
        double d2 = d / (double)n2;
        return Generate.normalize_Point_list_sub(linkedList, n2, d2);
    }

    public static LinkedList reduce_Point_list(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        linkedList2.append(point);
        Point point2 = (Point)enumeration.nextElement();
        Point point3 = null;
        Vector2 vector2 = null;
        Vector2 vector22 = null;
        while (enumeration.hasMoreElements()) {
            double d = 0.0;
            double d2 = 0.0;
            vector2 = new Vector2(point, point2);
            while (enumeration.hasMoreElements()) {
                point3 = (Point)enumeration.nextElement();
                vector22 = new Vector2(point2, point3);
                d2 += vector2.length();
                if ((d += vector2.get_relative_angle(vector22)) > 0.2 || d2 > (double)Def.MAXIMUM_STROKE_LENGTH) {
                    linkedList2.append(point2);
                    break;
                }
                point2 = point3;
                vector2 = vector22;
            }
            if (!enumeration.hasMoreElements()) break;
            point = point2;
            point2 = point3;
        }
        linkedList2.append(linkedList.tail());
        return linkedList2;
    }
}

