package Array;

public class fixArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 7, 6, 5 };
		int x = -1, y = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (x == -1 && arr[i] > arr[i + 1]) {
				x = arr[i];
			}
			if (x != -1 && arr[i] > arr[i + 1]) {
				y = arr[i + 1];
			}
		}
		System.out.println(x + " " + y);
	}
}
