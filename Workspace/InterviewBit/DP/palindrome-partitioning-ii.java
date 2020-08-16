public class Solution {
    public int minCut(String A) {
        int n=A.length();
        boolean[][] isPalin=new boolean[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=i+gap;j<n;i++,j++){
                if(gap==0){
                    isPalin[i][j]=true;
                }else if(gap==1){
                    if(A.charAt(i)==A.charAt(j)){
                        isPalin[i][j]=true;
                    }
                }else{
                    if(A.charAt(i)==A.charAt(j) && isPalin[i+1][j-1]==true){
                        isPalin[i][j]=true;
                    }
                }
            }
        }
        int[][] dp=new int[n][n];
        // dp[i][j] tells what are minimum number of cuts to make string[i:j] palindrome
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=i+gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j]=0;
                }else if(gap==1){
                    if(A.charAt(i)==A.charAt(j)){
                        dp[i][j]=0;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    // aab -> a ab : 2 cuts(1 for ab and 1 for a,ab), aa b : 1 cut for aa,b
                    if(isPalin[i][j]==true){
                        dp[i][j]=0;
                        continue;
                    }
                    int min=Integer.MAX_VALUE;
                    // 0-3 : 0-0 + 1-3, 0-1 + 2-3, 0-2 + 3-3 
                    for(int cutPoint=i;cutPoint<=j-1;cutPoint++){
                        int leftCost=dp[i][cutPoint];
                        int rightCost=dp[cutPoint+1][j];
                        min=Math.min(min,leftCost+rightCost+1);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][n-1];
    }
}
