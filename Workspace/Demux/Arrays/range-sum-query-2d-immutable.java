class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) 
            return;
        dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0];
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                dp[r][c] = dp[r][c-1] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            if(col1>=1){
                sum += dp[row][col2] - dp[row][col1-1];    
            }else{
                sum += dp[row][col2];
            }
        }
        return sum;
    }
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */