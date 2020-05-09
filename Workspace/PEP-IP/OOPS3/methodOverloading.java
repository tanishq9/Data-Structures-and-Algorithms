package OOPS3;

public class methodOverloading {

	public int add(int a, int b) {
		return a + b;
	}

	// different number of parameters
	public int add(int a, int b, int c) {
		return a + b + c;
	}

	// different type of parameters
	public int add(int a, double b) {
		return a + (int) b;
	}

	// different order of parameters
	public int add(double a, int b) {
		return (int) a + b;
	}

	public static void main(String[] args) {

	}
}
