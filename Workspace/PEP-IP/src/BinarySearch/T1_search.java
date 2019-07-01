package BinarySearch;

public class T1_search {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Use binary search.

		// n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

		// an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
		int left = 0;
		int right = matrix.length * matrix[0].length - 1;
		int m = matrix[0].length;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int value = matrix[mid / m][mid % m];
			if (target > value) {
				left = mid + 1;
			} else if (target < value) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
