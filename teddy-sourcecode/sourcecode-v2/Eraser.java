// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Eraser.java

package teddy;

import java.awt.Point;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Modify, Draw3DScene, LinkedList, Vector2, 
//            Teddy, Polyhedron, SurfaceLine, Edge, 
//            Polygon2, Vertex

class Eraser extends Modify
{

    private static boolean enclosed(LinkedList linkedlist, Vertex vertex)
    {
        Point point = Draw3DScene.project(vertex);
        Enumeration enumeration = linkedlist.elements();
        Point point2;
        for(Point point1 = (Point)enumeration.nextElement(); enumeration.hasMoreElements(); point1 = point2)
        {
            point2 = (Point)enumeration.nextElement();
            if((new Vector2(point1, point2)).cross_product(new Vector2(point1, point)) > 0.0D)
                return false;
        }

        return true;
    }

    Eraser()
    {
    }

    public static void erase(LinkedList linkedlist, Polyhedron polyhedron)
    {
        Teddy.teddy.play_sound("smooth.au");
        Modify.init(polyhedron);
        LinkedList linkedlist1 = new LinkedList();
        for(Enumeration enumeration = Modify.h.surface_lines.elements(); enumeration.hasMoreElements();)
        {
            SurfaceLine surfaceline = (SurfaceLine)enumeration.nextElement();
            if(!enclosed(linkedlist, ((Edge) (surfaceline)).start))
                linkedlist1.append(surfaceline);
        }

        Modify.h.surface_lines = linkedlist1;
        for(int i = 0; i < Modify.h.n_edges; i++)
        {
            Edge edge = Modify.h.edges[i];
            if(edge.sharp && (edge.left_polygon.front_facing || edge.right_polygon.front_facing) && enclosed(linkedlist, edge.start) && enclosed(linkedlist, edge.end))
                edge.sharp = false;
        }

    }
}
