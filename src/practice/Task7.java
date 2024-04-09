package practice;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Напишите программу, которая копирует содержимое одного файла
 * в другой с использованием класса java.nio.channels.FileChannel.
 */
public class Task7 {
    public static void main(String[] args) throws IOException {
        try (FileChannel ch1 = FileChannel.open(Paths.get("file.txt"), StandardOpenOption.READ);
             FileChannel ch2 = FileChannel.open(Paths.get("copied.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ch1.transferTo(0, ch1.size(), ch2);
        }
    }
}
