import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;


enum FileUtils {
	;

	static void deleteFiles(File file) {
		// TODO Auto-generated method stub
		
	}

}



public class FileOperationTest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
	
	@Test
	public void givenPathWhenCheckThenConfirm() throws IOException{
		//Check File Exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		
		//Delete File and Check File Not Exist
		Path playPath = Paths.get(HOME+"/"+PLAY_WITH_NIO);
		if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));
		
		//Create Directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(playPath));
		
		//Create File
		InStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp"+cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {Files.createFile(tempFile);}
			catch (IOException e) { }
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//List Files, Directories as well as Files with Extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && 
													path.toString().startsWith("temp")).forEach(System.out::println);
		
	}
}
