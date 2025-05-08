// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NewPolyhedron.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            Polyhedron, LinkedList, Vertex2D, Vector2

class NewPolyhedron extends Polyhedron
{

    public void add_temp_polygon(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7, double d8)
    {
        super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d, d1, d2), get_vertex(d3, d4, d5), get_vertex(d6, d7, d8)));
    }

    public void add_temp_polygon(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7, double d8, double d9, double d10, double d11)
    {
        super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d, d1, d2), get_vertex(d3, d4, d5), get_vertex(d6, d7, d8), get_vertex(d9, d10, d11)));
    }

    NewPolyhedron()
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
    }

    NewPolyhedron(LinkedList linkedlist)
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex2D vertex2d = new Vertex2D(0.0D, 0.0D);
        while(enumeration.hasMoreElements()) 
        {
            Vertex2D vertex2d1 = (Vertex2D)enumeration.nextElement();
            vertex2d.x += ((Vector2) (vertex2d1)).x;
            vertex2d.y += ((Vector2) (vertex2d1)).y;
        }
        vertex2d.x /= linkedlist.size();
        vertex2d.y /= linkedlist.size();
        enumeration = linkedlist.elements();
        Vertex2D vertex2d2 = (Vertex2D)enumeration.nextElement();
        int i = 4;
        while(enumeration.hasMoreElements()) 
        {
            Vertex2D vertex2d3 = (Vertex2D)enumeration.nextElement();
            double d = ((Vector2) (vertex2d2)).x;
            double d1 = ((Vector2) (vertex2d2)).y;
            double d2 = ((Vector2) (vertex2d3)).x;
            double d3 = ((Vector2) (vertex2d3)).y;
            for(int j = -i; j < i; j++)
            {
                double d12 = Math.cos((3.1415926535897931D * (double)j) / (double)i / 2D);
                double d14 = Math.sin((3.1415926535897931D * (double)j) / (double)i / 2D) / 2D;
                double d13 = Math.cos((3.1415926535897931D * (double)(j + 1)) / (double)i / 2D);
                double d15 = Math.sin((3.1415926535897931D * (double)(j + 1)) / (double)i / 2D) / 2D;
                double d4 = ((Vector2) (vertex2d)).x + (d - ((Vector2) (vertex2d)).x) * d12;
                double d5 = ((Vector2) (vertex2d)).y + (d1 - ((Vector2) (vertex2d)).y) * d12;
                double d6 = ((Vector2) (vertex2d)).x + (d2 - ((Vector2) (vertex2d)).x) * d12;
                double d7 = ((Vector2) (vertex2d)).y + (d3 - ((Vector2) (vertex2d)).y) * d12;
                double d8 = ((Vector2) (vertex2d)).x + (d2 - ((Vector2) (vertex2d)).x) * d13;
                double d9 = ((Vector2) (vertex2d)).y + (d3 - ((Vector2) (vertex2d)).y) * d13;
                double d10 = ((Vector2) (vertex2d)).x + (d - ((Vector2) (vertex2d)).x) * d13;
                double d11 = ((Vector2) (vertex2d)).y + (d1 - ((Vector2) (vertex2d)).y) * d13;
                if(j == -i)
                    super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(((Vector2) (vertex2d)).x, d14, ((Vector2) (vertex2d)).y), get_vertex(d10, d15, d11), get_vertex(d8, d15, d9)));
                else
                if(j == i - 1)
                    super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d6, d14, d7), get_vertex(d4, d14, d5), get_vertex(((Vector2) (vertex2d)).x, d15, ((Vector2) (vertex2d)).y)));
                else
                    super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d10, d15, d11), get_vertex(d8, d15, d9), get_vertex(d6, d14, d7), get_vertex(d4, d14, d5)));
            }

            vertex2d2 = vertex2d3;
        }
        postprocess_no_normalize();
    }

    public void generate_polygons()
    {
        postprocess_no_normalize();
    }
}
