import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class HelloServant extends UnicastRemoteObject implements Hello {

  // constructor from super class
  protected HelloServant() throws RemoteException {
  }

  @Override
  public String echo(String message) {
    // do some logic here
    return "From " + getClass().getName() + ", server message: " + message;
  }
}
