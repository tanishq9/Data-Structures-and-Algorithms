class Solution {
    public int maxDistance(int[] position, int m) { 
        Arrays.sort(position);
        // search space : 0 to 10^9 i.e maximum force between all balls
        int lo=0,hi=position[position.length-1],mid;
        // T*F* framework : last true 
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(predicate(position,mid,m)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        if(predicate(position,lo,m)){
            return lo;
        }
        return -1;
    }
    boolean predicate(int[] position,int mid,int m){
        int balls=1,prev=position[0];
        for(int i=1;i<position.length;i++){
            int curr=position[i];
            if(curr-prev>=mid){
                balls++;
                prev=curr;
                if(balls>=m){
                    return true;
                }
            }
        }
        return false;
    }
}