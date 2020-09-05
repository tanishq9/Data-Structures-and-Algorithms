class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return dfs(s1,0,s2,0,new Integer[s1.length()][s2.length()]);
    }
    int dfs(String s1,int i1,String s2,int i2,Integer[][] dp){
        if(i1==s1.length()){
            int removeFromS2Cost=0;
            for(int i=i2;i<s2.length();i++){
                removeFromS2Cost+=s2.charAt(i);
            }
            return removeFromS2Cost;
        }
        if(i2==s2.length()){
            int removeFromS1Cost=0;
            for(int i=i1;i<s1.length();i++){
                removeFromS1Cost+=s1.charAt(i);
            }
            return removeFromS1Cost;
        }
        if(dp[i1][i2]!=null){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            return dfs(s1,i1+1,s2,i2+1,dp); 
        }else{
            // delete from string1
            int cost1=s1.charAt(i1)+dfs(s1,i1+1,s2,i2,dp);
            // or delete from string2
            int cost2=s2.charAt(i2)+dfs(s1,i1,s2,i2+1,dp);
            return dp[i1][i2]=Math.min(cost1,cost2);
        }   
    }
}