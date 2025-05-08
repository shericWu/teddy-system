// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Edge.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;

// Referenced classes of package teddy:
//            Draw3DScene, Vector3, Polygon2, Vertex, 
//            LinkedList

class Edge
    implements Serializable
{

    public Polygon2 left_polygon()
    {
        return left_polygon;
    }

    public boolean contain(Vertex vertex)
    {
        return start == vertex || end == vertex;
    }

    public Vertex end()
    {
        return end;
    }

    public boolean connected(Polygon2 polygon2)
    {
        return polygon2 == left_polygon() || polygon2 == right_polygon();
    }

    public boolean connected(Edge edge)
    {
        return start == edge.start || start == edge.end || end == edge.start || end == edge.end;
    }

    public void set_parameters()
    {
        if(left_polygon() == null && right_polygon() == null)
        {
            System.out.println("Edge has no polygon (Edge:set_parameters())");
            return;
        }
        if(left_polygon() == null || right_polygon() == null)
        {
            System.out.println("Edge doesn't have 2 polygons (Edge:set_parameters())" + start + "," + end);
            if(left_polygon() == null)
            {
                Draw3DScene.current_polygon = right_polygon();
                return;
            } else
            {
                Draw3DScene.current_polygon = left_polygon();
                return;
            }
        } else
        {
            Polygon2 polygon2 = left_polygon();
            Polygon2 polygon2_1 = right_polygon();
            Vector3 vector3_1 = new Vector3(start, end);
            Vector3 vector3_2 = polygon2.normal;
            Vector3 vector3_3 = polygon2_1.normal;
            Vector3 vector3_4 = vector3_2.cross_product(vector3_3);
            concave = vector3_1.cos(vector3_4) < 0.0D;
            return;
        }
    }

    public void set_sharp_if_sharp()
    {
        Vector3 vector3_1 = left_polygon().normal;
        Vector3 vector3_2 = right_polygon().normal;
        if(concave)
        {
            sharp = vector3_1.cos(vector3_2) < 0.69999999999999996D;
            return;
        } else
        {
            sharp = vector3_1.cos(vector3_2) < 0.29999999999999999D;
            return;
        }
    }

    public int visibility_type()
    {
        Polygon2 polygon2 = left_polygon();
        Polygon2 polygon2_1 = right_polygon();
        if(polygon2.front_facing && polygon2_1.front_facing && sharp)
            return type = 3;
        if(polygon2.front_facing == polygon2_1.front_facing)
            return type = 0;
        if(concave)
            return type = 1;
        else
            return type = 2;
    }

    public boolean on_edge(Vertex vertex)
    {
        if(vertex == start || vertex == end)
            return true;
        Vector3 vector3_1 = new Vector3(vertex, start);
        Vector3 vector3_2 = new Vector3(vertex, end);
        return vector3_1.cos(vector3_2) < -0.90000000000000002D;
    }

    public boolean silhouette()
    {
        visibility_type();
        return type == 1 || type == 2;
    }

    public void set_sharp()
    {
        sharp = true;
    }

    public void set_sharp(boolean flag)
    {
        sharp = flag;
    }

    public Vertex start()
    {
        return start;
    }

    public Vertex mid_vertex()
    {
        return new Vertex((((Vector3) (start)).x + ((Vector3) (end)).x) / 2D, (((Vector3) (start)).y + ((Vector3) (end)).y) / 2D, (((Vector3) (start)).z + ((Vector3) (end)).z) / 2D);
    }

    public void renew_network()
    {
        start = start.child;
        end = end.child;
        left_polygon = left_polygon.child;
        right_polygon = right_polygon.child;
    }

    public Polygon2 get_another_polygon(Polygon2 polygon2)
    {
        return get_the_other_polygon(polygon2);
    }

    public Polygon2 get_the_other_polygon(Polygon2 polygon2)
    {
        if(left_polygon() != polygon2)
            return left_polygon();
        else
            return right_polygon();
    }

    public void set_right_polygon(Polygon2 polygon2)
    {
        right_polygon = polygon2;
    }

    public Vector3 vertical_from(Vertex vertex)
    {
        Vertex vertex1 = start();
        Vertex vertex2 = end();
        Vector3 vector3_1 = new Vector3(vertex1, vertex2);
        Vector3 vector3_2 = new Vector3(vertex1, vertex);
        double d = vector3_1.dot_product(vector3_2);
        double d1 = vector3_1.length();
        Vector3 vector3_3 = vector3_1.multiple(d / d1 / d1);
        Vertex vertex3 = vertex1.shift(vector3_3);
        return new Vector3(vertex, vertex3);
    }

    public boolean polygon_is_empty()
    {
        return left_polygon == null && right_polygon == null;
    }

    public double length()
    {
        return vector3().length();
    }

    public boolean same_edge(Vertex vertex, Vertex vertex1)
    {
        return vertex == start && vertex1 == end || vertex1 == start && vertex == end;
    }

    Edge()
    {
        sharp = false;
        checked = false;
        start = new Vertex();
        end = new Vertex();
        left_polygon = null;
        right_polygon = null;
    }

    Edge(Vertex vertex, Vertex vertex1)
    {
        sharp = false;
        checked = false;
        start = vertex;
        end = vertex1;
        if(start == end)
            System.out.println("Edge with same Vertex (Edge.java)");
        start.edges.append(this);
        end.edges.append(this);
        left_polygon = null;
        right_polygon = null;
    }

    public Vertex get_the_other_vertex(Vertex vertex)
    {
        if(vertex == start)
            return end;
        else
            return start;
    }

    public Vertex get_common_vertex(Edge edge)
    {
        if(start == edge.start || start == edge.end)
            return start;
        else
            return end;
    }

    public boolean possible()
    {
        visibility_type();
        return type == 3 || type == 2;
    }

    public Polygon2 right_polygon()
    {
        return right_polygon;
    }

    public void set_left_polygon(Polygon2 polygon2)
    {
        left_polygon = polygon2;
    }

    public void remove_polygon(Polygon2 polygon2)
    {
        if(left_polygon == polygon2)
        {
            left_polygon = null;
            return;
        }
        if(right_polygon == polygon2)
            right_polygon = null;
    }

    public Vector3 vector3()
    {
        return new Vector3(start, end);
    }

    public Edge copy()
    {
        Edge edge = new Edge();
        edge.start = start;
        edge.end = end;
        edge.left_polygon = left_polygon;
        edge.right_polygon = right_polygon;
        edge.sharp = sharp;
        edge.concave = concave;
        child = edge;
        return edge;
    }

    public void print()
    {
        System.out.println("" + this + ":" + start + "," + end + "; " + left_polygon + "," + right_polygon);
    }

    public Vertex start;
    public Vertex end;
    public int index;
    public Polygon2 left_polygon;
    public Polygon2 right_polygon;
    public boolean sharp;
    public boolean concave;
    public int type;
    public boolean checked;
    public transient Edge child;
    static final int NONE = 0;
    static final int BACK_SILHOUETTE = 1;
    static final int FRONT_SILHOUETTE = 2;
    static final int SHARP_FRONT = 3;
}
