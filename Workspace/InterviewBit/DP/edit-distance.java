public class Solution {
    public int minDistance(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else{
                    if(A.charAt(i-1)==B.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        // insertion, removal and replace wrt to i length string
                        // replace : 1 + dp[i-1][j-1]
                        // removal : 1 + dp[i-1][j]
                        // insert : 1 + dp[i][j-1]
                        dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    }
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
/*

If word1[i - 1] != word2[j - 1], we need to consider three cases.

Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
If word1[0..i - 1) = word2[0..j) then delete word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
If word1[0..i) + word2[j - 1] = word2[0..j) then insert word2[j - 1] to word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).

*/
