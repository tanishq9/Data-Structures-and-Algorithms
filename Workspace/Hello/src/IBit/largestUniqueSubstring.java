package IBit;

import java.util.Arrays;

public class largestUniqueSubstring {

	public static String findLargestUniqueSubstring(String str) {
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		int maxLength = 0, currentLength = 1;
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		visited[str.charAt(0)] = 0;
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			int lastOccurance = visited[str.charAt(i)];
			if (lastOccurance == -1 || (i - currentLength) > lastOccurance) {
				currentLength += 1;
				sb.append(str.charAt(i));
				// System.out.println(sb.toString());
			} else {
				if (maxLength < currentLength) {
					//System.out.println(sb.toString());
					res.setLength(0);
					res.append(sb.toString());
					maxLength = currentLength;
				}
				currentLength = i - lastOccurance;
				sb.setLength(0);
				sb.append(str.substring(lastOccurance + 1, i + 1));
				//System.out.println(sb);
			}
			visited[str.charAt(i)] = i;
		}
		if (maxLength < currentLength) {
			System.out.println(sb.toString());
			res.setLength(0);
			res.append(sb.toString());
			maxLength = currentLength;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(findLargestUniqueSubstring("abcdabceb"));
	}

}
