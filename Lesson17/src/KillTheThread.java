class KillTheThread{
  public static void main(String args[]){
    	 
     PortfolioVolatile p = new PortfolioVolatile("Portfolio data");
     p.start();

     // Some code implementation business logic goes here
     int i=0;
     do {
    	System.out.println(" i= " + i++); 
     }while (i<100);  
     
     // and now it's time to kill the thread
     p.stopMe();
  }
}