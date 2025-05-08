/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.BoundEdges;
import teddy.Edge;
import teddy.LinkedList;
import teddy.Polyhedron;
import teddy.ProjectedEdge;
import teddy.ProjectedVertex;
import teddy.Vertex;

class SilhouetteFind {
    public static ProjectedEdge[] silhouette_edges;
    public static int n_silhouette_edges;
    public static ProjectedEdge[] possible_edges;
    public static int n_possible_edges;
    public static int eye_z;
    public static Vertex camera;
    private static LinkedList visible_edges;
    private static ProjectedVertex[] possible_vertices;
    private static int n_possible_vertices;

    private static void propagate(ProjectedEdge projectedEdge, ProjectedVertex projectedVertex, int n) {
        ProjectedVertex projectedVertex2 = projectedEdge.another_vertex(projectedVertex);
        projectedEdge.QI = n;
        int n2 = n;
        int n3 = 0;
        while (n3 < n_silhouette_edges) {
            ProjectedEdge projectedEdge2 = silhouette_edges[n3];
            if (projectedEdge.cross_behind(projectedEdge2, camera)) {
                projectedEdge.QI = 2;
                n2 = projectedEdge2.in(projectedVertex) ? (n2 -= 2) : (n2 += 2);
            }
            ++n3;
        }
        if (n2 < 0) {
            return;
        }
        if (projectedVertex2.QI == -1) {
            projectedVertex2.QI = n2;
            SilhouetteFind.propagate(projectedVertex2, projectedEdge);
        }
    }

    private static void propagate(ProjectedVertex projectedVertex, ProjectedEdge projectedEdge) {
        int n = projectedVertex.cusp();
        if (n > 0) {
            if (n > 2) {
                return;
            }
            int n2 = projectedVertex.back_silhouette_edge.covered(projectedVertex) ? -1 : 1;
            int n3 = projectedVertex.QI;
            if (projectedEdge == projectedVertex.back_silhouette_edge) {
                projectedVertex.QI += n2;
            }
            Enumeration enumeration = projectedVertex.edges.elements();
            while (enumeration.hasMoreElements()) {
                ProjectedEdge projectedEdge2 = (ProjectedEdge)enumeration.nextElement();
                if (projectedEdge2 == projectedEdge || projectedEdge2.QI != -1) continue;
                if (projectedEdge2 == projectedVertex.back_silhouette_edge) {
                    int n4 = projectedVertex.QI - n2;
                    if (n4 < 0) {
                        System.out.println("back_silhouette's QI becomes -1 (SilhouetteFind.propagate())" + n3 + ", delta" + n2);
                        continue;
                    }
                    SilhouetteFind.propagate(projectedEdge2, projectedVertex, n4);
                    continue;
                }
                SilhouetteFind.propagate(projectedEdge2, projectedVertex, projectedVertex.QI);
            }
            return;
        }
        Enumeration enumeration = projectedVertex.edges.elements();
        while (enumeration.hasMoreElements()) {
            ProjectedEdge projectedEdge3 = (ProjectedEdge)enumeration.nextElement();
            if (projectedEdge3 == projectedEdge || projectedEdge3.QI != -1) continue;
            if (projectedEdge3.type == 1 && projectedEdge.type == 3) {
                SilhouetteFind.propagate(projectedEdge3, projectedVertex, projectedVertex.QI - 1);
                continue;
            }
            if (projectedEdge3.type == 3 && projectedEdge.type == 1) {
                SilhouetteFind.propagate(projectedEdge3, projectedVertex, projectedVertex.QI + 1);
                continue;
            }
            SilhouetteFind.propagate(projectedEdge3, projectedVertex, projectedVertex.QI);
        }
    }

    SilhouetteFind() {
    }

    private static void propagate_from_silhouette(ProjectedEdge projectedEdge, int n, Polyhedron polyhedron) {
        ProjectedVertex projectedVertex = projectedEdge.start;
        if (projectedVertex.original.y > 0.0) {
            n += 2;
        }
        projectedEdge.QI = n;
        projectedVertex.QI = n;
        SilhouetteFind.propagate(projectedEdge, projectedVertex, projectedVertex.QI);
        SilhouetteFind.propagate(projectedVertex, projectedEdge);
    }

    static {
        eye_z = 10;
    }

    private static ProjectedVertex find_same_vertex(ProjectedVertex projectedVertex) {
        int n = 0;
        while (n < n_possible_vertices) {
            ProjectedVertex projectedVertex2 = possible_vertices[n];
            if (projectedVertex2.same_position(projectedVertex)) {
                return projectedVertex2;
            }
            ++n;
        }
        return null;
    }

