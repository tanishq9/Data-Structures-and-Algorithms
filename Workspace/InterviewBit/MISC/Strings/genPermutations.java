package Strings;

public class genPermutations {

	public static void main(String[] args) {
		String str = "abc";
		printPermutations(str, "");
	}

	private static void printPermutations(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, result + cc);
		}
	}

}
