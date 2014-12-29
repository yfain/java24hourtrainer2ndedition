package publish;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

@ServerEndpoint("/clock")
public class WebSocketClock {
	
	static ScheduledExecutorService timer =
	        Executors.newSingleThreadScheduledExecutor();
		
	private static Set<Session> allSessions;
	
	DateTimeFormatter timeFormatter = 
			DateTimeFormatter.ofPattern("HH:mm:ss");	
	
   @OnOpen
   public void showTime(Session session){
	   
	   allSessions = session.getOpenSessions();
	   
	   // start the scheduler on the very first connection
	   if (allSessions.size()==1){
		   timer.scheduleAtFixedRate(
			  () ->sendTimeToAll(session),0,1,TimeUnit.SECONDS); 
	   }
   }
   
   private void sendTimeToAll(Session session){
       allSessions = session.getOpenSessions();
	   
	   for (Session sess: allSessions){
          try{  
			sess.getBasicRemote().sendText("Local time: " +
			            LocalTime.now().format(timeFormatter));		

          } catch (IOException ioe) {
    		     System.out.println(ioe.getMessage());
    	      }
	   }
   }
}