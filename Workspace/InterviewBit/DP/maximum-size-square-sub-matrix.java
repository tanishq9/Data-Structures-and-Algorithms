public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int max=0;
        int[][] dp=new int[n][m];
        // dp[i][j] tells the maximum square matrix which can be formed taking i,j as the top left corner
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 || j==m-1){
                    dp[i][j]=A.get(i).get(j);
                }else{
                    if(A.get(i).get(j)==1){
                        dp[i][j]=Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                    }else{
                        // not eligible for a square of all 1's as the top left element is 0
                        dp[i][j]=0;
                    }
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
