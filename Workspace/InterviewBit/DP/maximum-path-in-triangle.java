public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int[][] dp=new int[n][n];
        // dp[i][j] tells the max path value till i,j cell of matrix
        dp[0][0]=A.get(0).get(0);
        int max=dp[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=1){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]);
                }
                dp[i][j]+=A.get(i).get(j);
                if(i==n-1){
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
