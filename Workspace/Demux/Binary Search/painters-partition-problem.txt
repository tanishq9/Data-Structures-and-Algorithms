public class Solution {
    
    boolean isPossible(int A,int B,ArrayList<Integer> C,long mid){
        long[] arr=new long[C.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=C.get(i);
        }
        int currentWorkers=1;
        long currentTime=0;
        for(int i=0;i<arr.length;i++){
            long boardTime=arr[i];
            if(currentTime+boardTime<=mid){
                currentTime+=boardTime;
            }else{
                // engage next worker
                currentTime=boardTime;
                currentWorkers++;
                if(currentWorkers>A){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int paint(int A, int B, ArrayList<Integer> C) {
        long lo=Integer.MIN_VALUE,hi=0,mid;
        for(int i:C){
            lo=Math.max(lo,i);
            hi=(hi%10000003+i%10000003)%10000003;
        }
        // search space on time 
        // f*t* framework, first T
        // pred(x) : if all boards can be painted in x time
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            mid=mid%10000003;
            if(isPossible(A,B,C,mid)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(isPossible(A,B,C,lo)){
            return (int)((lo*B)%10000003);
        }else{
            return -1;
        }
    }
}
