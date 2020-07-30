/*

HINT

Suppose the given array contains only binary numbers, i.e A[i] belongs to [0, 1].

You only need to find the number of pairs having different bits.

Try to combine this approach if we have array of integers instead of binary numbers containing multiple bits.

*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        long total=0;
        long mod=1000000007;
        for(int i=0;i<32;i++){
            long count=0;
            for(int j=0;j<A.size();j++){
                // >0 means that bit is set
                // even ==0 is correct
                if((A.get(j)&(1<<i))>0){
                    count++;
                }
            }
            total=(total%mod+((count%mod)*((A.size()-count)*2)%mod)%mod)%mod;
        }
        return (int)(total%mod);
    }
}
