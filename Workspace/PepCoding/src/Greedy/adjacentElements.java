package Greedy;

public class adjacentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 6, 10, 100, 10, 5 };
		System.out.println(max(arr));
	}

	public static int max(int[] arr) {
		int inc = arr[0], exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int temp = inc;
			inc = arr[i] + exc;
			exc = Math.max(temp, exc);
		}
		return Math.max(inc, exc);
	}
}
