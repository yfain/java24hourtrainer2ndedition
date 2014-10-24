import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MethodReferenceSample extends JFrame {

	public void processButtonClick(ActionEvent actionEvent) {
		System.out.println("Someone clicked on the button");
	}

	public static void main(String args[]) {
		MethodReferenceSample methodReferenceSample = new MethodReferenceSample();
		JButton myButton = new JButton("Click me");
		methodReferenceSample.add(myButton);

		// Using method reference
		myButton.addActionListener(methodReferenceSample::processButtonClick);

		methodReferenceSample.pack();
		methodReferenceSample.setVisible(true);
		methodReferenceSample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}