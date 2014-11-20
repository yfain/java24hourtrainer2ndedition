class Tax{   
          double grossIncome;
          String state;
          int dependents;
      
          public double calcTax() {
           
             //return 234.55;  
        	  
        	  if (grossIncome <= 50000){
        		  return grossIncome*0.06;
        	  } else {
        		  return grossIncome*0.08;
        	  }
        	  
        	  
          }
}
