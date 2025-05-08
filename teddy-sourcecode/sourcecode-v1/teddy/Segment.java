/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.Def;
import teddy.Node;
import teddy.Vector2;

public class Segment
implements Serializable {
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public boolean same(Segment segment) {
        return this.start_node().same(segment.start_node()) && this.end_node().same(segment.end_node()) || this.start_node().same(segment.end_node()) && this.end_node().same(segment.start_node());
    }

    public static double get_distance(Node node, Node node2) {
        return Math.sqrt((node.x - node2.x) * (node.x - node2.x) + (node.y - node2.y) * (node.y - node2.y));
    }

    public boolean online(Node node) {
        return this.distance_line(node) < 1.0E-5;
    }

    public boolean between(Node node) {
        if (Def.equal(this.y1, this.y2)) {
            return node.x >= Math.min(this.x1, this.x2) - 1.0E-5 && node.x <= Math.max(this.x1, this.x2) + 1.0E-5;
        }
        return node.y >= Math.min(this.y1, this.y2) - 1.0E-5 && node.y <= Math.max(this.y1, this.y2) + 1.0E-5;
    }

    public boolean parallel(Segment segment) {
        Vector2 vector2;
        Vector2 vector22 = this.vector();
        double d = vector22.get_sin(vector2 = segment.vector());
        return Math.abs(d) < 1.0E-5;
    }

    public double parallel_interval(Segment segment) {
        Vector2 vector2 = this.vector().normalize();
        Segment segment2 = this.coord_system(vector2);
        Segment segment3 = segment.coord_system(vector2);
        if ((segment2.x1 - segment3.x2) * (segment2.x2 - segment3.x1) < 0.0 || (segment2.x1 - segment3.x2) * (segment2.x2 - segment3.x2) < 0.0 || (segment3.x1 - segment2.x1) * (segment3.x2 - segment2.x1) < 0.0) {
            double d = segment3.y1 - segment2.y1;
            return Math.abs(d);
        }
        return -1.0;
    }

    Segment(double d, double d2, double d3, double d4) {
        this.x1 = d;
        this.y1 = d2;
        this.x2 = d3;
        this.y2 = d4;
    }

    Segment(Node node, Node node2) {
        this.x1 = node.x;
        this.y1 = node.y;
        this.x2 = node2.x;
        this.y2 = node2.y;
    }

    public Vector2 vector() {
        return new Vector2(this.x2 - this.x1, this.y2 - this.y1);
    }

    public Node start_node() {
        return new Node(this.x1, this.y1);
    }

    public Node cross_node(Segment segment) {
        double d = this.y1 - this.y2;
        double d2 = this.x2 - this.x1;
        double d3 = this.y2 * this.x1 - this.x2 * this.y1;
        double d4 = segment.y1 - segment.y2;
        double d5 = segment.x2 - segment.x1;
        double d6 = segment.y2 * segment.x1 - segment.x2 * segment.y1;
        if (Math.abs(d * d5 - d4 * d2) < 1.0E-5) {
            System.out.println("Error in Segment.cross_node().");
            return null;
        }
        double d7 = (d2 * d6 - d5 * d3) / (d * d5 - d4 * d2);
        double d8 = (d * d6 - d4 * d3) / (d4 * d2 - d * d5);
        return new Node(d7, d8);
    }

    public double coords(int n) {
        switch (n) {
            case 0: {
                return this.x1;
            }
            case 1: {
                return this.y1;
            }
            case 2: {
                return this.x2;
            }
            case 3: {
                return this.y2;
            }
        }
        return 0.0;
    }

    public double distance_line(Node node) {
        double d = this.x2 - this.x1;
        double d2 = this.y2 - this.y1;
        double d3 = Math.sqrt(d * d + d2 * d2);
        double d4 = d * (node.y - this.y1) - d2 * (node.x - this.x1);
        if (d3 == 0.0) {
            System.out.println("Error in Segment.distance_line");
            return 0.0;
        }
        return Math.abs(d4 / d3);
    }

    public boolean same_line(Segment segment) {
        return this.online(segment.start_node()) && this.online(segment.end_node());
    }

    public Segment coord_system(Vector2 vector2) {
        double d = this.x1 * vector2.x + this.y1 * vector2.y;
        double d2 = -this.x1 * vector2.y + this.y1 * vector2.x;
        double d3 = this.x2 * vector2.x + this.y2 * vector2.y;
        double d4 = -this.x2 * vector2.y + this.y2 * vector2.x;
        return new Segment(d, d2, d3, d4);
    }

    public double length() {
        return Vector2.distance(this.x1, this.y1, this.x2, this.y2);
    }

    public Node end_node() {
        return new Node(this.x2, this.y2);
    }

    public boolean cross(Segment segment) {
        double d = this.y1 - this.y2;
        double d2 = this.x2 - this.x1;
        double d3 = this.y2 * this.x1 - this.x2 * this.y1;
        double d4 = segment.y1 - segment.y2;
        double d5 = segment.x2 - segment.x1;
        double d6 = segment.y2 * segment.x1 - segment.x2 * segment.y1;
        return (d * segment.x1 + d2 * segment.y1 + d3) * (d * segment.x2 + d2 * segment.y2 + d3) <= 1.0E-5 && (d4 * this.x1 + d5 * this.y1 + d6) * (d4 * this.x2 + d5 * this.y2 + d6) <= 1.0E-5;
    }

    public void configure(Node node, Node node2) {
        this.x1 = node.x;
        this.y1 = node.y;
        this.x2 = node2.x;
        this.y2 = node2.y;
    }

    public double distance(Node node) {
        Vector2 vector2;
        Node node2;
        Node node3 = this.start_node();
        Vector2 vector22 = new Vector2(node3, node2 = this.end_node());
        if (vector22.inner_product(vector2 = new Vector2(node3, node)) < 0.0) {
            return Segment.get_distance(node, node3);
        }
        vector2 = new Vector2(node2, node);
        if (vector22.inner_product(vector2) > 0.0) {
            return Segment.get_distance(node, node2);
        }
        return this.distance_line(node);
    }
}

