// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Test.java

package teddy;

import java.io.PrintStream;

// Referenced classes of package teddy:
//            Vertex2D, Edge2D, Vertex, Bend

public class Test
{

    public Test()
    {
    }

    public static void main(String args[])
    {
        Vertex2D vertex2d = new Vertex2D(0.0D, 0.0D);
        Vertex2D vertex2d1 = new Vertex2D(1.0D, 0.0D);
        Vertex2D vertex2d2 = new Vertex2D(0.0D, 0.0D);
        Vertex2D vertex2d3 = new Vertex2D(0.0D, 1.0D);
        Edge2D edge2d = new Edge2D(vertex2d, vertex2d1);
        Edge2D edge2d1 = new Edge2D(vertex2d2, vertex2d3);
        Vertex vertex = new Vertex(3D, 4D, 5D);
        Vertex vertex1 = Bend.warp_for_an_edge(edge2d, edge2d1, vertex);
        System.out.println(vertex1.toString());
    }
}
