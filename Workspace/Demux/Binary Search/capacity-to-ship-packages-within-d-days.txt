class Solution {
    
    public boolean predicate(int[] weights,int mid,int d){
        // mid is the current capacity
        int currentDays=1,currentLoad=0;
        for(int weight:weights){
            if((currentLoad+weight)<=mid){
                currentLoad+=weight;
            }else{
                currentLoad=weight;
                currentDays++;
                if(currentDays>d){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int shipWithinDays(int[] weights, int D) {
        int lo=Integer.MIN_VALUE,hi=0,mid;
        for(int weight:weights){hi+=weight;lo=Math.max(lo,weight);}
        // ss : 0 to sum(a[i]) (search space for capacity)
        // first t of : ffffttt
        // pred(x) : pred(x) <= D 
        // (predicate function tells whether its 
        //    possible to deliver with D days using the 'mid' capacity ships)
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(weights,mid,D)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(predicate(weights,lo,D)==true){
            return lo;
        }else{
            return -1;
        }
    }
}


---------------------------- ALTER ------------------------------------

class Solution {
    
    public boolean predicate(int[] weights,int mid,int d){
        // mid is the current capacity
        int currentDays=1,currentLoad=0;
        for(int weight:weights){
            if((currentLoad+weight)<=mid){
                currentLoad+=weight;
            }else{
                currentLoad=weight;
                if(weight>mid){
                    return false;
                }
                currentDays++;
                if(currentDays>d){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int shipWithinDays(int[] weights, int D) {
        int lo=0,hi=0,mid;
        for(int weight:weights){hi+=weight;}
        // ss : 0 to sum(a[i]) (search space for capacity)
        // first t of : ffffttt
        // pred(x) : pred(x) <= D 
        // (predicate function tells whether its 
        //    possible to deliver with D days using the 'mid' capacity ships)
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(weights,mid,D)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(predicate(weights,lo,D)==true){
            return lo;
        }else{
            return -1;
        }
    }
}



























