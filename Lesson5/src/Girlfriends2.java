public class Girlfriends2 {

       public static void main(String[] args) {
              String [] friends = new String [20];
              friends[0] = "Masha";
              friends[1] = "Matilda";
              friends[2] = "Rosa";
              friends[18] = "Hillary";
              friends[19] = "Natasha";

              int  totalElements = friends.length;
              int i;
              for (i=0; i<totalElements;i++){
                 System.out.println("I love " + friends[i]);
              }
       }
}