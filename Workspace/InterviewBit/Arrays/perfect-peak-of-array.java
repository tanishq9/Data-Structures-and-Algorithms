public class Solution {
    public int perfectPeak(ArrayList<Integer> A) {
        int n=A.size();
        int[] lmax=new int[n];
        int[] rmin=new int[n];
        lmax[0]=A.get(0);
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],A.get(i));
        }
        rmin[n-1]=A.get(n-1);
        for(int i=n-2;i>=0;i--){
            rmin[i]=Math.min(rmin[i+1],A.get(i));
            if(i>0 && A.get(i)>lmax[i-1] && A.get(i)<rmin[i+1]){
                return 1;
            }
        }
        return 0;
    }
}
