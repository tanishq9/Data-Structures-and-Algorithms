class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Creating Graph
        ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            gr.add(new ArrayList<>());
        }
        for(int[] connection:connections){
            int u=connection[0];
            int v=connection[1];
            gr.get(u).add(v);
            gr.get(v).add(u);
        }
        // Calculate size of each component
        ArrayList<Integer> sizes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int csize=dfs(i,gr,visited);
                sizes.add(csize);
            }
        }
        if(sizes.size()==1){
            return 0;
        }
        int minEdgesNeeded=0;
        for(int i=0;i<sizes.size();i++){
            minEdgesNeeded+=sizes.get(i)-1;
        }
        int edgesExtra=connections.length-minEdgesNeeded;
        int computersDisconnected=sizes.size()-1;
        if(edgesExtra>=computersDisconnected){
            return computersDisconnected;
        }
        return -1;
    }
    
    int dfs(int current,ArrayList<ArrayList<Integer>> gr,boolean[] visited){
        visited[current]=true;
        int size=1;
        for(int i=0;i<gr.get(current).size();i++){
            int ngr=gr.get(current).get(i);
            if(!visited[ngr]){
                size+=dfs(ngr,gr,visited);   
            }
        }
        return size;
    }
    
    
}