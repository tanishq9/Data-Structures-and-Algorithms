class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max=0;
        for(int day:bloomDay){
            max=Math.max(max,day);
        }
        int lo=0,mid,hi=max;
        // F*T* framework, First True
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(bloomDay,mid,m,k)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        // sanity check
        if(predicate(bloomDay,lo,m,k)){
            return lo;
        }
        return -1;
    }
    
    boolean predicate(int[] days,int mid,int m,int k){
        boolean[] bloom=new boolean[days.length];
        int count=0,i=0,j=0;
        while(j<days.length){
            bloom[j]=days[j]<=mid?true:false;
            if(bloom[j]==false){
                j++;
                i=j;
                continue;
            }else{
                if(j-i+1==k){
                    count++;
                    j++;
                    i=j;
                    if(count==m){
                        return true;
                    }
                    continue;
                }else{
                    j++;
                }
            }
        }
        return false;
    }
    
}