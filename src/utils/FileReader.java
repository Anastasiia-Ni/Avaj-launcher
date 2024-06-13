package src.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private String filePath;
    private List<String> fileContent  = new ArrayList<>();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public FileReader(String path) {
        this.filePath = path;
    }

    public void processFile() throws IOException, MyException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new IOException(ANSI_RED + "File " + filePath + " not found." + ANSI_RESET);
        }

        if (!Files.isReadable(Paths.get(filePath))) {
            throw new IOException(ANSI_RED + "File " + filePath + " not readable." + ANSI_RESET);
        }

        Path path = Paths.get(filePath);
        
        if (Files.size(path) == 0) {
            throw new IOException(ANSI_RED + "File " + filePath + " is empty." + ANSI_RESET);
        }
        
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            long lineCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isBlank()) {
                    fileContent.add(line);
                    lineCount++;
                }
                if (lineCount > Integer.MAX_VALUE) {
                    throw new MyException("File " + filePath + " too big.");
                }
            }
        }

        if (fileContent.size() == 0) {
            throw new IOException(ANSI_RED + "File " + filePath + " does not contain data." + ANSI_RESET);
        }
    }

    public List<String> getContent() {
        return this.fileContent;
    }

}