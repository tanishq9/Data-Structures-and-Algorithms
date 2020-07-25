class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String iw,int is){
            this.word=iw;
            this.steps=is;
        }
    }
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        char[] begin=start.toCharArray();
        // for the start word
        for(int i=0;i<bank.length;i++){
            char[] str=bank[i].toCharArray();
            int count=0; // number of mutations 
            for(int j=0;j<str.length;j++){
                if(str[j]!=begin[j]){
                    count++;
                }
                if(count>1){
                    break;
                }
            }
            if(count==1){
                map.putIfAbsent(start,new ArrayList<>());
                map.get(start).add(bank[i]);
            }
        }
        // for all bank words
        for(int i=0;i<bank.length;i++){
            for(int j=i+1;j<bank.length;j++){
                char[] str1=bank[i].toCharArray();
                char[] str2=bank[j].toCharArray();
                int count=0;
                for(int k=0;k<str1.length;k++){
                    if(str1[k]!=str2[k]){
                        count++;
                    }
                    if(count>1){
                        break;
                    }
                }
                if(count==1){
                    map.putIfAbsent(bank[i],new ArrayList<>());
                    map.putIfAbsent(bank[j],new ArrayList<>());                    
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }
            
        }
        // now the map for word and its corresponding list of one diff words in built
        LinkedList<Pair> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        q.add(new Pair(start,0));
        while(q.size()>0){
            Pair fr=q.removeFirst();
            if(vis.contains(fr.word)){
                continue;
            }
            vis.add(fr.word);
            if(fr.word.equals(end)){
                return fr.steps;
            }
            for(String temp:map.getOrDefault(fr.word,new ArrayList<>())){
                if(!vis.contains(temp)){
                    q.addLast(new Pair(temp,fr.steps+1));
                }
            }
        }
        return -1;
    }
}