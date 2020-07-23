public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int n=A.size();
        int[] lmin=new int[n];
        int[] rmax=new int[n];
        lmin[0]=A.get(0);
        rmax[n-1]=A.get(n-1);
        for(int i=1;i<n;i++){
            lmin[i]=Math.min(lmin[i-1],A.get(i));
        }
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],A.get(i));
        }
        int sp=0,ep=0,max=0;
        while(ep<n){
            if(rmax[ep]>=lmin[sp]){
                max=Math.max(max,ep-sp);
                ep++;
            }else if(rmax[ep]<lmin[sp]){
                sp++;
            }
        }
        return max;
    }
}
