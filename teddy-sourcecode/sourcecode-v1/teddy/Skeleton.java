/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Enumeration;
import teddy.Def;
import teddy.Draw3DScene;
import teddy.DrawPanel;
import teddy.Edge2D;
import teddy.Geometry2D;
import teddy.LinkedList;
import teddy.NewPolyhedron;
import teddy.Polyhedron;
import teddy.ReTessellation;
import teddy.SkEdge2D;
import teddy.SkPolygon2D;
import teddy.SkVertex2D;
import teddy.Tessellation;
import teddy.TrimData;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Skeleton {
    public static LinkedList triangles;
    public static LinkedList edges;
    public static SkVertex2D[] vertices;
    public static int n_vertices;
    public static NewPolyhedron h;
    private static int steps;
    private static double[] cos;
    private static double[] sin;

    private static void propagate(SkPolygon2D skPolygon2D, SkEdge2D skEdge2D, TrimData trimData, LinkedList linkedList) {
        SkPolygon2D skPolygon2D2;
        SkPolygon2D skPolygon2D3 = skPolygon2D;
        SkEdge2D skEdge2D2 = skEdge2D;
        while (true) {
            SkEdge2D skEdge2D3;
            skPolygon2D3.mark();
            skPolygon2D2 = skEdge2D2.the_other_polygon(skPolygon2D3);
            if (skPolygon2D2.type != 1 || !trimData.terminals_are_within_this_circle(skEdge2D3 = skPolygon2D2.the_other_internal_edge(skEdge2D2))) break;
            trimData.append_terminal_edge(skPolygon2D2.get_external_edge());
            skEdge2D2 = skEdge2D3;
            skPolygon2D3 = skPolygon2D2;
        }
        if (skPolygon2D2.type == 2) {
            SkVertex2D skVertex2D = skPolygon2D2.center;
            skPolygon2D2.setTrimData(skEdge2D2, trimData);
            Skeleton.propagate_junction(skPolygon2D2, linkedList);
            return;
        }
        SkVertex2D skVertex2D = new SkVertex2D(skEdge2D2.mid_point());
        skVertex2D.height = skEdge2D2.height;
        Enumeration enumeration = trimData.terminal_edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D4 = (SkEdge2D)enumeration.nextElement();
            linkedList.append(new SkPolygon2D(skEdge2D4, skVertex2D));
        }
    }

    private static void create_polygons_square(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        int n = -steps;
        while (n < steps) {
            double d13 = cos[n + steps];
            double d14 = d11 * sin[n + steps];
            double d15 = d8 * sin[n + steps];
            double d16 = cos[n + 1 + steps];
            double d17 = d11 * sin[n + 1 + steps];
            double d18 = d8 * sin[n + 1 + steps];
            if (n == -steps) {
                d13 = 0.0;
                d14 = -d11;
                d15 = -d8;
            } else if (n == steps - 1) {
                d16 = 0.0;
                d17 = d11;
                d18 = d8;
            }
            double d19 = d10 + (d - d10) * d13;
            double d20 = d12 + (d3 - d12) * d13;
            double d21 = d7 + (d4 - d7) * d13;
            double d22 = d9 + (d6 - d9) * d13;
            double d23 = d7 + (d4 - d7) * d16;
            double d24 = d9 + (d6 - d9) * d16;
            double d25 = d10 + (d - d10) * d16;
            double d26 = d12 + (d3 - d12) * d16;
            if (n == -1) {
                d23 = d4;
                d24 = d6;
                d25 = d;
                d26 = d3;
                d18 = 0.0;
            } else if (n == 0) {
                d19 = d;
                d20 = d3;
                d21 = d4;
                d22 = d6;
                d15 = 0.0;
            }
            if (Vector2.distance(d19, d20, d23, d24) > Vector2.distance(d21, d22, d25, d26)) {
                newPolyhedron.add_temp_polygon(d25, d17, d26, d23, d18, d24, d21, d15, d22);
                newPolyhedron.add_temp_polygon(d25, d17, d26, d21, d15, d22, d19, d14, d20);
            } else {
                newPolyhedron.add_temp_polygon(d25, d17, d26, d23, d18, d24, d19, d14, d20);
                newPolyhedron.add_temp_polygon(d23, d18, d24, d21, d15, d22, d19, d14, d20);
            }
            ++n;
        }
    }

    private static void create_polygons_junction_prepare(Vertex[] vertexArray, double d, double d2, double d3, double d4, double d5, double d6) {
        if (d2 > d5) {
            Skeleton.create_polygons_junction_prepare_sub(vertexArray, d, d2, d3, d4, d5, d6);
            return;
        }
        Skeleton.create_polygons_junction_prepare_sub(vertexArray, d4, d5, d6, d, d2, d3);
        Vertex[] vertexArray2 = new Vertex[steps + 1];
        int n = 0;
        while (n <= steps) {
            vertexArray2[n] = vertexArray[steps - n];
            ++n;
        }
        n = 0;
        while (n <= steps) {
            vertexArray[n] = vertexArray2[n];
            ++n;
        }
    }

    public static void create_T_triangle(LinkedList linkedList, LinkedList linkedList2, SkVertex2D skVertex2D, SkVertex2D skVertex2D2, SkVertex2D skVertex2D3) {
        SkEdge2D skEdge2D = new SkEdge2D(skVertex2D, skVertex2D2, 0);
        linkedList2.append(skEdge2D);
        SkEdge2D skEdge2D2 = new SkEdge2D(skVertex2D2, skVertex2D3, 0);
        linkedList2.append(skEdge2D2);
        SkEdge2D skEdge2D3 = Skeleton.get_edge(linkedList2, skVertex2D3, skVertex2D);
        linkedList.append(new SkPolygon2D(skEdge2D, skEdge2D2, skEdge2D3, 0));
    }

    private static void propagate_junction(SkPolygon2D skPolygon2D, LinkedList linkedList) {
        SkEdge2D skEdge2D = skPolygon2D.get_longest_edge();
        TrimData trimData = new TrimData();
        boolean bl = false;
        boolean bl2 = false;
        int n = 0;
        while (n < skPolygon2D.edges.size()) {
            SkEdge2D skEdge2D2 = skPolygon2D.get_edge(n);
            if (skEdge2D2 != skEdge2D) {
                TrimData trimData2 = skPolygon2D.getTrimData(n);
                if (trimData2 != null) {
                    if (!trimData2.terminals_are_within_this_circle(skEdge2D2)) {
                        bl = true;
                    } else {
                        trimData.merge(trimData2);
                    }
                } else {
                    bl2 = true;
                }
            }
            ++n;
        }
        if (skPolygon2D.getTrimData(skEdge2D) != null) {
            bl = true;
        }
        if (bl2) {
            return;
        }
        if (bl) {
            return;
        }
        Skeleton.propagate(skPolygon2D, skEdge2D, trimData, linkedList);
    }

    private static SkEdge2D find_appropriate_edge(LinkedList linkedList, SkEdge2D skEdge2D, SkVertex2D skVertex2D) {
        Vector2 vector2 = skEdge2D.vector2();
        if (skEdge2D.start != skVertex2D) {
            vector2.multiple_self(-1.0);
        }
        SkEdge2D skEdge2D2 = null;
        double d = 360.0;
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            double d2;
            SkEdge2D skEdge2D3 = (SkEdge2D)enumeration.nextElement();
            Vector2 vector22 = skEdge2D3.vector2();
            if (skEdge2D3.start != skVertex2D) {
                vector22.multiple_self(-1.0);
            }
            if (!((d2 = vector2.get_angle(vector22)) < d)) continue;
            d = d2;
            skEdge2D2 = skEdge2D3;
        }
        return skEdge2D2;
    }

    public static SkEdge2D get_edge(LinkedList linkedList, SkVertex2D skVertex2D, SkVertex2D skVertex2D2) {
        SkEdge2D skEdge2D;
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (!skEdge2D.equals(skVertex2D, skVertex2D2)) continue;
            skVertex2D.add_owner(skEdge2D);
            skVertex2D2.add_owner(skEdge2D);
            if (skEdge2D.type == 2) {
                System.out.println("edge shared by more than 2 polygons (SKeleton)");
            }
            skEdge2D.type = 2;
            return skEdge2D;
        }
        skEdge2D = new SkEdge2D(skVertex2D, skVertex2D2, 1);
        linkedList.append(skEdge2D);
        return skEdge2D;
    }

    private static void create_polygons_junction_simple_sub(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int n = 0;
        while (n < steps) {
            double d10 = cos[n + steps];
            double d11 = d8 + (d5 - d8) * sin[n + steps];
            double d12 = d8 + (d2 - d8) * sin[n + steps];
            double d13 = cos[n + 1 + steps];
            double d14 = d8 + (d5 - d8) * sin[n + 1 + steps];
            double d15 = d8 + (d2 - d8) * sin[n + 1 + steps];
            if (n == steps - 1) {
                d13 = 0.0;
                d14 = d5;
                d15 = d2;
            }
            double d16 = d4 + (d7 - d4) * d10;
            double d17 = d6 + (d9 - d6) * d10;
            double d18 = d + (d7 - d) * d10;
            double d19 = d3 + (d9 - d3) * d10;
            double d20 = d + (d7 - d) * d13;
            double d21 = d3 + (d9 - d3) * d13;
            double d22 = d4 + (d7 - d4) * d13;
            double d23 = d6 + (d9 - d6) * d13;
            if (n == 0) {
                newPolyhedron.add_temp_polygon(d22, d14, d23, d20, d15, d21, d7, d8, d9);
            } else {
                newPolyhedron.add_temp_polygon(d22, d14, d23, d20, d15, d21, d18, d12, d19);
                newPolyhedron.add_temp_polygon(d22, d14, d23, d18, d12, d19, d16, d11, d17);
            }
            ++n;
        }
    }

    private static void propagate_junction_final(SkPolygon2D skPolygon2D, LinkedList linkedList) {
        Object object;
        LinkedList linkedList2 = new LinkedList();
        int n = 0;
        while (n < skPolygon2D.edges.size()) {
            object = skPolygon2D.getTrimData(n);
            if (object != null) {
                linkedList2.connect(((TrimData)object).terminal_edges);
            }
            ++n;
        }
        SkVertex2D skVertex2D = skPolygon2D.center;
        object = linkedList2.elements();
        while (object.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)object.nextElement();
            linkedList.append(new SkPolygon2D(skEdge2D, skVertex2D));
        }
    }

    public static SkVertex2D get_vertex(int n) {
        if (n >= n_vertices) {
            n -= n / n_vertices * n_vertices;
        }
        if (n < 0) {
            n += (-n / n_vertices + 1) * n_vertices;
        }
        return vertices[n];
    }

    public static LinkedList get_skeleton_edges(LinkedList linkedList) {
        return new LinkedList();
    }

    private static void create_polygons_junction(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double d13 = Vector2.distance(d7, d9, d10, d12);
        if (d13 < Vector2.distance(d7, d9, d, d3) && d13 < Vector2.distance(d7, d9, d4, d6) && d13 < Vector2.distance(d10, d12, d, d3) && d13 < Vector2.distance(d10, d12, d, d3)) {
            Skeleton.create_polygons_junction_simple(newPolyhedron, d7, d8, d9, d10, d11, d12, d, d2, d3);
            Skeleton.create_polygons_junction_simple(newPolyhedron, d10, d11, d12, d7, d8, d9, d4, d5, d6);
            return;
        }
        Skeleton.create_polygons_junction_complicated(newPolyhedron, d7, d8, d9, d10, d11, d12, d, d2, d3);
        Skeleton.create_polygons_junction_complicated(newPolyhedron, d10, d11, d12, d7, d8, d9, d4, d5, d6);
    }

    private static void create_polygons_junction_prepare_sub(Vertex[] vertexArray, double d, double d2, double d3, double d4, double d5, double d6) {
        int n = 0;
        while (n <= steps) {
            double d7 = cos[n + steps];
            double d8 = sin[n + steps];
            double d9 = d + (d4 - d) * d7;
            double d10 = d3 + (d6 - d3) * d7;
            d8 = d5 + (d2 - d5) * d8;
            if (n == 0) {
                d9 = d4;
                d10 = d6;
                d8 = d5;
            }
            if (n == steps) {
                d9 = d;
                d10 = d3;
                d8 = d2;
            }
            vertexArray[Skeleton.steps - n] = new Vertex(d9, -d8, d10);
            ++n;
        }
        if (d2 > 0.0 && d5 > 0.0) {
            double d11 = vertexArray[0].x;
            double d12 = (vertexArray[Skeleton.steps].x - vertexArray[0].x) / (double)steps;
            double d13 = vertexArray[0].z;
            double d14 = (vertexArray[Skeleton.steps].z - vertexArray[0].z) / (double)steps;
            int n2 = 1;
            while (n2 <= steps - 1) {
                vertexArray[n2].x = d11 + d12 * (double)n2;
                vertexArray[n2].z = d13 + d14 * (double)n2;
                ++n2;
            }
        }
    }

    private static void create_polygons_external(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        if (d4 == d && d6 == d3) {
            System.out.println("clashed internal");
        }
        int n = -steps;
        while (n < steps) {
            double d10 = cos[n + steps];
            double d11 = d8 * sin[n + steps];
            double d12 = cos[n + 1 + steps];
            double d13 = d8 * sin[n + 1 + steps];
            double d14 = d7 + (d - d7) * d10;
            double d15 = d9 + (d3 - d9) * d10;
            double d16 = d7 + (d4 - d7) * d10;
            double d17 = d9 + (d6 - d9) * d10;
            double d18 = d7 + (d4 - d7) * d12;
            double d19 = d9 + (d6 - d9) * d12;
            double d20 = d7 + (d - d7) * d12;
            double d21 = d9 + (d3 - d9) * d12;
            if (n == -1) {
                d18 = d4;
                d19 = d6;
                d20 = d;
                d21 = d3;
                d13 = 0.0;
            } else if (n == 0) {
                d14 = d;
                d15 = d3;
                d16 = d4;
                d17 = d6;
                d11 = 0.0;
            }
            if (n == -steps) {
                newPolyhedron.add_temp_polygon(d7, d11, d9, d20, d13, d21, d18, d13, d19);
            } else if (n == steps - 1) {
                newPolyhedron.add_temp_polygon(d16, d11, d17, d14, d11, d15, d7, d13, d9);
            } else if (Vector2.distance(d14, d15, d18, d19) > Vector2.distance(d16, d17, d20, d21)) {
                newPolyhedron.add_temp_polygon(d20, d13, d21, d18, d13, d19, d16, d11, d17);
                newPolyhedron.add_temp_polygon(d20, d13, d21, d16, d11, d17, d14, d11, d15);
            } else {
                newPolyhedron.add_temp_polygon(d20, d13, d21, d18, d13, d19, d14, d11, d15);
                newPolyhedron.add_temp_polygon(d18, d13, d19, d16, d11, d17, d14, d11, d15);
            }
            ++n;
        }
    }

    private static void cos_sin_init() {
        int n = -steps;
        while (n <= steps) {
            Skeleton.cos[n + Skeleton.steps] = Math.cos(Math.PI * (double)n / (double)steps / 2.0);
            Skeleton.sin[n + Skeleton.steps] = Math.sin(Math.PI * (double)n / (double)steps / 2.0);
            ++n;
        }
        Skeleton.cos[0] = 0.0;
        Skeleton.sin[0] = -1.0;
        Skeleton.cos[Skeleton.steps] = 1.0;
        Skeleton.sin[Skeleton.steps] = 0.0;
        Skeleton.cos[Skeleton.steps * 2] = 0.0;
        Skeleton.sin[Skeleton.steps * 2] = 1.0;
    }

    private static void create_polygons_junction_complicated(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        Vertex[] vertexArray = new Vertex[steps + 1];
        Vertex[] vertexArray2 = new Vertex[steps + 1];
        Vertex[] vertexArray3 = new Vertex[steps + 1];
        Skeleton.create_polygons_junction_prepare(vertexArray, d4, d5, d6, d7, 0.0, d9);
        Skeleton.create_polygons_junction_prepare(vertexArray2, d, d2, d3, d7, 0.0, d9);
        Skeleton.create_polygons_junction_prepare(vertexArray3, d, d2, d3, d4, d5, d6);
        Vertex[] vertexArray4 = new Vertex[steps * 3 + 1];
        int n = 0;
        while (n < steps) {
            vertexArray4[n] = vertexArray[n];
            ++n;
        }
        n = 0;
        while (n < steps) {
            vertexArray4[Skeleton.steps + n] = vertexArray2[steps - n];
            ++n;
        }
        n = 0;
        while (n <= steps) {
            vertexArray4[Skeleton.steps * 2 + n] = vertexArray3[n];
            ++n;
        }
        LinkedList linkedList = Skeleton.delauny(vertexArray4);
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Vertex[] vertexArray5 = (Vertex[])enumeration.nextElement();
            Skeleton.create_polygons_junction_sub(vertexArray5[0], vertexArray5[1], vertexArray5[2]);
        }
    }

    Skeleton() {
    }

    private static LinkedList delauny(Vertex[] vertexArray) {
        Vertex vertex;
        Vertex[] vertexArray2;
        LinkedList linkedList = new LinkedList();
        int n = 0;
        while (n < steps * 3) {
            vertexArray2 = new Vertex[]{vertexArray[n], vertexArray[n + 1], Skeleton.delauny_sub(vertexArray, vertexArray[n], vertexArray[n + 1])};
            if (!(n > 0 && vertexArray2[2].same_position(vertexArray[n - 1]) || n == 0 && vertexArray2[2].same_position(vertexArray[steps * 3 - 1]))) {
                linkedList.append(vertexArray2);
            }
            ++n;
        }
        if (linkedList.size() == 10) {
            return linkedList;
        }
        Enumeration enumeration = linkedList.elements();
        Vertex[] vertexArray3 = new Vertex[3];
        while (enumeration.hasMoreElements()) {
            vertexArray2 = (Vertex[])enumeration.nextElement();
            vertex = vertexArray2[2];
            if (Skeleton.get_origin(vertexArray, vertex) != 1) continue;
            vertexArray3[0] = vertexArray2[0];
            break;
        }
        while (enumeration.hasMoreElements()) {
            vertexArray2 = (Vertex[])enumeration.nextElement();
            vertex = vertexArray2[2];
            if (Skeleton.get_origin(vertexArray, vertex) != 2) continue;
            vertexArray3[1] = vertexArray2[0];
            break;
        }
        while (enumeration.hasMoreElements()) {
            vertexArray2 = (Vertex[])enumeration.nextElement();
            vertex = vertexArray2[2];
            if (Skeleton.get_origin(vertexArray, vertex) != 0) continue;
            vertexArray3[2] = vertexArray2[0];
            linkedList.append(vertexArray3);
            break;
        }
        return linkedList;
    }

    private static int get_origin(Vertex[] vertexArray, Vertex vertex) {
        int n = 0;
        while (vertexArray[n] != vertex) {
            ++n;
        }
        return n / steps;
    }

    private static void create_polygons_junction_sub(Vertex vertex, Vertex vertex2, Vertex vertex3) {
        h.add_temp_polygon(vertex.x, vertex.y, vertex.z, vertex2.x, vertex2.y, vertex2.z, vertex3.x, vertex3.y, vertex3.z);
        h.add_temp_polygon(vertex2.x, -vertex2.y, vertex2.z, vertex.x, -vertex.y, vertex.z, vertex3.x, -vertex3.y, vertex3.z);
    }

    private static void create_polygons_junction_sub(Vertex vertex, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
        if (Vector3.distance(vertex, vertex3) > Vector3.distance(vertex2, vertex4)) {
            Vertex vertex5 = vertex4;
            vertex4 = vertex3;
            vertex3 = vertex2;
            vertex2 = vertex;
            vertex = vertex5;
        }
        h.add_temp_polygon(vertex.x, vertex.y, vertex.z, vertex2.x, vertex2.y, vertex2.z, vertex3.x, vertex3.y, vertex3.z);
        h.add_temp_polygon(vertex.x, vertex.y, vertex.z, vertex3.x, vertex3.y, vertex3.z, vertex4.x, vertex4.y, vertex4.z);
        h.add_temp_polygon(vertex2.x, -vertex2.y, vertex2.z, vertex.x, -vertex.y, vertex.z, vertex3.x, -vertex3.y, vertex3.z);
        h.add_temp_polygon(vertex3.x, -vertex3.y, vertex3.z, vertex.x, -vertex.y, vertex.z, vertex4.x, -vertex4.y, vertex4.z);
    }

    static {
        steps = 4;
        cos = new double[steps * 2 + 1];
        sin = new double[steps * 2 + 1];
    }

    private static void create_polygons_junction_simple(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        Skeleton.create_polygons_junction_simple_sub(newPolyhedron, d, d2, d3, d4, d5, d6, d7, 0.0, d9);
        Skeleton.create_polygons_junction_simple_sub(newPolyhedron, d4, -d5, d6, d, -d2, d3, d7, 0.0, d9);
    }

    public static void create_S_triangle(LinkedList linkedList, LinkedList linkedList2, SkVertex2D skVertex2D, SkVertex2D skVertex2D2, SkVertex2D skVertex2D3) {
        SkEdge2D skEdge2D = new SkEdge2D(skVertex2D, skVertex2D2, 0);
        linkedList2.append(skEdge2D);
        SkEdge2D skEdge2D2 = Skeleton.get_edge(linkedList2, skVertex2D2, skVertex2D3);
        SkEdge2D skEdge2D3 = Skeleton.get_edge(linkedList2, skVertex2D3, skVertex2D);
        linkedList.append(new SkPolygon2D(skEdge2D, skEdge2D2, skEdge2D3, 1));
    }

    public static void remove_S_triangle(LinkedList linkedList, LinkedList linkedList2, SkPolygon2D skPolygon2D) {
        SkEdge2D skEdge2D = skPolygon2D.get_external_edge();
        Skeleton.remove_edge(linkedList2, skEdge2D);
        LinkedList linkedList3 = skPolygon2D.get_internal_edges();
        ((SkEdge2D)linkedList3.head()).type = 1;
        ((SkEdge2D)linkedList3.tail()).type = 1;
    }

    public static void create_J_triangle(LinkedList linkedList, LinkedList linkedList2, SkEdge2D skEdge2D) {
        LinkedList linkedList3 = new LinkedList();
        SkEdge2D skEdge2D2 = skEdge2D;
        SkEdge2D skEdge2D3 = null;
        while (true) {
            skEdge2D2.type = 2;
            linkedList3.append(skEdge2D2);
            SkVertex2D skVertex2D = (SkVertex2D)skEdge2D2.start;
            if (skVertex2D == skEdge2D.end) break;
            LinkedList linkedList4 = skVertex2D.get_not_shared_edges();
            skEdge2D3 = linkedList4.size() > 1 ? Skeleton.find_appropriate_edge(linkedList4, skEdge2D2, skVertex2D) : (SkEdge2D)linkedList4.head();
            skEdge2D2 = skEdge2D3;
        }
        System.out.println("J" + linkedList3.size());
        linkedList.append(new SkPolygon2D(linkedList3, 2));
    }

    public static Polyhedron generate_polyhedron(LinkedList linkedList) {
        double d;
        Vertex2D vertex2D;
        Object object;
        Object object2;
        System.out.println("Skeleton start ------");
        DrawPanel.special_segments = new LinkedList();
        int n = linkedList.size();
        vertices = new SkVertex2D[linkedList.size()];
        int n2 = 0;
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Skeleton.vertices[n2++] = new SkVertex2D((Point)enumeration.nextElement());
        }
        Skeleton.vertices[n - 1] = vertices[0];
        n_vertices = n - 1;
        edges = new LinkedList();
        triangles = new LinkedList();
        int n3 = 0;
        while (n3 < n - 1) {
            object2 = vertices[n3];
            object = vertices[n3 + 1];
            double d2 = 1.0;
            vertex2D = null;
            int n4 = -100;
            int n5 = 0;
            while (n5 < n - 1) {
                double d3;
                if (n5 != n3 && n5 != n3 + 1 && (n3 != n - 2 || n5 != 0) && Geometry2D.left_side((Vertex2D)object2, (Vertex2D)object, vertices[n5]) && Geometry2D.left_side(Skeleton.get_vertex(n5 - 1), Skeleton.get_vertex(n5), Skeleton.get_vertex(n5 + 1), (Vertex2D)object2) && Geometry2D.left_side(Skeleton.get_vertex(n5 - 1), Skeleton.get_vertex(n5), Skeleton.get_vertex(n5 + 1), (Vertex2D)object) && (d3 = new Vector2(vertices[n5], (Vertex2D)object2).get_cos(new Vector2(vertices[n5], (Vertex2D)object))) < d2) {
                    d2 = d3;
                    vertex2D = vertices[n5];
                    n4 = n5;
                }
                ++n5;
            }
            if (n4 == n3 + 2 || n3 == n - 2 && n4 == 1 || n3 == n - 3 && n4 == 0) {
                Skeleton.create_T_triangle(triangles, edges, (SkVertex2D)object2, (SkVertex2D)object, vertex2D);
            } else if (n4 != n3 - 1 && (n3 != 0 || n4 != n - 2)) {
                Skeleton.create_S_triangle(triangles, edges, (SkVertex2D)object2, (SkVertex2D)object, vertex2D);
            }
            ++n3;
        }
        enumeration = edges.elements();
        while (enumeration.hasMoreElements()) {
            SkEdge2D skEdge2D = (SkEdge2D)enumeration.nextElement();
            if (skEdge2D.type != 1) continue;
            Skeleton.create_J_triangle(triangles, edges, skEdge2D);
        }
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            SkPolygon2D skPolygon2D = (SkPolygon2D)enumeration.nextElement();
            if (skPolygon2D.type == 1) {
                object2 = skPolygon2D.get_internal_edges();
                double d4 = ((SkEdge2D)((LinkedList)object2).head()).length();
                d = ((SkEdge2D)((LinkedList)object2).tail()).length();
                skPolygon2D.height = (d4 + d) / 4.0 * Def.GENERATE_HEIGHT;
                continue;
            }
            if (skPolygon2D.type == 2) {
                object2 = skPolygon2D.get_longest_edge();
                skPolygon2D.height = ((Edge2D)object2).length() / 2.0 * Def.GENERATE_HEIGHT;
                continue;
            }
            if (skPolygon2D.type != 0) continue;
            object2 = skPolygon2D.get_internal_edge();
            object = skPolygon2D.get_external_edges();
            SkEdge2D skEdge2D = (SkEdge2D)((LinkedList)object).head();
            SkEdge2D skEdge2D2 = (SkEdge2D)((LinkedList)object).tail();
            Vertex2D vertex2D2 = ((Edge2D)object2).mid_point();
            double d5 = skEdge2D.distance(vertex2D2);
            double d6 = skEdge2D2.distance(vertex2D2);
            skPolygon2D.height = Math.min(d5, d6) * Def.GENERATE_HEIGHT;
        }
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            SkPolygon2D skPolygon2D = (SkPolygon2D)enumeration.nextElement();
            object2 = skPolygon2D.edges.elements();
            while (object2.hasMoreElements()) {
                ((SkEdge2D)object2.nextElement()).set_height();
            }
            if (skPolygon2D.type != 2) continue;
            skPolygon2D.center.height = skPolygon2D.center_edge == null ? skPolygon2D.height : skPolygon2D.center_edge.height;
        }
        LinkedList linkedList2 = new LinkedList();
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (SkPolygon2D)enumeration.nextElement();
            if (((SkPolygon2D)object2).type != 0) continue;
            Skeleton.propagate_terminal((SkPolygon2D)object2, linkedList2);
        }
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (SkPolygon2D)enumeration.nextElement();
            if (((SkPolygon2D)object2).type != 2 || ((SkPolygon2D)object2).marked) continue;
            Skeleton.propagate_junction_final((SkPolygon2D)object2, linkedList2);
        }
        Skeleton.cos_sin_init();
        h = new NewPolyhedron();
        enumeration = linkedList2.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (SkPolygon2D)enumeration.nextElement();
            double d7 = Skeleton.reverse_convert(((SkPolygon2D)object2).center.height);
            Vertex2D vertex2D3 = Skeleton.reverse_convert(((SkPolygon2D)object2).center);
            Vertex2D vertex2D4 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(0));
            Vertex2D vertex2D5 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(1));
            Skeleton.create_polygons_external(h, vertex2D4.x, 0.0, vertex2D4.y, vertex2D5.x, 0.0, vertex2D5.y, vertex2D3.x, d7, vertex2D3.y);
        }
        enumeration = triangles.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (SkPolygon2D)enumeration.nextElement();
            if (!((SkPolygon2D)object2).marked && ((SkPolygon2D)object2).type == 1) {
                SkEdge2D skEdge2D = (SkEdge2D)((SkPolygon2D)object2).get_internal_edges().head();
                SkEdge2D skEdge2D3 = (SkEdge2D)((SkPolygon2D)object2).get_internal_edges().tail();
                d = Skeleton.reverse_convert(skEdge2D.height);
                double d8 = Skeleton.reverse_convert(skEdge2D3.height);
                Vertex2D vertex2D6 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(0));
                Vertex2D vertex2D7 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(1));
                Vertex2D vertex2D8 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(2));
                Vertex2D vertex2D9 = Skeleton.reverse_convert(skEdge2D.mid_point());
                Vertex2D vertex2D10 = Skeleton.reverse_convert(skEdge2D3.mid_point());
                Skeleton.create_polygons_square(h, vertex2D6.x, 0.0, vertex2D6.y, vertex2D7.x, 0.0, vertex2D7.y, vertex2D9.x, d, vertex2D9.y, vertex2D10.x, d8, vertex2D10.y);
                Skeleton.create_polygons_internal(h, vertex2D10.x, d8, vertex2D10.y, vertex2D9.x, d, vertex2D9.y, vertex2D8.x, 0.0, vertex2D8.y);
                continue;
            }
            if (((SkPolygon2D)object2).marked || ((SkPolygon2D)object2).type != 2) continue;
            SkVertex2D skVertex2D = ((SkPolygon2D)object2).center;
            Vertex2D vertex2D11 = Skeleton.reverse_convert(skVertex2D);
            d = Skeleton.reverse_convert(skVertex2D.height);
            int n6 = 0;
            while (n6 < ((SkPolygon2D)object2).edges.size()) {
                if (((SkPolygon2D)object2).trimData[n6] == null && ((SkPolygon2D)object2).get_edge(n6) != ((SkPolygon2D)object2).center_edge) {
                    vertex2D = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(n6));
                    Vertex2D vertex2D12 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_vertex(n6 + 1));
                    Vertex2D vertex2D13 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_edge(n6).mid_point());
                    double d9 = Skeleton.reverse_convert(((SkPolygon2D)object2).get_edge((int)n6).height);
                    Skeleton.create_polygons_junction(h, vertex2D.x, 0.0, vertex2D.y, vertex2D12.x, 0.0, vertex2D12.y, vertex2D13.x, d9, vertex2D13.y, vertex2D11.x, d, vertex2D11.y);
                }
                ++n6;
            }
        }
        h.postprocess_main();
        Tessellation.remove_thin_polygons(h);
        ReTessellation.smooth5(h);
        h.set_parameters();
        return h;
    }

    public static void remove_edge(LinkedList linkedList, SkEdge2D skEdge2D) {
        ((SkVertex2D)skEdge2D.start).remove_owner(skEdge2D);
        ((SkVertex2D)skEdge2D.end).remove_owner(skEdge2D);
        linkedList.remove(skEdge2D);
    }

    private static Vertex delauny_sub(Vertex[] vertexArray, Vertex vertex, Vertex vertex2) {
        Vertex2D vertex2D = new Vertex2D(vertex.x, vertex.z);
        Vertex2D vertex2D2 = new Vertex2D(vertex2.x, vertex2.z);
        int n = steps * 3 + 1;
        double d = 1.0;
        Vertex vertex3 = null;
        int n2 = -100;
        int n3 = 0;
        while (n3 < n - 1) {
            double d2;
            Vertex2D vertex2D3;
            if (vertexArray[n3] != vertex && vertexArray[n3] != vertex2 && !Geometry2D.left_side(vertex2D, vertex2D2, vertex2D3 = new Vertex2D(vertexArray[n3].x, vertexArray[n3].z)) && (d2 = new Vector2(vertex2D3, vertex2D).get_cos(new Vector2(vertex2D3, vertex2D2))) < d) {
                d = d2;
                vertex3 = vertexArray[n3];
                n2 = n3;
            }
            ++n3;
        }
        return vertex3;
    }

    private static void create_polygons_internal(NewPolyhedron newPolyhedron, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        if (d == d4 && d3 == d6 && d2 == d5) {
            System.out.println("clashed internal");
        }
        int n = -steps;
        while (n < steps) {
            double d10 = cos[n + steps];
            double d11 = d5 * sin[n + steps];
            double d12 = d2 * sin[n + steps];
            double d13 = cos[n + 1 + steps];
            double d14 = d5 * sin[n + 1 + steps];
            double d15 = d2 * sin[n + 1 + steps];
            if (n == -steps) {
                d10 = 0.0;
                d11 = -d5;
                d12 = -d2;
            } else if (n == steps - 1) {
                d13 = 0.0;
                d14 = d5;
                d15 = d2;
            }
            double d16 = d4 + (d7 - d4) * d10;
            double d17 = d6 + (d9 - d6) * d10;
            double d18 = d + (d7 - d) * d10;
            double d19 = d3 + (d9 - d3) * d10;
            double d20 = d + (d7 - d) * d13;
            double d21 = d3 + (d9 - d3) * d13;
            double d22 = d4 + (d7 - d4) * d13;
            double d23 = d6 + (d9 - d6) * d13;
            if (n == -1) {
                newPolyhedron.add_temp_polygon(d7, 0.0, d9, d18, d12, d19, d16, d11, d17);
            } else if (n == 0) {
                newPolyhedron.add_temp_polygon(d22, d14, d23, d20, d15, d21, d7, 0.0, d9);
            } else if (Vector2.distance(d16, d17, d20, d21) > Vector2.distance(d18, d19, d22, d23)) {
                newPolyhedron.add_temp_polygon(d22, d14, d23, d20, d15, d21, d18, d12, d19);
                newPolyhedron.add_temp_polygon(d22, d14, d23, d18, d12, d19, d16, d11, d17);
            } else {
                newPolyhedron.add_temp_polygon(d22, d14, d23, d20, d15, d21, d16, d11, d17);
                newPolyhedron.add_temp_polygon(d20, d15, d21, d18, d12, d19, d16, d11, d17);
            }
            ++n;
        }
    }

    private static void propagate_terminal(SkPolygon2D skPolygon2D, LinkedList linkedList) {
        SkVertex2D skVertex2D = skPolygon2D.get_terminal_vertex();
        LinkedList linkedList2 = skPolygon2D.get_external_edges();
        SkEdge2D skEdge2D = skPolygon2D.get_internal_edge();
        TrimData trimData = new TrimData(skVertex2D, linkedList2);
        Skeleton.propagate(skPolygon2D, skEdge2D, trimData, linkedList);
    }

    public static Vertex2D reverse_convert(Vertex2D vertex2D) {
        return new Vertex2D(Draw3DScene.reverse_convertX(vertex2D.x), Draw3DScene.reverse_convertY(vertex2D.y));
    }

    public static double reverse_convert(double d) {
        return Draw3DScene.reverse_convertZ(d);
    }
}

