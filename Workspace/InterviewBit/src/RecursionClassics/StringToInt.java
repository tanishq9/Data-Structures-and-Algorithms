package RecursionClassics;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringToInt("1234", 0));
	}

	private static int stringToInt(String str, int num) {
		if (str.length() == 0) {
			return num;
		}
		char cc = str.charAt(0);
		int offset = cc - 48;
		num = num * 10 + offset;
		return stringToInt(str.substring(1), num);
	}
}
