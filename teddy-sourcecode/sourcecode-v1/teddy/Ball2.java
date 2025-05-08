/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.LinkedList;
import teddy.Polyhedron;

class Ball2
extends Polyhedron {
    Ball2() {
        this.tmp_polygons = new LinkedList();
        this._vertices = new LinkedList();
        this._edges = new LinkedList();
        this._polygons = new LinkedList();
        double d = Math.cos(0.39269908169872414);
        double d2 = Math.sin(0.39269908169872414);
        double d3 = Math.sqrt(2.0) / 2.0;
        double[] dArray = new double[12];
        dArray[1] = 0.1;
        dArray[2] = 0.2;
        dArray[3] = 0.35;
        dArray[4] = 0.4;
        dArray[5] = 0.35;
        dArray[6] = 0.2;
        dArray[8] = -d2;
        dArray[9] = -d3;
        dArray[10] = -d;
        dArray[11] = -1.0;
        double[] dArray2 = dArray;
        double[] dArray3 = new double[12];
        dArray3[1] = 0.2;
        dArray3[2] = 0.3;
        dArray3[3] = 0.5;
        dArray3[4] = 0.65;
        dArray3[5] = 0.8;
        dArray3[6] = 0.95;
        dArray3[7] = 1.0;
        dArray3[8] = d;
        dArray3[9] = d3;
        dArray3[10] = d2;
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
        } while (++n2 <= 9);
        n = 0;
        do {
            this.tmp_polygons.append(new Polyhedron.TmpPolygon(this, this.get_vertex(dArray4[10] * dArrayArray2[n][0], dArray4[10] * dArrayArray2[n][1], dArray2[10]), this.get_vertex(0.0, 0.0, dArray2[11]), this.get_vertex(dArray4[10] * dArrayArray2[n + 1][0], dArray4[10] * dArrayArray2[n + 1][1], dArray2[10])));
        } while (++n <= 15);
        this.postprocess();
    }
}

