package Recursion;

public class decode {

	public static void main(String[] args) {
		String str = "12";
		System.out.println(decode(str, 0, str.length(), ""));
	}

	private static int decode(String str, int start, int end, String res) {
		if (start == end) {
			System.out.println(res);
			return 1;
		}
		int result = decode(str, start + 1, end, res + str.charAt(start));
		if ((end - start) >= 2 && Integer.valueOf(str.substring(start, start + 2)) <= 26) {
			result += decode(str, start + 2, end, str.charAt(start) + str.charAt(start + 1) + "");
		}
		return result;
	}

}
