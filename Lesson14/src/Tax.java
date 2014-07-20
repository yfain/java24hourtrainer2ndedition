class Tax {
    double grossIncome; // class member variables
    String state;
    int dependents;
   
    // First Constructor
    Tax (double grossIncome, String state, int dependents){
       this.grossIncome = grossIncome;  // instance variable initialization
       this.state = state;
       this.dependents=dependents;
    }

   // Second Constructor
    Tax (double grossIncome, int dependents){
       this(grossIncome, "NY", dependents); 
    }
    public double calcTax() {         
        double  stateTax=0;
        if (grossIncome < 30000) {
          stateTax=grossIncome*0.05;
        }
        else{
          stateTax= grossIncome*0.06;
        } 
          return stateTax;
  }

}
