class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        // dp[i][j] -> longest length of palindromic sequence between [i,j] inclusive
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=i+gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j)?2:1);
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}