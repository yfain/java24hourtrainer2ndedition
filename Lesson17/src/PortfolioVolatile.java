class PortfolioVolatile extends Thread{

private volatile Thread stopMe;

    public PortfolioVolatile (String threadName) {
          super(threadName);  
    }
    
    public void stopMe() {
        stopMe = null;
    }

    public void run() {
    	stopMe = Thread.currentThread();
    	
        while (stopMe == Thread.currentThread()) {
         //Do some portfolio processing here 
         System.out.println("The Portfolio thread is running");
        	
        }
       System.out.println("The Portfolio thread was killed");
  }
}    