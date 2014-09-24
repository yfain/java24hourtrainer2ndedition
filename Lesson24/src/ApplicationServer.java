import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ApplicationServer {

  public static void main(String[] args) throws RemoteException {
    // our server will be registered on port 4321
    Registry registry = LocateRegistry.createRegistry(4321);
    // and we have to look up it by name mentioned here
    registry.rebind("hello", new HelloServant());
  }
}
