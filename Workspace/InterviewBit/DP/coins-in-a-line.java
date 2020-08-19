public class Solution {
    public int maxcoin(ArrayList<Integer> A) {
        return helper(A,0,A.size()-1,new int[A.size()][A.size()]);
    }
    int helper(ArrayList<Integer> A,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int f1=A.get(i)+Math.min(helper(A,i+2,j,dp),helper(A,i+1,j-1,dp));
        int f2=A.get(j)+Math.min(helper(A,i,j-2,dp),helper(A,i+1,j-1,dp));
        return dp[i][j]=Math.max(f1,f2);
    }
}