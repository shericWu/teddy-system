/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import teddy.Draw3DScene;
import teddy.LinkedList;
import teddy.ProjectedEdge;
import teddy.Vertex;
import teddy.Vertex2D;

class ProjectedVertex
extends Vertex2D {
    public LinkedList edges;
    int QI;
    Vertex original;
    private static int eye_z = 10;
    public ProjectedEdge front_silhouette_edge;
    public ProjectedEdge back_silhouette_edge;

    public int cusp() {
        int n = 0;
        int n2 = 0;
        Enumeration enumeration = this.edges.elements();
        while (enumeration.hasMoreElements()) {
            ProjectedEdge projectedEdge = (ProjectedEdge)enumeration.nextElement();
            if (projectedEdge.type == 2) {
                ++n;
                this.front_silhouette_edge = projectedEdge;
                continue;
            }
            if (projectedEdge.type != 1) continue;
            ++n2;
            this.back_silhouette_edge = projectedEdge;
        }
        if (n >= 1 && n2 >= 1) {
            return n + n2;
        }
        return 0;
    }

    ProjectedVertex(Vertex vertex) {
        this.x = Draw3DScene.project_x(vertex);
        this.y = Draw3DScene.project_y(vertex);
        this.edges = new LinkedList();
        this.QI = -1;
        this.original = vertex;
    }

    ProjectedVertex(Vertex2D vertex2D) {
        this.x = vertex2D.x;
        this.y = vertex2D.y;
    }
}

