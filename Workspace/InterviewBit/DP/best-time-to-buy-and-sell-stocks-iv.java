class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if(k>prices.length/2){
            return maxP(prices);
        }
        int[][] dp=new int[k+1][prices.length];
        // dp[i][j] tells the max profit that i can get after making atmost i transactions till j days
        for(int i=0;i<=k;i++){
            int maxPrevDay=Integer.MIN_VALUE;
            for(int j=0;j<prices.length;j++){
                if(i==0){
                    // i=0 means cannot do any transaction
                    dp[i][j]=0;
                }else if(j==0){
                    // day 0 tak max profit is also 0
                    dp[i][j]=0;
                    maxPrevDay=Math.max(maxPrevDay,dp[i-1][j]-prices[j]);
                }else{
                    // let us assume the max profit till day j is same as max profit till day (j-1) having done i transactions till day (j-1) day as well
                    // let us consider other options which is by the completing kth transaction on jth day
                    /*for(int prev=0;prev<j;prev++){
                        dp[i%2][j]=Math.max(dp[i%2][j],prices[j]-prices[prev]+dp[(i-1)%2][prev]);   
                    }*/
                    dp[i][j]=Math.max(dp[i][j-1],maxPrevDay+prices[j]);
                    maxPrevDay=Math.max(maxPrevDay,dp[i-1][j]-prices[j]);
                }
            }
        }
        return dp[k][prices.length-1];
    }
    
     public int maxP(int[] prices){
        int res =0;
        for(int i=0;i<prices.length;i++){
            if(i>0 && prices[i] > prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }
    
    
}