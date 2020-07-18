class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        // dp[i] means is it possible to reach ith index
        // or another approach can be : dp[i] means reaching 
        // last index starting from ith index
        dp[nums.length-1]=true;
        for(int i=dp.length-2;i>=0;i--){
            int jumpValue=nums[i];
            for(int j=i+1;j<=i+jumpValue && j<dp.length;j++){
                if(dp[j]==true){
                    dp[i]=true;
                }
            }
        }
        return dp[0];
    }
}