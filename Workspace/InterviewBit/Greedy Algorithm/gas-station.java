public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    // Brute Force -> Checking for every point
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n=B.size();
        for(int si=0;si<n;si++){
            int tg=A.get(si)-B.get(si);
            int k=n;
            int j=si+1;
            while(k>0){
                if(tg<0){
                    break;
                }
                tg+=A.get(j%n)-B.get(j%n);
                j++;
                k--;
            }
            if(k==0){
                return si;    
            }
        }
        return -1;
    }
    // Optimized Approach
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int tank=0,start=0,total_gas=0,total_cost=0;
        for(int si=0;si<n;si++){
            total_gas+=gas[si];
            total_cost+=cost[si];
            tank+=gas[si]-cost[si];
            if(tank<0){
                start=si+1;
                tank=0;
            }
        }
        if(total_cost>total_gas){
            return -1;
        }
        return start;
    }
    
}
