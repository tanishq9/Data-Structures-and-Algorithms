public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int[] dp=new int[A.size()];
        int max=0;
        // dp[i] tells what is the maximum length of chain formed till index i
        // we will find the longest increasing sequence of such pairs till index i
        for(int i=0;i<A.size();i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(A.get(i).get(0)>A.get(j).get(1) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
