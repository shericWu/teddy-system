/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.IOException;
import java.io.OutputStream;
import teddy.Buffer;

class ArrayOutputStream
extends OutputStream {
    Buffer buffer;

    public void close() {
        System.out.println("out" + this.buffer.size);
    }

    ArrayOutputStream(Buffer buffer) {
        this.buffer = buffer;
        this.buffer.write_init();
    }

    public void write(int n) throws IOException {
        this.buffer.write(n);
    }
}

