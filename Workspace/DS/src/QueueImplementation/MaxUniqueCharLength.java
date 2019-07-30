package QueueImplementation;

import java.util.Scanner;

public class MaxUniqueCharLength {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = "abf";
		int[] visited = new int[256];
		for (int i = 0; i < 256; i++) {
			visited[i] = -1;// initially the latest position of all elements occurring is -1
		}
		visited[str.charAt(0)] = 0;
		int max_length = 1, current_length = 1;
		for (int i = 1; i < str.length(); i++) {
			int lastOccurence = visited[str.charAt(i)];
			// Expansion
			if (lastOccurence == -1 || (i - current_length) > lastOccurence) {
				// ya toh pehle kabhi aaya hi nahi ya fir aaya tha par current vali window mei
				// nahi hai
				current_length++;
				// max_length = Integer.max(current_length, max_length);
			}
			// Expansion and Contraction
			else {
				if (current_length > max_length) {
					max_length = current_length;
				}
				current_length = i - lastOccurence;
			}
			visited[str.charAt(i)] = i;// update the latest position of occurrence of element in the visited array
		}
		if (current_length > max_length) {
			max_length = current_length;
		}
		System.out.println(max_length);
	}
}
