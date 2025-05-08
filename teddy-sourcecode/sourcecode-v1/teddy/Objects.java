/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.Serializable;

public class Objects
implements Serializable {
    private Object[] objects;
    public int size;

    public Object get(int n) {
        return this.objects[n];
    }

    Objects() {
        this.size = 0;
        this.objects = null;
    }

    Objects(Object object, Object object2) {
        this.size = 2;
        this.objects = new Object[2];
        this.objects[0] = object;
        this.objects[1] = object2;
    }

    Objects(Object object, Object object2, Object object3) {
        this.size = 3;
        this.objects = new Object[3];
        this.objects[0] = object;
        this.objects[1] = object2;
        this.objects[2] = object3;
    }

    Objects(Object object, Object object2, Object object3, Object object4) {
        this.size = 4;
        this.objects = new Object[this.size];
        this.objects[0] = object;
        this.objects[1] = object2;
        this.objects[2] = object3;
        this.objects[3] = object4;
    }

    Objects(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        this.size = 6;
        this.objects = new Object[this.size];
        this.objects[0] = object;
        this.objects[1] = object2;
        this.objects[2] = object3;
        this.objects[3] = object4;
        this.objects[4] = object5;
        this.objects[5] = object6;
    }
}

