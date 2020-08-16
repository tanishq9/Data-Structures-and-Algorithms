public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int max=0;
        for(int e:A){
            max=Math.max(max,e);
        }
        // size of dp array -> max capacity of friend
        int[] dp=new int[max+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        // dp[i] tells minimum cost to achieve 'i' capacity
        for(int i=0;i<B.size();i++){
            for(int j=B.get(i);j<=max;j++){
                if(dp[j-B.get(i)]!=Integer.MAX_VALUE){
                    // it means there should be a way to form j-B.get(i) as then
                    // then only B.get(i) could add to this and form j
                    dp[j]=Math.min(dp[j],dp[j-B.get(i)]+C.get(i));                    
                }
            }
        }
        int total=0;
        for(int i=0;i<A.size();i++){
            total+=dp[A.get(i)];
        }
        return total;
    }
}
