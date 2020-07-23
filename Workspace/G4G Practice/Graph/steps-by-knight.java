import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    static int[] xx={2,2,-2,-2,1,1,-1,-1};
    static int[] yy={1,-1,1,-1,2,-2,2,-2};
    
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int sx=sc.nextInt();
	        int sy=sc.nextInt();
	        int dx=sc.nextInt();
	        int dy=sc.nextInt();
	        System.out.println(bfs(sx,sy,dx,dy,n));
	    }
	 }
	 
	 static int bfs(int sx,int sy,int dx,int dy,int n){
	    LinkedList<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n+1][n+1];
        q.add(new int[]{sx,sy,0});
        
        while(q.size()>0){
            
            int[] fr=q.removeFirst();
            
            int cx=fr[0];
            int cy=fr[1];
            int steps=fr[2];
            
            if(vis[cx][cy]){
                continue;
            }
            vis[cx][cy]=true;
            if(cx==dx && cy==dy){
                return steps;
            }
            
            for(int i=0;i<8;i++){
                int px=cx+xx[i];
                int py=cy+yy[i];
                if(px>=1 && py>=1 && px<=n && py<=n && !vis[px][py]){
                    q.addLast(new int[]{px,py,steps+1});
                }
            }
            
        }
        
        return 1;	        
	 }
}