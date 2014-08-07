package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	private static SimpleCalculatorPane simpleCalculatorPane = new SimpleCalculatorPane();
	private static StandardCalculatorPane standardCalculatorPane = new StandardCalculatorPane();
	private static FancyCalculatorPane fancyCalculatorPane = new FancyCalculatorPane();
	
	public static void main(String[] args) {
				
		// Define the calculator engine as a lambda expression and store it in a variable
		CalculatorEngine calculatorEngine = (ActionEvent e, 
				CalculatorPane parent) -> {
							
			// Get the source of this action
			Button clickedButton =  (Button) e.getSource();

			switch(clickedButton.getText()){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case ".":
				parent.setPreviouslyPressedButton(clickedButton.getText());
				//	displayDigit(clickedButton);
				// Get the existing text from the Calculator's display field
				String dispFieldText = parent.getDisplayValue();
				// Get the button's label
				String clickedButtonLabel = clickedButton.getText();
				parent.setDisplayValue(dispFieldText + clickedButtonLabel);
				break;
			case "+":
			case "-":
			case "/":
			case "*":
			case "%":
				// Store the first number and the operator in corresponding variables
				parent.setFirstNumber(parent.getDisplayValue());
				parent.setOperator(clickedButton.getText());
				parent.setPreviouslyPressedButton(parent.getOperator());
				// Erase the number from the display
				parent.setDisplayValue("");		
				break;
			case "=":

				// do nothing if previously pressed button was the equal sign, 
				// a unary operator or dot
				if ("=".equals(parent.getPreviouslyPressedButton()) ||
						"sqrt".equals(parent.getPreviouslyPressedButton()) ||
						"+/-".equals(parent.getPreviouslyPressedButton()) ||
						"1/x".equals(parent.getPreviouslyPressedButton()) ||
						"C".equals(parent.getPreviouslyPressedButton()) || 
						"Backspace".equals(parent.getPreviouslyPressedButton()) ||
						".".equals(parent.getPreviouslyPressedButton())) break; 

				try{
					// Perform the selected action
					if ("+".equals(parent.getOperator())) {
						parent.setResult(Double.parseDouble(parent.getDisplayValue()) + Double.parseDouble(parent.getFirstNumber()));
					}
					if ("-".equals(parent.getOperator())) {
						parent.setResult(Double.parseDouble(parent.getFirstNumber()) - Double.parseDouble(parent.getDisplayValue()));
					}
					if ("*".equals(parent.getOperator())) {
						parent.setResult(Double.parseDouble(parent.getFirstNumber()) * Double.parseDouble(parent.getDisplayValue()));
					}
					if ("/".equals(parent.getOperator())) {
						//validate input
						if (Double.parseDouble(parent.getDisplayValue()) == 0){
							// Display error message in red if user attempts to divide by zero
							parent.setDisplayValue("You cannot divide by zero!", "red");
							break;
						}
						else
							parent.setResult(Double.parseDouble(parent.getFirstNumber()) / Double.parseDouble(parent.getDisplayValue()));
					}
					if ("%".equals(parent.getOperator())) {
						parent.setResult(Double.parseDouble(parent.getFirstNumber()) % Double.parseDouble(parent.getDisplayValue()));
					}
				}
				catch(NumberFormatException exception){
					parent.setDisplayValue("Operand is not a number!", "red");
					break;
				}

				// Store the result in firstNumber
				parent.setFirstNumber(String.valueOf(parent.getResult()));
				// Display the result
				parent.setDisplayValue(parent.getFirstNumber());
				parent.setPreviouslyPressedButton("=");
				break;

			case "C":
				// erase the number or message from the display
				parent.setDisplayValue("");
				parent.setPreviouslyPressedButton(clickedButton.getText());
				break;

			case "sqrt":
				//store result in firstNumber
				parent.setFirstNumber(String.valueOf(Math.sqrt(Double.parseDouble(parent.getDisplayValue()))));
				//display the result
				parent.setDisplayValue(parent.getFirstNumber());
				parent.setPreviouslyPressedButton(clickedButton.getText());
				break;

			case "1/x":
				if (Double.parseDouble(parent.getDisplayValue()) == 0){
					// Display error message in red if user attempts to divide by zero
					parent.setDisplayValue("You cannot divide by zero!", "red");
					parent.setPreviouslyPressedButton(clickedButton.getText());
					break;
				}
				else{
					//store result in firstNumber
					parent.setFirstNumber(String.valueOf(1/(Double.parseDouble(parent.getDisplayValue()))));
					//display the result
					parent.setDisplayValue(parent.getFirstNumber());
				}
				parent.setPreviouslyPressedButton(clickedButton.getText());
				break;

			case "+/-":
				//store result in firstNumber
				parent.setFirstNumber(String.valueOf(0.0-(Double.parseDouble(parent.getDisplayValue()))));
				//display the result
				parent.setDisplayValue(parent.getFirstNumber());
				parent.setPreviouslyPressedButton(clickedButton.getText());
				break;

			case "Backspace":
				if((parent.getDisplayValue().length()) != 0) {
					parent.setDisplayValue(parent.getDisplayValue().substring(0,parent.getDisplayValue().length()-1));
				}
				parent.setPreviouslyPressedButton(clickedButton.getText());
				break;

			default:
				parent.setDisplayValue("Undefined action");

			}
		};
		
		
		// set handler code for calculator components
		fancyCalculatorPane.handle(calculatorEngine);
		simpleCalculatorPane.handle(calculatorEngine);
		standardCalculatorPane.handle(calculatorEngine);
		
        launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		// Window is not maximizable
		//primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		//primaryStage.initModality(Modality.NONE);
		// Set the application icon
	    primaryStage.getIcons().add(new Image("file:resources/images/calculatoryellow.png"));
		
		// Create the menu bar
		MenuBar menuBar = new MenuBar();
		Menu viewMenu = new Menu("View");
		RadioMenuItem simpleCalculatorMenuItem = new RadioMenuItem("Simple");
		RadioMenuItem standardCalculatorMenuItem = new RadioMenuItem("Standard");
		RadioMenuItem fancyCalculatorMenuItem = new RadioMenuItem("Fancy");
			// Set fancy calculator as default view
		fancyCalculatorMenuItem.setSelected(true);
		viewMenu.getItems().addAll(simpleCalculatorMenuItem, 
				standardCalculatorMenuItem,
				fancyCalculatorMenuItem);

		menuBar.getMenus().add(viewMenu);
		
		// Create a GridPane as the root layout node
		GridPane window = new GridPane();
		// Create the scene and set its style
		Scene scene = new Scene(window, 500, 350, Color.GREY);
		scene.getStylesheets()
		.add(getClass().getResource("calculator.css")
		.toExternalForm());				
		
		// Add the menu bar to the window
		window.add(menuBar, 0, 0);
		
		// At the beginning add to the window a fancy calculator pane

		window.add(fancyCalculatorPane, 0, 1);
		
		// Set the scene and display the window
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handler code for menu items
		standardCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				// if selected, add
				if (standardCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(simpleCalculatorPane))){
					simpleCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(simpleCalculatorPane);
					window.add(standardCalculatorPane, 0, 1);
				}
				if (standardCalculatorMenuItem.isSelected() && 
						(window.getChildren().contains(fancyCalculatorPane))){
						fancyCalculatorMenuItem.setSelected(false);
						window.getChildren().remove(fancyCalculatorPane);
						window.add(standardCalculatorPane, 0, 1);
					}
				// if unselected, remove
				if (!standardCalculatorMenuItem.isSelected()){
					if (window.getChildren().contains(standardCalculatorPane)){
						window.getChildren().remove(standardCalculatorPane);
					}
					window.add(simpleCalculatorPane, 0, 1);
					simpleCalculatorMenuItem.setSelected(true);
				}
			}
		});
		
		simpleCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				// if selected, add
				if (simpleCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(standardCalculatorPane))){
					standardCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(standardCalculatorPane);
					window.add(simpleCalculatorPane, 0, 1);
				}
				if (simpleCalculatorMenuItem.isSelected() && 
						(window.getChildren().contains(fancyCalculatorPane))){
						fancyCalculatorMenuItem.setSelected(false);
						window.getChildren().remove(fancyCalculatorPane);
						window.add(simpleCalculatorPane, 0, 1);
					}
				// if unselected, remove
				if (!simpleCalculatorMenuItem.isSelected()){
					if (window.getChildren().contains(simpleCalculatorPane)){
						window.getChildren().remove(simpleCalculatorPane);
					}
					window.add(standardCalculatorPane, 0, 1);
					standardCalculatorMenuItem.setSelected(true);
				}
			}
		});
		
		//Handler code for fancyCalculatorMenuItem, using lambda expression
		
		fancyCalculatorMenuItem.setOnAction(t -> {
			// if selected, add
			if (fancyCalculatorMenuItem.isSelected() && 
				(window.getChildren().contains(standardCalculatorPane))){
				standardCalculatorMenuItem.setSelected(false);
				window.getChildren().remove(standardCalculatorPane);
				window.add(fancyCalculatorPane, 0, 1);
			}
			if (fancyCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(simpleCalculatorPane))){
					simpleCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(simpleCalculatorPane);
					window.add(fancyCalculatorPane, 0, 1);
				}
			// if unselected, remove
			if (!fancyCalculatorMenuItem.isSelected()){
				if (window.getChildren().contains(fancyCalculatorPane)){
					window.getChildren().remove(fancyCalculatorPane);
				}
				window.add(standardCalculatorPane, 0, 1);
				standardCalculatorMenuItem.setSelected(true);
			}	
		});	

	}

}

