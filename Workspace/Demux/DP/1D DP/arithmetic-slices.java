class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<=2){
            return 0;
        }
        int[] dp=new int[A.length];
        // dp[i] : length of arithmetic subarray ending at i
        dp[0]=1;
        dp[1]=2;
        int count=0;
        for(int i=2;i<A.length;i++){
            int cdiff=A[i]-A[i-1];
            int pdiff=A[i-1]-A[i-2];
            if(cdiff==pdiff){
                dp[i]=dp[i-1]+1;
                count+=Math.max(0,dp[i]-3+1);
            }else{
                dp[i]=2;
            }
        }
        return count;
    } 
}