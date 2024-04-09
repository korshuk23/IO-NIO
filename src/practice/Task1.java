package practice;

import java.io.*;
/**
 * Напишите программу, которая копирует содержимое одного файла в другой.
 * */
public class Task1 {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("copied.txt")) {
            int a;
            while ((a = fileInputStream.read()) != -1) {
                fileOutputStream.write(a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
