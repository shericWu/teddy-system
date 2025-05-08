// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedList.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.NoSuchElementException;

// Referenced classes of package teddy:
//            Link, ListEnumeration

public class LinkedList
    implements Serializable
{

    public Object remove()
    {
        Link link = cursor();
        if(link == null)
            throw new NoSuchElementException();
        if(tail == link)
            tail = pre;
        if(pre != null)
            pre.next = link.next;
        else
            head = link.next;
        len--;
        return link.data;
    }

    public void merge(LinkedList linkedlist)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Object obj = enumeration.nextElement();
            if(!member(obj))
                append(obj);
        }

    }

    public LinkedList cdr()
    {
        LinkedList linkedlist = new LinkedList();
        Enumeration enumeration = elements();
        enumeration.nextElement();
        for(; enumeration.hasMoreElements(); linkedlist.append(enumeration.nextElement()));
        return linkedlist;
    }

    public void reset()
    {
        pre = null;
    }

    public Object head()
    {
        if(head == null)
            throw new NoSuchElementException();
        else
            return head.data;
    }

    public Object nextElement()
    {
        if(pre == null)
            pre = head;
        else
            pre = pre.next;
        if(pre == null)
            throw new NoSuchElementException();
        else
            return pre.data;
    }

    public void substitute(LinkedList linkedlist)
    {
        head = linkedlist.head;
        tail = linkedlist.tail;
        pre = null;
        len = linkedlist.len;
    }

    public void replace_head(Object obj)
    {
        head.data = obj;
    }

    public LinkedList()
    {
    }

    public void insert(Object obj)
    {
        Link link = new Link(obj, cursor());
        if(pre != null)
        {
            pre.next = link;
            if(pre == tail)
                tail = link;
        } else
        {
            if(head == null)
                tail = link;
            head = link;
        }
        pre = link;
        len++;
    }

    public boolean hasMoreElements()
    {
        return cursor() != null;
    }

    public int size()
    {
        return len;
    }

    public Enumeration elements()
    {
        return new ListEnumeration(head);
    }

    public LinkedList reverse()
    {
        Enumeration enumeration = elements();
        return reverse_sub(enumeration);
    }

    public Object tail()
    {
        if(tail == null)
            throw new NoSuchElementException();
        else
            return tail.data;
    }

    public LinkedList copy()
    {
        LinkedList linkedlist = new LinkedList();
        for(Enumeration enumeration = elements(); enumeration.hasMoreElements(); linkedlist.append(enumeration.nextElement()));
        return linkedlist;
    }

    public boolean member(Object obj)
    {
        for(Enumeration enumeration = elements(); enumeration.hasMoreElements();)
            if(obj == enumeration.nextElement())
                return true;

        return false;
    }

    public void print()
    {
        for(Enumeration enumeration = elements(); enumeration.hasMoreElements(); System.out.print(", " + enumeration.nextElement()));
        System.out.println();
    }

    public Object currentElement()
    {
        Link link = cursor();
        if(link == null)
            throw new NoSuchElementException();
        else
            return link.data;
    }

    public void replace_tail(Object obj)
    {
        tail.data = obj;
    }

    public LinkedList reverse_sub(Enumeration enumeration)
    {
        if(enumeration.hasMoreElements())
        {
            Object obj = enumeration.nextElement();
            LinkedList linkedlist = reverse_sub(enumeration);
            linkedlist.append(obj);
            return linkedlist;
        } else
        {
            return new LinkedList();
        }
    }

    public void append(Object obj)
    {
        Link link = new Link(obj, null);
        if(head == null)
        {
            head = tail = link;
        } else
        {
            tail.next = link;
            tail = link;
        }
        len++;
    }

    private Link cursor()
    {
        if(pre == null)
            return head;
        else
            return pre.next;
    }

    public void remove(Object obj)
    {
        reset();
        for(; hasMoreElements(); nextElement())
            if(obj == currentElement())
            {
                remove();
                return;
            }

    }

    public void connect(LinkedList linkedlist)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); append(enumeration.nextElement()));
    }

    private Link head;
    private Link tail;
    private Link pre;
    private int len;
}
