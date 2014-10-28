package tax;

class Tax{   
    double grossIncome;
    double federalTax;

    public void calcTax() {

        if (grossIncome < 30000) {
          federalTax=grossIncome*0.05;
        }
        else{
          federalTax= grossIncome*0.06;
        }
  } 
}
