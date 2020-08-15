public class Solution {
    public int climbStairs(int A) {
        return helper(A,new int[A+1]);
    }
    
    private int helper(int A,int[] dp){
        if(A<0){
            return 0;
        }
        if(A==0){
            return 1;
        }
        if(dp[A]!=0){
            return dp[A];
        }
        return dp[A]=helper(A-1,dp)+helper(A-2,dp);
    }
    
}
