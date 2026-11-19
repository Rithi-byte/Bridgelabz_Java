package javaFileIO;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a Watch Service to
 * watch particular directory
 * along with all Files and
 * Sub Directories - Using File IO Count Number of Entries
 * in the File
 */
public class DirectoryWatchService {

    private static WatchService watchService;
    private static Map<WatchKey, Path> watchKeys = new HashMap<>();

    // Register a directory and all its subdirectories
    private static void registerDirectory(Path directory) throws IOException {

        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(
                    Path dir, BasicFileAttributes attrs) throws IOException {

                WatchKey key = dir.register(
                        watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY
                );

                watchKeys.put(key, dir);

                System.out.println("Watching: " + dir);

                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get("MyFolder");

        // Create directory if it does not exist
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        // Create WatchService
        watchService = FileSystems.getDefault().newWatchService();

        // Register root directory and existing subdirectories
        registerDirectory(directory);

        System.out.println("\nWatching directory for changes...");

        while (true) {

            WatchKey key;

            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            Path currentDirectory = watchKeys.get(key);

            if (currentDirectory == null) {
                key.reset();
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {

                WatchEvent.Kind<?> kind = event.kind();

                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    System.out.println("Events may have been lost");
                    continue;
                }

                Path fileName = (Path) event.context();
                Path fullPath = currentDirectory.resolve(fileName);

                System.out.println(kind.name() + ": " + fullPath);

                // Register newly created directories and their subdirectories
                if (kind == StandardWatchEventKinds.ENTRY_CREATE
                        && Files.isDirectory(fullPath)) {

                    try {
                        registerDirectory(fullPath);
                    } catch (IOException e) {
                        System.out.println("Unable to watch: " + fullPath);
                    }
                }
            }

            // Remove invalid watch keys
            if (!key.reset()) {
                watchKeys.remove(key);
            }
        }

        watchService.close();
    }
}
