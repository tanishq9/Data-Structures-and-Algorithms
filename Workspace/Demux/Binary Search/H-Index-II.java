class Solution {
    
    boolean predicate(int[] cit,int mid){
        // count will keep track of number of papers
        // having citations atleast equal to mid
        int count=0;
        for(int i=0;i<cit.length;i++){
            if(cit[i]>=mid){
                count++;
            }
        }
        return count>=mid;
    }
    
    public int hIndex(int[] citations) {
        int mid=0,lo=0,hi=citations.length;
        // last true in t*f* framework
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(predicate(citations,mid)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}