package Recursion;

public class towerofhanoi {

	public static void main(String[] args) {
		toh('s', 'd', 'h', 3);
	}

	private static void toh(char src, char dest, char help, int n) {
		if (n == 0) {
			return;
		}
		toh(src, help, dest, n - 1);
		System.out.println(n + " " + src + " " + dest);
		toh(help, dest, src, n - 1);
	}
}
