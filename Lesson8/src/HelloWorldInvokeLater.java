import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class HelloWorldInvokeLater extends JFrame {

  public static void main(String[] args) {
	  
	  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        createAndShowGUI();
		    }
		});	  
  }

  private static void createAndShowGUI(){
	  JFrame myWindow = new HelloWorld();
	
	  // Creating and adding a button the the container
		JButton myButton = new JButton ("Click me");
	  myWindow.add(myButton); 
	
	  myWindow.setSize(200,300);
	  myWindow.setTitle("Hello World");
	  myWindow.setVisible(true);   
	  
	  myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
}
