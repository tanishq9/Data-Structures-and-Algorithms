package OOPS1;

// this class can only be extended within this package
// because no access modifier is specified
// to make other classes inherit this class
// this class 'Test' has to be made public
public class Test1 {
	// this private class has scope within this class
	private class D1 {

	}

	private int var1 = 1;
	public int var2 = 2; // everywhere
	protected int var3 = 3;// scope outside package but only in sub class
	int var4 = 4;
	
	
	static void main(String[] args) {
		
	}
}
