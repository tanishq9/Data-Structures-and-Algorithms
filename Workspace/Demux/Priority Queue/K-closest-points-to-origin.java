class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] p1,int[] p2){
                return (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]);
            }
        });
        // nlogk
        for(int[] point:points){
            if(pq.size()==K){
                int[] peek=pq.peek();
                if((point[0]*point[0] + point[1]*point[1]) < (peek[0]*peek[0] + peek[1]*peek[1])){
                    pq.remove();
                    pq.add(point);
                }
            }else{
                pq.add(point);
            }
        }
        int index=0;
        int[][] res=new int[K][2];
        while(K-->0){
            res[index][0]=pq.peek()[0];
            res[index++][1]=pq.remove()[1];
        }
        return res;
    }
    // (n+k)logn
    // nlogk
}