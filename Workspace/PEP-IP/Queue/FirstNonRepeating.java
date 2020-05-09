package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstNonRepeating {
	public static void uniqueChar(char[] str) {
		LinkedList<Character> q = new LinkedList<>();
		int[] freq = new int[26];
		for (int i = 0; i < str.length; i++) {
			char cc = str[i];
			int offset = cc - 'a';
			freq[offset]++;
			q.add(cc);
			while (q.size() > 0) {
				if (freq[q.peek() - 'a'] > 1) {
					q.remove();
				} else {
					System.out.print(q.peek() + " ");
					break;
				}
			}
			if (q.size() == 0) {
				System.out.print("-1 ");
			}
		}

	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char ch[] = new char[n];

		for (int i = 0; i < n; i++) {
			ch[i] = sc.next().charAt(0);

		}
		uniqueChar(ch);

	}
}
