

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Cristina
 */
public class AdvancedCalculator extends Application {
	
	private final static int PREF_BUTTON_WIDTH = 50;
	
    private TextField displayField = new TextField();
    
	//public API

	public String getDisplayFieldValue() {
		return displayField.getText();
	}

	public void setDisplayFieldValue(String val) {
		this.displayField.setText(val);
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//create calculator engine (mouse event handler)
    	CalculatorEngine calcEngine = new CalculatorEngine(this);
    	
        primaryStage.setTitle("Calculator");
        Group group = new Group();
        Scene scene = new Scene(group, 390, 230, Color.WHITESMOKE);
        
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        
        Menu edit = new Menu("Edit");
        Menu view = new Menu("View");
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(view);
        menuBar.getMenus().add(help);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        
        // display field
        GridPane.setRowSpan(displayField, 1);
        GridPane.setColumnSpan(displayField,2);
        displayField.setScaleX(1.0);
        displayField.setPrefWidth(350.0);
        displayField.setAlignment(Pos.BASELINE_RIGHT);;
        
        //first row of cells
        //create horizontal box to hold backspace, ce and c
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        GridPane.setRowSpan(hbox, 1);
        GridPane.setColumnSpan(hbox,2);
        GridPane.setHalignment(hbox, HPos.RIGHT);
        hbox.setScaleX(1.0);
        hbox.setPrefWidth(350.0);
        
        Button backspace = new Button();
        setButtonPropertiesAndEventHandler(backspace, "Backspace", 90, calcEngine);
        
        Button ce = new Button();
        setButtonPropertiesAndEventHandler(ce, "CE", 90, calcEngine);
        
        Button c = new Button();
        setButtonPropertiesAndEventHandler(c, "C", 90, calcEngine);
        
        //add backspace, ce and c to their container
        hbox.getChildren().add(backspace);
        hbox.getChildren().add(ce);
        hbox.getChildren().add(c);
        
        //MC, MR, MS, M+
        //create vertical box to hold mc, mr, ms and mPlus
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        GridPane.setRowSpan(vbox, 4);
        GridPane.setColumnSpan(vbox,1);
        GridPane.setValignment(vbox, VPos.BOTTOM);
        vbox.setScaleY(1.0);
        
        Button mc = new Button();
        setButtonPropertiesAndEventHandler(mc, "MC", 50, calcEngine);        
        
        Button mr = new Button();
        setButtonPropertiesAndEventHandler(mr, "MR", 50, calcEngine);  
        
        Button ms = new Button();
        setButtonPropertiesAndEventHandler(ms, "MS", 50, calcEngine);
        
        Button mPlus = new Button();
        setButtonPropertiesAndEventHandler(mPlus, "M+", 50, calcEngine);
        
        //add mc, mr, ms and mPlus to their container
        vbox.getChildren().add(mc);
        vbox.getChildren().add(mr);
        vbox.getChildren().add(ms);
        vbox.getChildren().add(mPlus);
        
        //the rest
        //create GridPane to hold the rest of the buttons
        GridPane moreButtons = new GridPane();        
        moreButtons.setHgap(10);
        moreButtons.setVgap(10);
        moreButtons.setPadding(new Insets(0,0,0,15));
        
        //create buttons
        Button seven = new Button("7");
        setPrefPlusHandlerAndAdd(seven, 0, 0, PREF_BUTTON_WIDTH, moreButtons, calcEngine);      
        
        Button eight = new Button("8");
        setPrefPlusHandlerAndAdd(eight, 1, 0, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button nine = new Button("9");
        setPrefPlusHandlerAndAdd(nine, 2, 0, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button div = new Button("/");
        setPrefPlusHandlerAndAdd(div, 3, 0, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button sqrt = new Button("sqrt");
        setPrefPlusHandlerAndAdd(sqrt, 4, 0, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button four = new Button("4");
        setPrefPlusHandlerAndAdd(four, 0, 1, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button five = new Button("5");
        setPrefPlusHandlerAndAdd(five, 1, 1, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button six = new Button("6");
        setPrefPlusHandlerAndAdd(six, 2, 1, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button mult = new Button("*");
        setPrefPlusHandlerAndAdd(mult, 3, 1, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button mod = new Button("%");
        setPrefPlusHandlerAndAdd(mod, 4, 1, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button one = new Button("1");
        setPrefPlusHandlerAndAdd(one, 0, 2, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button two = new Button("2");
        setPrefPlusHandlerAndAdd(two, 1, 2, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button three = new Button("3");
        setPrefPlusHandlerAndAdd(three, 2, 2, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button dot = new Button(".");
        setPrefPlusHandlerAndAdd(dot, 3, 2, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button inv = new Button("1/x");
        setPrefPlusHandlerAndAdd(inv, 4, 2, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button zero = new Button("0");
        setPrefPlusHandlerAndAdd(zero, 0, 3, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button plusMinus = new Button("+/-");
        setPrefPlusHandlerAndAdd(plusMinus, 1, 3, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button minus = new Button("-");
        setPrefPlusHandlerAndAdd(minus, 2, 3, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button plus = new Button("+");
        setPrefPlusHandlerAndAdd(plus, 3, 3, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        Button equal = new Button("=");
        setPrefPlusHandlerAndAdd(equal, 4, 3, PREF_BUTTON_WIDTH, moreButtons, calcEngine);
        
        //construct interface
        root.add(displayField, 0, 2);
        root.add(hbox, 0, 3);
        root.add(vbox, 0, 4);
        root.add(moreButtons, 1, 4);
        
        group.getChildren().add(menuBar);
        group.getChildren().add(root);
 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	private void setPrefPlusHandlerAndAdd(Button button, int x, int y, int width, 
			GridPane moreButtons, CalculatorEngine calcEngine) {
		button.setPrefWidth(width);
        moreButtons.add(button,x,y);
        button.setOnMouseClicked(calcEngine);
	}

	private void setButtonPropertiesAndEventHandler(Button button,
			String text, int prefWidth, CalculatorEngine calcEngine) {
		button.setText(text);
        button.setPrefWidth(prefWidth);
        button.setOnMouseClicked(calcEngine);
	}
    
    class CalculatorEngine implements EventHandler<MouseEvent>
    {
    	AdvancedCalculator parent;
    	
    	String firstNumber, operator, secondNumber;
    	double result;
    	
    	CalculatorEngine(AdvancedCalculator parent){
    		this.parent = parent;
    	}
    	  	
    	public void displayDigit(Button clickedButton){
    		String dispFieldText = parent.getDisplayFieldValue();
    		String clickedButtonLabel = clickedButton.getText();
    		parent.setDisplayFieldValue(dispFieldText + clickedButtonLabel);
    	}

		@Override
		public void handle(MouseEvent arg0) {
			Button clickedButton = (Button) arg0.getSource();
			
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
				displayDigit(clickedButton);
				break;
			case "+":
			case "-":
			case "/":
			case "*":
				// store first number and operator in corresponding variables
				firstNumber = parent.getDisplayFieldValue();
				operator = clickedButton.getText();
				// erase the number from the display
				parent.setDisplayFieldValue("");
				//print info on system console
				System.out.println("The first number is: " + firstNumber);
				System.out.println("The operation required is: " + operator);
				break;
			case "=":
				//print info on system console
				System.out.println("The second number is: " + parent.getDisplayFieldValue());
				System.out.println("The operation required is " + operator);
				
				//perform the selected action
					if ("+".equals(operator)) {
						result = Double.parseDouble(parent.getDisplayFieldValue()) + Double.parseDouble(firstNumber);
					}
					if ("-".equals(operator)) {
						result =  Double.parseDouble(firstNumber) - Double.parseDouble(parent.getDisplayFieldValue());
					}
					if ("*".equals(operator)) {
						result =  Double.parseDouble(firstNumber) * Double.parseDouble(parent.getDisplayFieldValue());
					}
					if ("/".equals(operator)) {
						//validate input
						if (Double.parseDouble(parent.getDisplayFieldValue()) == 0){
							parent.setDisplayFieldValue("You cannot divide by zero!");
							break;
						}
						else
								result =  Double.parseDouble(firstNumber) / Double.parseDouble(parent.getDisplayFieldValue());
					}
		
				//store result in firstNumber
				firstNumber = String.valueOf(result);
				//display the result
				parent.setDisplayFieldValue(firstNumber);
				break;
			case "Backspace":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "CE":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "C":
				// erase the number or message from the display
				parent.setDisplayFieldValue("");
				break;
			case "MC":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "MR":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "MS":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "M+":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "sqrt":
				//store result in firstNumber
				firstNumber = String.valueOf(Math.sqrt(Double.parseDouble(parent.getDisplayFieldValue())));
				//display the result
				parent.setDisplayFieldValue(firstNumber);
				break;
			case "%":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "1/x":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			case "+/-":
				parent.setDisplayFieldValue("Not yet implemented!");
				break;
			default:
				parent.setDisplayFieldValue("Undefined action");
			}
			
		}

			
		}
    	
    }
    	

