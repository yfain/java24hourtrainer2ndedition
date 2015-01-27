package tax;

interface Taxable {

	double calcTax(double grossIncome, int dependents) 
			 throws IllegalArgumentException;

	double applyStudentDeduction(double taxAmount, int numOfStudents);
}