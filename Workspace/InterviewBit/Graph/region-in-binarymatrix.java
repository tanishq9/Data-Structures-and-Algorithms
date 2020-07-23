public class Solution {
    
    void dfs(ArrayList<ArrayList<Integer>> A,boolean[][] vis,int x,int y,int[] count){
        if(x<0 || y<0 || x>=A.size() || y>=A.get(0).size()){
            return;
        }
        if(vis[x][y]){
            return;
        }
        if(A.get(x).get(y)!=1){
            return;
        }
        vis[x][y]=true;
        count[0]++;
        dfs(A,vis,x+1,y,count);
        dfs(A,vis,x-1,y,count);
        dfs(A,vis,x,y+1,count);
        dfs(A,vis,x,y-1,count);
        dfs(A,vis,x+1,y+1,count);
        dfs(A,vis,x+1,y-1,count);
        dfs(A,vis,x-1,y+1,count);
        dfs(A,vis,x-1,y-1,count);        
    }
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        boolean[][] vis=new boolean[A.size()][A.get(0).size()];
        int max=0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(!vis[i][j] && A.get(i).get(j)==1){
                    // obj is passed so that it can be used as reference 
                    // i.e it wont change with recursive calls
                    int[] count=new int[1];
                    dfs(A,vis,i,j,count);
                    max=Math.max(max,count[0]);
                }
            }
        }
        return max;
    }
}
