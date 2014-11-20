import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


class FileDownload{

  public static void main(String args[]){
    if (args.length!=2){
      System.out.println(
        "Proper Usage: java FileDownload SourceFileURL OutputFileName");
      System.out.println(
    	"For example:java FileDownload http://myflex.org/yf/nyc.jpg nyc.jpg");
      System.exit(-1);
    }

    URLConnection fileStream=null;
  try{
	    URL remoteFile=new URL(args[0]);
	    fileStream=remoteFile.openConnection();
  } catch (IOException ioe){
	  ioe.printStackTrace();
  }

  try(  FileOutputStream fOut=new FileOutputStream(args[1]);
		InputStream in = fileStream.getInputStream();){

    // Read a remote file and save it in the local one
    int data;
    System.out.println("Starting the download from " + args[0]);
    while((data=in.read())!=-1){
         fOut.write(data);
    }  
    System.out.println("Finished downloading the file " + args[1]);
  } catch (Exception e){
     e.printStackTrace();
  } 
 }
}
