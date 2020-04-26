class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return f(text1,text2,0,0,new int[text1.length()][text2.length()]);
    }
    int f(String s1,String s2,int i,int j,int[][] dp){
        if(s1.length()==0 || s2.length()==0){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(s1.charAt(0)==s2.charAt(0)){
            return 1 + f(s1.substring(1),s2.substring(1),i+1,j+1,dp);
        }else{
            return dp[i][j]=Math.max(f(s1.substring(1),s2,i+1,j,dp),f(s1,s2.substring(1),i,j+1,dp));
        }
    }
}