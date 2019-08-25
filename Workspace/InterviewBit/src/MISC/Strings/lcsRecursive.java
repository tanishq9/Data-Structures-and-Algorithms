package Strings;

public class lcsRecursive {

	public static void main(String[] args) {
		String str1 = "abag";
		String str2 = "agfg";
		System.out.println(lcsRecursive(str1, str2));
	}

	private static int lcsRecursive(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		char cc1 = str1.charAt(0);
		char cc2 = str2.charAt(0);
		if (cc1 == cc2) {
			return 1 + lcsRecursive(ros1, ros2);
		} else {
			int trimStr1 = lcsRecursive(ros1, str2);
			int trimStr2 = lcsRecursive(str1, ros2);
			return Math.max(trimStr1, trimStr2);
		}
	}

}
