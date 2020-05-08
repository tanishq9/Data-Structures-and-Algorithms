public class Solution {
    public int sqrt(int A) {
        // fffttt framework
        // find last f
        // pred(x) : x*x > A
        long lo=0,hi=(long)A,mid;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(mid*mid>A){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        return (int)lo;
    }
}
