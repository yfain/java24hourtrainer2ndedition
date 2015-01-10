package tryit;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController implements EventHandler<ActionEvent> {
	
  
  //Declaring a JavaFX property
  private StringProperty displayContent = new SimpleStringProperty("");
  
  private String previousValue="";
  private String currentValue="";
  private double result;
  private String lastOperation;

  Calculator gui;
  
  public CalculatorController(Calculator calculator) {
	gui = calculator;
	
	// Bind the property displayContent to the TextField on GUI
	gui.displayField.textProperty().bind(displayContent);
}

public void handle(ActionEvent evt){
	 
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
	  
	  // The property displayContent is bout to the GUI TextField
	  displayContent.setValue(displayContent.getValue() + buttonLabel);
	  
  }

  // The method processOperation implements only
  // the plus operation. Other operations can be implemented similarly
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
		  previousValue = displayContent.getValue();
		  displayContent.setValue("");
		  	  
	  } else{
		  currentValue = displayContent.getValue(); 
		  result = Double.parseDouble(previousValue) + 
				   Double.parseDouble(currentValue); 
		  displayContent.setValue("" + result);  
	  }
  }
}
