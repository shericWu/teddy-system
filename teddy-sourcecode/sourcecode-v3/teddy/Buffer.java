package teddy;

import java.io.IOException;

class Buffer {
   public byte[] data;
   public int size;
   public int cursor;
   public int max = 1000000;

   Buffer() {
      this.data = new byte[1000000];
      this.size = 0;
      this.cursor = 0;
   }

   public int read() throws IOException {
      if (this.cursor == this.size) {
         return -1;
      } else {
         short var1 = this.data[this.cursor++];
         if (var1 < 0) {
            var1 += 256;
         }

         return var1;
      }
   }

   public void write_init() {
      this.size = 0;
   }

   public void write(int var1) throws IOException {
      if (this.size == this.max) {
         System.exit(0);
      }

      this.data[this.size++] = (byte)var1;
   }

   public void read_init() {
      this.cursor = 0;
   }
}
