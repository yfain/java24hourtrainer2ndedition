package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public abstract class CalculatorPane extends StackPane{
	
	private String firstNumber; 
	private String operator; // selected action 
	private double result;
	private String previouslyPressedButton = "";
	
	public void handle(CalculatorEngine engine) {
		button0.setOnAction((e) -> 
		engine.processEvent(e,this));
		button1.setOnAction((e) -> 
		engine.processEvent(e,this));
		button2.setOnAction((e) -> 
		engine.processEvent(e,this));
		button3.setOnAction((e) -> 
		engine.processEvent(e,this));
		button4.setOnAction((e) -> 
		engine.processEvent(e,this));
		button5.setOnAction((e) -> 
		engine.processEvent(e,this));
		button6.setOnAction((e) -> 
		engine.processEvent(e,this));
		button7.setOnAction((e) -> 
		engine.processEvent(e,this));
		button8.setOnAction((e) -> 
		engine.processEvent(e,this));
		button9.setOnAction((e) -> 
		engine.processEvent(e,this));
		
		buttonPoint.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonEqual.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonPlus.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMinus.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMult.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonDiv.setOnAction((e) -> 
		engine.processEvent(e,this));
		
		buttonSQRT.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMOD.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonINV.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonOPP.setOnAction((e) -> 
		engine.processEvent(e,this));
		
		buttonBackspace.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonCE.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonC.setOnAction((e) -> 
		engine.processEvent(e,this));
		
		buttonMC.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMR.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMS.setOnAction((e) -> 
		engine.processEvent(e,this));
		buttonMPlus.setOnAction((e) -> 
		engine.processEvent(e,this));
	}
	
	// Declare all calculator's components.
	protected TextField displayField;
	
	protected Button button0;
	protected Button button1;
	protected Button button2;
	protected Button button3;
	protected Button button4;
	protected Button button5;
	protected Button button6;
	protected Button button7;
	protected Button button8;
	protected Button button9;
	protected Button buttonPoint;
	protected Button buttonEqual;
	protected Button buttonPlus;
	protected Button buttonMinus;
	protected Button buttonMult;
	protected Button buttonDiv;
	
	protected Button buttonSQRT;
	protected Button buttonMOD;
	protected Button buttonINV;
	protected Button buttonOPP;
	
	protected Button buttonBackspace;
	protected Button buttonCE;
	protected Button buttonC;
	
	protected Button buttonMC;
	protected Button buttonMR;
	protected Button buttonMS;
	protected Button buttonMPlus;
	
	// Constructor
	public CalculatorPane(){
		super();
	}
	
	// Define getter and setters
	
	   public String getDisplayValue() {
	        return displayField.getText();
	    }
	
	   public void setDisplayValue(String val){
		   String textColor = "  -fx-text-fill: black";
		   displayField.setStyle(textColor);
		   displayField.setText(val);
	   }
    
	   public void setDisplayValue(String val, String color){
		   String textColor = "  -fx-text-fill: " + color;
		   displayField.setStyle(textColor);
		   displayField.setText(val);
	   }
	   
		public String getFirstNumber() {
			return firstNumber;
		}

		public void setFirstNumber(String firstNumber) {
			this.firstNumber = firstNumber;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public double getResult() {
			return result;
		}

		public void setResult(double result) {
			this.result = result;
		}

		public String getPreviouslyPressedButton() {
			return previouslyPressedButton;
		}

		public void setPreviouslyPressedButton(String previouslyPressedButton) {
			this.previouslyPressedButton = previouslyPressedButton;
		}
	   
	   protected void setButtonStyles(String style){
			button0.setId(style);
			button1.setId(style);
			button2.setId(style);
			button3.setId(style);
			button4.setId(style);
			button5.setId(style);
			button6.setId(style);
			button7.setId(style);
			button8.setId(style);
			button9.setId(style);
			
			buttonPoint.setId(style);
			buttonEqual.setId(style);
			buttonPlus.setId(style);
			buttonMinus.setId(style);
			buttonMult.setId(style);
			buttonDiv.setId(style);
			
			buttonSQRT.setId(style);
			buttonMOD.setId(style);
			buttonINV.setId(style);
			buttonOPP.setId(style);
			
			buttonBackspace.setId(style);
			buttonCE.setId(style);
			buttonC.setId(style);
			
			buttonMC.setId(style);
			buttonMR.setId(style);
			buttonMS.setId(style);
			buttonMPlus.setId(style);
		   
	   }

}
