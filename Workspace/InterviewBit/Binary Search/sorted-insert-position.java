public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        if(a.get(0)>=b){
            return 0;
        }
        if(a.get(a.size()-1)<b){
            return a.size();
        }
        int lo=0,hi=a.size()-1,mid;
        // first true
        // pred(x) : a.get(x) >= b
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(a.get(mid)>=b){
                // true
                hi=mid;
            }else{
                // false
                lo=mid+1;
            }
        }
        return lo;
    }
}
