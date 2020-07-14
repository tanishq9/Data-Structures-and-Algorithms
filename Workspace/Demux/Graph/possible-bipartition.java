class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color=new int[N+1];
        Arrays.fill(color,-1);
        // check for every component
        for(int i=1;i<=N;i++){
            if(color[i]==-1){
                if(!helper(dislikes,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean helper(int[][] dislikes,int[] color,int src){
        LinkedList<Integer> q=new LinkedList<>();
        q.add(src);
        color[src]=1;
        while(q.size()>0){
            int fr=q.removeFirst();
            for(int i=0;i<dislikes.length;i++){
                if(dislikes[i][0]==fr){
                    int ngr=dislikes[i][1];
                    if(color[ngr]==-1){
                        color[ngr]=1-color[fr];
                        q.addLast(ngr);
                    }else if(color[fr]==color[ngr]){
                        return false;
                    }
                }else if(dislikes[i][1]==fr){
                    int ngr=dislikes[i][0];
                    if(color[ngr]==-1){
                        color[ngr]=1-color[fr];
                        q.addLast(ngr);
                    }else if(color[fr]==color[ngr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}