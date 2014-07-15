
public class Strings {
  
	public static void main(String[] args){
		
// StringBuffer
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("Mary");
		sbf.append(" Smith");

		String fullName = sbf.toString();  // Converting back to String
		
		System.out.println("StringBuffer, fullname = " + fullName);
		
// StringBuilder
		
		StringBuilder sbld = new StringBuilder(50);
		sbld.append("Mary");
		sbld.append(" Smith");

		fullName = sbld.toString(); // Converting back to String
		System.out.println("StringBuilder, fullname = " + fullName);
		
// Comparing Strings
		String friend1=new String("Mary");
		String friend2=new String("Joe");
		String friend3=new String("Mary");
		
		System.out.println("Is friend1==friend3? " + (friend1==friend3));
		System.out.println("Is friend1.equals(friend3)? " + (friend1.equals(friend3)));
		
	}
}
