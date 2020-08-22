public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] matrix=new int[A][A];
        int current=1;
        int top=0,bottom=A-1,right=A-1,left=0;
        int total=A*A;
        while(true){
            for(int i=left;i<=right;i++){
                matrix[top][i]=current;
                current+=1;
                total--;
            }
            if(total==0){break;}
            top++;
            for(int i=top;i<=bottom;i++){
                matrix[i][right]=current;
                current+=1;
                total--;
            }
            if(total==0){break;}
            right--;
            for(int i=right;i>=left;i--){
                matrix[bottom][i]=current;
                current+=1;
                total--;
            }
            if(total==0){break;}
            bottom--;
            for(int i=bottom;i>=top;i--){
                matrix[i][left]=current;
                current+=1;
                total--;
            }
            if(total==0){break;}
            left++;
        }
        return matrix;
    }
}
