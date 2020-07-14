class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        // this sounds like an all pairs shortest path problem
        // lets use floyd warshall, which works in O(V^3)
        
        int[][] wts=new int[n][n];
        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int dist=edge[2];
            wts[from][to]=wts[to][from]=dist;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && wts[i][j]==0){
                    wts[i][j]=Integer.MAX_VALUE;
                }
            }
        } 
        for(int in=0;in<n;in++){
            for(int src=0;src<n;src++){
                for(int dest=0;dest<n;dest++){
                    if(in!=src && in!=dest && wts[src][in]!=Integer.MAX_VALUE && wts[in][dest]!=Integer.MAX_VALUE){
                        if(wts[src][in]+wts[in][dest]<wts[src][dest]){
                            wts[src][dest]=wts[src][in]+wts[in][dest];
                        }
                    }
                }
            }
        }
        /*for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(wts[i][j]+" ");
            }
            System.out.println();
        }*/
        int min=Integer.MAX_VALUE,result=0;
        for(int i=0;i<n;i++){
            int canVisit=0;
            for(int j=0;j<n;j++){
                if(wts[i][j]>0 && wts[i][j]<=distanceThreshold){
                    canVisit++;
                }
            }
            // System.out.println(canVisit);
            if(canVisit<=min){
                min=canVisit;
                result=i;
            }
        }
        return result;
    }
}