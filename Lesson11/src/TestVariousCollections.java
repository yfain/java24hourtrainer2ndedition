import java.util.*;
<<<<<<< HEAD
import java.util.Queue;
import java.util.LinkedList;

public class TestVariousCollections {

    /**
     * @param args
     */
    public static void main(String[] args) {

        HashSet sss = new HashSet();
        sss.add("Mary");
        sss.add("Mary");

        ArrayList aaa = new ArrayList();

        aaa.add("Mary");
        aaa.add("Mary");

        Vector bbb = new Vector();

        Map map = new HashMap();
        map.put("customer", new Customer("John", "Smith"));
        map.put("order", new Order());

    }
=======

public class TestVariousCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		HashSet sss = new HashSet();
		sss.add("Mary");
		sss.add("Mary");
			
		ArrayList aaa = new ArrayList();
		
		aaa.add("Mary");
		aaa.add("Mary");
		
		Vector bbb = new Vector();
		
		HashMap hm=new HashMap();
		hm.put("customer", new Customer("John", "Smith")); 
		hm.put("order", new Order());
	}
>>>>>>> 3d18358fc37bf5522b3b5a77dcd944099c2eb7e5

}
