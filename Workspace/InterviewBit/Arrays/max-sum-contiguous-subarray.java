public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int cs=A.get(0),ms=A.get(0);
        for(int i=1;i<A.size();i++){
            // decision : become part of the existing array or be itself large enough than the previous array (incase of negative numbers)
            cs=Math.max(cs+A.get(i),A.get(i));
            ms=Math.max(ms,cs);
        }
        return ms;
    }
}
