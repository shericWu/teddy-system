// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trianglation.java

package teddy;


// Referenced classes of package teddy:
//            Polyhedron, Polygon2, Vector3, Edge, 
//            LinkedList, Vertex

class Trianglation
{

    public static void trianglate(Polyhedron polyhedron)
    {
        h = polyhedron;
        for(int i = 0; i < h.n_polygons; i++)
            while(h.polygons[i].n_edges > 3) 
                trianglate(h, h.polygons[i]);

        h.set_parameters();
    }

    public static void trianglate(Polyhedron polyhedron, Polygon2 polygon2)
    {
        if(polygon2.n_edges == 3)
            return;
        h = polyhedron;
        normal = polygon2.calc_normal();
        int i = polygon2.n_edges;
        Vertex vertex = polygon2.get_vertex(0);
        Vertex vertex1 = polygon2.get_vertex(1);
        double d = 2D;
        Vertex vertex2 = null;
        int j = -100;
        for(int k = 2; k < i; k++)
        {
            Vertex vertex3 = polygon2.get_vertex(k);
            if(left_side(vertex, vertex1, vertex3))
            {
                double d1 = (new Vector3(vertex3, vertex)).get_cos(new Vector3(vertex3, vertex1));
                if(d1 < d)
                {
                    d = d1;
                    vertex2 = vertex3;
                    j = k;
                }
            }
        }

        h.remove(polygon2);
        Polygon2 polygon2_1 = null;
        Polygon2 polygon2_2 = null;
        Edge edge1;
        if(j > 2)
        {
            edge1 = new Edge(vertex1, vertex2);
            h.append(edge1);
            LinkedList linkedlist = new LinkedList();
            for(int l = 1; l < j; l++)
                linkedlist.append(polygon2.edges(l));

            linkedlist.append(edge1);
            polygon2_2 = new Polygon2(linkedlist);
            h.append(polygon2_2);
        } else
        {
            edge1 = vertex1.get_shared_edge(vertex2);
        }
        Edge edge;
        if(j < i - 1)
        {
            edge = new Edge(vertex, vertex2);
            h.append(edge);
            LinkedList linkedlist1 = new LinkedList();
            for(int i1 = j; i1 < i; i1++)
                linkedlist1.append(polygon2.edges(i1));

            linkedlist1.append(edge);
            polygon2_1 = new Polygon2(linkedlist1);
            h.append(polygon2_1);
        } else
        {
            edge = vertex.get_shared_edge(vertex2);
        }
        h.append(new Polygon2(polygon2.edges(0), edge1, edge));
        if(polygon2_2 != null)
            trianglate(h, polygon2_2);
        if(polygon2_1 != null)
            trianglate(h, polygon2_1);
    }

    public static boolean left_side(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        if(vertex == vertex2 || vertex1 == vertex2)
            return true;
        Vector3 vector3 = new Vector3(vertex, vertex1);
        Vector3 vector3_1 = new Vector3(vertex, vertex2);
        return vector3.cross_product(vector3_1).dot_product(normal) >= 0.0D;
    }

    Trianglation()
    {
    }

    private static Polyhedron h;
    public static LinkedList triangles;
    public static LinkedList edges;
    public static Vector3 normal;
}
