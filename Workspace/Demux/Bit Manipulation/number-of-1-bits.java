public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        // mask is taken as long since 1<<31 will overflow INT_MAX as it is 1<<31 - 1 i.e 2^31 - 1
        // we can therefore write n&mask>0 otherwise if mask was int then we could also write n&mask!=0
        long mask=1;
        for(int i=0;i<32;i++){
            // System.out.println(n&mask);
            if((n&mask)>0){
                count++;
            }
            mask<<=1;
        }
        return count;
    }
}