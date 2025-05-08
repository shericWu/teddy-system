// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SilhouetteFind.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            Vertex2D, LinkedList, ProjectedEdge, Draw3DScene, 
//            Vector2, Vertex

class ProjectedVertex extends Vertex2D
{

    public int cusp()
    {
        int i = 0;
        int j = 0;
        for(Enumeration enumeration = edges.elements(); enumeration.hasMoreElements();)
        {
            ProjectedEdge projectededge = (ProjectedEdge)enumeration.nextElement();
            if(projectededge.type == 2)
            {
                i++;
                front_silhouette_edge = projectededge;
            } else
            if(projectededge.type == 1)
            {
                j++;
                back_silhouette_edge = projectededge;
            }
        }

        if(i >= 1 && j >= 1)
            return i + j;
        else
            return 0;
    }

    ProjectedVertex(Vertex vertex)
    {
        super.x = Draw3DScene.project_x(vertex);
        super.y = Draw3DScene.project_y(vertex);
        edges = new LinkedList();
        QI = -1;
        original = vertex;
    }

    ProjectedVertex(Vertex2D vertex2d)
    {
        super.x = ((Vector2) (vertex2d)).x;
        super.y = ((Vector2) (vertex2d)).y;
    }

    public LinkedList edges;
    int QI;
    Vertex original;
    private static int eye_z = 10;
    public ProjectedEdge front_silhouette_edge;
    public ProjectedEdge back_silhouette_edge;

}
