class Solution {
    public int characterReplacement(String s, int k) {
        int start=0,end=0;
        int maxCount=0,max=0;
        int[] freq=new int[26];
        while(end<s.length()){
            maxCount=Math.max(maxCount,++freq[s.charAt(end)-'A']);
            // window is valid if the number of different characters in it except the maxFreq element is <=k
            // window is invalid so shrink
            while((end-start+1-maxCount)>k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            max=Math.max(max,end-start+1);
            // expand window
            end++;
        }
        return max;
    }
}