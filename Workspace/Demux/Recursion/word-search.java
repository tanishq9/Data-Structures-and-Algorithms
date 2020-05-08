class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(f(board,i,j,word,0,new boolean[board.length][board[0].length])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // proactive recursive karo kyuki bilkul ricks nhi lena 
    public boolean f(char[][] board,int i,int j,String word,int wordIndex,boolean[][] visited){
        
        // if we get the whole word
        if(wordIndex==word.length()){
            return true;
        }
        
        // ensuring we are always within bounds and that cell is not visited before
        if(i>=0 && i<board.length && j>=0 && j<board[0].length){
            if(visited[i][j]==false && board[i][j]==word.charAt(wordIndex)){
                visited[i][j]=true;
                // kisi ek raste ke through true aa jaaye tab baaki paths ko explore nhi karegey
                boolean left=f(board,i,j-1,word,wordIndex+1,visited);
                if(left)return true;
                boolean right=f(board,i,j+1,word,wordIndex+1,visited);
                if(right)return true;
                boolean top=f(board,i-1,j,word,wordIndex+1,visited);
                if(top)return true;
                boolean down=f(board,i+1,j,word,wordIndex+1,visited); 
                if(down)return true;
                visited[i][j]=false;
                // dont explore all instead check ki agar ek path ke through ki true aajaye tabhi return krdo
                /*if(left || right || top || down){
                    return true;
                }*/
            } 
        }
        // returning false since out of bounds 
        return false;
    }
    
}