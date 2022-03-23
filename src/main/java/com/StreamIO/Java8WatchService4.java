package com.StreamIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class Java8WatchService4 {
	
	private static final Kind<?> ENTRY_DELETE = null;
	private static final Kind<?> ENTRY_MODIFY = null;
	private static final Kind<?> ENTRY_CREATE = null;
	private final WatchService watcher;
	private final Map<WatchKey, Path> dirWatchers;

	/**
	 * Created a Watch Service method to watch particular directory along with all
	 * Files and Sub Directories
	 * 
	 * @param dir -passing parameter as path directory
	 * @throws IOException -throws exception
	 */
	public Java8WatchService4(Path dir) throws IOException {
		this.watcher = FileSystems.getDefault().newWatchService();
		this.dirWatchers = new HashMap<WatchKey, Path>();
		scanAndRegisterDirectories(dir);
	}

	/**
	 * created method to Register given directory with watch service
	 * 
	 * @param dir -passing parameter as path directory
	 * @throws IOException -throws exception
	 */
	private void registerDirWatchers(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		dirWatchers.put(key, dir);
	}

	/**
	 * registered directory and sub directories
	 * 
	 * @param start
	 * @throws IOException
	 */
	private void scanAndRegisterDirectories(final Path start) throws IOException {
		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				registerDirWatchers(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * created method for processing the events
	 */
	public void processEvents() {
		while (true) {
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}
			Path dir = dirWatchers.get(key);
			if (dir == null)
				continue;
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind kind = event.kind();
				Path name = ((WatchEvent<Path>) event).context();
				Path child = dir.resolve(name);
				System.out.format("%s : %s\n", event.kind().name(), child);

				if (kind == ENTRY_CREATE) {
					try {
						if (Files.isDirectory(child))
							scanAndRegisterDirectories(child);
					} catch (IOException x) {
					}
				} else if (kind.equals(ENTRY_DELETE)) {
					if (Files.isDirectory(child))
						dirWatchers.remove(key);
				}

			}
			boolean valid = key.reset();
			if (!valid) {
				dirWatchers.remove(key);
				if (dirWatchers.isEmpty())
					break;
			}
		}
	}
}
