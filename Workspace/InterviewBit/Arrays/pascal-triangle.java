public class Solution {
    public int[][] solve(int A) {
        if(A==0){
            return new int[0][0];
        }
        // Making a Jagged Array i.e variable length of each row in the 2D matrix
        // This is only possible for Java 8 onwards
        int[][] arr=new int[A][];
        arr[0]=new int[1];
        arr[0][0]=1;
        for(int i=1;i<A;i++){
            arr[i]=new int[i+1];
            for(int j=0;j<=i;j++){
                arr[i][j]=(j>=1?arr[i-1][j-1]:0)+(j<arr[i-1].length?arr[i-1][j]:0);
            }
        }
        return arr;
    }
}
