public class SuppressWarningDemo {

	 @SuppressWarnings("fallthrough") 
	public static void main(String[] args) {
		int salaryBand=3;
        int bonus;
	 // Retrieve the salary band of the person from some data source here
		switch(salaryBand){
		 case 1:
			bonus=1000;
			System.out.println("Giving bonus " + bonus);
			break;
		 case 2:
			bonus=2000;
			System.out.println("Giving bonus " + bonus);
			break;
		 case 3:
			bonus=6000;
			System.out.println("Giving bonus " + bonus);
		 case 4:
			bonus=10000;
			System.out.println("Giving bonus " + bonus);
			break;
		 default:
		      // wrong salary band
              System.out.println("Invalid salary band");	
		} 
	}

}
