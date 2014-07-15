import javax.swing.JFrame;
import javax.swing.JButton;

public class HelloWorld extends JFrame {

  public static void main(String[] args) {
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
