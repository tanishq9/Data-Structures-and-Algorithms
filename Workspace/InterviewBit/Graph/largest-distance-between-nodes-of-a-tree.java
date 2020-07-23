public class Solution {
    public int solve(ArrayList<Integer> A) {
        // adjacency list
        ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            gr.add(new ArrayList<>());
        }
        int src=-1;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==-1){
                src=i;
                continue;
            }
            gr.get(A.get(i)).add(i);
            gr.get(i).add(A.get(i));
        }
        // 2 bfs algo 
        // first bfs to find the farthest node
        // seconds bfs to find the max distance from farthest node
        LinkedList<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[A.size()];
        q.add(src);
        int lastNode=src;
        while(q.size()>0){
            int fr=q.removeFirst();
            if(vis[fr]){
                continue;
            }
            vis[fr]=true;
            // every iteration update the last node
            // bfs helps us to process level vise
            // therefore the last node processed will be the farthest node
            lastNode=fr;
            for(int i=0;i<gr.get(fr).size();i++){
                int ng=gr.get(fr).get(i);
                if(!vis[ng]){
                    q.addLast(ng);
                }
            }
        }
        // now do second bfs from the farthest node that we found
        LinkedList<int[]> qu=new LinkedList<>();
        vis=new boolean[A.size()];
        int max=0;
        qu.add(new int[]{lastNode,0});
        while(qu.size()>0){
            int[] fr=qu.removeFirst();
            int node=fr[0];
            int dist=fr[1];
            if(vis[node]){
                continue;
            }
            vis[node]=true;
            // update the max distance in every iteration
            max=Math.max(max,dist);
            for(int i=0;i<gr.get(node).size();i++){
                int ng=gr.get(node).get(i);
                if(!vis[ng]){
                    qu.addLast(new int[]{ng,dist+1});
                }
            }
        }
        return max;
    }
}
