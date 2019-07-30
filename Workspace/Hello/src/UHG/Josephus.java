package UHG;

public class Josephus {

	public static void main(String[] args) {
		System.out.println(Josephus(5, 2) + 1);
	}

	public static int Josephus(int n, int k) {
		if (n == 1) {
			return 0;// It means that there is only person then the index will be 0
		}
		return (Josephus(n - 1, k) + k) % n;
	}

}
