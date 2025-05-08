/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import teddy.Vector2;

public class Graphics2 {
    static void addPoint(Polygon polygon, Point point, Vector2 vector2) {
        polygon.addPoint((int)((double)point.x + vector2.x), (int)((double)point.y + vector2.y));
    }

    public static void drawLine(Graphics graphics, int n, int n2, int n3, int n4) {
        Graphics2.drawWideLine(graphics, n, n2, n3, n4, 4.0);
    }

    public static void drawRandomLine(Graphics graphics, int n, int n2, int n3, int n4) {
        Vector2 vector2 = new Vector2(n3 - n, n4 - n2);
        Vector2 vector22 = vector2.rotate(Math.random() * 60.0 - 30.0).scale(Math.random() * 0.2);
        Vector2 vector23 = vector22.rotate(180.0);
        int n5 = n + (int)vector23.x;
        int n6 = n2 + (int)vector23.y;
        int n7 = n3 + (int)vector22.x;
        int n8 = n4 + (int)vector22.y;
        graphics.drawLine(n5, n6, n7, n8);
    }

    public static void drawWideCircle(Graphics graphics, int n, int n2, int n3, int n4) {
        int n5 = n3 - n4 / 2;
        while (n5 < n3 + n4 / 2) {
            graphics.drawOval(n - n5, n2 - n5, n5 * 2 - 1, n5 * 2 - 1);
            ++n5;
        }
    }

    public static void drawWideLine(Graphics graphics, double d, double d2, double d3, double d4, double d5) {
        Graphics2.drawWideLine(graphics, (int)d, (int)d2, (int)d3, (int)d4, d5);
    }

    public static void drawWideLine(Graphics graphics, int n, int n2, int n3, int n4, double d) {
        int n5 = n3 - n;
        int n6 = n4 - n2;
        double d2 = Math.sqrt(n5 * n5 + n6 * n6);
        double d3 = (double)n5 / d2 * d / 2.0;
        double d4 = (double)n6 / d2 * d / 2.0;
        Point point = new Point(n, n2);
        Point point2 = new Point(n3, n4);
        Vector2 vector2 = new Vector2(d3, d4);
        Polygon polygon = new Polygon();
        Graphics2.addPoint(polygon, point, vector2.rotate(90.0));
        Graphics2.addPoint(polygon, point, vector2.rotate(135.0));
        Graphics2.addPoint(polygon, point, vector2.rotate(180.0));
        Graphics2.addPoint(polygon, point, vector2.rotate(225.0));
        Graphics2.addPoint(polygon, point, vector2.rotate(270.0));
        Graphics2.addPoint(polygon, point2, vector2.rotate(270.0));
        Graphics2.addPoint(polygon, point2, vector2.rotate(315.0));
        Graphics2.addPoint(polygon, point2, vector2.rotate(0.0));
        Graphics2.addPoint(polygon, point2, vector2.rotate(45.0));
        Graphics2.addPoint(polygon, point2, vector2.rotate(90.0));
        Graphics2.addPoint(polygon, point, vector2.rotate(90.0));
        graphics.fillPolygon(polygon);
    }
}

