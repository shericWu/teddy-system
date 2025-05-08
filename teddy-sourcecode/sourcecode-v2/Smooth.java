// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Smooth.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            Pop, Draw3DScene, Modify, Geometry, 
//            Vector3, Polyhedron, LinkedList, SurfaceLine, 
//            Edge, Vertex, CoordSystem, Objects, 
//            Trianglation2D, Trianglation, Tessellation, Teddy, 
//            Polygon2

class Smooth extends Pop
{

    public static void smooth_main()
    {
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex);
        Vector3 vector3 = new Vector3(0.0D, 0.0D, 0.0D);
        Enumeration enumeration = Modify.h.temp_surface_lines.elements();
        Vector3 vector3_3;
        for(Vector3 vector3_2 = ((SurfaceLine)enumeration.nextElement()).vector3(); enumeration.hasMoreElements(); vector3_2 = vector3_3)
        {
            vector3_3 = ((SurfaceLine)enumeration.nextElement()).vector3();
            Vector3 vector3_1 = vector3_2.cross_product(vector3_3);
            vector3.add_self(vector3_1);
        }

        vector3.normalize();
        Vertex vertex1 = new Vertex(0.0D, 0.0D, 0.0D);
        SurfaceLine surfaceline;
        for(enumeration = Modify.h.temp_surface_lines.elements(); enumeration.hasMoreElements(); vertex1.add_self(((Edge) (surfaceline)).start))
            surfaceline = (SurfaceLine)enumeration.nextElement();

        vertex1.multiple_self(1.0D / (double)Modify.h.temp_surface_lines.size());
        Vector3 vector3_4 = vector3.multiple(-1D);
        Vector3 vector3_5 = vector3_4.cross_product(new Vector3(1.0D, 0.0D, 0.0D));
        vector3_5.normalize_self();
        Vector3 vector3_6 = vector3_4.cross_product(vector3_5);
        CoordSystem coordsystem = new CoordSystem(vector3_5, vector3_6, vector3_4);
        if(!Modify.h.section_bumping)
        {
            Modify.section_is_sharp = false;
            Pop.divide_polygons_loop(Modify.h.temp_edge_vertex_list);
            Modify.delete_temp_polygons();
        } else
        {
            SurfaceLine surfaceline1;
            for(enumeration = Modify.h.temp_surface_lines.elements(); enumeration.hasMoreElements(); Modify.h.remove(surfaceline1.polygon))
                surfaceline1 = (SurfaceLine)enumeration.nextElement();

            Edge edge;
            for(enumeration = Modify.h.temp_edge_vertex_list.elements(); enumeration.hasMoreElements(); edge.set_sharp(false))
                edge = (Edge)((Objects)enumeration.nextElement()).get(0);

        }
        LinkedList linkedlist = new LinkedList();
        enumeration = Modify.h.temp_edge_vertex_list.elements();
        enumeration.nextElement();
        Objects objects;
        for(; enumeration.hasMoreElements(); linkedlist.append((Vertex)objects.get(1)))
            objects = (Objects)enumeration.nextElement();

        Polygon2 polygon2 = Trianglation2D.generate_simple_patch(Modify.h, linkedlist, coordsystem);
        Modify.remove_broken_polygons();
        Modify.h.remove(polygon2);
        Trianglation2D.generate_smooth_patch(Modify.h, linkedlist, coordsystem);
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
        Modify.h.temp_surface_lines = new LinkedList();
    }

    Smooth()
    {
    }

    public static void smooth(Polyhedron polyhedron)
    {
        Teddy.teddy.play_sound("smooth.au");
        Modify.h = polyhedron;
        Modify.h.current_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
        smooth_main();
    }

    private static int old_part_index;
    private static int new_part_index;
}
