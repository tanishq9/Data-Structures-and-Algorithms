public class Solution {
    public int lengthOfLongestSubstring(String A) {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0,end=0,max=0;
        boolean valid=true;
        while(end<A.length()){
            char cend=A.charAt(end);
            map.put(cend,map.getOrDefault(cend,0)+1);
            if(map.get(cend)>1){
                valid=false;
            }
            while(valid==false){
                char cstart=A.charAt(start);
                // only consider characters in that window, delete past records
                map.put(cstart,map.get(cstart)-1);
                if(map.get(cstart)==1){
                    valid=true;
                }
                // keep releasing
                start++;
            }
            max=Math.max(max,end-start+1);
            // keep expanding the window
            end++;
        }
        return max;
    }
}
