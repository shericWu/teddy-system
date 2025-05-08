// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SurfaceLine.java

package teddy;

import java.awt.Point;
import java.awt.Polygon;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Edge, Vertex, Polygon2, LinkedList, 
//            Draw3DScene, Geometry, Objects, Vertex2D, 
//            Teddy, Generate, Vector2, Def, 
//            Polyhedron, Vector3

class SurfaceLine extends Edge
    implements Serializable
{

    SurfaceLine()
    {
        super.start = new Vertex();
        super.end = new Vertex();
        polygon = null;
    }

    SurfaceLine(Vertex vertex, Vertex vertex1, Polygon2 polygon2)
    {
        super.start = vertex;
        super.end = vertex1;
        polygon = polygon2;
        if(polygon != null)
            polygon.surface_lines.append(this);
    }

    SurfaceLine(Vertex2D vertex2d, Vertex2D vertex2d1, Polyhedron polyhedron)
    {
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(polyhedron, vertex);
        Objects objects = Geometry.find_vertex_on_surface(vertex2d, true);
        Objects objects1 = Geometry.find_vertex_on_surface(vertex2d1, true);
        if(objects.get(0) != objects1.get(0))
            System.out.println("surface line, different polygon");
        super.start = (Vertex)objects.get(1);
        super.end = (Vertex)objects1.get(1);
        polygon = (Polygon2)objects.get(0);
    }

    public static boolean generate_surface_lines(LinkedList linkedlist, Polyhedron polyhedron, boolean flag)
    {
        h = polyhedron;
        if(linkedlist.size() == 0)
            return false;
        boolean flag1 = generate_surface_lines_main(linkedlist, true);
        if(flag1)
            return true;
        if(flag)
            generate_surface_lines_main(linkedlist, false);
        return false;
    }

    public static LinkedList get_edge_vertex_list(LinkedList linkedlist, Objects objects, boolean flag)
    {
        LinkedList linkedlist1 = new LinkedList();
        linkedlist1.append(objects);
        Enumeration enumeration = linkedlist.elements();
        Point point1;
        for(Point point = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point = point1)
        {
            point1 = (Point)enumeration.nextElement();
            Vertex2D vertex2d = new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y));
            Vertex2D vertex2d1 = new Vertex2D(Draw3DScene.reverse_convertX(point1.x), Draw3DScene.reverse_convertY(point1.y));
            get_edge_vertex_list_sub(vertex2d, vertex2d1, h, linkedlist1, flag);
        }

        return linkedlist1;
    }

    public static boolean generate_surface_lines_main(LinkedList linkedlist, boolean flag)
    {
        Point point = (Point)linkedlist.head();
        Vertex2D vertex2d = new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y));
        Objects objects = Geometry.find_vertex_on_surface(vertex2d, flag);
        if(objects == null)
            return true;
        Teddy.teddy.play_sound("drip.au");
        boolean flag1 = false;
        double d = Generate.calculate_stroke_length(linkedlist);
        if(d > 40D && Vector2.distance((Point)linkedlist.head(), (Point)linkedlist.tail()) < 20D)
        {
            flag1 = true;
            linkedlist.replace_tail(linkedlist.head());
            linkedlist = Generate.counter_clockwise(linkedlist);
        }
        linkedlist = Generate.normalize_Point_list(linkedlist, Def.NORMALIZED_STROKE_LENGTH_POP);
        LinkedList linkedlist1 = get_edge_vertex_list(linkedlist, objects, flag);
        linkedlist1 = remove_short_edges(linkedlist1);
        if(flag1)
        {
            h.temp_surface_lines.connect(generate_surface_lines_sub(linkedlist1));
            linkedlist1.replace_tail(linkedlist1.head());
            h.temp_edge_vertex_list = linkedlist1;
            h.section_bumping = false;
        } else
        {
            h.surface_lines.connect(generate_surface_lines_sub(linkedlist1));
        }
        return false;
    }

    public static LinkedList generate_surface_lines_sub(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Polygon2 polygon2 = (Polygon2)objects.get(0);
        Vertex vertex1;
        for(Vertex vertex = (Vertex)objects.get(1); enumeration.hasMoreElements(); vertex = vertex1.copy())
        {
            Objects objects1 = (Objects)enumeration.nextElement();
            vertex1 = (Vertex)objects1.get(1);
            linkedlist1.append(new SurfaceLine(vertex, vertex1, polygon2));
            if(objects1.get(0) instanceof Edge)
            {
                Edge edge = (Edge)objects1.get(0);
                polygon2 = edge.get_another_polygon(polygon2);
            }
        }

        return linkedlist1;
    }

    public static void get_edge_vertex_list_sub(Vertex2D vertex2d, Vertex2D vertex2d1, Polyhedron polyhedron, LinkedList linkedlist, boolean flag)
    {
        Objects objects = Geometry.find_vertex_on_surface(vertex2d, flag);
        Objects objects1 = Geometry.find_vertex_on_surface(vertex2d1, flag);
        if(objects == null || objects1 == null)
        {
            System.out.println("failed to find surface");
            return;
        } else
        {
            Vertex vertex = (Vertex)objects.get(1);
            Vertex vertex1 = (Vertex)objects1.get(1);
            Polygon2 polygon2 = (Polygon2)objects.get(0);
            Polygon2 polygon2_1 = (Polygon2)objects1.get(0);
            linkedlist.connect(Geometry.surface_path(vertex2d, vertex2d1, vertex, vertex1, polygon2, polygon2_1));
            linkedlist.append(objects1);
            return;
        }
    }

    public Edge copy()
    {
        Polygon2 polygon2 = polygon.child;
        SurfaceLine surfaceline = new SurfaceLine(super.start.position_copy(), super.end.position_copy(), polygon2);
        polygon2.surface_lines.append(surfaceline);
        return surfaceline;
    }

    private static LinkedList remove_short_edges(LinkedList linkedlist)
    {
        boolean flag = false;
        if(linkedlist.head() == linkedlist.tail())
            flag = true;
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Objects objects1 = objects;
        Objects objects3 = objects;
        linkedlist1.append(objects);
        Vertex vertex = (Vertex)objects.get(1);
        while(enumeration.hasMoreElements()) 
        {
            Objects objects4 = (Objects)enumeration.nextElement();
            Vertex vertex1 = (Vertex)objects4.get(1);
            if(Vector3.distance(vertex, vertex1) > Def.MINIMUM_EDGE_LENGTH || (objects4.get(0) instanceof Edge))
            {
                if((objects.get(0) instanceof Polygon) && Vector3.distance(vertex, vertex1) < Def.MINIMUM_EDGE_LENGTH)
                    linkedlist1.remove(linkedlist1.tail());
                if((objects.get(0) instanceof Edge) && objects.get(0) == objects4.get(0))
                {
                    linkedlist1.append(objects3);
                    System.out.println("inserted");
                }
                linkedlist1.append(objects4);
                Objects objects2 = objects;
                vertex = vertex1;
                objects = objects4;
            }
            objects3 = objects4;
        }
        if(flag)
        {
            if(linkedlist1.head() != linkedlist1.tail())
                linkedlist1.append(linkedlist1.head());
        } else
        {
            if(linkedlist1.head() != linkedlist.head())
            {
                linkedlist1.reset();
                linkedlist1.insert(linkedlist.head());
            }
            if(linkedlist1.tail() != linkedlist.tail())
                linkedlist1.append(linkedlist.tail());
        }
        return linkedlist1;
    }

    public static Teddy teddy;
    public Polygon2 polygon;
    public static Polyhedron h;
}
