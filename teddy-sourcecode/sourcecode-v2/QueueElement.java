// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Queue.java

package teddy;

import java.io.Serializable;

class QueueElement
    implements Serializable
{

    QueueElement(Object obj, QueueElement queueelement)
    {
        data = obj;
        next = queueelement;
    }

    Object data;
    QueueElement next;
}
