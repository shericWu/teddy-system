/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.io.Serializable;
import java.util.Enumeration;
import teddy.Def;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Generate;
import teddy.Geometry;
import teddy.Line;
import teddy.LinkedList;
import teddy.Modify;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Ring;
import teddy.Surface;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Tessellation;
import teddy.Trianglation;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Pop
extends Modify {
    private static int old_part_index;
    private static int new_part_index;

    public static void pop(LinkedList linkedList, Polyhedron polyhedron) {
        if (Vector2.distance((Point)linkedList.head(), (Point)linkedList.tail()) < 10.0) {
            polyhedron.temp_surface_lines = new LinkedList();
            return;
        }
        Teddy.teddy.play_sound("pop.au");
        linkedList = Generate.normalize_Point_list(linkedList, Def.NORMALIZED_STROKE_LENGTH_POP);
        Modify.h = polyhedron;
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Point point = (Point)enumeration.nextElement();
            linkedList2.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y)));
        }
        linkedList2 = Generate.normalize_Vertex2D_list(linkedList2);
        linkedList2 = Generate.reduce_Vertex2D_list(linkedList2, false);
        ++Modify.h.max_part_index;
        new_part_index = Modify.h.max_part_index;
        Modify.h.parent_of_a_part[Pop.new_part_index] = old_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
        Modify.h.current_part_index = new_part_index;
        Pop.pop_main(linkedList2);
    }

    private static void construct(LinkedList linkedList) {
        Serializable serializable;
        Enumeration enumeration;
        if (!Modify.h.section_bumping) {
            Modify.section_is_sharp = true;
            Modify.h.current_part_index = old_part_index;
            Pop.divide_polygons_loop(Modify.h.temp_edge_vertex_list);
            Modify.h.current_part_index = new_part_index;
            Modify.delete_temp_polygons();
        } else {
            Modify.section_is_sharp = false;
            enumeration = Modify.h.temp_surface_lines.elements();
            while (enumeration.hasMoreElements()) {
                serializable = (SurfaceLine)enumeration.nextElement();
                Modify.h.remove(((SurfaceLine)serializable).polygon);
            }
            enumeration = Modify.h.temp_edge_vertex_list.elements();
            while (enumeration.hasMoreElements()) {
                serializable = (Edge)((Objects)enumeration.nextElement()).get(0);
                ((Edge)serializable).set_sharp(false);
            }
        }
        enumeration = linkedList.elements();
        serializable = (Ring)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Object e = enumeration.nextElement();
            if (e instanceof Vertex) {
                Pop.construct_top((Ring)serializable, (Vertex)e);
                break;
            }
            Ring ring = (Ring)e;
            Pop.construct_sub((Ring)serializable, ring);
            serializable = ring;
        }
        Modify.h.temp_surface_lines = new LinkedList();
    }

    Pop() {
    }

    private static void construct_top(Ring ring, Vertex vertex) {
        Modify.h.append(vertex);
        Enumeration enumeration = ring.elements();
        Vertex vertex2 = (Vertex)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Vertex vertex3 = (Vertex)enumeration.nextElement();
            Modify.h.append_a_new_polygon(vertex2, vertex3, vertex);
            vertex2 = vertex3;
        }
    }

    private static LinkedList generate_rings(Ring ring, Vertex vertex, Vertex vertex2, LinkedList linkedList, Vector3 vector3) {
        Serializable serializable;
        Vector3 vector32;
        Serializable serializable2;
        Object object;
        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(ring);
        LinkedList linkedList3 = linkedList.reverse();
        Enumeration enumeration = linkedList.elements();
        Enumeration enumeration2 = linkedList3.elements();
        Vertex vertex3 = (Vertex)enumeration.nextElement();
        Vertex vertex4 = (Vertex)enumeration.nextElement();
        Vertex vertex5 = (Vertex)enumeration.nextElement();
        Vertex vertex6 = (Vertex)enumeration2.nextElement();
        Vertex vertex7 = (Vertex)enumeration2.nextElement();
        Vertex vertex8 = (Vertex)enumeration2.nextElement();
        while (true) {
            object = Ring.sweep(ring, vertex, vertex2, vertex3, vertex6, vector3);
            linkedList2.append(object);
            if (vertex4 == vertex7) {
                linkedList2.append(vertex4);
                break;
            }
            if (vertex4 == vertex6) {
                linkedList2.append(Vertex.mid_point(vertex3, vertex6));
                break;
            }
            serializable2 = new Vector3(vertex3, vertex4).get_normalized();
            vector32 = new Vector3(vertex4, vertex5).get_normalized();
            serializable = new Vector3(vertex6, vertex7).get_normalized();
            Vector3 vector33 = new Vector3(vertex7, vertex8).get_normalized();
            ((Vector3)serializable2).add(vector33);
            vector32.add((Vector3)serializable);
            vector32.add(vector33);
            Vector3 vector34 = new Vector3(vertex3, vertex7);
            Vector3 vector35 = new Vector3(vertex4, vertex6);
            Vector3 vector36 = new Vector3(vertex4, vertex7);
            double d = Math.max(Math.abs(vector34.cos((Vector3)serializable2)), Math.abs(vector34.cos(vector33)));
            double d2 = Math.max(Math.abs(vector35.cos(vector32)), Math.abs(vector35.cos((Vector3)serializable)));
            double d3 = Math.max(Math.abs(vector36.cos(vector32)), Math.abs(vector36.cos(vector33)));
            if (d <= d2 && d <= d3) {
                vertex6 = vertex7;
                vertex7 = vertex8;
                vertex8 = (Vertex)enumeration2.nextElement();
                vertex3 = Vertex.mid_point(vertex3, vertex4);
                continue;
            }
            if (d2 <= d && d2 <= d3) {
                vertex3 = vertex4;
                vertex4 = vertex5;
                vertex5 = (Vertex)enumeration.nextElement();
                vertex6 = Vertex.mid_point(vertex6, vertex7);
                continue;
            }
            vertex3 = vertex4;
            vertex4 = vertex5;
            vertex5 = (Vertex)enumeration.nextElement();
            vertex6 = vertex7;
            vertex7 = vertex8;
            vertex8 = (Vertex)enumeration2.nextElement();
        }
        object = linkedList2.elements();
        serializable2 = (Ring)object.nextElement();
        while (object.hasMoreElements()) {
            vector32 = object.nextElement();
            if (vector32 instanceof Vertex) break;
            serializable = (Ring)((Object)vector32);
            if (((Vertex)((LinkedList)serializable2).head()).same_position((Vertex)((LinkedList)serializable).head())) {
                ((LinkedList)serializable).replace_head(((LinkedList)serializable2).head());
                ((LinkedList)serializable).replace_tail(((LinkedList)serializable2).head());
            }
            serializable2 = serializable;
        }
        return linkedList2;
    }

    protected static void divide_polygons_loop(LinkedList linkedList) {
        Polygon2 polygon2;
        Modify.init(Modify.h);
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        Objects objects = (Objects)enumeration.nextElement();
        linkedList2.append((Vertex)objects.get(1));
        Polygon2 polygon22 = polygon2 = (Polygon2)objects.get(0);
        System.out.println("base " + polygon22);
        objects = new Objects();
        while (enumeration.hasMoreElements()) {
            objects = (Objects)enumeration.nextElement();
            linkedList2.append((Vertex)objects.get(1));
            if (objects.get(0) instanceof Edge) break;
        }
        if (!enumeration.hasMoreElements()) {
            return;
        }
        Vertex vertex = (Vertex)objects.get(1);
        Edge edge = (Edge)objects.get(0);
        Polygon2 polygon23 = polygon2;
        polygon2 = edge.get_another_polygon(polygon23);
        Modify.h.append(vertex);
        LinkedList linkedList3 = linkedList2.reverse();
        Vertex vertex2 = vertex;
        Edge edge2 = edge;
        while (true) {
            Modify.PolygonReplace polygonReplace;
            linkedList2 = new LinkedList();
            linkedList2.append(vertex);
            while (enumeration.hasMoreElements()) {
                objects = (Objects)enumeration.nextElement();
                linkedList2.append((Vertex)objects.get(1));
                if (objects.get(0) instanceof Edge) break;
            }
            if (!enumeration.hasMoreElements()) break;
            Vertex vertex3 = (Vertex)objects.get(1);
            Edge edge3 = (Edge)objects.get(0);
            Polygon2 polygon24 = edge3.get_another_polygon(polygon2);
            Edge edge4 = edge3;
            if (polygon24 == null) {
                edge3 = Modify.find_corresponding_edge(polygon2, edge3);
                polygon24 = edge3.get_another_polygon(polygon2);
            }
            Edge edge5 = edge3;
            if (polygon24 == null) {
                edge5 = edge4;
                polygon24 = edge5.get_another_polygon(null);
            }
            if (edge == edge3 && (polygonReplace = Modify.polygon_replace_manager.replaced(polygon23)) != null) {
                Edge edge6 = Modify.find_corresponding_edge(polygonReplace.child0, edge3);
                Edge edge7 = Modify.find_corresponding_edge(polygonReplace.child1, edge3);
                if (edge6.on_edge(vertex3)) {
                    edge5 = edge6;
                    polygon24 = polygonReplace.child0;
                } else {
                    edge5 = edge7;
                    polygon24 = polygonReplace.child1;
                }
            }
            if (!polygon2.contains(edge3)) {
                edge3 = Modify.polygon_replace_manager.get_corresponding_edge(edge3, vertex3);
            }
            Modify.divide_a_polygon(polygon2, linkedList2, vertex, edge, vertex3, edge3);
            polygon23 = polygon2;
            vertex = vertex3;
            edge = edge5;
            polygon2 = polygon24;
            Modify.h.append(vertex);
        }
        Modify.divide_knot_polygon(polygon22, vertex, edge, linkedList2, vertex2, edge2, linkedList3);
    }

    /*
     * Unable to fully structure code
     */
    private static void construct_sub(Ring var0, Ring var1_1) {
        var2_2 = var1_1.elements();
        var2_2.nextElement();
        while (var2_2.hasMoreElements()) {
            Modify.h.append((Vertex)var2_2.nextElement());
        }
        var3_3 = var0.elements();
        var4_4 = var1_1.elements();
        var5_5 = (Vertex)var3_3.nextElement();
        var6_6 = (Vertex)var4_4.nextElement();
        if (var0.size() == var1_1.size()) ** GOTO lbl43
        var7_7 = (Vertex)var3_3.nextElement();
        var8_9 = (Vertex)var4_4.nextElement();
        while (var3_3.hasMoreElements() || var4_4.hasMoreElements()) {
            var9_11 = new Vector3(var6_6, var8_9);
            var10_12 = new Vector3(var5_5, var7_7);
            var11_13 = new Vector3(var5_5, var8_9);
            var12_14 = new Vector3(var6_6, var7_7);
            var13_15 = Math.min(Math.abs(var11_13.sin(var9_11)), Math.abs(var11_13.sin(var10_12)));
            var15_16 = Math.min(Math.abs(var12_14.sin(var9_11)), Math.abs(var12_14.sin(var10_12)));
            if (var15_16 > var13_15 || !var4_4.hasMoreElements()) {
                Modify.h.append_a_new_polygon(var5_5, var7_7, var6_6);
                var5_5 = var7_7;
                var7_7 = (Vertex)var3_3.nextElement();
                continue;
            }
            Modify.h.append_a_new_polygon(var8_9, var6_6, var5_5);
            var6_6 = var8_9;
            var8_9 = (Vertex)var4_4.nextElement();
        }
        Modify.h.append_a_new_polygon(var5_5, var7_7, var6_6);
        Modify.h.append_a_new_polygon(var8_9, var6_6, var7_7);
        return;
lbl-1000:
        // 1 sources

        {
            var7_8 = (Vertex)var3_3.nextElement();
            var8_10 = (Vertex)var4_4.nextElement();
            if (var7_8.distance(var6_6) < var5_5.distance(var8_10)) {
                Modify.h.append_a_new_polygon(var5_5, var7_8, var6_6);
                Modify.h.append_a_new_polygon(var8_10, var6_6, var7_8);
            } else {
                Modify.h.append_a_new_polygon(var5_5, var7_8, var8_10);
                Modify.h.append_a_new_polygon(var8_10, var6_6, var5_5);
            }
            var5_5 = var7_8;
            var6_6 = var8_10;
lbl43:
            // 2 sources

            ** while (var3_3.hasMoreElements())
        }
lbl44:
        // 1 sources

    }

    public static void pop_main(LinkedList linkedList) {
        Vertex vertex;
        Vertex vertex2;
        Serializable serializable;
        Vertex vertex3 = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex3);
        Vector3 vector3 = new Vector3(0.0, 0.0, 0.0);
        Enumeration enumeration = Modify.h.temp_surface_lines.elements();
        Vector3 vector32 = ((SurfaceLine)enumeration.nextElement()).vector3();
        while (enumeration.hasMoreElements()) {
            Vector3 vector33 = ((SurfaceLine)enumeration.nextElement()).vector3();
            Vector3 vector34 = vector32.cross_product(vector33);
            vector3.add_self(vector34);
            vector32 = vector33;
        }
        vector3.normalize();
        Vertex vertex4 = new Vertex(0.0, 0.0, 0.0);
        enumeration = Modify.h.temp_surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (SurfaceLine)enumeration.nextElement();
            vertex4.add_self(serializable.start);
        }
        vertex4.multiple_self(1.0 / (double)Modify.h.temp_surface_lines.size());
        Modify.h.pivot_of_a_part[Modify.h.current_part_index] = vertex4;
        Modify.h.normal_of_a_part[Modify.h.current_part_index] = vector3;
        serializable = new Vector3(vertex3, vertex4);
        Vector3 vector35 = vector3.cross_product((Vector3)serializable);
        enumeration = Modify.h.temp_surface_lines.elements();
        Vertex vertex5 = ((SurfaceLine)enumeration.nextElement()).start;
        Vector3 vector36 = new Vector3(vertex4, vertex5);
        double d = vector35.dot_product(vector36);
        Vertex vertex6 = vertex5;
        Vertex vertex7 = vertex5;
        double d2 = d;
        double d3 = d;
        while (enumeration.hasMoreElements()) {
            vertex5 = ((SurfaceLine)enumeration.nextElement()).start;
            vector36 = new Vector3(vertex4, vertex5);
            d = vector35.dot_product(vector36);
            if (d > d2) {
                d2 = d;
                vertex6 = vertex5;
            }
            if (!(d < d3)) continue;
            d3 = d;
            vertex7 = vertex5;
        }
        Surface surface = new Surface(vertex4, vector3.cross_product(vector3.cross_product((Vector3)serializable)));
        LinkedList linkedList2 = new LinkedList();
        enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            vertex5 = Draw3DScene.image_plane_to_world_coords((Vertex2D)enumeration.nextElement());
            linkedList2.append(surface.cross_point(new Edge(vertex3, vertex5)));
        }
        System.out.println(linkedList2.size());
        Ring ring = new Ring(Modify.h.temp_edge_vertex_list);
        double d4 = Vector3.distance(vertex7, (Vertex)linkedList2.head());
        double d5 = Vector3.distance(vertex7, (Vertex)linkedList2.tail());
        if (d4 < d5) {
            vertex2 = vertex7;
            vertex = vertex6;
        } else {
            vertex2 = vertex6;
            vertex = vertex7;
        }
        Line line = new Line(vertex4, vector3.cross_product((Vector3)serializable));
        vertex2 = line.get_foot(vertex2);
        vertex = line.get_foot(vertex);
        LinkedList linkedList3 = Pop.generate_rings(ring, vertex2, vertex, linkedList2, vector3);
        Pop.construct(linkedList3);
        Modify.remove_broken_polygons();
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
    }
}

