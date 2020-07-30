public class Solution {
    public int numSetBits(long a) {
        int count=0;
        // when we take a&(a-1), we unset the rightmost set bit of a
        // therefore number of times the loop runs is the number of set bits of a
        while(a>0){
            a=a&(a-1);
            count++;
        }
        return count;
    }
}
