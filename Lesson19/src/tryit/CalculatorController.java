package tryit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	
  @FXML                 // inject the value from GUI
  private TextField displayField;  
  
  private String previousValue="";
  private String currentValue="";
  private double result;
  
  private String lastOperation;
	
  public void buttonClickHandler(ActionEvent evt){
	 
	Button clickedButton = (Button) evt.getTarget();
	String buttonLabel = clickedButton.getText();
	
	// Tell apart digits from operations
	switch(buttonLabel){
	  case "0": case "1": case "2": case "3": case "4": case "5":
	  case "6": case "7": case "8": case "9": case "10": case ".":		
	     processDigit(buttonLabel);
		 break;
	 default:
		 processOperation(buttonLabel);
	}
  }	
  
  private void processDigit(String buttonLabel){ 
	  
	  displayField.setText(displayField.getText() + buttonLabel);

  }
  
  private void processOperation(String buttonLabel){
	  switch (buttonLabel) {
	    case "+":
	    	  lastOperation = "+";
	    	  addNumbers();
	    	  break;	  
	    case "=":
	    	  if ("+".equals(lastOperation)){
	    		  addNumbers(); 
	    	  }
	    	  break;
	  }  	  
  }
  
  private void addNumbers(){
	  if ("".equals(previousValue)){
		  previousValue = displayField.getText();
		  displayField.setText("");
		  	  
	  } else{
		  currentValue = displayField.getText(); 
		  result = Double.parseDouble(previousValue) + 
				   Double.parseDouble(currentValue); 
		  displayField.setText("" + result);  
	  }
  }
  
}
