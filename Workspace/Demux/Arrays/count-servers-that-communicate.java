class Solution {
    public int countServers(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[] rowCount=new int[grid.length];
        int[] colCount=new int[grid[0].length];
        int total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rowCount[i]+=1;
                    colCount[j]+=1;
                    total+=1;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(rowCount[i]==1 && colCount[j]==1){
                        total-=1;
                    }
                }
            }
        }
        return total;
    }
}