class Solution {
    public int[][] generateMatrix(int n) {
        int[][] A=new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        int total=n*n;
        int num=1;
        while(true){
            for(int col=left;col<=right;col++){
                A[top][col]=num++;
                total--;
            }
            if(total==0){break;}
            top++;
            for(int row=top;row<=bottom;row++){
                A[row][right]=num++;
                total--;
            }
            if(total==0){break;}
            right--;
            for(int col=right;col>=left;col--){
                A[bottom][col]=num++;
                total--;
            }
            if(total==0){break;}
            bottom--;
            for(int row=bottom;row>=top;row--){
                A[row][left]=num++;
                total--;
            }
            if(total==0){break;}
            left++;
        }
        return A;
    }
}