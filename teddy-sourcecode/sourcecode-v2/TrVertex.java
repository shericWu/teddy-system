// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trianglation2D.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Vector;

// Referenced classes of package teddy:
//            Vertex2D, Edge2D, Vector2, TrEdge, 
//            Vector3, Vertex, Edge, CoordSystem, 
//            Surface, Polygon2

class TrVertex extends Vertex2D
{

    public TrEdge find_opposite_edge(TrEdge tredge, Vector vector)
    {
        Vertex2D vertex2d = tredge.mid_point();
        Vector2 vector2 = new Vector2(vertex2d, this);
        for(int i = 0; i < vector.size(); i++)
        {
            TrEdge tredge1 = (TrEdge)vector.elementAt(i);
            Vector2 vector2_1 = new Vector2(vertex2d, ((Edge2D) (tredge1)).start);
            Vector2 vector2_2 = new Vector2(vertex2d, ((Edge2D) (tredge1)).end);
            if(tredge1 != tredge && vector2.dot_product(vector2_2) > 0.0D && vector2_1.cross_product(vector2_2) < 0.0D && vector2.cross_product(vector2_1) * vector2.cross_product(vector2_2) <= 0.0D && vector2.length() < vector2_1.length())
                return tredge1;
        }

        System.out.println("Error in Trianglation2D.find_opposite_edge");
        return null;
    }

    TrVertex(Point point, boolean flag)
    {
        edges = new Vector();
        external = false;
        original = null;
        super.x = point.x;
        super.y = point.y;
        external = flag;
    }

    TrVertex(Vertex vertex, boolean flag, Vertex vertex1)
    {
        edges = new Vector();
        external = false;
        original = null;
        original = vertex1;
        super.x = ((Vector3) (vertex)).x;
        super.y = ((Vector3) (vertex)).y;
        height = ((Vector3) (vertex)).z;
        external = flag;
    }

    TrVertex(Vertex2D vertex2d)
    {
        edges = new Vector();
        external = false;
        original = null;
        super.x = ((Vector2) (vertex2d)).x;
        super.y = ((Vector2) (vertex2d)).y;
    }

    public void destroy()
    {
    }

    public void set_height(Vector vector)
    {
        height = 0.0D;
        double d = 0.0D;
        for(int i = 0; i < vector.size(); i++)
        {
            TrVertex trvertex = (TrVertex)vector.elementAt(i);
            double d1 = Vector2.distance(this, trvertex);
            height += d1 * trvertex.height;
            d += d1;
        }

        height /= d;
    }

    public boolean edge_is_clockwise(TrEdge tredge)
    {
        Vector2 vector2 = new Vector2(this, ((Edge2D) (tredge)).start);
        Vector2 vector2_1 = new Vector2(this, ((Edge2D) (tredge)).end);
        return vector2.cross_product(vector2_1) < 0.0D;
    }

    public void set_height_slope(Vector vector, CoordSystem coordsystem)
    {
        Vector vector1 = new Vector();
        for(int i = 0; i < vector.size(); i++)
        {
            TrVertex trvertex = (TrVertex)vector.elementAt(i);
            TrVertex trvertex1;
            if(i < vector.size() - 1)
                trvertex1 = (TrVertex)vector.elementAt(i + 1);
            else
                trvertex1 = (TrVertex)vector.elementAt(0);
            TrEdge tredge = trvertex.shared_edge(trvertex1);
            tredge.original = trvertex.original.get_shared_edge(trvertex1.original);
            vector1.addElement(tredge);
        }

        height = 0.0D;
        double d = 0.0D;
        for(int j = 0; j < vector1.size(); j++)
        {
            TrEdge tredge1 = (TrEdge)vector1.elementAt(j);
            if(edge_is_clockwise(tredge1))
            {
                double d1 = set_height_slope_sub(tredge1, vector1, coordsystem);
                double d2 = 1.0D / Vector2.distance(tredge1.mid_point(), this);
                if(d1 != 0.0D)
                {
                    d2 *= d2;
                    height += d1 * d2;
                    d += d2;
                }
            }
        }

        height /= d;
    }

