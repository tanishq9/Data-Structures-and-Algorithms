package Creational;

class Abc {
	private static final Abc abc = new Abc();

	// Private constructor to restrict the instantiation of the class from other
	// classes
	private Abc() {
	}

	public static Abc getInstance() {
		return abc;
	}
}

public class Singleton {
	// Singleton pattern limits the instantiation of class and makes sure that only
	// one instance class has been created
	// Example : used in case of shared resources like in case of thread pool
	// Thread pool maintains multiple threads waiting for tasks to be executed
	public static void main(String[] args) {
		Abc obj = Abc.getInstance();
		System.out.println(obj.hashCode());
		Abc obj2 = Abc.getInstance();
		System.out.println(obj2.hashCode());
	}

}
