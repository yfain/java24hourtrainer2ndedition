package application;

import javafx.event.ActionEvent;

@FunctionalInterface
public interface CalculatorEngine {
	void processEvent(ActionEvent e, CalculatorPane parent);
}
