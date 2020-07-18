class Solution {
    public int countOrders(int n) {
        long[] dp=new long[n+1];
        int mod=(int)Math.pow(10,9)+7;
        dp[1]=1;
        // consider n=1, we have p1d1 only 1 order
        // consider n=2, we can place this place in n*(2n-1) which is 2*(4-1) of p2d2 in 6 ways
        // given we already have p1d1, example : p2p1d1d2,p1p2d1d2,....4 more ways, analyze it by
        // seeing what will happen if i place the last pair i.e here it is p2,d2 by first placing
        // p2 in the beginning i.e before p1, then we have 3 ways to place d2, no place p2 after p1
        // p1p2_d1_ therefore d2 can be placed in 2 ways now, and now place p2 after d1 i.e p1d1p2_
        // here in last case, only way to place d2 therefore we have 3+2+1=6 ways
        // more general, to place nth pair of pn,dn we have 2n-2 filled spots and 2 open spots
        // we can place pn at starting and have 2n-1 more ways for dn to choose from, if we place pn
        // after p1 then we have 1 less way to place dn, so total we have : 2n-1 + 2n-2 + .... + 1 ways
        // which is infact sum of first 2n-1 numbers and it comes to be : n*(2n-1)
        // and we mulitple it by dp[n-1] because it can be applied to any of the previous state arrangement
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]%mod*(i*(2*i-1)%mod))%mod;
        }
        return (int)dp[n];
    }

    // using 2 variables instead of 1d dp array
    public int countOrders(int n) {
        long prev=1,current=1;
        int mod=(int)Math.pow(10,9)+7;
        prev=1;
        for(int i=2;i<=n;i++){
            current=(prev%mod*(i*(2*i-1)%mod))%mod;
            prev=current;
        }
        return (int)current;
    }

}