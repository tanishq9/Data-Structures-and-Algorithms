class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        // dp[i][j] tells lcs for text1 [0,i] and text2 [0,j]
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    // if text1 is of 0 length
                    dp[i][j]=0;
                }else if(j==0){
                    // if text2 is of 0 length
                    dp[i][j]=0;
                }else{
                    // if both text1 and text2 have length >= 1
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}