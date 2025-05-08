// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedList.java

package teddy;

import java.io.Serializable;

class Link
    implements Serializable
{

    Link(Object obj, Link link)
    {
        data = obj;
        next = link;
    }

    Object data;
    Link next;
}
