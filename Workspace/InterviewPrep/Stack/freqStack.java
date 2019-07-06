package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class freqStack {
	static class FreqStack {
		Map<Integer, Integer> freq;
		Map<Integer, Stack<Integer>> group;
		int maxfreq;

		public FreqStack() {
			freq = new HashMap<>();
			group = new HashMap<>();
			maxfreq = 0;
		}

		public void push(int x) {
			int f = freq.getOrDefault(x, 0) + 1;
			freq.put(x, f);
			if (f > maxfreq)
				maxfreq = f;

			group.computeIfAbsent(f, z -> new Stack()).push(x);
		}

		public int pop() {
			int x = group.get(maxfreq).pop();
			freq.put(x, freq.get(x) - 1);
			if (group.get(maxfreq).size() == 0)
				maxfreq--;
			return x;
		}
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FreqStack fs = new FreqStack();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (s.equals("DensityStack")) {
				System.out.println("null");
			} else if (s.charAt(1) == 'u') {
				int x = sc.nextInt();
				fs.push(x);
				System.out.println("null");
			} else {
				System.out.println(fs.pop());
			}

		}
	}

}
