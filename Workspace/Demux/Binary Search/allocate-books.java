public class Solution {
    
    public boolean predicate(ArrayList<Integer> A,int mid,int B){
        int currentStudents=1,currentPages=0;
        for(int page:A){
            if((currentPages+page)<=mid){
                currentPages+=page;
            }else{
                currentPages=page;
                // this check not needed since we have set our low as correct
                // this means if current book's number of pages is more than 
                // what we are alloting each student to read
                if(page>mid){
                    return false;
                }
                currentStudents++;
                if(currentStudents>B){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int books(ArrayList<Integer> A, int B) {
        if(A.size()<B){
            return -1;
        }
        // search space on number of pages : max(A),sum(A)
        int lo=Integer.MIN_VALUE,hi=0,mid;
        for(int i:A){
            lo=Math.max(lo,i);
            hi+=i;
        }
        // first t
        // pred(x) : possible with x pages
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(A,mid,B)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(predicate(A,lo,B)){
            return lo;
        }else{
            return -1;
        }
    }
}
