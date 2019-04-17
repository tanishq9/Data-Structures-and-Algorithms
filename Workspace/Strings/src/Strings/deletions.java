package Strings;

public class deletions {

	public static void main(String[] args) {
		String s = "";
		int sum = 0, currentCount = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				sum++;
			}
		}
		System.out.println(sum);
	}

}
