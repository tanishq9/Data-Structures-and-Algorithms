class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        f(sr,sc,image,new boolean[image.length][image[0].length],image[sr][sc],newColor);    
        return image;
    }
    
    void f(int sr,int sc,int[][] im,boolean[][] vis,int oc,int nc){
        // out of bounds
        if(sr<0 || sr>=im.length || sc<0 || sc>=im[0].length){
            return;
        }
        
        // don't process the nodes which are already processed
        if(vis[sr][sc]==true){
            return;
        }
        
        // make it as processed and call its 4 neighbouring cells
        vis[sr][sc]=true;
        
        // check if its color is same as original color and replace it with new color
        if(im[sr][sc]==oc){
            im[sr][sc]=nc;
            f(sr+1,sc,im,vis,oc,nc);
            f(sr,sc+1,im,vis,oc,nc);
            f(sr-1,sc,im,vis,oc,nc);
            f(sr,sc-1,im,vis,oc,nc);
        }
    }
    
}