/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Vector;
import teddy.Draw3DScene;
import teddy.Edge;
import teddy.Objects;
import teddy.Polygon2;
import teddy.Polyhedron;
import teddy.SurfaceLine;
import teddy.Teddy;
import teddy.Vector2;
import teddy.Vector3;
import teddy.Vertex;
import teddy.Vertex2D;

class ObjFileHandler {
    ObjFileHandler() {
    }

    public static void convert(String string) {
        int n;
        Object object;
        double d;
        double d2;
        double d3;
        int n2;
        Object object2;
        Object object3;
        Polyhedron polyhedron = null;
        try {
            object3 = new BufferedReader(new FileReader(Teddy.filename(string)));
            polyhedron = ObjFileHandler.load((BufferedReader)object3);
        }
        catch (IOException iOException) {
            System.out.print("IO Error " + iOException);
        }
        Draw3DScene.set_front_facing(polyhedron);
        object3 = new Vector();
        Vector vector = new Vector();
        int n3 = 0;
        while (n3 < polyhedron.n_vertices) {
            object2 = polyhedron.vertices[n3];
            ((Vector)object3).addElement(object2);
            ((Vertex)object2).index = n3++;
        }
        n3 = 0;
        while (n3 < polyhedron.n_polygons) {
            object2 = polyhedron.polygons[n3];
            Vector<Integer> vector2 = new Vector<Integer>();
            n2 = 0;
            while (n2 < ((Polygon2)object2).n_edges) {
                vector2.addElement(new Integer(((Polygon2)object2).get_vertex((int)n2).index + 1));
                ++n2;
            }
            vector.addElement(vector2);
            ++n3;
        }
        n3 = ((Vector)object3).size();
        object2 = new boolean[((Vector)object3).size() + 1];
        int n4 = 0;
        while (n4 < ((Vector)object3).size() + 1) {
            object2[n4] = false;
            ++n4;
        }
        ((Vector)object3).size();
        Vector vector3 = new Vector();
        n2 = 0;
        while (n2 < vector.size()) {
            Vector vector4 = (Vector)vector.elementAt(n2);
            Vector vector5 = new Vector();
            vector5.addElement(vector4.elementAt(2));
            vector5.addElement(vector4.elementAt(1));
            vector5.addElement(vector4.elementAt(0));
            vector3.addElement(vector5);
            ++n2;
        }
        vector = vector3;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        int n5 = 0;
        while (n5 < n3) {
            Vertex vertex = (Vertex)((Vector)object3).elementAt(n5);
            if (vertex.z < d4) {
                d4 = vertex.z;
            }
            if (vertex.z > d5) {
                d5 = vertex.z;
            }
            if (vertex.x < d6) {
                d6 = vertex.x;
            }
            if (vertex.x > d7) {
                d7 = vertex.x;
            }
            ++n5;
        }
        double d8 = d7 - d6;
        double d9 = d5 - d4;
        if (d8 > d9) {
            d3 = Math.max(d8, d9 * 2.0);
            d2 = d9 / d3;
            d = 0.0;
        } else {
            d3 = Math.max(d8 * 2.0, d9);
            d = d8 / d3;
            d2 = 0.0;
        }
        Vector<Vertex2D> vector6 = new Vector<Vertex2D>();
        Vector vector7 = new Vector();
        int[] nArray = new int[((Vector)object3).size() + 1];
        int[] nArray2 = new int[((Vector)object3).size() + 1];
        int n6 = 0;
        while (n6 < vector.size()) {
            Vector vector8 = (Vector)vector.elementAt(n6);
            object = new Vector();
            int n7 = 0;
            while (n7 < vector8.size()) {
                int n8 = (Integer)vector8.elementAt(n7);
                n = nArray[n8];
                if (!polyhedron.polygons[n6].front_facing) {
                    n = nArray2[n8];
                }
                if (n == 0) {
                    Vertex vertex = (Vertex)((Vector)object3).elementAt(n8 - 1);
                    double d10 = (vertex.x - d6) / d3;
                    double d11 = (vertex.z - d4) / d3;
                    if (!polyhedron.polygons[n6].front_facing) {
                        d10 += d;
                        d11 += d2;
                    }
                    d11 = 1.0 - d11;
                    vector6.addElement(new Vertex2D(d10, d11));
                    n = vector6.size();
                    if (polyhedron.polygons[n6].front_facing) {
                        nArray[n8] = n;
                    } else {
                        nArray2[n8] = n;
                    }
                }
                ((Vector)object).addElement(new Integer(n));
                ++n7;
            }
            vector7.addElement(object);
            ++n6;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Teddy.filename_(string)));
            int n9 = 0;
            while (n9 < ((Vector)object3).size()) {
                object = (Vertex)((Vector)object3).elementAt(n9);
                String string2 = "v " + ((Vector3)object).x + " " + ((Vector3)object).y + " " + ((Vector3)object).z;
                bufferedWriter.write(string2, 0, string2.length());
                bufferedWriter.newLine();
                ++n9;
            }
            n9 = 0;
            while (n9 < vector6.size()) {
                object = (Vertex2D)vector6.elementAt(n9);
                String string3 = "vt " + ((Vector2)object).x + " " + ((Vector2)object).y;
                bufferedWriter.write(string3, 0, string3.length());
                bufferedWriter.newLine();
                ++n9;
            }
            n9 = 0;
            while (n9 < vector.size()) {
                object = (Vector)vector.elementAt(n9);
                Vector vector9 = (Vector)vector7.elementAt(n9);
                String string4 = "f";
                n = 0;
                while (n < ((Vector)object).size()) {
                    int n10 = (Integer)((Vector)object).elementAt(n);
                    int n11 = (Integer)vector9.elementAt(n);
                    string4 = string4 + " " + n10 + "/" + n11 + "";
                    ++n;
                }
                bufferedWriter.write(string4, 0, string4.length());
                bufferedWriter.newLine();
                ++n9;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            return;
        }
        catch (IOException iOException) {
            System.out.print("IO Error " + iOException);
            return;
        }
    }

    public static void main(String[] stringArray) {
        ObjFileHandler.convert(stringArray[0]);
    }

    /*
     * Unable to fully structure code
     */
    public static Polyhedron load(BufferedReader var0) {
        var1_1 = new Vector<Vertex>();
        var2_2 = new Vector<Vector<E>>();
        var3_3 = new Vector<Objects>();
        var4_4 = new Vector<Objects>();
lbl5:
        // 3 sources

        try {
            while ((var5_5 = var0.readLine()) != null) {
                block9: {
                    var6_7 = new StringTokenizer(var5_5);
                    if (!var6_7.hasMoreTokens()) continue;
                    var7_8 = var6_7.nextToken();
                    if (var7_8.equals("v")) {
                        var8_9 = new Double(var6_7.nextToken());
                        var10_14 = new Double(var6_7.nextToken());
                        var12_17 = new Double(var6_7.nextToken());
                        var1_1.addElement(new Vertex(var8_9, -var12_17, var10_14));
                        continue;
                    }
                    if (var7_8.equals("f")) {
                        var8_10 = new Vector<Integer>();
                        while (var6_7.hasMoreTokens()) {
                            var9_12 = var6_7.nextToken();
                            var10_15 = var9_12.indexOf("/");
                            if (var10_15 != -1) {
                                var9_12 = var9_12.substring(0, var10_15);
                            }
                            var11_16 = new Integer(var9_12) - 1;
                            var8_10.addElement(new Integer(var11_16));
                        }
                        var2_2.addElement(var8_10);
                        continue;
                    }
                    if (!var7_8.equals("#se")) break block9;
                    while (var6_7.hasMoreTokens()) {
                        var8_11 = new Integer(var6_7.nextToken());
                        var9_13 = new Integer(var6_7.nextToken());
                        var3_3.addElement(new Objects(new Integer(var8_11), new Integer(var9_13)));
                    }
                    ** GOTO lbl5
                }
                if (!var7_8.equals("#sl")) continue;
                while (var6_7.hasMoreTokens()) {
                    var8_9 = new Double(var6_7.nextToken());
                    var10_14 = new Double(var6_7.nextToken());
                    var12_17 = new Double(var6_7.nextToken());
                    var14_18 = new Double(var6_7.nextToken());
                    var16_19 = new Double(var6_7.nextToken());
                    var18_20 = new Double(var6_7.nextToken());
                    var20_21 = new Vertex(var8_9, -var12_17, var10_14);
                    var21_22 = new Vertex(var14_18, -var18_20, var16_19);
                    var22_23 = new Integer(var6_7.nextToken());
                    var4_4.addElement(new Objects(var20_21, var21_22, var22_23));
                }
                ** GOTO lbl5
            }
            var0.close();
        }
        catch (IOException var5_6) {
            System.out.print("IO Error " + var5_6);
        }
        return new Polyhedron(var1_1, var2_2, var3_3, var4_4);
    }

    public static void save(Polyhedron polyhedron, String string) {
        Object object;
        Serializable serializable;
        Vector<Vertex> vector = new Vector<Vertex>();
        Vector<Object> vector2 = new Vector<Object>();
        int n = 0;
        while (n < polyhedron.n_vertices) {
            serializable = polyhedron.vertices[n];
            vector.addElement((Vertex)serializable);
            ((Vertex)serializable).index = n++;
        }
        n = 0;
        while (n < polyhedron.n_polygons) {
            serializable = polyhedron.polygons[n];
            ((Polygon2)serializable).index = n;
            object = new Vector();
            int n2 = 0;
            while (n2 < ((Polygon2)serializable).n_edges) {
                ((Vector)object).addElement(new Integer(((Polygon2)serializable).get_vertex((int)n2).index + 1));
                ++n2;
            }
            vector2.addElement(object);
            ++n;
        }
        Vector<Objects> vector3 = new Vector<Objects>();
        int n3 = 0;
        while (n3 < polyhedron.n_edges) {
            object = polyhedron.edges[n3];
            if (((Edge)object).sharp) {
                vector3.addElement(new Objects(new Integer(((Edge)object).start.index), new Integer(((Edge)object).end.index)));
            }
            ++n3;
        }
        Vector<SurfaceLine> vector4 = new Vector<SurfaceLine>();
        object = polyhedron.surface_lines.elements();
        while (object.hasMoreElements()) {
            SurfaceLine surfaceLine = (SurfaceLine)object.nextElement();
            vector4.addElement(surfaceLine);
        }
        try {
            Object object2;
            Object object3;
            object = new BufferedWriter(new FileWriter(Teddy.filename(string)));
            int n4 = 0;
            while (n4 < vector.size()) {
                object3 = (Vertex)vector.elementAt(n4);
                object2 = "v " + ((Vector3)object3).x + " " + ((Vector3)object3).z + " " + -((Vector3)object3).y;
                ((BufferedWriter)object).write((String)object2, 0, ((String)object2).length());
                ((BufferedWriter)object).newLine();
                ++n4;
            }
            n4 = 0;
            while (n4 < vector2.size()) {
                object3 = (Vector)vector2.elementAt(n4);
                object2 = "f";
                int n5 = 0;
                while (n5 < ((Vector)object3).size()) {
                    object2 = (String)object2 + " " + ((Integer)((Vector)object3).elementAt(n5)).toString();
                    ++n5;
                }
                ((BufferedWriter)object).write((String)object2, 0, ((String)object2).length());
                ((BufferedWriter)object).newLine();
                ++n4;
            }
            n4 = 0;
            while (n4 < vector4.size()) {
                object3 = "#sl";
                object2 = (SurfaceLine)vector4.elementAt(n4);
                object3 = (String)object3 + " " + ((Edge)object2).start.x + " " + ((Edge)object2).start.z + " " + -((Edge)object2).start.y;
                object3 = (String)object3 + " " + ((Edge)object2).end.x + " " + ((Edge)object2).end.z + " " + -((Edge)object2).end.y;
                object3 = (String)object3 + " " + ((SurfaceLine)object2).polygon.index;
                ((BufferedWriter)object).write((String)object3, 0, ((String)object3).length());
                ((BufferedWriter)object).newLine();
                ++n4;
            }
            String string2 = "#se";
            int n6 = 0;
            while (n6 < vector3.size()) {
                object2 = (Objects)vector3.elementAt(n6);
                string2 = string2 + " " + ((Integer)((Objects)object2).get(0)).toString() + " " + ((Integer)((Objects)object2).get(1)).toString();
                ++n6;
            }
            ((BufferedWriter)object).write(string2, 0, string2.length());
            ((BufferedWriter)object).newLine();
            ((BufferedWriter)object).flush();
            ((BufferedWriter)object).close();
            return;
        }
        catch (IOException iOException) {
            System.out.print("IO Error " + iOException);
            return;
        }
    }
}

