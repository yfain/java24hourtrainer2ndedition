package application;

public class FancyCalculatorPane extends StandardCalculatorPane {
	
	public FancyCalculatorPane(){
		super();
		
		setStyle( " -fx-background-color: grey; "
				+ "-fx-text-fill: white;"
				+ "-fx-font-family: \"Times New Roman\";"
				+ "-fx-font-size: 18px;");
    	
		// Set button styles  
		
		 setButtonStyles("big-yellow");
		// setButtonStyles("iphone");
		// setButtonStyles("green");
		// setButtonStyles("shiny-orange");
		// setButtonStyles("round-red");
		 
	}

}
