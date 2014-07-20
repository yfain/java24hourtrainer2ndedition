package com.practicalJava.lesson15.tax;

class TaxF{   

 public static double calcTax(double grossIncome, String state) {
        double stateTax=0;
        if (grossIncome < 30000) {
          stateTax=grossIncome*0.05;
        }
        else{
          stateTax= grossIncome*0.06;
        }
          return stateTax;
  }  
}
