package Crio_Launch_HackerRank_Java;

public class Java_Generics {
	class Printer {
		// Write your code here
		<T> void printArray(T[] arr) {
			for (T element : arr) {
				System.out.println(element);
			}
		}
	}
}
