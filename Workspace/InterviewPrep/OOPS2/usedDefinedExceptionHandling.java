package OOPS2;

public class usedDefinedExceptionHandling {
	// A user defined exception class is a subclass of the Exception class
	public static class GreaterNumberException extends Exception {
		// write a default constructor
		// We can also create a parameterized constructor
		public GreaterNumberException() {
			// We can call super class(Exception) constructor from this
			super();
			System.out.println("Triggered.");
		}
	}

	public static void main(String[] args) {
		int num = 0;
		try {
			for (int i = 0; i < 5; i++) {
				if (num > 3) {
					// custom error exception ko hamesha throw karna padhta hai
					throw new GreaterNumberException(); // yeh seedha catch block mei jayegi ab
				} else {
					System.out.println(num);
				}
				num++;
			}
		} catch (GreaterNumberException gne) {
			// If not caught main thread mei exception aa jayega
			System.out.println("Number got greater than 3");
		}

		System.out.println("See even after some error, I am able to execute further statements");
		System.out.println("This is because we have caught(catch) the run time exception in main thread");
	}

}
