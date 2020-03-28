class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start=0,end=0,max=0;
        while(end<s.length()){
            // keep expanding the window till its valid
            int endCost=Math.abs(s.charAt(end)-t.charAt(end));
            maxCost-=endCost;
            // invalid : shrink the window to make it valid again
            while(maxCost<0){
                int startCost=Math.abs(s.charAt(start)-t.charAt(start));
                maxCost+=startCost;
                start++;
            }
            // valid i.e maxCost>=0
            max=Math.max(max,end-start+1);
            // acquire more characters
            end++;
        }
        return max;
    }
}