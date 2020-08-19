public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] dp=new int[A.size()+1][C+1];
        // dp[i][j] tells what is the maximum profit using i elements and max j capacity
        for(int i=0;i<=A.size();i++){
            for(int j=0;j<=C;j++){
                if(i==0 && j==0){
                    // 0 elements and 0 max capacity i.e 0 profit
                    dp[i][j]=0;
                }else if(i==0){
                    // 0 elements but capacity>0 i.e 0 profit
                    dp[i][j]=0;
                }else if(j==0){
                    // 0 max capacity and >0 elements i.e 0 profit
                    dp[i][j]=0;
                }else{
                    // if current element not considered
                    dp[i][j]=dp[i-1][j];
                    // if current element can be considered
                    if(j-B.get(i-1)>=0){
                        // if max capacity - current weight of item >= 0
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-B.get(i-1)]+A.get(i-1));
                    }
                }
            }
        }
        
        /*for(int i=0;i<=A.size();i++){
            for(int j=0;j<=C;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        
        return dp[A.size()][C];
    }
}
