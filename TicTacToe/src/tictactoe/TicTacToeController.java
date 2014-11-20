package tictactoe;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class TicTacToeController {
   
   @FXML Button b1; 
   @FXML Button b2;
   @FXML Button b3;
   @FXML Button b4;
   @FXML Button b5;
   @FXML Button b6;
   @FXML Button b7;
   @FXML Button b8;
   @FXML Button b9;
   
   @FXML GridPane gameBoard;
	
   private boolean isFirstPlayer = true;
   
   public void buttonClickHandler(ActionEvent evt){
		 
		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();
		
		if ("".equals(buttonLabel) && isFirstPlayer){
			clickedButton.setText("X");
			isFirstPlayer = false;
		} else if("".equals(buttonLabel) && !isFirstPlayer){
			clickedButton.setText("O");
			isFirstPlayer = true;
		}
		
		find3InARow();  // is there a winner?
   }	
   
   private boolean find3InARow(){
	   //Row 1
	   if (""!=b1.getText() && b1.getText() == b2.getText() 
		   && b2.getText() == b3.getText()){
		   highlightWinningCombo(b1,b2,b3);
		   return true;
	   }
	   //Row 2
	   if (""!=b4.getText() && b4.getText() == b5.getText() 
		   && b5.getText() == b6.getText()){
		   highlightWinningCombo(b4,b5,b6);
		   return true;
	   }
	   //Row 3
	   if (""!=b7.getText() && b7.getText() == b8.getText() 
		   && b8.getText() == b9.getText()){
		   highlightWinningCombo(b7,b8,b9);
		   return true;
	   }
	   //Column 1
	   if (""!=b1.getText() && b1.getText() == b4.getText() 
		   && b4.getText() == b7.getText()){
		   highlightWinningCombo(b1,b4,b7);
		   return true;
	   }
	   //Column 2
	   if (""!=b2.getText() && b2.getText() == b5.getText() 
		   && b5.getText() == b8.getText()){
		   highlightWinningCombo(b2,b5,b8);
		   return true;
	   }
	   //Column 3
	   if (""!=b3.getText() && b3.getText() == b6.getText() 
		   && b6.getText() == b9.getText()){
		   highlightWinningCombo(b3,b6,b9);
		   return true;
	   }
	   //Diagonal 1
	   if (""!=b1.getText() && b1.getText() == b5.getText() 
		   && b5.getText() == b9.getText()){
		   highlightWinningCombo(b1,b5,b9);
		   return true;
	   }
	   //Diagonal 2
	   if (""!=b3.getText() && b3.getText() == b5.getText() 
		   && b5.getText() == b7.getText()){
		   highlightWinningCombo(b3,b5,b7);
		   return true;
	   }	   
	   return false;
   }
   
   private void highlightWinningCombo(Button first, Button second, Button third){
       first.getStyleClass().add("winning-button");
       second.getStyleClass().add("winning-button");
       third.getStyleClass().add("winning-button");

   }
   
   public void menuClickHandler(ActionEvent evt){
		MenuItem clickedMenu = (MenuItem) evt.getTarget();
		String menuLabel = clickedMenu.getText();
		
		if ("Play".equals(menuLabel)){
			ObservableList<Node> buttons = 
					gameBoard.getChildren();
			
			buttons.forEach(btn -> {
				((Button) btn).setText("");
				 btn.getStyleClass().remove("winning-button");
			});
			
			isFirstPlayer = true;
		}
   }  
}