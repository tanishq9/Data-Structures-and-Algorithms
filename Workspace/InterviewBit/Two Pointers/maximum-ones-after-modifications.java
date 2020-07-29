public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int countZeros=0,i=0,j=0,max=0;
        while(j<A.size()){
            int val=A.get(j);
            if(val==0){
                countZeros++;
            }
            // check for invalid window
            while(countZeros>B){
                int valStart=A.get(i);
                if(valStart==0){
                    countZeros--;    
                }
                i++;
            }
            max=Math.max(max,j-i+1); 
            // expand the window 
            j++;
        }
        return max;
    }
}
