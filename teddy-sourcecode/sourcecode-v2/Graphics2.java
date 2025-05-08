// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Graphics2.java

package teddy;

import java.awt.*;

// Referenced classes of package teddy:
//            Vector2

public class Graphics2
{

    static void addPoint(Polygon polygon, Point point, Vector2 vector2)
    {
        polygon.addPoint((int)((double)point.x + vector2.x), (int)((double)point.y + vector2.y));
    }

    public static void drawLine(Graphics g, int i, int j, int k, int l)
    {
        drawWideLine(g, i, j, k, l, 4D);
    }

    public static void drawRandomLine(Graphics g, int i, int j, int k, int l)
    {
        Vector2 vector2 = new Vector2(k - i, l - j);
        Vector2 vector2_1 = vector2.rotate(Math.random() * 60D - 30D).scale(Math.random() * 0.20000000000000001D);
        Vector2 vector2_2 = vector2_1.rotate(180D);
        int i1 = i + (int)vector2_2.x;
        int j1 = j + (int)vector2_2.y;
        int k1 = k + (int)vector2_1.x;
        int l1 = l + (int)vector2_1.y;
        g.drawLine(i1, j1, k1, l1);
    }

    public Graphics2()
    {
    }

    public static void drawWideCircle(Graphics g, int i, int j, int k, int l)
    {
        for(int i1 = k - l / 2; i1 < k + l / 2; i1++)
            g.drawOval(i - i1, j - i1, i1 * 2 - 1, i1 * 2 - 1);

    }

    public static void drawWideLine(Graphics g, double d, double d1, double d2, double d3, double d4)
    {
        drawWideLine(g, (int)d, (int)d1, (int)d2, (int)d3, d4);
    }

    public static void drawWideLine(Graphics g, int i, int j, int k, int l, double d)
    {
        int i1 = k - i;
        int j1 = l - j;
        double d1 = Math.sqrt(i1 * i1 + j1 * j1);
        double d2 = (((double)i1 / d1) * d) / 2D;
        double d3 = (((double)j1 / d1) * d) / 2D;
        Point point = new Point(i, j);
        Point point1 = new Point(k, l);
        Vector2 vector2 = new Vector2(d2, d3);
        Polygon polygon = new Polygon();
        addPoint(polygon, point, vector2.rotate(90D));
        addPoint(polygon, point, vector2.rotate(135D));
        addPoint(polygon, point, vector2.rotate(180D));
        addPoint(polygon, point, vector2.rotate(225D));
        addPoint(polygon, point, vector2.rotate(270D));
        addPoint(polygon, point1, vector2.rotate(270D));
        addPoint(polygon, point1, vector2.rotate(315D));
        addPoint(polygon, point1, vector2.rotate(0.0D));
        addPoint(polygon, point1, vector2.rotate(45D));
        addPoint(polygon, point1, vector2.rotate(90D));
        addPoint(polygon, point, vector2.rotate(90D));
        g.fillPolygon(polygon);
    }
}
