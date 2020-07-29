public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int i=0,j=0,sum=0,count=0;
        while(j<A.size()){
            sum+=A.get(j);
            // check for invalid window
            while(sum>=B){
                sum-=A.get(i);
                i++;
            }
            count+=j-i+1;
            // expand the window 
            j++;
        }
        return count;
    }
}
