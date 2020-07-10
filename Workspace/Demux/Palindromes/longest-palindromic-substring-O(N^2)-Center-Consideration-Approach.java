class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
	// We are expanding 'possible palindrome' by considering each index
	// as the center of every 'possible' palindrome (mirror technique)
        // Using this center of palindrome technique, we get O(N^2) approach
        // it is less time consuming as compared to the standard : O(N^3) approach
        int n=s.length(),center=0,maxLength=1,maxC=0;
        while(center<n){
            // consider it as center of an odd length string
            int l=center-1,r=center+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(maxLength<r-l-1){
                maxLength=r-l-1;
                maxC=center;
            }
            // consider it as center of an even length string
            if(center+1<n && s.charAt(center)==s.charAt(center+1)){
                l=center-1;r=center+2;
                while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                } 
                if(maxLength<r-l-1){
                    maxLength=r-l-1;
                    maxC=center;
                }
            }
            // consider other possible centers
            center++;
        }
        int start=maxC-(maxLength-1)/2;
        return s.substring(start,start+maxLength);
    }
}