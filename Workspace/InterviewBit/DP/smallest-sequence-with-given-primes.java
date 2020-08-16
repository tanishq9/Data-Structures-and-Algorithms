public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        //  Logic : Every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5
        int iA=0,iB=0,iC=0;
        ArrayList<Integer> result=new ArrayList<>();
        result.add(1);
        for(int i=1;i<=D;i++){
            int min=Math.min(A*result.get(iA),Math.min(B*result.get(iB),C*result.get(iC)));
            result.add(min);
            if(A*result.get(iA)==min){
                // move to the next multiple of A
                iA++;
            }
            if(B*result.get(iB)==min){
                // move to the next multiple of B
                iB++;
            }
            if(C*result.get(iC)==min){
                // move to the next multiple of C
                iC++;
            }
        }
        result.remove(0);
        return result;
    }
}