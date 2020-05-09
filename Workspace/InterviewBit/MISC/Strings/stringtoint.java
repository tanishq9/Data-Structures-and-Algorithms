package Strings;

public class stringtoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-12";
		Boolean isNegative = false;
		if (str.charAt(0) == '-') {
			isNegative = true;
		}
		int result = StringToInt(str);
		if (isNegative) {
			System.out.println("-" + result);
		} else {
			System.out.println(result);
		}
	}

	static int StringToInt(String str) {
		int i, result = 0;
		if (str.charAt(0) == '-') {
			i = 1;
		} else {
			i = 0;
		}
		for (; i < str.length(); i++) {

			int convertedWord = str.charAt(i) - '0';
			result = result * 10 + convertedWord;
		}
		return result;
	}

}
