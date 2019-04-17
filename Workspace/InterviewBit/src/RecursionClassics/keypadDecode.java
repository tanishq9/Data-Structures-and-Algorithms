package RecursionClassics;

public class keypadDecode {

	public static void main(String[] args) {
		String str = "123";
		int total = genCodes(str, 0, str.length() - 1, "");
		System.out.println(total);
	}

	private static int genCodes(String str, int start, int end, String result) {
		if (start == end + 1) {
			System.out.println(result);
			return 1;
		}
		int total = genCodes(str, start + 1, end, result + (char) ((int) str.charAt(start) + 48));
		if ((end - start) >= 1 && Integer.valueOf(str.substring(start, start + 2)) <= 26) {
			total += genCodes(str, start + 2, end,
					result + (char) (Integer.valueOf(str.substring(start, start + 2)) + 96));
		}
		return total;
	}
}
