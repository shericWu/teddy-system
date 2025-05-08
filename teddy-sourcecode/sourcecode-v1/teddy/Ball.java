/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.LinkedList;
import teddy.Polyhedron;

class Ball
extends Polyhedron {
    Ball() {
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
        double d = Math.cos(0.39269908169872414);
        double d2 = Math.sin(0.39269908169872414);
        double d3 = Math.sqrt(2.0) / 2.0;
        double[] dArray = new double[9];
        dArray[0] = 1.0;
        dArray[1] = d;
        dArray[2] = d3;
        dArray[3] = d2;
        dArray[5] = -d2;
        dArray[6] = -d3;
        dArray[7] = -d;
        dArray[8] = -1.0;
        double[] dArray2 = dArray;
        double[] dArray3 = new double[9];
        dArray3[1] = d2;
        dArray3[2] = d3;
        dArray3[3] = d;
        dArray3[4] = 1.0;
        dArray3[5] = d;
        dArray3[6] = d3;
        dArray3[7] = d2;
        double[] dArray4 = dArray3;
        double[][] dArrayArray = new double[17][];
        double[] dArray5 = new double[2];
        dArray5[0] = 1.0;
        dArrayArray[0] = dArray5;
        dArrayArray[1] = new double[]{d, d2};
        dArrayArray[2] = new double[]{d3, d3};
        dArrayArray[3] = new double[]{d2, d};
        double[] dArray6 = new double[2];
        dArray6[1] = 1.0;
        dArrayArray[4] = dArray6;
        dArrayArray[5] = new double[]{-d2, d};
        dArrayArray[6] = new double[]{-d3, d3};
        dArrayArray[7] = new double[]{-d, d2};
        double[] dArray7 = new double[2];
        dArray7[0] = -1.0;
        dArrayArray[8] = dArray7;
        dArrayArray[9] = new double[]{-d, -d2};
        dArrayArray[10] = new double[]{-d3, -d3};
        dArrayArray[11] = new double[]{-d2, -d};
        double[] dArray8 = new double[2];
        dArray8[1] = -1.0;
        dArrayArray[12] = dArray8;
        dArrayArray[13] = new double[]{d2, -d};
        dArrayArray[14] = new double[]{d3, -d3};
        dArrayArray[15] = new double[]{d, -d2};
        double[] dArray9 = new double[2];
        dArray9[0] = 1.0;
        dArrayArray[16] = dArray9;
        double[][] dArrayArray2 = dArrayArray;
        int n = 0;
        do {
            this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(0.0, 0.0, dArray2[0]), this.get_vertex(dArray4[1] * dArrayArray2[n][0], dArray4[1] * dArrayArray2[n][1], dArray2[1]), this.get_vertex(dArray4[1] * dArrayArray2[n + 1][0], dArray4[1] * dArrayArray2[n + 1][1], dArray2[1])));
        } while (++n <= 15);
        int n2 = 1;
        do {
            n = 0;
            do {
                this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(dArray4[n2] * dArrayArray2[n][0], dArray4[n2] * dArrayArray2[n][1], dArray2[n2]), this.get_vertex(dArray4[n2 + 1] * dArrayArray2[n][0], dArray4[n2 + 1] * dArrayArray2[n][1], dArray2[n2 + 1]), this.get_vertex(dArray4[n2 + 1] * dArrayArray2[n + 1][0], dArray4[n2 + 1] * dArrayArray2[n + 1][1], dArray2[n2 + 1]), this.get_vertex(dArray4[n2] * dArrayArray2[n + 1][0], dArray4[n2] * dArrayArray2[n + 1][1], dArray2[n2])));
            } while (++n <= 15);
        } while (++n2 <= 6);
        n = 0;
        do {
            this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(dArray4[7] * dArrayArray2[n][0], dArray4[7] * dArrayArray2[n][1], dArray2[7]), this.get_vertex(0.0, 0.0, dArray2[8]), this.get_vertex(dArray4[7] * dArrayArray2[n + 1][0], dArray4[7] * dArrayArray2[n + 1][1], dArray2[7])));
        } while (++n <= 15);
        this.postprocess();
    }
}

