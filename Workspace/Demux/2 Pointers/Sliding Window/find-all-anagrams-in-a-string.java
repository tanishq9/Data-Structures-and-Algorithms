class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        // keep track of what is in the window
        HashMap<Character,Integer> map = new HashMap<>();
        int match_count=0;
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        // a-1, b-1, c-1
        int start=0,end=0;
        while(end<s.length()){
            char cc=s.charAt(end);
            // get to solution by expanding the window
            if(map.containsKey(cc)){
                // acquire this
                map.put(cc,map.get(cc)-1);
                // check if the character is fully acquired
                if(map.get(cc)==0){
                    match_count++;
                }
            } 
            // reached solution, try shrinking the video
            while(match_count==map.size()){
                if(end-start+1==p.length()){
                    list.add(start);
                }
                char cs=s.charAt(start);
                if(map.containsKey(cs)){
                    map.put(cs,map.get(cs)+1);
                    if(map.get(cs)>0){
                        match_count--;
                    }
                }
                // move ahead start pointer
                start++;
            }
            // move ahead end pointer
            end++;
        }
        return list;
    }
}