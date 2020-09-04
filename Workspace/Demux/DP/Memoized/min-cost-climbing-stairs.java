class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int index=cost.length;
        return dfs(cost,index,new Integer[cost.length+1]);
    }
    int dfs(int[] cost,int index,Integer[] dp){
        if(index==0 || index==1){
            return cost[index];
        }
        if(dp[index]!=null){
            return dp[index];
        }
        int c1=((index==cost.length)?0:cost[index])+dfs(cost,index-1,dp);
        int c2=((index==cost.length)?0:cost[index])+dfs(cost,index-2,dp);
        return dp[index]=Math.min(c1,c2);
    }
}