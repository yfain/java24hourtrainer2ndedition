import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: maxormo
 */
public interface Hello extends Remote {

  public String echo(String message) throws RemoteException;
}
