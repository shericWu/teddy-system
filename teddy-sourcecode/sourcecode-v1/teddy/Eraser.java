/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Point;
import java.util.Enumeration;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Modify;
import teddy.Polyhedron;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Vector2;
import teddy.Vertex;

class Eraser
extends Modify {
    private static boolean enclosed(LinkedList linkedList, Vertex vertex) {
        Point point = Draw3DScene.project(vertex);
        Enumeration enumeration = linkedList.elements();
        Point point2 = (Point)enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            Point point3 = (Point)enumeration.nextElement();
            Vector2 vector2 = new Vector2(point2, point3);
            Vector2 vector22 = new Vector2(point2, point);
            if (vector2.cross_product(vector22) > 0.0) {
                return false;
            }
            point2 = point3;
        }
        return true;
    }

    Eraser() {
    }

    public static void erase(LinkedList linkedList, Polyhedron polyhedron) {
        Teddy.teddy.play_sound("smooth.au");
        Modify.init(polyhedron);
        LinkedList linkedList2 = new LinkedList();
        Enumeration enumeration = Modify.h.surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            SurfaceLine surfaceLine = (SurfaceLine)enumeration.nextElement();
            if (Eraser.enclosed(linkedList, surfaceLine.start)) continue;
            linkedList2.append(surfaceLine);
        }
        Modify.h.surface_lines = linkedList2;
        int n = 0;
        while (n < Modify.h.n_edges) {
            Edge edge = Modify.h.edges[n];
            if (edge.sharp && (edge.left_polygon.front_facing || edge.right_polygon.front_facing) && Eraser.enclosed(linkedList, edge.start) && Eraser.enclosed(linkedList, edge.end)) {
                edge.sharp = false;
            }
            ++n;
        }
    }
}

