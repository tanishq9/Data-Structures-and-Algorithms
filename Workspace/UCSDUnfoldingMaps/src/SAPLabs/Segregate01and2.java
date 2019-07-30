package SAPLabs;

//Based on Dutch National flag algorithm or 3 way partition 
public class Segregate01and2 {

	/* Utility function to print array arr[] */
	static void printArray(int arr[]) {
		int i;
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	static void sort012(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1, temp;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
				break;
			}
		}
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 0, 1, 2, 0 };
		sort012(arr);
		System.out.println("Array after seggregation ");
		printArray(arr);
	}
}