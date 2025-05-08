// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trianglation2D.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            TrEdge, Edge2D, TrVertex, Triangle, 
//            Geometry2D, LinkedList, Generate, Queue, 
//            Scene, Vertex, Polygon2, Polyhedron, 
//            Vertex2D, Vector2, CoordSystem, ReTessellation

class Trianglation2D
{

    private static void check_flip(TrEdge tredge)
    {
        if(tredge.left_triangle == null || tredge.right_triangle == null)
            return;
        TrVertex trvertex = (TrVertex)((Edge2D) (tredge)).start;
        TrVertex trvertex1 = (TrVertex)((Edge2D) (tredge)).end;
        TrVertex trvertex2 = tredge.left_triangle.get_opposite_vertex(tredge);
        TrVertex trvertex3 = tredge.right_triangle.get_opposite_vertex(tredge);
        if(Geometry2D.left_side(trvertex2, trvertex, trvertex3) && cos(trvertex, trvertex1, trvertex2) > cos(trvertex, trvertex3, trvertex2))
        {
            tredge.left_triangle.destroy();
            tredge.right_triangle.destroy();
            triangles.addElement(new Triangle(trvertex, trvertex3, trvertex2));
            triangles.addElement(new Triangle(trvertex1, trvertex2, trvertex3));
            check_flip(trvertex.shared_edge(trvertex2));
            check_flip(trvertex.shared_edge(trvertex3));
            check_flip(trvertex1.shared_edge(trvertex2));
            check_flip(trvertex1.shared_edge(trvertex3));
            check_encroached(trvertex2.shared_edge(trvertex3));
        }
    }

