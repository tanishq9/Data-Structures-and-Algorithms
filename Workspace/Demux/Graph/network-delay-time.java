class Solution {
    class dj implements Comparable<dj>{
        int u;
        int wt;
        dj(int iu,int iw){
            this.u=iu;
            this.wt=iw;
        }
        public int compareTo(dj o){
            return this.wt-o.wt;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        // using BFS approach to find network delay -> Won't work
        // Plain BFS won't give correct answer, so use Djikstra
        boolean[] vis=new boolean[N+1];
        PriorityQueue<dj> pq=new PriorityQueue<>();
        int max=0;
        // pair of current node and time taken to reach it
        pq.add(new dj(K,0));
        while(pq.size()>0){
            dj fr=pq.remove();
            int currentNode=fr.u;
            int distanceTillNow=fr.wt;
            if(vis[currentNode]){
                continue;
            }else{
                vis[currentNode]=true;
            }
            // System.out.println(fr[0]);
            max=Math.max(max,distanceTillNow);
            for(int i=0;i<times.length;i++){
                if(times[i][0]==currentNode && !vis[times[i][1]]){
                    // System.out.println(times[i][0]+" "+times[i][1]);
                    pq.add(new dj(times[i][1],distanceTillNow+times[i][2]));
                }
            }
        }
        
        // if any of the node is not visited/reached then message won't ever reach
        for(int i=1;i<=N;i++){
            if(!vis[i]){
                return -1;
            }
        }
        return max;
    }
}