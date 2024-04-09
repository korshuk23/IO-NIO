package practice;

import java.io.*;

/**
 * Напишите программу, которая копирует содержимое одного файла
 * в другой используя классы BufferedReader/Writer,FileReader/Writer.
 */
public class Task3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("copied.txt"))) {
            int i;
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
