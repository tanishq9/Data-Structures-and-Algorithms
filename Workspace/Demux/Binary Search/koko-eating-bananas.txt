class Solution {
    
    public int predicate(int[] piles,int mid){
        int hours=0;
        for(int pile:piles){
            if(pile<=mid){
                hours+=1;
            }else{
                hours+=Math.ceil((float)pile/mid);
            }
        }
        return hours;
    }
    
    public int minEatingSpeed(int[] piles, int H) {
        int lo=1,hi=Integer.MIN_VALUE,mid;
        for(int pile:piles){hi=Math.max(hi,pile);}
        // fffttt : first t
        // pred(x) : predicate(x)<=H
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(piles,mid)<=H){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(predicate(piles,lo)<=H){
            return lo;
        }else{
            return -1;
        }
    }
}