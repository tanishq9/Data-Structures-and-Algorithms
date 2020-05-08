class Solution {
    public int arrangeCoins(int n) {
        if(n==0){return 0;}
        long ln=(long)n;
        long lo=1,hi=ln,mid;
        // last t
        // pred(x) : x(x+1)/2 <= n
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(mid <= 2*ln/(mid+1)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return (int)lo;
    }
}