class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        boolean[][] dp=new boolean[n+1][sum+1];   
        // dp[i][j] -> whether it is possible to form sum j using i elements
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    // don't take the element
                    dp[i][j]=dp[i-1][j];
                    // if false then try other way
                    // i.e take the element and check if its counter part is present or not
                    if(!dp[i][j] && j-nums[i-1]>=0){
                        dp[i][j]=dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        return dp[n][sum/2];
    }
}