import com.practicaljava.lesson7.Person;
import com.practicaljava.lesson7.Contractor;
import com.practicaljava.lesson7.Employee;

public class TestPayIncrease {

      public static void main(String[] args) {

        Person workers[] = new Person[3];
              workers[0] = new Employee("John");
              workers[1] = new Contractor("Mary");
              workers[2] = new Employee("Steve");

              for (Person p: workers){
                        p.promote(30);
              }
        }
}