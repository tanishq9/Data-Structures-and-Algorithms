class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // first true framework       
        int lo=0,mid,hi=letters.length-1;
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if((letters[mid]-target)>0){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if((letters[lo]-target)>0){
            return letters[lo];
        }else{
            return letters[0];
        }
    }
}