package Array;

public class magicSquare {
	public int numMagicSquaresInside(int[][] grid) {
		int count = 0;
		for (int i = 0; i <= (grid.length - 3); i++) {
			for (int j = 0; j <= (grid[0].length - 3); j++) {
				if (isValid(grid, i, j)) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean isValid(int[][] grid, int i, int j) {
		// For property and early breakage if necessary
		if (grid[i + 1][j + 1] != 5) {
			return false;
		}
		int[] valid = new int[10];
		for (int x = i; x <= i + 2; x++) {
			for (int y = j; y <= j + 2; y++) {
				if (grid[x][y] >= 1 && grid[x][y] <= 9) {
					valid[grid[x][y]]++;
				}
			}
		}
		// For distinctness
		for (int x = 1; x <= 9; x++) {
			if (valid[x] != 1) {
				return false;
			}
		}
		// For row, column and diagonal sum
		if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) {
			return false;
		}
		;
		if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) {
			return false;
		}
		;
		if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) {
			return false;
		}
		;
		if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) {
			return false;
		}
		if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) {
			return false;
		}
		if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) {
			return false;
		}
		if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) {
			return false;
		}
		if (grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] != 15) {
			return false;
		}
		return true;
	}

}
