public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        // finding peek in mountain array : last F
        int lo=0,mid=-1,hi=A.size()-1;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(A.get(mid)<A.get(mid-1)){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        int peekIndex=lo;
        // we will search for B in [0....peekIndex-1] and in [peekIndex+1....n-1]    
        lo=0;hi=peekIndex-1;
        // first T : search in the left half i.e increasing array
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(A.get(mid)>=B){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(lo<A.size() && A.get(lo)==B){
            return lo;
        }
        // first T : search in the right half i.e decreasing array
        lo=peekIndex+1;hi=A.size()-1;
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(A.get(mid)<=B){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(lo<A.size() && A.get(lo)==B){
            return lo;
        }
        return -1;
    }
}
