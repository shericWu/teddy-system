// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Lshape.java

package teddy;


// Referenced classes of package teddy:
//            Polyhedron, LinkedList

class Lshape extends Polyhedron
{

    Lshape()
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
        for(double d = -1D; d <= 0.5D; d += 0.5D)
        {
            for(double d5 = -1D; d5 <= 0.5D; d5 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d, d5, 3D), get_vertex(d + 0.5D, d5, 3D), get_vertex(d + 0.5D, d5 + 0.5D, 3D), get_vertex(d, d5 + 0.5D, 3D)));

        }

        for(double d10 = 3D; d10 >= 1.5D; d10 -= 0.5D)
        {
            for(double d1 = -1D; d1 <= 0.5D; d1 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, 1.0D, d10), get_vertex(d1 + 0.5D, 1.0D, d10), get_vertex(d1 + 0.5D, 1.0D, d10 - 0.5D), get_vertex(d1, 1.0D, d10 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d1, -1D, d10 - 0.5D), get_vertex(d1 + 0.5D, -1D, d10 - 0.5D), get_vertex(d1 + 0.5D, -1D, d10), get_vertex(d1, -1D, d10)));
            }

            for(double d6 = -1D; d6 <= 0.5D; d6 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(-1D, d6, d10), get_vertex(-1D, d6 + 0.5D, d10), get_vertex(-1D, d6 + 0.5D, d10 - 0.5D), get_vertex(-1D, d6, d10 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(1.0D, d6, d10 - 0.5D), get_vertex(1.0D, d6 + 0.5D, d10 - 0.5D), get_vertex(1.0D, d6 + 0.5D, d10), get_vertex(1.0D, d6, d10)));
            }

        }

        for(double d2 = 1.0D; d2 <= 2.5D; d2 += 0.5D)
        {
            for(double d7 = -1D; d7 <= 0.5D; d7 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d2, d7, 1.0D), get_vertex(d2 + 0.5D, d7, 1.0D), get_vertex(d2 + 0.5D, d7 + 0.5D, 1.0D), get_vertex(d2, d7 + 0.5D, 1.0D)));

        }

        for(double d11 = 1.0D; d11 >= -0.5D; d11 -= 0.5D)
        {
            for(double d3 = -1D; d3 <= 2.5D; d3 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d3, 1.0D, d11), get_vertex(d3 + 0.5D, 1.0D, d11), get_vertex(d3 + 0.5D, 1.0D, d11 - 0.5D), get_vertex(d3, 1.0D, d11 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d3, -1D, d11 - 0.5D), get_vertex(d3 + 0.5D, -1D, d11 - 0.5D), get_vertex(d3 + 0.5D, -1D, d11), get_vertex(d3, -1D, d11)));
            }

            for(double d8 = -1D; d8 <= 0.5D; d8 += 0.5D)
            {
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(-1D, d8, d11), get_vertex(-1D, d8 + 0.5D, d11), get_vertex(-1D, d8 + 0.5D, d11 - 0.5D), get_vertex(-1D, d8, d11 - 0.5D)));
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(3D, d8, d11 - 0.5D), get_vertex(3D, d8 + 0.5D, d11 - 0.5D), get_vertex(3D, d8 + 0.5D, d11), get_vertex(3D, d8, d11)));
            }

        }

        for(double d4 = -1D; d4 <= 2.5D; d4 += 0.5D)
        {
            for(double d9 = -1D; d9 <= 0.5D; d9 += 0.5D)
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(d4, d9, -1D), get_vertex(d4, d9 + 0.5D, -1D), get_vertex(d4 + 0.5D, d9 + 0.5D, -1D), get_vertex(d4 + 0.5D, d9, -1D)));

        }

        postprocess();
    }
}
