package OOPS1;

public class finalKeyword {

	final int num = 0;
	static int count = 5;
	final int num2;
	final static int count2;

	{
		num2 = 10;
	}

	static {
		count2 = 10;
	}

	public void fun() {
		System.out.println(this.count);
	}
	
	public static void fun_static() {
		// System.out.println(this.num); not valid here
	}

	public static void main(String[] args) {

	}
}
