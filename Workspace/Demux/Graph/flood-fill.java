class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oc=image[sr][sc];
        boolean[][] vis=new boolean[image.length][image[0].length];
        fill(image,sr,sc,oc,newColor,vis);
        return image;
    }
    void fill(int[][] image,int x,int y,int oc,int nc,boolean[][] vis){
        if(x<0 || y<0 || x>=image.length || y>=image[0].length){
            return;
        }
        // don't visit the already visited vertex
        if(vis[x][y]){
            return;
        }
        vis[x][y]=true;
        if(image[x][y]==oc){
            image[x][y]=nc;
            fill(image,x+1,y,oc,nc,vis);
            fill(image,x-1,y,oc,nc,vis);
            fill(image,x,y+1,oc,nc,vis);
            fill(image,x,y-1,oc,nc,vis);
        }
    }
}