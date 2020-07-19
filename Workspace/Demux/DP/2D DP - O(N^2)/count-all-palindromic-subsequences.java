class Solution {
    public int countPalindromicSubsequences(String S) {
        int[][] dp=new int[S.length()][S.length()];
        for(int gap=0;gap<S.length();gap++){
            for(int i=0,j=i+gap;j<S.length();i++,j++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j]=3;
                    }else{
                        dp[i][j]=2;
                    }
                }else{
                    // abc, a and c are not equal
                    // count(ab)=2, count(bc)=2
                    // count(abc)=count(ab)+count(bc)-count(b) // as b is common
                    // consider : aba
                    // count(abb)=4, count(bba)=4 
                    // count(abba)=1+dp[i+1][j]+dp[i][j-1]-dp[i-1][j+1]+dp[i-1][j+1]
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j]=1+dp[i][j-1]+dp[i+1][j];
                    }else{
                        dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][S.length()-1];
    }
}