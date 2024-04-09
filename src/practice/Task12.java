package practice;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Напишите программу, которая создает новую папку,
 * перемещает туда все файлы с заданным расширением из
 * текущей папки и удаляет оригинальные файлы.
 */
public class Task12 {
    public static void main(String[] args) throws IOException {
        Path destPath = Files.createDirectories(Path.of("destination"));


        Files.walkFileTree(Path.of("Files"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().endsWith(".txt")) {
                    System.out.println("Файл найден: " + file);
                    Path destFile = destPath.resolve(file.getFileName());
                    Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                    Files.delete(file);
                    System.out.println("Файл скопирован: " + destFile);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Ошибка доступа к файлу: " + file + " - " + exc);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
