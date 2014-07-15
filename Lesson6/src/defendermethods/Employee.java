package defendermethods;
class Employee extends Person implements Payable, Promotionable{
   public static void main(String[] args){
	   Employee emp = new Employee();
	   emp.increasePay(10);
   }
}
