class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int mid=0,lo=0,hi=letters.length-1;
        // first true in f*t*
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(letters[mid]>target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        // sanity check : as answer will always be within bounds, so this final check is necessary
        if(letters[lo]>target){
            return letters[lo];
        }else{
            return letters[0];
        }
    }
}