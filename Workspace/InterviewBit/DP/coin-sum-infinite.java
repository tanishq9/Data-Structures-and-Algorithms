public class Solution {
    public int coinchange2(ArrayList<Integer> A, int B) {
        int[] dp=new int[B+1];
        int mod=1000007;
        dp[0]=1;
        // counting combinations as order matters here i.e no permutation 
        for(int i=0;i<A.size();i++){
            for(int j=A.get(i);j<=B;j++){
                dp[j]=(dp[j]%mod+dp[j-A.get(i)]%mod)%mod;
            }
        }
        return dp[B]%mod;
    }
}
