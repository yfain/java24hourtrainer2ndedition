package com.practicalJava.lesson15.tax;

public class Customer {
	public String name;
	public double grossIncome;
	public String state;

	public void applyTaxCalcFunction(TaxFunction taxFunc) {

		double calculatedTax = taxFunc.calculateTax(grossIncome, state);
		System.out.println("The calculated tax for " + name + " is "
				+ calculatedTax);

	}
}