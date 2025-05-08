/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Bend;
import teddy.Edge2D;
import teddy.Vertex;
import teddy.Vertex2D;

public class Test {
    public static void main(String[] stringArray) {
        Vertex2D vertex2D = new Vertex2D(0.0, 0.0);
        Vertex2D vertex2D2 = new Vertex2D(1.0, 0.0);
        Vertex2D vertex2D3 = new Vertex2D(0.0, 0.0);
        Vertex2D vertex2D4 = new Vertex2D(0.0, 1.0);
        Edge2D edge2D = new Edge2D(vertex2D, vertex2D2);
        Edge2D edge2D2 = new Edge2D(vertex2D3, vertex2D4);
        Vertex vertex = new Vertex(3.0, 4.0, 5.0);
        Vertex vertex2 = Bend.warp_for_an_edge(edge2D, edge2D2, vertex);
        System.out.println(vertex2.toString());
    }
}

