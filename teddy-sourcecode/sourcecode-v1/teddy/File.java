/*
 * Decompiled with CFR 0.152.
 */
package teddy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import teddy.Buffer;

public class File {
    private static Buffer buffer = new Buffer();

    public static Object load(String string) {
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            fileInputStream.close();
            return object;
        }
        catch (Exception exception) {
            System.out.print("Error: " + exception);
            return null;
        }
    }

    public static void save(String string, Object object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            fileOutputStream.close();
            return;
        }
        catch (Exception exception) {
            System.out.print("Error: " + exception);
            return;
        }
    }
}

