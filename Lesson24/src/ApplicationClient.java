import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ApplicationClient {

  public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
    // lookup registered remote server
    Hello remoteServer = (Hello) Naming.lookup("rmi://localhost:4321/hello");

    // executing remote method on server
    String message = remoteServer.echo("you got me!!! but i am " + remoteServer.getClass().getName());

    System.out.println("server says: " + message);
  }
}
