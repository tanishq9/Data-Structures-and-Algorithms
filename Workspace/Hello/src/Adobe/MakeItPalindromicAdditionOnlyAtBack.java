package Adobe;

public class MakeItPalindromicAdditionOnlyAtBack {

	public static void main(String[] args) {
		String str = "aacecaaaa";
		// Check the first and the last char of the string if they are equal
		// If so then check if that string is Palindrome or not
		StringBuilder sb = new StringBuilder(str);
		sb=sb.reverse();
		int ans = 0;
		for (int i = 0; i < sb.length();) {
			if (sb.charAt(i) == sb.charAt(sb.length() - 1)) {
				if (isPalindromic(sb, i)) {
					break;
				} else {
					ans += 1;
					i++;
				}
			} else {
				ans += 1;
				i++;
			}
		}
		System.out.println(ans);
	}

	public static Boolean isPalindromic(StringBuilder str, int low) {
		int high = str.length() - 1;
		while (low <= high) {
			if (!(str.charAt(low) == str.charAt(high))) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}

}
