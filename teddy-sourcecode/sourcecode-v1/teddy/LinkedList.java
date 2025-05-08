/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import teddy.Link;
import teddy.ListEnumeration;

public class LinkedList
implements Serializable {
    private Link head;
    private Link tail;
    private Link pre;
    private int len;

    public Object remove() {
        Link link = this.cursor();
        if (link == null) {
            throw new NoSuchElementException();
        }
        if (this.tail == link) {
            this.tail = this.pre;
        }
        if (this.pre != null) {
            this.pre.next = link.next;
        } else {
            this.head = link.next;
        }
        this.len += -1;
        return link.data;
    }

    public void merge(LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            Object e = enumeration.nextElement();
            if (this.member(e)) continue;
            this.append(e);
        }
    }

    public LinkedList cdr() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.elements();
        enumeration.nextElement();
        while (enumeration.hasMoreElements()) {
            linkedList.append(enumeration.nextElement());
        }
        return linkedList;
    }

    public void reset() {
        this.pre = null;
    }

    public Object head() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        return this.head.data;
    }

    public Object nextElement() {
        this.pre = this.pre == null ? this.head : this.pre.next;
        if (this.pre == null) {
            throw new NoSuchElementException();
        }
        return this.pre.data;
    }

    public void substitute(LinkedList linkedList) {
        this.head = linkedList.head;
        this.tail = linkedList.tail;
        this.pre = null;
        this.len = linkedList.len;
    }

    public void replace_head(Object object) {
        this.head.data = object;
    }

    public void insert(Object object) {
        Link link = new Link(object, this.cursor());
        if (this.pre != null) {
            this.pre.next = link;
            if (this.pre == this.tail) {
                this.tail = link;
            }
        } else {
            if (this.head == null) {
                this.tail = link;
            }
            this.head = link;
        }
        this.pre = link;
        ++this.len;
    }

    public boolean hasMoreElements() {
        return this.cursor() != null;
    }

    public int size() {
        return this.len;
    }

    public Enumeration elements() {
        return new ListEnumeration(this.head);
    }

    public LinkedList reverse() {
        Enumeration enumeration = this.elements();
        return this.reverse_sub(enumeration);
    }

    public Object tail() {
        if (this.tail == null) {
            throw new NoSuchElementException();
        }
        return this.tail.data;
    }

    public LinkedList copy() {
        LinkedList linkedList = new LinkedList();
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            linkedList.append(enumeration.nextElement());
        }
        return linkedList;
    }

    public boolean member(Object object) {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            if (object != enumeration.nextElement()) continue;
            return true;
        }
        return false;
    }

    public void print() {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(", " + enumeration.nextElement());
        }
        System.out.println();
    }

    public Object currentElement() {
        Link link = this.cursor();
        if (link == null) {
            throw new NoSuchElementException();
        }
        return link.data;
    }

    public void replace_tail(Object object) {
        this.tail.data = object;
    }

    public LinkedList reverse_sub(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            Object e = enumeration.nextElement();
            LinkedList linkedList = this.reverse_sub(enumeration);
            linkedList.append(e);
            return linkedList;
        }
        return new LinkedList();
    }

    public void append(Object object) {
        Link link = new Link(object, null);
        if (this.head == null) {
            this.head = this.tail = link;
        } else {
            this.tail.next = link;
            this.tail = link;
        }
        ++this.len;
    }

    private Link cursor() {
        if (this.pre == null) {
            return this.head;
        }
        return this.pre.next;
    }

    public void remove(Object object) {
        this.reset();
        while (this.hasMoreElements()) {
            if (object == this.currentElement()) {
                this.remove();
                return;
            }
            this.nextElement();
        }
    }

    public void connect(LinkedList linkedList) {
        Enumeration enumeration = linkedList.elements();
        while (enumeration.hasMoreElements()) {
            this.append(enumeration.nextElement());
        }
    }
}

