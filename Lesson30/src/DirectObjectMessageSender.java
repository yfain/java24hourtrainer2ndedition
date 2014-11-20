
import javax.jms.*;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;


public class DirectObjectMessageSender{
 public static void main(String[] args){

   ConnectionFactory factory;
	 
   factory = new com.sun.messaging.ConnectionFactory();  

	try( JMSContext context = factory.createContext("admin","admin")){

		factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
		      Destination ordersQueue = context.createQueue("TradingOrdersQueue");	  
	          JMSProducer producer = context.createProducer();
	          
	          Order order = new Order(1, "AAPL", 200, 100.00f);
	          ObjectMessage objMsg = context.createObjectMessage(order);
	          
	      
	          // Send msg to buy 200 shares of AAPL at market price	      
	          producer.send(ordersQueue,objMsg);
	          
	          System.out.println("Placed an order to purchase 200 shares of AAPL to TradingOrdersQueue");
	 } catch (JMSException e){
	           System.out.println("Error: " + e.getMessage());
	 } 
 }		
}
