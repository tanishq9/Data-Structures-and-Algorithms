public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        boolean[][] vis=new boolean[a][a];
        helper(a,0,res,vis);
        return res;
    }
    void helper(int a,int row,ArrayList<ArrayList<String>> res,boolean[][] vis){
        if (row == a) {
            // means i have got a valid configration
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                String str = "";
                for (int j = 0; j < a; j++) {
                    if (vis[i][j]) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                temp.add(str);
            }
            res.add(temp);
            return;
        }
        for(int j=0;j<a;j++){
            if(canBePlaced(a,row,j,vis)){
                // place urself
                vis[row][j]=true;
                // try to place in the next row
                helper(a,row+1,res,vis);
                // explore more paths
                vis[row][j]=false;
            }
        }
    }
    
    boolean canBePlaced(int a,int i,int j,boolean[][] vis){
        // vertical and both diagonals
        // check for all rows in same column above it
        for(int row=i-1;row>=0;row--){
            if(vis[row][j]){
                return false;
            }
        }
        // check for left upper diagonal
        int sx=i-1,sy=j-1;
        while(sx>=0 && sy>=0){
            if(vis[sx][sy]){
                return false;
            }
            sx--;
            sy--;
        }
        // check for right upper diagonal
        sx=i-1;sy=j+1;
        while(sx>=0 && sy<a){
            if(vis[sx][sy]){
                return false;
            }
            sx--;
            sy++;
        }
        return true;
    }
    
}
