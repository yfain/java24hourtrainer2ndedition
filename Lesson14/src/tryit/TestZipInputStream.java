package tryit;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestZipInputStream {

	public static void main(String[] args) {
		
		ZipEntry ze = null;
		
		try (FileInputStream myFile = new FileInputStream("Lesson14.zip");
				BufferedInputStream	buff = new BufferedInputStream(myFile);
				ZipInputStream zipFile = new ZipInputStream(buff);){
			
			while ((ze = zipFile.getNextEntry()) != null) {
				System.out.println(ze.getName());
				zipFile.closeEntry();
			}

		} catch (IOException e) {
			System.out.println("Could not read file: " + e.toString());
		} 
	}
}
