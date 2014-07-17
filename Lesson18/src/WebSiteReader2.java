import java.net.*;
import java.io.*;
public class WebSiteReader2 {
  public static void main(String args[]){
       String nextLine;
       URL url = null;
       URLConnection urlConn = null;
       InputStreamReader  inStream = null;
       BufferedReader buff = null;
       try{
         // index.html is a default URL's  file name  
          url  = new URL("http://finance.yahoo.com/q?s=MOT" );
          urlConn = url.openConnection();
         inStream = new InputStreamReader( 
                           urlConn.getInputStream());
           buff  = new BufferedReader(inStream);
        
      // Read the entire trading information about Motorolla
      // into a String variable
        String theWholePage=null;
        String currentLine;
        while ((currentLine=buff.readLine()) !=null){
             theWholePage+=currentLine; 
         }
         System.out.println(theWholePage);
     } catch(MalformedURLException e){
       System.out.println("Please check the URL:" + 
                                           e.toString() );
     } catch(IOException  e1){
      System.out.println("Can't read  from the Internet: "+ 
                                          e1.toString() ); 
  }
 }
}
