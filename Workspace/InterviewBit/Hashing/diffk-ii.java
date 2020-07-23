public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> set=new HashSet<>();
        for(int e:A){
            if(set.contains(e+B) || set.contains(e-B)){
                return 1;
            }
            set.add(e);
        }
        return 0;
    }
}
