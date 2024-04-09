package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Создайте программу, которая считывает содержимое файла
 * с использованием класса java.nio.file.Path и выводит его на экран.
 */
public class Task6 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("file.txt");
        String text = Files.readString(path);
        System.out.println(text);
    }
}
