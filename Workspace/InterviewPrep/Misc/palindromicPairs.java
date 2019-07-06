package Misc;

import java.util.ArrayList;
import java.util.Scanner;

public class palindromicPairs {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					String word = words[i] + words[j];
					list.add(word);
				}
			}
		}
		int count = 0;
		for (String s : list) {
			if (isPalindrome(s)) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (i <= j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
