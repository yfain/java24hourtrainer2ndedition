package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class HBoxSample extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		Label emailLbl = new Label("Email:");
		
		TextField emailTxt = new TextField();
		emailTxt.setPrefColumnCount(20);
		emailTxt.setPromptText("Your email"); 	
		
		Button submitBtn = new Button("Submit");
		
		VBox emailBox = new VBox(5);  // spacing between children 5 px
		emailBox.setPadding(new Insets(3));  // space around HBox
		emailBox.getChildren().addAll(emailLbl, emailTxt, submitBtn);
		
		Scene scene = new Scene(emailBox,750,100);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
