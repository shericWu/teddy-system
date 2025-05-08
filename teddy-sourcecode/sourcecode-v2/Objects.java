// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Objects.java

package teddy;

import java.io.Serializable;

public class Objects
    implements Serializable
{

    public Object get(int i)
    {
        return objects[i];
    }

    Objects()
    {
        size = 0;
        objects = null;
    }

    Objects(Object obj, Object obj1)
    {
        size = 2;
        objects = new Object[2];
        objects[0] = obj;
        objects[1] = obj1;
    }

    Objects(Object obj, Object obj1, Object obj2)
    {
        size = 3;
        objects = new Object[3];
        objects[0] = obj;
        objects[1] = obj1;
        objects[2] = obj2;
    }

    Objects(Object obj, Object obj1, Object obj2, Object obj3)
    {
        size = 4;
        objects = new Object[size];
        objects[0] = obj;
        objects[1] = obj1;
        objects[2] = obj2;
        objects[3] = obj3;
    }

    Objects(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        size = 6;
        objects = new Object[size];
        objects[0] = obj;
        objects[1] = obj1;
        objects[2] = obj2;
        objects[3] = obj3;
        objects[4] = obj4;
        objects[5] = obj5;
    }

    private Object objects[];
    public int size;
}
