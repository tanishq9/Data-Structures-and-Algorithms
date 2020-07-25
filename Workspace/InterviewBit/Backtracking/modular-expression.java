public class Solution {
    long fun(long x,long p,long mod){
        if(p==0){
            return 1;
        }
        if(p==1 || x==1){
            return (x%mod+mod)%mod;
        }
        long rr=(fun(x,p/2,mod)%mod+mod)%mod;
        if(p%2==0){
            return (rr*rr)%mod;
        }else{
            return (((rr*rr)%mod)*(x%mod))%mod;
        }
    }
    public int Mod(int A, int B, int C) {
        if(A==0 && B==0){
            return 0;
        }
        return (int)fun((long)A,(long)B,(long)C);
    }
}
