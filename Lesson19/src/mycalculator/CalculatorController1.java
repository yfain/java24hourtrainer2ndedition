package mycalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculatorController1 {
	
  public void buttonClickHandler(ActionEvent evt){
    
	// Recognize and print the clicked button's text  
	Button clickedButton = (Button) evt.getTarget();
	System.out.println("You clicked on " + clickedButton.getText());
  }	
}
