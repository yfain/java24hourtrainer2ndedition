class Tax {
    double grossIncome; // class member variables
    String state;
    int dependents;
    static int customerCounter;
   
    // Constructor
    Tax (double gi, String st, int depen){
       grossIncome = gi;  // member variable initialization
       state = st;
       dependents=depen;
       customerCounter++;   // increment the counter by one
       
       System.out.println("Preparing the tax data for customer #" + customerCounter);
    }
    
    public double calcTax() { 
    	return (grossIncome*0.33 - dependents*100);
    }
    
    public void convertToEuros(double taxInDollars){
        System.out.println("Tax in Euros: " + taxInDollars/1.25);
    }	
    
}
