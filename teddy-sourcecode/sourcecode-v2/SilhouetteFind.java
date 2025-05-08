// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SilhouetteFind.java

package teddy;

import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            ProjectedEdge, ProjectedVertex, LinkedList, Vector3, 
//            Vertex2D, BoundEdges, Polyhedron, Polygon2, 
//            Edge, Vertex

class SilhouetteFind
{

    private static void propagate(ProjectedEdge projectededge, ProjectedVertex projectedvertex, int i)
    {
        ProjectedVertex projectedvertex1 = projectededge.another_vertex(projectedvertex);
        projectededge.QI = i;
        int j = i;
        for(int k = 0; k < n_silhouette_edges; k++)
        {
            ProjectedEdge projectededge1 = silhouette_edges[k];
            if(projectededge.cross_behind(projectededge1, camera))
            {
                projectededge.QI = 2;
                if(projectededge1.in(projectedvertex))
                    j -= 2;
                else
                    j += 2;
            }
        }

        if(j < 0)
            return;
        if(projectedvertex1.QI == -1)
        {
            projectedvertex1.QI = j;
            propagate(projectedvertex1, projectededge);
        }
    }

    private static void propagate(ProjectedVertex projectedvertex, ProjectedEdge projectededge)
    {
        int i = projectedvertex.cusp();
        if(i > 0)
        {
            if(i > 2)
                return;
            byte byte0;
            if(projectedvertex.back_silhouette_edge.covered(projectedvertex))
                byte0 = -1;
            else
                byte0 = 1;
            int j = projectedvertex.QI;
            if(projectededge == projectedvertex.back_silhouette_edge)
                projectedvertex.QI = projectedvertex.QI + byte0;
            for(Enumeration enumeration1 = projectedvertex.edges.elements(); enumeration1.hasMoreElements();)
            {
                ProjectedEdge projectededge2 = (ProjectedEdge)enumeration1.nextElement();
                if(projectededge2 != projectededge && projectededge2.QI == -1)
                    if(projectededge2 == projectedvertex.back_silhouette_edge)
                    {
                        int k = projectedvertex.QI - byte0;
                        if(k < 0)
                            System.out.println("back_silhouette's QI becomes -1 (SilhouetteFind.propagate())" + j + ", delta" + byte0);
                        else
                            propagate(projectededge2, projectedvertex, k);
                    } else
                    {
                        propagate(projectededge2, projectedvertex, projectedvertex.QI);
                    }
            }

            return;
        }
        for(Enumeration enumeration = projectedvertex.edges.elements(); enumeration.hasMoreElements();)
        {
            ProjectedEdge projectededge1 = (ProjectedEdge)enumeration.nextElement();
            if(projectededge1 != projectededge && projectededge1.QI == -1)
                if(projectededge1.type == 1 && projectededge.type == 3)
                    propagate(projectededge1, projectedvertex, projectedvertex.QI - 1);
                else
                if(projectededge1.type == 3 && projectededge.type == 1)
                    propagate(projectededge1, projectedvertex, projectedvertex.QI + 1);
                else
                    propagate(projectededge1, projectedvertex, projectedvertex.QI);
        }

    }

    SilhouetteFind()
    {
    }

    private static void propagate_from_silhouette(ProjectedEdge projectededge, int i, Polyhedron polyhedron)
    {
        ProjectedVertex projectedvertex = projectededge.start;
        if(((Vector3) (projectedvertex.original)).y > 0.0D)
            i += 2;
        projectededge.QI = i;
        projectedvertex.QI = i;
        propagate(projectededge, projectedvertex, projectedvertex.QI);
        propagate(projectedvertex, projectededge);
    }

    private static ProjectedVertex find_same_vertex(ProjectedVertex projectedvertex)
    {
        for(int i = 0; i < n_possible_vertices; i++)
        {
            ProjectedVertex projectedvertex1 = possible_vertices[i];
            if(projectedvertex1.same_position(projectedvertex))
                return projectedvertex1;
        }

        return null;
    }

