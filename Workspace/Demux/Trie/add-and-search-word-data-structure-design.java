class Node{
    char cc;
    boolean eow;
    HashMap<Character,Node> cmap;
    Node(char ic){
        this.cc=ic;
        this.eow=false;
        this.cmap=new HashMap<>();
    }
}

class WordDictionary {
    
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node('$');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int n=word.length();
        Node curr=root;
        for(int i=0;i<n;i++){
            char cc=word.charAt(i);
            if(curr.cmap.containsKey(cc)){
                curr=curr.cmap.get(cc);    
            }else{
                Node newNode=new Node(cc);
                curr.cmap.put(cc,newNode);
                curr=newNode;
            }
        }
        curr.eow=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word,root);
    }
    
    boolean helper(String word,Node curr){
        if(word.length()==0){
            return curr.eow;
        }
        char cc=word.charAt(0);
        String ros=word.substring(1);
        if(cc!='.' && curr.cmap.containsKey(cc)==false){
            return false;
        }else if(cc!='.' && curr.cmap.containsKey(cc)==true){
            if(helper(ros,curr.cmap.get(cc))){
                return true;
            }else{
                return false;
            }
        }else{
            for(char key : curr.cmap.keySet()){
                if(helper(ros,curr.cmap.get(key))){
                    return true;
                }
            }
            return false;
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */