/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;

class Link
implements Serializable {
    Object data;
    Link next;

    Link(Object object, Link link) {
        this.data = object;
        this.next = link;
    }
}

