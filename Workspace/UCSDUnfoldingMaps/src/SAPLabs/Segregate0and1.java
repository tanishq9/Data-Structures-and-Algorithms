package SAPLabs;

public class Segregate0and1 {

	// Get the leftmost 1 and the rightmost 0 and swap them by using 2 pointers
	// So, the final output array is like {0,0,0,0,1,1,1,1}
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 0, 0, 0, 1, 1 };
		int left = 0, right = arr.length - 1;
		while (left < right) {
			// if left overshoots right then it means that we are done segregating the array
			while (arr[left] == 0 && left < right) {
				// this will help us reach the next 1 element from the left side
				left++;
			}
			while (arr[right] == 1 && left < right) {
				// this will help us reach the next 0 element from the right side
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
