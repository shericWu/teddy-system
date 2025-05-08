// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   File.java

package teddy;

import java.io.*;

// Referenced classes of package teddy:
//            Buffer

class ArrayInputStream extends InputStream
{

    public void close()
    {
        System.out.println("in" + buffer.cursor);
    }

    ArrayInputStream(Buffer buffer1)
    {
        buffer = buffer1;
        buffer.read_init();
    }

    public int read()
        throws IOException
    {
        return buffer.read();
    }

    Buffer buffer;
}
