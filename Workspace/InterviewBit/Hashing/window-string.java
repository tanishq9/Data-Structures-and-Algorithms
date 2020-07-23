public class Solution {
    public String minWindow(String A, String B) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char cc:B.toCharArray()){
            map.put(cc,map.getOrDefault(cc,0)+1);
        }
        int start=0,end=0,matchCount=0,min=Integer.MAX_VALUE,mine=-1,mins=0;
        while(end<A.length()){
            char cend=A.charAt(end);
            if(map.containsKey(cend)){
                map.put(cend,map.get(cend)-1);
                if(map.get(cend)==0){
                    matchCount++;
                }
            }
            // valid window, so find minimum 
            while(matchCount==map.size()){
                if(min>end-start+1){
                    mine=end;
                    mins=start;
                    min=end-start+1;
                }
                char cstart=A.charAt(start);
                if(map.containsKey(cstart)){
                    map.put(cstart,map.get(cstart)+1);
                    if(map.get(cstart)>0){
                        matchCount--;
                    }
                }
                // keep releasing to shrink window
                start++;
            }
            // keep acquiring to expand window
            end++;
        }
        return A.substring(mins,mine+1);
    }
}
