/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import teddy.Def;

public class Node {
    public double x;
    public double y;

    public static double distance(Node node, Node node2) {
        return Math.sqrt((node.x - node2.x) * (node.x - node2.x) + (node.y - node2.y) * (node.y - node2.y));
    }

    public boolean same(Node node) {
        return Def.equal(node.x, this.x) && Def.equal(node.y, this.y);
    }

    Node(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public double distance(Node node) {
        return Math.sqrt((node.x - this.x) * (node.x - this.x) + (node.y - this.y) * (node.y - this.y));
    }
}

