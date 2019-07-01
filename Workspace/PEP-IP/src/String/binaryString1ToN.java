package String;

public class binaryString1ToN {
	public static boolean queryString(String S, int N) {
		// Write your code here
		for (int i = N; i > N / 2; i--) {
			if (!S.contains(Integer.toBinaryString(i))) {
				return false;
			}
		}
		return true;
	}
}
