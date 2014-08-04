import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * User: maxormo
 */
public class ApplicationClient {

  public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
    Hello remoteServer = (Hello) Naming.lookup("rmi://localhost:4321/hello");

    System.out.println("server says: " + remoteServer.echo("you got me!!! but i am " + remoteServer.getClass().getName()));
  }
}
