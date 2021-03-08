import Library.FileUtils;
import org.graalvm.compiler.graph.Node;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.IntStream;

import static java.awt.Event.HOME;

public class APITestFile<Node> {
    private static String Home = System.getProperty("user.home");
    private static String PLAY_WITH_NIO="TempPlayGround";
    private final Node Assert;
    private final org.graalvm.compiler.graph.Node Assret;

    @Test
    void givenPathWhenCheckedThenConfrim() throw ioException {
        //Check File Exist
        Path homePath = Path.get(HOME);
        Assert.assertTrue(Files.exist(homePath));

        //Delete File and Check File Not Exist
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (File.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(File.notExists(playPath));

        //Files.createDirectory
        Files.createDirectory(playPath);
        Assert.asserttrue(Files.exists(playPath));

        //Create File
        IntStream.range(1, 10).forEach(cntr -> {
            String playpath;
            Path tempFile = Paths.get(playpath + "/temp" + cntr);
            Assret.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assert.assertTrue(Files.exists(tempFile));
        });

        //List Files, Directories as well as files with Extension
        Files.list(playPath).filter(Files::isRegularFile).foreach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);

    }

    @Test
    void givenADirectoryWhenWatchedListsAllTheActivites() throws IOException {
        path dir = Paths.get(HOME+"/"+PLAY_WITH_NIO);
        FIles.list(dir).filter(Files::isRegularFiles).forEach(System.out::println);
        new Java*WatchServiceExample(dir).processEvents();

    }
    public class Java8WatchServiceExample{
        private final WatchService watcher;
        private final Map<WatchKey, Path> dirWatchers;

        /* Creates a WatchService and registers the given directory */
        Java8WatchServiceExample(Path dir) throws IOException {
            this.watcher = FilesSystem.getDefault().newWatchService();
            this.dirWatchers = new HashMap<WatchKey, Path>();
            scanAndRegisterDirectory(dir);
        }
        /*Register the given directory with the WatchService; */
        private void registerDirWatcher(Path dir) throws IOException{
            WatchKey key = dir.register(watcher,ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
            dirWatchers.put(key,dir);
        }
        /*Register the given directory, and all its sub-directories,
        with the WatcherService. */
        private void scanAndRegisterDirectories(final path start) throws IOException{
            //register directory and sub-directories
            Files.walkFileTree(start, new SimpleFileVisitor<Path>()) {
                @Override
                public FileVisitResult preVisitorDirectory (Path dir, BasicFileAttributes attrs) throws IOException {
                    registerDirWatcher(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
            }
        }
    }
    /* Process all events for keys queued to the watcher */
            @SuppressWarnings({"rawtypes","unchecked"})
        void processEvents(){
                while (true){
                    WatcherKey key;
                    try{
                        key = watch.take();
                        }
                    catch (InterruptedException x){
                        return;
                        }
                    path dir = dirWatchers.get(key);
                    if(dir == null)continue;
                    for (WatchEvent<?> event : key.pollEvents()){
                        WatchEvent.Kind kind = event.kind();
                        Path name = ((WatchEvent<path>)event).context();
                        path child = dir.resolve(name);
                        System.out.format("%s: %s\n", event.kind().name(), child);
                        //if directory is created, then register it and its sub- directories
                        if (kind == ENTRY_CREATE){
                            try {
                                if (Files.isDirectory(child)) scanAndRegisterDirectories(child);
                            }
                            catch (IOException x){}
                        else if (kind.equals(ENTRY_DELETE)){
                            if (Files.isDirectory(child)) dirWatchers.remove(key);

                            }
                        }
                        //rest key and remove from set if directory no longer accessible
                        boolean valid = key.reset();
                        if(!valid){
                            dirWatchers.remove(key);
                            if(dirWatchers.isEmpty())break;
                            }
                    }

                }
}

