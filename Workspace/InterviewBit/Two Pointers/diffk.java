public class Solution {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int start=0,end=1;
        while(end<A.size()){
            int startVal=A.get(start);
            int endVal=A.get(end);
            if(start!=end){
                int diff=endVal-startVal;
                if(diff<B){
                    end++;
                }else if(diff>B){
                    start++;
                }else{
                    return 1;
                }
            }else{
                end++;
            }
        }
        return 0;
    }
}
