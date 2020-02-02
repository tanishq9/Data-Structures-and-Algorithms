package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_Static_Initializer_Block {
	public static int B, H;
	public static boolean flag;
	static {
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		H = sc.nextInt();
		if (B <= 0 || H <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		} else {
			System.out.println(B * H);
		}
	}
}
