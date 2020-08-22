public class Solution {
    int ans;
    private int dfs(int u,ArrayList<Integer> G[],int p){
        // vis[u]=true;
        int s=1;
        for(int i=0;i<G[u].size();i++){
            int v=G[u].get(i);
            if(v!=p){
                int k=dfs(v,G,u);
                if(k%2==0)
                    ans++;
                else
                    s+=k;
            }
        }
        return s;
    }
    public int solve(int n, int[][] B) {
        ans=0;
        ArrayList<Integer> G[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            G[i]=new ArrayList<>();
        for(int i=0;i<B.length;i++){
            G[B[i][0]-1].add(B[i][1]-1);
            G[B[i][1]-1].add(B[i][0]-1);
        }
        boolean vis[]=new boolean[n];
        dfs(0,G,-1);
        return ans;
    }
}
