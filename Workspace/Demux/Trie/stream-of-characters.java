class StreamChecker {
    
    class Node{
        HashMap<Character,Node> cmap;
        char cc;
        boolean eow;
        Node(char ic){
            this.cc=ic;
            this.cmap=new HashMap<>();
            this.eow=false;
        }
    }
    
    Node root;
    StringBuilder global;
    
    void insert(String word){
        Node current=root;
        for(char cc:word.toCharArray()){
            if(!current.cmap.containsKey(cc)){
                Node nc=new Node(cc);
                current.cmap.put(cc,nc);
            }
            current=current.cmap.get(cc);
        }
        current.eow=true;
    }
  
    public StreamChecker(String[] words) {
        root=new Node('$');
        StringBuilder sb;
        global=new StringBuilder();
        for(String word:words){
            sb=new StringBuilder(word);
            insert(sb.reverse().toString());
        }
    }
    
    public boolean query(char letter) {
        global.append(letter);
        Node current=root;
        for(int i=global.length()-1;i>=0;i--){
            char cc=global.charAt(i);
            if(current.cmap.containsKey(cc) && current.cmap.get(cc).eow==true){
                return true;
            }else if(!current.cmap.containsKey(cc)){
                return false;
            }
            current=current.cmap.get(cc);
        }
        System.out.println();
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */