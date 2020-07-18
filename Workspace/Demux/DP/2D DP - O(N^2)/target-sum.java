class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(S>1000){
            return 0;
        }
        // 2d dp
        // fill it row wise
        int n=nums.length;
        int[][] dp=new int[n][2001];
        // max sum is 1000, so it means max negative sum is also 1000
        // therefore we take 2001 columns for this purpose
        // -1000 will be mapped to 0, so sum+0 will be mapped to sum+1000 
        // 1000 se har sum ko right shift karna hai
        // dp[i][j] is the number of ways to form sum j using i elements [0,i] of the array
        for(int i=0;i<n;i++){
            for(int j=-1000;j<=1000;j++){
                if(i==0){
                    if(j==-1*nums[0]){
                        dp[0][j+1000]=1;
                    }
                    if(j==nums[0]){
                        dp[0][j+1000]+=1;
                    }
                }else{
                    if(j-nums[i]>=-1000){
                        // taking current element as -ve
                        dp[i][j+1000]=dp[i-1][j-nums[i]+1000];                        
                    }
                    if(j+nums[i]<=1000){
                        // taking current element as +ve
                        dp[i][j+1000]+=dp[i-1][j+nums[i]+1000];   
                    }
                }
            }
        }
        
        return dp[n-1][S+1000];
    }
    
}