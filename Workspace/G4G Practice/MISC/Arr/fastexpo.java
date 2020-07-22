package Arr;

public class fastexpo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fastExpo(2, 2) - 1);
	}

	public static int fastExpo(int num, int p) {
		if (p == 0) {
			return 1;
		}
		if (p == 1) {
			return num;
		}
		if ((p & 1) == 1) {
			return num * fastExpo(num, p - 1);
		} else {
			return fastExpo(num, p / 2) * fastExpo(num, p / 2);
		}
	}
}
