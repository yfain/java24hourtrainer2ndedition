public class TestStackTrace {
	TestStackTrace()    
	{
	   // Produces thre line stack trace		
       divideByZero();
    }
	
    int divideByZero()
    {
       return 25/0;
    }

    public static void main(String[] args)
    {
           new TestStackTrace();

    }
}
