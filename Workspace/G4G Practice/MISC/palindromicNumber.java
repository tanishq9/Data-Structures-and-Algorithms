package IBit;

public class palindromicNumber {
	public static int isPalindrome(int A) {
		StringBuilder sb = new StringBuilder(String.valueOf(A));
		System.out.println(sb.toString());
		int i = 0, j = sb.length() - 1;
		while (i < j) {
			if (sb.charAt(i) != sb.charAt(j)) {
				return 0;
			}
			i++;
			j--;
		}
		return 1;
	}

	public static void main(String[] args) {
		StringBuilder str=new StringBuilder(String.valueOf(2212));
		System.out.println(str.toString());
		//System.out.println(isPalindrome(223));
	}
}
