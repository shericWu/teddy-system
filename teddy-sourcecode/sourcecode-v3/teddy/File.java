package teddy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {
   private static Buffer buffer = new Buffer();

   public static Object load(String var0) {
      try {
         FileInputStream var1 = new FileInputStream(var0);
         ObjectInputStream var2 = new ObjectInputStream(var1);
         Object var3 = var2.readObject();
         var1.close();
         return var3;
      } catch (Exception var4) {
         System.out.print("Error: " + var4);
         return null;
      }
   }

   public static void save(String var0, Object var1) {
      try {
         FileOutputStream var2 = new FileOutputStream(var0);
         ObjectOutputStream var3 = new ObjectOutputStream(var2);
         var3.writeObject(var1);
         var3.flush();
         var2.close();
      } catch (Exception var4) {
         System.out.print("Error: " + var4);
      }
   }
}
