public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if(A.size()==0){
            return 0;
        }
        int min=A.get(0),best=0;
        // we fix every i as the selling point and update the best and the buying point
        // aim is to keep selling point as high as possible and buying point as low
        for(int i=1;i<A.size();i++){
            if(best<A.get(i)-min){
                best=A.get(i)-min;
            }
            min=Math.min(min,A.get(i));
        }
        return best;
    }
}