class Node{
    char cc;
    HashMap<Character,Node> cmap;
    ArrayList<Integer> indexes;
    Node(char ic){
        this.cc=ic;
        this.cmap=new HashMap<>();
        this.indexes=new ArrayList<>();
    }
}

class WordFilter {
    
    Node rootP=new Node('$'); // root of Prefix tree
    Node rootS=new Node('$'); // root of Suffix tree
    
    public WordFilter(String[] words) {
        for(int i=0;i<words.length;i++){
            // add in prefix tree
            addP(rootP,i,words[i]);
            addS(rootS,i,reverse(words[i]));
            // System.out.println(i);
        }
    }
    
    String reverse(String word){
        char[] w=word.toCharArray();
        int i=0,j=w.length-1;
        while(i<j){
            char temp=w[i];
            w[i]=w[j];
            w[j]=temp;
            i++;
            j--;
        }
        return new String(w);
    }
    
    void addP(Node root,int index,String word){
        int n=word.length();
        Node curr=root;
        for(int i=0;i<n;i++){
            char cc=word.charAt(i);
            curr.indexes.add(index);
            if(curr.cmap.containsKey(cc)){
                curr=curr.cmap.get(cc);
            }else{
                Node newNode=new Node(cc);
                curr.cmap.put(cc,newNode);
                curr=newNode;
            }
        }
        curr.indexes.add(index);
    }
    
    void addS(Node root,int index,String word){
        int n=word.length();
        Node curr=root;
        for(int i=0;i<n;i++){
            char cc=word.charAt(i);
            curr.indexes.add(index);
            if(curr.cmap.containsKey(cc)){
                curr=curr.cmap.get(cc);
            }else{
                Node newNode=new Node(cc);
                curr.cmap.put(cc,newNode);
                curr=newNode;
            }
        }
        curr.indexes.add(index);
    }
    
    public int f(String prefix, String suffix) {
        ArrayList<Integer> getPList=search(prefix,rootP);
        ArrayList<Integer> getSList=search(reverse(suffix),rootS);
        int i=getPList.size()-1;
        int j=getSList.size()-1;
        // System.out.println(i+" "+j);
        while(i>=0 && j>=0){
            if(getPList.get(i)>getSList.get(j)){
                i--;
            }else if(getPList.get(i)<getSList.get(j)){
                j--;
            }else{
                return getPList.get(i);
            }
        }
        return -1;
    }
    
    ArrayList<Integer> search(String word,Node root){
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
        return curr.indexes;
    }
    
}



/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */