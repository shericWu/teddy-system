// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Node.java

package teddy;


// Referenced classes of package teddy:
//            Def

public class Node
{

    public static double distance(Node node, Node node1)
    {
        return Math.sqrt((node.x - node1.x) * (node.x - node1.x) + (node.y - node1.y) * (node.y - node1.y));
    }

    public boolean same(Node node)
    {
        return Def.equal(node.x, x) && Def.equal(node.y, y);
    }

    Node(double d, double d1)
    {
        x = d;
        y = d1;
    }

    public double distance(Node node)
    {
        return Math.sqrt((node.x - x) * (node.x - x) + (node.y - y) * (node.y - y));
    }

    public double x;
    public double y;
}
