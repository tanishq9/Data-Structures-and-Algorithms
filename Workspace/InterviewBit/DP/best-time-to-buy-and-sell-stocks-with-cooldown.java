class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        // only one stock can be bought at a time i.e to buy another stock, the previous one has to be sold
        int buy=-prices[0]; // bought state max
        int sell=0; // sold state max
        int cooldown=0; // cooldown state max
        for(int i=1;i<prices.length;i++){
            int prevDayBuy=buy;
            int prevDaySell=sell;
            int prevDayCoolDown=cooldown;
            int newDayBuy=Math.max(prevDayBuy,prevDayCoolDown-prices[i]);
            int newDaySell=Math.max(prevDaySell,prevDayBuy+prices[i]);
            int newDayCoolDown=Math.max(prevDayCoolDown,prevDaySell);
            buy=newDayBuy;
            sell=newDaySell;
            cooldown=newDayCoolDown;
        }
        return Math.max(sell,cooldown);
    }
}