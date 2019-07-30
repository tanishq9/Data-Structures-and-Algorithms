package IBIT;

public class kadaneThrowback {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, -7, 2, 3 };
		int ms = 0, cs = 0;
		for (int i = 0; i < arr.length; i++) {
			cs += arr[i];
			if (cs < 0) {
				cs = 0;
			}
			ms = Math.max(ms, cs);
		}
		System.out.println(ms);
	}

}
