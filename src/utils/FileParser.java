package src.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser {
    private String filePath;

    public FileParser(String path) {
        this.filePath = path;
    }

    public void processFile() throws IOException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new IOException("File " + filePath + " not found.");
        }

        if (!Files.isReadable(Paths.get(filePath))) {
            throw new IOException("File " + filePath + " not readable.");
        }

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println("Содержимое файла успешно обработано.");
    }

}