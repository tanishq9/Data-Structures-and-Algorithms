public class Solution {
    public int numDecodings(String A) {
        int mod=(int)Math.pow(10,9)+7;
        // Building Bottom Up
        int[] dp=new int[A.length()];
        // dp[i] tells what is the count of encodings possible till index i
        for(int i=0;i<A.length();i++){
            int digit=A.charAt(i)-'0';
            if(digit>=1 && digit<=9){
                // this is the case when the current character can be directly appended to previous possible encodings
                dp[i]=(i-1)>=0?dp[i-1]%mod:1;
            }
            // add one more possibility i.e current and prev character taken together
            if(i>0 && A.charAt(i-1)=='1'){
                dp[i]=(dp[i]%mod+((i-2)>=0?dp[i-2]%mod:1))%mod;
            }else if(i>0 && A.charAt(i-1)=='2' && digit<=6){
                dp[i]=(dp[i]%mod+((i-2)>=0?dp[i-2]%mod:1))%mod;
            }
        }
        return dp[A.length()-1]%mod;
    }
}
// In dp, always when computing dp[i], relate how it depends on dp[i-1] 
// that is the just previous state or maybe even states before that
// make sure to use dp array previous states no matter how many to construct
// the current state