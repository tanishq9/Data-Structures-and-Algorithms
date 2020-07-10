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

class Solution {
    
    Node root;
    ArrayList<String> result;
    HashSet<String> set;
    
    void insertWord(String word){
        Node currNode=root;
        for(int i=0;i<word.length();i++){
            char cc=word.charAt(i);
            if(currNode.cmap.containsKey(cc)){
                currNode=currNode.cmap.get(cc);
            }else{
                Node newNode=new Node(cc);
                currNode.cmap.put(cc,newNode);
                currNode=newNode;
            }
        }
        currNode.eow=true;
    }
    
    void search(char[][] board,boolean[][] vis,int x,int y,Node root,String wsf){
        
        if(root.eow==true){
            if(!set.contains(wsf)){
                set.add(wsf);
                result.add(wsf);
            }
        }
        
        if(x<0 || y<0 || x==board.length || y==board[0].length){
            return;
        }
        
        if(vis[x][y]==true){
            return;
        }
        
    
        char cc=board[x][y];        
        if(root.cmap.containsKey(cc)){
            // mark visited as true, since we are visiting it for first time
            vis[x][y]=true;
            search(board,vis,x+1,y,root.cmap.get(cc),wsf+cc);
            search(board,vis,x-1,y,root.cmap.get(cc),wsf+cc);
            search(board,vis,x,y+1,root.cmap.get(cc),wsf+cc);
            search(board,vis,x,y-1,root.cmap.get(cc),wsf+cc);
            // mark unvisited as we have explored all paths through it  
            // so that it later can be included in some other possible path
            vis[x][y]=false;
        }
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        root=new Node('$'); 
        for(String word:words){
            insertWord(word);
        }
        result=new ArrayList<>();
        set=new HashSet<>();
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                // System.out.println(i+" "+j);
                search(board,visited,i,j,root,"");        
            }
        }
        return result;
    }
}