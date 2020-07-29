public class Solution {
    
    boolean pred(ArrayList<Integer> A,int wood,int mid){
        long sum=0;
        for(int e:A){
            if(e>=mid){
                sum+=(long)e-(long)mid;
            }
        }
        return sum>=wood?true:false;
    }
    
    public int solve(ArrayList<Integer> A, int B) {
        // fast T in T*F* framework
        int max=0;
        for(int e:A){
            max=Math.max(max,e);
        }
        int lo=0,hi=max,mid=0;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(pred(A,B,mid)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
