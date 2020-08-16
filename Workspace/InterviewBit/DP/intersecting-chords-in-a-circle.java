public class Solution {
    public int chordCnt(int A) {
        int mod=(int)Math.pow(10,9)+7;
        // we are getting a catalan series : 1,2,5,14...
        long[] dp=new long[A+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=A;i++){
            for(int j=0;j<=i-1;j++){
                dp[i]=(dp[i]%mod+((dp[j]%mod)*(dp[i-j-1]%mod))%mod)%mod;
            }
        }
        return (int)dp[A]%mod;
    }
}