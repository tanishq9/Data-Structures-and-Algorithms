public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int[][] dp=new int[A.size()][A.get(0).size()];
        // dp[i][j] tells what is the minimum cost to reach the [i][j] cell of the given matrix
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(i==0 && j==0){
                    dp[i][j]=A.get(0).get(0);
                }else if(i==0){
                    dp[0][j]=dp[0][j-1]+A.get(0).get(j);
                }else if(j==0){
                    dp[i][0]=dp[i-1][0]+A.get(i).get(0);
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+A.get(i).get(j);
                }
            }
        }
        return dp[A.size()-1][A.get(0).size()-1];
    }
}
