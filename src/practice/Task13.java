package practice;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Реализуйте программу, которая переименовывает файлы в папке,
 * добавляя к их именам префикс или суффикс.
 */
public class Task13 {
    public static void main(String[] args) throws IOException {
        String prefix = "prefix";

        Files.walkFileTree(Path.of("Files"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String getName = file.getFileName().toString().replaceFirst("[.][^.]+$", "");
                String newName = prefix + getName + getFileExtension(file);
                Path renameFile = file.resolveSibling(newName);
                Files.move(file, renameFile, StandardCopyOption.REPLACE_EXISTING);

                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static String getFileExtension(Path file) {
        int index = file.getFileName().toString().indexOf(".");
        return file.getFileName().toString().substring(index);
    }
}
