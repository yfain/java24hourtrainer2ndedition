package com.practicalJava.lesson15.tax;

@FunctionalInterface
public interface TaxFunction {
	double calculateTax(double grossIncome, String state);
}
