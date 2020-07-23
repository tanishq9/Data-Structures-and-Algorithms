https://www.geeksforgeeks.org/0-1-bfs-shortest-path-binary-graph/

public class Solution {
    
    boolean wb(int i,int j,int A,int B){
        return i>=0 && j>=0 && i<A && j<B;
    }
    
    int[] xx={0,0,-1,1};
    int[] yy={1,-1,0,0};
    char[] zz={'R','L','U','D'};
    
    public int solve(int A, int B, ArrayList<String> C) {
        LinkedList<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[A][B];
        q.add(new int[]{0,0,0});
        int min=Integer.MAX_VALUE,dx=A-1,dy=B-1;
        while(q.size()>0){
            int[] fr=q.removeFirst();
            int cx=fr[0];
            int cy=fr[1];
            int ccost=fr[2];
            
            visited[cx][cy]=true;
            
            if(cx==dx && cy==dy){
                return ccost;
            }
            
            char cc=C.get(cx).charAt(cy);
            
            for(int i=0;i<4;i++){
                int px=cx+xx[i];
                int py=cy+yy[i];
                char move=zz[i];
                if(wb(px,py,A,B) && !visited[px][py] && cc==move){
                    q.addFirst(new int[]{px,py,ccost});
                }else if(wb(px,py,A,B) && !visited[px][py] && cc!=move){
                    q.addLast(new int[]{px,py,ccost+1}); 
                }
            }
            
        }
        
        return min;
    }
}
/*
Thinking of shortest path algorithms the first thing that comes to our mind is Dijsktra Algorithm with time complexity of O(V+ElogV) which is good but can we make it better?

The answer is yes we can apply 0-1 BFS here which is nothing just a BFS on weighted graph where each edge has binary weights.

So what does the 0-1 BFS algo says:
Read it from here : Click here

So, till here you are clear about the concept and implementation of 0-1 BFS.

Algorithm:

1) Start with cell (0,0) push it into the doubly-ended queue and also make it distance as 0.
2) Pop the front node from the queue.
3) You can go to four directions from the popped node so if you go to a direction that is written on the cell then mark dist[neighbour]=dist[current]+1 else dist[neighbour]=dist[curr]
4) If direction in which you move is not same as the direction written on the cell so this implies you have to incur a cost of 1 so push it to the back of queue else push it to the front of the queue.
5) Repeat steps 2-4
*/

