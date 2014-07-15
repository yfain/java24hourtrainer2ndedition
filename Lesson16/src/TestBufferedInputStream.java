import java.io.*;
public class TestBufferedInputStream {

	public static void main(String[] args) throws IOException{

	   try (FileInputStream myFile = new  FileInputStream("abc.dat");
		  BufferedInputStream buff = new BufferedInputStream(myFile);){
     
            boolean eof = false;
            while (!eof) {
                int byteValue = buff.read();
                System.out.print(byteValue + " ");
                if (byteValue  == -1)
                    eof = true;
           }
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
