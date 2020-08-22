public class Solution {
    public int[] nextPermutation(int[] A) {
        int n=A.length,i1=-1,i2=-1;
        // find the first element obeying the decreasing sequence
        for(int i=n-1;i>=1;i--){
            if(A[i]>A[i-1]){
                i1=i-1;
                break;
            }
        }
        if(i1==-1){
            Arrays.sort(A);
            return A;
        }
        // find element just larger than this element
        for(int i=n-1;i>=i1;i--){
            if(A[i1]<A[i]){
                i2=i;
                break;
            }
        }
        int temp=A[i1]; // first element smaller than or equal to lastDigit
        A[i1]=A[i2];
        A[i2]=temp;
        Arrays.sort(A,i1+1,n); 
        return A;
    }
}
