// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SilhouetteFind.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            Edge2D, Vector2, ProjectedVertex, Edge, 
//            Vertex, Vector3, Polygon2, LinkedList, 
//            Vertex2D

class ProjectedEdge extends Edge2D
{

    public double bottom()
    {
        return Math.max(((Vector2) (start)).y, ((Vector2) (end)).y);
    }

    public Vertex2D cross_point(ProjectedEdge projectededge)
    {
        return cross_point(((Vector2) (start)).x, ((Vector2) (start)).y, ((Vector2) (end)).x, ((Vector2) (end)).y, ((Vector2) (projectededge.start)).x, ((Vector2) (projectededge.start)).y, ((Vector2) (projectededge.end)).x, ((Vector2) (projectededge.end)).y);
    }

    public boolean connected(ProjectedEdge projectededge)
    {
        return start == projectededge.start || start == projectededge.end || end == projectededge.start || end == projectededge.end;
    }

    ProjectedEdge(Edge edge)
    {
        start = new ProjectedVertex(edge.start());
        end = new ProjectedVertex(edge.end());
        QI = -1;
        original = edge;
        type = edge.type;
    }

    ProjectedEdge(Vertex2D vertex2d, Vertex2D vertex2d1)
    {
        start = new ProjectedVertex(vertex2d);
        end = new ProjectedVertex(vertex2d1);
        original = null;
    }

    public boolean cross_behind(ProjectedEdge projectededge, Vertex vertex)
    {
        if(connected(projectededge))
            return false;
        if(!cross(projectededge))
            return false;
        Vertex2D vertex2d = cross_point(projectededge);
        if(vertex2d == null)
            return false;
        Vertex vertex1 = new Vertex(((Vector2) (vertex2d)).x, 0.0D, ((Vector2) (vertex2d)).y);
        Vector3 vector3 = new Vector3(vertex, original.start());
        Vector3 vector3_1 = original.vector3();
        Vector3 vector3_2 = new Vector3(vertex, vertex1);
        double d = vector3.cross_product(vector3_1).length() / vector3_2.cross_product(vector3_1).length();
        vector3 = new Vector3(vertex, projectededge.original.start());
        vector3_1 = projectededge.original.vector3();
        double d1 = vector3.cross_product(vector3_1).length() / vector3_2.cross_product(vector3_1).length();
        return d > d1;
    }

    public boolean in(Vertex2D vertex2d)
    {
        Polygon2 polygon2 = original.left_polygon();
        boolean flag = right_side_of_edge(((Vector2) (start)).x, ((Vector2) (start)).y, ((Vector2) (end)).x, ((Vector2) (end)).y, ((Vector2) (vertex2d)).x, ((Vector2) (vertex2d)).y);
        if(polygon2.front_facing)
            return !flag;
        else
            return flag;
    }

    public boolean in(Polygon2 polygon2, Vertex2D vertex2d)
    {
        Polygon2 polygon2_1 = original.left_polygon();
        boolean flag = right_side_of_edge(((Vector2) (start)).x, ((Vector2) (start)).y, ((Vector2) (end)).x, ((Vector2) (end)).y, ((Vector2) (vertex2d)).x, ((Vector2) (vertex2d)).y);
        if(!polygon2.front_facing)
            flag = !flag;
        if(polygon2 == polygon2_1)
            return !flag;
        else
            return flag;
    }

    public double top()
    {
        return Math.min(((Vector2) (start)).y, ((Vector2) (end)).y);
    }

    public ProjectedVertex bottom_vertex()
    {
        if(((Vector2) (start)).y > ((Vector2) (end)).y)
            return start;
        else
            return end;
    }

    private boolean covered_sub(Vertex vertex, Polygon2 polygon2)
    {
        if(!polygon2.front_facing)
            return false;
        if(original.connected(polygon2))
            return false;
        Vector3 vector3 = original.vector3();
        if(original.end == vertex)
            vector3 = vector3.reverse();
        if(polygon2.absolute_normal().dot_product(vector3) >= 0.0D)
            return false;
        int i = polygon2.get_vertex_index(vertex);
        Vertex vertex1 = polygon2.get_vertex(i - 1);
        Vertex vertex2 = polygon2.get_vertex(i + 1);
        Vertex vertex3 = original.get_the_other_vertex(vertex);
        ProjectedVertex projectedvertex = new ProjectedVertex(vertex1);
        ProjectedVertex projectedvertex1 = new ProjectedVertex(vertex2);
        ProjectedVertex projectedvertex2 = new ProjectedVertex(vertex);
        ProjectedVertex projectedvertex3 = new ProjectedVertex(vertex3);
        Vector2 vector2 = new Vector2(projectedvertex2, projectedvertex);
        Vector2 vector2_1 = new Vector2(projectedvertex2, projectedvertex1);
        Vector2 vector2_2 = new Vector2(projectedvertex2, projectedvertex3);
        double d = 360D - vector2.get_angle(vector2_1);
        double d1 = 360D - vector2.get_angle(vector2_2);
        return d1 < d;
    }

    public double left()
    {
        return Math.min(((Vector2) (start)).x, ((Vector2) (end)).x);
    }

    public ProjectedVertex left_vertex()
    {
        if(((Vector2) (start)).x < ((Vector2) (end)).x)
            return start;
        else
            return end;
    }

    public double right()
    {
        return Math.max(((Vector2) (start)).x, ((Vector2) (end)).x);
    }

    public boolean covered(ProjectedVertex projectedvertex)
    {
        Vertex vertex = projectedvertex.original;
        for(Enumeration enumeration = vertex.polygons().elements(); enumeration.hasMoreElements();)
        {
            Polygon2 polygon2 = (Polygon2)enumeration.nextElement();
            if(covered_sub(vertex, polygon2))
                return true;
        }

        return false;
    }

    public ProjectedVertex another_vertex(ProjectedVertex projectedvertex)
    {
        if(projectedvertex == start)
            return end;
        else
            return start;
    }

    public boolean cross(ProjectedEdge projectededge)
    {
        return cross(((Vector2) (start)).x, ((Vector2) (start)).y, ((Vector2) (end)).x, ((Vector2) (end)).y, ((Vector2) (projectededge.start)).x, ((Vector2) (projectededge.start)).y, ((Vector2) (projectededge.end)).x, ((Vector2) (projectededge.end)).y);
    }

    public ProjectedVertex right_vertex()
    {
        if(((Vector2) (start)).x > ((Vector2) (end)).x)
            return start;
        else
            return end;
    }

    public ProjectedVertex top_vertex()
    {
        if(((Vector2) (start)).y < ((Vector2) (end)).y)
            return start;
        else
            return end;
    }

    public ProjectedVertex start;
    public ProjectedVertex end;
    Edge original;
    int QI;
    int type;
}
