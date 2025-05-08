// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   File.java

package teddy;

import java.io.*;

// Referenced classes of package teddy:
//            Buffer

class ArrayOutputStream extends OutputStream
{

    public void close()
    {
        System.out.println("out" + buffer.size);
    }

    ArrayOutputStream(Buffer buffer1)
    {
        buffer = buffer1;
        buffer.write_init();
    }

    public void write(int i)
        throws IOException
    {
        buffer.write(i);
    }

    Buffer buffer;
}
