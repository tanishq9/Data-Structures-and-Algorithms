package SubArray;

import java.util.Arrays;

public class largestUniqueSubString {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int current_length = 1, max_length = 0;
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		visited[str.charAt(0)] = 0;
		for (int i = 1; i < str.length(); i++) {
			int last_Occurance = visited[str.charAt(i)];
			if (last_Occurance == -1 || (i - current_length) > last_Occurance) {
				current_length += 1;
			} else {
				if (current_length > max_length) {
					max_length = current_length;
				}
				current_length = i - last_Occurance;
			}
			visited[str.charAt(i)] = i;
		}
		if (current_length > max_length) {
			max_length = current_length;
		}
		System.out.println(max_length);
	}
}
