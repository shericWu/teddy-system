package teddy;

import java.io.IOException;
import java.io.InputStream;

class ArrayInputStream extends InputStream {
   Buffer buffer;

   public void close() {
      System.out.println("in" + this.buffer.cursor);
   }

   ArrayInputStream(Buffer var1) {
      this.buffer = var1;
      this.buffer.read_init();
   }

   public int read() throws IOException {
      return this.buffer.read();
   }
}
