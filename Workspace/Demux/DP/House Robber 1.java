class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){return 0;}
        int[] dp = new int[n];
        // solve the smallest subproblem
        dp[0] = nums[0];
        // iterate from the next smallest subproblem to the biggest and populate
        for(int i=1;i<=n-1;i++){
            // exclude it
            dp[i] = dp[i-1];
            // include
            if(i-2 >= 0){
                dp[i] = Math.max(dp[i], dp[i-2]+nums[i]);
            }else{
                dp[i] = Math.max(dp[i], nums[i]);
            }
        }
        return dp[n-1];
    }
}