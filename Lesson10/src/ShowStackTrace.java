public class ShowStackTrace {

    public static int divideByZero()
    {
       return 25/0;
    }

    public static void main(String[] args)
    {
       // Produces two line stack trace	
       ShowStackTrace.divideByZero();
    }
}