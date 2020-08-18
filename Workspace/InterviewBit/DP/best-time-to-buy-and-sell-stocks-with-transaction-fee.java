class Solution {
    public int maxProfit(int[] prices, int fee) {
	// buy sell buy sell is fine, we cannot buy consecutively
        //  You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
	int buy=-prices[0]; // buying state -> one share extra bought (bought state max)
        int sell=0; // equal bought and sell on this day (sold state max)
        for(int i=1;i<prices.length;i++){
            int prevDayBuy=buy;
            int prevDaySell=sell;
            int newDayBuy=Math.max(prevDayBuy,prevDaySell-prices[i]);
            int newDaySell=Math.max(prevDaySell,prevDayBuy+prices[i]-fee);
            buy=newDayBuy;
            sell=newDaySell;
        }
        return sell;
    }
}