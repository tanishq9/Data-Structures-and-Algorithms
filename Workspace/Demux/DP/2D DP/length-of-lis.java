class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}