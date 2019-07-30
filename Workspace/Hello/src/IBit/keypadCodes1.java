package IBit;

public class keypadCodes1 {

	public static void main(String[] args) {
		String str = "12345";
		char c = 'a';
		int asciiOfC = c + 2;
		String s = "12";
		String st = String.valueOf(asciiOfC);
		System.out.println((char) asciiOfC);
		// System.out.println(asciiOfC);
		System.out.println(keypadCodes(str, 0, str.length() - 1, ""));
	}

	private static int keypadCodes(String str, int start, int end, String result) {
		if (start == end) {
			System.out.println(result);
			return 1;
		}
		int res = keypadCodes(str, start + 1, end, result);
		if ((end - start) >= 1 && Integer.valueOf(str.substring(start, start + 2)) <= 26) {
			res += keypadCodes(str, start + 2, end,
					result + Integer.valueOf(Integer.valueOf(str.substring(start, start + 2)) + 96));
		}
		return res;
	}
}
