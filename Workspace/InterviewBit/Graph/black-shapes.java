public class Solution {
    public int black(ArrayList<String> A) {
        char[][] gr=new char[A.size()][A.get(0).length()];
        int index=0;
        for(int i=0;i<A.size();i++){
            char[] arr=A.get(i).toCharArray();
            for(int j=0;j<arr.length;j++){
                gr[index][j]=arr[j];
            }
            index++;
        }
        boolean[][] vis=new boolean[gr.length][gr[0].length];
        int count=0;
        for(int i=0;i<gr.length;i++){
            for(int j=0;j<gr[0].length;j++){
                if(gr[i][j]=='X' && !vis[i][j]){
                    dfs(gr,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] gr,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=gr.length || j>=gr[0].length){
            return;
        }
        if(gr[i][j]!='X'){
            return;
        }
        if(vis[i][j]){
            return;
        }
        vis[i][j]=true;
        dfs(gr,vis,i+1,j);
        dfs(gr,vis,i-1,j);
        dfs(gr,vis,i,j+1);
        dfs(gr,vis,i,j-1);
    }
    
}
