// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Box.java

package teddy;


// Referenced classes of package teddy:
//            Polyhedron, LinkedList

class Box extends Polyhedron
{

    Box()
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
        for(double d = -2D; d <= 1.5D; d += 0.5D)
        {
            for(double d3 = -1D; d3 <= 0.5D; d3 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d, d3, 1.0D), get_vertex(d + 0.5D, d3, 1.0D), get_vertex(d + 0.5D, d3 + 0.5D, 1.0D), get_vertex(d, d3 + 0.5D, 1.0D)));

        }

        for(double d6 = 1.0D; d6 >= -0.5D; d6 -= 0.5D)
        {
            for(double d1 = -2D; d1 <= 1.5D; d1 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, 1.0D, d6), get_vertex(d1 + 0.5D, 1.0D, d6), get_vertex(d1 + 0.5D, 1.0D, d6 - 0.5D), get_vertex(d1, 1.0D, d6 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, -1D, d6 - 0.5D), get_vertex(d1 + 0.5D, -1D, d6 - 0.5D), get_vertex(d1 + 0.5D, -1D, d6), get_vertex(d1, -1D, d6)));
            }

            for(double d4 = -1D; d4 <= 0.5D; d4 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(-2D, d4, d6), get_vertex(-2D, d4 + 0.5D, d6), get_vertex(-2D, d4 + 0.5D, d6 - 0.5D), get_vertex(-2D, d4, d6 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(2D, d4, d6 - 0.5D), get_vertex(2D, d4 + 0.5D, d6 - 0.5D), get_vertex(2D, d4 + 0.5D, d6), get_vertex(2D, d4, d6)));
            }

        }

        for(double d2 = -2D; d2 <= 1.5D; d2 += 0.5D)
        {
            for(double d5 = -1D; d5 <= 0.5D; d5 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d2, d5, -1D), get_vertex(d2, d5 + 0.5D, -1D), get_vertex(d2 + 0.5D, d5 + 0.5D, -1D), get_vertex(d2 + 0.5D, d5, -1D)));

        }

        postprocess();
        set_sharp_edges();
        rotate_z(20D);
        rotate_x(10D);
    }
}
