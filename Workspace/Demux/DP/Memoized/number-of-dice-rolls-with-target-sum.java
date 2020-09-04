class Solution {
    int mod=(int)Math.pow(10,9)+7;
    public int numRollsToTarget(int d, int f, int target) {
        return fun(d,f,target,new Integer[d+1][target+1]);
    }
    int fun(int d,int f,int target,Integer[][] dp){
        // base case
        if(d==0){
            if(target==0){
                return 1;
            }else if(target>0){
                return 0;
            }
        }
        if(dp[d][target]!=null){
            return dp[d][target];
        }
        int ways=0;
        for(int i=1;i<=f;i++){
            if(target-i>=0){
                ways=(ways%mod+fun(d-1,f,target-i,dp)%mod)%mod;
            }
        }
        return dp[d][target]=ways%mod;
    }
}