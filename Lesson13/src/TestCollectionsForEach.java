import java.util.Arrays;
import java.util.List;

import collections.Person;

public class TestCollectionsForEach {
	
  public static void main(String[] args) {

        Person workers[] = new Person[3];
		workers[0] = new Person("John", 'E');
		workers[1] = new Person("Mary", 'C');
		workers[2] = new Person("Steve", 'E');	
		
		List<Person> workersList = Arrays.asList(workers);
		
		// Imperative loop
		System.out.println("1. Running imperative loop");
		for (Person p: workersList){
			if ('E'==p.getWorkerStatus()){
				System.out.println(p.getName() + " is employee");
			} else if ('C'==p.getWorkerStatus()){
				System.out.println(p.getName() + " is contractor");			
			}
		}
		
		// Functional loop
		System.out.println("2. Running functional loop");
        workersList.forEach(pers -> {
        	if ('E'==pers.getWorkerStatus()){
				System.out.println(pers.getName() + " is employee");
			} else if ('C'==pers.getWorkerStatus()){
				System.out.println(pers.getName() + " is contractor");			
			}
        });
	
  }

}
