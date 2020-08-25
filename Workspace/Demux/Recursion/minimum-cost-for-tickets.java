class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return helper(days,costs,0,new int[days.length]);
    }
    int helper(int[] days,int[] costs,int index,int[] dp){
        if(index==days.length){
            return 0;
        }
        if(dp[index]!=0){
            return dp[index];
        }
        int currentIndex=index;
        int currentDay=days[index];
        // opt1
        int opt1=costs[0]+helper(days,costs,index+1,dp);
        // opt2
        int nextWeekDay=currentDay+6;
        while(index<days.length && days[index]<=nextWeekDay){
            index++;
        }
        int opt2=costs[1]+helper(days,costs,index,dp);
        // opt3
        int nextMonthDay=currentDay+29;
        while(index<days.length && days[index]<=nextMonthDay){
            index++;
        }
        int opt3=costs[2]+helper(days,costs,index,dp);     
        // choose the best cost effective option
        int best=Math.min(opt1,Math.min(opt2,opt3));
        return dp[currentIndex]=best;
    }
}