public class Solution {
    
    class Node{
        char cc;
        HashMap<Character,Node> cmap;
        boolean eow;
        int count; // tells how many times this character has been seen 
        Node(char ic){
            this.cc=ic;
            this.cmap=new HashMap<>();
            this.count=1;
            this.eow=false;
        }
    }
    
    Node root;
    
    void insertInTrie(String str){
        Node current=root;
        for(char cc:str.toCharArray()){
            if(current.cmap.containsKey(cc)){
                current=current.cmap.get(cc);
                current.count+=1; // increment count as the word has been seen 1 more time
            }else{
                current.cmap.put(cc,new Node(cc));
                current=current.cmap.get(cc);
            }
        }
        current.eow=true;
    }
    
    String getUnique(String str){
        Node current=root;
        StringBuilder sb=new StringBuilder();
        for(char cc:str.toCharArray()){
            if(current.cmap.containsKey(cc)){
                current=current.cmap.get(cc);
                // System.out.println(current.cc+" "+current.count);
            }
            // append the current node's character to the stringbuilder
            sb.append(current.cc);
            // check here now if the current character has occurred in only one string
            if(current.count==1){
                return sb.toString();
            }
        }
        // this condition will never hit
        return "";
    }
    
    public String[] prefix(String[] A) {
        root=new Node('$');
        for(int i=0;i<A.length;i++){
            insertInTrie(A[i]);
        }
        String[] uniquePrefix=new String[A.length];
        for(int i=0;i<A.length;i++){
            uniquePrefix[i]=getUnique(A[i]);
        }
        return uniquePrefix;
    }
}
