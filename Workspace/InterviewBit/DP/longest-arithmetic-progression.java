public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int n=A.size(),maxLen=1;
        HashMap<Integer,Integer>[] dp=new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }
        // dp[i] means what is the longest AP till index i
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                int cd=A.get(i)-A.get(j);
                if(dp[j].containsKey(cd)){
                    dp[i].put(cd,dp[j].get(cd)+1);
                }else{
                    dp[i].put(cd,2);
                }
                // update the longest length
                maxLen=Math.max(maxLen,dp[i].get(cd));
            }
        }
        return maxLen;
    }
}
