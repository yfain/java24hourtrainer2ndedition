import java.io.FileInputStream;
import java.io.IOException;
public class TestFileInputStream {

  public static void main(String[] args) {

	try (FileInputStream myFile = new FileInputStream("abc.dat")){
	        
        boolean eof = false;

        while (!eof) {
            int byteValue = myFile.read();
            System.out.print(byteValue + " ");
            if (byteValue  == -1)
                eof = true;
        }
	  } catch (IOException ioe) {
	           System.out.println("Could not read file: " + 
	                                           ioe.toString());
	  } 
	}
}