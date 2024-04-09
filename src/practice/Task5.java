package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Реализуйте программу, которая записывает в файл текстовую информацию, введенную пользователем.
 */
public class Task5 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to write: ");
        String text = scanner.nextLine();

        Path path = Paths.get("file2.txt");
        Files.writeString(path, text);
        System.out.println("Done!");
    }
}
