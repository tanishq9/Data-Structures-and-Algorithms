package Matrix;

public class DFS_TLE_shortestPathBinaryMatrix {
	int min = Integer.MAX_VALUE;

	public int shortestPathBinaryMatrix(int[][] grid) {
		min = Integer.MAX_VALUE;
		helper(grid, new boolean[grid.length][grid[0].length], 0, 0, 1);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	void helper(int[][] grid, boolean[][] visited, int row, int col, int count) {
		// valid path found
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			if (grid[row][col] == 0) {
				min = Math.min(min, count);
			}
		}
		// out of bounds
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return;
		}
		// blocked cell
		if (grid[row][col] == 1) {
			return;
		}
		// already visited cell
		if (visited[row][col] == true) {
			return;
		}
		// mark the valid cell
		visited[row][col] = true;
		helper(grid, visited, row - 1, col - 1, count + 1);
		helper(grid, visited, row - 1, col, count + 1);
		helper(grid, visited, row - 1, col + 1, count + 1);
		helper(grid, visited, row, col - 1, count + 1);
		helper(grid, visited, row, col, count + 1);
		helper(grid, visited, row, col + 1, count + 1);
		helper(grid, visited, row + 1, col - 1, count + 1);
		helper(grid, visited, row + 1, col, count + 1);
		helper(grid, visited, row + 1, col + 1, count + 1);
		// unmark the valid cell
		visited[row][col] = false;
	}
}
