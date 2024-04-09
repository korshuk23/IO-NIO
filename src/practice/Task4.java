package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * Создайте программу, которая считывает содержимое файла и выводит его на экран.
 * */
public class Task4 {
    public static void main(String[] args) throws IOException {
        System.out.print((Files.readAllLines(Path.of("file.txt"))));
    }
}
