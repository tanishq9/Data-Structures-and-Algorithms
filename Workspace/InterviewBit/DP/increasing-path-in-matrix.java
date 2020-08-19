public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int[][] dp=new int[n][m];
        int maxLen=0;
        // dp[i][j] tells max inc path till i,j cell
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    if(A.get(0).get(j)>A.get(0).get(j-1)){
                        dp[i][j]=dp[i][j-1]!=0?dp[i][j-1]+1:0;
                    }
                }else if(j==0){
                    if(A.get(i).get(0)>A.get(i-1).get(0)){
                        dp[i][j]=dp[i-1][j]!=0?dp[i-1][j]+1:0;
                    }
                }else{
                    if(A.get(i).get(j)>A.get(i-1).get(j)
                            && A.get(i).get(j)>A.get(i).get(j-1)){
                        // if this cell can be accessible from either of its top or left cell then there exists a path
                        if(dp[i-1][j]!=0 || dp[i][j-1]!=0){
                            dp[i][j]=1+Math.max(dp[i][j-1],dp[i-1][j]);
                        }
                    }
                }
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen==n+m-1?n+m-1:-1;
    }
}
