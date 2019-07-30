package String;

public class integerToRoman {
	public static String intToRoman(int num) {

		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] M = { "", "M", "MM", "MMM" };

		return M[num / 1000] + "" + C[(num / 100) % 10] + "" + X[(num / 10) % 10] + I[num % 10];

	}

}
