public class Girlfriends1 {

 public static void main(String[] args) {
    String [] friends = new String [20]; // Declare and instantiate array
    friends[0] = "Masha";             //Initialize the first element
    friends[1] = "Matilda";           //Initialize the second element
    friends[2] = "Rosa";
    // ...
    friends[18] = "Hillary";
    friends[19] = "Natasha";

    System.out.println("The third girl's name is " + friends[2]);
    System.out.println("The twentieth girl's name is " + friends[19]);
 }
}