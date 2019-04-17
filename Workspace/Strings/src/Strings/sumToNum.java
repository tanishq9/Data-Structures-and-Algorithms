package Strings;

public class sumToNum {

	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 20, 10 };
		int target = 45;
		Boolean flag = false;
		int possibleCombinations = (1 << arr.length);
		for (int i = 0; i < possibleCombinations; i++) {
			if (isEqualtoSum(i, arr, target)) {
				flag = true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("YAAAS");
		}else {
			System.out.println("NOOOO");
		}
	}

	private static boolean isEqualtoSum(int i, int[] arr, int target) {
		int index = 0;
		int sum = 0;
		while (i > 0) {
			if ((i & 1) == 1) {
				sum += arr[index];
			}
			i = i >> 1;
			index++;
		}
		if (sum == target) {
			return true;
		}
		return false;
	}

}
