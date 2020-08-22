public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int j=0;
        while(j<A.size()){
            // skip past the duplicates
            while(j+1<A.size() && A.get(j)==A.get(j+1)){
                j++;
            }
            // compute numbers of element GREATER THAN the current number
            int greater=A.size()-1-j;
            if(A.get(j)==greater){
                return 1;
            }
            // explore further numbers
            j++;
        }
        return -1;
    }
}
