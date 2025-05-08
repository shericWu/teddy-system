// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Def.java

package teddy;


public class Def
{

    public Def()
    {
    }

    public static final boolean equal(double d, double d1)
    {
        return Math.abs(d - d1) < 1.0000000000000001E-05D;
    }

    public static final boolean negrigible(double d)
    {
        return Math.abs(d) < 1.0000000000000001E-05D;
    }

    public static final double ERROR_RANGE = 1.0000000000000001E-05D;
    public static int NORMALIZED_STROKE_LENGTH_NEW = 20;
    public static int MAXIMUM_STROKE_LENGTH = 40;
    public static int NORMALIZED_STROKE_LENGTH_POP = 10;
    public static double NORMALIZED_EDGE_LENGTH = 0.10000000000000001D;
    public static double MAXIMUM_EDGE_LENGTH = 0.29999999999999999D;
    public static double MINIMUM_EDGE_LENGTH = 0.080000000000000002D;
    public static double GENERATE_HEIGHT = 0.84999999999999998D;

}
