public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int max=Integer.MIN_VALUE;
        int[] temp=new int[n];
        // Since every col's value is greater than prev column value and same goes for rows
        // so we can do better than the usual O(N^3) time complexity
        for(int left=m-1;left>=0;left--){
            for(int i=0;i<n;i++){
                temp[i]+=A.get(i).get(left);
            }
            // apply kadane : to find maximum sum contiguous array
            int cs=temp[0],ms=temp[0];
            for(int i=1;i<n;i++){
                cs=Math.max(temp[i],cs+temp[i]);
                ms=Math.max(cs,ms);
            }
            max=Math.max(max,ms);
        }
        return max;
    }
}
