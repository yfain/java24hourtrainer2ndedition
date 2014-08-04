import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * User: maxormo
 */
public class ApplicationServer {

  public static void main(String[] args) throws RemoteException {
    Registry registry = LocateRegistry.createRegistry(4321);
    registry.rebind("hello", new HelloServant());
  }
}
