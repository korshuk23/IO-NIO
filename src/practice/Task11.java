package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Реализуйте программу, которая считывает содержимое файла,
 * заменяет все вхождения заданного слова на другое слово и
 * записывает измененный текст в новый файл.
 */
public class Task11 {
    public static void main(String[] args) throws IOException {
        String str = Files.readString(Path.of("file.txt"));
        str = str.replaceAll("privet", "poka");

        Files.writeString(Path.of("newFile.txt"), str);

    }
}
