package practice;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
/**
 * Напишите программу, которая считывает содержимое нескольких файлов и объединяет их в один файл.
 * */
public class Task10 {
    public static void main(String[] args) throws IOException {
        Path[] files = new Path[]{
                Path.of("text.txt"), Path.of("copied.txt")
        };
        mergeFile(files, Path.of("file.txt"));
    }

    public static void mergeFile(Path[] files, Path destFile) {
        try (FileChannel dest = FileChannel.open(destFile, StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            for (Path sourceFile : files) {
                try (FileChannel source = FileChannel.open(sourceFile, StandardOpenOption.READ)) {
                    source.transferTo(0, source.size(), dest);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }
}
