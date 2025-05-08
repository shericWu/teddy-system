/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import teddy.Link;

class ListEnumeration
implements Enumeration {
    private Link cursor;

    public Object nextElement() {
        if (this.cursor == null) {
            throw new NoSuchElementException();
        }
        Object object = this.cursor.data;
        this.cursor = this.cursor.next;
        return object;
    }

    public ListEnumeration(Link link) {
        this.cursor = link;
    }

    public boolean hasMoreElements() {
        return this.cursor != null;
    }
}

