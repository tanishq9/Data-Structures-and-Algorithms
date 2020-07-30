public class Solution {
    public int divide(int A, int B) {
        // https://www.youtube.com/watch?v=bdxJHWIyyqI -> Intution
        long dividend=Math.abs(A*1L),divisor=Math.abs(B*1L),temp=0,quotient=0;
        // t^f and f^t are true for xor 
        int sign=((A<0)^(B<0))?-1:1;
        for(int i=31;i>=0;i--){
            // temp+divisor*pow(2,i)<=dividend
            // System.out.println(temp+(divisor<<i)+" "+dividend);
            if(temp+(divisor<<i)<=dividend){
                temp+=divisor<<i;
                quotient|=1L<<i;
            }
        }
        // System.out.println(quotient*sign+" "+Integer.MAX_VALUE);
        quotient*=sign;
        if(quotient>=1L*Integer.MAX_VALUE || quotient<1L*Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)quotient;
    }
}
