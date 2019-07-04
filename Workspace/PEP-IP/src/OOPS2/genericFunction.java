package OOPS2;

import java.util.ArrayList;

public class genericFunction {

	// <T> mention this thing before return type of function
	static <T> void display(T element) {
		System.out.println(element.getClass());
	}

	// <T,S> mention
	static <T, S> void displayAnother(T e, S f) {
		System.out.println(e.getClass() + " " + f.getClass());
	}

	// when we write comparable<T> it means only
	// those parameters are allowed who have implemented
	// comparable interface
	static <T extends Comparable<T>> void sort(T[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input[j].compareTo(input[j + 1]) == 1) {
					// swap thing
				}
			}
		}
	}

	public static void main(String[] args) {
		display("AbC");
		displayAnother("Text", 18);

		ArrayList al = new ArrayList();
		al.add(0);
		// Individual type casting is required
		int i = (int) al.get(0);
		
	}

}
