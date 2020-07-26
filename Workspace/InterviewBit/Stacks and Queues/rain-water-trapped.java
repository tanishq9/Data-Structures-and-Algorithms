public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int n=A.size();
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        lmax[0]=A.get(0);
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(A.get(i),lmax[i-1]);
        }
        rmax[n-1]=A.get(n-1);
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(A.get(i),rmax[i+1]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            total+=Math.min(lmax[i],rmax[i])-A.get(i);
        }
        return total;
    }
}
