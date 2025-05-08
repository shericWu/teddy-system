/*
 * Decompiled with CFR 0.152.
 */
package teddy;

public class Def {
    public static final double ERROR_RANGE = 1.0E-5;
    public static int NORMALIZED_STROKE_LENGTH_NEW = 20;
    public static int MAXIMUM_STROKE_LENGTH = 40;
    public static int NORMALIZED_STROKE_LENGTH_POP = 10;
    public static double NORMALIZED_EDGE_LENGTH = 0.1;
    public static double MAXIMUM_EDGE_LENGTH = 0.3;
    public static double MINIMUM_EDGE_LENGTH = 0.08;
    public static double GENERATE_HEIGHT = 0.85;

    public static final boolean equal(double d, double d2) {
        return Math.abs(d - d2) < 1.0E-5;
    }

    public static final boolean negrigible(double d) {
        return Math.abs(d) < 1.0E-5;
    }
}

