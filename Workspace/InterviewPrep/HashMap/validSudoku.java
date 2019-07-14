package HashMap;

public class validSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int value = board[i][j] - '1';
				// agar ith row mei value pehle se hai to return false
				// agar jth col mei value pehle se padhi hai to return false
				// agar (i/3*3+j box mei value pehle se padhi hai to return false
				if (row[i][value] == true || col[j][value] == true || box[(i / 3) * 3 + j / 3][value] == true) {
					return false;
				}
				row[i][value] = col[j][value] = box[(i / 3) * 3 + j / 3][value] = true;
			}
		}
		return true;
	}
}
