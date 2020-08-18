public class Solution {
    public int solve(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        // dp[i][j] tells the LCS for A[0:i] and B[0:j] strings
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0 || j==0){
                    dp[0][j]=0;
                }else{
                    if(A.charAt(i-1)==B.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
