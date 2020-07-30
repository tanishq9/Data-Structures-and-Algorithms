public class Solution {
    
    public int solve(int A) {
        return solveIthBitApproach(A);
    }
    
    public int solveIthBitApproach(int A) {
        int count=0;
        for(int i=0;i<32;i++){
            if((A&(1<<i))==0){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    
    public int solveRightShiftApproach(int A) {
        int count=0;
        while(A>0){
            if((A&1)==0){
                count++;
            }else{
                break;
            }
            A>>=1;
        }
        return count;
    }
    
    public int solveBitArrayApproach(int A) {
        int[] bits=new int[32];
        int index=0;
        while(A>0){
            bits[index++]=A%2;
            A/=2;
        }
        int count=0;
        for(int i=0;i<32;i++){
            if(bits[i]==0){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
