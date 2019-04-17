package RecursionClassics;

public class firstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 5, 6 };
		System.out.println(contains(arr, 5, 0));
	}

	private static boolean contains(int[] arr, int element, int index) {
		if (index == arr.length) {
			return false;
		} else if (arr[index] == element) {
			return true;
		} else {
			return contains(arr, element, index + 1);
		}
	}

}
