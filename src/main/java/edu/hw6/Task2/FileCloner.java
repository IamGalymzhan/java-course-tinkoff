package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCloner {
    private FileCloner() {
    }

    public static void cloneFile(Path path) {
        String fileFullName = path.getFileName().toString();
        String fileName = fileFullName.substring(0, fileFullName.lastIndexOf('.'));
        String fileExt = fileFullName.substring(fileFullName.lastIndexOf('.'));
        Path parentPath = path.getParent();
        String file = fileName + " - копия" + fileExt;
        int i = 2;
        while (Files.exists(parentPath.resolve(file))) {
            file = fileName + " - копия (" + i++ + ")" + fileExt;
        }
        try {
            Files.createFile(parentPath.resolve(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
