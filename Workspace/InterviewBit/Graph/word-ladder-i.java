public class Solution {
    class Pair{
        String word;int steps;
        Pair(String iw,int is){
            this.word=iw;this.steps=is;
        }
    }
    
    public int solve(String beginWord, String endWord, ArrayList<String> wordList) {
         // map : transformation -> words that can have that transformation
        HashMap<String,ArrayList<String>> intermediate=new HashMap<>();
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String transformation=word.substring(0,i)+"*"+word.substring(i+1);
                intermediate.putIfAbsent(transformation,new ArrayList<String>());
                intermediate.get(transformation).add(word);
            }
        }
        
        LinkedList<Pair> q=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        q.add(new Pair(beginWord,1));
        while(q.size()>0){
            // remove
            Pair fr=q.removeFirst();
            String word=fr.word;
            int steps=fr.steps;
            // mark
            if(visited.contains(word)){
                continue;
            }
            visited.add(word);
            // work
            if(word.equals(endWord)){
                return steps;
            }     
            for(int i=0;i<word.length();i++){
                String transformation=word.substring(0,i)+"*"+word.substring(i+1);
                ArrayList<String> list=intermediate.getOrDefault(transformation,new ArrayList<>());
                for(String str:list){
                    if(!visited.contains(str)){
                        q.addLast(new Pair(str,steps+1));
                    }
                }
            }
            
        }
        return 0;
    }
}