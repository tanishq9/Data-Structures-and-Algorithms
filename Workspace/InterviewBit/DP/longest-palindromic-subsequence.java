public class Solution {
    public int solve(String A) {
        int[][] dp=new int[A.length()][A.length()];
        int max=0;
        for(int gap=0;gap<A.length();gap++){
            for(int i=0,j=i+gap;j<A.length();i++,j++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    if(A.charAt(i)==A.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    if(A.charAt(i)==A.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
