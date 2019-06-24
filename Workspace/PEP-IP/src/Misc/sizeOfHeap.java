package Misc;

public class sizeOfHeap {
	private static int solve(int N) {
		// Write your code here
		// Height of heap : ceil(log(n+1)-1)
		int h = 0;
		while ((1 << h) < (N + 1)) {
			h++;
		}
		return h - 1;
	}
}
