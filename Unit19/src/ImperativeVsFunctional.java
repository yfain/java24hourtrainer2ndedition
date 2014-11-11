import java.util.ArrayList;
import java.util.List;

public class ImperativeVsFunctional {

    public static void main(String[] args) {

        List<String> winners = new ArrayList<>();

        winners.add("Mary");
        winners.add("Ringo");
        winners.add("Joe");
        winners.add("Paul");

  // Imperative
        boolean gotRingo = false;
        for (String winner: winners){
            if ("Ringo".equals(winner)){
                gotRingo = true;
                System.out.println("Imperative style. Ringo won? " + gotRingo);
                break;
            }
        }

 //Functional
        System.out.println("Functional style. Ringo won? " + winners.contains("Ringo"));

    }
}