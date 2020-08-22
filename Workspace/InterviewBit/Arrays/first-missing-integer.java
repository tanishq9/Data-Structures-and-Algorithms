public class Solution {
    public int firstMissingPositive(int[] A) {
        int res=1;
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i]<0){
                continue;
            }else if(A[i]==res){
                res++;
            }else if(A[i]>res){
                return res;
            }
        }
        return res;
    }
}
