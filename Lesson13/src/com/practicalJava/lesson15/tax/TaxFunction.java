package com.practicalJava.lesson15.tax;

@FunctionalInterface
public interface TaxFunction {
	double calcTax(double grossIncome, String state);
}
