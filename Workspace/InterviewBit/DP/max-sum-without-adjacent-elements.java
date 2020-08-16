public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int[] dp=new int[m]; 
        // dp[i] tells what is the max amount possible till index i
        for(int i=0;i<m;i++){
            dp[i]=Math.max(A.get(0).get(i),A.get(1).get(i));
            dp[i]+=(i-2)>=0?dp[i-2]:0;
            if(i-1>=0){
                dp[i]=Math.max(dp[i],dp[i-1]);
            }
        }
        return dp[m-1];
    }
}
