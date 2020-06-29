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

class Trie {
    
    /** Initialize your data structure here. */
    Node root;
    public Trie() {
        root=new Node('$');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n=word.length();
        Node curr=root;
        for(int i=0;i<n;i++){
            char cc=word.charAt(i);
            if(curr.cmap.containsKey(cc)){
                curr=curr.cmap.get(cc);
            }else{
                return false;
            }
        }
        return curr.eow;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n=prefix.length();
        Node curr=root;
        for(int i=0;i<n;i++){
            char cc=prefix.charAt(i);
            if(curr.cmap.containsKey(cc)){
                curr=curr.cmap.get(cc);
            }else{
                return false;
            }
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */