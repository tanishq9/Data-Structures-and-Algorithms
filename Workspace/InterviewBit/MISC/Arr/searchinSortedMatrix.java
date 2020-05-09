package Arr;

public class searchinSortedMatrix {

	public Boolean sortedMatrix(int[][] matrix, int n, int element) {
		int r = 0;
		int c = n - 1;
		while (r >= 0 && c <= (n - 1)) {
			if (element > matrix[r][c]) {
				r++;
			} else if (element < matrix[r][c]) {
				c--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
