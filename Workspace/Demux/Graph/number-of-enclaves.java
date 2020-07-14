class Solution {
    void dfs(int[][] A,boolean[][] vis,int x,int y){
        if(x<0 || y<0 || x>=A.length || y>=A[0].length){
            return;
        }
        if(vis[x][y]){
            return;
        }
        if(A[x][y]!=1){
            return;
        }
        vis[x][y]=true;
        dfs(A,vis,x+1,y);
        dfs(A,vis,x-1,y);
        dfs(A,vis,x,y+1);
        dfs(A,vis,x,y-1);
    }
    public int numEnclaves(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // only traverse starting from boundary
                if((i==0 || j==0 || i==n-1 || j==m-1) && A[i][j]==1 && !visited[i][j]){
                    // System.out.println(i+" "+j);
                    dfs(A,visited,i,j);                    
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // check cells which are not on boundary(inside) and are 1 and also not visited
                if(!(i==0 || j==0 || i==n-1 || j==m-1) && A[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}