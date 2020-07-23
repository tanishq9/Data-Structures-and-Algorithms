class Solution {
    public List<Integer> spiralOrder(int[][] A) {
        ArrayList<Integer> res=new ArrayList<>();
        if(A.length==0){return res;}
        int n=A.length;
        int m=A[0].length;
        int top=0,bottom=n-1,left=0,right=m-1;
        int total=n*m;
        while(true){
            for(int col=left;col<=right;col++){
                res.add(A[top][col]);
                total--;
            }
            if(total==0){break;}
            top++;
            for(int row=top;row<=bottom;row++){
                res.add(A[row][right]);
                total--;
            }
            if(total==0){break;}
            right--;
            for(int col=right;col>=left;col--){
                res.add(A[bottom][col]);
                total--;
            }
            if(total==0){break;}
            bottom--;
            for(int row=bottom;row>=top;row--){
                res.add(A[row][left]);
                total--;
            }
            if(total==0){break;}
            left++;
        }
        return res;
    }
}