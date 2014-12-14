package tryit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	Calculator parent; // a reference to the Calculator
	double currentNumber, enteredNumber;
	String selectedAction;
	boolean dot;

	// Constructor stores the reference to the
	// Calculator window in the member variable parent
	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		// Get the source of this action
		JButton clickedButton = (JButton) e.getSource();
		// Get the existing text from the Calculator�s
		// display field. Reaching inside another object is bad.
		String dispFieldText = parent.getDisplayValue();
		dot = dispFieldText.contains(".");
		if (!dispFieldText.equals(""))
			enteredNumber = Double.parseDouble(dispFieldText);

		if (clickedButton.getText().equals("+")) {
			selectedAction = "+";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");

		} else if (clickedButton.getText().equals("-")) {
			selectedAction = "-";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if (clickedButton.getText().equals("*")) {
			selectedAction = "*";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if (clickedButton.getText().equals("/")) {
			selectedAction = "/";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if ((clickedButton == parent.buttonEqual)
				&& (selectedAction != null)) {
			if (selectedAction.equals("+")) {
				currentNumber += enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("-")) {
				currentNumber -= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("*")) {
				currentNumber *= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("/")) {
				currentNumber /= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			}
		}

		else {

			if (!clickedButton.getText().equals("=")) {
				if ((clickedButton.getText().equals(".")) && dot){}
				else
				{
					// Get the button's label
					String clickedButtonLabel = clickedButton.getText();
					parent.setDisplayValue(dispFieldText + clickedButtonLabel);
				}

			}
		}
	}
}
