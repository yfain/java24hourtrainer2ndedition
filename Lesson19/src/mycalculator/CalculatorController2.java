package mycalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculatorController2 {
	
  public void buttonClickHandler(ActionEvent evt){
	 
	Button clickedButton = (Button) evt.getTarget();
	String buttonLabel = clickedButton.getText();
	
	// Tell apart digits from operations
	switch(buttonLabel){
	  case "0": case "1": case "2": case "3": case "4": case "5":
	  case "6": case "7": case "8": case "9": case "10": case ".":		
		System.out.println("You clicked on digit or a period. " );		
	    break;
	 default:
		 System.out.println("You clicked on the operation button." );		 
	}
	
  }	
}
