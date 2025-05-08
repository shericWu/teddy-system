/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.IOException;
import java.io.InputStream;
import teddy.Buffer;

class ArrayInputStream
extends InputStream {
    Buffer buffer;

    public void close() {
        System.out.println("in" + this.buffer.cursor);
    }

    ArrayInputStream(Buffer buffer) {
        this.buffer = buffer;
        this.buffer.read_init();
    }

    public int read() throws IOException {
        return this.buffer.read();
    }
}