    public TrEdge shared_edge(TrVertex trvertex)
    {
        for(int i = 0; i < edges.size(); i++)
        {
            TrEdge tredge = (TrEdge)edges.elementAt(i);
            if(tredge.contains(trvertex))
                return tredge;
        }

        return null;
    }

    public void remove_edge(TrEdge tredge)
    {
        edges.removeElement(tredge);
        if(edges.size() != 0);
        destroy();
    }

    public double set_height_slope_sub(TrEdge tredge, Vector vector, CoordSystem coordsystem)
    {
        Edge edge = tredge.original;
        Vertex vertex = edge.mid_vertex();
        TrEdge tredge1 = find_opposite_edge(tredge, vector);
        if(tredge1 == null)
            return 0.0D;
        Edge edge1 = tredge1.original;
        double d = ((Vector3) (coordsystem.translate(vertex))).z;
        original = coordsystem.reverse_translate(super.x, super.y, d);
        Vector3 vector3 = coordsystem.base_z.cross_product(new Vector3(vertex, original));
        Surface surface = new Surface(vertex, vector3);
        Vertex vertex1 = surface.cross_point(edge1);
        Vector3 vector3_1;
        if(edge.left_polygon != null)
            vector3_1 = edge.vector3().cross_product(edge.left_polygon.calc_normal());
        else
            vector3_1 = edge.vector3().reverse().cross_product(edge.right_polygon.calc_normal());
        vector3_1.normalize();
        Vector3 vector3_2;
        if(edge1.left_polygon != null)
            vector3_2 = edge1.vector3().cross_product(edge1.left_polygon.calc_normal());
        else
            vector3_2 = edge1.vector3().reverse().cross_product(edge1.right_polygon.calc_normal());
        vector3_2.normalize();
        Vector3 vector3_3 = coordsystem.base_z;
        Vector3 vector3_4 = new Vector3(vertex, vertex1);
        Vector3 vector3_5 = vector3_4.cross_product(vector3_3).get_normalized();
        vector3_4 = vector3_3.cross_product(vector3_5).get_normalized();
        CoordSystem coordsystem1 = new CoordSystem(vector3_4, vector3_3, vector3_5);
        Vertex vertex2 = coordsystem1.translate(original);
        Vertex vertex3 = coordsystem1.translate(vertex);
        Vertex vertex4 = coordsystem1.translate(vertex1);
        Vector2 vector2 = new Vector2(coordsystem1.translate(vector3_1));
        Vector2 vector2_1 = new Vector2(coordsystem1.translate(vector3_2));
        double d1 = Vector2.distance(((Vector3) (vertex3)).x, ((Vector3) (vertex3)).y, ((Vector3) (vertex4)).x, ((Vector3) (vertex4)).y);
        vector2 = vector2.get_normalized().multiple(d1 * 1.5D);
        vector2_1 = vector2_1.get_normalized().multiple(d1);
        double d2 = ((2D * ((Vector3) (vertex3)).x - 2D * ((Vector3) (vertex4)).x) + vector2.x) - vector2_1.x;
        double d3 = ((-3D * ((Vector3) (vertex3)).x + 3D * ((Vector3) (vertex4)).x) - 2D * vector2.x) + vector2_1.x;
        double d4 = vector2.x;
        double d5 = ((Vector3) (vertex3)).x;
        double d6 = ((2D * ((Vector3) (vertex3)).y - 2D * ((Vector3) (vertex4)).y) + vector2.y) - vector2_1.y;
        double d7 = ((-3D * ((Vector3) (vertex3)).y + 3D * ((Vector3) (vertex4)).y) - 2D * vector2.y) + vector2_1.y;
        double d8 = vector2.y;
        double d9 = ((Vector3) (vertex3)).y;
        double d10 = (((Vector3) (vertex2)).x - ((Vector3) (vertex3)).x) / (((Vector3) (vertex4)).x - ((Vector3) (vertex3)).x);
        if(d10 < 0.0D || d10 > 1.0D)
        {
            System.out.println("Strange t (Trianglation2D.set_height_slope_sub())" + d10);
            d10 = 0.5D;
        }
        double d11 = d6 * d10 * d10 * d10 + d7 * d10 * d10 + d8 * d10 + d9;
        return d11;
    }

    public Vector edges;
    public boolean external;
    public Vertex original;
    public double height;
}
