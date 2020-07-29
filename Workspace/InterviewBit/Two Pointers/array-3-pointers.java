public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i=0,j=0,k=0,res=Integer.MAX_VALUE;
        while(i<A.size() && j<B.size() && k<C.size()){
            int min=Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
            int max=Math.max(A.get(i),Math.max(B.get(j),C.get(k)));
            res=Math.min(res,max-min);
            if(A.get(i)==min){
                i++;
            }
            if(B.get(j)==min){
                j++;
            }
            if(C.get(k)==min){
                k++;
            }
        }
        return res;
    }
}
