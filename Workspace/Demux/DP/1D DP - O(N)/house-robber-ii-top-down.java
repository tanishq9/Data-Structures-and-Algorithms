public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int m1=f(nums,0,nums.length-2,dp);
        Arrays.fill(dp,-1);
        int m2=f(nums,1,nums.length-1,dp);
        return Math.max(m1,m2);
    }
    
    int f(int[] nums,int start,int end,int[] dp){
        if(start>end){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int opt1=nums[start]+f(nums,start+2,end,dp);
        int opt2=0+f(nums,start+1,end,dp);
        return dp[start]=Math.max(opt1,opt2);
    }