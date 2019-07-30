package Div2_63;

import java.util.Scanner;

public class YoungPhysicist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		while (n-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			sum += (x + y + z);
		}
		if (sum == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
