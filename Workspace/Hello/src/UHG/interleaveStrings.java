package UHG;

public class interleaveStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "xxx";
		String b = "xxz";
		String c = "xxzxxxy";
		System.out.println(isInterleaving(a, b, c));
	}

	private static Boolean isInterleaving(String a, String b, String c) {
		if (a.length() == 0 || b.length() == 0 || c.length() == 0) {
			return true;
		}
		if (c.length() == 0) {
			return false;
		}
		return (a.charAt(0) == c.charAt(0) && isInterleaving(a.substring(1), b, c.substring(1)))
				|| (b.charAt(0) == c.charAt(0) && isInterleaving(a, b.substring(1), c.substring(1)));
	}

}
