
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import com.sun.messaging.ConnectionFactory;
//import com.sun.messaging.ConnectionConfiguration;


public class DirectMessageReceiver implements MessageListener{
	
	Context namingContext = null;

//ConnectionFactory factory = new com.sun.messaging.ConnectionFactory();  
	
	JMSConsumer consumer;
	
	DirectMessageReceiver(){
		try{
            // Set up the namingContext for the JNDI lookup
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://127.0.0.1:9080"));
            env.put(Context.SECURITY_PRINCIPAL, "quickstartUser");
            env.put(Context.SECURITY_CREDENTIALS, "quickstartPwd1!");
            namingContext = new InitialContext(env);
            
        	ConnectionFactory factory = (ConnectionFactory) namingContext.lookup("jms/RemoteConnectionFactory");
        	
        	try( JMSContext context = factory.createContext("quickstartUser","quickstartPwd1!")){
        		//factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
        		   
        					Destination ordersQueue = context.createQueue("testQueue");	  
        			        
        					consumer = context.createConsumer(ordersQueue);
        				    
        					consumer.setMessageListener(this);
        				      
        				      System.out.println("Listening to the test queue...");
        				      
        				      // Keep the program running - wait for messages
        				      Thread.sleep(100000);
        				    
        				   }
		
		}	
			catch(NamingException e){
				
			} 
		catch (InterruptedException e){
	           System.out.println("Error: " + e.getMessage());
	       }
//		    catch (JMSException e){
//		           System.out.println("Error: " + e.getMessage());
//		    } 
		finally {
	            if (namingContext != null) {
	                try {
	                    namingContext.close();
	                } catch (NamingException e) {
	                    System.out.println(e.getMessage());
	                }
	            }
	        
 
		}

	}

    public void onMessage(Message msg){
    	
      try{
    /*   System.out.println("Got the text message from the TradingOrdersQueue: " +
                          msg.getBody(String.class)); */
  /* 	  
          if (msg instanceof ObjectMessage) {
              Object object = ((ObjectMessage) msg).getObject();
              Bid myBid = (Bid) object;
      
    	 // Bid myBid = (Bid)((ObjectMessage) msg).getObject();
    	 // System.out.println("Received a bid from " + myBid.user.name);

         System.out.println("\n === Here's what toString() on the message prints \n" + myBid);
          }
          */
    	  
    	  Bid myBid = msg.getBody(Bid.class);
       
       System.out.println("\n === Here's what toString() on the message prints \n" + msg);
       
       
       
      } catch (JMSException e){
    	  System.err.println("JMSException: " + e.toString());
      }
    }

 public static void main(String[] args){
	  new DirectMessageReceiver();
 }	 
}