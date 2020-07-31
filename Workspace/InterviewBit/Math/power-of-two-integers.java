public class Solution {
    
    public int isPower(int A) {
        if(A==1){
            return 1;
        }
        for(int i=2;i*i<=A;i++){
            int temp=A;
            while(temp%i==0){
                temp/=i;
            }
            if(temp==1){
                return 1;
            }
        }
        return 0;
    }
    
    public int isPowerLogApproach(int A) {
        if(A==1){
            return 1;
        }
        // A=x^y, take log both sides
        // logA=y*logx
        // if logA/logx is an integer then A can be expressed as x^y 
        for(int i=2;i*i<=A;i++){
            double val=Math.log10(A)/Math.log10(i);
            // val%1 is 0 for all integers
            if(val%1==0){
                return 1;
            }
        }
        return 0;
    }
}