    public static void trianglate_from_stroke(LinkedList linkedlist)
    {
        linkedlist.append(linkedlist.head());
        linkedlist = Generate.normalize_Point_list(linkedlist, (int)MIN_EDGE_LENGTH);
        linkedlist.remove(linkedlist.head());
        vertices = new Vector();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); vertices.addElement(new TrVertex((Point)enumeration.nextElement(), true)));
        trianglate();
    }

    public static void trianglate()
    {
        edges = new Vector();
        triangles = new Vector();
        for(int i = 0; i < vertices.size() - 1; i++)
        {
            TrVertex trvertex = (TrVertex)vertices.elementAt(i);
            TrVertex trvertex1 = (TrVertex)vertices.elementAt(i + 1);
            edges.addElement(new TrEdge(trvertex, trvertex1, true));
        }

        edges.addElement(new TrEdge((TrVertex)vertices.elementAt(vertices.size() - 1), (TrVertex)vertices.elementAt(0), true));
        constraint_delauny_trianglate(vertices);
        queue_of_segments = new Queue();
        queue_of_triangles = new Queue();
        for(int j = 0; j < edges.size(); j++)
            check_encroached((TrEdge)edges.elementAt(j));

        int k = 0;
        while(queue_of_segments.size() > 0) 
        {
            TrEdge tredge = (TrEdge)queue_of_segments.pop();
            if(!tredge.destroyed)
                divide_edge(tredge);
            if(++k > 500)
                break;
        }
    }

    public static Scene rearrange_scene()
    {
        Scene scene = new Scene();
        rearrange();
        TrEdge tredge;
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements(); Generate.add_segment(scene, ((Edge2D) (tredge)).start, ((Edge2D) (tredge)).end))
            tredge = (TrEdge)enumeration.nextElement();

        return scene;
    }

    private static void check_encroached(TrEdge tredge)
    {
        if(encroached(tredge))
            queue_of_segments.push(tredge);
    }

    Trianglation2D()
    {
    }

    public static Polygon2 generate_simple_patch(Polyhedron polyhedron, LinkedList linkedlist, CoordSystem coordsystem)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex vertex = (Vertex)enumeration.nextElement();
        Vertex vertex1 = vertex;
        while(enumeration.hasMoreElements()) 
        {
            Vertex vertex2 = (Vertex)enumeration.nextElement();
            linkedlist1.append(vertex.get_shared_edge(vertex2));
            if(vertex.same_position(vertex2))
                System.out.println("T2D.generate_smooth_patch() overlapping vertex");
            vertex = vertex2;
        }
        linkedlist1.append(vertex.get_shared_edge(vertex1));
        Polygon2 polygon2 = new Polygon2(linkedlist1);
        polyhedron.append(polygon2);
        return polygon2;
    }

    public static void rearrange()
    {
        Vertex2D avertex2d[] = new Vertex2D[vertices.size()];
        for(int i = 0; i < vertices.size(); i++)
        {
            TrVertex trvertex = (TrVertex)vertices.elementAt(i);
            if(!trvertex.external)
            {
                Vertex2D vertex2d = get_center(trvertex);
                Vector2 vector2 = new Vector2(trvertex, vertex2d);
                avertex2d[i] = trvertex.translate(vector2.multiple(0.5D));
            } else
            {
                avertex2d[i] = trvertex;
            }
        }

        for(int j = 0; j < vertices.size(); j++)
        {
            TrVertex trvertex1 = (TrVertex)vertices.elementAt(j);
            trvertex1.warp(avertex2d[j]);
        }

    }

    public static void generate_smooth_patch(Polyhedron polyhedron, LinkedList linkedlist, CoordSystem coordsystem)
    {
        vertices = new Vector();
        Vector vector = new Vector();
        TrVertex trvertex;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); vector.addElement(trvertex))
        {
            Vertex vertex = (Vertex)enumeration.nextElement();
            Vertex vertex1 = coordsystem.translate(vertex);
            trvertex = new TrVertex(vertex1, true, vertex);
            vertices.addElement(trvertex);
        }

        double d = 0.0D;
        Enumeration enumeration1 = vector.elements();
        TrVertex trvertex1 = (TrVertex)enumeration1.nextElement();
        TrVertex trvertex2 = trvertex1;
        while(enumeration1.hasMoreElements()) 
        {
            TrVertex trvertex3 = (TrVertex)enumeration1.nextElement();
            d += Vector2.distance(trvertex1, trvertex3);
            trvertex1 = trvertex3;
        }
        d += Vector2.distance(trvertex1, trvertex2);
        MIN_EDGE_LENGTH = (d / (double)linkedlist.size()) * 2D;
        trianglate();
        int i = 0;
        do
            rearrange();
        while(++i < 5);
        for(Enumeration enumeration2 = vertices.elements(); enumeration2.hasMoreElements();)
        {
            TrVertex trvertex4 = (TrVertex)enumeration2.nextElement();
            if(!trvertex4.external)
            {
                trvertex4.set_height_slope(vector, coordsystem);
                trvertex4.original = coordsystem.reverse_translate(((Vector2) (trvertex4)).x, ((Vector2) (trvertex4)).y, trvertex4.height);
                polyhedron.append(trvertex4.original);
            }
        }

        for(Enumeration enumeration3 = edges.elements(); enumeration3.hasMoreElements();)
        {
            TrEdge tredge = (TrEdge)enumeration3.nextElement();
            Vertex vertex2 = ((TrVertex)((Edge2D) (tredge)).start).original;
            Vertex vertex3 = ((TrVertex)((Edge2D) (tredge)).end).original;
            tredge.original = polyhedron.get_edge_array(vertex2, vertex3);
        }

        Vector vector1 = new Vector();
        for(int j = 0; j < vertices.size(); j++)
        {
            TrVertex trvertex5 = (TrVertex)vertices.elementAt(j);
            vector1.addElement(trvertex5.original);
        }

        ReTessellation.smooth(vector1);
        Triangle triangle;
        for(Enumeration enumeration4 = triangles.elements(); enumeration4.hasMoreElements(); polyhedron.append(new Polygon2(triangle.original_edges())))
            triangle = (Triangle)enumeration4.nextElement();

    }

    private static void divide_edge(TrEdge tredge)
    {
        TrVertex trvertex = new TrVertex(tredge.mid_point());
        vertices.addElement(trvertex);
        if(tredge.external)
            trvertex.external = true;
        TrVertex trvertex1 = (TrVertex)((Edge2D) (tredge)).start;
        TrVertex trvertex2 = (TrVertex)((Edge2D) (tredge)).end;
        divide_edge_sub(tredge, trvertex, tredge.left_triangle, trvertex1, trvertex2);
        divide_edge_sub(tredge, trvertex, tredge.right_triangle, trvertex2, trvertex1);
        check_encroached(trvertex.shared_edge(trvertex1));
        check_encroached(trvertex.shared_edge(trvertex2));
    }

    public static Scene generate_scene(LinkedList linkedlist)
    {
        Scene scene = new Scene();
        trianglate_from_stroke(linkedlist);
        TrEdge tredge;
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements(); Generate.add_segment(scene, ((Edge2D) (tredge)).start, ((Edge2D) (tredge)).end))
            tredge = (TrEdge)enumeration.nextElement();

        return scene;
    }

    private static boolean encroached(TrEdge tredge)
    {
        return !tredge.external && tredge.length() >= MIN_EDGE_LENGTH * 1.8D;
    }

    private static boolean encroached_sub(TrEdge tredge, Triangle triangle)
    {
        if(triangle == null)
            return false;
        TrVertex trvertex = triangle.get_opposite_vertex(tredge);
        return (new Vector2(trvertex, ((Edge2D) (tredge)).start)).cos(new Vector2(trvertex, ((Edge2D) (tredge)).end)) < 0.0D;
    }

    public static void constraint_delauny_trianglate(Vector vector)
    {
        if(vector.size() == 3)
        {
            triangles.addElement(new Triangle((TrVertex)vector.elementAt(0), (TrVertex)vector.elementAt(1), (TrVertex)vector.elementAt(2)));
            return;
        }
        int i = vector.size();
        TrVertex trvertex = (TrVertex)vector.elementAt(0);
        TrVertex trvertex1 = (TrVertex)vector.elementAt(1);
        double d = 2D;
        TrVertex trvertex2 = null;
        int j = -100;
        for(int k = 2; k < i; k++)
        {
            TrVertex trvertex3 = (TrVertex)vector.elementAt(k);
            if(Geometry2D.left_side(trvertex, trvertex1, trvertex3))
            {
                double d1 = (new Vector2(trvertex3, trvertex)).get_cos(new Vector2(trvertex3, trvertex1));
                if(d1 < d)
                {
                    d = d1;
                    trvertex2 = trvertex3;
                    j = k;
                }
            }
        }

        if(trvertex2 == null)
            System.out.println("Trianglation2D.constraint_delauny_trianglation(), closest_v == null");
        triangles.addElement(new Triangle(trvertex, trvertex1, trvertex2));
        if(j > 2)
        {
            Vector vector1 = new Vector();
            for(int l = 1; l <= j; l++)
                vector1.addElement(vector.elementAt(l));

            constraint_delauny_trianglate(vector1);
        }
        if(j < i - 1)
        {
            Vector vector2 = new Vector();
            vector2.addElement(vector.elementAt(0));
            for(int i1 = j; i1 <= i - 1; i1++)
                vector2.addElement(vector.elementAt(i1));

            constraint_delauny_trianglate(vector2);
        }
    }

    public static void rearrange3D()
    {
        Vertex avertex[] = new Vertex[vertices.size()];
        for(int i = 0; i < vertices.size(); i++)
        {
            TrVertex trvertex = (TrVertex)vertices.elementAt(i);
            Vertex vertex = trvertex.original;
            if(!trvertex.external)
            {
                LinkedList linkedlist = vertex.get_sorrounding_vertices();
                avertex[i] = ReTessellation.to_the_center(linkedlist, vertex, 0.5D);
            } else
            {
                avertex[i] = vertex;
            }
        }

        for(int j = 0; j < vertices.size(); j++)
        {
            TrVertex trvertex1 = (TrVertex)vertices.elementAt(j);
            trvertex1.original.warp(avertex[j]);
        }

    }

    public static Vertex2D get_center(TrVertex trvertex)
    {
        Vertex2D vertex2d = new Vertex2D(0.0D, 0.0D);
        for(int i = 0; i < trvertex.edges.size(); i++)
        {
            TrEdge tredge = (TrEdge)trvertex.edges.elementAt(i);
            vertex2d.add_self(tredge.get_the_other_vertex(trvertex));
        }

        return new Vertex2D(vertex2d.multiple(1.0D / (double)trvertex.edges.size()));
    }

    private static void divide_edge_sub(TrEdge tredge, TrVertex trvertex, Triangle triangle, TrVertex trvertex1, TrVertex trvertex2)
    {
        if(triangle == null)
        {
            return;
        } else
        {
            TrVertex trvertex3 = triangle.get_opposite_vertex(tredge);
            triangle.destroy();
            triangles.addElement(new Triangle(trvertex1, trvertex, trvertex3));
            triangles.addElement(new Triangle(trvertex, trvertex2, trvertex3));
            check_flip(trvertex3.shared_edge(trvertex1));
            check_flip(trvertex3.shared_edge(trvertex2));
            check_encroached(trvertex.shared_edge(trvertex3));
            return;
        }
    }

    private static double cos(Vertex2D vertex2d, Vertex2D vertex2d1, Vertex2D vertex2d2)
    {
        return (new Vector2(vertex2d1, vertex2d)).cos(new Vector2(vertex2d1, vertex2d2));
    }

    public static Vector vertices;
    public static Vector edges;
    public static Vector triangles;
    public static Queue queue_of_segments;
    public static Queue queue_of_triangles;
    private static double MIN_EDGE_LENGTH = 40D;

}
