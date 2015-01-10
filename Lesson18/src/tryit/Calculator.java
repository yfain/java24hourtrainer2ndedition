package tryit;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Calculator extends Application {
	
	List<Node> buttons= new ArrayList<>();
	EventHandler<ActionEvent> calculatorController;
	
	TextField displayField = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
	
		// Create the instance of the calculator engine - 
		// the controller - to handle GUI events
		calculatorController	 = new CalculatorController(this);
		
		try {
			BorderPane root = new BorderPane();
			
            // Top - a display field
			// displayField = new TextField();
			BorderPane.setAlignment(displayField,Pos.CENTER);
			root.setTop(displayField);
			
			
			// Center - a grid pane with buttons
			GridPane buttonsPanel = new GridPane();
			buttonsPanel.setVgap(5.0);
			buttonsPanel.setHgap(5.0);
			buttonsPanel.setAlignment(Pos.CENTER);
			buttonsPanel.setPadding(new Insets(10,10,10,10));
			root.setCenter(buttonsPanel);
			
			// Create buttons an add them to the List buttons
			createButton("MC", 0,0,1,1);
			createButton("M+", 1,0,1,1);
			createButton("M-", 2,0,1,1);
			createButton("MR", 3,0,1,1);
			
			createButton("C",  0,1,1,1);
			createButton("+ -", 1,1,1,1);
			createButton("/", 2,1,1,1);
			createButton("X", 3,1,1,1);
			
			createButton("7",  0,2,1,1);
			createButton("8", 1,2,1,1);
			createButton("9", 2,2,1,1);
			createButton("-", 3,2,1,1);

			createButton("4",  0,3,1,1);
			createButton("5", 1,3,1,1);
			createButton("6", 2,3,1,1);
			createButton("+", 3,3,1,1);
			
			createButton("1",  0,4,1,1);
			createButton("2", 1,4,1,1);
			createButton("3", 2,4,1,1);
			createButton("=", 3,4,1,2);
			
			createButton("0",  0,5,2,1);
			createButton(".", 2,5,1,1);
			
			buttonsPanel.getChildren().addAll(buttons);
			
			Scene scene = new Scene(root,435,265);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	private void createButton(String label, int x, int y, int colSpan, int rowSpan) {
		Button button = new Button(label);
		
		GridPane.setConstraints(button, x, y, colSpan, rowSpan);
		button.setPrefHeight(37.0);
		button.setPrefWidth(132.0);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);
		button.setOpaqueInsets(new Insets(5,5,5,5));
		
		button.setOnAction(calculatorController);
		buttons.add(button);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
