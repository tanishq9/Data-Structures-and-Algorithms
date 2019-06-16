package Array;

import java.util.LinkedList;
import java.util.Scanner;

public class firstNonRepeatingQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next().charAt(0);
			}
			LinkedList<Character> q = new LinkedList<>();
			int[] freq = new int[26];
			for (int i = 0; i < n; i++) {
				char cc = arr[i];
				int offset = cc - 'a';
				freq[offset]++;
				q.add(cc);
				if (freq[offset] > 1) {
					q.remove();
				} else {
					System.out.print(q.peek() + " ");
				}

				if (q.size() == 0) {
					System.out.print("-1 ");
				}
			}
			System.out.println();
		}
	}

}
