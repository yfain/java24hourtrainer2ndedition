
import java.util.Enumeration;

import javax.jms.*;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;


public class DirectMessageSenderWithBrowser{
 public static void main(String[] args){

   ConnectionFactory factory;
	 
   factory = new com.sun.messaging.ConnectionFactory();  

	try( JMSContext context = factory.createContext("admin","admin")){

		factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
		      Queue ordersQueue = context.createQueue("TradingOrdersQueue");	  
	          JMSProducer producer = context.createProducer();
	      
	          // Send msg to buy 200 shares of IBM at market price	      
	          producer.send(ordersQueue,"IBM 300 Mkt");
	          
	          System.out.println("Placed an order to purchase 300 shares of IBM to TradingOrdersQueue");
	          
	          QueueBrowser queueBrowser = context.createBrowser(ordersQueue);
	          Enumeration enumeration = queueBrowser.getEnumeration();
	          while (enumeration.hasMoreElements()) {
	              TextMessage o = (TextMessage) enumeration.nextElement();
	             System.out.println("Browser sees  " + o.getText());

	          }
	          
	          
	          
	 } catch (JMSException e){
	           System.out.println("Error: " + e.getMessage());
	 } 
 }		
}
