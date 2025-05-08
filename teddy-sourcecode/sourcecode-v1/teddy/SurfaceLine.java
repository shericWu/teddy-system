/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.Enumeration;
import teddy.Def;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Generate;
import teddy.Geometry;
import teddy.LinkedList;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Teddy;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class SurfaceLine
extends Edge
implements Serializable {
    public static Teddy teddy;
    public Polygon2 polygon;
    public static Polyhedron h;

    SurfaceLine() {
        this.start = new Vertex();
        this.end = new Vertex();
        this.polygon = null;
    }

    SurfaceLine(Vertex vertex, Vertex vertex2, Polygon2 polygon2) {
        this.start = vertex;
        this.end = vertex2;
        this.polygon = polygon2;
        if (this.polygon != null) {
            this.polygon.surface_lines.append(this);
        }
    }

    SurfaceLine(Vertex2D vertex2D, Vertex2D vertex2D2, Polyhedron polyhedron) {
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(polyhedron, vertex);
        Objects objects = Geometry.find_vertex_on_surface(vertex2D, true);
        Objects objects2 = Geometry.find_vertex_on_surface(vertex2D2, true);
        if (objects.get(0) != objects2.get(0)) {
            System.out.println("surface line, different polygon");
        }
        this.start = (Vertex)objects.get(1);
        this.end = (Vertex)objects2.get(1);
        this.polygon = (Polygon2)objects.get(0);
    }

    public static boolean generate_surface_lines(LinkedList linkedList, Polyhedron polyhedron, boolean bl) {
        h = polyhedron;
        if (linkedList.size() == 0) {
            return false;
        }
        boolean bl2 = SurfaceLine.generate_surface_lines_main(linkedList, true);
        if (bl2) {
            return true;
        }
        if (bl) {
            SurfaceLine.generate_surface_lines_main(linkedList, false);
        }
        return false;
    }

    public static LinkedList get_edge_vertex_list(LinkedList linkedList, Objects objects, boolean bl) {
        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(objects);
        Enumeration enumeration = linkedList.elements();
        Point point = (Point)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Point point2 = (Point)enumeration.nextElement();
            Vertex2D vertex2D = new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y));
            Vertex2D vertex2D2 = new Vertex2D(Draw3DScene.reverse_convertX(point2.x), Draw3DScene.reverse_convertY(point2.y));
            SurfaceLine.get_edge_vertex_list_sub(vertex2D, vertex2D2, h, linkedList2, bl);
            point = point2;
        }
        return linkedList2;
    }

    public static boolean generate_surface_lines_main(LinkedList linkedList, boolean bl) {
        Point point = (Point)linkedList.head();
        Vertex2D vertex2D = new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y));
        Objects objects = Geometry.find_vertex_on_surface(vertex2D, bl);
        if (objects == null) {
            return true;
        }
        Teddy.teddy.play_sound("drip.au");
        boolean bl2 = false;
        double d = Generate.calculate_stroke_length(linkedList);
        if (d > 40.0 && Vector2.distance((Point)linkedList.head(), (Point)linkedList.tail()) < 20.0) {
            bl2 = true;
            linkedList.replace_tail(linkedList.head());
            linkedList = Generate.counter_clockwise(linkedList);
        }
        linkedList = Generate.normalize_Point_list(linkedList, Def.NORMALIZED_STROKE_LENGTH_POP);
        LinkedList linkedList2 = SurfaceLine.get_edge_vertex_list(linkedList, objects, bl);
        linkedList2 = SurfaceLine.remove_short_edges(linkedList2);
        if (bl2) {
            SurfaceLine.h.temp_surface_lines.connect(SurfaceLine.generate_surface_lines_sub(linkedList2));
            linkedList2.replace_tail(linkedList2.head());
            SurfaceLine.h.temp_edge_vertex_list = linkedList2;
            SurfaceLine.h.section_bumping = false;
        } else {
            SurfaceLine.h.surface_lines.connect(SurfaceLine.generate_surface_lines_sub(linkedList2));
        }
        return false;
    }

    public static LinkedList generate_surface_lines_sub(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Polygon2 polygon2 = (Polygon2)objects.get(0);
        Vertex vertex = (Vertex)objects.get(1);
        while (enumeration.hasMoreElements()) {
            objects = (Objects)enumeration.nextElement();
            Vertex vertex2 = (Vertex)objects.get(1);
            linkedList2.append(new SurfaceLine(vertex, vertex2, polygon2));
            if (objects.get(0) instanceof Edge) {
                Edge edge = (Edge)objects.get(0);
                polygon2 = edge.get_another_polygon(polygon2);
            }
            vertex = vertex2.copy();
        }
        return linkedList2;
    }

    public static void get_edge_vertex_list_sub(Vertex2D vertex2D, Vertex2D vertex2D2, Polyhedron polyhedron, LinkedList linkedList, boolean bl) {
        Objects objects = Geometry.find_vertex_on_surface(vertex2D, bl);
        Objects objects2 = Geometry.find_vertex_on_surface(vertex2D2, bl);
        if (objects == null || objects2 == null) {
            System.out.println("failed to find surface");
            return;
        }
        Vertex vertex = (Vertex)objects.get(1);
        Vertex vertex2 = (Vertex)objects2.get(1);
        Polygon2 polygon2 = (Polygon2)objects.get(0);
        Polygon2 polygon22 = (Polygon2)objects2.get(0);
        linkedList.connect(Geometry.surface_path(vertex2D, vertex2D2, vertex, vertex2, polygon2, polygon22));
        linkedList.append(objects2);
    }

    public Edge copy() {
        Polygon2 polygon2 = this.polygon.child;
        SurfaceLine surfaceLine = new SurfaceLine(this.start.position_copy(), this.end.position_copy(), polygon2);
        polygon2.surface_lines.append(surfaceLine);
        return surfaceLine;
    }

    private static LinkedList remove_short_edges(LinkedList linkedList) {
        Objects objects;
        boolean bl = false;
        if (linkedList.head() == linkedList.tail()) {
            bl = true;
        }
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Objects objects2 = objects = (Objects)enumeration.nextElement();
        Objects objects3 = objects;
        linkedList2.append(objects);
        Vertex vertex = (Vertex)objects.get(1);
        while (enumeration.hasMoreElements()) {
            Objects objects4 = (Objects)enumeration.nextElement();
            Vertex vertex2 = (Vertex)objects4.get(1);
            if (Vector3.distance(vertex, vertex2) > Def.MINIMUM_EDGE_LENGTH || objects4.get(0) instanceof Edge) {
                if (objects.get(0) instanceof Polygon && Vector3.distance(vertex, vertex2) < Def.MINIMUM_EDGE_LENGTH) {
                    linkedList2.remove(linkedList2.tail());
                }
                if (objects.get(0) instanceof Edge && objects.get(0) == objects4.get(0)) {
                    linkedList2.append(objects3);
                    System.out.println("inserted");
                }
                linkedList2.append(objects4);
                objects2 = objects;
                vertex = vertex2;
                objects = objects4;
            }
            objects3 = objects4;
        }
        if (bl) {
            if (linkedList2.head() != linkedList2.tail()) {
                linkedList2.append(linkedList2.head());
            }
        } else {
            if (linkedList2.head() != linkedList.head()) {
                linkedList2.reset();
                linkedList2.insert(linkedList.head());
            }
            if (linkedList2.tail() != linkedList.tail()) {
                linkedList2.append(linkedList.tail());
            }
        }
        return linkedList2;
    }
}

