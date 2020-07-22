public class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int wt;
        
        Pair(int iv,int iw){
            this.val=iv;
            this.wt=iw;
        }
        
        public int compareTo(Pair other){
            return this.wt-other.wt;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // store in adjacency list
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<=A;i++){
            list.add(new ArrayList<int[]>());
        }
        for(int i=0;i<B.size();i++){
            int x=B.get(i).get(0);
            int y=B.get(i).get(1);
            int w=B.get(i).get(2);
            list.get(x).add(new int[]{y,w});
            list.get(y).add(new int[]{x,w});
        }
         // find MST using Prims
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean[] vis=new boolean[A+1];
        int sum=0;
        pq.add(new Pair(1,0));
        while(pq.size()>0){
            Pair fr=pq.remove();
            // stop when we have processes n-1 edges
            if(vis[fr.val]){
                continue;
            }else{
                vis[fr.val]=true;
            }
            sum+=fr.wt;
            // add the neigbor
            for(int i=0;i<list.get(fr.val).size();i++){
                int[] ng=list.get(fr.val).get(i);
                int ngval=ng[0];
                int wt=ng[1];
                if(!vis[ngval]){
                    pq.add(new Pair(ngval,wt));
                }
            }
        }
        return sum;
    }
}
