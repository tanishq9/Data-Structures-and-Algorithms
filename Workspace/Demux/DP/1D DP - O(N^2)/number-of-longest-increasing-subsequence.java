class Solution {
    public int findNumberOfLIS(int[] nums) {
        // dp[i] -> length of longest subseq ending at i
        int[] dp=new int[nums.length];
        // count[i] -> count of longest subseq ending at i
        int[] count=new int[nums.length];
        int max=0,res=0;
        for(int i=0;i<nums.length;i++){
            count[i]=1;
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                }
            }
            if(max==dp[i]){
                res+=count[i];
            }
            if(max<dp[i]){
                max=dp[i];
                res=count[i];
            }
           
        }
        return res;
    }
}