    private static void renew_network() {
        possible_vertices = new ProjectedVertex[n_possible_edges * 2];
        n_possible_vertices = 0;
        int n = 0;
        while (n < n_possible_edges) {
            ProjectedEdge projectedEdge = possible_edges[n];
            ProjectedVertex projectedVertex = SilhouetteFind.find_same_vertex(projectedEdge.start);
            if (projectedVertex != null) {
                projectedEdge.start = projectedVertex;
                projectedVertex.edges.append(projectedEdge);
            } else {
                SilhouetteFind.possible_vertices[SilhouetteFind.n_possible_vertices++] = projectedEdge.start;
                projectedEdge.start.edges.append(projectedEdge);
            }
            projectedVertex = SilhouetteFind.find_same_vertex(projectedEdge.end);
            if (projectedVertex != null) {
                projectedEdge.end = projectedVertex;
                projectedVertex.edges.append(projectedEdge);
            } else {
                SilhouetteFind.possible_vertices[SilhouetteFind.n_possible_vertices++] = projectedEdge.end;
                projectedEdge.end.edges.append(projectedEdge);
            }
            ++n;
        }
    }

    private static void propagate_from_boundedges(BoundEdges boundEdges) {
        boundEdges.right.right_vertex().QI = 0;
        boundEdges.top.top_vertex().QI = 0;
        boundEdges.bottom.bottom_vertex().QI = 0;
        ProjectedEdge projectedEdge = boundEdges.left;
        ProjectedVertex projectedVertex = projectedEdge.left_vertex();
        projectedVertex.QI = 0;
        SilhouetteFind.propagate(projectedEdge, projectedVertex, projectedVertex.QI);
        SilhouetteFind.propagate(projectedVertex, projectedEdge);
        projectedEdge = boundEdges.right;
        projectedVertex = projectedEdge.right_vertex();
        projectedVertex.QI = 0;
        SilhouetteFind.propagate(projectedEdge, projectedVertex, projectedVertex.QI);
        SilhouetteFind.propagate(projectedVertex, projectedEdge);
        projectedEdge = boundEdges.top;
        projectedVertex = projectedEdge.top_vertex();
        projectedVertex.QI = 0;
        SilhouetteFind.propagate(projectedEdge, projectedVertex, projectedVertex.QI);
        SilhouetteFind.propagate(projectedVertex, projectedEdge);
        projectedEdge = boundEdges.bottom;
        projectedVertex = projectedEdge.bottom_vertex();
        projectedVertex.QI = 0;
        SilhouetteFind.propagate(projectedEdge, projectedVertex, projectedVertex.QI);
        SilhouetteFind.propagate(projectedVertex, projectedEdge);
    }

    public static LinkedList find_visible_edges(Polyhedron polyhedron, Vertex vertex) {
        ProjectedEdge projectedEdge;
        if (!polyhedron.view_changed && visible_edges != null) {
            return visible_edges;
        }
        polyhedron.view_changed = false;
        camera = vertex;
        int n = 0;
        while (n < polyhedron.n_polygons) {
            polyhedron.polygons[n].check_facing(camera);
            ++n;
        }
        silhouette_edges = new ProjectedEdge[polyhedron.n_edges];
        n_silhouette_edges = 0;
        possible_edges = new ProjectedEdge[polyhedron.n_edges];
        n_possible_edges = 0;
        BoundEdges boundEdges = new BoundEdges(new ProjectedEdge(polyhedron.edges[n]));
        n = 0;
        while (n < polyhedron.n_edges) {
            Edge edge = polyhedron.edges[n];
            int n2 = edge.visibility_type();
            if (n2 != 0) {
                projectedEdge = new ProjectedEdge(edge);
                if (n2 == 2 || n2 == 1) {
                    SilhouetteFind.silhouette_edges[SilhouetteFind.n_silhouette_edges++] = projectedEdge;
                }
                if (n2 == 2 || n2 == 3) {
                    SilhouetteFind.possible_edges[SilhouetteFind.n_possible_edges++] = projectedEdge;
                    boundEdges.check(projectedEdge);
                }
            }
            ++n;
        }
        SilhouetteFind.renew_network();
        SilhouetteFind.propagate_from_boundedges(boundEdges);
        n = 0;
        while (n < n_possible_edges) {
            projectedEdge = possible_edges[n];
            if (projectedEdge.QI == -1) {
                SilhouetteFind.propagate_from_silhouette(projectedEdge, 0, polyhedron);
            }
            ++n;
        }
        visible_edges = new LinkedList();
        n = 0;
        while (n < n_possible_edges) {
            projectedEdge = possible_edges[n];
            if (projectedEdge.QI == 0 || projectedEdge.QI == -1) {
                visible_edges.append(projectedEdge);
            }
            ++n;
        }
        return visible_edges;
    }
}

