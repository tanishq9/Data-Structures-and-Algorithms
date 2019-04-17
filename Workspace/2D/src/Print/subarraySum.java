package Print;

public class subarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0, end = 0, desiredSum = 50, currentSum = 0, num = 0;
		int[] arr = { 1, 10, 3, 40, 18 };
		for (; end < arr.length;) {
			while (currentSum <= desiredSum && end < arr.length) {
				currentSum += arr[end++];
			}
			// if cs>ds
			while (currentSum > desiredSum && start < arr.length) {
				// update min length
				if (num > end - start) {
					num = end - start;
				}
				// remove starting elements
				currentSum -= arr[start++];
			}
		}
		System.out.println(num);
	}

}
