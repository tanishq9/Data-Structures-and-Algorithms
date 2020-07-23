public class Solution {
     public int fibsum(int A) {
        ArrayList<Integer> coins=new ArrayList<>();
        int ft=1;
        int st=1;
        coins.add(1);
        while(st<=A){
            int tt=ft+st;
            ft=st;
            st=tt;
            coins.add(tt);
        }
        int count=0;
        int index=coins.size()-1;
        // Greedy solution works, so using DP will be an overkill
        while(A>0){
            count+=A/coins.get(index);
            A=A%coins.get(index);
            index--;
        }
        return count;
    }
    
    public int fibsumDP(int A) {
        ArrayList<Integer> coins=new ArrayList<>();
        int ft=1;
        int st=1;
        coins.add(1);
        while(st<=A){
            int tt=ft+st;
            ft=st;
            st=tt;
            coins.add(tt);
        }
        int[] dp=new int[A+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.size();i++){
            for(int j=coins.get(i);j<=A;j++){
                if(dp[j-coins.get(i)]!=Integer.MAX_VALUE
                        && dp[j-coins.get(i)]+1<dp[j]){
                    dp[j]=dp[j-coins.get(i)]+1;
                }
            }
        }
        return dp[A];
    }
}
