package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static boolean checkFileExists(String filePath) {
        return new File(filePath).exists();
    }

    public static void createDirectory(String dirPath) {
        try {
            Files.createDirectories(Paths.get(dirPath));
        } catch (IOException e) {
            System.err.println("Failed to create directory structure: " + e.getMessage());
        }
    }
}
