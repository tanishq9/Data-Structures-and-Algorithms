public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        if(A.size()==0){
            ArrayList<Integer> res = new  ArrayList<Integer>(); 
            res.add(-1);res.add(-1);
            return res;
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
        int lo=0,hi=A.size()-1,mid;
        // F*T* pattern
        // first occurance : first t
        // pred(x) : arr[x] >= B
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(A.get(mid)>=B){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(A.get(lo)==B){
            res.add(lo);
        }else{
            res.add(-1);
        }
        lo=0;
        hi=A.size()-1;
        // F*T* pattern
        // first occurance : last f
        // pred(x) : arr[x] < B
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(A.get(mid)>B){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        if(A.get(lo)==B){
            res.add(lo);
        }else{
            res.add(-1);
        }
        return res;
    }
}
