public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int[][] dp=new int[A.size()][A.get(0).size()];
        // dp[i][j] tells the number of ways to reach i,j cell of matrix
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[0][0]=1-A.get(0).get(0);   
                }else if(i==0){
                    // ek baar obstacle aa gya toh no ways to reach cells further in 0th row
                    if(A.get(0).get(j)==1){
                        dp[0][j]=0;
                    }else{
                        dp[0][j]=dp[0][j-1];
                    }
                }else if(j==0){
                    // ek baar obstacle aa gya toh no ways to reach cells further in 0th column
                    if(A.get(i).get(0)==1){
                        dp[i][0]=0;
                    }else{
                        dp[i][0]=dp[i-1][0];
                    }
                }else{
                    // if there is no obstable at that cell then it can only be reached
                    // from the left and top cells
                    if(A.get(i).get(j)!=1){
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
