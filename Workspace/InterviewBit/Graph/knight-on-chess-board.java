public class Solution {
    
    int[] xx={2,2,-2,-2,1,1,-1,-1};
    int[] yy={1,-1,1,-1,2,-2,2,-2};
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        
        LinkedList<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[A+1][B+1];
        q.add(new int[]{C,D,0});
        
        while(q.size()>0){
            
            int[] fr=q.removeFirst();
            
            int cx=fr[0];
            int cy=fr[1];
            int steps=fr[2];
            
            if(vis[cx][cy]){
                continue;
            }
            vis[cx][cy]=true;
            if(cx==E && cy==F){
                return steps;
            }
            
            for(int i=0;i<8;i++){
                int px=cx+xx[i];
                int py=cy+yy[i];
                if(px>=1 && py>=1 && px<=A && py<=B && !vis[px][py]){
                    q.addLast(new int[]{px,py,steps+1});
                }
            }
            
        }
        return -1;	        
    }
    
}
