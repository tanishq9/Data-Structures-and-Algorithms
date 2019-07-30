package OOPS1;

public class Test2 {
	public static void main(String[] args) {
		// only because the scope of the class is default
		// it can be accessed in other class of the same package
		Test1 t1 = new Test1();
		// var2 is public therefore can be access outside that package as well
		System.out.println(t1.var2);
		// System.out.println(t1.var1); : Cannot do this
	}
}
