https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

class Solution {
    public int numberOfSubstrings(String s) {
        // 2 pointer is applicable as i increasse implies j also increases when both start from 0
        int total=0;
        int start=0,end=0,n=s.length();
        // take hashmap to keep track of characters inside the window
        HashMap<Character,Integer> map=new HashMap<>();
        while(end<n){
            char cend=s.charAt(end);
            map.put(cend,map.getOrDefault(cend,0)+1);
            // if the window becomes valid
            // then compute all possible valid strings by releasing the chars from start
            while(map.size()==3){ 
                // +1 to valid substrings in the valid window
                // add n-end-1 as it can strings after it will also be valid
                total+=(1+(n-end-1));
                // get start char and release it to shrink down the window till its valid
                char cstart=s.charAt(start);
                map.put(cstart,map.get(cstart)-1);
                if(map.get(cstart)==0){
                    map.remove(cstart);
                }
                // keep releasing till window becomes invalid
                start++;
            }
            // keep expanding the window by acquiring more characters
            end++;
        }
        return total;
    }
}