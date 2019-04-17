package Recursion;

public class subseq {

	private static void subseq(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		String ros = str.substring(1);
		char cc = str.charAt(0);
		subseq(ros, result + cc);
		subseq(ros, result);
	}

	public static void main(String[] args) {
		String str = "abc";
		subseq(str, "");
	}
}
