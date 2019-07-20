package DP;

public class probabilityKnightOnChessboard {

	int[] dx = { 1, 1, 2, 2, -1, -1, -2, -2 };
	int[] dy = { 2, -2, 1, -1, -2, 2, 1, -1 };

	public double knightProbability(int N, int K, int r, int c) {

		double[][][] dp = new double[K + 1][N][N];
		dp[0][r][c] = 1;
		for (int steps = 1; steps <= K; steps++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int s = 0; s < 8; s++) {
						int px = i + dx[s];
						int py = j + dy[s];
						if (px >= 0 && py >= 0 && px < N && py < N) {
							dp[steps][i][j] += (dp[steps - 1][px][py] / 8.0);
						}
					}
				}
			}
		}

		double sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += dp[K][i][j];
			}
		}

		return sum;
	}
}
