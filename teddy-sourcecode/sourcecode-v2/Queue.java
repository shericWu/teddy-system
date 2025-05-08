// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Queue.java

package teddy;

import java.io.Serializable;

// Referenced classes of package teddy:
//            QueueElement

public class Queue
    implements Serializable
{

    public Object pop()
    {
        if(head == null)
        {
            return null;
        } else
        {
            Object obj = head.data;
            head = head.next;
            len--;
            return obj;
        }
    }

    Queue()
    {
        head = null;
        tail = null;
        len = 0;
    }

    public int size()
    {
        return len;
    }

    public void push(Object obj)
    {
        QueueElement queueelement = new QueueElement(obj, null);
        if(head == null)
        {
            head = tail = queueelement;
        } else
        {
            tail.next = queueelement;
            tail = queueelement;
        }
        len++;
    }

    private QueueElement head;
    private QueueElement tail;
    private int len;
}
