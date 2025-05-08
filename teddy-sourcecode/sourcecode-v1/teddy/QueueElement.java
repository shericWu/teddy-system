/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;

class QueueElement
implements Serializable {
    Object data;
    QueueElement next;

    QueueElement(Object object, QueueElement queueElement) {
        this.data = object;
        this.next = queueElement;
    }
}

