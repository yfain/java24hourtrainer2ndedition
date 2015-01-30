package tryit;

public class DBParamProcessor {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Provide the name of the annotated class as a command-line argument.");
			System.out.println("For example, java DBParamProcessor tryit.MyDBWorker");
			System.exit(1);
		}

		String annotatedClass = args[0];

		try {
			Class classForIntrospection = Class.forName(annotatedClass);

			DBParam dbParamAnnotation = (DBParam) classForIntrospection.getAnnotation(DBParam.class);
			System.out.println("DB Name: " + dbParamAnnotation.dbName());
			System.out.println("User ID: " + dbParamAnnotation.uid());
			System.out.println("Password: " + dbParamAnnotation.password());

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
