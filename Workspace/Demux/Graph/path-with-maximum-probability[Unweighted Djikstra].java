class Solution {
     
    class Node implements Comparable<Node>{
        int vtx;
        double prob;
        Node(int iv,double ip){
            this.vtx=iv;
            this.prob=ip;
        }
        public int compareTo(Node o){
            // choose node with greater probability
            if(this.prob>o.prob){
                return -1;
            }else{
                return 1;
            }
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // using djikstra algorithm with a slight variation
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean[] vis=new boolean[n];
        pq.add(new Node(start,1));
        while(pq.size()>0){
            Node fr=pq.remove();
            // System.out.println(fr.vtx);
            if(vis[fr.vtx]){
                continue;
            }else{
                vis[fr.vtx]=true;
            }
            if(fr.vtx==end){
                return fr.prob;
            }
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==fr.vtx && !vis[edges[i][1]]){
                    // System.out.println(edges[i][0]+" "+edges[i][1]+" "+fr.prob*succProb[i]);
                    pq.add(new Node(edges[i][1],fr.prob*succProb[i]));
                }else if(edges[i][1]==fr.vtx && !vis[edges[i][0]]){
                    pq.add(new Node(edges[i][0],fr.prob*succProb[i]));
                }
            }
        }
        return 0;
    }
}