class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp=new int[s.length()+1];
        // dp[i] tells whether it is possible to partition string of length i
        dp[0]=1;
        for(int len=1;len<=s.length();len++){
            // for string of length 'len', I draw partition at length 'j' and
            // check whether the length 'j' is partitionable and the dictionary contains word of length j to len
            for(int j=0;j<=len-1;j++){
                if(dp[j]==1 && wordDict.contains(s.substring(j,len))){
                    // yes, we can partition in this case
                    dp[len]=1;
                }
            }
        }
        // dp[str.length()] tells whether it is possible to partition the string 
        return dp[s.length()]==1;
    }
}