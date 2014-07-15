import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
 
 Calculator parent; // a reference to the Calculator
	
 // Constructor stores the reference to the 
 // Calculator window in  the member variable parent
 CalculatorEngine(Calculator parent){
   this.parent = parent;
 }

 public void actionPerformed(ActionEvent e){
   // Get the source of this action
   JButton clickedButton =  (JButton) e.getSource();
   	
   // Get the existing text from the Calculator's
   // display field. Reaching inside another object is bad.
   String dispFieldText = parent.getDisplayValue();

   // Get the button's label 
   String clickedButtonLabel = clickedButton.getText();
   	
   parent.setDisplayValue(dispFieldText + 
                                   clickedButtonLabel);
 }
}
