package superdemo;

// A demo of using the super keyword

public class Y extends X {
   void a(){
     new Thread(() -> Y.super.a()).start();
 }
 
  public static void main(String[] args){

	  new Y().a();
  }
}
