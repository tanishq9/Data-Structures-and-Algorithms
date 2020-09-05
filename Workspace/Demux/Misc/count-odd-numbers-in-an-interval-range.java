class Solution {
    public int countOdds(int low, int high) {
        if(low%2==0){
            // remaining number of elements considering element at low is even
            int rm=high-low;
            // e [o e o e]
            // e [o e o e o]
            if(rm%2==0){
                return rm/2;
            }else{
                return rm/2 + 1;
            }
        }else{
            // remaining number of elements considering element at low is odd
            int rm=high-low;
            // o [e o e o]
            // o [e o e o e]
            if(rm%2==0){
                return 1 + rm/2;
            }else{
                return 1 + rm/2;
            }
        }
    }
}