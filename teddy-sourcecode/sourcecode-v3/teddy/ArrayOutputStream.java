package teddy;

import java.io.IOException;
import java.io.OutputStream;

class ArrayOutputStream extends OutputStream {
   Buffer buffer;

   public void close() {
      System.out.println("out" + this.buffer.size);
   }

   ArrayOutputStream(Buffer var1) {
      this.buffer = var1;
      this.buffer.write_init();
   }

   public void write(int var1) throws IOException {
      this.buffer.write(var1);
   }
}
