public class Solution {
    public int bulbs(ArrayList<Integer> A) {
        int flips=0;
        for(int i=0;i<A.size();i++){
            int change=flips%2;
            // 'change' will tell whether the original sign was changed or not
            // if change is 0 then it will same sign as starting
            // else if change is 1 then it means it's sign would have changed i.e 0 if 1 and 1 if it was 0
            if(change==0){
                // if no overall change
                if(A.get(i)==0){
                    flips++;
                }else{
                    // if already 1, then just let it be
                    // don't increase the number of flips
                }
            }else{
                // if opposite sign to starting
                if(A.get(i)==0){
                    // if change is 1 i.e it would have been changed to 1
                    // therefore don't change its sign now as its already 1!
                }else{
                    flips++;
                }
            }
        }
        return flips;
    }
}
