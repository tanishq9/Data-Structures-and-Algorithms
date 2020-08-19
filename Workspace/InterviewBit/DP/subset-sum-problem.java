public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        boolean[][] dp=new boolean[2][B+1];
        // dp[i][j] tells whether its possible to form target j using i elements
        for(int i=0;i<=A.size();i++){
            for(int j=0;j<=B;j++){
                if(i==0 && j==0){
                    // 0 elements and 0 target
                    dp[i%2][j]=true;
                }else if(i==0){
                    // target >0 but 0 elements 
                    dp[i%2][j]=false;
                }else if(j==0){
                    // target 0 and >0 elements
                    dp[i%2][j]=true;
                }else{
                    if(dp[(i-1)%2][j]==true){
                        // not considering the current element
                        dp[i%2][j]=true;
                    }else if(j-A.get(i-1)>=0 && dp[(i-1)%2][j-A.get(i-1)]==true){
                        // considering the current element
                        dp[i%2][j]=true;
                    }
                }
            }
        }
        return dp[A.size()%2][B]==true?1:0;
    }
}
