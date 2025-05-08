/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.IOException;

class Buffer {
    public byte[] data = new byte[1000000];
    public int size = 0;
    public int cursor = 0;
    public int max = 1000000;

    Buffer() {
    }

    public int read() throws IOException {
        int n;
        if (this.cursor == this.size) {
            return -1;
        }
        if ((n = this.data[this.cursor++]) < 0) {
            n = 256 + n;
        }
        return n;
    }

    public void write_init() {
        this.size = 0;
    }

    public void write(int n) throws IOException {
        if (this.size == this.max) {
            System.exit(0);
        }
        this.data[this.size++] = (byte)n;
    }

    public void read_init() {
        this.cursor = 0;
    }
}

