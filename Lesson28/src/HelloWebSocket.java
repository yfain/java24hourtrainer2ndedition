
import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

@ServerEndpoint("/hello")
public class HelloWebSocket {
	
   @OnOpen
   public void greetTheClient(Session session){
	   try {
		session.getBasicRemote().sendText("Hello stranger");
		
	} catch (IOException ioe) {
		System.out.println(ioe.getMessage());
	}
   }
}
