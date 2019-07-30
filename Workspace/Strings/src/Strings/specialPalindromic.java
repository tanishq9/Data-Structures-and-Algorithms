package Strings;

public class specialPalindromic {

	public static void main(String[] args) {
		String str = "aadaa";
		countSpecialPalindromic(str);// works in O(n^3)
	}

	private static void countSpecialPalindromic(String str) {

		char left, right, current;
		Boolean flag;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				flag = true;
				current = str.charAt(i);
				for (int k = i, x = j; k < x; k++, x--) {
					left = str.charAt(k);
					right = str.charAt(x);
					if (left == current && right == current) {

					} else {
						flag = false;
					}
				}
				if (flag == true) {
					count++;
					// System.out.println(str.substring(i, j + 1));
				}
			}
		}
		System.out.println(count);
	}

}
