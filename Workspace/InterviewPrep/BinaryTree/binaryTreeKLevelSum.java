package BinaryTree;

import java.util.Scanner;

public class binaryTreeKLevelSum {
	public static void main(String[] args) {
		// write your code here.
		Scanner ab = new Scanner(System.in);
		int K = Integer.parseInt(ab.nextLine().trim());
		String str = new String(ab.nextLine().trim());
		int open = 0, sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (cc == '(') {
				open++;
			} else if (cc == ')') {
				open--;
			} else {
				int num = 0;
				while (i < str.length() && Character.isDigit(str.charAt(i))) {
					num = num * 10 + (str.charAt(i) - '0');
					i++;
				}
				i--;
				if (open == K + 1) {
					sum += num;
				}
			}
		}
		System.out.println(sum);
	}
}
