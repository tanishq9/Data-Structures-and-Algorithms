package Recursion;

public class Practice {

	public static void main(String[] args) {
		String str = "abc";
		printSS(str, "");
		System.out.println();
		printStairs(3, "");
		System.out.println();
		printMazePath(0, 0, 2, 2, "");
		System.out.println();
		int[] arr = { 2, 3, 6, 5 };
		printSubset(arr, 10, 0, "");
		System.out.println();
		int[] elements = { 2, 3, 6, 5 };
		// Do LIS
		// System.out.println(decodings("123"));
	}

	public static void printSS(String str, String sf) {
		if (str.length() == 0) {
			System.out.println(sf);
			return;
		}
		printSS(str.substring(1), sf);
		printSS(str.substring(1), sf + str.charAt(0));
	}

	public static void printStairs(int n, String asf) {
		if (n == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if ((n - i) >= 0) {
				printStairs(n - i, asf + String.valueOf(i));
			}
		}
	}

	public static void printkpc(String ques, String asf) {

	}

	public static void printMazePath(int cr, int cc, int dr, int dc, String asf) {
		if (cr == dr && cc == dc) {
			System.out.println(asf);
			return;
		}
		if (cc < dc) {
			printMazePath(cr, cc + 1, dr, dc, asf + "h");
		}
		if (cr < dr) {
			printMazePath(cr + 1, cc, dr, dc, asf + "v");
		}

	}

	public static void printMazePathMultiMove(int cr, int cc, int dr, int dc, String asf) {

	}

	public static void printSubset(int[] arr, int target, int idx, String asf) {
		if (target == 0) {
			System.out.println(asf);
			return;
		}
		if (target < 0) {
			return;
		}
		if (idx == arr.length) {
			return;
		}
		printSubset(arr, target, idx + 1, asf);
		printSubset(arr, target - arr[idx], idx + 1, asf + arr[idx]);
	}
	
	
	

}
