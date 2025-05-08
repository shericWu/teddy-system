// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ObjFileHandler.java

package teddy;

import java.io.*;
import java.util.*;

// Referenced classes of package teddy:
//            Teddy, Draw3DScene, Polyhedron, Vertex, 
//            Polygon2, Vector3, Vertex2D, Vector2, 
//            Objects, Edge, LinkedList, SurfaceLine

class ObjFileHandler
{

    ObjFileHandler()
    {
    }

    public static void convert(String s)
    {
        Polyhedron polyhedron = null;
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(Teddy.filename(s)));
            polyhedron = load(bufferedreader);
        }
        catch(IOException ioexception)
        {
            System.out.print("IO Error " + ioexception);
        }
        Draw3DScene.set_front_facing(polyhedron);
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        for(int i = 0; i < polyhedron.n_vertices; i++)
        {
            Vertex vertex = polyhedron.vertices[i];
            vector.addElement(vertex);
            vertex.index = i;
        }

        for(int j = 0; j < polyhedron.n_polygons; j++)
        {
            Polygon2 polygon2 = polyhedron.polygons[j];
            Vector vector2 = new Vector();
            for(int i1 = 0; i1 < polygon2.n_edges; i1++)
                vector2.addElement(new Integer(polygon2.get_vertex(i1).index + 1));

            vector1.addElement(vector2);
        }

        int k = vector.size();
        boolean aflag[] = new boolean[vector.size() + 1];
        for(int l = 0; l < vector.size() + 1; l++)
            aflag[l] = false;

        vector.size();
        Vector vector3 = new Vector();
        for(int j1 = 0; j1 < vector1.size(); j1++)
        {
            Vector vector4 = (Vector)vector1.elementAt(j1);
            Vector vector5 = new Vector();
            vector5.addElement(vector4.elementAt(2));
            vector5.addElement(vector4.elementAt(1));
            vector5.addElement(vector4.elementAt(0));
            vector3.addElement(vector5);
        }

        vector1 = vector3;
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        for(int k1 = 0; k1 < k; k1++)
        {
            Vertex vertex1 = (Vertex)vector.elementAt(k1);
            if(((Vector3) (vertex1)).z < d)
                d = ((Vector3) (vertex1)).z;
            if(((Vector3) (vertex1)).z > d1)
                d1 = ((Vector3) (vertex1)).z;
            if(((Vector3) (vertex1)).x < d2)
                d2 = ((Vector3) (vertex1)).x;
            if(((Vector3) (vertex1)).x > d3)
                d3 = ((Vector3) (vertex1)).x;
        }

        double d4 = d3 - d2;
        double d5 = d1 - d;
        double d6;
        double d7;
        double d8;
        if(d4 > d5)
        {
            d6 = Math.max(d4, d5 * 2D);
            d8 = d5 / d6;
            d7 = 0.0D;
        } else
        {
            d6 = Math.max(d4 * 2D, d5);
            d7 = d4 / d6;
            d8 = 0.0D;
        }
        Vector vector6 = new Vector();
        Vector vector7 = new Vector();
        int ai[] = new int[vector.size() + 1];
        int ai1[] = new int[vector.size() + 1];
        for(int l1 = 0; l1 < vector1.size(); l1++)
        {
            Vector vector8 = (Vector)vector1.elementAt(l1);
            Vector vector9 = new Vector();
            for(int l2 = 0; l2 < vector8.size(); l2++)
            {
                int i3 = ((Integer)vector8.elementAt(l2)).intValue();
                int j3 = ai[i3];
                if(!polyhedron.polygons[l1].front_facing)
                    j3 = ai1[i3];
                if(j3 == 0)
                {
                    Vertex vertex3 = (Vertex)vector.elementAt(i3 - 1);
                    double d9 = (((Vector3) (vertex3)).x - d2) / d6;
                    double d10 = (((Vector3) (vertex3)).z - d) / d6;
                    if(!polyhedron.polygons[l1].front_facing)
                    {
                        d9 += d7;
                        d10 += d8;
                    }
                    d10 = 1.0D - d10;
                    vector6.addElement(new Vertex2D(d9, d10));
                    j3 = vector6.size();
                    if(polyhedron.polygons[l1].front_facing)
                        ai[i3] = j3;
                    else
                        ai1[i3] = j3;
                }
                vector9.addElement(new Integer(j3));
            }

            vector7.addElement(vector9);
        }

        try
        {
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(Teddy.filename_(s)));
            for(int i2 = 0; i2 < vector.size(); i2++)
            {
                Vertex vertex2 = (Vertex)vector.elementAt(i2);
                String s1 = "v " + ((Vector3) (vertex2)).x + " " + ((Vector3) (vertex2)).y + " " + ((Vector3) (vertex2)).z;
                bufferedwriter.write(s1, 0, s1.length());
                bufferedwriter.newLine();
            }

            for(int j2 = 0; j2 < vector6.size(); j2++)
            {
                Vertex2D vertex2d = (Vertex2D)vector6.elementAt(j2);
                String s2 = "vt " + ((Vector2) (vertex2d)).x + " " + ((Vector2) (vertex2d)).y;
                bufferedwriter.write(s2, 0, s2.length());
                bufferedwriter.newLine();
            }

            for(int k2 = 0; k2 < vector1.size(); k2++)
            {
                Vector vector10 = (Vector)vector1.elementAt(k2);
                Vector vector11 = (Vector)vector7.elementAt(k2);
                String s3 = "f";
                for(int k3 = 0; k3 < vector10.size(); k3++)
                {
                    int l3 = ((Integer)vector10.elementAt(k3)).intValue();
                    int i4 = ((Integer)vector11.elementAt(k3)).intValue();
                    s3 = s3 + " " + l3 + "/" + i4 + "";
                }

                bufferedwriter.write(s3, 0, s3.length());
                bufferedwriter.newLine();
            }

            bufferedwriter.flush();
            bufferedwriter.close();
            return;
        }
        catch(IOException ioexception1)
        {
            System.out.print("IO Error " + ioexception1);
        }
    }

    public static void main(String args[])
    {
        convert(args[0]);
    }

    public static Polyhedron load(BufferedReader bufferedreader)
    {
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        try
        {
label0:
            do
            {
                StringTokenizer stringtokenizer;
                String s1;
                do
                {
                    String s = bufferedreader.readLine();
                    if(s == null)
                        break label0;
                    stringtokenizer = new StringTokenizer(s);
                    if(stringtokenizer.hasMoreTokens())
                    {
                        s1 = stringtokenizer.nextToken();
                        if(s1.equals("v"))
                        {
                            double d = (new Double(stringtokenizer.nextToken())).doubleValue();
                            double d2 = (new Double(stringtokenizer.nextToken())).doubleValue();
                            double d4 = (new Double(stringtokenizer.nextToken())).doubleValue();
                            vector.addElement(new Vertex(d, -d4, d2));
                        } else
                        if(s1.equals("f"))
                        {
                            Vector vector4 = new Vector();
                            int l;
                            for(; stringtokenizer.hasMoreTokens(); vector4.addElement(new Integer(l)))
                            {
                                String s2 = stringtokenizer.nextToken();
                                int k = s2.indexOf("/");
                                if(k != -1)
                                    s2 = s2.substring(0, k);
                                l = (new Integer(s2)).intValue() - 1;
                            }

                            vector1.addElement(vector4);
                        } else
                        {
                            if(!s1.equals("#se"))
                                continue;
                            int i;
                            int j;
                            for(; stringtokenizer.hasMoreTokens(); vector2.addElement(new Objects(new Integer(i), new Integer(j))))
                            {
                                i = (new Integer(stringtokenizer.nextToken())).intValue();
                                j = (new Integer(stringtokenizer.nextToken())).intValue();
                            }

                        }
                    }
                    continue label0;
                } while(!s1.equals("#sl"));
                Vertex vertex;
                Vertex vertex1;
                Integer integer;
                for(; stringtokenizer.hasMoreTokens(); vector3.addElement(new Objects(vertex, vertex1, integer)))
                {
                    double d1 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    double d3 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    double d5 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    double d6 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    double d7 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    double d8 = (new Double(stringtokenizer.nextToken())).doubleValue();
                    vertex = new Vertex(d1, -d5, d3);
                    vertex1 = new Vertex(d6, -d8, d7);
                    integer = new Integer(stringtokenizer.nextToken());
                }

            } while(true);
            bufferedreader.close();
        }
        catch(IOException ioexception)
        {
            System.out.print("IO Error " + ioexception);
        }
        return new Polyhedron(vector, vector1, vector2, vector3);
    }

    public static void save(Polyhedron polyhedron, String s)
    {
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        for(int i = 0; i < polyhedron.n_vertices; i++)
        {
            Vertex vertex = polyhedron.vertices[i];
            vector.addElement(vertex);
            vertex.index = i;
        }

        for(int j = 0; j < polyhedron.n_polygons; j++)
        {
            Polygon2 polygon2 = polyhedron.polygons[j];
            polygon2.index = j;
            Vector vector4 = new Vector();
            for(int l = 0; l < polygon2.n_edges; l++)
                vector4.addElement(new Integer(polygon2.get_vertex(l).index + 1));

            vector1.addElement(vector4);
        }

        Vector vector2 = new Vector();
        for(int k = 0; k < polyhedron.n_edges; k++)
        {
            Edge edge = polyhedron.edges[k];
            if(edge.sharp)
                vector2.addElement(new Objects(new Integer(edge.start.index), new Integer(edge.end.index)));
        }

        Vector vector3 = new Vector();
        SurfaceLine surfaceline;
        for(Enumeration enumeration = polyhedron.surface_lines.elements(); enumeration.hasMoreElements(); vector3.addElement(surfaceline))
            surfaceline = (SurfaceLine)enumeration.nextElement();

        try
        {
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(Teddy.filename(s)));
            for(int i1 = 0; i1 < vector.size(); i1++)
            {
                Vertex vertex1 = (Vertex)vector.elementAt(i1);
                String s3 = "v " + ((Vector3) (vertex1)).x + " " + ((Vector3) (vertex1)).z + " " + -((Vector3) (vertex1)).y;
                bufferedwriter.write(s3, 0, s3.length());
                bufferedwriter.newLine();
            }

            for(int j1 = 0; j1 < vector1.size(); j1++)
            {
                Vector vector5 = (Vector)vector1.elementAt(j1);
                String s4 = "f";
                for(int i2 = 0; i2 < vector5.size(); i2++)
                    s4 = s4 + " " + ((Integer)vector5.elementAt(i2)).toString();

                bufferedwriter.write(s4, 0, s4.length());
                bufferedwriter.newLine();
            }

            for(int k1 = 0; k1 < vector3.size(); k1++)
            {
                String s2 = "#sl";
                SurfaceLine surfaceline1 = (SurfaceLine)vector3.elementAt(k1);
                s2 += " " + ((Vector3) (((Edge) (surfaceline1)).start)).x + " " + ((Vector3) (((Edge) (surfaceline1)).start)).z + " " + -((Vector3) (((Edge) (surfaceline1)).start)).y;
                s2 += " " + ((Vector3) (((Edge) (surfaceline1)).end)).x + " " + ((Vector3) (((Edge) (surfaceline1)).end)).z + " " + -((Vector3) (((Edge) (surfaceline1)).end)).y;
                s2 += " " + surfaceline1.polygon.index;
                bufferedwriter.write(s2, 0, s2.length());
                bufferedwriter.newLine();
            }

            String s1 = "#se";
            for(int l1 = 0; l1 < vector2.size(); l1++)
            {
                Objects objects = (Objects)vector2.elementAt(l1);
                s1 += " " + ((Integer)objects.get(0)).toString() + " " + ((Integer)objects.get(1)).toString();
            }

            bufferedwriter.write(s1, 0, s1.length());
            bufferedwriter.newLine();
            bufferedwriter.flush();
            bufferedwriter.close();
            return;
        }
        catch(IOException ioexception)
        {
            System.out.print("IO Error " + ioexception);
        }
    }
}
