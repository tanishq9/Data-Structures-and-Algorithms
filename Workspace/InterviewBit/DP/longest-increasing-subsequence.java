public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int max=0;
        int[] dp=new int[A.size()];
        for(int i=0;i<A.size();i++){
            dp[i]=1;
            for(int j=0;j<=i-1;j++){
                if(A.get(i)>A.get(j) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
