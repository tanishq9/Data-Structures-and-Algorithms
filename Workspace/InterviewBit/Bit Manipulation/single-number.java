public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int res=0;
        for(int e:A){
            res^=e;
        }
        return res;
    }
}
