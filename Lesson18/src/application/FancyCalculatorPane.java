package application;

public class FancyCalculatorPane extends StandardCalculatorPane {
	
	public FancyCalculatorPane(){
		super();
/*		
		setStyle( " -fx-background-color: grey; "
				+ "-fx-text-fill: white;"
				+ "-fx-font-family: \"Times New Roman\";"
				+ "-fx-font-size: 18px;");
*/    	
		setStyle( "-fx-border-radius: 30;"+
		"-fx-border-width:5;"+
		"-fx-border-color:blue;");
		
		// Set button styles  
		
		 setButtonStyles("chocolat");

		 
	}

}
