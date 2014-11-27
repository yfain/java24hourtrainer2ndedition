package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SimpleCalculatorPane extends CalculatorPane{
	
	public SimpleCalculatorPane(){
		super();
			
			// Create a GridPane as the root layout node
	GridPane window = new GridPane();
	window.setPadding(new Insets(5));
	window.setHgap(5);
	window.setVgap(5);
		
			// Create a BorderPane for the calculator
	BorderPane windowContent = new BorderPane();
	  	
	  		// Create the display field and place it at the Top area of the window
	displayField = new TextField();
    displayField.setAlignment(Pos.BASELINE_RIGHT);
	windowContent.setTop(displayField);

	  		// Create the components
	button0 = new Button("0");
	button1 = new Button("1");
	button2 = new Button("2");
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
	  	
	  		// Set a large preferred size of the buttons, so that they fill the whole space
	  		//in their container
	button0.setPrefSize(800, 800);
	button1.setPrefSize(800, 800);
	button2.setPrefSize(800, 800);
	button3.setPrefSize(800, 800);
	button4.setPrefSize(800, 800);
	button5.setPrefSize(800, 800);
	button6.setPrefSize(800, 800);
	button7.setPrefSize(800, 800);
	button8.setPrefSize(800, 800);
	button9.setPrefSize(800, 800);
	buttonPoint.setPrefSize(800, 800);
	buttonEqual.setPrefSize(800, 800);
	  	
	buttonPlus.setPrefSize(80, 800);
	buttonMinus.setPrefSize(80, 800);
	buttonMult.setPrefSize(80, 800);
	buttonDiv.setPrefSize(80, 800);
	  	  	
			// Create a GridPane node to hold 12 buttons – 
			//10 numeric ones, period, and the equal sign 	  	
	GridPane gridPane = new GridPane();
	  	
	  		// Add buttons to the gridPane
	gridPane.add(button0,0,0); 
	gridPane.add(button1,1,0);
	gridPane.add(button2,2,0);
	gridPane.add(button3,0,1);
	gridPane.add(button4,1,1);
	gridPane.add(button5,2,1); 
	gridPane.add(button6,0,2);
	gridPane.add(button7,1,2);
	gridPane.add(button8,2,2);
	gridPane.add(button9,0,3);
	gridPane.add(buttonPoint,1,3);
	gridPane.add(buttonEqual,2,3);
	
		// Create a VBox and add Plus, Minus, Mult, Div buttons to it
	VBox operations = new VBox();
	operations.getChildren().add(buttonPlus);
	operations.getChildren().add(buttonMinus);
	operations.getChildren().add(buttonMult);
	operations.getChildren().add(buttonDiv);
			
		// Place the gridPane with buttons at the Center of the window(BorderPane)
	windowContent.setCenter(gridPane);
	
		// Place the VBox with operation buttons (Plus, Minus, Div, Mult) 
		//at the Right area of the border pane
	windowContent.setRight(operations);
	
	window.add(windowContent, 0, 1);
	
    getChildren().add(window);
	  		
	}

}

