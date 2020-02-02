package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_Output_Formatting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			// Complete this line
			System.out.printf("%-15s", s1);
			if (x >= 100) {
				System.out.println(x);
			} else if (x >= 10) {
				System.out.println("0" + x);
			} else if (x < 10) {
				System.out.println("00" + x);
			}
		}
		System.out.println("================================");

	}
}
