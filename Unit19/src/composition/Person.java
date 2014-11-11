package composition;

public class Person {

  String name;
  Payable validator_func;

  public Person(String name, Payable validator_func) {
    this.name = name;
    this.validator_func = validator_func;
  }

 public void tryIncrease(int percent) {
    if (validator_func.increasePay(percent)) {
      System.out.println("Pay increase of " + percent + " approved for " + name );
    } else {
      System.out.println("Can't increase pay for " + name + " by " + percent);
    }
 }
}