/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;
import teddy.QueueElement;

public class Queue
implements Serializable {
    private QueueElement head = null;
    private QueueElement tail = null;
    private int len = 0;

    public Object pop() {
        if (this.head == null) {
            return null;
        }
        Object object = this.head.data;
        this.head = this.head.next;
        this.len += -1;
        return object;
    }

    Queue() {
    }

    public int size() {
        return this.len;
    }

    public void push(Object object) {
        QueueElement queueElement = new QueueElement(object, null);
        if (this.head == null) {
            this.head = this.tail = queueElement;
        } else {
            this.tail.next = queueElement;
            this.tail = queueElement;
        }
        ++this.len;
    }
}

