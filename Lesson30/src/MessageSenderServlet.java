import java.io.IOException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.messaging.ConnectionConfiguration;

@WebServlet("/MessageSenderServlet")
public class MessageSenderServlet extends HttpServlet {
	
	  @Resource(lookup ="java:comp/DefaultJMSConnectionFactory")  // JNDI name
	  ConnectionFactory factory;
	  
	  @Resource(lookup = "OutgoingTradeOrders")  // JNDI name
	  Destination ordersQueue;

	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException{	
		
		try( JMSContext context = factory.createContext("admin","admin")){
  
		          JMSProducer producer = context.createProducer();
		      
		          // Send msg to buy 200 shares of IBM at market price	      
		          producer.send(ordersQueue,"IBM 200 Mkt");
		          
		          System.out.println("Placed an order to purchase 200 shares of IBM to OutgoingTradeOrders");
	  }
	}
}
