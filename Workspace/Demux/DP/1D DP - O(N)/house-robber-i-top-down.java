class Solution {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
	// since end is always n-1 so it can be done using 1D DP as well
        // therefore end is not a VARIABLE where start is
	// so 1D Dp is needed, 2D is just an unecessary overkill
	for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
        return f(nums,0,nums.length-1,dp);
    }
    int f(int[] nums,int start,int end,int[][] dp){
        if(start>end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
	// subproblem is a suffix array
        int opt1=nums[start]+f(nums,start+2,end,dp); // Faith
        int opt2=0+f(nums,start+1,end,dp); // Faith
        return dp[start][end]=Math.max(opt1,opt2); // Expectation
    }
}