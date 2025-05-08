// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedList.java

package teddy;

import java.util.Enumeration;
import java.util.NoSuchElementException;

// Referenced classes of package teddy:
//            Link

class ListEnumeration
    implements Enumeration
{

    public Object nextElement()
    {
        if(cursor == null)
        {
            throw new NoSuchElementException();
        } else
        {
            Object obj = cursor.data;
            cursor = cursor.next;
            return obj;
        }
    }

    public ListEnumeration(Link link)
    {
        cursor = link;
    }

    public boolean hasMoreElements()
    {
        return cursor != null;
    }

    private Link cursor;
}
