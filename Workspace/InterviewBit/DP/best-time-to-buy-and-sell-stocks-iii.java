class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int n=prices.length;
        // leftBuySellMax[i] -> aajtak sell krke max profit kya hai?
        int[] leftBuySellMax=new int[n];    
        // rightBuySellMax[i] -> aajtak buy kre toh max profit kya aayega future me sell krke?
        int[] rightBuySellMax=new int[n];
        leftBuySellMax[0]=0;
        int minBuy=prices[0];
        for(int i=1;i<n;i++){
            leftBuySellMax[i]=Math.max(prices[i]-minBuy,leftBuySellMax[i-1]);
            minBuy=Math.min(minBuy,prices[i]);
        }
        rightBuySellMax[n-1]=0;
        int maxSell=prices[n-1];
        for(int i=n-2;i>=0;i--){
            rightBuySellMax[i]=Math.max(maxSell-prices[i],rightBuySellMax[i+1]);
            maxSell=Math.max(maxSell,prices[i]);
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,leftBuySellMax[i]+rightBuySellMax[i]);
        }
        return maxProfit;
    }
}