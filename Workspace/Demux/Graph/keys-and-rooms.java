class Solution {
    void dfs(List<List<Integer>> rooms,int src,boolean[] vis){
        vis[src]=true;
        for(int i=0;i<rooms.get(src).size();i++){
            int ngr=rooms.get(src).get(i);
            if(!vis[ngr]){
                dfs(rooms,ngr,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // basically check if graph has single connected
        // as only then we will be able to entry or exit every room
        boolean[] vis=new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(int i=0;i<rooms.size();i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}