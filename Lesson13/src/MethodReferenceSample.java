
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MethodReferenceSample extends JFrame {

   public void processButtonClick(ActionEvent e){
      System.out.println("Someone clicked on the button");
   }
   
   public static void main(String args[]){
	   MethodReferenceSample mrs = new MethodReferenceSample();
	   JButton myButton = new JButton("Click me");
	   mrs.add(myButton);
	   
	   // Using method reference
	   myButton.addActionListener(mrs::processButtonClick);
			   
	   mrs.pack(); 
	   mrs.setVisible(true);	  
       mrs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
}