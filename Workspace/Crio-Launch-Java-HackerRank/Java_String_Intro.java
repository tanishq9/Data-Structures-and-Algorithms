package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_String_Intro {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		System.out.println(A.length() + B.length());
		if (A.compareTo(B) <= 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
		System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase()
				+ B.substring(1));
	}
}
