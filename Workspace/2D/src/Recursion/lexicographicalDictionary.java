package Recursion;


public class lexicographicalDictionary {

	public static void main(String[] args) {
		lexico(20);
	}

	private static void lexico(int num) {
		for (int i = 1; i <= 9; i++) {
			lexicohelper(i, num);
		}
	}

	private static void lexicohelper(int numSoFar, int num) {
		if (numSoFar > num) {
			return;
		}
		System.out.println(numSoFar);
		for (int i = 0; i <= 9; i++) {
			lexicohelper(numSoFar * 10 + i, num);
		}
	}

}
