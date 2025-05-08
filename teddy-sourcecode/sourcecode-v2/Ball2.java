// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Ball2.java

package teddy;


// Referenced classes of package teddy:
//            Polyhedron, LinkedList

class Ball2 extends Polyhedron
{

    Ball2()
    {
        super.tmp_polygons = new LinkedList();
        super._vertices = new LinkedList();
        super._edges = new LinkedList();
        super._polygons = new LinkedList();
        double d = Math.cos(0.39269908169872414D);
        double d1 = Math.sin(0.39269908169872414D);
        double d2 = Math.sqrt(2D) / 2D;
        double ad[] = {
            0, 0.10000000000000001D, 0.20000000000000001D, 0.34999999999999998D, 0.40000000000000002D, 0.34999999999999998D, 0.20000000000000001D, 0, -d1, -d2, 
            -d, -1D
        };
        double ad1[] = {
            0, 0.20000000000000001D, 0.29999999999999999D, 0.5D, 0.65000000000000002D, 0.80000000000000004D, 0.94999999999999996D, 1.0D, d, d2, 
            d1, 0
        };
        double ad2[][] = {
            {
                1.0D, 0
            }, {
                d, d1
            }, {
                d2, d2
            }, {
                d1, d
            }, {
                0, 1.0D
            }, {
                -d1, d
            }, {
                -d2, d2
            }, {
                -d, d1
            }, {
                -1D, 0
            }, {
                -d, -d1
            }, {
                -d2, -d2
            }, {
                -d1, -d
            }, {
                0, -1D
            }, {
                d1, -d
            }, {
                d2, -d2
            }, {
                d, -d1
            }, {
                1.0D, 0
            }
        };
        int j = 0;
        do
            super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(0.0D, 0.0D, ad[0]), get_vertex(ad1[1] * ad2[j][0], ad1[1] * ad2[j][1], ad[1]), get_vertex(ad1[1] * ad2[j + 1][0], ad1[1] * ad2[j + 1][1], ad[1])));
        while(++j <= 15);
        int i = 1;
        do
        {
            j = 0;
            do
                super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(ad1[i] * ad2[j][0], ad1[i] * ad2[j][1], ad[i]), get_vertex(ad1[i + 1] * ad2[j][0], ad1[i + 1] * ad2[j][1], ad[i + 1]), get_vertex(ad1[i + 1] * ad2[j + 1][0], ad1[i + 1] * ad2[j + 1][1], ad[i + 1]), get_vertex(ad1[i] * ad2[j + 1][0], ad1[i] * ad2[j + 1][1], ad[i])));
            while(++j <= 15);
        } while(++i <= 9);
        j = 0;
        do
            super.tmp_polygons.append(new Polyhedron.TmpPolygon(this, get_vertex(ad1[10] * ad2[j][0], ad1[10] * ad2[j][1], ad[10]), get_vertex(0.0D, 0.0D, ad[11]), get_vertex(ad1[10] * ad2[j + 1][0], ad1[10] * ad2[j + 1][1], ad[10])));
        while(++j <= 15);
        postprocess();
    }
}
