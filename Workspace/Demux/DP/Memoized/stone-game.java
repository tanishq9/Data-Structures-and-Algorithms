class Solution {
    public boolean stoneGame(int[] piles) {
        int total=0;
        for(int pile:piles){
            total+=pile;
        }
        int maxAlex=dfs(piles,0,piles.length-1,new Integer[piles.length][piles.length]);
        return total-maxAlex<maxAlex;
    }
    int dfs(int[] piles,int i,int j,Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return piles[i];
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int c1=piles[i]+Math.min(dfs(piles,i+1,j-1,dp),dfs(piles,i+2,j,dp));
        int c2=piles[j]+Math.min(dfs(piles,i,j-2,dp),dfs(piles,i+1,j-1,dp));
        return dp[i][j]=Math.max(c1,c2);
    }
}