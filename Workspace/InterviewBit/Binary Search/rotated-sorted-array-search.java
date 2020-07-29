public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        // first true
        // pred(i) : a(0) > a(i)
        int lo=0,hi=A.size()-1,mid,pivot;
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(A.get(0)>A.get(mid)){
                // true
                hi=mid;
            }else{
                // false
                lo=mid+1;
            }
        }
        pivot=lo;
        if(lo<A.size() && A.get(lo)==B){
            return lo;
        }
        // search in left part of pivot
        lo=0;
        hi=pivot-1;
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
        // search in right part of pivot
        lo=pivot+1;
        hi=A.size()-1;
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
        return -1;
    }
}
