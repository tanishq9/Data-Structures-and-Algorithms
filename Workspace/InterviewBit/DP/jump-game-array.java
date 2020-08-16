public class Solution {
    public int canJump(ArrayList<Integer> A) {
        boolean[] dp=new boolean[A.size()];
        dp[0]=true;
        // dp[i] tells whether that ith index is reachable or not
        for(int i=0;i<A.size();i++){
            if(dp[i]==false){
                // couldn't reach ith cell from 0th cell
                return 0;
            }
            for(int j=i+1;j<A.size() && j<=i+A.get(i);j++){
                if(j==A.size()-1){
                    // last cell reached, no check further
                    return 1;
                }
                dp[j]=true;
            }
        }
        return dp[A.size()-1]==true?1:0;
    }
}
