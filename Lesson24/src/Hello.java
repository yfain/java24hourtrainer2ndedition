import java.rmi.Remote;
import java.rmi.RemoteException;


//this interface intended to be a common protocol of execution between server and client, therefore should be
// accessible from both sides
public interface Hello extends Remote {

  // method for remote execution
  public String echo(String message) throws RemoteException;
}
