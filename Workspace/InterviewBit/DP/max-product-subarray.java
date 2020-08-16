public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        int[] mini=new int[A.size()];
        int[] maxi=new int[A.size()];
        int max=mini[0]=maxi[0]=A.get(0);
        for(int i=1;i<A.size();i++){
            mini[i]=Math.min(A.get(i),Math.min(A.get(i)*maxi[i-1],A.get(i)*mini[i-1]));
            maxi[i]=Math.max(A.get(i),Math.max(A.get(i)*maxi[i-1],A.get(i)*mini[i-1]));
            // System.out.println(mini[i]+" "+maxi[i]);
            max=Math.max(max,maxi[i]);
        }
        return max;
    }
}
// Input : [ -10, 10, -10, 10 ]
// mini : -10 -100 -100 -1000
// maxi : -10 10 1000 10000