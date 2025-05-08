/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.ProjectedEdge;
import teddy.Surface;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class Geometry {
    public static Polyhedron h;
    public static Vertex camera;
    public static Polygon2[] sorted_polygons;

    private static Vertex cross_point(Polygon2 polygon2, Vertex2D vertex2D) {
        Vertex vertex = Draw3DScene.image_plane_to_world_coords(vertex2D);
        Edge edge = new Edge(camera, vertex);
        return polygon2.cross_point(edge);
    }

    Geometry() {
    }

    public static Objects find_vertex_on_surface(Vertex2D vertex2D, boolean bl) {
        Vertex vertex = null;
        Polygon2 polygon2 = null;
        double d = -1.0;
        Vertex vertex2 = null;
        Polygon2 polygon22 = null;
        int n = 0;
        while (n < Geometry.h.n_polygons) {
            polygon22 = sorted_polygons[n];
            if (polygon22.front_facing == bl && Geometry.on_surface(polygon22, vertex2D)) {
                double d2;
                vertex2 = Geometry.cross_point(polygon22, vertex2D);
                d = d2 = Vector3.distance(camera, vertex2);
                vertex = vertex2;
                polygon2 = polygon22;
                break;
            }
            ++n;
        }
        if (d != -1.0) {
            return new Objects(polygon2, vertex);
        }
        return null;
    }

    public static LinkedList surface_path(Vertex2D vertex2D, Vertex2D vertex2D2, Vertex vertex, Vertex vertex2, Polygon2 polygon2, Polygon2 polygon22) {
        LinkedList linkedList = new LinkedList();
        if (polygon2 == polygon22) {
            return linkedList;
        }
        ProjectedEdge projectedEdge = new ProjectedEdge(vertex2D, vertex2D2);
        Polygon2 polygon23 = polygon2;
        Vertex vertex3 = vertex;
        ProjectedEdge projectedEdge2 = projectedEdge;
        Surface surface = new Surface(camera, Draw3DScene.image_plane_to_world_coords(vertex2D), Draw3DScene.image_plane_to_world_coords(vertex2D2));
        while (polygon23 != polygon22) {
            Objects objects = Geometry.find_cross_edge(polygon23, projectedEdge, projectedEdge2.original);
            ProjectedEdge projectedEdge3 = (ProjectedEdge)objects.get(0);
            Vertex2D vertex2D3 = (Vertex2D)objects.get(1);
            Vertex vertex4 = surface.cross_point(projectedEdge3.original);
            linkedList.append(new Objects(projectedEdge3.original, vertex4));
            polygon23 = projectedEdge3.original.get_another_polygon(polygon23);
            vertex3 = vertex4.copy();
            projectedEdge2 = projectedEdge3;
        }
        return linkedList;
    }

    public static boolean on_surface(Polygon2 polygon2, Vertex2D vertex2D) {
        int n = 0;
        while (n < polygon2.n_edges) {
            if (!new ProjectedEdge(polygon2.edges(n)).in(polygon2, vertex2D)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private static Objects find_cross_edge(Polygon2 polygon2, ProjectedEdge projectedEdge, Edge edge) {
        int n = 0;
        while (n < polygon2.n_edges) {
            ProjectedEdge projectedEdge2;
            if (polygon2.edges(n) != edge && (projectedEdge2 = new ProjectedEdge(polygon2.edges(n))).cross(projectedEdge)) {
                Vertex2D vertex2D = projectedEdge2.cross_point(projectedEdge);
                return new Objects(projectedEdge2, vertex2D);
            }
            ++n;
        }
        System.out.println("error in path finding (Geometry.find_cross_edge())");
        return null;
    }

    public static void sort_polygons() {
        LinkedList linkedList = new LinkedList();
        int n = 0;
        while (n < Geometry.h.n_polygons) {
            Geometry.h.polygons[n].set_distance(camera);
            linkedList.append(Geometry.h.polygons[n]);
            ++n;
        }
        linkedList = Geometry.sort_polygons(linkedList);
        sorted_polygons = new Polygon2[Geometry.h.n_polygons];
        Enumeration enumeration = linkedList.elements();
        int n2 = 0;
        while (n2 < Geometry.h.n_polygons) {
            Geometry.sorted_polygons[n2] = (Polygon2)enumeration.nextElement();
            ++n2;
        }
    }

    private static LinkedList sort_polygons(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        Enumeration enumeration = linkedList.elements();
        if (!enumeration.hasMoreElements()) {
            return new LinkedList();
        }
        Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
        double d = polygon2.distance;
        while (enumeration.hasMoreElements()) {
            Polygon2 polygon22 = (Polygon2)enumeration.nextElement();
            if (polygon22.distance < d) {
                linkedList2.append(polygon22);
                continue;
            }
            linkedList3.append(polygon22);
        }
        linkedList2 = Geometry.sort_polygons(linkedList2);
        linkedList3 = Geometry.sort_polygons(linkedList3);
        linkedList = linkedList2;
        linkedList.append(polygon2);
        linkedList.connect(linkedList3);
        return linkedList;
    }

    public static void init(Polyhedron polyhedron, Vertex vertex) {
        h = polyhedron;
        camera = vertex;
        Geometry.sort_polygons();
    }
}

