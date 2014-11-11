import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardCopyOption.*;


public class TestFilesPaths {

  public static void main(String[] args) {

	// Get the path to the file states.txt located in dir
	// this program was launched from	
	Path sourceFilePath = Paths.get("states.txt");
	
	// Will copy the source file to this destination 
	Path destFilePath = Paths.get("states.bak");
	
	if (Files.exists(sourceFilePath)){
		System.out.println("The file  " + sourceFilePath + " exists");
		System.out.println("The absolute path is " + sourceFilePath.toAbsolutePath());
		
		try{
		// Check the file size (in bytes)
		System.out.println("It's size is " + Files.size(sourceFilePath));
		
		// Copy the file from states.txt to states.bak
		Files.copy(sourceFilePath, destFilePath, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Copy completed. The backup file is at " + destFilePath.toAbsolutePath());		
		
		} catch(IOException ioe){
			ioe.printStackTrace();
		}	
	}
  }
}
