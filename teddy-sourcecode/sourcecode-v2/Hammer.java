// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Hammer.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            Polyhedron, LinkedList, Vertex, Vector3

class Hammer extends Polyhedron
{

    Hammer()
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
        for(double d = -2D; d <= 1.5D; d += 0.5D)
        {
            for(double d5 = -1D; d5 <= 0.5D; d5 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d, d5, 1.0D), get_vertex(d + 0.5D, d5, 1.0D), get_vertex(d + 0.5D, d5 + 0.5D, 1.0D), get_vertex(d, d5 + 0.5D, 1.0D)));

        }

        for(double d10 = 1.0D; d10 >= -0.5D; d10 -= 0.5D)
        {
            for(double d1 = -2D; d1 <= 1.5D; d1 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, 1.0D, d10), get_vertex(d1 + 0.5D, 1.0D, d10), get_vertex(d1 + 0.5D, 1.0D, d10 - 0.5D), get_vertex(d1, 1.0D, d10 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, -1D, d10 - 0.5D), get_vertex(d1 + 0.5D, -1D, d10 - 0.5D), get_vertex(d1 + 0.5D, -1D, d10), get_vertex(d1, -1D, d10)));
            }

            for(double d6 = -1D; d6 <= 0.5D; d6 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(-2D, d6, d10), get_vertex(-2D, d6 + 0.5D, d10), get_vertex(-2D, d6 + 0.5D, d10 - 0.5D), get_vertex(-2D, d6, d10 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(2D, d6, d10 - 0.5D), get_vertex(2D, d6 + 0.5D, d10 - 0.5D), get_vertex(2D, d6 + 0.5D, d10), get_vertex(2D, d6, d10)));
            }

        }

        for(double d2 = -2D; d2 <= 1.5D; d2 += 0.5D)
        {
            for(double d7 = -1D; d7 <= 0.5D; d7 += 0.5D)
                if(d2 != -0.5D && d2 != 0.0D || d7 != -0.5D && d7 != 0.0D)
                    super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d2, d7, -1D), get_vertex(d2, d7 + 0.5D, -1D), get_vertex(d2 + 0.5D, d7 + 0.5D, -1D), get_vertex(d2 + 0.5D, d7, -1D)));

        }

        for(double d11 = -1D; d11 >= -2.75D; d11 -= 0.25D)
        {
            for(double d3 = -0.5D; d3 <= 0.0D; d3 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d3, 0.5D, d11), get_vertex(d3 + 0.5D, 0.5D, d11), get_vertex(d3 + 0.5D, 0.5D, d11 - 0.25D), get_vertex(d3, 0.5D, d11 - 0.25D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d3, -0.5D, d11 - 0.25D), get_vertex(d3 + 0.5D, -0.5D, d11 - 0.25D), get_vertex(d3 + 0.5D, -0.5D, d11), get_vertex(d3, -0.5D, d11)));
            }

            for(double d8 = -0.5D; d8 <= 0.0D; d8 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(-0.5D, d8, d11), get_vertex(-0.5D, d8 + 0.5D, d11), get_vertex(-0.5D, d8 + 0.5D, d11 - 0.25D), get_vertex(-0.5D, d8, d11 - 0.25D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(0.5D, d8, d11 - 0.25D), get_vertex(0.5D, d8 + 0.5D, d11 - 0.25D), get_vertex(0.5D, d8 + 0.5D, d11), get_vertex(0.5D, d8, d11)));
            }

        }

        for(double d4 = -0.5D; d4 <= 0.0D; d4 += 0.5D)
        {
            for(double d9 = -0.5D; d9 <= 0.0D; d9 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d4, d9, -3D), get_vertex(d4, d9 + 0.5D, -3D), get_vertex(d4 + 0.5D, d9 + 0.5D, -3D), get_vertex(d4 + 0.5D, d9, -3D)));

        }

        for(Enumeration enumeration = super._vertices.elements(); enumeration.hasMoreElements();)
        {
            Vertex vertex = (Vertex)enumeration.nextElement();
            double d12 = Math.sqrt(((Vector3) (vertex)).x * ((Vector3) (vertex)).x + ((Vector3) (vertex)).y * ((Vector3) (vertex)).y);
            if(d12 > 0.0001D)
            {
                double d13 = (0.5D + d12 / 2D) / d12;
                vertex.x = ((Vector3) (vertex)).x * d13;
                vertex.y = ((Vector3) (vertex)).y * d13;
            }
        }

        postprocess();
    }
}
