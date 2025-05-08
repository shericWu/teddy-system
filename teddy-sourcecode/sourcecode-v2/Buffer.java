// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   File.java

package teddy;

import java.io.IOException;

class Buffer
{

    Buffer()
    {
        max = 0xf4240;
        data = new byte[0xf4240];
        size = 0;
        cursor = 0;
    }

    public int read()
        throws IOException
    {
        if(cursor == size)
            return -1;
        int i = data[cursor++];
        if(i < 0)
            i = 256 + i;
        return i;
    }

    public void write_init()
    {
        size = 0;
    }

    public void write(int i)
        throws IOException
    {
        if(size == max)
            System.exit(0);
        data[size++] = (byte)i;
    }

    public void read_init()
    {
        cursor = 0;
    }

    public byte data[];
    public int size;
    public int cursor;
    public int max;
}
