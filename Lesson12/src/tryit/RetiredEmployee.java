package tryit;

public class RetiredEmployee extends Employee {

	private Double pensionAmount;

	public RetiredEmployee(String name, Double pensionAmount) {
		super(name);
		this.pensionAmount = pensionAmount;
	}

	public Double getPension() {
		return pensionAmount;
	}

	public void setPension(Double pension) {
		this.pensionAmount = pension;
	}
}
