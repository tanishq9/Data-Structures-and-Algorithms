class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0){return 0;}
        int sum=0;
        int max=nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        // dp[i] : largest sum subarray ending at index i
        for(int i=1;i<n;i++){
            // consider dp[i-1]+nums[i] or just nums[i]
            // eg : -1 3 -1 4
            //      -1 3 2 6
            dp[i]=Math.max(nums[i]+dp[i-1], nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}