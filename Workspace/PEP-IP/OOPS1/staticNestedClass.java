package OOPS1;

public class staticNestedClass {

	static int count = 5;

	static class staticT1 {
		public void display() {
			System.out.println(count);
		}

		public static void displayAnother() {
			System.out.println(count);
		}
	}

	class non_staticT1 {
		public void display() {
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		// without creating a reference of the class
		// we can access the its 'nested' static class
		// and even access the nested static class's static methods
		staticNestedClass.staticT1.displayAnother();
	}

}
