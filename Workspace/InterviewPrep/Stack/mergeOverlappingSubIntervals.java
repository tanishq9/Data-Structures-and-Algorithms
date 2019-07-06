package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class mergeOverlappingSubIntervals {

	static class Pair implements Comparable<Pair> {
		int start;
		int end;

		Pair(int is, int ie) {
			this.start = is;
			this.end = ie;
		}

		public int compareTo(Pair other) {
			if (this.start < other.start) {
				return -1;
			} else if (this.start > other.start) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Pair[] intervals = new Pair[n];
			for (int i = 0; i < n; i++) {
				intervals[i] = new Pair(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(intervals);
			Stack<Pair> stack = new Stack<>();
			stack.push(intervals[0]);
			for (int i = 1; i < n; i++) {
				int currend = stack.peek().end;
				int currstart = intervals[i].start;
				if (currstart > currend) {
					stack.push(intervals[i]);
				} else {
					// update if more
					stack.peek().end = Math.max(stack.peek().end, intervals[i].end);
				}
			}
			String str = "";
			while (stack.size() > 0) {
				str = (stack.peek().start + " " + stack.peek().end + " ") + str;
				stack.pop();
			}
			System.out.println(str);
		}
	}
}
