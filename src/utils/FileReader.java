package src.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * FileReader class reads a file from the specified path and processes its content.
 */
public class FileReader {
    private String filePath; // Path to the file
    private List<String> fileContent  = new ArrayList<>(); // Content of the file as a list of lines

    /** Constructs a FileReader object with the specified file path. */
    public FileReader(String path) {
        this.filePath = path;
    }

    /** Processes the file specified by the filePath. */
    public void processFile() throws IOException, MyException {
        // Check if the file exists
        if (!Files.exists(Paths.get(filePath))) {
            throw new IOException("File " + filePath + " not found.");
        }

        // Check if the file is readable
        if (!Files.isReadable(Paths.get(filePath))) {
            throw new IOException("File " + filePath + " not readable.");
        }

        // Get the path object for the file
        Path path = Paths.get(filePath);
        
        // Check if the file is empty
        if (Files.size(path) == 0) {
            throw new IOException("File " + filePath + " is empty.");
        }
        
        // Read the file line by line
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

        // Check if the fileContent list is empty after processing
        if (fileContent.size() == 0) {
            throw new IOException("File " + filePath + " does not contain data.");
        }
    }

    /** Returns the content of the file as a list of strings. */
    public List<String> getContent() {
        return this.fileContent;
    }

}