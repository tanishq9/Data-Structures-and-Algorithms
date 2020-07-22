public class Solution {
    public int exist(ArrayList<String> A, String B) {
        char[][] gr=new char[A.size()][A.get(0).length()];
        int index=0;
        for(int i=0;i<A.size();i++){
            char[] arr=A.get(i).toCharArray();
            for(int j=0;j<arr.length;j++){
                gr[index][j]=arr[j];
            }
            index++;
        }
        for(int i=0;i<gr.length;i++){
            for(int j=0;j<gr[0].length;j++){
                if(gr[i][j]==B.charAt(0) && dfs(gr,new boolean[gr.length][gr[0].length],i,j,0,B)){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    boolean dfs(char[][] gr,boolean[][] vis,int x,int y,int index,String str){
        if(x<0 || y<0 || x>=gr.length || y>=gr[0].length){
            return false;
        }
        if(index==str.length()){
            return true;
        }
        // each cell can be visited more than once so don't check for vis[i][j]=false
        // because cell can even be visited if vis[i][j]=true i.e already visited
        if(gr[x][y]==str.charAt(index)){
            if(dfs(gr,vis,x+1,y,index+1,str)){
                // either here write vis[x][y]=false
                // or each time pass a fresh boolean matrix
                // otherwise if we keep on returning true then
                // the path will not be unset and wouldn't 
                // be able to be used to search for other words
                // incase of multiple words are to be searched
                // but works for one word search as we don't have
                // to search any further words
                return true;
            }
            if(dfs(gr,vis,x-1,y,index+1,str)){
                return true;
            }
            if(dfs(gr,vis,x,y+1,index+1,str)){
                return true;
            }
            if(dfs(gr,vis,x,y-1,index+1,str)){
                return true;
            }         
        }
        return false;
    }
    
}
