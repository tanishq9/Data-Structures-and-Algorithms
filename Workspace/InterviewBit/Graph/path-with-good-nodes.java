public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        // Init Graph
        ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
        for(int i=0;i<=A.size();i++){
            gr.add(new ArrayList<>());
        }
        for(ArrayList<Integer> e:B){
            int v1=e.get(0);
            int v2=e.get(1);
            gr.get(v1).add(v2);
            gr.get(v2).add(v1);
        }
        boolean[] vis=new boolean[A.size()+1];
        // Use a queue for BFS
        LinkedList<int[]> q=new LinkedList<>();
        q.add(new int[]{1,A.get(0)});
        // Count the number of valid paths
        int count=0;
        while(q.size()>0){
            int[] fr=q.remove();
            int vtx=fr[0];
            int score=fr[1];
            if(vis[vtx]){
                continue;
            }
            vis[vtx]=true;
            
            // Check if score is atmost C and is a leaf node
            if(score<=C && gr.get(vtx).size()==1){
                count++;
                continue;
            }
            
            // Add neigbhors to the queue for processing
            for(int i=0;i<gr.get(vtx).size();i++){
                int ng=gr.get(vtx).get(i);
                if(!vis[ng]){
                    q.addLast(new int[]{ng,score+A.get(ng-1)});
                }
            }
        }
        return count;
    }
}
