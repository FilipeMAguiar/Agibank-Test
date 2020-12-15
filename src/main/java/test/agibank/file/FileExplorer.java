package test.agibank.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class FileExplorer {
    public static List<Path> searchFilePaths(Properties properties) throws IOException {
        return Files.list(Paths.get(properties.getProperty("INPUT_FILE_PATH")))
                .filter(path -> path.toFile().isFile())
                .collect(Collectors.toList());
    }
}
