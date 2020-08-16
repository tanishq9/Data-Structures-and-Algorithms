public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> set=new HashSet<>();
        for(String str:B){
            set.add(str);
        }
        // dp[i] tells whether 'i' length string could be successfully segmented 
        boolean[] dp=new boolean[A.length()+1];
        // empty string need not be segmented
        dp[0]=true;
        for(int i=1;i<=A.length();i++){
            for(int j=i;j>=0;j--){
                if(dp[i]==true){
                    // use this optimization to avoid TLE
                    break;
                }
                if(dp[j]==true && set.contains(A.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[A.length()]==true?1:0;
    }
}
