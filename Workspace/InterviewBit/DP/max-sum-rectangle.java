public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int max=Integer.MIN_VALUE;
        for(int left=0;left<m;left++){
            int[] temp=new int[n];
            for(int right=left;right<m;right++){
                for(int i=0;i<n;i++){
                    temp[i]+=A.get(i).get(right);
                }
                // apply kadane : to find maximum sum contiguous array
                int cs=temp[0],ms=temp[0];
                for(int i=1;i<n;i++){
                    cs=Math.max(temp[i],cs+temp[i]);
                    ms=Math.max(cs,ms);
                }
                max=Math.max(max,ms);
            }
        }
        return max;
    }
}
