public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        // find the longest bitonic sequence
        int n=A.size(),max=0;
        int[] inc=new int[n];
        int[] dec=new int[n];
        // form the increasing dp array
        for(int i=0;i<n;i++){
            inc[i]=1;
            for(int j=0;j<=i-1;j++){
                if(A.get(i)>A.get(j) && inc[i]<inc[j]+1){
                    inc[i]=inc[j]+1;
                }
            }
        }
        // form the decreasing dp array
        for(int i=n-1;i>=0;i--){
            dec[i]=1;
            for(int j=i+1;j<n;j++){
                if(A.get(i)>A.get(j) && dec[i]<dec[j]+1){
                    dec[i]=dec[j]+1;
                }
            }
            max=Math.max(max,dec[i]+inc[i]-1);
        }
        return max;
    }
}
