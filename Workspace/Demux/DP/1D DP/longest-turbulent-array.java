class Solution {
    public int maxTurbulenceSize(int[] A) {
        int[] inc=new int[A.length];
        int[] dec=new int[A.length];
        inc[0]=1;
        dec[0]=1;
        int max=1;
        for(int i=1;i<A.length;i++){
            // if current element is bigger than previous
            // then it can only be attached to the decreasing subarray at i-1
            // otherwise sequence will be violated
            if(A[i]>A[i-1]){
                inc[i]=dec[i-1]+1;
                dec[i]=1;
                max=Math.max(max,inc[i]);
            }else if(A[i]<A[i-1]){
                // if current element is smaller than previous
                // then it can only be attached to the increasing subarray at i-1 
                // otherwise sequence will be violated
                dec[i]=inc[i-1]+1;
                inc[i]=1;
                max=Math.max(max,dec[i]);
            }else{
                inc[i]=1;
                dec[i]=1;
            }
        }
        return max;
    }
}