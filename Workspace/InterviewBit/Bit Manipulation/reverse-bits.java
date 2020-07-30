import java.math.*;

public class Solution {
    public long reverse(long a) {
        if(a==0){
            return 0;
        }
        long[] bits=new long[32];
        int index=0;
        while(a>0){
            long rem=a%2;
            bits[index++]=rem;
            a/=2;
        }
        long res=0;
        // System.out.println(Arrays.toString(bits));
        // BigInteger bi=new BigInteger("0");
        for(int i=31;i>=0;i--){
            if(bits[31-i]==1){
                // bi=bi.add(new BigInteger((int)Math.pow(2,i)+""));
                res+=Math.pow(2,i);             
             }
        }
        return res;
    }
}
