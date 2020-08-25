public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
        for(int i=0;i<=A;i++){
            gr.add(new ArrayList<>());
        }
        for(ArrayList<Integer> e:B){
            int u=e.get(0);
            int v=e.get(1);
            gr.get(u).add(v);
            gr.get(v).add(u);
        }
        boolean[] vis=new boolean[A+1];
        // check for all the nodes
        for(int i=1;i<=A;i++){
            if(!vis[i]){
                LinkedList<Integer> q=new LinkedList<>();
                q.add(i);
                while(q.size()>0){
                    int fr=q.removeFirst();
                    if(vis[fr]){
                        return 1;
                    }
                    vis[fr]=true;
                    for(int j=0;j<gr.get(fr).size();j++){
                        int ng=gr.get(fr).get(j);
                        if(!vis[ng]){
                            q.add(ng);
                        }
                    }
                }        
            }
        }
        return 0;
    }
}
