// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   File.java

package teddy;

import java.io.*;

// Referenced classes of package teddy:
//            Buffer

public class File
{

    public File()
    {
    }

    public static Object load(String s)
    {
        try
        {
            FileInputStream fileinputstream = new FileInputStream(s);
            ObjectInputStream objectinputstream = new ObjectInputStream(fileinputstream);
            Object obj = objectinputstream.readObject();
            fileinputstream.close();
            return obj;
        }
        catch(Exception exception)
        {
            System.out.print("Error: " + exception);
        }
        return null;
    }

    public static void save(String s, Object obj)
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
            objectoutputstream.writeObject(obj);
            objectoutputstream.flush();
            fileoutputstream.close();
            return;
        }
        catch(Exception exception)
        {
            System.out.print("Error: " + exception);
        }
    }

    private static Buffer buffer = new Buffer();

}
