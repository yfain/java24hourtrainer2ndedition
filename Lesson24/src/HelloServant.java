import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: maxormo
 */
public class HelloServant extends UnicastRemoteObject implements Hello {
  protected HelloServant() throws RemoteException {
  }

  @Override
  public String echo(String message) {
    return "From " + getClass().getName() + "server: " + message;
  }
}
