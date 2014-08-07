package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class StandardCalculatorPane extends CalculatorPane{
	
	private final double BUTTON_PREF_WIDTH = 800;
	private final double BUTTON_PREF_HEIGHT = 800;
	
	public StandardCalculatorPane(){
		super();
		
			// Create a GridPane as the root layout node
  	  	GridPane windowContent = new GridPane();
  	  	windowContent.setPadding(new Insets(5));
  	  	windowContent.setHgap(5);
  	  	windowContent.setVgap(5);
  	  	
  	  		// Create the display field and set the corresponding constraints
  	  	displayField = new TextField();
        displayField.setAlignment(Pos.BASELINE_RIGHT);;
  	  	GridPane.setColumnSpan(displayField, 6); // this cell is as wide as 6 other ones
  	  	GridPane.setRowSpan(displayField, 1); // this cell has the same height as other cells
  	  	GridPane.setFillHeight(displayField, true);
  	  	GridPane.setFillWidth(displayField, true); // fill all space in the cell
  	  	GridPane.setHalignment(displayField, HPos.CENTER);
  	  	GridPane.setValignment(displayField, VPos.CENTER); // position within the cell
  	  	GridPane.setHgrow(displayField, Priority.ALWAYS);
  	  	GridPane.setVgrow(displayField, Priority.ALWAYS); // grow larger than the preferred size if there is space
  	  	
  	  		// Add the display field to the window
  	  	windowContent.add(displayField, 0, 1);
  
  	  		// Create the buttons
    	button0 = new Button("0");
  	  	button1 = new Button("1");
  	  	button2  =new Button("2");
  	  	button3 = new Button("3");
  	  	button4 = new Button("4");
  	  	button5 = new Button("5");
  	  	button6 = new Button("6");
  	  	button7 = new Button("7");
  	  	button8 = new Button("8");
  	  	button9 = new Button("9");
  	  	buttonPoint = new Button(".");
  	  	buttonEqual = new Button("=");
  	  	
  	  	buttonPlus = new Button("+");
  	  	buttonMinus = new Button("-");
  	  	buttonMult = new Button("*");
  	  	buttonDiv = new Button("/");
  	  	
  	  	buttonSQRT = new Button("sqrt");
  	  	buttonMOD = new Button("%");
  	  	buttonINV = new Button("1/x");
  	  	buttonOPP = new Button("+/-");
  	
  	  	buttonBackspace = new Button("Backspace");
  	  	buttonCE = new Button("CE");
  	  	buttonC = new Button("C");
  	
  	  	buttonMC = new Button("MC");
  	  	buttonMR = new Button("MR");
  	  	buttonMS = new Button("MS");
  	  	buttonMPlus = new Button("M+");
  	  	
  	  		// Set a large preferred size of the buttons, 
  	  		// so that they fill the whole space
  	  		// in their container
  	  	button0.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button1.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button2.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button3.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button4.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button5.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button6.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button7.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button8.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button9.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
 	  	buttonPoint.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonEqual.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	
  	  	buttonPlus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMinus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMult.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonDiv.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	
	  	buttonMC.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMR.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMS.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMPlus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	
	  	buttonSQRT.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonMOD.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonINV.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonOPP.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	
  	  	buttonBackspace.setPrefSize(200, 800);
  	  	buttonCE.setPrefSize(200, 800);
  	  	buttonC.setPrefSize(200, 800);
 	  	  	  	  	
  	  		// Add the buttons to the window
	  	windowContent.add(button0,1,6); 
	  	windowContent.add(button1,1,5);
	  	windowContent.add(button2,2,5);
	  	windowContent.add(button3,3,5);
	  	windowContent.add(button4,1,4);
	  	windowContent.add(button5,2,4); 
	  	windowContent.add(button6,3,4);
	  	windowContent.add(button7,1,3);
	  	windowContent.add(button8,2,3);
	  	windowContent.add(button9,3,3);
	  	windowContent.add(buttonPoint,3,6);
	  	windowContent.add(buttonSQRT,5,3);
	  	windowContent.add(buttonMOD,5,4);
	  	windowContent.add(buttonINV,5,5);
	  	windowContent.add(buttonEqual,5,6);
	  	windowContent.add(buttonOPP,2,6);
		  	
	  	GridPane.setRowIndex(buttonPlus, 6);
	  	GridPane.setColumnIndex(buttonPlus, 4);
	  	GridPane.setRowIndex(buttonMinus, 5);
	  	GridPane.setColumnIndex(buttonMinus, 4);
	  	GridPane.setRowIndex(buttonMult, 4);
	  	GridPane.setColumnIndex(buttonMult, 4);
	  	GridPane.setRowIndex(buttonDiv, 3);
	  	GridPane.setColumnIndex(buttonDiv, 4);
	  	windowContent.getChildren().addAll(buttonPlus, buttonMinus, buttonMult, buttonDiv);
	  	
	  		// First column
	  	GridPane.setRowIndex(buttonMC, 3);
	  	GridPane.setColumnIndex(buttonMC, 0);
  	  	buttonMC.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	
	  	GridPane.setRowIndex(buttonMR, 4);
	  	GridPane.setColumnIndex(buttonMR, 0);
	  	GridPane.setRowIndex(buttonMS, 5);
	  	GridPane.setColumnIndex(buttonMS, 0);
	  	GridPane.setRowIndex(buttonMPlus, 6);
	  	GridPane.setColumnIndex(buttonMPlus, 0);
	
	  	windowContent.getChildren().addAll(buttonMC, buttonMR, buttonMS, buttonMPlus);
	  	
	  		// First row
	  	GridPane.setHalignment(buttonBackspace, HPos.LEFT);
  	  	GridPane.setColumnSpan(buttonBackspace, 2);
  	  	GridPane.setFillHeight(buttonBackspace, true);
  	  	GridPane.setFillWidth(buttonBackspace, true); // fill all space in the cell
	  	GridPane.setHgrow(buttonBackspace, Priority.ALWAYS);
	  	GridPane.setVgrow(buttonBackspace, Priority.ALWAYS);
  	  	GridPane.setMargin(buttonBackspace, new Insets(2,40,2,2));
	  	windowContent.add(buttonBackspace, 1, 2);
	  	
	  	GridPane.setHalignment(buttonCE, HPos.CENTER);
  	  	GridPane.setColumnSpan(buttonCE, 3);
  	  	GridPane.setMargin(buttonCE, new Insets(2,40,2,40));
	  	windowContent.add(buttonCE, 2, 2);
	  	
	  	GridPane.setHalignment(buttonC, HPos.RIGHT);
  	  	GridPane.setColumnSpan(buttonC, 2);
  	  	GridPane.setMargin(buttonC, new Insets(2,2,2,40));
	  	windowContent.add(buttonC, 4, 2);
		
	    getChildren().add(windowContent);
		
	}

}
