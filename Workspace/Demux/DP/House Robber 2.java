class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // we cannot take 0 and n-1 elements together
        // to understand more intuitively draw the array
        // and mark 0 to n-1 and 1 to n-2 to notice the 
        // differnce and the given approach
        if(n==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    
     public int rob(int[] nums,int start,int end) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==0){return 0;}
        // solve the smallest subproblem
        dp[start] = nums[start];
        // iterate from the next smallest subproblem to the biggest and populate
        for(int i=start+1;i<=end;i++){
            // exclude it
            dp[i] = dp[i-1];
            // include
            if(i-2 >= 0){
                dp[i] = Math.max(dp[i], dp[i-2]+nums[i]);
            }else{
                dp[i] = Math.max(dp[i], nums[i]);
            }
        }
        return dp[end];
    }
    
}