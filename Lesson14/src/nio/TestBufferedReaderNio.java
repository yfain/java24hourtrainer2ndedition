package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;


public class TestBufferedReaderNio {
	public static void main(String[] args){
		Path statesFile = Paths.get("states.txt");

		try (BufferedReader reader = 
				Files.newBufferedReader(statesFile, StandardCharsets.UTF_8)){

	        String stateName;
			while ( (stateName = reader.readLine()) != null ){
				System.out.println("Got the state " + stateName);
			}
			
		} catch (IOException ioe){
			System.out.println("Error while reading states.txt: " + ioe.getMessage());
		}
	}

}
