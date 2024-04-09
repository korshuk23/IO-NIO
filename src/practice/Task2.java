package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Реализуйте программу, которая записывает в файл текстовую информацию.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] symb = {'a', 'b', 'c'};
        try (FileInputStream fileInputStream = new FileInputStream("file2.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("file2.txt")) {
            for (int c : symb) {
                fileOutputStream.write(c);
            }
            int size = fileInputStream.available();
            for (int i = 0; i < size; i++) {
                System.out.print((char) fileInputStream.read() + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
