package RecursionClassics;

public class FirstAndLastIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 2, 3, 4, 4, 5 };
		System.out.println(firstOccurance(arr, 4, 0));
		System.out.println(lastOccurance(arr, 4, 0));
		int[] ans = allindices(arr, 0, 1, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);

		}
	}

	private static int firstOccurance(int[] arr, int element, int index) {
		if (index == arr.length) {
			return -1;
		} else if (arr[index] == element) {
			return index;
		} else {
			return firstOccurance(arr, element, index + 1);
		}
	}

	private static int lastOccurance(int[] arr, int element, int index) {
		if (index == arr.length) {
			return -1;
		}
		int position = lastOccurance(arr, element, index + 1);
		if (position == -1) {
			if (arr[index] == element) {
				return index;
			} else {
				return -1;
			}
		} else {
			return position;
		}
	}

	public static int[] allindices(int[] arr, int si, int num, int count) {
		if (si == arr.length) {
			return new int[count];
		}
		int[] indices = null;
		if (arr[si] == num) {
			indices = allindices(arr, si + 1, num, count + 1);
		} else {
			indices = allindices(arr, si + 1, num, count);
		}
		if (arr[si] == num) {
			indices[count] = si;
		}
		return indices;
	}

}
