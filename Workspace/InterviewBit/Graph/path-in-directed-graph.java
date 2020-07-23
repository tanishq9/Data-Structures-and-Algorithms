public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] vis=new boolean[A+1];
        ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
        for(int i=0;i<=A;i++){
            gr.add(new ArrayList<>());
        }
        for(ArrayList<Integer> e:B){
            gr.get(e.get(0)).add(e.get(1));
        }
        LinkedList<Integer> q=new LinkedList<>();
        q.add(1);
        while(q.size()>0){
            int fr=q.remove();
            if(vis[fr]){
                continue;
            }
            vis[fr]=true;
            if(fr==A){
                return 1;
            }
            for(int i=0;i<gr.get(fr).size();i++){
                if(!vis[gr.get(fr).get(i)]){
                    q.addLast(gr.get(fr).get(i));
                }
            }
        }
        return 0;
    }
}
