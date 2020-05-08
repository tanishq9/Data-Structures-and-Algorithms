class Solution {
    public String minWindow(String s, String t) {
        int gstart=0,gend=Integer.MAX_VALUE,start=0,end=0,match_count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char cc:t.toCharArray()){
            map.put(cc,map.getOrDefault(cc,0)+1);
        }
        while(end<s.length()){
            char cend=s.charAt(end);
            if(map.containsKey(cend)){
                map.put(cend,map.get(cend)-1);
                if(map.get(cend)==0){
                    match_count++;
                }
            }
            while(match_count==map.size()){
                if(end-start<gend-gstart){
                    gstart=start;
                    gend=end;
                }
                char cstart=s.charAt(start);
                if(map.containsKey(cstart)){
                    map.put(cstart,map.get(cstart)+1);
                    if(map.get(cstart)>0){
                        match_count--;
                    }
                }
                start++;
            }
            end++;
        }
        if(gstart==0 && gend==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(gstart,gend+1);
    }
}