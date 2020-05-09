package Array;

public class stringCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "12";
		String str2 = "15";
		// Mimicking the behavior of compareTo method in string
		// (int)str1.charAt(i) - (int)str2.charAt(i) is computed
		// if not equal we return the difference
		// otherwise we return difference in length
		// this concept is used in the question : maxNumArray
		// (max number that can be formed from array)
		System.out.println(compare(str1, str2));
	}

	private static int compare(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		int lmin = Math.min(l1, l2);
		for (int i = 0; i < lmin; i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if ((int) c1 != (int) c2) {
				return c1 - c2;
			}
		}
		if (l1 != l2) {
			return l1;
		}
		return 0;
	}
}
