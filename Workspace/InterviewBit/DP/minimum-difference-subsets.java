public class Solution {
    public int solve(ArrayList<Integer> A) {
        int sum=0;
        for(int e:A){
            sum+=e;
        }
        boolean[][] dp=new boolean[A.size()+1][sum+1];
        for(int i=0;i<=A.size();i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }else if(j-A.get(i-1)>=0 && dp[i][j-A.get(i-1)]==true){
                        dp[i][j]=true;
                    }
                }
            }
        }
        int min=sum;
        for(int j=sum/2;j>=0;j--){
            if(dp[A.size()][j]==true){
                int s1sum=j; // subset1 sum
                int s2sum=sum-j; // subset2 sum
                return s2sum-s1sum;
            }
        }
        return -1;
    }
}
