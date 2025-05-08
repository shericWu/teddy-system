/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import teddy.CoordSystem;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Geometry;
import teddy.LinkedList;
import teddy.Modify;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.Pop;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Tessellation;
import teddy.Trianglation;
import teddy.Trianglation2D;
import teddy.Vector3;
import teddy.Vertex;

class Smooth
extends Pop {
    private static int old_part_index;
    private static int new_part_index;

    public static void smooth_main() {
        Serializable serializable;
        Serializable serializable2;
        Serializable serializable3;
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex);
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
        Vertex vertex2 = new Vertex(0.0, 0.0, 0.0);
        enumeration = Modify.h.temp_surface_lines.elements();
        while (enumeration.hasMoreElements()) {
            serializable3 = (SurfaceLine)enumeration.nextElement();
            vertex2.add_self(((Edge)serializable3).start);
        }
        vertex2.multiple_self(1.0 / (double)Modify.h.temp_surface_lines.size());
        serializable3 = vector3.multiple(-1.0);
        Vector3 vector35 = ((Vector3)serializable3).cross_product(new Vector3(1.0, 0.0, 0.0));
        vector35.normalize_self();
        Vector3 vector36 = ((Vector3)serializable3).cross_product(vector35);
        CoordSystem coordSystem = new CoordSystem(vector35, vector36, (Vector3)serializable3);
        if (!Modify.h.section_bumping) {
            Modify.section_is_sharp = false;
            Pop.divide_polygons_loop(Modify.h.temp_edge_vertex_list);
            Modify.delete_temp_polygons();
        } else {
            enumeration = Modify.h.temp_surface_lines.elements();
            while (enumeration.hasMoreElements()) {
                serializable2 = (SurfaceLine)enumeration.nextElement();
                Modify.h.remove(((SurfaceLine)serializable2).polygon);
            }
            enumeration = Modify.h.temp_edge_vertex_list.elements();
            while (enumeration.hasMoreElements()) {
                serializable2 = (Edge)((Objects)enumeration.nextElement()).get(0);
                ((Edge)serializable2).set_sharp(false);
            }
        }
        serializable2 = new LinkedList();
        enumeration = Modify.h.temp_edge_vertex_list.elements();
        enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            serializable = (Objects)enumeration.nextElement();
            ((LinkedList)serializable2).append((Vertex)((Objects)serializable).get(1));
        }
        serializable = Trianglation2D.generate_simple_patch(Modify.h, (LinkedList)serializable2, coordSystem);
        Modify.remove_broken_polygons();
        Modify.h.remove((Polygon2)serializable);
        Trianglation2D.generate_smooth_patch(Modify.h, (LinkedList)serializable2, coordSystem);
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
        Modify.h.temp_surface_lines = new LinkedList();
    }

    Smooth() {
    }

    public static void smooth(Polyhedron polyhedron) {
        Teddy.teddy.play_sound("smooth.au");
        Modify.h = polyhedron;
        Modify.h.current_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
        Smooth.smooth_main();
    }
}

