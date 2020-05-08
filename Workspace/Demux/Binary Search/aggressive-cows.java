  boolean isPossible(ArrayList<Integer> A,int dist,int B){
        int bullsPlaced=1;
        int lastBullLocation=A.get(0);
        for(int i=1;i<A.size();i++){
            int currentBullLocation=A.get(i);
            if((currentBullLocation-lastBullLocation)>=dist){
                bullsPlaced+=1;
                lastBullLocation=currentBullLocation;
                if(bullsPlaced==B){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int solve(ArrayList<Integer> A, int B) {
        // Search Space : [0,Max(A)-Min(A)]
        Collections.sort(A);
        int lo=Integer.MAX_VALUE,hi=Integer.MIN_VALUE,mid;
        for(int i:A){
            lo=Math.min(lo,i);
            hi=Math.max(hi,i);
        }
        hi=hi-lo;
        lo=0;
        // T*F* framework : last True
        // pred(x) : isPossible(x)
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(isPossible(A,mid,B)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        if(isPossible(A,lo,B)){
            return lo;
        }else{
            return -1;
        }
    }