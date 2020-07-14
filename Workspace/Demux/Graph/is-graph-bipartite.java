class Solution {
    public boolean isBipartite(int[][] graph) {
        LinkedList<Integer> q=new LinkedList<>();
        int[] color=new int[10000];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            // checking for each component
            if(graph[i].length>0 && color[i]==-1){
                color[i]=1;
                q.add(i);
                while(q.size()>0){
                    int fr=q.removeFirst();
                    for(int j=0;j<graph[fr].length;j++){
                        int ngr=graph[fr][j];
                        if(color[ngr]==-1){
                            color[ngr]=1-color[fr];
                            q.addLast(ngr);
                        }else if(color[ngr]!=-1 && color[ngr]==color[fr]){
                            return false;
                        }
                    }
                }
            }
        }        
        return true;
    }
}