    private static void renew_network()
    {
        possible_vertices = new ProjectedVertex[n_possible_edges * 2];
        n_possible_vertices = 0;
        for(int i = 0; i < n_possible_edges; i++)
        {
            ProjectedEdge projectededge = possible_edges[i];
            ProjectedVertex projectedvertex = find_same_vertex(projectededge.start);
            if(projectedvertex != null)
            {
                projectededge.start = projectedvertex;
                projectedvertex.edges.append(projectededge);
            } else
            {
                possible_vertices[n_possible_vertices++] = projectededge.start;
                projectededge.start.edges.append(projectededge);
            }
            projectedvertex = find_same_vertex(projectededge.end);
            if(projectedvertex != null)
            {
                projectededge.end = projectedvertex;
                projectedvertex.edges.append(projectededge);
            } else
            {
                possible_vertices[n_possible_vertices++] = projectededge.end;
                projectededge.end.edges.append(projectededge);
            }
        }

    }

    private static void propagate_from_boundedges(BoundEdges boundedges)
    {
        boundedges.right.right_vertex().QI = 0;
        boundedges.top.top_vertex().QI = 0;
        boundedges.bottom.bottom_vertex().QI = 0;
        ProjectedEdge projectededge = boundedges.left;
        ProjectedVertex projectedvertex = projectededge.left_vertex();
        projectedvertex.QI = 0;
        propagate(projectededge, projectedvertex, projectedvertex.QI);
        propagate(projectedvertex, projectededge);
        projectededge = boundedges.right;
        projectedvertex = projectededge.right_vertex();
        projectedvertex.QI = 0;
        propagate(projectededge, projectedvertex, projectedvertex.QI);
        propagate(projectedvertex, projectededge);
        projectededge = boundedges.top;
        projectedvertex = projectededge.top_vertex();
        projectedvertex.QI = 0;
        propagate(projectededge, projectedvertex, projectedvertex.QI);
        propagate(projectedvertex, projectededge);
        projectededge = boundedges.bottom;
        projectedvertex = projectededge.bottom_vertex();
        projectedvertex.QI = 0;
        propagate(projectededge, projectedvertex, projectedvertex.QI);
        propagate(projectedvertex, projectededge);
    }

    public static LinkedList find_visible_edges(Polyhedron polyhedron, Vertex vertex)
    {
        if(!polyhedron.view_changed && visible_edges != null)
            return visible_edges;
        polyhedron.view_changed = false;
        camera = vertex;
        int i;
        for(i = 0; i < polyhedron.n_polygons; i++)
            polyhedron.polygons[i].check_facing(camera);

        silhouette_edges = new ProjectedEdge[polyhedron.n_edges];
        n_silhouette_edges = 0;
        possible_edges = new ProjectedEdge[polyhedron.n_edges];
        n_possible_edges = 0;
        BoundEdges boundedges = new BoundEdges(new ProjectedEdge(polyhedron.edges[i]));
        for(int j = 0; j < polyhedron.n_edges; j++)
        {
            Edge edge = polyhedron.edges[j];
            int i1 = edge.visibility_type();
            if(i1 != 0)
            {
                ProjectedEdge projectededge = new ProjectedEdge(edge);
                if(i1 == 2 || i1 == 1)
                    silhouette_edges[n_silhouette_edges++] = projectededge;
                if(i1 == 2 || i1 == 3)
                {
                    possible_edges[n_possible_edges++] = projectededge;
                    boundedges.check(projectededge);
                }
            }
        }

        renew_network();
        propagate_from_boundedges(boundedges);
        for(int k = 0; k < n_possible_edges; k++)
        {
            ProjectedEdge projectededge1 = possible_edges[k];
            if(projectededge1.QI == -1)
                propagate_from_silhouette(projectededge1, 0, polyhedron);
        }

        visible_edges = new LinkedList();
        for(int l = 0; l < n_possible_edges; l++)
        {
            ProjectedEdge projectededge2 = possible_edges[l];
            if(projectededge2.QI == 0 || projectededge2.QI == -1)
                visible_edges.append(projectededge2);
        }

        return visible_edges;
    }

    public static ProjectedEdge silhouette_edges[];
    public static int n_silhouette_edges;
    public static ProjectedEdge possible_edges[];
    public static int n_possible_edges;
    public static int eye_z = 10;
    public static Vertex camera;
    private static LinkedList visible_edges;
    private static ProjectedVertex possible_vertices[];
    private static int n_possible_vertices;

}
