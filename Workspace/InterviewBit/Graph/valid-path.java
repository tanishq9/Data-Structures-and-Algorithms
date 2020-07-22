public class Solution {
    class Pair{
        int x;
        int y;
        Pair(int ix,int iy){
            this.x=ix;
            this.y=iy;
        }
    }
    int[] xx={0,0,-1,1,-1,-1,1,1};
    int[] yy={-1,1,0,0,1,-1,1,-1};
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        // C is the number of points and D is the radius
        int r=D;
        boolean[][] visited=new boolean[A+1][B+1];
        // for every point in the rectangle
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                // check if its lying inside any circle of radius r
                for(int k=0;k<C;k++){
                    int cx=E.get(k);
                    int cy=F.get(k);
                    // if yes, then mark this cell as true
                    if(Math.sqrt(Math.pow(i-cx,2)+Math.pow(j-cy,2))<=r){
                        visited[i][j]=true;
                    }
                }
            }
        }
        // perform a BFS to reach from 0,0 to m,n if path exists
        LinkedList<Pair> q=new LinkedList<>();
        if(visited[0][0]==false){
            q.add(new Pair(0,0));
        }
        while(q.size()>0){
            Pair fr=q.removeFirst();
            if(fr.x==A && fr.y==B){
                return "YES";
            }
            if(visited[fr.x][fr.y]==true){
                continue;
            }else{
                visited[fr.x][fr.y]=true;
            }
            for(int i=0;i<8;i++){
                int px=fr.x+xx[i];
                int py=fr.y+yy[i];
                if(px>=0 && py>=0 && px<=A && py<=B && visited[px][py]==false){
                    q.addLast(new Pair(px,py));
                }
            }
            
        }
        return "NO";
    }
}
