package UHG;

public class permutationsString {

	public static void main(String[] args) {
		String str = "abc";
		permute(str, 0);
	}

	public static void permute(String str, int i) {
		if (i >= str.length()) {
			System.out.println(str);
			return;
		}
		for (int j = i; j < str.length(); j++) {
			str = swap(str, i, j);
			permute(str, i + 1);
			str = swap(str, i, j);
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
