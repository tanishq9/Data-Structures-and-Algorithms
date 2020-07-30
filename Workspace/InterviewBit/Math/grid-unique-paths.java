public class Solution {
    public int uniquePaths(int A, int B) {
        int[][] dp=new int[A][B];
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                }else if(j==0){
                    dp[i][0]=1;
                }else if(i==0){
                    dp[0][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[A-1][B-1];
    }
}
