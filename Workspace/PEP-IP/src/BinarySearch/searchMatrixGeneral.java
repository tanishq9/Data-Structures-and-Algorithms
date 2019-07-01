package BinarySearch;

public class searchMatrixGeneral {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix == null) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;
		while (col >= 0 && row <= matrix.length - 1) {
			if (matrix[row][col] > target) {
				// row++; Can't
				col--;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				return true;
			}
		}
		return false;
	}
}
