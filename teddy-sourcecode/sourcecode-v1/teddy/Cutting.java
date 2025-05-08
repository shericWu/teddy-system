/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Enumeration;
import java.util.Vector;
import teddy.Def;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Generate;
import teddy.Geometry;
import teddy.LinkedList;
import teddy.Modify;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Tessellation;
import teddy.Trianglation;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Cutting
extends Modify {
    private static LinkedList get_edge_vertices(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Objects objects = (Objects)enumeration.nextElement();
            if (!(objects.get(0) instanceof Edge)) continue;
            linkedList2.append((Vertex)objects.get(1));
        }
        return linkedList2;
    }

    private static void generate_temp_edge_vertex_list(LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3, LinkedList linkedList4, Vector vector) {
        Modify.h.temp_edge_vertex_list = new LinkedList();
        Cutting.generate_temp_edge_vertex_list(linkedList, vector);
        Cutting.generate_temp_edge_vertex_list(linkedList2, vector);
        Cutting.generate_temp_edge_vertex_list(linkedList3, vector);
        Cutting.generate_temp_edge_vertex_list(linkedList4, vector);
        Modify.h.temp_edge_vertex_list.append(Modify.h.temp_edge_vertex_list.head());
    }

    private static void generate_temp_edge_vertex_list(LinkedList linkedList, Vector vector) {
        Enumeration enumeration = linkedList.elements();
        Vertex vertex = Cutting.find_corresponding_vertex((Vertex)((Objects)enumeration.nextElement()).get(1), vector);
        while (enumeration.hasMoreElements()) {
            Vertex vertex2 = Cutting.find_corresponding_vertex((Vertex)((Objects)enumeration.nextElement()).get(1), vector);
            if (vertex != vertex2) {
                Edge edge = vertex.get_shared_edge(vertex2);
                if (edge == null) {
                    System.out.println("Cutting, OOOOOOOPS");
                }
                Modify.h.temp_edge_vertex_list.append(new Objects(edge, vertex));
            }
            vertex = vertex2;
        }
    }

    private static Objects divide_polygons(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex = (Vertex)objects.get(1);
        linkedList2.append(vertex);
        Polygon2 polygon2 = (Polygon2)objects.get(0);
        objects = new Objects();
        while (enumeration.hasMoreElements()) {
            objects = (Objects)enumeration.nextElement();
            linkedList2.append((Vertex)objects.get(1));
            if (objects.get(0) instanceof Edge) break;
        }
        if (!enumeration.hasMoreElements()) {
            return new Objects(null, null, linkedList2, null, null, null);
        }
        Vertex vertex2 = (Vertex)objects.get(1);
        Edge edge = (Edge)objects.get(0);
        Polygon2 polygon22 = polygon2;
        System.out.println("divide polygons--");
        Modify.PolygonReplace polygonReplace = Modify.polygon_replace_manager.replaced(polygon22);
        if (polygonReplace != null) {
            polygon22 = Modify.polygon_replace_manager.get_corresponding_polygon(polygonReplace, vertex);
            edge = Modify.find_corresponding_edge(polygon22, edge);
        }
        if ((polygon2 = edge.get_another_polygon(polygon22)) == null && (polygon2 = (edge = Modify.polygon_replace_manager.get_corresponding_edge(edge, vertex2)).get_another_polygon(null)) == polygon22) {
            System.out.println("from divided to not-divied (Cutting.divide_polygons)");
            edge = (Edge)objects.get(0);
            polygon2 = edge.get_another_polygon(null);
        }
        Modify.h.append(vertex2);
        LinkedList linkedList3 = linkedList2.reverse();
        Vertex vertex3 = vertex2;
        Edge edge2 = edge;
        while (true) {
            Modify.PolygonReplace polygonReplace2;
            linkedList2 = new LinkedList();
            linkedList2.append(vertex2);
            while (enumeration.hasMoreElements()) {
                objects = (Objects)enumeration.nextElement();
                linkedList2.append((Vertex)objects.get(1));
                if (objects.get(0) instanceof Edge) break;
            }
            if (!enumeration.hasMoreElements()) break;
            Vertex vertex4 = (Vertex)objects.get(1);
            Edge edge3 = (Edge)objects.get(0);
            Polygon2 polygon23 = edge3.get_another_polygon(polygon2);
            Edge edge4 = edge3;
            if (polygon23 == null) {
                edge3 = Modify.find_corresponding_edge(polygon2, edge3);
                polygon23 = edge3.get_another_polygon(polygon2);
            }
            Edge edge5 = edge3;
            if (polygon23 == null) {
                edge5 = edge4;
                polygon23 = edge5.get_another_polygon(null);
                System.out.println("into polygon not divided");
            }
            if (edge == edge3 && (polygonReplace2 = Modify.polygon_replace_manager.replaced(polygon22)) != null) {
                Edge edge6 = Modify.find_corresponding_edge(polygonReplace2.child0, edge3);
                Edge edge7 = Modify.find_corresponding_edge(polygonReplace2.child1, edge3);
                if (edge6.on_edge(vertex4)) {
                    edge5 = edge6;
                    polygon23 = polygonReplace2.child0;
                } else {
                    edge5 = edge7;
                    polygon23 = polygonReplace2.child1;
                }
                System.out.println("U turn");
            }
            if (!polygon2.contains(edge3)) {
                edge3 = Modify.polygon_replace_manager.get_corresponding_edge(edge3, vertex4);
            }
            Modify.divide_a_polygon(polygon2, linkedList2, vertex2, edge, vertex4, edge3);
            polygon22 = polygon2;
            vertex2 = vertex4;
            edge = edge5;
            polygon2 = polygon23;
            Modify.h.append(vertex2);
        }
        return new Objects(vertex3, edge2, linkedList3, vertex2, edge, linkedList2);
    }

    private static void draw_surface_lines(LinkedList linkedList, Polygon2 polygon2, Vertex vertex) {
        Enumeration enumeration = linkedList.elements();
        enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Objects objects = (Objects)enumeration.nextElement();
            Vertex vertex2 = (Vertex)objects.get(1);
            Modify.h.temp_surface_lines.append(new SurfaceLine(vertex.copy(), vertex2.copy(), polygon2));
            if (objects.get(0) instanceof Edge) {
                Edge edge = (Edge)objects.get(0);
                polygon2 = edge.get_another_polygon(polygon2);
            }
            vertex = vertex2.copy();
        }
    }

    private static double get_average_length(LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3, LinkedList linkedList4) {
        double d = 0.0;
        d += Cutting.get_average_length_sub(linkedList);
        d += Cutting.get_average_length_sub(linkedList2);
        d += Cutting.get_average_length_sub(linkedList3);
        return (d += Cutting.get_average_length_sub(linkedList4)) / (double)(linkedList.size() + linkedList2.size() + linkedList3.size() + linkedList4.size());
    }

    Cutting() {
    }

    private static void generate_section_surface(LinkedList linkedList, LinkedList linkedList2) {
        Edge edge;
        Vertex vertex;
        LinkedList linkedList3 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex2 = vertex = (Vertex)objects.get(1);
        while (enumeration.hasMoreElements()) {
            objects = (Objects)enumeration.nextElement();
            Vertex vertex3 = (Vertex)objects.get(1);
            edge = Modify.h.get_edge_array(vertex, vertex3);
            linkedList3.append(edge);
            vertex = vertex3;
        }
        edge = Modify.h.get_edge_array(vertex, vertex2);
        linkedList3.append(edge);
        Polygon2 polygon2 = new Polygon2(linkedList3);
        Modify.h.append(polygon2);
        linkedList2.append(edge);
    }

    private static void generate_section_surface(LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3) {
        Enumeration enumeration = linkedList.elements();
        Enumeration enumeration2 = linkedList2.elements();
        Vertex vertex = null;
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex2 = (Vertex)objects.get(1);
        objects = (Objects)enumeration2.nextElement();
        Vertex vertex3 = (Vertex)objects.get(1);
        while (enumeration.hasMoreElements()) {
            Vertex vertex4 = vertex2;
            LinkedList linkedList4 = new LinkedList();
            while (enumeration.hasMoreElements()) {
                objects = (Objects)enumeration.nextElement();
                vertex = (Vertex)objects.get(1);
                linkedList4.append(Modify.h.get_edge_array(vertex4, vertex));
                if (objects.get(0) instanceof Polygon2) break;
                vertex4 = vertex;
            }
            Vertex vertex5 = vertex;
            vertex4 = vertex3;
            LinkedList linkedList5 = new LinkedList();
            while (enumeration2.hasMoreElements()) {
                objects = (Objects)enumeration2.nextElement();
                vertex = (Vertex)objects.get(1);
                linkedList5.append(Modify.h.get_edge_array(vertex4, vertex));
                if (objects.get(0) instanceof Polygon2) break;
                vertex4 = vertex;
            }
            Vertex vertex6 = vertex;
            Edge edge = Modify.h.get_edge_array(vertex3, vertex2);
            Edge edge2 = Modify.h.get_edge_array(vertex5, vertex6);
            LinkedList linkedList6 = new LinkedList();
            linkedList6.append(edge);
            linkedList6.connect(linkedList4);
            linkedList6.append(edge2);
            linkedList6.connect(linkedList5.reverse());
            Modify.h.append(new Polygon2(linkedList6));
            vertex2 = vertex5;
            vertex3 = vertex6;
            linkedList3.append(edge);
        }
    }

    private static void generate_section_surface(Vertex vertex, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(Modify.h.get_edge_array(vertex, vertex2));
        linkedList.append(Modify.h.get_edge_array(vertex2, vertex3));
        linkedList.append(Modify.h.get_edge_array(vertex3, vertex4));
        linkedList.append(Modify.h.get_edge_array(vertex4, vertex));
        Modify.h.append(new Polygon2(linkedList));
    }

    private static void generate_section_surface(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(Modify.h.get_edge_array(vertex, vertex2));
        linkedList.append(Modify.h.get_edge_array(vertex2, vertex3));
        linkedList.append(Modify.h.get_edge_array(vertex3, vertex));
        Modify.h.append(new Polygon2(linkedList));
    }

    public static boolean cut_main(LinkedList linkedList, boolean bl) {
        LinkedList linkedList2;
        Objects objects;
        Vertex2D vertex2D;
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex);
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Vertex2D vertex2D2 = (Vertex2D)enumeration.nextElement();
        if (Geometry.find_vertex_on_surface(vertex2D2, true) != null) {
            return false;
        }
        while (true) {
            if (!enumeration.hasMoreElements()) {
                System.out.println("invalid cutting stroke");
                return true;
            }
            vertex2D = (Vertex2D)enumeration.nextElement();
            objects = Geometry.find_vertex_on_surface(vertex2D, true);
            if (objects != null) break;
            vertex2D2 = vertex2D;
        }
        Vertex2D vertex2D3 = vertex2D2;
        Vertex2D vertex2D4 = vertex2D;
        Polygon2 polygon2 = (Polygon2)objects.get(0);
        Vertex vertex2 = (Vertex)objects.get(1);
        linkedList3.append(objects);
        Objects objects2 = Cutting.cut_sub(linkedList3, enumeration, polygon2, vertex2D, vertex2, true);
        Polygon2 polygon22 = (Polygon2)objects2.get(0);
        Vertex vertex3 = (Vertex)objects2.get(1);
        vertex2D2 = (Vertex2D)objects2.get(2);
        Vertex2D vertex2D5 = vertex2D = (Vertex2D)objects2.get(3);
        Vertex2D vertex2D6 = vertex2D2;
        Polygon2 polygon23 = polygon22;
        Vertex vertex4 = vertex3;
        enumeration = linkedList.elements();
        while (vertex2D3 != (Vertex2D)enumeration.nextElement()) {
        }
        vertex2D = (Vertex2D)enumeration.nextElement();
        objects = Geometry.find_vertex_on_surface(vertex2D, false);
        Polygon2 polygon24 = (Polygon2)objects.get(0);
        Vertex vertex5 = (Vertex)objects.get(1);
        linkedList4.append(objects);
        objects2 = Cutting.cut_sub(linkedList4, enumeration, polygon24, vertex2D, vertex5, false);
        polygon22 = (Polygon2)objects2.get(0);
        vertex3 = (Vertex)objects2.get(1);
        vertex2D2 = (Vertex2D)objects2.get(2);
        vertex2D = (Vertex2D)objects2.get(3);
        if (vertex2D5 != vertex2D || vertex2D6 != vertex2D2) {
            System.out.println("front back cutting mismatch");
            return false;
        }
        Polygon2 polygon25 = polygon22;
        Vertex vertex6 = vertex3;
        LinkedList linkedList5 = new LinkedList();
        LinkedList linkedList6 = new LinkedList();
        linkedList5.append(new Objects(polygon2, vertex2));
        linkedList5.connect(Geometry.surface_path(vertex2D4, vertex2D3, vertex2, vertex5, polygon2, polygon24));
        linkedList5.append(new Objects(polygon24, vertex5));
        linkedList6.append(new Objects(polygon23, vertex4));
        linkedList6.connect(Geometry.surface_path(vertex2D6, vertex2D5, vertex4, vertex6, polygon23, polygon25));
        linkedList6.append(new Objects(polygon25, vertex6));
        if (bl) {
            Cutting.draw_surface_lines(linkedList3, polygon2, vertex2);
            Cutting.draw_surface_lines(linkedList4, polygon24, vertex5);
            Cutting.draw_surface_lines(linkedList5, polygon2, vertex2.copy());
            Cutting.draw_surface_lines(linkedList6, polygon23, vertex4.copy());
            Modify.h.surface_lines.connect(Modify.h.temp_surface_lines);
            Modify.h.temp_surface_lines = new LinkedList();
            return false;
        }
        Modify.h.current_part_index = polygon2.part_index;
        Modify.section_is_sharp = true;
        Objects objects3 = Cutting.divide_polygons(linkedList3);
        Objects objects4 = Cutting.divide_polygons(linkedList4.reverse());
        Objects objects5 = Cutting.divide_polygons(linkedList5.reverse());
        Objects objects6 = Cutting.divide_polygons(linkedList6);
        if (objects3.get(0) != null) {
            Modify.divide_knot_polygon(polygon2, (Vertex)objects5.get(3), (Edge)objects5.get(4), (LinkedList)objects5.get(5), (Vertex)objects3.get(0), (Edge)objects3.get(1), (LinkedList)objects3.get(2));
            Modify.divide_knot_polygon(polygon23, (Vertex)objects3.get(3), (Edge)objects3.get(4), (LinkedList)objects3.get(5), (Vertex)objects6.get(0), (Edge)objects6.get(1), (LinkedList)objects6.get(2));
        } else {
            linkedList2 = (LinkedList)objects5.get(5);
            linkedList2.connect(((LinkedList)objects3.get(2)).cdr());
            Modify.divide_knot_polygon(polygon2, (Vertex)objects5.get(3), (Edge)objects5.get(4), linkedList2, (Vertex)objects6.get(0), (Edge)objects6.get(1), (LinkedList)objects6.get(2));
        }
        if (objects4.get(0) != null) {
            Modify.divide_knot_polygon(polygon24, (Vertex)objects4.get(3), (Edge)objects4.get(4), (LinkedList)objects4.get(5), (Vertex)objects5.get(0), (Edge)objects5.get(1), (LinkedList)objects5.get(2));
            Modify.divide_knot_polygon(polygon25, (Vertex)objects6.get(3), (Edge)objects6.get(4), (LinkedList)objects6.get(5), (Vertex)objects4.get(0), (Edge)objects4.get(1), (LinkedList)objects4.get(2));
        } else {
            linkedList2 = (LinkedList)objects6.get(5);
            linkedList2.connect(((LinkedList)objects4.get(2)).cdr());
            Modify.divide_knot_polygon(polygon25, (Vertex)objects6.get(3), (Edge)objects6.get(4), (LinkedList)objects6.get(5), (Vertex)objects5.get(0), (Edge)objects5.get(1), (LinkedList)objects5.get(2));
        }
        Modify.delete_temp_polygons();
        linkedList2 = new LinkedList();
        Cutting.generate_section_surface(linkedList5.reverse(), linkedList2);
        linkedList2 = new LinkedList();
        Cutting.generate_section_surface(linkedList6, linkedList2);
        Cutting.generate_section_surface(linkedList3, linkedList4, linkedList2);
        Modify.remove_broken_polygons();
        double d = Cutting.get_average_length(linkedList5, linkedList3, linkedList6, linkedList4);
        Tessellation.adjust_polygon_size(Modify.h, linkedList2, d);
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
        return false;
    }

    private static Objects cut_sub(LinkedList linkedList, Enumeration enumeration, Polygon2 polygon2, Vertex2D vertex2D, Vertex vertex, boolean bl) {
        Vertex2D vertex2D2;
        while (true) {
            if (!enumeration.hasMoreElements()) {
                System.out.println("Cutting sttroke is too short");
                return null;
            }
            vertex2D2 = (Vertex2D)enumeration.nextElement();
            Objects objects = Geometry.find_vertex_on_surface(vertex2D2, bl);
            if (objects == null) break;
            Polygon2 polygon22 = (Polygon2)objects.get(0);
            Vertex vertex2 = (Vertex)objects.get(1);
            linkedList.connect(Geometry.surface_path(vertex2D, vertex2D2, vertex, vertex2, polygon2, polygon22));
            linkedList.append(objects);
            polygon2 = polygon22;
            vertex2D = vertex2D2;
            vertex = vertex2;
        }
        return new Objects(polygon2, vertex, vertex2D, vertex2D2);
    }

    private static double get_average_length_sub(LinkedList linkedList) {
        double d = 0.0;
        Enumeration enumeration = linkedList.elements();
        Vertex vertex = (Vertex)((Objects)enumeration.nextElement()).get(1);
        while (enumeration.hasMoreElements()) {
            Vertex vertex2 = (Vertex)((Objects)enumeration.nextElement()).get(1);
            d += Vector3.distance(vertex, vertex2);
            vertex = vertex2;
        }
        return d;
    }

    private static void generate_temp_surface_lines(Vector vector) {
        Modify.h.temp_surface_lines = new LinkedList();
        Enumeration enumeration = Modify.h.temp_edge_vertex_list.elements();
        enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Objects objects = (Objects)enumeration.nextElement();
            Edge edge = (Edge)objects.get(0);
            Polygon2 polygon2 = edge.left_polygon;
            Vertex vertex = edge.start;
            Vertex vertex2 = edge.end;
            if (edge.start != objects.get(1)) {
                polygon2 = edge.right_polygon;
                vertex = edge.end;
                vertex2 = edge.start;
            }
            Modify.h.temp_surface_lines.append(new SurfaceLine(vertex.copy(), vertex2.copy(), polygon2));
        }
    }

    public static boolean cut(LinkedList linkedList, Polyhedron polyhedron, boolean bl) {
        Teddy.teddy.play_sound("cutting.au");
        linkedList = Generate.normalize_Point_list(linkedList, Def.NORMALIZED_STROKE_LENGTH_POP);
        Modify.init(polyhedron);
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Point point = (Point)enumeration.nextElement();
            linkedList2.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y)));
        }
        linkedList2 = Generate.normalize_Vertex2D_list(linkedList2);
        linkedList2 = Generate.reduce_Vertex2D_list(linkedList2, true);
        return Cutting.cut_main(linkedList2, bl);
    }

    private static Vertex find_corresponding_vertex(Vertex vertex, Vector vector) {
        int n = 0;
        while (n < vector.size()) {
            Objects objects = (Objects)vector.elementAt(n);
            if (vertex == objects.get(0)) {
                vertex = (Vertex)objects.get(1);
                n = 0;
            }
            ++n;
        }
        return vertex;
    }
}

