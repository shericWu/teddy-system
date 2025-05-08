// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Geometry.java

package teddy;

import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Draw3DScene, Edge, Polygon2, Vector3, 
//            Polyhedron, Objects, LinkedList, ProjectedEdge, 
//            Surface, Vertex2D, Vertex

class Geometry
{

    private static Vertex cross_point(Polygon2 polygon2, Vertex2D vertex2d)
    {
        Vertex vertex = Draw3DScene.image_plane_to_world_coords(vertex2d);
        Edge edge = new Edge(camera, vertex);
        return polygon2.cross_point(edge);
    }

    Geometry()
    {
    }

    public static Objects find_vertex_on_surface(Vertex2D vertex2d, boolean flag)
    {
        Vertex vertex = null;
        Polygon2 polygon2 = null;
        double d = -1D;
        Object obj = null;
        Object obj1 = null;
        for(int i = 0; i < h.n_polygons; i++)
        {
            Polygon2 polygon2_1 = sorted_polygons[i];
            if(polygon2_1.front_facing != flag || !on_surface(polygon2_1, vertex2d))
                continue;
            Vertex vertex1 = cross_point(polygon2_1, vertex2d);
            double d1 = Vector3.distance(camera, vertex1);
            d = d1;
            vertex = vertex1;
            polygon2 = polygon2_1;
            break;
        }

        if(d != -1D)
            return new Objects(polygon2, vertex);
        else
            return null;
    }

    public static LinkedList surface_path(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex vertex, Vertex vertex1, Polygon2 polygon2, Polygon2 polygon2_1)
    {
        LinkedList linkedlist = new LinkedList();
        if(polygon2 == polygon2_1)
            return linkedlist;
        ProjectedEdge projectededge = new ProjectedEdge(vertex2d, vertex2d1);
        Polygon2 polygon2_2 = polygon2;
        Vertex vertex2 = vertex;
        ProjectedEdge projectededge1 = projectededge;
        Surface surface = new Surface(camera, Draw3DScene.image_plane_to_world_coords(vertex2d), Draw3DScene.image_plane_to_world_coords(vertex2d1));
        while(polygon2_2 != polygon2_1) 
        {
            Objects objects = find_cross_edge(polygon2_2, projectededge, projectededge1.original);
            ProjectedEdge projectededge2 = (ProjectedEdge)objects.get(0);
            Vertex2D vertex2d2 = (Vertex2D)objects.get(1);
            Vertex vertex4 = surface.cross_point(projectededge2.original);
            linkedlist.append(new Objects(projectededge2.original, vertex4));
            polygon2_2 = projectededge2.original.get_another_polygon(polygon2_2);
            Vertex vertex3 = vertex4.copy();
            projectededge1 = projectededge2;
        }
        return linkedlist;
    }

    public static boolean on_surface(Polygon2 polygon2, Vertex2D vertex2d)
    {
        for(int i = 0; i < polygon2.n_edges; i++)
            if(!(new ProjectedEdge(polygon2.edges(i))).in(polygon2, vertex2d))
                return false;

        return true;
    }

    private static Objects find_cross_edge(Polygon2 polygon2, ProjectedEdge projectededge, Edge edge)
    {
        for(int i = 0; i < polygon2.n_edges; i++)
            if(polygon2.edges(i) != edge)
            {
                ProjectedEdge projectededge1 = new ProjectedEdge(polygon2.edges(i));
                if(projectededge1.cross(projectededge))
                {
                    Vertex2D vertex2d = projectededge1.cross_point(projectededge);
                    return new Objects(projectededge1, vertex2d);
                }
            }

        System.out.println("error in path finding (Geometry.find_cross_edge())");
        return null;
    }

    public static void sort_polygons()
    {
        LinkedList linkedlist = new LinkedList();
        for(int i = 0; i < h.n_polygons; i++)
        {
            h.polygons[i].set_distance(camera);
            linkedlist.append(h.polygons[i]);
        }

        linkedlist = sort_polygons(linkedlist);
        sorted_polygons = new Polygon2[h.n_polygons];
        Enumeration enumeration = linkedlist.elements();
        for(int j = 0; j < h.n_polygons; j++)
            sorted_polygons[j] = (Polygon2)enumeration.nextElement();

    }

    private static LinkedList sort_polygons(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        LinkedList linkedlist2 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        if(!enumeration.hasMoreElements())
            return new LinkedList();
        Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
        double d = polygon2.distance;
        while(enumeration.hasMoreElements()) 
        {
            Polygon2 polygon2_1 = (Polygon2)enumeration.nextElement();
            if(polygon2_1.distance < d)
                linkedlist1.append(polygon2_1);
            else
                linkedlist2.append(polygon2_1);
        }
        linkedlist1 = sort_polygons(linkedlist1);
        linkedlist2 = sort_polygons(linkedlist2);
        linkedlist = linkedlist1;
        linkedlist.append(polygon2);
        linkedlist.connect(linkedlist2);
        return linkedlist;
    }

    public static void init(Polyhedron polyhedron, Vertex vertex)
    {
        h = polyhedron;
        camera = vertex;
        sort_polygons();
    }

    public static Polyhedron h;
    public static Vertex camera;
    public static Polygon2 sorted_polygons[];
}
