class Solution {
    int[] xx={0,0,1,-1};
    int[] yy={1,-1,0,0};
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        // m*n grid
        int m=board.length;
        int n=board[0].length;
        LinkedList<int[]> q=new LinkedList<>();
        // first row and last row 
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]=='O'){
                board[0][col]='W';
                q.add(new int[]{0,col});
            }
            if(board[m-1][col]=='O'){
                board[m-1][col]='W';
                q.add(new int[]{m-1,col});
            }
        }
        // leftmost column and rightmost column 
        for(int row=0;row<board.length;row++){
            if(board[row][0]=='O'){
                board[row][0]='W';
                q.add(new int[]{row,0});
            }
            if(board[row][n-1]=='O'){
                board[row][n-1]='W';
                q.add(new int[]{row,n-1});
            }
        }
        boolean[][] visited=new boolean[m][n];
        while(q.size()>0){
            int[] fr=q.removeFirst();
            int x=fr[0];
            int y=fr[1];
            if(visited[x][y]){
                continue;
            }
            visited[x][y]=true;
            for(int i=0;i<4;i++){
                int px=x+xx[i];
                int py=y+yy[i];
                if(px>=0 && py>=0 && px<board.length && py<board[0].length && 
                                    board[px][py]=='O' && !visited[px][py] ){
                    board[px][py]='W';
                    q.add(new int[]{px,py});
                }
            }
        }
        // replace W with O and O with X as remaining O will be surrounded by X 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='W'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}