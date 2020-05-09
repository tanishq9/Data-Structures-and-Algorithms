package HashMap;

import java.util.Scanner;

public class smallestDistinctWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();

			boolean[] visited = new boolean[26];
			int numDistinct = 0;
			for (int i = 0; i < str.length(); i++) {
				if (visited[str.charAt(i) - 'a'] == false) {
					numDistinct++;
					visited[str.charAt(i) - 'a'] = true;
				}
			}

			// System.out.println(numDistinct);

			int start = 0; // for releasing
			int end = 0; // for acquiring
			int currentDistinct = 0;
			int minSize = Integer.MAX_VALUE;
			int[] count = new int[26];

			for (end = 0; end < str.length(); end++) {
				count[str.charAt(end) - 'a']++;
				if (count[str.charAt(end) - 'a'] == 1) {
					currentDistinct++;
				}
				// After finding a valid window, we try to optimize it's length
				if (currentDistinct == numDistinct) {
					// Potentially moving towards a smaller window
					while (count[str.charAt(start) - 'a'] > 1) {
						count[str.charAt(start) - 'a']--;
						start++;
					}
					// Update the length
					minSize = Math.min(minSize, end - start + 1);
				}
			}
			minSize = Math.min(minSize, end - start + 1);
			System.out.println(minSize);
		}
	}
}
